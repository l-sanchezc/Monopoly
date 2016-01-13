package edu.iit.itmd510;

/**
 * Dice to play
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class Dice {
	private int roll;
	
    /**
     * Roll the dice
     */
    public void roll(){
    	roll = (int)(Math.random() * 6) + 1;
    }
    
    /**
     * Get the dice roll.
     *
     * @return dice roll
     */
    public int getRoll(){
    	return roll;
    }
    
    /**
     * Set the dice roll.
     *
     * @param dice roll
     */
    public void setRoll(int roll){
    	this.roll = roll;
    }
}
