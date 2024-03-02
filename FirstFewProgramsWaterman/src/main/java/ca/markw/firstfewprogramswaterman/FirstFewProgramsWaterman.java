/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.firstfewprogramswaterman;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class FirstFewProgramsWaterman {
	
	/*
		//keyedInput.nextInt();
		//keyedInput.nextDouble();
		//keyedInput.nextLine();
		int num1 = keyedInput.nextInt();
		}
	}
	*/
	private static double incometax(double income, double[] rates, double[] brackets) {
		double tax = 0d;
		for (int i = 0; i < rates.length; i++) {
			tax += rates[i] * Math.max(0, Math.min(income, brackets[i+1]) - brackets[i]);
		}
		return tax;
	}
	private final static Scanner keyedInput = new Scanner (System.in);
	public static void main(String[] args) {
		System.out.println("What program do you want?");
		System.out.println("1: Shopping");
		System.out.println("2: Income Tax");
		System.out.println("3: Water and Computer Manufacturing");
		String choice = keyedInput.nextLine().toLowerCase().strip().trim();
		if(choice.startsWith("1")||choice.contains("shop")){
			System.out.println("1: Shopping");
			final String[] names = {"USB storage devices", "Keyboards", "Computer Mice"};
			final double[] costs = {19.99d,				  49.99d,	  25.99d};
			final double taxrate = 13d;
			double subtotal = 0d;
			for (int i = 0; i < names.length; i++) {
				System.out.println("How many $" + costs[i] + " " + names[i] + " do you want?");
				subtotal += costs[i] * keyedInput.nextInt();
			}
			double tax = Math.floor(taxrate * subtotal)/100d;
			double total = Math.floor((subtotal + tax)*100d)/100d;
			System.out.println("subtotal $" + subtotal);
			System.out.println("tax $" + tax);
			System.out.println("total $" + total);
		}else if(choice.startsWith("2")||choice.contains("tax")){
			System.out.println("2: Income Tax");
			final double[] federalrates =    { .15d,    .205d,     .26d,     .29d,     .33d};
			final double[] federalbrackets = {0,   53359,    106717,   165430,   235675,   Double.POSITIVE_INFINITY};
			final double[] provincialrates    = { .0505d,    .0915d,    .1116d,     .1216d,     .1316d};
			final double[] provincialbrackets = {0,     49231,     98463,     150000,     220000,     Double.POSITIVE_INFINITY};
			System.out.println("Please input your salary");
			double income = keyedInput.nextDouble();
			double federaltax = incometax(income,federalrates,federalbrackets);
			double provincialtax = incometax(income,provincialrates,provincialbrackets);
			double tax = federaltax + provincialtax;
			System.out.println("You owe $" + Math.floor(federaltax*100d)/100d + " in federal income tax.");
			System.out.println("You owe $" + Math.floor(provincialtax*100d)/100d + " in Ontario income tax.");
			System.out.println("You owe $" + Math.floor(tax*100d)/100d + " in income tax.");
		}else{
			System.out.println("3: Water and Computer Manufacturing");
			final double ratio = 1.5d;
			System.out.println("How many computer/monitor combos you own?");
			System.out.println("It takes " + ratio * keyedInput.nextDouble() + " tons of water to manufacture them.");
		}
	}
}
