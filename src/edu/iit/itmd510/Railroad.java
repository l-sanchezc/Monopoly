package edu.iit.itmd510;

/**
 * Railroad spaces
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class Railroad extends Space{
	private int credits; 
	
    /**
     * Constructor
     *
     * @param name of the space
     * @param credits to pay
     */
	public Railroad (String name, int credits){
		super(name);
		this.credits = credits;
	}
	
    /**
     * Getter.
     *
     * @return credits to pay
     */
	public int getCredits(){
		return credits;
	}
	
    /**
     * Setter.
     *
     * @param credits to pay
     */
	public void setCredits(int credits){
		this.credits = credits;
	}
}