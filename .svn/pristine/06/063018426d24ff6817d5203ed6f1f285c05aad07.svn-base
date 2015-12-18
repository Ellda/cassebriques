package gameState;

import model.Game;
import controller.GameController;

/**
 * 
 * This transitional state is called when the player loses a life. It stops the timer and
 * calls the appropriate method in the controler.
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

public class NewLifeGameState implements GameState {

	private GameController gameController;

	public NewLifeGameState(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void runGame() {

		System.out.println("Vie perdue");

	    Game.playSound("smb_mariodie.wav");
		
		// Stop of the game timer
		gameController.getTimer().cancel();

		// Change state to playing
		gameController.newLifeGame();

	}

}
