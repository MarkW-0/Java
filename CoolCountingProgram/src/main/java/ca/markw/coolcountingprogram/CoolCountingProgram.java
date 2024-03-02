/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.coolcountingprogram;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class CoolCountingProgram {
	private final static Scanner INPUT = new Scanner(System.in);
	private final static int[] START = {0,  100, 50,  6000};
	private final static int[] END =   {10, 0,   500, 50};
	private final static int[] STEP =  {1,  10,  50,  1000};
	//private final static comment[] comment = {//constants}
	private static int choice = 0;
	public static void main(String[] args) {
		System.out.println("---Cool Counting Program---");
		System.out.println();
		System.out.println("Please enter your choice:");
		for (int i = 0; i < START.length; i++) {//print choices
			System.out.println((i + 1) + "... Count from " + START[i] + " to " + END[i] + " by " + STEP[i]);
		}
		System.out.println("Please enter your choice:");
		choice = INPUT.nextInt() - 1;//0 indexing
		if(choice < 0 || START.length <= choice){
			System.err.println("index out of bounds!");
			return;
		}
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("You have chosen to count from " + START[choice] + " to " + END[choice] + " by " + STEP[choice] + ":");
		if(START[choice] <= END[choice]) {//count up?
			for (int i = START[choice]; i <= END[choice]; i += STEP[choice]) {
				System.out.println(i);
			}
		} else {//Countdown
			for (int i = START[choice]; END[choice] <= i; i -= STEP[choice]) {
				System.out.println(i);
			}
		}
	}
}
