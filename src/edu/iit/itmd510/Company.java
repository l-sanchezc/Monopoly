package edu.iit.itmd510;

/**
 * Electric company and Water Works spaces
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class Company extends Space {
	private int multiplier;
	
    /**
     * Constructor
     *
     * @param name of the space
     * @param multiplier of the space
     */
	public Company(String name, int multiplier){
		super(name);
		this.multiplier = multiplier;
	}
	
    /**
     * Getter of multiplier.
     *
     * @return multiplier of the space
     */
	public int getMultiplier(){
		return multiplier;
	}
	
    /**
     * Setter of multiplier.
     *
     * @param multiplier of the space
     */
	public void setMultiplier(int multiplier){
		this.multiplier = multiplier;
	}
}
