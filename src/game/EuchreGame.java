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
		players[0] = new Player();
		players[1] = new Player();
		players[2] = new Player();
		players[3] = new Player();
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
	 * false if not.
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
	 * This method asks the player of the given index whether or not
	 * they want to choose the trump if the dealer card had not been chosen.
	 * 
	 * @param index The index of the player to ask.
	 * @return True if they chose a trump, false if not.
	 */
	public boolean chooseTrump(final int index) {
		Suit trumpChosen = players[index].chooseTrump();
		if (trumpChosen != null) {
			trump = trumpChosen;
			return true;
		}
		return false;
	}

	/**
	 * This method asks the player of the given index to play a card
	 * from their hand.
	 * 
	 * @param index The index of the player to ask.
	 */
	public void makePlay(final int index) {
		if (cardsPlayed.size() >= 4) {
			System.out.println(cardsPlayed.size());
			throw new IllegalStateException();
		}
		Card play = players[index].choosePlay(cardsPlayed, trump);
		cardsPlayed.add(play);
	}

	/**
	 * Returns the suit for the second bower.
	 * @return The suit of the second bower.
	 */
	private Suit getOpTrump() {
		switch (trump) {
		case HEARTS:
			return Suit.DIAMONDS;
		case DIAMONDS:
			return Suit.HEARTS;
		case SPADES:
			return Suit.CLUBS;
		default:
			return Suit.SPADES;
		}
	}

	/**
	 * This method checks the four cards on the table to determine which
	 * player won the round. It then updates the point totals  for the
	 * round.
	 */
	public void checkWin() {
		if (cardsPlayed.size() < 4) {
			throw new IllegalStateException();
		} else if (cardsPlayed.size() > 4) {
			throw new IllegalArgumentException();
		}

		// keeps track of what players played trump cards
		ArrayList<Integer> trumpIndexes = new ArrayList<Integer>();
		// keeps track of the trump cards
		ArrayList<Card> trumpCards = new ArrayList<Card>();

		for (int i = 0; i < 4; i++) { // counts number of trump cards
			if (cardsPlayed.get(i).getSuit() == trump) {
				trumpIndexes.add((i + 1 + dealerIndex) % 4); 
				// adds index of player of 
				// the card based off dealer
				trumpCards.add(cardsPlayed.get(i));
			} else if (cardsPlayed.get(i).getSuit() == getOpTrump()
					&& 
					cardsPlayed.get(i).getValue() == 11) {
				// checks for second bower
				trumpIndexes.add((i + 1 + dealerIndex) % 4);
				trumpCards.add(cardsPlayed.get(i));
			}
		}

		if (trumpIndexes.size() == 0) { 
			// no trump cards, check for initial suit
			Suit main = cardsPlayed.get(0).getSuit();
			for (int i = 0; i < 4; i++) {
				if (cardsPlayed.get(i).getSuit() == main) {
					trumpIndexes.add((i + 1 + dealerIndex)
							% 4); 
					// adds index of player of
					// the card based off dealer
					// trumpIndexes used for main suit
					trumpCards.add(cardsPlayed.get(i));
					// trumpCards used for main suit
				}
			}
			if (trumpIndexes.size() == 1) {
				// means first player wins
				// (they picked main suit)
				if (trumpIndexes.get(0) == 0
						|| trumpIndexes.get(0) == 2) {
					team1points++;
				} else {
					team2points++;
				}
			} else {
				int maxValue = 0;
				int maxIndex = 0;
				for (int i = 0; i < trumpCards.size(); i++) {
					// finds the highest value card played
					if (trumpCards.get(i).getValue() 
							> maxValue) {
						maxValue = trumpCards.get(i).getValue();
						maxIndex = i;
					}
				}
				if (trumpIndexes.get(maxIndex) == 0
						|| trumpIndexes.get(maxIndex) == 2) {
					team1points++;
				} else {
					team2points++;
				}
			}
		} else if (trumpIndexes.size() == 1) {
			// one trump card, it automatically wins
			if (trumpIndexes.get(0) == 0 
					|| trumpIndexes.get(0) == 2) {
				team1points++;
			} else {
				team2points++;
			}
		} else {
			boolean found = false;
			for (int i = 0; i < trumpCards.size(); i++) {
				// checks if first bower was played
				if (trumpCards.get(i).getValue() == 11
						&& 
						trumpCards.get(i).getSuit() 
						== trump) {
					if (trumpIndexes.get(i) == 0
							|| trumpIndexes.get(i) == 2) {
						team1points++;
					} else {
						team2points++;
					}
					found = true;
				}
			}
			if (!found) {
				for (int i = 0; i < trumpCards.size(); i++) {
					// checks if second bower was played
					// assuming first bower wasn't played
					if (trumpCards.get(i).getSuit() 
							== getOpTrump()) {
						if (trumpIndexes.get(i) == 0
								|| trumpIndexes.get(i) 
								== 2) {
							team1points++;
						} else {
							team2points++;
						}
						found = true;
					}
				}
				if (!found) {
					int maxValue = 0;
					int maxIndex = 0;
					for (int i = 0; i < trumpCards.size(); 
							i++) {
						// finds highest card value
						// assuming neither bower
						// was played
						if (trumpCards.get(i).getValue() 
								> maxValue) {
							maxValue = trumpCards.get(i).getValue();
							maxIndex = i;
						}
					}
					if (trumpIndexes.get(maxIndex) == 0
							|| trumpIndexes.get(maxIndex) 
							== 2) {
						team1points++;
					} else {
						team2points++;
					}
				}
			}
		}

		if ((team1points + team2points) == 5) {
			if (team1points > team2points) {
				team1score++;
			} else {
				team2score++;
			}
			checkGameWin();
			team1points = 0;
			team2points = 0;
			cardDeck.resetDeck();
			dealerIndex++;
			if (dealerIndex == 4) {
				dealerIndex = 0;
			}
		}
	}

	/**
	 * Checks if either team has won the game.
	 */
	private void checkGameWin() {
		if (team1score >= 10) {
			gameState = 1;
		} else if (team2score >= 10) {
			gameState = 2;
		}
	}

	/**
	 * Deals the cards.
	 */
	public void deal() {
		int curDeal = dealerIndex;
		// two cards to each player
		for (int j = 0; j < 4; j++) { 
			// goes through all four players
			curDeal++;
			if(curDeal >= 4) {
				curDeal -= 4;
			}
			//System.out.println(curDeal);
			players[curDeal].addToHand(cardDeck.deal());
			players[curDeal].addToHand(cardDeck.deal());
		}
		curDeal = dealerIndex;
		// three cards to each player
		for (int j = 0; j < 4; j++) {
			// goes through all four players
			curDeal++;
			if(curDeal >= 4) {
				curDeal -= 4;
			}
			players[curDeal].addToHand(cardDeck.deal());
			players[curDeal].addToHand(cardDeck.deal());
			players[curDeal].addToHand(cardDeck.deal());
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
	 * Returns the top card of the discard pile.
	 * @return The top card of the discard pile.
	 */
	public Card getTopCard() {
		return topCard;
	}

	/**
	 * Sets the top card of the discard pile.
	 * @param topCard The top card of the discard pile.
	 */
	public void setTopCard(final Card topCard) {
		this.topCard = topCard;
	}

}
