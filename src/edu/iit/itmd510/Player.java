package edu.iit.itmd510;

/**
 * Player of Monopoly game
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class Player {
	private int credits;
	private int currentSpace;
	private int timesRailroads;
	
	/**
	 * Constructor
	 */
	public Player(){
		this.credits = 0;
		this.currentSpace = 0;
		this.timesRailroads = 0;
	}
	
	/**
	 * It gets the actual player credits
	 * @return player credits
	 */
	public int getCredits(){
		return this.credits;
	}
	
	/**
	 * It gets the index of the current space
	 * @return the index of the current space
	 */
	public int getIndexSpace() {
		return this.currentSpace;
	}
	
	/**
	 * It gets the name of the current space
	 * @return the name of the current space
	 */
	public Space getSpace(Board board) {
		return board.getSpace(this.getIndexSpace());
	}
	
	/**
	 * It gets the number of times that the player has landed on a railroad space
	 * @return number of times
	 */
	public int getTimesRailroads(){
		return this.timesRailroads;
	}
	
	/**
	 * It sets the credits of the player
	 * @param credits of the player
	 */
	public void setCredits(int credits){
		this.credits = credits;
	}
	
	/**
	 * It sets the space in which is the player
	 * @param space index
	 */
	public void setSpace(int space) {
		this.currentSpace = space;
	}
	
	/**
	 * It sets the number of times that the player has landed on a railroad space
	 * @param times number
	 */
	public void setTimesRailroads(int times){
		this.timesRailroads = times;
	}
	
	/**
	 * This method moves the player 
	 * @param totalRoll
	 * @return endGame
	 */
	public boolean move(int totalRoll) {
		boolean endGame;
		if (this.currentSpace + totalRoll <= 39){
			this.currentSpace = currentSpace + totalRoll;
			endGame = false;
		}
		else{
			this.currentSpace = 0;
			endGame = true;
		}
		return endGame;
	}
}
