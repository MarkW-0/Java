/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.moresubroutineswaterman;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Mark
 */
public class MoreSubroutinesWaterman {

	private final static String INTREGEX = "\\d+";
	private final static Pattern DOUBLEREGEX = Pattern.compile("[+-]?(NaN|Infinity|("+INTREGEX+")(\\.\\d*)?|\\.\\d+)");//++++
	private final static Pattern TOKENREGEX = Pattern.compile("[\\Q+-*/%^()\\E(" + DOUBLEREGEX.pattern() + ")]");//+++
	private static Scanner TokenStream;//last token
	private static String Last;//last token
	private static String Peek;//next token
	
	/* Consume
		This subroutine acts like TokenStream.next()
		but using Consume allows you to Peek at the next Token
		
		Returns: a "Token" String
	*/
	private static String Consume() {
		Last = Peek;
		Peek = TokenStream.hasNext()?TokenStream.next():"";
		return Last;
	}
	
	/* GetPrecedence
		This function receives an operator and returns its precedence.
		
		Parameters: a "Operator" String
		Returns: a "Precedence" int
	*/
	private static int GetPrecedence(String Op){
		return Op.equals("+") ? 9 :
				Op.equals("-")? 9 :
				Op.equals("*")? 19 :
				Op.equals("/")? 19 :
				Op.equals("%")? 19 :
				Op.equals("^")? 29 :
				Integer.MAX_VALUE;//an error has the highest precedence
	};
	
	/* main
		This method is the main method.
		What did you expect?
	*/
	public static void main(String[] args) {
		final Scanner InputScanner = new Scanner(System.in);
		String Tokens;
		System.out.println("Smart Calculator");
		System.out.println("This calculator uses operator precedence");
		System.out.println("Sqrt(x) is x ^ 0.5, 1/x is x ^ -1, x mod y is x % y.");
		System.out.println("Type quit to exit.");
		System.out.println("+ - * / % ^ + - * / % ^ + - * / % ^ + - * / % ^ + - * / % ^");
		while (true) {
			Tokens = Tokenize(InputScanner.nextLine());//1 + (2 + 3) / 4
			System.out.println(Tokens);
			if (Tokens.contains("quit")) {
				break;
			} else {
				TokenStream = new Scanner(Tokens);
				Consume();//cleenup
				System.out.println(Parse(0));
			}
		}
	}
	
	/* Tokenize +++ DOES NOT WORK +++
		This function receives an expression and returns its tokenized version.
		
		Parameters: a "Expression" String
		Returns: a "TokenizedExpression" String
	*/
	private static String Tokenize(String Arg) {
		Matcher Matcher = TOKENREGEX.matcher(Arg.toLowerCase().strip().trim());
		String Tokens = "";
		if (Matcher.find()){
			do {
				Tokens = Tokens.concat(" " + Matcher.group());
			} while (Matcher.find(Matcher.end()));
		}
		return Tokens;
	}
	
	/* Parse
		This method receives a Precedence.
		It evaluates TokenStream with the selected precedence,
		and returns the result.
		
		Parameters: a "Precedence" int
		Returns: a double
	*/
	private static double Parse(int Precedence) {
		double LeftNode;
		if (Consume().equals("(")){
			LeftNode = ParseParen();
		} else {//then a number
			LeftNode =  ParseNumber(Last);
		}
		/*Implementation note
		To parse (2+x)*x^2 - x, with "*" precedence
		parse (2+x) with ParseParen
		Start precedence is less then "*" precedence
		so parse x^2 with ParseBinary("*")
		Start precedence is Not less then "-" precedence
		so return (2+x)*x^2 to caller (parse (2+x)*x^2 - x)
		*/
		loop: while(!Peek.isEmpty() && Precedence < GetPrecedence(Peek)){
			switch(Consume()){
				case "+": {LeftNode = ParseBinary("+", true, LeftNode);break;}
				case "-": {LeftNode = ParseBinary("-", true, LeftNode);break;}
				case "*": {LeftNode = ParseBinary("*", true, LeftNode);break;}
				case "/": {LeftNode = ParseBinary("/", true, LeftNode);break;}
				case "%": {LeftNode = ParseBinary("%", true, LeftNode);break;}
				case "^": {LeftNode = ParseBinary("^", false, LeftNode);break;}
				default: {break loop;}
			}
		}
		return LeftNode;
	}
	
	/* ParseParen
		This method evaluates TokenStream and returns the result.
		
		Returns: a double
	*/
	private static double ParseParen() {
		double Node = Parse(0);
		Consume();//should be ")"
		return Node;
	}
	
	/* ParseNumber
		This function receives a NumberToken and returns its value.
		
		Parameters: a "NumberToken" String
		Returns: a double
	*/
	private static double ParseNumber(String Token) {
		return Double.parseDouble(Token);
	}
	
	/* ParseBinary
		This method receives a Operator, a boolean and a double.
		It evaluates TokenStream for a second double,
		It Evaluates the Operator with the doubles,
		and returns the Operator's result.
		
		Returns: a double
	*/
	private static double ParseBinary(String Op, boolean LeftAssociative, double LeftNode) {
		return Evaluate(Op, LeftNode,Parse(
			GetPrecedence(Op) - (LeftAssociative ? 0 : 1)
		));//Decrement right associative operators precedence
	}
	
	/* Evaluate
		This function receives a Operator and two doubles,
		It Evaluates the Operator with the doubles, and returns the result.
		
		Parameters: a "Operator" String, and two doubles
		Returns: a double
	*/
	private static double Evaluate(String Op, double LeftNode, double RightNode) {
		return Op.equals("+") ? LeftNode + RightNode :
				Op.equals("-")? LeftNode - RightNode :
				Op.equals("*")? LeftNode * RightNode :
				Op.equals("/")? LeftNode / RightNode :
				Op.equals("%")? LeftNode % RightNode :
				Op.equals("^")? Math.pow(LeftNode, RightNode) :
				Double.NaN;//errors are NaNs
	}
}
