/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ca.markw.datavalidationwaterman;

import java.util.regex.Pattern;
import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class DataValidationWaterman {
	private final static String[] prompts = {"6 or more characters.",
		"a string that contains at least one lowercase “a”.",
		"5 to 15 non “z” characters.",
		"an integer between 5 and 500.",
		"a negative integer.",
		"a positive, odd integer."
	};
	private final static Scanner InputScanner = new Scanner(System.in);
	private final static String[] REGEXES = {".{7,}", ".*?a.*", "[^zZ]{5,16}",
		"[5-9]|[1-9]\\d|[1-4]\\d{2}|500", "-[1-9]\\d*", "\\+?([1-9]\\d*)?[13579]"};
	private final static Pattern[] Patterns = new Pattern[REGEXES.length];
	static{
		for (int i = 0; i < REGEXES.length; i++) {
			Patterns[i] = Pattern.compile(REGEXES[i]);
		}
	}
	private static final String[] results = new String[REGEXES.length];
	private static String line;
	public static void main(String[] args) {
		for (int i = 0; i < REGEXES.length; i++) {
			do{
				System.out.println("Please enter " + prompts[i]);
				line = InputScanner.nextLine();
			} while (!Patterns[i].matcher(line).matches());
			results[i] = line;
		}
		for (int i = 0; i < REGEXES.length; i++) {
			System.out.println("“" + results[i] + "” is " + prompts[i]);
		}
		System.out.println("Congrats!");
	}
}
