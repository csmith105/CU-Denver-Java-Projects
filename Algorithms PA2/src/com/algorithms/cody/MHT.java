package com.algorithms.cody;

import com.algorithms.cody.HashEntry;

/*
 * Code adapted from: http://www.algolist.net/Data_structures/Hash_table/Simple_example
 */

public class MHT {
	
    private final static int TABLE_SIZE = 1200000;
    
    private int size = 0;

    HashEntry[] table;

    MHT() {
    	
          table = new HashEntry[TABLE_SIZE];
          
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
          
    }

    public Word get(String key) {
    	
          int hash = (key.hashCode() % TABLE_SIZE);
          
          while (table[hash] != null && table[hash].getKey() != key) {
        	  	hash = (hash + 1) % TABLE_SIZE;
        	  	Word.incrementComparisonsCount();
          }
          
          return(table[hash] == null) ? null : table[hash].getValue();

    }
    
    public int size() {
    		return size;
    }

    public void put(String key, Word value) {
    	
          int hash = (key.hashCode() % TABLE_SIZE);
          
          while (table[hash] != null && table[hash].getKey() != key) {
        	  	hash = (hash + 1) % TABLE_SIZE;
        	  	Word.incrementComparisonsCount();
          }
                
          table[hash] = new HashEntry(key, value);
          ++size;
          
    }
    
}
