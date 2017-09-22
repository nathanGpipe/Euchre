package game;

public class Card implements Comparable<Card>{
	
	private String name;
	private int value;
	private Suit suit;
	
	public int getValue() {
		return value;
	}
	
	
	public Card() {
		
	}
	
	/**
	 * 
	 * @return Returns the difference between the two cards values.
	 */
	public int compareTo(final Card c) {
		
		return this.value - c.getValue();
	}
}
