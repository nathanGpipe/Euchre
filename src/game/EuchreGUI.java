package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Nathan Pipe, Tressa Groelsma, Saxton Stafford
 *
 */
public class EuchreGUI {
	
	/**
	 * 
	 */
	private JFrame frame;
	
	
	/**
	 * 
	 */
	private GamePanel gamePanel;
	
	
	/**
	 * 
	 */
	private EuchreGame game;
	
	
	/**
	 * 
	 */
	public EuchreGUI() {
		game = new EuchreGame();
		
		frame = new JFrame();
		
		gamePanel = new GamePanel(game);
		
		
		frame.add(gamePanel);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	/**
	 * 
	 * @author Nathan Pipe
	 *
	 */
	private class GamePanel extends JPanel {
		
		/**
		 * Event Listener for user input.
		 */
		private EventListener listener;
		
		
		/**
		 * Organizes player card graphics.
		 */
		private JLabel[][] players;
		
		
		/**
		 * Holds all the components for the current cards in play.
		 */
		private JPanel tablePanel;
		
		
		/**
		 * Holds the users current cards.
		 */
		private JPanel cardsPanel;
		
		
		/**
		 * Displays score and other information.
		 */
		private JPanel infoPanel;
		
		
		/**
		 * 
		 */
		private EuchreGame game;
		
		/**
		 * 
		 */
		GamePanel(EuchreGame g) {
			game = g;
			listener = new EventListener();
			
			tablePanel = new JPanel(new BorderLayout());
			cardsPanel = new JPanel(new GridLayout(1, 5));
			infoPanel = new JPanel();
			
			this.setLayout(new BorderLayout());
			
			
		}
	
		
		/**
		 * 
		 * @author Nathan Pipe
		 *
		 */
		private class EventListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		}
	}
	
	
	
	
}



