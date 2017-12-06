package game;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 * Enumerated class consisting of various game states.
 */
public enum GameState {
	/**
	 * The very beginning of the game.
	 */
	BEGINNINGPHASE, 
	
	/**
	 * The player needs to decide whether or not
	 * they want the top card.
	 */
	PLAYERSTOPCARD,
	
	/**
	 * The player needs to decide whether or not
	 * they want the dealer to have the top card.
	 */
	DEALERSTOPCARD,
	
	/**
	 * The player needs to pick a suit for trump.
	 */
	PLAYERSUIT,
	
	/**
	 * The player needs to swap a card from their hand
	 * for the top card.
	 */
	PLAYERSWAP,
	
	/**
	 * The game needs to go through a round of deciding trump
	 */
	TRUMPCHOICE,
	
	/**
	 * The trump is chosen and it is time for the round
	 * to be played.
	 */
	ROUND
}
