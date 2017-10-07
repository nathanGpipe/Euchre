package game;

import java.util.ArrayList;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 * Class to store data pertaining to each player.
 */
public class Player {
	
	/**
	 * ArrayList of playable cards for the given player.
	 */
	private ArrayList<Card> hand;
	
	/**
	 * Partner of the player. 
	 */
	private Player partner;

	/**
	 * Accessor method for hand.
	 * @return ArrayList of the cards in the players hand.
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	/**
	 * Accessor method for partner instance variable.
	 * @return Partner of the player.
	 */
	public Player getPartner() {
		return partner;
	}
}
