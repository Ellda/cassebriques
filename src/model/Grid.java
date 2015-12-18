package model;

import executer.Executer;


/**
 *
 * The grid defines the coordinates of the bricks contained in the list
 * The height and the width of Bricks are defined by the amount of bricks allowed by the grid
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

public class Grid {
	
	private static Grid instance = null ;
	
	/**
	 *  The total of the horizontal bricks
	 */
	private int nbCasesX ;
	
	/**
	 *  The total of the vertical bricks
	 */
	private int nbCasesY ;
	
	public synchronized static Grid getInstance(){
		if(instance == null)
			instance =  new Grid() ;
		return instance ;
	}
	
	private Grid(){
		nbCasesX = 10 ;
		nbCasesY = 10 ;
	}
	/**
	 * 
	 * @param brick
	 * @return The X coordinate on the screen according to the brick's X coordinate in the grid
	 */
	public int getXLeftFromBrick(Brick brick){
		return (getBrickWidth()*brick.getX()) ;
	}
	
	/**
	 * 
	 * @param brick
	 * @return The Y coordinate on the screen according to the brick's Y coordinate in the grid
	 */
	public int getYTopFromBrick(Brick brick){
		return (getBrickHeight()*brick.getY()) ;
	}
	
	public int getBrickWidth(){
		return (Executer.WIN_WIDTH/nbCasesX) ;
	}
	
	public int getBrickHeight(){
		return ((Executer.WIN_HEIGHT *2/3)/nbCasesY) ;
	}
	
	public int getYBottomFromBrick(Brick brick){
		return getYTopFromBrick(brick) + getBrickHeight();
	}
	
	public int getXRightFromBrick(Brick brick){
		return getXLeftFromBrick(brick) + getBrickWidth();
	}
	
	public int getNbCasesX(){
		return nbCasesX ;
	}
	
	public int getNbCasesY(){
		return nbCasesY ;
	}
	
	
	public void setNbCasesX(int nbCasesX){
		if(nbCasesX > 0)
			this.nbCasesX = nbCasesX ;
	}
	
	public void setNbCasesY(int nbCasesY){
		if(nbCasesY > 0)
			this.nbCasesY = nbCasesY ;
	}
	

	public boolean isWithinRangeX(Brick br, double xLeft, double xRight) {
		return (xLeft < getXRightFromBrick(br) && xRight > getXLeftFromBrick(br));
	}

	public boolean isWithinRangeY(Brick br, double yTop, double yBottom) {
		return (yTop < getYBottomFromBrick(br) && yBottom > getYTopFromBrick(br));
	}
	
}
