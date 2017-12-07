package game;

import java.util.ArrayList;

/**
 * Class to store data pertaining to each player.
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford 
 */
public class Player {

	/**
	 * ArrayList of playable cards for the given player.
	 */
	private ArrayList<Card> hand;

	/**
	 * Partner of the player.
	 */
	private Player partner;

	/**
	 * Constructs a player object.
	 */
	public Player() {
		hand = new ArrayList<Card>(5);
		partner = null;
	}

	/**
	 * Chooses a suit to be trump based on quantity of bowers in hand and/or
	 * frequency of suits.
	 * 
	 * @return The desired suit to be trump, or NULL if no choice.
	 */
	public Suit chooseTrump() {
		return getFavoriteSuit();
	}

	/**
	 * Chooses whether or not to have the dealer pick up the initial card.
	 * 
	 * @param c
	 *            The card to check for the dealer to pick up.
	 * @return True if the player wants them to pick it up.
	 */
	public boolean pickUp(final Card c) {
		if (getFavoriteSuit() == c.getSuit()) {
			return true;
		}
		return false;
	}

	/**
	 * Swaps the card on top of the discard pile with one in the player's
	 * hand.
	 * 
	 * @param c
	 *            The card on top of the discard pile.
	 */
	public void swap(final Card c) {
		hand.remove(getWorstCard(c.getSuit()));
		addToHand(c);
	}

	/**
	 * Looks at what cards are on the table and chooses which card to play.
	 * 
	 * @param table
	 *            An ArrayList of cards that have been played this trick.
	 * @param trump
	 *            The trump suit of this round.
	 * @return A card from the player's hand that they choose to play.
	 */
	public Card choosePlay(final ArrayList<Card> table, final Suit trump) {

		if (table.size() == 0) {
			return hand.remove(leadTurn(trump));
		} else {
			Suit follow = table.get(0).getSuit();
			return hand.remove(followSuit(follow, trump));
		}
	}

	/**
	 * Adds a card to the player's hand.
	 * 
	 * @param c
	 *            The card to be added to the hand.
	 */
	public void addToHand(final Card c) {
		hand.add(c);
	}

	/**
	 * Accessor method for hand.
	 * 
	 * @return ArrayList of the cards in the players hand.
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}

	/**
	 * Sets the partner for this player and the partner for the Player in
	 * the parameter's partner to this Player.
	 * 
	 * @param p
	 *            The partner of the player.
	 */
	public void setPartner(final Player p) {
		partner = p;
		p.partner = this;
	}

	/**
	 * Accessor method for partner instance variable.
	 * 
	 * @return Partner of the player.
	 */
	public Player getPartner() {
		return partner;
	}

	/**
	 * Private helper method to assist in AI functions.
	 * 
	 * @return the preferred suit, given the player's hand
	 */
	public Suit getFavoriteSuit() {
		int numClubs = 0;
		int numSpades = 0;
		int numDiamonds = 0;
		int numHearts = 0;

		int numBlackBowers = 0;
		int numRedBowers = 0;

		// Counting number of cards in each suit and number of bowers.
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getSuit() == Suit.CLUBS) {
				numClubs++;
				if (hand.get(i).getName().equals("Jack")) {
					numBlackBowers++;
				}
			}
			if (hand.get(i).getSuit() == Suit.SPADES) {
				numSpades++;
				if (hand.get(i).getName().equals("Jack")) {
					numBlackBowers++;
				}
			}
			if (hand.get(i).getSuit() == Suit.DIAMONDS) {
				numDiamonds++;
				if (hand.get(i).getName().equals("Jack")) {
					numRedBowers++;
				}
			}
			if (hand.get(i).getSuit() == Suit.HEARTS) {
				numHearts++;
				if (hand.get(i).getName().equals("Jack")) {
					numRedBowers++;
				}
			}
		}

		// Deciding on suit to pick based on counts.
		if (numRedBowers == 2) {
			if (numHearts > numDiamonds) {
				return Suit.HEARTS;
			}
			return Suit.DIAMONDS;
		} else if (numBlackBowers == 2) {
			if (numSpades > numClubs) {
				return Suit.SPADES;
			}
			return Suit.CLUBS;
		} else if (numClubs >= 3) {
			return Suit.CLUBS;
		} else if (numSpades >= 3) {
			return Suit.SPADES;
		} else if (numDiamonds >= 3) {
			return Suit.DIAMONDS;
		} else if (numHearts >= 3) {
			return Suit.HEARTS;
		} else {
			return null;
		}
	}

	/**
	 * Looks at the player's hand and finds the lowest off-suit card it can.
	 * 
	 * @param trump
	 *            The current trump suit.
	 * @return The index of the Player's worst card
	 */
	private int getWorstCard(final Suit trump) {
		Card current = hand.get(0);
		int index = 0;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getSuit() != trump 
					|| current.getSuit() == trump) {
				if (hand.get(i).getValue() < current.getValue() 
						|| current.getSuit() == trump) {
					current = hand.get(i);
					index = i;
				}
			}
		}
		return index;
	}

	/**
	 * Player chooses their highest off-suit card.
	 * 
	 * @param trump
	 *            The current trump suit.
	 * @return The index of the card to lead the turn with.
	 */
	private int leadTurn(final Suit trump) {
		Card current = hand.get(0);
		int index = 0;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getSuit() != trump 
					&& hand.get(i).getValue() 
					> current.getValue()) {
				current = hand.get(i);
				index = i;
			}
		}
		return index;
	}

	/**
	 * Player chooses their best card of the 
	 * current suit or throws their lowest trump card.
	 * 
	 * @param current
	 *            The suit that the turn was lead with.
	 * @param trump
	 *            The current trump suit.
	 * @return The index of card to play.
	 */
	private int followSuit(final Suit current, final Suit trump) {
		Card c = hand.get(0);
		int index = 0;

		// Finds a card to follow with
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getSuit() == current) {
				c = hand.get(i);
				index = i;
				break;
			}
		}

		// Finds the best card of that suit to play
		for (int i = index; i < hand.size(); i++) {
			if (hand.get(i).getSuit() == current 
					&& hand.get(i).getValue() 
					> c.getValue()) {
				c = hand.get(i);
				index = i;
				break;
			}
		}

		// If it can't follow suit then it plays a trump card
		if (c.getSuit() != current) {
			for (int i = index; i < hand.size(); i++) {
				if (hand.get(i).getSuit() == trump) {
					c = hand.get(i);
					index = i;
					break;
				}
			}
			
			// It looks for its lowest trump card to play
			for (int i = index; i < hand.size(); i++) {
				if (hand.get(i).getSuit() == trump 
						&& hand.get(i).getValue() 
						< c.getValue()) {
					c = hand.get(i);
					index = i;
				}
			}
		}
		return index;
	}
}
