package game;

import java.util.ArrayList;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 *
 */
public class EuchreGame {

	/**
	 * Array that keeps track of the four players.
	 */
	private Player[] players;

	/**
	 * Score for team 1.
	 */
	private int team1score;
	
	/**
	 * Team 1 points during a round.
	 */
	private int team1points;

	/**
	 * Score for team 2.
	 */
	private int team2score;
	
	/**
	 * Team 2 points during a round.
	 */
	private int team2points;

	/**
	 * Index for the player array to keep track of which 
	 * player is the dealer.
	 */
	private int dealerIndex;

	/**
	 * The deck of cards for the game.
	 */
	private Deck cardDeck;
	
	/**
	 * Cards that have been played on the table.
	 */
	private ArrayList<Card> cardsPlayed;
	
	/**
	 * The active trump suit.
	 */
	private Suit trump;
	
	/**
	 * The card on top of the discard pile.
	 */
	private Card topCard;

	/**
	 * 0 - Playing, 1 - Team 1 Wins, 2 - Team 2 wins.
	 */
	private int gameState;

	/**
	 * Runs the Euchre game.
	 */
	public EuchreGame() {
		cardDeck = new Deck();
		players = new Player[4];
		players[0].setPartner(players[2]);
		players[1].setPartner(players[3]);
		players[2].setPartner(players[0]);
		players[3].setPartner(players[1]);

		team1score = 0;
		team2score = 0;

		dealerIndex = (int) (Math.random() * 4);
		
		cardsPlayed = new ArrayList<Card>(4);
		
		trump = null;
		
		gameState = 0;

//		while (team1score < 10 || team2score < 10) {
//			//trick();
//			dealerIndex++;
//			if (dealerIndex == 4) {
//				dealerIndex = 0;
//			}
//		}
	}

	/**
	 * This method asks the player of the given index whether or not
	 * they want the dealer to pick up the top card of the discard
	 * pile.
	 * 
	 * @param index The index of the player to ask.
	 * @return True if they want the dealer to pick the card up,
	 * false if not/
	 */
	public boolean dealerCard(final int index) {
		if (players[index].pickUp(topCard)) {
			trump = topCard.getSuit();
			if (dealerIndex == 0) { 
				// if the dealer is the player don't swap
				return true;
			} else { 
				// have the dealer swap out the top card 
				// for something in their hand
				players[dealerIndex].swap(topCard);
				return true;
			}
		}
		return false;
	}

	/**
	 * Deals the cards.
	 */
	private void deal() {
		for (int i = 0; i < 8; i++) { // two cards to each player
			for (int j = 0; j < 4; j++) { 
				// goes through all four players
				int curDeal = dealerIndex++;
				if (curDeal == 4) {
					curDeal = 0;
				}
				players[curDeal].addToHand(cardDeck.deal());
				players[curDeal].addToHand(cardDeck.deal());
			}
		}
		for (int i = 0; i < 12; i++) { // three cards to each player
			for (int j = 0; j < 4; j++) {
				// goes through all four players
				int curDeal = dealerIndex++;
				if (curDeal == 4) {
					curDeal = 0;
				}
				players[curDeal].addToHand(cardDeck.deal());
				players[curDeal].addToHand(cardDeck.deal());
				players[curDeal].addToHand(cardDeck.deal());
			}
		}
		topCard = cardDeck.deal();
	}

	/**
	 * Returns player objects.
	 * @return The players.
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Sets the players.
	 * @param players The players of the game.
	 */
	public void setPlayers(final Player[] players) {
		this.players = players;
	}

	/**
	 * Returns the score for team 1.
	 * @return Team 1's score.
	 */
	public int getTeam1score() {
		return team1score;
	}

	/**
	 * Sets the score for team 1.
	 * @param team1score The score for team 1 to set.
	 */
	public void setTeam1score(final int team1score) {
		this.team1score = team1score;
	}

	/**
	 * Returns the number of points team 1 has this round.
	 * @return The number of points team 1 has this round.
	 */
	public int getTeam1points() {
		return team1points;
	}

	/**
	 * Sets the number of points team 1 has this round.
	 * @param team1points The number of points to set.
	 */
	public void setTeam1points(final int team1points) {
		this.team1points = team1points;
	}

	/**
	 * Returns the score for team 2.
	 * @return Team 2's score.
	 */
	public int getTeam2score() {
		return team2score;
	}

	/**
	 * Sets the score for team 2.
	 * @param team2score The score for team 2 to set.
	 */
	public void setTeam2score(final int team2score) {
		this.team2score = team2score;
	}

	/**
	 * Returns the number of points team 2 has this round.
	 * @return The number of points team 2 has this round.
	 */
	public int getTeam2points() {
		return team2points;
	}

	/**
	 * Sets the number of points team 2 has this round.
	 * @param team2points The number of points to set.
	 */
	public void setTeam2points(final int team2points) {
		this.team2points = team2points;
	}

	/**
	 * Returns the index of the dealer in the player[] array.
	 * @return The index of the dealer.
	 */
	public int getDealerIndex() {
		return dealerIndex;
	}

	/**
	 * Sets the index of the dealer in the player[] array.
	 * @param dealerIndex The index of the dealer.
	 */
	public void setDealerIndex(final int dealerIndex) {
		this.dealerIndex = dealerIndex;
	}

	/**
	 * Returns what cards have been played on the table.
	 * @return The cards that have been played on the table.
	 */
	public ArrayList<Card> getCardsPlayed() {
		return cardsPlayed;
	}

	/**
	 * Sets the cards that have been played on the table.
	 * @param cardsPlayed The cards that have been played on the table.
	 */
	public void setCardsPlayed(final ArrayList<Card> cardsPlayed) {
		this.cardsPlayed = cardsPlayed;
	}

	/**
	 * Returns the current trump suit.
	 * @return The current trump suit.
	 */
	public Suit getTrump() {
		return trump;
	}

	/**
	 * Sets the current trump suit.
	 * @param trump The trump suit.
	 */
	public void setTrump(final Suit trump) {
		this.trump = trump;
	}

	/**
	 * Returns the state of the game.
	 * @return The state of the game
	 */
	public int getGameState() {
		return gameState;
	}

	/**
	 * Sets the state of the game.
	 * @param gameState The state to set the game to.
	 */
	public void setGameState(final int gameState) {
		this.gameState = gameState;
	}

}
