package com.advanced.cody;

import java.util.Scanner;

public class PA2 {
	
	// Clamp numbers
	public static int clamp(int value, int min, int max) {
		
		return (value > min) ? ((value < max) ? value : max) : min;
		
	}

	public static void main(String[] args) {
		
		// Create a new scanner
		Scanner console = new Scanner(System.in);
		
		// Prompt the user for the number of disks to populate
		System.out.println("How many disks would you like to create (0 min, 50 max)?");
		int numberOfDisks = PA2.clamp(console.nextInt(), 0, 50);
		
		// Prompt the user for the number of disks to move
		System.out.println("How many disks would you like to move (0 min, 50 max)?");
		int numberOfDisksToMove = PA2.clamp(console.nextInt(), 0, 50);
		
		// Close the scanner
		console.close();
		
		// Initialize the towers
		Tower[] arrayOfTowers = { new Tower(1, numberOfDisks), new Tower(2), new Tower(3) };
		
		// Perform the move
		arrayOfTowers[0].moveDisksAmongTowers(
				PA2.clamp(numberOfDisksToMove, 0, arrayOfTowers[0].getNumberOfDisks()),
				arrayOfTowers[2],
				arrayOfTowers[1]);

		// Print each tower
		for(Tower tower : arrayOfTowers)
			System.out.println(tower.toString());
		
	}

}
