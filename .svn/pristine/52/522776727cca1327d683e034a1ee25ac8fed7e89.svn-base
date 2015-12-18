package controller;

import executer.Executer;
import view.MainFrame;
import model.Bar;

/**
 * BarController is the controller class that handles the Bar model.
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

public class BarController {

	private Bar bar;
	private boolean leftKeyPressed = false;
	private boolean rightKeyPressed = false;
	private MainFrame mainFrame;

	public BarController(Bar barModel, MainFrame mainFrame) {
		bar = barModel;
		this.mainFrame = mainFrame;
	}

	/**
	 * This two functions makes the bar move to the right/left in regards of its
	 * speed
	 */
	public void moveRight() {
		bar.setX(bar.getX() + bar.getSpeed());
	}

	public void moveLeft() {
		bar.setX(bar.getX() - bar.getSpeed());
	}

	public void refresh() {
		
		// Move the bar if any key is hold
		if(leftKeyPressed){
			moveLeft();
		}else{
			if(rightKeyPressed){
				moveRight();
			}
		}
		// Repaint the main frame
		mainFrame.paintBar(bar);
		mainFrame.repaint();
	}
	
	public void setLeftKeyPressed(boolean pressed){
		this.leftKeyPressed = pressed;
	}
	
	public void setRightKeyPressed(boolean pressed){
		this.rightKeyPressed = pressed;
	}

	public void resetBar() {
		// Position in the middle
		bar.setX(Executer.WIN_WIDTH / 2); 
		bar.setY(Executer.WIN_HEIGHT - 100); 
		// Counter at 0
		bar.setCounter(0);
	}

	public void setBar(Bar newBar) {
		this.bar = newBar;
	}
	


}
