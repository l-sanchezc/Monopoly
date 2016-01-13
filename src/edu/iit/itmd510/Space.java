package edu.iit.itmd510;

/**
 * Spaces of the board
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class Space {
	private String name;
	
    /**
     * Constructor
     *
     * @param name of the space
     */
	public Space (String name){
		this.name = name;
	}
	
    /**
     * Getter.
     *
     * @return name of the space
     */
	public String getName(){
		return name;
	}
	
    /**
     * Setter.
     * 
     * @param name of the space
     */
	public void setName(String name){
		this.name = name;
	}
}
