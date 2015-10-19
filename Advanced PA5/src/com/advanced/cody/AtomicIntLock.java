package com.advanced.cody;

public class AtomicIntLock {
	
	private volatile int value;
	
	public AtomicIntLock(int initialValue) {
		value = initialValue;
	}
	
	public synchronized boolean getChops() {
		
		if(value <= 3) {
			
			value += 2;
			
			return true;
		}
		
		return false;

	}
	
	public synchronized void releaseChops() {
		
		value -= 2;
		
	}

}
