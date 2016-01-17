package controller;

import gameState.GameState;
import gameState.NewGameState;
import gameState.NewLifeGameState;
import gameState.OverGameState;
import gameState.PlayingGameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

import view.MainFrame;
import model.Ball;
import model.Bar;
import model.Bonus;
import model.Configuration;
import model.Game;

/**
 * This class is the main controller of the game. It uses the State pattern in
 * order to manage the state of the game. There are 4 states : new game, playing,
 * game over and new life. It also controls the global timer, which is stopped
 * in the different states.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author J�r�my Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot G�mus-Pr�vost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class GameController {

	private Game game;
	private MainFrame view;

	// Possible states of the game
	private GameState newGameState;
	private GameState playingGameState;
	private GameState overGameState;
	private GameState newLifeGameState;
	// Current state of the game
	private GameState currentState;
	private Configuration gameConfig;
	// Timer
	private Timer gameTimer;
	


	public GameController(Game game, MainFrame view) {

		this.game = game;
		this.view = view;

		newGameState = new NewGameState(this);
		playingGameState = new PlayingGameState(this);
		overGameState = new OverGameState(this);
		newLifeGameState = new NewLifeGameState(this);
		gameConfig = new Configuration();
		// Adding of a key listener on the main frame
		MyKeyListener listener = new MyKeyListener();
		this.view.addKeyListener(listener);
	}

	public void refreshGame() {

		// Repaint before restarting the timer (to see the changes during the
		// second of waiting before playing)
		//view.repaintAll();
		view.repaint();

		// Global timer, restarted each time that this method is called (new
		// life or new game).
		gameTimer = new Timer();
		gameTimer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				getState().runGame();
			}
		}, 2000, 16);

	}
	/**
	 * Initializes the game. Called at the start and when a new game is started
	 * after a Game Over state.
	 */
	public void initGame() {
		// Reset previous game bonus if any
		for (Bonus b : game.getBonusList())
		{
			b.cancelBonus();
		}
		game.clearBonusList();
		
		// Set the total life
		game.setLife(game.getMaxLife());

		// Defines the elements
		game.setBall(new Ball());
		game.setBar(new Bar());
		game.setBallController(new BallController(game.getBall(), getView()));
		game.setBarController(new BarController(game.getBar(), getView()));
		game.setBrickController(new BrickController(getGame(), getView()));
		game.setBonusObjectController(new BonusObjectController(getGame(), getView()));
		game.getBrickController().setBricksPattern();
		game.getBall().addObserver(game.getBrickController());
		// Informs the view
		view.setBall(game.getBall());
		view.setBar(game.getBar());
		view.setBrickList(game.getBrickController().getlistOfBricks_alive());
		updateInfosView();
		// Set the correct state
		setGameState(getNewGameState());
		// Call the refresh method to launch the game
		refreshGame();

	}

	/**
	 * Reinitialize the game. Called when the player loses a life.
	 */
	public void newLifeGame() {
		// Cancel bonus effects
		for (Bonus b : game.getBonusList())
		{
			b.cancelBonus();
		}
		game.clearBonusList();
		
		// Resets the ball and the bar
		game.setBall(new Ball());
		game.setBar(new Bar());
		game.getBallController().setBall(game.getBall());
		game.getBarController().setBar(game.getBar());
		game.getBall().addObserver(game.getBrickController());
		// Clear falling bonus objects
		game.getBonusObjectController().clearBonusObjects();
		// Informs the view
		view.setBall(game.getBall());
		view.setBar(game.getBar());
		updateInfosView();
		// Set the correct state
		setGameState(getPlayingGameState());
		
		BallController ballController = new BallController(null,null);
		
		ballController.setNbBrickTouche(0);
		// Calls the refresh method to launch the game
		refreshGame();
	}

	/**
	 * Informs the view of the current life in order to display the correct
	 * value.
	 */
	public void updateInfosView() {
		view.updateGameInfoPanel(game.getLife(), game.getMaxLife(), game.getBrickController().getScore());
	}

	/**
	 * Management of the key listener
	 */
	public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			switch (e.getKeyCode()) {

			default:
				break;
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			  
			int keyPressed = e.getKeyCode();
			
			if(keyPressed ==  gameConfig.getQuitter())
				System.exit(0);
			else if(keyPressed ==  gameConfig.getGauche())
				game.getBarController().setLeftKeyPressed(true);
			else if(keyPressed ==  gameConfig.getDroite())
				game.getBarController().setRightKeyPressed(true);
			else if(keyPressed == 77){ //m
				gameConfig.toggleSon();
				try {
					gameConfig.save();
				} catch (IOException | URISyntaxException e1) {
					// rien a faire, ça n'est pas grave ici si la configuration ne peut pas être sauvegardé.
				}
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			int keyReleased = e.getKeyCode();

			if(keyReleased ==  gameConfig.getQuitter())
				System.exit(0);
			else if(keyReleased ==  gameConfig.getGauche())
				game.getBarController().setLeftKeyPressed(false);
			else if(keyReleased ==  gameConfig.getDroite())
				game.getBarController().setRightKeyPressed(false);
		}
	}
	
	public Game getGame() {
		return this.game;
	}

	public MainFrame getView() {
		return this.view;
	}

	public GameState getState() {
		return currentState;
	}

	public void setGameState(GameState newState) {
		this.currentState = newState;
	}

	public GameState getNewGameState() {
		return newGameState;
	}

	public GameState getPlayingGameState() {
		return playingGameState;
	}

	public GameState getOverGameState() {
		return overGameState;
	}

	public GameState getNewLifeGameState() {
		return newLifeGameState;
	}

	public Timer getTimer() {
		return gameTimer;
	}

	public void incLife() {
		game.setLife(game.getLife() + 1);
	}
	
	public void decLife() {
		if(game.getLife() > -1)game.setLife(game.getLife() - 1);
	}
	
	public void repaint()
	{
		view.repaint();
	}
}
