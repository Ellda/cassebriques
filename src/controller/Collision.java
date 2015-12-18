package controller;

import java.util.ArrayList;

import view.MainFrame;
import model.Ball;
import model.Bar;
import model.Brick;
import model.Grid;

/**
 * This class is used to test the collision events.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji 14 000 626
 * @author Jérémy Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot Gémus-Prévost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class Collision {

	private MainFrame mainFrame;
	private int collisionCoord;
	private Grid grid;

	public Collision(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		grid = Grid.getInstance();
	}

	/**
	 * Collision with the top of the bar
	 * @param bar
	 * @param newY
	 * @return
	 */
	public boolean intersect_haut(Bar bar, double newY) {
		Ball ball = mainFrame.getBall();
		if (newY + ball.getRadius() > bar.getTopY()
				&& ball.getY() + ball.getRadius() > bar.getTopY()) {
			return bar.isWithinBarRange(ball.getX() - ball.getRadius(),
					ball.getX() + ball.getRadius());
		}
		return false;
	}

	public Brick collision_brickX(double newX) {
		ArrayList<Brick> listOfBricks = mainFrame.getBricks();
		Ball ball = mainFrame.getBall();
		for (Brick br : listOfBricks) {
			if (grid.isWithinRangeX(br, newX - ball.getRadius(),
					newX + ball.getRadius())
					&& grid.isWithinRangeY(br, ball.getyTop(),
							ball.getyBottom())) {
				return br;
			}
		}
		return null;
	}

	public Brick collision_brickY(double newY) {
		ArrayList<Brick> listOfBricks = mainFrame.getBricks();
		Ball ball = mainFrame.getBall();
		for (Brick br : listOfBricks) {
			if (grid.isWithinRangeY(br, newY - ball.getRadius(),
					newY + ball.getRadius())
					&& grid.isWithinRangeX(br, ball.getxLeft(),
							ball.getxRight())) {
				return br;
			}
		}
		return null;
	}

	public void setCollisionCoord(int newCoord) {
		this.collisionCoord = newCoord;
	}

	public int getCollisionCoord() {
		return this.collisionCoord;
	}

}
