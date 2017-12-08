package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * A class to build a Graphical User Interface for the Euchre game.
 * 
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 */

//JFrame objects should not be serialized in this project
@SuppressWarnings("serial")
public class EuchreGUI extends JFrame {


	/** Width of the entire game window. */
	private static final int FRAME_WIDTH = 1270;

	/** height of the entire game window. */
	private static final int FRAME_HEIGHT = 790;

	/** The color Blue used by the game board. */
	private static final Color BLUE = new Color(0x2980b9);

	/** The color White used by the game board. */
	private static final Color WHITE = new Color(0xecf0f1);

	/** The color Black used by the game board. */
	private static final Color BLACK = new Color(0x34495e);


	/**
	 * Handles most game rules, and interfaces with AI's.
	 */
	private EuchreGame game;


	/**
	 * Listens for swing component events.
	 */
	private EventListener eventListener;


	/**
	 * Organizes player card graphics.
	 */
	private ArrayList<ArrayList<JButton>> playerCards;


	/**
	 * Organizes tables card graphics.
	 */
	private ArrayList<JButton> tableCards;


	/**
	 * Used in the beginning of the game.
	 * Passes the card, not declaring trump.
	 */
	private JButton passButton;


	/**
	 * Used in the beginning of the game.
	 * Tells the dealer to pick up the card, declaring trump.
	 * Is placed on the board as a clickable card.
	 */
	private JButton pickupButton;


	/**
	 * Holds all the components for the current cards in play. Along with 
	 * other players cards.
	 */
	private JPanel tablePanel;

	/**
	 * Holds the current cards in play.
	 */
	private JPanel centerTable;


	/**
	 * Holds the users current cards.
	 */
	private JPanel cardsPanel;


	/**
	 * Displays score and other information.
	 */
	private JPanel infoPanel;


	/**
	 * Holds the current round points and over all score information.
	 */
	private JLabel scoreLabel;


	/**
	 * Is used to notify the player about the game state.
	 */
	private JLabel alertLabel;


	/**
	 * Tells the player which suit is trump.
	 */
	private JLabel trumpLabel;

	/**
	 * Initializes variables, and handles the beginning state of the game.
	 */
	public EuchreGUI() {
		game = new EuchreGame();
		game.deal();

		playerCards = new ArrayList<ArrayList<JButton>>(4);
		tableCards = new ArrayList<JButton>(4);
		eventListener = new EventListener();
		//clickListener = new ClickListener();


		initDisplay();
		game.startRound();
		alertLabel = new JLabel();
		infoPanel.add(alertLabel);
		//		update();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	/**
	 * Sets up the the frame, adding in all components. Also initializes 
	 * componenets. 
	 */
	private void initDisplay() {
		this.setLayout(new BorderLayout());
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		tablePanel = new JPanel(new BorderLayout());
		infoPanel = new JPanel(new GridLayout(5, 1, 10, 15));
		cardsPanel = new JPanel(new GridLayout(1, 5));

		tablePanel.setPreferredSize(new Dimension(950, 550));

		JPanel northTable = new JPanel(new GridLayout(1, 5));
		northTable.setBackground(BLUE);
		tablePanel.add(northTable,
				BorderLayout.NORTH);

		JPanel westTable = new JPanel(new GridLayout(5, 1));
		westTable.setBackground(BLUE);
		tablePanel.add(westTable,
				BorderLayout.WEST);

		JPanel eastTable = new JPanel(new GridLayout(5, 1));
		eastTable.setBackground(BLUE);
		tablePanel.add(eastTable,
				BorderLayout.EAST);

		centerTable = new JPanel(new GridLayout(1, 4));
		centerTable.setBackground(BLUE);
		tablePanel.add(centerTable,
				BorderLayout.CENTER);

		//tablePanel.setSize(1045, 580);
		//infoPanel.setSize(200, 580);
		//cardsPanel.setSize(1250, 175);


		tablePanel.setBackground(BLUE);

		infoPanel.setBackground(WHITE);

		cardsPanel.setBackground(BLACK);

		// Initializes the players hand
		Player[] players = game.getPlayers();
		//ImageIcon cardBack = cardGraphic(null);

		//iterate over players
		for (int i = 0; i < players.length; i++) {
			ArrayList<Card> hand = players[i].getHand();
			ArrayList<JButton> buttons = new ArrayList<JButton>();
			System.out.println("Player " + i + ", size " + hand.size());
			//iterate over the players cards
			for (int j = 0; j < hand.size(); j++) {

				JButton cardButton;
				//only show the players cards, not your opponents/partners
				if (i == 0) {
					cardButton = new JButton(cardGraphic(hand.get(j)));
				} else {
					cardButton = new JButton(cardGraphic(null));
				}

				buildImageButton(cardButton);

				if (i == 0) {
					cardsPanel.add(cardButton);
				} else if (i == 1) {
					westTable.add(cardButton);
				} else if (i == 2) {
					northTable.add(cardButton);
				} else if (i == 3) {
					eastTable.add(cardButton);
				}

				cardButton.addActionListener(eventListener);

				buttons.add(cardButton);
			}
			playerCards.add(buttons);
		}


		pickupButton = new JButton(cardGraphic(game.getTopCard()));
		buildImageButton(pickupButton);
		pickupButton.addActionListener(eventListener);

		centerTable.add(pickupButton);


		passButton = new JButton("PASS");
		passButton.addActionListener(eventListener);
		scoreLabel = new JLabel(scoreText());
		trumpLabel = new JLabel("");

		infoPanel.add(passButton);
		infoPanel.add(scoreLabel);
		infoPanel.add(trumpLabel);


		this.add(infoPanel, BorderLayout.WEST);
		this.add(cardsPanel, BorderLayout.SOUTH);
		this.add(tablePanel, BorderLayout.EAST);


		this.setResizable(false);
		this.setVisible(true);

	}

	/**
	 * Sets player's buttons back up.
	 */
	private void resetButtons() {
		ArrayList<Card> hand = game.getPlayers()[0].getHand();
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		System.out.println("Player " + 0 + ", size " + hand.size());
		//iterate over the players cards
		for (int j = 0; j < hand.size(); j++) {

			JButton cardButton;
			cardButton = new JButton(cardGraphic(hand.get(j)));

			buildImageButton(cardButton);
			cardsPanel.add(cardButton);

			cardButton.addActionListener(eventListener);

			buttons.add(cardButton);
		}
		playerCards.add(buttons);
		
		pickupButton.setIcon(cardGraphic(game.getTopCard()));
		buildImageButton(pickupButton);
		
		centerTable.add(pickupButton);
		
		passButton.setEnabled(true);
		
		SwingUtilities.updateComponentTreeUI(this);
	}

	/**
	 * Refreshes the display to show the current game state.
	 */
	private void update() {

		centerTable.removeAll();
		//trumpLabel.setText("Trump is: " + game.getTrump().name());
		//update the center tables played cards
		ArrayList<Card> playedCards = game.getCardsPlayed();
		System.out.println("cards played " + playedCards.size());
		//iterate over the players cards
		for (int i = 0; i < playedCards.size(); i++) {
			System.out.println("------ " + i);

			JButton button = new JButton(cardGraphic(playedCards.get(i)));
			buildImageButton(button);
			centerTable.add(button);

			tableCards.add(button);
		}


		// re-render components with changed imageicons
		SwingUtilities.updateComponentTreeUI(this);

		if (game.getGameState() == GameState.PLAYERSTOPCARD) {
			alertLabel.setText("Do you want to pick up the top card?");
		} else if (game.getGameState() == GameState.DEALERSTOPCARD) {
			alertLabel.setText("Would you like the dealer (Player " 
					+ game.getDealerIndex() 
					+ ") to pick up the top card?");
		} else if (game.getGameState() == GameState.PLAYERSWAP) {
			alertLabel.setText("Pick a card to swap from your hand.");
		} else if (game.getGameState() == GameState.TRICK) {
			alertLabel.setText("Play a card");
		}
		//
		//		if (!roundFinished) {
		//			trick();
		//		}
	}


	/**
	 * Formats a JButton to not be java styled, but just be a clickable
	 * imageIcon.
	 * @param b The button to be formatted.
	 * @return A properly formatted button to look like a plain image.
	 */
	private JButton buildImageButton(final JButton b) {
		JButton button = b;
		button.setFocusPainted(true);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBorder(
				BorderFactory.createEmptyBorder(20, 20, 20, 20));

		return button;
	}


	/**
	 * With the given Card, find the correct image in the directory
	 * resources/cards/.
	 * @param c The given card.
	 * @return An ImageIcon of the card corresponding to the given
	 * card c.
	 */
	private ImageIcon cardGraphic(final Card c) {
		String path;
		if (c == null) {
			path = "resources/cards/back1.GIF";
		} else if (c.getValue() < 11) {
			path = "resources/cards/" 
					+ c.getValue() 
					+ c.getSuit().name().toLowerCase() 
					+ ".GIF";
		} else {
			path = "resources/cards/";
			if (c.getValue() == 11) {
				path += "jack"
						+ c.getSuit().name().toLowerCase()
						+ ".GIF";
			} else if (c.getValue() == 12) {
				path += "queen"
						+ c.getSuit().name().toLowerCase()
						+ ".GIF";
			} else if (c.getValue() == 13) {
				path += "king"
						+ c.getSuit().name().toLowerCase()
						+ ".GIF";
			} else if (c.getValue() == 14) {
				path += "ace"
						+ c.getSuit().name().toLowerCase()
						+ ".GIF";
			}
		}
		ImageIcon image = new ImageIcon(path);
		//		JButton cardButton = new JButton(image);
		//		cardButton.setFocusPainted(false);
		//		cardButton.setMargin(new Insets(0, 0, 0, 0));
		//		cardButton.setContentAreaFilled(false);
		//		cardButton.setBorderPainted(false);
		//		cardButton.setOpaque(false);
		//		cardButton.setBorder(
		//			BorderFactory.createEmptyBorder(20, 20, 20, 0));
		//		cardsPanel.add(cardButton);
		return image;
	}


	/**
	 * @return A formatted String containing overall and round score
	 * data
	 */
	private String scoreText() {
		return "<html>ROUND POINTS<br>Team 1: " 
				+ game.getTeam1points()
				+ "<br>Team 2: "
				+ game.getTeam2points()
				+ "<br><br>TOTAL SCORE<br>Team 1: "
				+ game.getTeam1score()
				+ "<br>Team 2: "
				+ game.getTeam2score()
				+ "</html>";
	}


	/**
	 * Has the AI's before the player make their plays, then prompts the
	 * player to play a card.
	 */
	//	private void trick() {
	//		game.getCardsPlayed().clear();
	//		int dealerIndex = game.getDealerIndex();
	//		if (dealerIndex != 0) {
	//			//starts at the dealer, haveing players play
	//			//their cards
	//			for (int i = dealerIndex; i < 4; i++) {
	//				game.makePlay(i);
	//			}
	//		}
	//
	//		//update();
	//	}

	/**
	 * Listens for component events and alters the game and gui state
	 * accordingly.
	 * @author Nathan Pipe, Tressa Groelsma
	 *
	 */
	private class EventListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent e) {
			//			try {
			System.out.println("event");
			System.out.println(game.getGameState());

			if (e.getSource().equals(pickupButton)) {
				passButton.setEnabled(false);
				if (game.getGameState() == GameState.DEALERSTOPCARD) {
					// player told dealer to pick up top card
					game.dealerSwap();
				} else if (game.getGameState() 
						== GameState.PLAYERSTOPCARD) {
					// player decided to pick up top card
					// player needs to pick a card to swap 
					// from their hand
					game.setGameState(GameState.PLAYERSWAP);
				}
			} else if (e.getSource().equals(passButton)) {
				passButton.setEnabled(false);
				if (game.getGameState() == GameState.DEALERSTOPCARD) {
					// player did not want dealer to pick up top card
					game.finishTopCardChoice();
				} else if (game.getGameState()
						== GameState.PLAYERSTOPCARD) {
					// player did not want to pick up top card
					game.finishTopCardChoice();
				}
			}

			for (int i = 0; i < playerCards.get(0).size(); i++) {
				if (e.getSource() == playerCards.get(0).get(i)) {
					if (game.getGameState() == GameState.PLAYERSWAP) {
						game.playerSwap(game.getPlayers()[0]
								.getHand().get(i));
						playerCards.get(0).remove(i);
						cardsPanel.remove(i);
						JButton cardButton = new JButton(cardGraphic(
								game.getTopCard()));
						buildImageButton(cardButton);
						cardsPanel.add(cardButton);
						cardButton.addActionListener(eventListener);
						playerCards.get(0).add(cardButton);
						game.trickBefore();
					} else if (game.getGameState() 
							== GameState.TRICK) {
						boolean flag = false;
						game.playerPlay(i);
						playerCards.get(0).remove(i);
						cardsPanel.remove(i);
						game.trickAfter();
						scoreLabel.setText(scoreText());
						if (game.getGameState() == GameState.ROUNDEND) {
							flag = true;
						}
						game.trickReset();
						if (flag) {
							resetButtons();
						}
					}
				}
			}
			//			} catch (Exception exc) {
			//				System.out.println(exc);
			//			} finally {
			update();
			//			}
		}

	}

	/**
	 * Creates a EuchreGUI object to start the game.
	 * @param args System arguments.
	 */
	public static void main(final String[] args) {
		new EuchreGUI();

		//		EuchreGame game = new EuchreGame();
		//		game.deal();
		//		Player[] players = game.getPlayers();
		//		for(Player p : players)
		//			System.out.println(p.getHand().size());
	}

}

