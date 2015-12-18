package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import model.Brick;
import model.Brick_bonus;
import model.Game;
import model.Grid;
import view.MainFrame;

/**
 * BrickController is the controller class that handles the Brick model.
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

public class BrickController implements Observer{
	
	private Grid grid ;
	private MainFrame mainFrame ;
	private ArrayList<Brick> listOfBricks_alive ;

	private ArrayList<Integer> coordMorteX = new ArrayList<Integer>() ;
	private ArrayList<Integer> coordMorteY = new ArrayList<Integer>() ;
	

	private BallController ballController;
	
	//Score 
	private int score;
	
	
	public BrickController(MainFrame mainFrame){
		
		grid = Grid.getInstance() ;
		listOfBricks_alive = new ArrayList<Brick>() ;
		this.mainFrame = mainFrame;
		score = 0;
	}
	
	

	
	/**
	 *  Create a squared pattern of bricks.
	 *  Initially, the score given by a brick is 10.
	 */
	public void setBricksSquare(){
		int bType;
		this.removeAllBricks();
		for(int i = 1 ; i < grid.getNbCasesX() - 1 ; i++)
			for(int j = 1 ; j < grid.getNbCasesY() - 3; j++){
				bType = (int) Math.floor(Math.random() * 2);
				switch(bType){
				case 0:
					listOfBricks_alive.add(new Brick(i, j, 10));
				case 1:
					listOfBricks_alive.add(new Brick_bonus(i, j, 10)) ;
				}
			}
	}
	
	public void removeDeadBricks(){
		for(int i = listOfBricks_alive.size() - 1; i >= 0; i--){
			if(listOfBricks_alive.get(i).isDead()){
				
				coordMorteX.add(listOfBricks_alive.get(i).getX());
				coordMorteY.add(listOfBricks_alive.get(i).getY());
				
				ballController = new BallController (null, mainFrame);
								
				ballController.incNbBrickTouche();
				incScore(listOfBricks_alive.get(i).getBrickPointValue() * ballController.getNbBrickTouche());
				listOfBricks_alive.remove(i);
				
				Game.playSound("smb_breakblock.wav");
				
			}
		}
		
	}
	
	public void reviveDeadBricks(){
		
		if(coordMorteX.size() > 0 && coordMorteY.size() > 0){
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(coordMorteX.size());
			listOfBricks_alive.add(new Brick(coordMorteX.get(randomInt).intValue(), 
											 coordMorteY.get(randomInt).intValue(), 
											 10)); //10 is the point value of the brick
			coordMorteX.remove(0);
			coordMorteY.remove(0);
			
		}
		
		if(getlistOfBricks_alive().size() == 2)
		{
			setBricksSquare();
		}

	}
	
	public ArrayList<Brick> getlistOfBricks_alive(){
		return listOfBricks_alive ;
	}
	
	public void refresh(){
		removeDeadBricks();
		
		if(mainFrame.getBar().getCounter() == 2){
			int nBricksRevived = new Random().nextInt(5);
			for(int i = 0; i < nBricksRevived; i++){
				reviveDeadBricks();
			}
			mainFrame.getBar().setCounter(0);
		}
		
		mainFrame.paintBricks(listOfBricks_alive);
		mainFrame.repaint();
	
	}
	
	/**
	 *  Removes all the bricks from the grid 
	 */
	public void removeAllBricks(){
		getlistOfBricks_alive().removeAll(listOfBricks_alive);
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {

		System.out.println("NOTIFY");
		if(arg1.toString().equals("GAME OVER")){

			//Brute Method: we remove all of the bricks
			//before filling the grid once again
		
;			removeAllBricks();
			setBricksSquare();
		}	
	}
	
	
	
	//Arbitrarily increases by 10 points
	//everytime we break a brick. 
	public void incScore(int pointValue){
		setScore(getScore() + pointValue);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
	
}