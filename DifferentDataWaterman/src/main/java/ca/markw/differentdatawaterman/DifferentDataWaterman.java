/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.differentdatawaterman;

/**
 *
 * @author Mark
 */
public class DifferentDataWaterman {
		private final static String fname = "Mark";
		private final static String lname = "Waterman";
		private final static int classichighscore = 10110;
		private final static double timehighscore = 58.2;
		private final static boolean lovesCS = true;

	public static void main(String[] args) {
		System.out.println("First Name: " + fname);
		System.out.println("Last Name: " + lname);
		System.out.println("Classic highscore: " + classichighscore + " Points");
		System.out.println("Time highscore: " + timehighscore + " Seconds");
		System.out.println((lovesCS ? "Loves" : "Does't love")+" Computer Science");
	}
}
