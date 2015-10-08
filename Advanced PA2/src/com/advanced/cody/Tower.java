package com.advanced.cody;

import java.util.Stack;

public class Tower {
	
	// Tower index
	private int index;
	
	// Stack of disks
	private Stack<Disk> stack = new Stack<Disk>();

	// Constructor, used to create an empty tower
	public Tower(int index) {
		
		this.index = index;
		
	}
	
	// Constructor, used to create a tower with n disks
	public Tower(int index, int numDisks) {
		
		this.index = index;
		
		// Populate the tower with n disks, ranging from size numDisks to 1.
		for(int i = 0; i < numDisks; ++i) {
			
			// Create new disk and add it to the stack
			stack.push(new Disk(numDisks - i));
			
		}
		
	}
	
	// Gets the index of this tower
	public int getIndex() { return index; }
	
	// Move this towers top disk to another tower
	public void pop(Tower tower) {
		tower.push(stack.pop());
	}
	
	// Add a disk to the top of this tower
	public void push(Disk disk) {
		stack.push(disk);
	}
	
	// Gets the number of disks on this tower
	public int getNumberOfDisks() {
		return stack.size();
	}
	
	// Override toString, for easy printing
    @Override public String toString() {
    	
    	String string = "Tower: " + index + "\n\r";
    	
    	for(int i = getNumberOfDisks() - 1; i >= 0; --i)
    		string += stack.elementAt(i).toString() + "\n\r";
    	
    	return string;
        
    }
	
    // Moves N disks from this tower to another following the "Tower of Hanoi" rules
	public void moveDisksAmongTowers(int	 number, Tower finalTower, Tower intermediateTower) {
		
		// Safeguard, if less than zero do nothing
		if (number <= 0) return;
		
		if (number == 1)
		{
			
			// Base case, just move the single peg over to its final position
			pop(finalTower);
			
		}
		else
		{
			
			// Move number-1 disks to the intermediate peg, using the final peg as the intermediate
			moveDisksAmongTowers(number - 1, intermediateTower, finalTower);
			
			// Move the final peg to the final tower
			pop(finalTower);
			
			// Move the rest of the disks over to the final recursively
			intermediateTower.moveDisksAmongTowers(number - 1, finalTower, this);
			
		}
		
	}

}