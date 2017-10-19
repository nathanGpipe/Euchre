package game;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * JUnit test cases for the EuchreGame class.
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 */

public class EuchreGameTest {

	/**
	 * Tests that the method returns true if
	 * the dealer is the player.
	 */
	@Test
	public void testDealerCard1() {
		EuchreGame g = new EuchreGame();
		g.deal();
		while (g.getPlayers()[1].getFavoriteSuit() == null) {
			g = new EuchreGame();
			g.deal();
		}
		g.setDealerIndex(0);
		Card c = new Card("Jack of Hearts", 
				11, g.getPlayers()[1].getFavoriteSuit());
		g.setTopCard(c);
		assertTrue(g.dealerCard(1));
	}
	
	/**
	 * Tests that the method returns true if
	 * the dealer isn't the player.
	 */
	@Test
	public void testDealerCard2() {
		EuchreGame g = new EuchreGame();
		g.setDealerIndex(1);
		g.deal();
		while (g.getPlayers()[1].getFavoriteSuit() == null) {
			g = new EuchreGame();
			g.setDealerIndex(1);
			g.deal();
		}
		Card c = new Card("Jack of Hearts", 
				11, g.getPlayers()[1].getFavoriteSuit());
		g.setTopCard(c);
		assertTrue(g.dealerCard(1));
	}
	
	/**
	 * Tests that the method returns
	 * false if the player doesn't
	 * want the dealer to pick up
	 * the top card.
	 */
	@Test
	public void testDealerCard3() {
		EuchreGame g = new EuchreGame();
		g.deal();
		while (g.getPlayers()[1].getFavoriteSuit() == null) {
			g = new EuchreGame();
			g.setDealerIndex(1);
			g.deal();
		}
		Card c;
		if (g.getPlayers()[1].getFavoriteSuit() == Suit.HEARTS) {
			c = new Card("Jack of Hearts", 
					11, Suit.CLUBS);
		} else {
			c = new Card("Jack of Hearts", 
					11, Suit.HEARTS);
		}
		g.setTopCard(c);
		assertFalse(g.dealerCard(1));
	}
	
	/**
	 * Tests that the method returns
	 * true when the player chooses a trump.
	 */
	@Test
	public void testChooseTrump1() {
		EuchreGame g = new EuchreGame();
		g.deal();
		while (g.getPlayers()[1].getFavoriteSuit() == null) {
			g = new EuchreGame();
			g.deal();
		}
		assertTrue(g.chooseTrump(1));
	}
	
	/**
	 * Tests that the method returns
	 * false when the player doesn't
	 * choose a trump.
	 */
	@Test
	public void testChooseTrump2() {
		EuchreGame g = new EuchreGame();
		g.deal();
		while (g.getPlayers()[1].getFavoriteSuit() != null) {
			g = new EuchreGame();
			g.deal();
		}
		assertFalse(g.chooseTrump(1));
	}
	
	/**
	 * Tests that makePlay throws
	 * an exception if too many
	 * cards have been played.
	 */
	@Test(expected = IllegalStateException.class) 
	public void testMakePlay1() {
		EuchreGame g = new EuchreGame();
		ArrayList<Card> cList = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			Card c = new Card("", 0, Suit.HEARTS);
			cList.add(c);
		}
		g.setCardsPlayed(cList);
		g.makePlay(1);
	}
	
//	/**
//	 * Tests that a card is added
//	 * to cardsPlayed after makePlay
//	 * is called.
//	 */
//	@Test
//	public void testMakePlay2() {
//		EuchreGame g = new EuchreGame();
//		ArrayList<Card> cList = new ArrayList<Card>();
//		for (int i = 0; i < 2; i++) {
//			Card c = new Card("", 0, Suit.HEARTS);
//			cList.add(c);
//		}
//		g.setCardsPlayed(cList);
//		g.makePlay(1);
//		assertTrue(g.getCardsPlayed().size() == 3);
//	}
	
	/**
	 * This test checks that an error
	 * is thrown when fewer than 4 cards
	 * are played.
	 */
	@Test(expected = IllegalStateException.class) 
	public void testCheckWin1() {
		EuchreGame g = new EuchreGame();
		ArrayList<Card> cList = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
			Card c = new Card("", 0, Suit.HEARTS);
			cList.add(c);
		}
		g.setCardsPlayed(cList);
		g.checkWin();
	}
	
	/**
	 * This test checks that an error
	 * is thrown when more than 4 cards
	 * are played.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCheckWin2() {
		EuchreGame g = new EuchreGame();
		ArrayList<Card> cList = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			Card c = new Card("", 0, Suit.HEARTS);
			cList.add(c);
		}
		g.setCardsPlayed(cList);
		g.checkWin();
	}
	
	/**
	 * This test checks that team 1's score
	 * increases when they play the only
	 * trump card (only 1 trump is played).
	 */
	@Test
	public void testCheckWin3() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 9, Suit.CLUBS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * testCheckWin3 with team 2 winning.
	 */
	@Test
	public void testCheckWin3A() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(2);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 9, Suit.CLUBS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2points() == 1);
	}
	
	/**
	 * testCheckWin3 with index 0 winning.
	 */
	@Test
	public void testCheckWin3B() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(3);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 9, Suit.CLUBS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * This test checks that team 1's score
	 * increases when they play the left
	 * bower and more than one
	 * trump card has been played.
	 */
	@Test
	public void testCheckWin4() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 11, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 9, Suit.HEARTS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * testCheckWin4 with team 2 winning.
	 */
	@Test
	public void testCheckWin4A() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(2);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 11, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 9, Suit.HEARTS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2points() == 1);
	}
	
	/**
	 * testCheckWin4 with index 0 winning.
	 */
	@Test
	public void testCheckWin4B() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(3);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 11, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 9, Suit.HEARTS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * This test checks that team 1's score
	 * increases when they play the left
	 * bower, more than one
	 * trump card has been played,
	 * and the other team plays the right
	 * bower.
	 */
	@Test
	public void testCheckWin5() {
		EuchreGame g = new EuchreGame();
		g.getDealerIndex();
		g.getCardsPlayed();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 11, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 11, Suit.DIAMONDS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		g.getTrump();
		g.getTopCard();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * This test checks that team 2's score
	 * increases when they play the right
	 * bower, more than one
	 * trump card has been played,
	 * and the left bower has not
	 * been played.
	 */
	@Test
	public void testCheckWin6() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 11, Suit.DIAMONDS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2points() == 1);
	}
	
	/**
	 * Same as testCheckWin6 but checking
	 * getOpTrump() for diamonds instead
	 * of hearts, and checking for team 1's
	 * points.
	 */
	@Test
	public void testCheckWin6A() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.DIAMONDS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 11, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 9, Suit.DIAMONDS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * Same as testCheckWin6 but checking
	 * getOpTrump() for clubs instead
	 * of hearts, and having index 0 win.
	 */
	@Test
	public void testCheckWin6B() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.CLUBS);
		g.setDealerIndex(2);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.CLUBS);
		cList.add(a);
		Card b = new Card("", 11, Suit.SPADES);
		cList.add(b);
		Card c = new Card("", 10, Suit.HEARTS);
		cList.add(c);
		Card d = new Card("", 11, Suit.HEARTS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * Same as testCheckWin6 but checking
	 * getOpTrump() for spades instead
	 * of hearts.
	 */
	@Test
	public void testCheckWin6C() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.SPADES);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 11, Suit.CLUBS);
		cList.add(b);
		Card c = new Card("", 10, Suit.HEARTS);
		cList.add(c);
		Card d = new Card("", 11, Suit.HEARTS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2points() == 1);
	}
	
	/**
	 * This test checks that team 2's score
	 * increases when more than one
	 * trump card has been played,
	 * but neither bower has been
	 * played.
	 */
	@Test
	public void testCheckWin7() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 10, Suit.HEARTS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2points() == 1);
	}
	
	/**
	 * testCheckWin7 with team 1 winning.
	 */
	@Test
	public void testCheckWin7A() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 12, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 10, Suit.HEARTS);
		cList.add(b);
		Card c = new Card("", 12, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * testCheckWin7 with index 0 winning.
	 */
	@Test
	public void testCheckWin7B() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(3);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 12, Suit.HEARTS);
		cList.add(a);
		Card b = new Card("", 10, Suit.HEARTS);
		cList.add(b);
		Card c = new Card("", 12, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * This test checks that team 1's score
	 * increases when no trump cards have been
	 * played and nobody matched the suit
	 * of the first player.
	 */
	@Test
	public void testCheckWin8() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.DIAMONDS);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * testCheckWin8 but with team 2 winning.
	 */
	@Test
	public void testCheckWin8A() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(2);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.DIAMONDS);
		cList.add(b);
		Card c = new Card("", 12, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2points() == 1);
	}
	
	/**
	 * testCheckWin8 but with index 0 winning.
	 */
	@Test
	public void testCheckWin8B() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(3);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.DIAMONDS);
		cList.add(b);
		Card c = new Card("", 12, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * This test checks that team 2's score
	 * increases when no trump cards have been
	 * played, two cards matched the suit the
	 * first player played, and team 2's
	 * card was higher. 
	 */
	@Test
	public void testCheckWin9() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 12, Suit.SPADES);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2points() == 1);
	}
	
	/**
	 * testCheckWin9 with team 1 winning.
	 */
	@Test
	public void testCheckWin9A() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 12, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.SPADES);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * testCheckWin9 with person 2 winning.
	 */
	@Test
	public void testCheckWin9B() {
		EuchreGame g = new EuchreGame();
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 9, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.CLUBS);
		cList.add(b);
		Card c = new Card("", 10, Suit.SPADES);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1points() == 1);
	}
	
	/**
	 * Tests the last of the code in
	 * checkWin for team 1 winning the
	 * trick to make sure team 1's score
	 * increases.
	 */
	@Test
	public void testCheckGameWin1() {
		EuchreGame g = new EuchreGame();
		g.setTeam1points(4);
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(1);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 12, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.SPADES);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam1score() == 1);
	}
	
	/**
	 * Tests the last of the code in
	 * checkWin for team 2 winning the
	 * trick to make sure team 2's score
	 * increases.
	 */
	@Test
	public void testCheckGameWin1A() {
		EuchreGame g = new EuchreGame();
		g.setTeam2points(4);
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(2);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 12, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.SPADES);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getTeam2score() == 1);
	}
	
	/**
	 * Tests the last of the code in
	 * checkWin for team 1 winning the
	 * game to make sure the gameState
	 * changes.
	 */
	@Test
	public void testCheckGameWin2() {
		EuchreGame g = new EuchreGame();
		g.setTeam1points(4);
		g.setTeam1score(9);
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(3);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 12, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.SPADES);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getGameState() == 1);
	}
	
	/**
	 * Tests the last of the code in
	 * checkWin for team 2 winning the
	 * trick to make sure the gameState
	 * changes.
	 */
	@Test
	public void testCheckGameWin2A() {
		EuchreGame g = new EuchreGame();
		g.setTeam2points(4);
		g.setTeam2score(9);
		g.setTrump(Suit.HEARTS);
		g.setDealerIndex(2);
		
		ArrayList<Card> cList = new ArrayList<Card>();
		Card a = new Card("", 12, Suit.SPADES);
		cList.add(a);
		Card b = new Card("", 9, Suit.SPADES);
		cList.add(b);
		Card c = new Card("", 10, Suit.CLUBS);
		cList.add(c);
		Card d = new Card("", 11, Suit.CLUBS);
		cList.add(d);
		
		g.setCardsPlayed(cList);
		g.checkWin();
		assertTrue(g.getGameState() == 2);
	}
}
