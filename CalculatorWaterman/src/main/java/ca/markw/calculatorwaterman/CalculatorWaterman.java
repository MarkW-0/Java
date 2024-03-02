/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.calculatorwaterman;

import java.util.Scanner;
import java.util.TreeMap;
/**
 *
 * @author Mark
 */
public final class CalculatorWaterman {
	public final TreeMap<Character, TokenClass> Tokens = new TreeMap<>();
	public final TokenClass DefaultToken = new TokenClass();
	{
		Tokens.put('0', new TokenClass(1,00, new char[]{'0'}, new int[]{}));
		Tokens.put('1', new TokenClass(1,00, new char[]{'1'}, new int[]{}));
		Tokens.put('2', new TokenClass(1,00, new char[]{'2'}, new int[]{}));
		Tokens.put('3', new TokenClass(1,00, new char[]{'3'}, new int[]{}));
		Tokens.put('4', new TokenClass(1,00, new char[]{'4'}, new int[]{}));
		Tokens.put('5', new TokenClass(1,00, new char[]{'5'}, new int[]{}));
		Tokens.put('6', new TokenClass(1,00, new char[]{'6'}, new int[]{}));
		Tokens.put('7', new TokenClass(1,00, new char[]{'7'}, new int[]{}));
		Tokens.put('8', new TokenClass(1,00, new char[]{'8'}, new int[]{}));
		Tokens.put('9', new TokenClass(1,00, new char[]{'9'}, new int[]{}));
		Tokens.put('(', new TokenClass(1,00, new char[]{'(', 0, ')'}, new int[]{0}));
		Tokens.put('+', new TokenClass(2,10, new char[]{0, '+', 0}, new int[]{10}));
		Tokens.put('-', new TokenClass(2,10, new char[]{0, '-', 0}, new int[]{10}));
		Tokens.put('*', new TokenClass(2,20, new char[]{0, '*', 0}, new int[]{20}));
		Tokens.put('/', new TokenClass(2,20, new char[]{0, '/', 0}, new int[]{20}));
		Tokens.put('%', new TokenClass(2,20, new char[]{0, '%', 0}, new int[]{20}));
		Tokens.put('^', new TokenClass(2,30, new char[]{0, '^', 0}, new int[]{29}));
	}
	public static class TokenClass {
		private final int Precedence;
		private final char[] Pattern;
		private final int[] Precedences;
		final int Flags;
		public class Token {
			public final char Char;
			public int GetPrecedence(){
				return Precedence;
			};
			public Token(char Char) {
				this.Char = Char;
			}
			public Node Parse(TokenStream TokenStream){
				if (TokenClass.this.Flags == 1){
					if(this.Char == '('){
						Node Node = TokenStream.Parse(0);
						if(TokenStream.next().Char != ')'){
							System.err.println("expected close parenthesis");
						}
						return Node;
					} else {
						String string = "" + this.Char;
						while ("0123456789.".contains("" + TokenStream.Peek.Char)){
							string += TokenStream.next().Char;
						}
						return new Node(Double.parseDouble(string));
					}
				}
				throw new UnsupportedOperationException("Initial Parse of '" + Char + "' " + (int)Char);
			};
			public Node Parse(Node Left, TokenStream TokenStream){
				if (TokenClass.this.Flags == 2){
					return new Node(Char, new Node[]{Left,TokenStream.Parse(TokenClass.this.Precedences[0])});
				}
				throw new UnsupportedOperationException("Subsequent Parse of '" + Char + "' " + (int)Char);
			};
		}
		public TokenClass(){
			this.Precedence = 0;
			this.Pattern = null;
			this.Precedences = null;
			this.Flags = 0;
		}
		public TokenClass(int Precedence, char[] Pattern, int[] Precedences) {
			this.Precedence = Precedence;
			this.Pattern = Pattern;
			this.Precedences = Precedences;
			this.Flags = 0;
			throw new RuntimeException("Must use Flags");
		}
		public TokenClass(int Flags, int Precedence, char[] Pattern, int[] Precedences) {
			this.Precedence = Precedence;
			this.Pattern = Pattern;
			this.Precedences = Precedences;
			//System.err.println("Warning using Flags");
			this.Flags = Flags;
		}
	}
	public final class TokenStream {
		TokenClass.Token Last;
		public TokenClass.Token Peek;
		private final String Input;
		private int Position;
		public TokenStream(String Input) {
			this.Input = Input;
			this.Position = 0;
			this.next();
		}
		public TokenClass.Token next() {
			this.Last = this.Peek;
			if (Position < Input.length()){
				char Char = Input.charAt(Position);
				TokenClass Class = Tokens.getOrDefault(Char, DefaultToken);
				this.Peek = Class.new Token(Char);
			} else {
				this.Peek = DefaultToken.new Token('\0');
			}
			Position++;
			return this.Last;
		}
		public Node Parse(int Precedence) {
			Node Left = this.next().Parse(this);
			/*Implementation note
			To parse (2+x)*x^2 - x, with "*" precedence
			parse (2+x) with ParseParen
			"*" precedence is less then "*" precedence
			so parse x^2 with ParseBinary("*")
			"*" precedence is Not less then "-" precedence
			so return (2+x)*x^2 to caller (parse (2+x)*x^2 - x with less precedence)
			*/
			while(Precedence < this.Peek.GetPrecedence()){
				Left = this.next().Parse(Left, this);
			}
			return Left;
		}

	}
	public static class Node {
		public final boolean Leaf;
		public final char Char;
		public final double Value;
		public final Node[] Nodes;
		public Node(double Value) {
			this.Leaf = true;
			this.Value = Value;
			this.Nodes = null;
			this.Char = 0;
		}
		public Node(char Char, Node[] Nodes) {
			this.Leaf = false;
			this.Value = 0;
			this.Nodes = Nodes;
			this.Char = Char;
			
		}
		public double Evaluate(){
			return
				this.Leaf ? this.Value :
				Char == '+' ? this.Nodes[0].Evaluate() + this.Nodes[1].Evaluate() :
				Char == '-' ? this.Nodes[0].Evaluate() - this.Nodes[1].Evaluate() :
				Char == '*' ? this.Nodes[0].Evaluate() * this.Nodes[1].Evaluate() :
				Char == '/' ? this.Nodes[0].Evaluate() / this.Nodes[1].Evaluate() :
				Char == '%' ? this.Nodes[0].Evaluate() % this.Nodes[1].Evaluate() :
				Char == '^' ? Math.pow(this.Nodes[0].Evaluate(), this.Nodes[1].Evaluate()) :
				Double.NaN;//errors are NaNs
		};
	}
	/* main
		This method is the main method.
		What did you expect?
	*/
	public static void main(String[] args) {
		new CalculatorWaterman().main();//not static
	}
	public void main() {
		final Scanner InputScanner = new Scanner(System.in);
		String Line;
		Node Tree;
		CalculatorWaterman.TokenStream TokenStream;
		System.out.println("Smart Calculator");
		System.out.println("This calculator uses operator precedence");
		System.out.println("Sqrt(x) is x ^ 0.5, 1/x is x ^ -1, x mod y is x % y.");
		System.out.println("Type quit to exit.");
		System.out.println("+ - * / % ^ + - * / % ^ + - * / % ^ + - * / % ^ + - * / % ^");
		while (true) {
			Line = InputScanner.nextLine();
			TokenStream = new TokenStream(Line.replaceAll(" ", ""));//1 + (2 + 3) / 4
			if (Line.contains("quit")) {
				break;
			} else {
				Tree = TokenStream.Parse(0);
		//		System.out.println(Tree);
				System.out.println(Tree.Evaluate());
			}
		}
	}
}