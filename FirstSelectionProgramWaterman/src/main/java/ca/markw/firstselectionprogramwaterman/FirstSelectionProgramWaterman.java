/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.firstselectionprogramwaterman;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class FirstSelectionProgramWaterman {
	private final static Scanner KEYEDINPUT = new Scanner(System.in);
	private final static double[] RANGES =   {0, 40, 80, 120, Double.POSITIVE_INFINITY};
	private final static double[] DISCOUNTS = {10, 20, 30,  40};
	private static double spending;
	private static double discount;
	private static double savings;
	private static double total;
	public static void main(String[] args) {
		System.out.println("Please enter the amount spent:");
		spending = KEYEDINPUT.nextDouble();
		discount = 0;
		for (int i = 0; i < DISCOUNTS.length; i++) {//find discount
			if(RANGES[i] < spending && spending <= RANGES[i+1]){
				discount = DISCOUNTS[i];
			}
		}
		savings = spending * discount / 100;//discount is a %
		total = spending - savings;
		System.out.println("You spent: $" + spending);
		System.out.println("You are saving " + discount + "%");
		System.out.println("You are saving $" + Math.round(savings * 100) / 100);
		System.out.println("Tour total is $" + Math.round(total * 100) / 100);
	}
}
