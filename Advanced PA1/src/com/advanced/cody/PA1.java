package com.advanced.cody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PA1 {

	public static void main(String[] args) {

		// Define our words
		String foo = "Work", bar = "Java";
		
		// Define the document
		String document = "Java technology allows you to work and play in a secure computing environment. Upgrading to the latest Java version improves the security of your system, as older versions do not include the latest security updates. Java allows you to play online games, chat with people around the world, calculate your mortgage interest, and view images in 3D, just to name a few.";
		
		// Remove everything but the letters and numbers
		document = document.replaceAll("[^A-Za-z0-9']", " ");
		
		// Create & populate our word array
		String[] arrayOfWords = document.split("[\\s]+");
		
		System.out.println("Printing the words:");
		
		// Display each word
		System.out.print(Arrays.toString(arrayOfWords));
		System.out.println();
		
		// Run the find function
		findTheShortestDistance(arrayOfWords, foo, bar);

	}
	
	public static void findTheShortestDistance(String[]	arrayOfWords, String word1, String word2) {
		
		// Create a Map of words, along with their respective places
		HashMap<String, ArrayList<Integer>> wordMap = new HashMap<String, ArrayList<Integer>>();
		
		// Add each word to the map
		for(int i = 0; i < arrayOfWords.length; ++i) {
			
			// Does this word exist in the map?
			if(wordMap.containsKey(arrayOfWords[i])) {
				
				// It does, get the value and add to it
				wordMap.get(arrayOfWords[i]).add(i);
				
			} else {
				
				// It does not, create the first record
				ArrayList<Integer> firstRecord = new ArrayList<Integer>();
				firstRecord.add(i);
				wordMap.put(arrayOfWords[i].toLowerCase(), firstRecord);
				
			}
			
		}
		
		// Ensure that there is a record for word1 and word2?
		if(!wordMap.containsKey(word1.toLowerCase()) || !wordMap.containsKey(word2.toLowerCase())) {
			
			System.out.println("Specified words don't appear in the provided document.");
			return;
			
		}
		
		// Now let's find the closest instance of word2 to word1
		
		// Get the locations of word1
		ArrayList<Integer> locationsOfWord1 = wordMap.get(word1.toLowerCase());
		
		// Get the locations of word2
		ArrayList<Integer> locationsOfWord2 = wordMap.get(word2.toLowerCase());
		
		// Initialize minDistance, cannot be longer than the length of our document
		int minDistance = arrayOfWords.length;
		int word1Position = 0, word2Position = 0;
		
		// Compare each instance of word1
		for(int i : locationsOfWord1) {
			
			// To each instance of word2
			for(int j : locationsOfWord2) {
				
				// Get the distance between these two occurrences
				int distance = Math.abs(i - j);
				
				// If our distance is less than minDistance, update minDistance
				if(distance < minDistance) {
					
					// Set the new distance
					minDistance = distance;
					word1Position = i;
					word2Position = j;
					
				}
				
			}
			
		}
			
		// We're done, print out the result
		System.out.println("\r\nThe distance is:\r\n" + minDistance + " [" + word1 + " @ " + (word1Position + 1) + "], [" + word2 + " @ " + (word2Position + 1) + "]");
		
	}

}