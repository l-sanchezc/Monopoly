package edu.iit.itmd510;

import java.util.Scanner;

/**
 * Monopoly Game
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class Monopoly {
	private static Board board = new Board();
	private static Player player = new Player();
	private static Dice[] dice = { new Dice(), new Dice()};
	public static int totalRoll;
	private static boolean automatic = true;
	private static boolean endGame = false;
	
	public static void main(String[] args) {
		String command = "";
		for(String s: args){
			command = command + s;
		}
		if (command.contains("-dice")){
			automatic = false;
		}
		else{
			automatic = true;
		}
		run();	
	}
	
	/**
	 * This method runs the game
	 */
	public static void run(){
		do{
			if (automatic){
				roll();
				System.out.printf("Player rolled %d and %d = %d %n", dice[0].getRoll(), dice[1].getRoll(), totalRoll);
			}
			else{
				validateInput();
			}
			endGame = player.move(totalRoll);
			print(player.getSpace(board), updatePlayer(player));
		} while(endGame == false);
	}
	
	/**
	 * This method validate the input of the command line
	 */
	private static void validateInput(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		int roll1, roll2;
		do {
			System . out. print ("Please enter your dice roll: ");
			roll1 = scanner.nextInt();
			roll2 = scanner.nextInt();
			if (roll1 < 1 || roll1 > 6 || roll2 < 1 || roll2 > 6 ){
				System.out.println("Please enter a valid dice roll.");
			}
		} while (roll1 < 1 || roll1 > 6 || roll2 < 1 || roll2 > 6 );
		dice[0].setRoll(roll1);
		dice[1].setRoll(roll2);
		totalRoll=roll1+roll2;
	}
	
	/**
	 * It rolls the dice
	 */
	private static void roll(){
		totalRoll=0;
		for (int i = 0; i < 2; i++){
			dice[i].roll();
			totalRoll += dice[i].getRoll();
		}
	}
	
	/**
	 * This method updates the parameters of the player
	 * @param player
	 */
	public static int updatePlayer(Player player)	{
		Space space = player.getSpace(board);
		int total = 0;	
		if (space instanceof Property){
			Property property = (Property) space;
			player.setCredits(player.getCredits()+property.getCredits());
		}
		else if (space instanceof Tax){
			Tax tax = (Tax) space;
			player.setCredits(player.getCredits()+tax.getCredits());
		}
		else if (space instanceof Railroad){
			Railroad railroad = (Railroad) space;
			player.setTimesRailroads(player.getTimesRailroads()+1);
			total = railroad.getCredits()*player.getTimesRailroads();
			player.setCredits(player.getCredits()+total);
		}
		else if (space instanceof Company){
			Company company = (Company) space;
			total = company.getMultiplier()*totalRoll;
			player.setCredits(player.getCredits()+total);
		}
		else if (space.getName().equals("Go To Jail")){
			player.setSpace(10);
		}	
		else if (space.getName().equals("Go")){
			player.setCredits(player.getCredits()+200);	
		}
		return total;
	}	
	
	/**
	 * This method prints the game
	 * @param space
	 * @param total credits to increase
	 */
	public static void print(Space space, int total)	{
		if (endGame == false){
			System.out.println("Player landend on " + space.getName());
			if (space instanceof Property){
				Property property = (Property) space;
				System.out.printf("%s awards %d credits.%n", space.getName(), property.getCredits());
			}
			else if (space instanceof Tax){
				Tax tax = (Tax) space;
				System.out.printf("%s awards %d credits.%n", space.getName(), tax.getCredits());
			}
			else if (space instanceof Railroad){
				Railroad railroad = (Railroad) space;
				System.out.printf("%s awards %d x %d = %d credits.%n", space.getName(), player.getTimesRailroads(), railroad.getCredits(), total);
			}
			else if (space instanceof Company){
				Company company = (Company) space;
				System.out.printf("%s awards (%d + %d) x %d = %d credits.%n", space.getName(), dice[0].getRoll(), dice[1].getRoll(), company.getMultiplier(), total);
			}
			else if (space.getName().equals("Go To Jail")){
				System.out.println("Go directly to Jail. Do not pass Go, do not collect 200 credits.");
			}	
			else if (space.getName().equals("Chance")){
				System.out.println(drawChanceCard(player));
			}
			else if (space.getName().equals("Community Chest")){
				System.out.println(drawCommunityChestCard(player));
			}	}
		else {
			System.out.println("Player passes Go and is awarded 200 credits.");
		}
		System.out.printf("Total Credits Won: %d credits.%n", player.getCredits());
	}	
	
	/**
	 * It draws chance card
	 * @param player
	 */
	public static String drawChanceCard(Player player){
		int num = (int)(Math.random() * 5) + 1;
		String chanceCard = "";
		switch (num){
		case 1:
			chanceCard = "Go directly to Jail.";
			player.setSpace(10);
			break;
		case 2:
			chanceCard = "Bank pays you dividend of 50 credits.";
			player.setCredits( player.getCredits() + 50);
			break;
		case 3:
			chanceCard = "Go back 3 spaces.";
			player.setSpace(player.getIndexSpace()-3);
			break;
		case 4:
			chanceCard = "You have won a crossword competition. Collect 10 credits.";
			player.setCredits( player.getCredits() + 10);
			break;
		case 5:
			chanceCard = "You have been elected Chairman of the Board. Collect 100 credits.";
			player.setCredits( player.getCredits() + 100);
			break;
		}
		return chanceCard;
	}
	
	/**
	 * It draws community chest card
	 * @param player
	 */
	public static String drawCommunityChestCard(Player player){
		int num = (int)( Math.random() * 5) + 1;
		String communityChestCard = "";
		switch (num){
		case 1:
			communityChestCard = "Bank error in your favor. Collect 200 credits.";
			player.setCredits( player.getCredits() + 200);
			break;
		case 2:
			communityChestCard = "From sale of stock, you get 50 credits.";
			player.setCredits( player.getCredits() + 50);
			break;
		case 3:
			communityChestCard = "Go directly to Jail.";
			player.setSpace(10);
			break;
		case 4:
			communityChestCard = "Holiday Fund matures. Receive 100 credits.";
			player.setCredits( player.getCredits() + 100);
			break;
		case 5:
			communityChestCard = "Income tax refund. Collect 20 credits.";
			player.setCredits( player.getCredits() + 20);
			break;
		}
		return communityChestCard;
	}
	
}