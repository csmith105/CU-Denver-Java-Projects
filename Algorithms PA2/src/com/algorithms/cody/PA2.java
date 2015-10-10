package com.algorithms.cody;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ListIterator;

public class PA2 {

	public static void main(String[] args) {
		
		// Was a file passed to this program via command line arguments?
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
		
		long assignmentCount = 0;
		int wordCounter = 0;
		
		// 1. Begin - Using am unsorted vector
		System.out.println("Starting Unsorted Vector...");
		
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
				
		}

		System.out.println("Processed: " + wordCounter + " words");
		System.out.println("Found " + vectorWordConcordance.size() + " unique words.");
		System.out.println("In " + Word.getComparisons() + " comparisons.");
		System.out.println("In " + assignmentCount + " assignments.");
		System.out.println();
		
		// 1. End
		
		// Cleanup
		Word.resetComparisons();
		
		assignmentCount = 0;
		wordCounter = 0;
		
		// 2. Using a sorted list
		System.out.println("Starting Sorted List...");
		
		LinkedList<Word> listWordConcordance = new LinkedList<Word>();
		
		// For each line in lines, try to create a word, store the successes into the vectorWordList
		for(String string : lines) {
			
			Word word = Word.buildWordFromString(string);
			
			if(word != null) {
				
				boolean foundWord = false;
				
				// Search the list, looking for matching words
				ListIterator<Word> itr = listWordConcordance.listIterator();
				
				while(itr.hasNext()) {
					
					Word listword = itr.next();
					
					if(listword.compareTo(word) == 0) {
						listword.incrementCount();
						foundWord = true;
						break;
					}
					
					// See if this is where our word goes in the list
					if(itr.hasNext()) {
						
						// Peek the next word
						Word nextListWord = itr.next();
						itr.previous();
						
						if(word.compareTo(listword) > 0 && word.compareTo(nextListWord) < 0) {
							++assignmentCount;
							itr.add(word);
							foundWord = true;
							break;
						}
						
					}
					
				}
				
				// If the word wasn't found, add it to the end
				if(foundWord == false) {
					++assignmentCount;
					listWordConcordance.add(word);
				}
					
			}
			
			++wordCounter;
				
		}
		
		System.out.println("Processed: " + wordCounter + " words");
		System.out.println("Found " + listWordConcordance.size() + " unique words.");
		System.out.println("In " + Word.getComparisons() + " comparisons.");
		System.out.println("In " + assignmentCount + " assignments.");
		System.out.println();

		// 2. End
		
		// Cleanup
		Word.resetComparisons();
		
		assignmentCount = 0;
		wordCounter = 0;
		
		// 3. Using a BTree
		System.out.println("Starting Sorted BTree...");
		
		BTree treeWordConcordance = new BTree();
		
		// For each line in lines, try to create a word, store the successes into the vectorWordList
		for(String string : lines) {
			
			Word word = Word.buildWordFromString(string);
			
			if(word != null) {
				
				Word foundWord = treeWordConcordance.find(word);
				
				if(foundWord != null) {
					foundWord.incrementCount();
				} else {
					treeWordConcordance.insert(word);
					++assignmentCount;
				}
					
			}
			
			++wordCounter;
				
		}
		
		System.out.println("Processed: " + wordCounter + " words");
		System.out.println("Found " + treeWordConcordance.size() + " unique words.");
		System.out.println("In " + Word.getComparisons() + " comparisons.");
		System.out.println("In " + assignmentCount + " assignments.");
		System.out.println();

		// 3. End
		
		// Cleanup
		Word.resetComparisons();
		
		assignmentCount = 0;
		wordCounter = 0;
		
		// 4. Using a Hashtable
		System.out.println("Starting Sorted Hashtable...");
		
		Hashtable<String, Word> hashtable = new Hashtable<String, Word>();
		
		// For each line in lines, try to create a word, store the successes into the vectorWordList
		for(String string : lines) {
			
			Word word = Word.buildWordFromString(string);
			
			if(word != null) {
				
				boolean foundWord = hashtable.containsKey(word.getString());
				
				if(foundWord) {
					hashtable.get(word.getString()).incrementCount();
				} else {
					hashtable.put(word.getString(), word);
					++assignmentCount;
				}
					
			}
			
			++wordCounter;
				
		}
		
		System.out.println("Processed: " + wordCounter + " words");
		System.out.println("Found " + hashtable.size() + " unique words.");
		System.out.println("In " + Word.getComparisons() + " comparisons.");
		System.out.println("In " + assignmentCount + " assignments.");
		System.out.println();
		
		// 4. End
				
	}

}
