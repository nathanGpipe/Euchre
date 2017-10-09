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
	 * Collection of all active cards.
	 */
	private ArrayList<Card> cards;
	/**
	 * 
	 */
	private String[] cardNames = {"One", "Two", "Three"};
	
	/**
	 * Collection of cards that are not active in the game.
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
	 * Shuffles the order of the active cards in cards.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/** 
	 * Removes a card from the deck and puts it in the discard pile.
	 * 
	 * @param c The card to be discarded.
	 * @return c The card that was discarded.
	 */
	public Card discard(final Card c) {
		cards.remove(c);
		discard.add(c);
		return c;
	}

	/**
	 * Sends the card at the top of the deck to be dealt.
	 * @return The card at the top of the deck.
	 */
	public Card deal() {
		return discard(cards.get(0));
	}

}
