package game;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 *
 */

//I'm just making sure I have git configured corrrectly on my laptop
public class Card implements Comparable<Card> {
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private int value;
	
	/**
	 * 
	 */
	private Suit suit;
	
	/**
	 * 
	 * @return The cards value.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * 
	 * @return The cards name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return The cards suit.
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * 
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
