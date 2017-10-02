package game;

import java.util.ArrayList;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 *
 */
public class Deck {
	
	/**
	 * 
	 */
	private ArrayList<Card> cards;
	
	/**
	 * 
	 */
	private ArrayList<Card> discard;
	
	
	/**
	 * Initializes a 24 card Euchre deck.
	 */
	public Deck() {
		
	}
	
	
	/**
	 * 
	 */
	public void shuffle() {
		
	}
	
	/**
	 * 
	 * @param c The card to be moved from the draw deck to the discard pile.
	 */
	public void discard(final Card c) {
		cards.remove(c);
		discard.add(c);
	}

	
	/**
	 * 
	 * @return The card delt out of the deck.
	 */
	public Card deal() {
		
		return null;
	}
	
}
