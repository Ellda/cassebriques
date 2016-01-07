package gameState;

import controller.GameController;

/**
 * 
 * This principal state is called when the game is playing. It can change to game over or
 * new life if the ball dies.
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

public class PlayingGameState implements GameState {

	private GameController gameController;

	public PlayingGameState(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void runGame() {

		gameController.getGame().getBarController().refresh();
		gameController.getGame().getBrickController().refresh();
		gameController.getGame().getBallController().refresh();
		gameController.getGame().getBonusObjectController().refresh();
		gameController.repaint();
		
		gameController.updateInfosView();

		if (gameController.getGame().getBall().getAlive() == false) {

			gameController.decLife();
			gameController.updateInfosView();

			if (gameController.getGame().getLife() <= 0) {
				gameController.setGameState(gameController.getOverGameState());
			} else {
				gameController.setGameState(gameController.getNewLifeGameState());
			}

		}
	}

}
