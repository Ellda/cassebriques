package gameState;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import view.Menu;
import controller.GameController;

import model.Game;

/**
 * 
 * This 'pause' state is called when the game is over. It stops the timer and displays a
 * option panel. According to the answer given by the user, it can switch to a
 * new game or close the program.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author Jérémy Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot Gémus-Prévost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class OverGameState implements GameState {

	private GameController gameController;

	public OverGameState(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void runGame() {

		System.out.println("Game Over");
		
		Game.playSound("smb_gameover.wav");

		// Stop of the game timer
		gameController.getTimer().cancel();

		// Ask window if new game
		int option = JOptionPane.showConfirmDialog(gameController.getView(),
				"Vous avez perdu ! Voulez vous rejouer ?", "Game Over",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		// If yes : reseting and restart timer
		if (option == JOptionPane.YES_OPTION) {
		
			gameController.initGame();

		} else {
						
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(gameController.getView());
			topFrame.dispose();
			Menu.getInstance().setVisible(true);
		}

	}

}
