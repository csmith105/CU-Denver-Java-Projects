package com.advanced.cody;

public class Disk {
	
	// Size of disk
	private int size;

	// Disc constructor
	public Disk(int size) {
		this.size = size;
	}
	
	// Size getter
	public int getSize() { return size; }
	
	// Override toString, for easy printing
    @Override public String toString() {
    	
    	return Integer.toString(size);
        
    }

}
