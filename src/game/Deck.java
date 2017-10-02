package game;

import java.util.ArrayList;

/**
 * 
 * @author 
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
	private String[] cardNames = {"One", "Two", "Three"};
	
	/**
	 * Initializes a standard 52 deck of cards.
	 */
	public Deck() {
		//
		Suit curSuit = Suit.HEARTS;
		for (int i = 1; i < 14; i++) {
			Card curCard = new Card("", i, curSuit);
		}
	}
	
	/**
	 * 
	 */
	public void shuffle() {
		
	}
	
	/**
	 * 
	 * @return thing
	 */
	public Card deal() {
		
		return null;
	}
	
}
