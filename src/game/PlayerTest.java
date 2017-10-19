package game;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

/**
 * JUnit test cases for the Player class.
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 */
public class PlayerTest {


	Player p1 = new Player();
	Player p2 = new Player();
	

	Card c1 = new Card("King", 13, Suit.HEARTS);
	Card c2 = new Card("Jack", 11, Suit.HEARTS);
	Card c3 = new Card("Jack", 11, Suit.DIAMONDS);
	Card c4 = new Card("Nine", 9, Suit.CLUBS);
	Card c5 = new Card("Ten", 10, Suit.SPADES);
	
	ArrayList<Card> hand1 = new ArrayList<Card>();
	
	

	/**
	 * Test method for {@link game.Player#chooseTrump()}.
	 */
	@Test
	public void testChooseTrump1() {
		for (int i = 0; i < hand1.size(); i++) {
			p1.addToHand(hand1.get(i));
		}
		assertEquals("Failed to choose proper trump", Suit.HEARTS, 
				p1.chooseTrump());
	}

	/**
	 * Test method for {@link game.Player#pickUp(game.Card)}.
	 */
	@Test
	public void testPickUp() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Player#swap(game.Card)}.
	 */
	@Test
	public void testSwap() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for 
	 * {@link game.Player#choosePlay(java.util.ArrayList, game.Suit)}.
	 */
	@Test
	public void testChoosePlay() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game.Player#addToHand(game.Card)}.
	 */
	@Test
	public void testAddToHand() {
		p1.addToHand(c1);
		ArrayList<Card> hand = p1.getHand();
		assertTrue("Failed to add to hand.", hand.contains(c1));
	}

	/**
	 * Test method for {@link game.Player#getHand()}.
	 */
	@Test
	public void testGetHand() {
		p1.addToHand(c1);
		ArrayList<Card> hand = p1.getHand();
		assertTrue("Failed to get hand.", hand.contains(c1));
	}

	/**
	 * Test method for {@link game.Player#setPartner(game.Player)}.
	 */
	@Test
	public void testSetPartner() {
		p1.setPartner(p2);
		assertEquals(p1.getPartner(), p2);
	}

	/**
	 * Test method for {@link game.Player#getPartner()}.
	 */
	@Test
	public void testGetPartner() {
		p1.setPartner(p2);
		assertEquals(p1.getPartner(), p2);
	}

}
