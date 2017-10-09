package game;

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
	 * Two players in team 1.
	 */
	private Player[] team1;
	
	/**
	 * Two players in team 2.
	 */
	private Player[] team2;
	
	/**
	 * Score for team 1.
	 */
	private int team1score;
	
	/**
	 * Score for team 2.
	 */
	private int team2score;
	
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
	 * Runs the Euchre game.
	 */
	public EuchreGame() {
		cardDeck = new Deck();
		players = new Player[4];
		players[0].setPartner(players[2]);
		players[1].setPartner(players[3]);
		players[2].setPartner(players[0]);
		players[3].setPartner(players[1]);
		
		team1 = new Player[2];
		team2 = new Player[2];
		
		team1[0] = players[0];
		team1[1] = players[2];
		team2[0] = players[1];
		team2[1] = players[3];
		
		team1score = 0;
		team2score = 0;
		
		dealerIndex = (int) (Math.random() * 4);
		
		while (team1score < 10 || team2score < 10) {
				trick();
				dealerIndex++;
				if (dealerIndex == 4) {
					dealerIndex = 0;
				}
		}
	}
	
	/**
	 * Runs a trick of the game.
	 */
	private void trick() {
		cardDeck.shuffle();
		deal();
	}
	
	/**
	 * Deals the cards.
	 */
	private void deal() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 4; j++) {
				int curDeal = dealerIndex++;
			}
		}
	}
	
}
