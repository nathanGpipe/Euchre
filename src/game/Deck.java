package game;

import java.util.ArrayList;

//import javax.smartcardio.Card;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 *
 */
public class Deck {

	/**
	 * Collection of all active cards
	 */
	private ArrayList<Card> cards;

	/**
	 * Collection of cards that are not active in the game
	 */
	private ArrayList<Card> discard;

	/**
	 * Initializes a 24 card Euchre deck.
	 */
	public Deck() {
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
	}

	/**
	 * Shuffles the order of the active cards in cards
	 */
	public void shuffle() {

	}

	/**
	 * 
	 * @param c
	 *            The card to be moved from the draw deck to the discard pile.
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
