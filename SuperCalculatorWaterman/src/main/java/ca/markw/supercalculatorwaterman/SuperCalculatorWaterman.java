/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.supercalculatorwaterman;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Mark
 */
final class SuperCalculatorWaterman {
	final class MoreMath{//Math doesn't have them
		static double acosh(double x){
			return Math.log(x + Math.sqrt(x * x - 1));
		}
		static double asinh(double x){
			return Math.log(x + Math.sqrt(x * x + 1));
		}
		static double atanh(double x){
			return 0.5 * Math.log((1 + x) / (1 - x));
		}
	};
	final TreeMap<Character, TokenClass> Tokens = new TreeMap<>();
	final TokenClass DefaultToken = new TokenClass();
	{
		new TokenClass('0', 00, new char[]{'0'}, new int[]{});
		new TokenClass('1', 00, new char[]{'1'}, new int[]{});
		new TokenClass('2', 00, new char[]{'2'}, new int[]{});
		new TokenClass('3', 00, new char[]{'3'}, new int[]{});
		new TokenClass('4', 00, new char[]{'4'}, new int[]{});
		new TokenClass('5', 00, new char[]{'5'}, new int[]{});
		new TokenClass('6', 00, new char[]{'6'}, new int[]{});
		new TokenClass('7', 00, new char[]{'7'}, new int[]{});
		new TokenClass('8', 00, new char[]{'8'}, new int[]{});
		new TokenClass('9', 00, new char[]{'9'}, new int[]{});
		new TokenClass('p', 00, new char[]{'p'}, new int[]{});
		new TokenClass('e', 00, new char[]{'e'}, new int[]{});
		new TokenClass('(', 00, new char[]{'(', 0, ')'}, new int[]{0});
		new TokenClass('+', 10, new char[]{0, '+', 0}, new int[]{10});
		new TokenClass('-', 10, new char[]{0, '-', 0}, new int[]{10});
		new TokenClass('h', 12, new char[]{'h', 0}, new int[]{11});
		new TokenClass('c', 14, new char[]{'c', 'o', 's', 0}, new int[]{13});
		new TokenClass('s', 14, new char[]{'s', 'i', 'n', 0}, new int[]{13});
		new TokenClass('t', 14, new char[]{'t', 'a', 'n', 0}, new int[]{13});
		new TokenClass('a', 16, new char[]{'a', 0}, new int[]{15});
		new TokenClass('l', 16, new char[]{'l', 'o', 'g', 0}, new int[]{11});
		new TokenClass('*', 20, new char[]{0, '*', 0}, new int[]{20});
		new TokenClass('/', 20, new char[]{0, '/', 0}, new int[]{20});
		new TokenClass('%', 20, new char[]{0, '%', 0}, new int[]{20});
		new TokenClass('^', 30, new char[]{0, '^', 0}, new int[]{29});
	}
	final class TokenClass {
		final int Precedence;
		final char[] Pattern;
		final int[] Precedences;
		class Token {
			final char Char;
			int GetPrecedence(){
				return Precedence;
			};
			Token(char Char) {
				this.Char = Char;
			}
			Node Parse(TokenStream TokenStream){
				if(this.Char == '('){
					Node Node = TokenStream.Parse(TokenClass.this.Precedences[0]);
					if(TokenStream.next().Char != ')'){
						System.err.println("expected close parenthesis");
					}
					return new Node('(', new Node[]{Node});
				} else if ("0123456789.".contains("" + this.Char)) {//numbers
					String string = "" + this.Char;
					while ("0123456789.".contains("" + TokenStream.Peek.Char)){
						string += TokenStream.next().Char;
					}
					return new Node(Double.parseDouble(string));
				} else if (this.Char == 'p') {//pi Archimedes's constant
					if(TokenStream.next().Char != 'i'){
						System.err.println("expected pi");
					}
					return new Node('p', null);
				} else if (this.Char == 'e') {//e Euler's number
					return new Node('e', null);
				} else if (this.Char == 'c') {//cos
					if(TokenStream.next().Char != 'o' ||
						TokenStream.next().Char != 's'){
						System.err.println("expected cos");
					}
					return new Node('c', new Node[]{TokenStream.Parse(TokenClass.this.Precedences[0])});
				} else if (this.Char == 's') {//sin
					if(TokenStream.next().Char != 'i' ||
						TokenStream.next().Char != 'n'){
						System.err.println("expected sin");
					}
					return new Node('s', new Node[]{TokenStream.Parse(TokenClass.this.Precedences[0])});
				} else if (this.Char == 't') {//tan
					if(TokenStream.next().Char != 'a' ||
						TokenStream.next().Char != 'n'){
						System.err.println("expected tan");
					}
					return new Node('t', new Node[]{TokenStream.Parse(TokenClass.this.Precedences[0])});
				} else if (this.Char == 'h') {//hyperbolic trig
					return new Node('h', new Node[]{TokenStream.Parse(TokenClass.this.Precedences[0])});
				} else if (this.Char == 'a') {//inverse trig
					return new Node('a', new Node[]{TokenStream.Parse(TokenClass.this.Precedences[0])});
				} else if (this.Char == 'l') {//log
					if(TokenStream.next().Char != 'o' ||
						TokenStream.next().Char != 'g'){
						System.err.println("expected log");
					}
					return new Node('l', new Node[]{TokenStream.Parse(TokenClass.this.Precedences[0])});
				} else {
					throw new UnsupportedOperationException("Initial Parse of '" + Char + "' " + (int)Char);
				}
			};
			Node Parse(Node Left, TokenStream TokenStream){
				if (Pattern[0] == 0){
					return new Node(Char, new Node[]{Left,TokenStream.Parse(TokenClass.this.Precedences[0])});
				}
				throw new UnsupportedOperationException("Subsequent Parse of '" + Char + "' " + (int)Char);
			};
		}
		TokenClass(){
			this.Precedence = 0;
			this.Pattern = new char[0];
			this.Precedences = new int[0];
		}
		TokenClass(char Char, int Precedence, char[] Pattern, int[] Precedences) {
			this.Precedence = Precedence;
			this.Pattern = Pattern;
			this.Precedences = Precedences;
			Tokens.put(Char, this);
		}
	};
	final class TokenStream {
		TokenClass.Token Last;
		TokenClass.Token Peek;
		final String Input;
		int Position;
		TokenStream(String Input) {
			this.Input = Input;
			this.Position = 0;
			this.next();
		}
		TokenClass.Token next() {//step to next token
			this.Last = this.Peek;
			if (Position < Input.length()){
				char Char;
				do {
					Char = Input.charAt(Position);
					Position++;
				} while (Char == ' ');
				TokenClass Class = Tokens.getOrDefault(Char, DefaultToken);
				this.Peek = Class.new Token(Char);
			} else {
				this.Peek = DefaultToken.new Token('\0');
			}
			return this.Last;
		}
		Node Parse(int Precedence) {
			Node Left = this.next().Parse(this);
			/*Pratt parser Implementation https://en.wikipedia.org/wiki/Operator-precedence_parser#Pratt_parsing
			To parse (2+x)^2 - x, with "*" precedence
			parse (2+x) with ParseParen
			"*" precedence is less then "*" precedence
			so parse (2+x)^2 with ParseBinary("^")
			"*" precedence is Not less then "-" precedence
			so return (2+x)*x^2 to caller 
			(parse (2+x)*x^2 - x with less precedence)
			*/
			while(Precedence < this.Peek.GetPrecedence()){
				Left = this.next().Parse(Left, this);
			}
			return Left;
		}
	};
	final class Node {
		boolean Leaf;
		char Char;
		double Value;
		Node[] Nodes;
		int Width;
		int Height;
		Node(double Value) {
			this.Leaf = true;
			this.Value = Value;
			this.Nodes = null;
			this.Char = '0';
		};
		Node(char Char, Node[] Nodes) {
			this.Leaf = (Char == 'p' || Char == 'e');
			this.Nodes = Nodes;
			this.Char = Char;
			this.Value = //evaluate
				Char == 'p' ? Math.PI : Char == 'e' ? Math.E :
				Char == '+' ? this.Nodes[0].Value + this.Nodes[1].Value :
				Char == '-' ? this.Nodes[0].Value - this.Nodes[1].Value :
				Char == '*' ? this.Nodes[0].Value * this.Nodes[1].Value :
				Char == '/' ? this.Nodes[0].Value / this.Nodes[1].Value :
				Char == '%' ? this.Nodes[0].Value % this.Nodes[1].Value :
				Char == '^' ? Math.pow(this.Nodes[0].Value, this.Nodes[1].Value) :
				Char == '=' ? this.Nodes[0].Value == this.Nodes[1].Value ? 1 : 0 :
				Char == '(' ? this.Nodes[0].Value :
				Char == 'a' ? //ask child for input
					this.Nodes[0].Char == 'c' ? this.Nodes[0].Nodes[0].Char == 'h' ?
						MoreMath.acosh(this.Nodes[0].Nodes[0].Nodes[0].Value):
						Math.acos(this.Nodes[0].Nodes[0].Value):
					this.Nodes[0].Char == 's' ? this.Nodes[0].Nodes[0].Char == 'h' ?
						MoreMath.asinh(this.Nodes[0].Nodes[0].Nodes[0].Value):
						Math.asin(this.Nodes[0].Nodes[0].Value):
					this.Nodes[0].Char == 't' ? this.Nodes[0].Nodes[0].Char == 'h' ?
						MoreMath.atanh(this.Nodes[0].Nodes[0].Nodes[0].Value):
						Math.atan(this.Nodes[0].Nodes[0].Value):// atan2?
					Double.NaN :
				Char == 'c' ?this.Nodes[0].Char == 'h' ?
					Math.cosh(this.Nodes[0].Nodes[0].Value) :
					Math.cos(this.Nodes[0].Value) :
				Char == 's' ? this.Nodes[0].Char == 'h' ?
					Math.sinh(this.Nodes[0].Nodes[0].Value) :
					Math.sin(this.Nodes[0].Value) :
				Char == 't' ? this.Nodes[0].Char == 'h' ?
					Math.tanh(this.Nodes[0].Nodes[0].Value) :
					Math.tan(this.Nodes[0].Value) :
				Char == 'h' ? Double.NaN ://parent node will not read this
				Char == 'l' ? Math.log(this.Nodes[0].Value) :
				Double.NaN;//errors are NaNs
		};
//<editor-fold>
		/*
			+--+
			|  |   +---+
			|  | # |   |
			|  |   +---+
			+--+
		
			+--+
			|  |     +---+
			|  | mod |   |
			|  |     +---+
			+--+
		
			 +-------+
			 |       |
			 +-------+
			===========
			   +---+
			   |   |
			   +---+
		
			+--+                +-+
			|  | +--+      +--+ | |
			|  | +--+  OR  |  | +-+
			|  |           +--+
			+--+
		*/
		//</editor-fold>
		void resize(Graphics2D g){
			FontMetrics metrics = g.getFontMetrics();
			if(Leaf){
				if (Char == 'p') {
					Width = metrics.charWidth('π');// using Unicode U+03C0
				} else if (Char == 'e'){
					Width = metrics.charWidth('𝑒');// using Unicode U+1D452
				} else {
					Width = metrics.stringWidth(Double.toString(Value));
				}
				Width += 2;
				Height = metrics.getMaxAscent() + metrics.getMaxDescent();
			} else {
				Nodes[0].resize(g);
				if ("(acsthl".contains("" + this.Char)) {
					this.Height = Nodes[0].Height;
					this.Width = Nodes[0].Width;
					switch (Char) {
						case '(' -> {
							this.Width += 4 + metrics.charWidth('(') + metrics.charWidth(')');
							this.Height += 4;
						}
						case 'a' -> {
							this.Width += metrics.stringWidth("arc");
						}
						case 'c' -> {
							this.Width += 2 + metrics.stringWidth("cos");
						}
						case 's' -> {
							this.Width += 2 + metrics.stringWidth("sin");
						}
						case 't' -> {
							this.Width += 2 + metrics.stringWidth("tan");
						}
						case 'h' -> {
							this.Width += 2 + metrics.charWidth('h');
						}
						case 'l' -> {
							this.Width += 2 + metrics.stringWidth("log");
						}
					}
				} else {
					Nodes[1].resize(g);
					switch (Char) {
						case '+', '-', '*' , '=' -> {
							this.Width = Nodes[0].Width + metrics.stringWidth(" " + Char + " ") + Nodes[1].Width;
							this.Height = Math.max(Nodes[0].Height,Nodes[1].Height);
						}
						case '/' -> {
							this.Width = 2 + Math.max(Nodes[0].Width,Nodes[1].Width);
							this.Height = Nodes[0].Height + 5 + Nodes[1].Height;
						}
						case '%' -> {
							this.Width = Nodes[0].Width + metrics.stringWidth(" mod ") + Nodes[1].Width;
							this.Height = Math.max(Nodes[0].Height,Nodes[1].Height);
						}
						case '^' -> {
							this.Width = Nodes[0].Width + Nodes[1].Width;
							this.Height = Math.max(Nodes[0].Height, Nodes[0].Height/2 + Nodes[1].Height);
						}
					}
				}
			}
		};
		void paint(Graphics2D g){
			if (g.getClipBounds().isEmpty()) {
				return;
			}
			FontMetrics metrics = g.getFontMetrics();
			if(this.Leaf){
				if (Char == 'p') {
					Width = metrics.charWidth('π');
					g.drawString("π", 1, metrics.getMaxAscent());
				} else if (Char == 'e'){
					g.drawString("𝑒", 1, metrics.getMaxAscent());
				} else {
					g.drawString(Double.toString(Value), 1, metrics.getMaxAscent());
				}
			} else {
				Graphics2D g2 = (Graphics2D) g.create(0, 0, Width, Height);
				switch (Char) {
					case '(' -> {
						g2.translate(2 + metrics.charWidth('('), 2);
						g.scale(1.0, ((double) Height)/(metrics.getMaxAscent() + metrics.getMaxDescent()));
						g.drawString("(", 1, metrics.getMaxAscent());
						Nodes[0].paint(g2);
						g.drawString(")", 3 + metrics.charWidth('(') + Nodes[0].Width, metrics.getMaxAscent());
					}
					case 'a' -> {
						g2.translate(metrics.stringWidth("arc"), (Height - Nodes[0].Height)/2);
						Nodes[0].paint(g2);
						g.drawString("arc", 1, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
					}
					case 'c' -> {
						g2.translate(2 + metrics.stringWidth("cos"), (Height - Nodes[0].Height)/2);
						Nodes[0].paint(g2);
						g.drawString("cos", 1, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
					}
					case 's' -> {
						g2.translate(2 + metrics.stringWidth("sin"), (Height - Nodes[0].Height)/2);
						Nodes[0].paint(g2);
						g.drawString("sin", 1, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
					}
					case 't' -> {
						g2.translate(2 + metrics.stringWidth("tan"), (Height - Nodes[0].Height)/2);
						Nodes[0].paint(g2);
						g.drawString("tan", 1, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
					}
					case 'h' -> {
						g2.translate(metrics.charWidth('h'), (Height - Nodes[0].Height)/2);
						Nodes[0].paint(g2);
						g.drawString("h", -1, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
					}
					case 'l' -> {
						g2.translate(2 + metrics.stringWidth("log"), (Height - Nodes[0].Height)/2);
						Nodes[0].paint(g2);
						g.drawString("log", 1, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
					}
					case '+', '-', '*', '=' -> {
						Nodes[0].paint((Graphics2D) g.create(0, (Height - Nodes[0].Height)/2, Nodes[0].Width, Nodes[0].Height));
						g.drawString(" " + Char + " ", Nodes[0].Width, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
						Nodes[1].paint((Graphics2D) g.create(Nodes[0].Width + metrics.stringWidth(" " + Char + " "), (Height - Nodes[1].Height)/2, Nodes[1].Width, Nodes[1].Height));
					}
					case '/' -> {
						Nodes[0].paint((Graphics2D) g.create((Width - Nodes[0].Width)/2, 0, Nodes[0].Width, Nodes[0].Height));
						g.drawLine(1, 3 + Nodes[0].Height, Width-1, 3 + Nodes[0].Height);
						Nodes[1].paint((Graphics2D) g.create((Width - Nodes[1].Width)/2, Nodes[0].Height + 5, Nodes[1].Width, Nodes[1].Height));
					}
					case '%' -> {
						Nodes[0].paint((Graphics2D) g.create(0, (Height - Nodes[0].Height)/2, Nodes[0].Width, Nodes[0].Height));
						g.drawString(" mod ", Nodes[0].Width, (Height + metrics.getMaxAscent() - metrics.getMaxDescent())/2);
						Nodes[1].paint((Graphics2D) g.create(Nodes[0].Width + metrics.stringWidth(" mod "), (Height - Nodes[1].Height)/2, Nodes[1].Width, Nodes[1].Height));
					}
					case '^' -> {
						Nodes[0].paint((Graphics2D) g.create(0, Height - Nodes[0].Height, Nodes[0].Width, Nodes[0].Height));
						Nodes[1].paint((Graphics2D) g.create(Nodes[0].Width, Math.max(0, Nodes[0].Height / 2 - Nodes[1].Height), Nodes[1].Width, Nodes[1].Height));
					}
				}
			}
		};
	};
	final class GUI extends JFrame {
		static final long serialVersionUID = 1L;
		final JLabel GUI_TITLE = new JLabel("Super Smart Calculator",SwingConstants.CENTER);
		final JLabel GUI_TXET = new JLabel(
			"<html>"+
				"This calculator uses operator precedence.<br>"+
				"x mod y is x % y.<br>"+
				"Inverse trig functions are prefixed with “a”.<br>"+
				"Inverse hyperbolic sine is “asinh”."+
			"</html>");
		final JTextField GUI_INPUT = new JTextField("1+asinh(2-e^pi)/4");
		final Display GUI_DISPLAY = new Display("1+asinh(2-e^pi)/4");
		GUI() {
			super();
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setTitle("Super Smart Calculator");
			setLayout(new GridBagLayout());
			GridBagConstraints layout = new GridBagConstraints();
			layout.insets = new Insets(5, 5, 5, 5);
			layout.gridx = 0; layout.gridy = 0;
			layout.weightx = 1.0;
			layout.fill = GridBagConstraints.BOTH;
			GUI_TITLE.setFont(new java.awt.Font("Segoe UI", 0, 48));
			add(GUI_TITLE, layout.clone());
			layout.gridy = 1;
			GUI_TXET.setFont(new java.awt.Font("Segoe UI", 0, 24));
			add(GUI_TXET, layout.clone());
			layout.gridy = 4;
			GUI_INPUT.setHorizontalAlignment(SwingConstants.CENTER);
			GUI_INPUT.setFont(GUI_TXET.getFont());
			GUI_INPUT.addActionListener((var evt) -> {
				GUI_DISPLAY.updateText(GUI_INPUT.getText());
			});
			add(GUI_INPUT, layout.clone());
			layout.gridy = 2;
			layout.weighty = 1.0;
			add(GUI_DISPLAY, layout.clone());
			pack();
		}
	}
	final class Display extends JPanel {
		static final long serialVersionUID = 2L;
		int Width = 0;
		int Height = 0;
		String Text = "";
		Node Root;
		Display(String Text) {
			super();
			this.updateText(Text);
			this.addComponentListener(new ComponentAdapter() {
				public void componentResized(ComponentEvent evt) {
					Display.this.updateSize();
					Display.this.repaint();
				}
			});
		}
		public Dimension getPreferredSize() {
			return new Dimension(400, 300);//set the default size
		}
		void updateSize() {
			this.Width = getWidth(); this.Height = getHeight();
		}
		void updateText(String Text) {
			if (!this.Text.equals(Text) ){
				this.Text = Text;
				Root = new TokenStream(Text).Parse(0);
				Root = new Node('=',new Node[]{Root, new Node (Root.Value)});
				this.repaint();
			}
		}
		public void paintComponent(Graphics g0) {
			super.paintComponent(g0);
			Graphics2D g = (Graphics2D) g0.create();
			g.setStroke(new BasicStroke());
			g.setColor(getForeground());
			Root.resize(g);
			double scale;
			if((((double) Root.Width) / Root.Height) < (((double) Width) / Height)){
				//scale up
				scale = ((double) Height)/Root.Height;
				g.translate((Width - scale*Root.Width) / 2.0, 0);
				g.scale(scale, scale);
			} else {
				//scale right
				scale = ((double) Width)/Root.Width;
				g.translate(0, (Height - scale*Root.Height) / 2.0);
				g.scale(scale, scale);
			}
			Root.paint(g);
		}
	}
	/* main
		This method is the main method.
		What did you expect?
	*/
	public static void main(String[] args) {
		new SuperCalculatorWaterman().new GUI().setVisible(true);//not static
	}
}