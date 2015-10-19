package com.advanced.cody;

import java.util.concurrent.atomic.AtomicInteger;

public class Philosopher implements Runnable {

	private static volatile AtomicIntLock chopsticksInUse = new AtomicIntLock(0);
	
	private int leftChopStick, rightChopStick;
	
	private final int id;
	
	public Philosopher(int id) {
		this.id = id;
	}
	
	public void run() {
		
		final long startTime = System.currentTimeMillis();
		long time = 0;
		boolean waiting = false;
		
		while(time < 60000) {
			
			if(chopsticksInUse.getChops()) {
				
				waiting = false;
				
				System.out.println("Philosopher #" + id + " eating...");
				 
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				chopsticksInUse.releaseChops();
				System.out.println("Philosopher #" + id + " resting...");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} else {
				
				if(!waiting) {
					waiting = true;
					System.out.println("Philosopher #" + id + " is waiting for food...");
				}
				
			}
			
			time = System.currentTimeMillis() - startTime;
			
		}
		
		System.out.println("Philosopher #" + id + " died.");
		
    }
	
}
