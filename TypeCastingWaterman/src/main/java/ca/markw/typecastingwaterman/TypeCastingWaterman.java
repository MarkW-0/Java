/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ca.markw.typecastingwaterman;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Mark
 */
public class TypeCastingWaterman {
	private final static String[] PROMPTS = {
		"a whole number.",
		"a decimal number.",
		"a character.",
		"a name.",
		"a whole number.",
		"a decimal number.",
	};
	private final static Scanner INPUTSCANNER = new Scanner(System.in);
	private final static String[] REGEXES = {"0|[1-9]\\d*", "(0|[1-9]\\d*)(\\.\\d*)?", ".",
		".*", "0|[1-9]\\d*", "(0|[1-9]\\d*)(\\.\\d*)?"};
	private final static Pattern[] PATTERNS = new Pattern[REGEXES.length];
	static{
		for (int i = 0; i < REGEXES.length; i++) {
			PATTERNS[i] = Pattern.compile(REGEXES[i]);
		}
	}
	private final static String[] RESULTS = new String[REGEXES.length];
	private static String line;
	public static void main(String[] args) {
		for (int i = 0; i < REGEXES.length; i++) {
			do{
				System.out.println("Please enter " + PROMPTS[i]);
				line = INPUTSCANNER.nextLine();
			} while (!PATTERNS[i].matcher(line).matches());
			RESULTS[i] = line;
		}
		int Result0 = Integer.parseInt(RESULTS[0]);
		double Result1 = Double.parseDouble(RESULTS[1]);
		char Result2 = RESULTS[2].charAt(0);
		String Result3 = RESULTS[3];
		String Result4 = RESULTS[4];
		String Result5 = RESULTS[5];
		System.out.println((double) Result0);
		System.out.println((int) Result1);
		System.out.println( Character.toString(Result2));
		System.out.println(Result3.charAt(0));
		System.out.println(Integer.parseInt(Result4));
		System.out.println(Double.parseDouble(Result5));
	}
}
