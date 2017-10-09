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
	 * Constructs a player object.
	 */
	public Player() {
		hand = new ArrayList<Card>(5);
		partner = null;
	}
	
	/**
	 * Looks at what cards are on the table and chooses which card to play.
	 * 
	 * @param table An ArrayList of cards that have been played this trick.
	 * @param trump The trump suit of this round.
	 * @return A card from the player's hand that they choose to play.
	 */
	public Card choosePlay(final ArrayList<Card> table, final Suit trump) {
		int index = 0;
		return hand.remove(index);
	}
	
	/**
	 * Adds a card to the player's hand.
	 * @param c The card to be added to the hand.
	 */
	public void addToHand(final Card c) {
		hand.add(c);
	}
	
	/**
	 * Accessor method for hand.
	 * @return ArrayList of the cards in the players hand.
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	/**
	 * Sets the partner for this player.
	 * 
	 * @param p The partner of the player.
	 */
	public void setPartner(final Player p) {
		partner = p;
	}
	
	/**
	 * Accessor method for partner instance variable.
	 * @return Partner of the player.
	 */
	public Player getPartner() {
		return partner;
	}
}
