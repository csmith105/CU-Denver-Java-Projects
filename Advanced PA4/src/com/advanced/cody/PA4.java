package com.advanced.cody;

import java.util.Scanner;

public class PA4 {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("You will enter an array that is in ascending order, but may be rotated n times. This program will scan the entire array to make sure this is correct, any non-ascending arrays will be rejected.");
		System.out.println();
		
		System.out.print("How many elements would you like to enter? ");
		
		int numElements = console.nextInt();
		
		if(numElements == 0) {
			
			// Bail
			System.out.println("Sorry array lengths of 0 are invalid.");
			
			console.close();
			return;
			
		}
		
		int[] array = new int[numElements];
		
		for(int i = 0; i < array.length; ++i) {
			
			System.out.print("Enter element #" + String.format("%3d: ", i));
			
			array[i] = console.nextInt();
			
		}
		
		System.out.println();
		
		System.out.print("Your array is: ");
		
		for(int i = 0; i < array.length; ++i) {
			
			System.out.print(array[i]);
			
			if(i != (array.length - 1)) {
				System.out.print(", ");
			}
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Checking that the array is monotonicly increasing, even if rotated.");
		System.out.println();
		
		int beginIndex = 0, endIndex = 0;
		
		// Check the array
		if(array.length > 1) {
			
			boolean foundPivot = false;
			
			// For each element...
			for(int i = 1; i < array.length; ++i) {
				
				// Check for negative numbers
				if(array[i] < 0) {
					System.out.println("Your array has a negative element, negative elements aren't allowed.");
					return;
				}
				
				// If the next element is grater than or equal to the last element...
				if(array[i] >= array[i-1]) {
					
					if(!foundPivot) {
						endIndex = i;
					}
					
				} else {
					
					// This is either the pivot or a really big problem
					if(foundPivot) {
						
						// If we've already found the pivot, bail
						System.out.println("Your array doesn't check out, only (rotated) monotonically incraesing arrays are allowed.");
						console.close();
						return;
						
					} else {
						
						// This is the first pivot, set begin element and end element
						foundPivot = true;
						beginIndex = i;
						
					}
					
				}
				
			}
			
		}
		
		System.out.println("Your array checks out");
		System.out.println("The begin index is " + beginIndex + " (element value of: " + array[beginIndex] + ")");
		System.out.println("The end index is " + endIndex + " (element value of: " + array[endIndex] + ")");
		System.out.println();
		
		// Seach loop
		while(true) {
			
			System.out.print("Choose a value to search for: ");
			int value = console.nextInt();
			
			// Actually perform the search
			int returnValue = binarySearch(array, beginIndex, endIndex, array.length, array.length, value);
			
			if(returnValue != -1) {
				System.out.println("Your value is at index: " + returnValue);
			} else {
				System.out.println("Your value was not found.");
			}
			
			System.out.println();
			
			System.out.print("Would you like to keep going (yes/no)? ");
			String string = console.next().toLowerCase();
			
			if(string.equals("no") || string.equals("n")) break;
			
		}
		
		console.close();

	}

	// The binary search function
	public static int binarySearch(int[] array, int beginIndex, int endIndex, int length, int newLength, int value) {
		
		if ((beginIndex + 1) % length == endIndex) {
			
			if(array[beginIndex] == value)
				return beginIndex;
			
			if(array[endIndex] == value)
				return endIndex;
			
			return -1;
				
		}
		
	    int middleIndex = (beginIndex + (newLength / 2)) % length;
	    
	    if (array[middleIndex] == value) {
	    	
	    		return middleIndex;
	    		
	    } else if (value < array[middleIndex]) {
	    	
	    		return binarySearch(array, beginIndex, (middleIndex - 1) % length, length, length / 2, value);
	               
	    } else {
	    	
	    		return binarySearch(array, (middleIndex + 1) % length, endIndex, length, length / 2, value);
	    		       
	    }
		
	}
	
}