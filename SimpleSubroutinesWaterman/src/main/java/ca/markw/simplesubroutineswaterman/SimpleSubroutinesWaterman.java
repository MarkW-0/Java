/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.markw.simplesubroutineswaterman;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class SimpleSubroutinesWaterman {

	private final static Scanner inputscanner = new Scanner(System.in);
	private static Scanner linescanner;
	private static String line;
	private static String op;
	private static double ans = 0;

	private static String calc() {
		while (linescanner.hasNext()) {
			if (linescanner.hasNextDouble()) {
				ans = linescanner.nextDouble();
			} else {
				op = linescanner.next().strip().trim();
				switch(op){
					case "+": {add();break;}
					case "-": {sub();break;}
					case "*": {mult();break;}
					case "/": {div();break;}
					//case "%": {System.out.print("%");break;}
					case "^": {pow();break;}
					default: {return op + " is not + - * / or ^ ";}
				}
			}
		}
		return "" + ans;
	}
	public static void add() {
		ans = ans + linescanner.nextDouble();
	}
	public static void sub() {
		ans = ans - linescanner.nextDouble();
	}
	public static void mult() {
		ans = ans * linescanner.nextDouble();
	}
	public static void div() {
		ans = ans / linescanner.nextDouble();
	}
	public static void pow() {
		ans = Math.pow(ans,linescanner.nextDouble());
	}
	public static void main(String[] args) {
		System.out.println("Simple Calculator");
		System.out.println();
		System.out.println("This calculator evaluates left to right Not ^ /* +-.");
		System.out.println("Sqrt(x) is x ^ 0.5, 1/x is x ^ -1.");
		System.out.println("Put whitespace characters between numbers and operators eg:");
		System.out.println("' + 2.4 / 4 ...'");
		System.out.println("Type q to quit.");
		System.out.println("+ - * / ^ + - * / ^ + - * / ^ + - * / ^ + - * / ^ + - * / ^");
		while (true) {
			line = inputscanner.nextLine();
			if (line.toLowerCase().strip().trim().contains("q")) {
				break;
			}
			linescanner = new Scanner(line);
			System.out.println(calc());
		}
	}
}
