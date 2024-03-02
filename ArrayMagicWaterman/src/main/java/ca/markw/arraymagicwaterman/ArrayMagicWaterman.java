/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.arraymagicwaterman;

import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class ArrayMagicWaterman {
	public static void main(String[] args) {
		final Scanner input = new Scanner(System.in);
		System.out.println("How many primes do you want?");
		final int[] primes = new int[input.nextInt()];
		final int[] multiprimes = new int[primes.length];//prime * multiplier
		int prime = -1;//index of last prime
		int N = 2;//num to test
		System.out.println("Your " + primes.length + " primes are:");
		while(prime < primes.length - 1){
			int i = 0;
			while(i <= prime) {
				while(multiprimes[i] < N){
					multiprimes[i] += primes[i];
				}
				if(multiprimes[i] == N){
					multiprimes[i] += primes[i];
					break;//not prime
				}
				i++;
			}
			if(prime < i){//prime
				prime++;
				System.out.println(1 + prime + ", " + N);
				primes[prime] = N;
				multiprimes[prime] = N;
			}
			N++;
		}
		System.out.println("Goodbye");
	}
}
