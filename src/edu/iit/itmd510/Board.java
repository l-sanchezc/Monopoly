package edu.iit.itmd510;

/**
 * Board of Monopoly Game
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class Board {
	private Space[] board = new Space[40];
	
	/**
	 * Constructor.
	 */
	public Board(){
		board[0]= new Space("Go");
		board[1]= new Property("Mediterranean Avenue",60);
		board[2]= new Space("Community Chest");
		board[3]= new Property("Baltic Avenue",60);
		board[4]= new Tax("Income Tax",200);
		board[5]= new Railroad("Reading Railroad",200);
		board[6]= new Property("Oriental Avenue",100);
		board[7]= new Space("Chance");
		board[8]= new Property("Vermont Avenue",100);
		board[9]= new Property("Connecticut Avenue",120);
		board[10]= new Space("Just Visiting/In Jail");
		board[11]= new Property("St. Charles Place",140);
		board[12]= new Company("Electric Company",5);
		board[13]= new Property("States Avenue",140);
		board[14]= new Property("Virginia Avenue",160);
		board[15]= new Railroad("Pennsylvania Railroad",200);
		board[16]= new Property("St. James Place",180);
		board[17]= new Space("Community Chest");
		board[18]= new Property("Tennessee Avenue",180);
		board[19]= new Property("New York Avenue",200);
		board[20]= new Space("Free Parking");
		board[21]= new Property("Kentucky Avenue",220);
		board[22]= new Space("Chance");
		board[23]= new Property("Indiana Avenue",220);
		board[24]= new Property("Illinois Avenue",240);
		board[25]= new Railroad("B&O Railroad",200);
		board[26]= new Property("Atlantic Avenue",260);
		board[27]= new Property("Ventnor Avenue",260);
		board[28]= new Company("Water Works",10);
		board[29]= new Property("Marvin Gardens",280);
		board[30]= new Space("Go To Jail");
		board[31]= new Property("Pacific Avenue",300);
		board[32]= new Property("North Carolina Avenue",300);
		board[33]= new Space("Community Chest");
		board[34]= new Property("Pennsylvania Avenue",320);
		board[35]= new Railroad("Short Line Railroad",200);
		board[36]= new Space("Chance");
		board[37]= new Property("Park Place",350);
		board[38]= new Tax("Luxury Tax",100);
		board[39]= new Property("Boardwalk",400);
	}
	
	/**
	 * Get space of the board
	 * @param num number of the space
	 * @return space with that number
	 */
	public Space getSpace(int num) {
		return board[num];
	}
}
