package com.prince.cody;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PA2 {

	public static void main(String[] args) {
		
		System.out.println("Reading HYG formatted CSV file named \"" + args[0] + "\".");
		
		String line;
		
		// Our collection of stars
		ArrayList<Star> stars = new ArrayList<Star>();

		try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {

		    while ((line = file.readLine()) != null) {
		    	
		    	// Split the string on the comma
		    	String[] data = line.split(",");
		    	
			    	// Add the star if the distance field isn't 10000000
			    	if(!data[0].equals("10000000")) {
				    	stars.add(new Star(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3])));
			    	}
		    	
		    }
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Found " + stars.size() + " stars.");
		
		// Compute distances
		for(Star star : stars) {
			star.computeNearestNeighborDistance(stars);
		}
		
		// Compute minimum
		double minimum = 10000000;
		
		for(Star star : stars) {
			if(star.getNearestStarDistance() < minimum) {
				minimum = star.getNearestStarDistance();
			}
		}
		
		System.out.println("minimum\t= " + minimum);
		
		// Compute maximum
		double maximum = 0;
		
		for(Star star : stars) {
			if(star.getNearestStarDistance() > maximum) {
				maximum = star.getNearestStarDistance();
			}
		}
		
		System.out.println("maximum\t= " + maximum);
		
		// Compute mean
		double meanTotal = 0;
		
		for(Star star : stars) {
			meanTotal += star.getNearestStarDistance();
		}
				
		System.out.println("mean\t= " + (double) meanTotal / (double) stars.size());
		
	}

}
