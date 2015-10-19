package com.advanced.cody;

public class DiningPhilosophers {
	
	public DiningPhilosophers() {
		
		Thread[] threads = new Thread[5];
		
		for(int i = 0; i < 5; ++i) {
			
			// Create and start the five Philosophers
			threads[i] = new Thread(new Philosopher(i + 1));
					
			threads[i].start();
			
		}
		
		for(int i = 0; i < 5; ++i) {	
			
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}	
		
	}

}
