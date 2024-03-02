/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.programfixingwaterman;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class ProgramFixingWaterman {
	private static void TotalOfTwenty() {//Ten->Twenty
		Scanner keyedInput = new Scanner(System.in);
		int[] numbers = new int[20];//10->20
		int total = 0;
		System.out.println("Enter twenty integers and they will be added together:");//"ten"->"twenty"
		for (int i = 0; i <= 19; i = i + 1) {//9->19
			numbers[i] = keyedInput.nextInt();
		}
		for (int i = 0; i <= 19; i = i + 1) {//9->19
			total = total + numbers[i];
		}
		System.out.println("The sum of those numbers is:");
		System.out.println(total);
	}

	private static void FriendSelection() {
		Scanner keyedInput = new Scanner(System.in);
		String[] friends = new String[5];//10->5
		System.out.println("Enter the names of five friends:");//"ten"->"five"
		for (int i = 0; i <= 4; i = i + 1) {//9->4
			friends[i] = keyedInput.nextLine();
		}
		System.out.println("The second, third and fourth names listed were:");//"fourth and seventh"->"second, third and fourth"
		System.out.println("Second: " + friends[1]);//"Fourth"->"Second",3->1
		System.out.println("Third: " + friends[2]);//"Seventh"->"Third",6->2
		System.out.println("Fourth: " + friends[3]);//->System.out.println("Fourth: " + friends[3]);
	}

	private static void AverageOfEight() {//Five->Eight
		Scanner keyedInput = new Scanner(System.in);
		double[] marks = {34.7, 54.1, 34.8, 99.6, 43.6, 43.2, 65.8, 44.8, 88.6};//->, 65.8, 44.8, 88.6
		double total = 0;
		double average;
		System.out.println("These are the marks:");
		for (int i = 0; i <= 8; i = i + 1) {//5->8
			System.out.println(marks[i]);
		}
		for (int i = 0; i <= 8; i = i + 1) {//5->8
			total = total + marks[i];
		}
		average = total / 9;//6->9
		average = average * 10;
		average = Math.round(average);
		average = average / 10;
		System.out.println("The average mark is:");
		System.out.println(average);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose program");
		System.out.println("1: Total of twenty");//"ten"->"twenty"
		System.out.println("2:Friend selection");
		System.out.println("3:Average of eight");//"five"->"eight"
		int choice = input.nextInt();
		System.out.println("----------------------------------------------");
		switch(choice){
			case 1:
				TotalOfTwenty();//"Ten"->"Twenty"
				break;
			case 2:
				FriendSelection();
				break;
			case 3:
				AverageOfEight();//"Five"->"Eight"
				break;
		}
	}
}
