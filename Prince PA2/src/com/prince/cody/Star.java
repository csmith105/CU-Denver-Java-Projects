package com.prince.cody;

import java.util.ArrayList;

public class Star {
	
	private double x, y, z, nearestStarDistance = 10000000;

	// Construct this star using provided coordinates
	public Star(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		//System.out.println("Created Star @ " + x + " " + y + " " + z);
	
	}
	
	// Getters
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public double getZ() { return this.z; }
	public double getNearestStarDistance() { return nearestStarDistance; }
	
	// Calculate the distance between this star and the provided star
	public double getDistanceTo(Star star) {
		return Math.sqrt(Math.pow(this.x - star.getX(), 2) + Math.pow(this.y - star.getY(), 2) + Math.pow(this.z - star.getZ(), 2));
	}
	
	static int starCounter = 0;
	
	// Given a list of stars, determine which one is closest and note the distance
	public void computeNearestNeighborDistance(ArrayList<Star> stars) {
		
		for(Star star : stars) {
			
			// Make sure we don't count ourself
			if(star != this) {
				
				// Get the distance
				double distance = this.getDistanceTo(star);
				
				// Compare the distance to our current closest
				if(distance < nearestStarDistance) nearestStarDistance = distance;
				
			}
			
		}
		
		++starCounter;
		
		if(starCounter % 100 == 0)
			System.out.println("Processed " + starCounter + " stars.");
		
	}

}
