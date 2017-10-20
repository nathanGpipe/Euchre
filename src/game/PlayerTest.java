package game;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

/**
 * JUnit test cases for the Player class.
 * 
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 */
public class PlayerTest {

	Card h1 = new Card("Ten", 10, Suit.HEARTS);
	Card h2 = new Card("Jack", 11, Suit.HEARTS);
	Card h3 = new Card("King", 13, Suit.HEARTS);
	Card h4 = new Card("Ace", 14, Suit.HEARTS);

	Card d1 = new Card("Ten", 10, Suit.DIAMONDS);
	Card d2 = new Card("Jack", 11, Suit.DIAMONDS);
	Card d3 = new Card("King", 13, Suit.DIAMONDS);
	Card d4 = new Card("Ace", 14, Suit.DIAMONDS);

	Card c1 = new Card("Ten", 10, Suit.CLUBS);
	Card c2 = new Card("Jack", 11, Suit.CLUBS);
	Card c3 = new Card("King", 13, Suit.CLUBS);
	Card c4 = new Card("Ace", 14, Suit.CLUBS);

	Card s1 = new Card("Ten", 10, Suit.SPADES);
	Card s2 = new Card("Jack", 11, Suit.SPADES);
	Card s3 = new Card("King", 13, Suit.SPADES);
	Card s4 = new Card("Ace", 14, Suit.SPADES);

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpHearts1() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(h3);
		hand1.add(h2);
		hand1.add(d2);
		hand1.add(c1);
		hand1.add(s1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}

		assertEquals(Suit.HEARTS, p1.chooseTrump());

	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpHearts2() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(h3);
		hand1.add(h2);
		hand1.add(h4);
		hand1.add(c1);
		hand1.add(s1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(Suit.HEARTS, p1.chooseTrump());
	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpDiamonds1() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(d3);
		hand1.add(h2);
		hand1.add(d2);
		hand1.add(c1);
		hand1.add(s1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(Suit.DIAMONDS, p1.chooseTrump());
	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpDiamonds2() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(d3);
		hand1.add(d2);
		hand1.add(d4);
		hand1.add(c1);
		hand1.add(s1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(Suit.DIAMONDS, p1.chooseTrump());
	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpClubs1() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(c3);
		hand1.add(s2);
		hand1.add(c2);
		hand1.add(d1);
		hand1.add(h1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(Suit.CLUBS, p1.chooseTrump());
	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpClubs2() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(c3);
		hand1.add(c2);
		hand1.add(c4);
		hand1.add(h1);
		hand1.add(d1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(Suit.CLUBS, p1.chooseTrump());
	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpSpades1() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(s3);
		hand1.add(c2);
		hand1.add(s2);
		hand1.add(d1);
		hand1.add(h1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(Suit.SPADES, p1.chooseTrump());
	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpSpades2() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(s3);
		hand1.add(s2);
		hand1.add(s4);
		hand1.add(h1);
		hand1.add(d1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(Suit.SPADES, p1.chooseTrump());
	}

	/**
	 * Test method for chooseTrump().
	 */
	@Test
	public void testChooseTrumpPass() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(s3);
		hand1.add(c1);
		hand1.add(s1);
		hand1.add(h1);
		hand1.add(d1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals(null, p1.chooseTrump());
	}

	/**
	 * Test method for pickUp().
	 */
	@Test
	public void testPickUp1() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();

		hand1.add(h3);
		hand1.add(h2);
		hand1.add(d2);
		hand1.add(c1);
		hand1.add(s1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}

		assertTrue(p1.pickUp(h4));
	}

	/**
	 * Test method for pickUp().
	 */
	@Test
	public void testPickUp2() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(c3);
		hand1.add(c2);
		hand1.add(c4);
		hand1.add(h1);
		hand1.add(d1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}

		assertFalse(p1.pickUp(d2));
	}

	/**
	 * Test method for swap().
	 */
	@Test
	public void testSwap() {
		Player p1 = new Player();

		ArrayList<Card> hand1 = new ArrayList<Card>();
		hand1.add(c3);
		hand1.add(c2);
		hand1.add(c4);
		hand1.add(h1);
		hand1.add(d1);

		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}

		Card topOfDeck = new Card("Queen", 12, Suit.CLUBS);
		p1.swap(topOfDeck);

		boolean result = (p1.getHand().contains(topOfDeck)
				&& p1.getHand().size() == 5);

		assertTrue(result);
	}

	/**
	 * Test method for choosePlay().
	 */
	@Test
	public void testChoosePlay1() {
		Player p1 = new Player();
		p1.addToHand(h2);
		p1.addToHand(h3);
		p1.addToHand(c1);
		p1.addToHand(c4);
		p1.addToHand(d1);

		ArrayList<Card> table = new ArrayList<Card>();
		table.add(h1);
		Suit trump = Suit.SPADES;

		assertEquals(h3, p1.choosePlay(table, trump));
	}

	/**
	 * Test method for choosePlay().
	 */
	@Test
	public void testChoosePlay2() {
		Player p1 = new Player();
		p1.addToHand(h3);
		p1.addToHand(h2);
		p1.addToHand(c1);
		p1.addToHand(c4);
		p1.addToHand(d1);

		ArrayList<Card> table = new ArrayList<Card>();
		table.add(s1);
		Suit trump = Suit.HEARTS;

		assertEquals(h2, p1.choosePlay(table, trump));
	}

	/**
	 * Test method for choosePlay().
	 */
	@Test
	public void testChoosePlay3() {
		Player p1 = new Player();
		p1.addToHand(h3);
		p1.addToHand(h2);
		p1.addToHand(c1);
		p1.addToHand(c4);
		p1.addToHand(d1);

		ArrayList<Card> table = new ArrayList<Card>();
		Suit trump = Suit.HEARTS;

		assertEquals(c4, p1.choosePlay(table, trump));
	}

	/**
	 * Test method for addToHand().
	 */
	@Test
	public void testAddToHand() {
		Player p1 = new Player();
		p1.addToHand(h3);
		ArrayList<Card> hand = p1.getHand();
		assertTrue("Failed to add to hand.", hand.contains(h3));
	}

	/**
	 * Test method for getHand().
	 */
	@Test
	public void testGetHand() {
		Player p1 = new Player();
		p1.addToHand(h3);
		ArrayList<Card> hand = p1.getHand();
		assertTrue("Failed to get hand.", hand.contains(h3));
	}

	/**
	 * Test method for setPartner().
	 */
	@Test
	public void testSetPartner() {
		Player p1 = new Player();
		Player p2 = new Player();

		p1.setPartner(p2);
		assertEquals(p1.getPartner(), p2);
	}

	/**
	 * Test method for getPartner().
	 */
	@Test
	public void testGetPartner() {
		Player p1 = new Player();
		Player p2 = new Player();

		p1.setPartner(p2);
		assertEquals(p1.getPartner(), p2);
	}

}
