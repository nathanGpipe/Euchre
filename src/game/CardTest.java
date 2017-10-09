package game;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test cases for the Card class.
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 */
public class CardTest {

	/**
	 *  Test case for getValue().
	 */
	@Test
	public void testGetValue() {
		Card c = new Card("Nine", 9, Suit.CLUBS);
		int x = c.getValue();
		assertEquals(9, x);
	}

	/**
	 *  Test case for getName().
	 */
	@Test
	public void testGetName() {
		Card c = new Card("Nine", 9, Suit.CLUBS);
		String x = c.getName();
		assertEquals("Nine", x);
	}

	/**
	 *  Test case for getSuit().
	 */
	@Test
	public void testGetSuit() {
		Card c = new Card("Nine", 9, Suit.CLUBS);
		Suit s = c.getSuit();
		assertEquals(Suit.CLUBS, s);
	}

	/**
	 *  Test case for Card() constructor.
	 */
	@Test
	public void testCard() {
		Card c = new Card("Ace", 14, Suit.SPADES);
		assertEquals(Suit.SPADES, c.getSuit());
		assertEquals(14, c.getValue());
		assertEquals("Ace", c.getName());
	}

	/**
	 *  Test case for compareTo().
	 */
	@Test
	public void testCompareTo() {
		Card x = new Card("Queen", 12, Suit.HEARTS);
		Card y = new Card("Ten", 10, Suit.DIAMONDS);
		assertEquals(2, x.compareTo(y));
	}

	/**
	 *  Test case for toString().
	 */
	@Test
	public void testToString() {
		Card x = new Card("Queen", 12, Suit.HEARTS);
		String s = x.toString();
		assertEquals("Queen of HEARTS", s);
	}
}
