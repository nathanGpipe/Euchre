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
	 * Chooses a suit to be trump.
	 * Judgement based on quantity of 
	 * @return The desired suit to be trump, or NULL if no choice.
	 */
	public Suit chooseTrump() {
		int numClubs = 0;
		int numSpades = 0;
		int numDiamonds = 0;
		int numHearts = 0;
		
		int numBlackBowers = 0;
		int numRedBowers = 0;
		
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getSuit() == Suit.CLUBS) {
				numClubs++;
				if(hand.get(i).getName() == "Jack") 
					numBlackBowers++;
			}
			if(hand.get(i).getSuit() == Suit.SPADES) {
				numSpades++;
				if(hand.get(i).getName() == "Jack") 
					numBlackBowers++;
			}
			if(hand.get(i).getSuit() == Suit.DIAMONDS) {
				numDiamonds++;
				if(hand.get(i).getName() == "Jack") 
					numRedBowers++;
			}
			if(hand.get(i).getSuit() == Suit.HEARTS) {
				numHearts++;
				if(hand.get(i).getName() == "Jack") 
					numRedBowers++;
			}
		}
		
			
			
		
	}
	
	/**
	 * Chooses whether or not to have the dealer pick up the initial card.
	 * @return True if the player wants them to pick it up.
	 */
	public boolean pickUp(Card c) {
		
		return false;
	}
	ost
	discard = new ArrayList<Card>();
	/**
	 * Swaps the card on the top of the discard pile with one
	 * in the player's hand.
	 * 
	 * @param c The card on top of the discard pile.
	 */
	public void swap(final Card c) {
		
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
