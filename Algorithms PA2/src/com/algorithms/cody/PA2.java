package com.algorithms.cody;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PA2 {

	public static void main(String[] args) {
		
		// Was a file passed to this program via command line arguements?
		if(args.length == 0) {
			
			System.out.println("No arguements provided.");
			
			return;
			
		}
		
		String line;
		
		// ArrayList to hold the lines, so that we don't have to read them from the file multiple times
		ArrayList<String> lines = new ArrayList<String>(1020000);
		
		try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {

		    while ((line = file.readLine()) != null)
		    	lines.add(line);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("All lines read from file: " + args[0] + "\r\n");
		
		System.out.println("Begin Vector:\r\n");
		
		// 1. Using a vector
		long assignmentCount = 0;
		int wordCounter = 0;
		
		ArrayList<Word> vectorWordConcordance = new ArrayList<Word>(1020000);
		
		// For each line in lines, try to create a word, store the successes into the vectorWordList
		for(String string : lines) {
			Word word = Word.buildWordFromString(string);
			
			if(word != null) {
				
				boolean foundWord = false;
				
				// Search the list, looking for matching words
				for(Word listword : vectorWordConcordance) {
					
					if(listword.compareTo(word) == 0) {
						listword.incrementCount();
						foundWord = true;
						break;
					}
					
				}
				
				if(foundWord == false) {
					++assignmentCount;
					vectorWordConcordance.add(word);
				}
					
				
			}
			
			++wordCounter;
			
			if(wordCounter % 1000 == 0) {
				System.out.println("Found " + vectorWordConcordance.size() + " words.");
				System.out.println("In " + Word.getComparisons() + " comparisons.");
				System.out.println("In " + assignmentCount + " assignments.");
			}
				
		}
		
		System.out.println("FINAL: Found " + vectorWordConcordance.size() + " words.");
		System.out.println("FINAL: In " + Word.getComparisons() + " comparisons.");
		System.out.println("FINAL: In " + assignmentCount + " assignments.");

	}

}
