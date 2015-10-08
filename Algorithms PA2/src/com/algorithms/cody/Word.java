package com.algorithms.cody;

public class Word implements Comparable<Word>{

	private String string;
	
	private static long comparisons = 0;
	
	private int count = 0;
	
	// Tests the word to see if it qualifies, if not returns null, otherwise this function returns a Word
	public static Word buildWordFromString(String string) {
		
		// Don't even try if the string is empty
		if(string.length() == 0)
			return null;
		
		// Get the first char
		final char first = string.charAt(0);
		
		// Make sure the first char is alphabetic
		if ((first >= 'a' && first <= 'z') || (first >= 'A' && first <= 'Z'))
			return new Word(string.toLowerCase());
		
		// Otherwise return null
		return null;
		
	}
	
	// Return the word count
	public int getCount() {
		return count;
	}
	
	// Increment the word count
	public void incrementCount() {
		++count;
	}
	
	// Constructor, all words must be built with a valid string
	public Word(String string) {
		
		this.string = string;
		
	}
	
	// Returns the raw string value from this object
	public String getString() {
		
		return string;
		
	}
	
	// Returns the comparison counter's count
	public static long getComparisons() {
		
		return comparisons;
		
	}
	
	// Resets the comparison counter
	public static void resetComparisons() {
		
		comparisons = 0;
		
	}
	
	 @Override
	 public int compareTo(Word word) {
		
		// Increment the comparison counter
		++comparisons;
		
		// Do the comparison
		return this.getString().compareTo(word.getString());
		
    }

}