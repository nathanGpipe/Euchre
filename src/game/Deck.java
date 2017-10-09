package game;

import java.util.ArrayList;
import java.util.Collections;

//import javax.smartcardio.Card;

/**
 * 
 * @author 
 *
 */
public class Deck {

	/**
	 * Collection of all active cards
	 */
	private ArrayList<Card> cards;
<<<<<<< HEAD
	/**
	 * 
	 */
	private String[] cardNames = {"One", "Two", "Three"};
	
=======

>>>>>>> branch 'master' of https://github.com/nathanGpipe/Euchre
	/**
	 * Collection of cards that are not active in the game
	 */
	private ArrayList<Card> discard;

	/**
	 * Initializes a 24 card Euchre deck.
	 */
	public Deck() {
<<<<<<< HEAD
		//
		Suit curSuit = Suit.HEARTS;
		for (int i = 1; i < 14; i++) {
			Card curCard = new Card("", i, curSuit);
		}
=======
		// Creating hearts
		cards.add(new Card("Nine", 9, Suit.HEARTS));
		cards.add(new Card("Ten", 10, Suit.HEARTS));
		cards.add(new Card("Jack", 11, Suit.HEARTS));
		cards.add(new Card("Queen", 12, Suit.HEARTS));
		cards.add(new Card("King", 13, Suit.HEARTS));
		cards.add(new Card("Ace", 14, Suit.HEARTS));

		// Creating diamonds
		cards.add(new Card("Nine", 9, Suit.DIAMONDS));
		cards.add(new Card("Ten", 10, Suit.DIAMONDS));
		cards.add(new Card("Jack", 11, Suit.DIAMONDS));
		cards.add(new Card("Queen", 12, Suit.DIAMONDS));
		cards.add(new Card("King", 13, Suit.DIAMONDS));
		cards.add(new Card("Ace", 14, Suit.DIAMONDS));

		// Creating clubs
		cards.add(new Card("Nine", 9, Suit.CLUBS));
		cards.add(new Card("Ten", 10, Suit.CLUBS));
		cards.add(new Card("Jack", 11, Suit.CLUBS));
		cards.add(new Card("Queen", 12, Suit.CLUBS));
		cards.add(new Card("King", 13, Suit.CLUBS));
		cards.add(new Card("Ace", 14, Suit.CLUBS));

		// Creating spades
		cards.add(new Card("Nine", 9, Suit.SPADES));
		cards.add(new Card("Ten", 10, Suit.SPADES));
		cards.add(new Card("Jack", 11, Suit.SPADES));
		cards.add(new Card("Queen", 12, Suit.SPADES));
		cards.add(new Card("King", 13, Suit.SPADES));
		cards.add(new Card("Ace", 14, Suit.SPADES));
>>>>>>> branch 'master' of https://github.com/nathanGpipe/Euchre
	}

	/**
	 * Shuffles the order of the active cards in cards
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * 
	 * @param c
	 * The card to be moved from the draw deck to the discard pile.
	 */
	public void discard(final Card c) {
		cards.remove(c);
		discard.add(c);
	}

	/**
	 * 
	 * @return thing
	 */
	public Card deal() {
		
		return null;
	}

}
