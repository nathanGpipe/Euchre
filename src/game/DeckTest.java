package game;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * JUnit test cases for the Deck class.
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 */
public class DeckTest {

	/**
	 * Tests the shuffle() class to make sure deck shuffles.
	 */
	@Test
	public void testShuffle() {
		Deck d = new Deck();
		ArrayList<Card> deckBefore = d.getCards();
		d = new Deck(); 
		// so deckBefore and d aren't pointing to same object
		d.shuffle();
		assertFalse(deckBefore.equals(d.getCards()));
	}
	
	/**
	 * Tests the discard() method to see if card is
	 * being put in discard list.
	 */
	@Test
	public void testDiscard1() {
		Deck d = new Deck();
		d.shuffle();
		Card c = d.discard(d.getCards().get(0));
		assertTrue(d.getDiscard().contains(c));
	}
	
	/**
	 * Tests the discard() method to see if card is
	 * being removed from card list.
	 */
	@Test
	public void testDiscard2() {
		Deck d = new Deck();
		d.shuffle();
		Card c = d.discard(d.getCards().get(0));
		assertFalse(d.getCards().contains(c));
	}
	
	/**
	 * Tests resetDeck() to make sure
	 * that the cards dealt were put
	 * back in the deck.
	 */
	@Test
	public void testResetDeck() {
		Deck d = new Deck();
		Card a = d.discard(d.getCards().get(0));
		Card b = d.discard(d.getCards().get(1));
		Card c = d.discard(d.getCards().get(2));
		d.resetDeck();
		assertTrue(d.getCards().contains(a));
		assertTrue(d.getCards().contains(b));
		assertTrue(d.getCards().contains(c));
	}
	
	/**
	 * Tests the to see if deal() returns the first card in the deck.
	 */
	@Test
	public void testDeal1() {
		Deck d = new Deck();
		d.shuffle();
		Card c1 = d.getCards().get(0);
		Card c2 = d.deal();
		assertEquals(c1, c2);
	}
	
	/**
	 * Tests to see if deal() is putting the card into
	 * the discard list.
	 */
	@Test
	public void testDeal2() {
		Deck d = new Deck();
		d.shuffle();
		Card c = d.deal();
		assertTrue(d.getDiscard().contains(c));
	}
}
