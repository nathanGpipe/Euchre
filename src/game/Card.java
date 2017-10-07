package game;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 * Class for 
 */

public class Card implements Comparable<Card> {
	
	/**
	 * Written value of the card (Eight, Queen, etc.)
	 */
	private String name;
	
	/**
	 * Value of the card (Jack = 11, Queen = 12, King = 13, Ace = 14)
	 */
	private int value;
	
	/**
	 * Hearts, Diamonds, Clubs, or Spades
	 */
	private Suit suit;
	
	/**
	 * @return The cards value.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * @return The cards name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The cards suit.
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * @param n The cards name.
	 * @param v The cards value.
	 * @param s The cards suit.
	 */
	public Card(final String n, final int v, final Suit s) {
		name = n;
		value = v;
		suit = s;
	}
	
	/**
	 * @param c The card which you wish to compare to.
	 * @return Returns the difference between the two cards values.
	 */
	public int compareTo(final Card c) {
		return this.value - c.getValue();
	}
	
	/**
	 * @return Returns information about the object in string form.
	 */
	public String toString() {
		return name + " of " + suit;
	}

}
