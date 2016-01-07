package controller;

import executer.Executer;
import model.Ball;
import model.Brick;
import model.Game;
import view.MainFrame;

/**
 * BallController is the controller class that handles the Ball model and its
 * movements and collisions.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji 14 000 626
 * @author J�r�my Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot G�mus-Pr�vost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class BallController {

	private Ball ball;
	private MainFrame mainFrame;
	private Collision collision;

	private int nbBrickTouche;

	public BallController(Ball ballModel, MainFrame mainFrame) {
		ball = ballModel;
		this.mainFrame = mainFrame;
		collision = new Collision(mainFrame);

	}

	public void refresh() {
		moveX();
		moveY();
		ball.setSpeed(ball.getSpeed() + 0.002);
		//mainFrame.paintBall(ball);
		//mainFrame.repaint();
	}

	/**
	 * Move the x position of the ball
	 */
	public void moveX() {

		double newX = ball.calcFutureX();
		Brick br;
		// Left border collision
		newX = BounceWindow(newX, true);

		if (newX - ball.getRadius() > 0
				|| newX + ball.getRadius() < Executer.WIN_WIDTH) {
			br = collision.collision_brickX(newX);
			bounceAndKillBrick(br, true);
		}
		ball.setX(newX);
	}

	/**
	 * Move the y position of the ball
	 */
	public void moveY() {

		double newY = ball.calcFutureY();
		Brick br;

		// Top border collision
		newY = BounceWindow(newY, false);

		// After the game is over, we set newY to -1

		if (newY != -1) {

			// Top of the bar collision
			if (ball.getyDir() == 1
					&& collision.intersect_haut(mainFrame.getBar(), newY)) {

				Game.playSound("smb_kick.wav");

				mainFrame.getBar().incCounter();

				// 1) Horizontal trajectory change
				if (mainFrame.getBar().isOnTheRight(ball.getX())) {
					ball.setxDir(1);
				} else {
					ball.setxDir(-1);
				}

				// 2) Angle change after bouncing
				ball.changeAngleFromPercentage(mainFrame.getBar()
						.getDistanceFromCenter(ball.getX()));

				// 3) Bouncing
				newY = calcCoordAfterBounce(newY, ball.getY(), ball.getyDir(),
						mainFrame.getBar().getTopY());
				ball.reverseyDir();
				BallController ballController = new BallController(null, null);
				ballController.setNbBrickTouche(0);

			} else {
				br = collision.collision_brickY(newY);
				bounceAndKillBrick(br, false);
			}
			ball.setY(newY);
		}
	}

	private void bounceAndKillBrick(Brick br, boolean XTrueYFalse) {
		if (br != null) {
			br.kill();
			reverseXorY(XTrueYFalse);
		}
	}

	/**
	 * Calculate the new value of the newCoord according after the bouncing
	 * against the obstacleCoord
	 * 
	 * @param newCoord
	 * @param currentCoord
	 * @param direction
	 * @param obstacleCoord
	 * @return
	 */
	public double calcCoordAfterBounce(double newCoord, double currentCoord,
			int direction, double obstacleCoord) {

		int dir = (direction == -1 ? direction : 1);
		double d = (currentCoord - newCoord) * dir;
		return currentCoord + d - 2
				* (obstacleCoord - (currentCoord + ball.getRadius() * dir));

	}

	private double BounceWindow(double newCoord, boolean XTrueYFalse) {
		int Direction;
		Direction = findDirection(XTrueYFalse);

		if (newCoord - ball.getRadius() <= 0) {
			// Top OR Left border collision
			newCoord = calcCoordAfterBounce(newCoord,
					getPositionXorY(XTrueYFalse), Direction, 0);
			reverseXorY(XTrueYFalse);
		} else if (newCoord + ball.getRadius() >= getWidthOrHeight(XTrueYFalse)) {
			// Right OR Bottom border collision
			newCoord = calcCoordAfterBounce(newCoord,
					getPositionXorY(XTrueYFalse), Direction,
					getWidthOrHeight(XTrueYFalse));
			reverseXorY(XTrueYFalse);
		} else if (newCoord + ball.getRadius() > mainFrame.getBar().getY()
				+ mainFrame.getBar().getHeight()
				&& !XTrueYFalse) {

			ball.killBall();

			// we return -1 to prevent further calculations done on moveY
			return -1;
		}
		return newCoord;
	}

	private int getWidthOrHeight(boolean XTrueYFalse) { // returns the height or
														// the width of the
														// window
														// (true =
														// moveX, false = moveY)
		if (XTrueYFalse)
			return Executer.WIN_WIDTH;
		else
			return Executer.WIN_HEIGHT;
	}

	private double getPositionXorY(boolean XTrueYFalse) { // returns the
															// position
															// of the ball in
															// x or y
															// (true = moveX,
															// false = moveY)
		if (XTrueYFalse)
			return ball.getX();
		else
			return ball.getY();
	}

	private void reverseXorY(boolean XTrueYFalse) { // changes the girections of
													// the
													// ball (true = moveX, false
													// = moveY)
		if (XTrueYFalse)
			ball.reversexDir();
		else
			ball.reverseyDir();
	}

	private int findDirection(boolean XTrueYFalse) { // returns the direction of
														// the ball according to
														// x or y
														// (true = moveX, false
														// = moveY)
		if (XTrueYFalse)
			return ball.getxDir();
		else
			return ball.getyDir();
	}

	public void setBall(Ball newBall) {
		this.ball = newBall;
	}

	public int getNbBrickTouche() {
		return nbBrickTouche;
	}

	public void setNbBrickTouche(int nbBrickTouche) {
		this.nbBrickTouche = nbBrickTouche;
	}

	public void incNbBrickTouche() {
		this.nbBrickTouche++;
	}

}