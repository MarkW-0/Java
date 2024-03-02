/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.cubessquaresandpowerswaterman;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class CubesSquaresAndPowersWaterman {

	private final static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("1… Find the value of a number squared");
			System.out.println("2… Find the value of a number cubed");
			System.out.println("3… Find the value of a number, to any power");
			System.out.println("4… Exit");
			double power = input.nextInt() + 1;
			if (power == 5) {
				break;
			}
			System.out.println("enter a number");
			double base = input.nextDouble();
			if (power == 4) {
				System.out.println("enter a power");
				power = input.nextDouble();
			}
			System.out.println(Math.pow(base, power));
		}
		System.out.println("Goodbye");
	}
}
