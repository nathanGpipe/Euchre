package game;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 *
 */
public class Card implements Comparable<Card>{
	
	private String name;
	private int value;
	private Suit suit;
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Card(String n, int v, Suit s) {
		name = n;
		value = v;
		suit = s;
	}
	
	/**
	 * 
	 * @return Returns the difference between the two cards values.
	 */
	public int compareTo(final Card c) {
		return this.value - c.getValue();
	}
}
