package edu.iit.itmd510;

import org.junit.Assert;
import org.junit.Test;

/**
 * Monopoly Test Game
 * @author Lazaro Sanchez Campos
 * @version 10/25/2015
 */
public class MonopolyTest {
	private Dice[] dice = { new Dice(), new Dice()};
	private Player player1 = new Player();
	private Player player2 = new Player();
	private Player player3 = new Player();
	private Player player4 = new Player();
	
	@Test
	public void landingOnStCharlesPlacePays140Credits() {
		//given
			player1.setSpace(5);
		//when
			dice[0].setRoll(3);
			dice[1].setRoll(3);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			Monopoly.updatePlayer(player1);
		//then
			Assert.assertEquals(player1.getCredits(),140);
	}
	
	@Test
	public void landingOnElectricCompanyWith10Pays50Credits(){
		//given
			player1.setSpace(2);
		//when
			dice[0].setRoll(5);
			dice[1].setRoll(5);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			Monopoly.totalRoll = totalRoll;
			Monopoly.updatePlayer(player1);
		//then
			Assert.assertEquals(player1.getCredits(),50);
	}
	
	@Test
	public void landingOnWaterWorksWith10Pays100Credits(){
		//given
			player1.setSpace(18);
		//when
			dice[0].setRoll(5);
			dice[1].setRoll(5);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			Monopoly.totalRoll = totalRoll;
			Monopoly.updatePlayer(player1);
		//then
			Assert.assertEquals(player1.getCredits(),100);
	}
	
	@Test
	public void landingOneTimeOnRailroadSpacesPays200Credits() {
		//given
			player1.setSpace(3);
			player2.setSpace(13);
			player3.setSpace(23);
			player4.setSpace(33);
		//when
			dice[0].setRoll(1);
			dice[1].setRoll(1);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			player2.move(totalRoll);
			player3.move(totalRoll);
			player4.move(totalRoll);
			Monopoly.updatePlayer(player1);
			Monopoly.updatePlayer(player2);
			Monopoly.updatePlayer(player3);
			Monopoly.updatePlayer(player4);
		//then
			Assert.assertEquals(player1.getCredits(),200);
			Assert.assertEquals(player2.getCredits(),200);
			Assert.assertEquals(player3.getCredits(),200);
			Assert.assertEquals(player4.getCredits(),200);
	}
	
	@Test
	public void landingTwoTimesOnRailroadSpacesPays400Credits() {
		//given
			player1.setSpace(4);
		//when
			dice[0].setRoll(5);
			dice[1].setRoll(6);
			int totalRoll1 = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll1);
			Monopoly.updatePlayer(player1);
			dice[0].setRoll(5);
			dice[1].setRoll(5);
			int totalRoll2 = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll2);
		//then
			Assert.assertEquals(Monopoly.updatePlayer(player1),400);
			Assert.assertEquals(player1.getTimesRailroads(),2);
	}
	
	@Test
	public void landingThreeTimesOnRailroadSpacesPays600Credits() {
		//given
			player1.setSpace(4);
		//when
			dice[0].setRoll(5);
			dice[1].setRoll(6);
			int totalRoll1 = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll1);
			Monopoly.updatePlayer(player1);
			dice[0].setRoll(5);
			dice[1].setRoll(5);
			int totalRoll2 = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll2);
			Monopoly.updatePlayer(player1);
			player1.move(totalRoll2);
		//then
			Assert.assertEquals(Monopoly.updatePlayer(player1),600);
			Assert.assertEquals(player1.getTimesRailroads(),3);
	}
	
	@Test
	public void landingFourTimesOnRailroadSpacesPays800Credits() {
		//given
			player1.setSpace(3);
		//when
			dice[0].setRoll(1);
			dice[1].setRoll(1);
			int totalRoll1 = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll1);
			Monopoly.updatePlayer(player1);
			dice[0].setRoll(5);
			dice[1].setRoll(5);
			int totalRoll2 = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll2);
			Monopoly.updatePlayer(player1);
			player1.move(totalRoll2);
			Monopoly.updatePlayer(player1);
			player1.move(totalRoll2);
		//then
			Assert.assertEquals(Monopoly.updatePlayer(player1),800);
			Assert.assertEquals(player1.getTimesRailroads(),4);
	}
	
	@Test
	public void landingOnGoToJailMovesPlayerToJustVisiting() {
		//given
			player1.setSpace(26);
		//when
			dice[0].setRoll(2);
			dice[1].setRoll(2);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			Monopoly.updatePlayer(player1);
		//then
			Assert.assertEquals(player1.getIndexSpace(),10);
	}

	@Test
	public void landingOnLuxuryTaxOrIncomeTaxPays200Or100Credits(){
		//given
			player1.setSpace(1);
			player2.setSpace(35);
		//when
			dice[0].setRoll(1);
			dice[1].setRoll(2);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			player2.move(totalRoll);
			Monopoly.updatePlayer(player1);
			Monopoly.updatePlayer(player2);
		//then
			Assert.assertEquals(player1.getCredits(),200);
			Assert.assertEquals(player2.getCredits(),100);
	}

	@Test
	public void passingOrLandingOnGoSpacePays200Credits(){
		//given
			player1.setSpace(36);
			player2.setSpace(37);
		//when
			dice[0].setRoll(2);
			dice[1].setRoll(2);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			player2.move(totalRoll);
			Monopoly.updatePlayer(player1);
			Monopoly.updatePlayer(player2);
		//then
			Assert.assertEquals(player1.getCredits(),200);
			Assert.assertEquals(player2.getCredits(),200);
	}
	
	@Test
	public void landingOnJustVisitingOrFreeParkingSpacesDoNotPayCredits(){
		//given
			player1.setSpace(4);
			player2.setSpace(14);
		//when
			dice[0].setRoll(3);
			dice[1].setRoll(3);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			player2.move(totalRoll);
			Monopoly.updatePlayer(player1);
			Monopoly.updatePlayer(player2);
		//then
			Assert.assertEquals(player1.getCredits(),0);
			Assert.assertEquals(player2.getCredits(),0);
	}
	
	@Test
	public void testingDrawingChanceCards(){
		//given
			player1.setSpace(4);
		//when
			dice[0].setRoll(2);
			dice[1].setRoll(1);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			String message = Monopoly.drawChanceCard(player1);
		//then
			if(message == "Go directly to Jail."){
				Assert.assertEquals(player1.getCredits(),0);
			}
			else if(message == "Bank pays you dividend of 50 credits."){
				Assert.assertEquals(player1.getCredits(),50);
			}
			else if(message == "Go back 3 spaces."){
				Assert.assertEquals(player1.getIndexSpace(),4);
			}
			else if(message == "You have won a crossword competition. Collect 10 credits."){
				Assert.assertEquals(player1.getCredits(),10);
			}
			else if (message == "You have been elected Chairman of the Board. Collect 100 credits."){
				Assert.assertEquals(player1.getCredits(),100);
			}
	}
	
	@Test
	public void testingDrawingCommunityChestCards(){
		//given
			player1.setSpace(14);
		//when
			dice[0].setRoll(2);
			dice[1].setRoll(1);
			int totalRoll = dice[0].getRoll() + dice[1].getRoll();
			player1.move(totalRoll);
			String message = Monopoly.drawCommunityChestCard(player1);
		//then
			if(message == "Bank error in your favor. Collect 200 credits."){
				Assert.assertEquals(player1.getCredits(),200);
			}
			else if(message == "From sale of stock, you get 50 credits."){
				Assert.assertEquals(player1.getCredits(),50);
			}
			else if(message == "Go directly to Jail."){
				Assert.assertEquals(player1.getIndexSpace(),10);
			}
			else if(message == "Holiday Fund matures. Receive 100 credits."){
				Assert.assertEquals(player1.getCredits(),100);
			}
			else if (message == "Income tax refund. Collect 20 credits."){
				Assert.assertEquals(player1.getCredits(),20);
			}
	}

}