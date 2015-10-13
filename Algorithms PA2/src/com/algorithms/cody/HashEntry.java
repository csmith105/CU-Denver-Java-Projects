package com.algorithms.cody;

/*
 * Code adapted from: http://www.algolist.net/Data_structures/Hash_table/Simple_example
 */
public class HashEntry {
	
    private String key;
    private Word value;

    HashEntry(String key, Word value) {
          this.key = key;
          this.value = value;
    }     

    public String getKey() {
          return key;
    }

    public Word getValue() {
          return value;
    }
}
