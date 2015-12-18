package model;

import java.util.Observable;

import executer.Executer;

/**
 * Defines the Ball objet.
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

public class Ball extends Observable{
	
	private double x, y;
	private double speed;
	private int radius;
	private double angle; // angle max 90 et angle min 30°
	private int xDir; //SensX
	private int yDir; //SensY
	private boolean alive;

	public Ball() {
		this.x = Executer.WIN_WIDTH / 2; // Initial position in the middle
		this.y = (Executer.WIN_HEIGHT* 3/4);
		init();
	}
	

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		init();
	}
	
	private void init() {
		this.speed = 7;
		this.radius = 10;
		this.angle = 90;
		this.xDir = 1;
		this.yDir = -1;
		this.alive = true;
	}

	/**
	 * Setters
	 */
	
	
	public void setX(double newX) {
		if (newX + radius < Executer.WIN_WIDTH && newX > 0) {
			x = newX;
		}

	}

	public void setY(double newY) {
		if (newY + radius < Executer.WIN_HEIGHT && newY > 0){
			y = newY;
		}
		
	}

	public void setxDir(int newxDir) {
		if( newxDir == -1 || newxDir == 1 ){
			xDir = newxDir;	
		}
	}
	
	public void setyDir(int newyDir) {
		if( newyDir == -1 || newyDir == 1 ){
			yDir = newyDir;
		}
	}
	
	public void reversexDir(){
		setxDir(-getxDir());
	}
	
	public void reverseyDir(){
		setyDir(-getyDir());
	}
	
	/**
	 * 
	 * @param newAngle : angle in degrees
	 */
	public void setAngle(double newAngle) {
		angle = Math.toRadians(newAngle);
	}	
	
	public void setRadius(int newRadius) {
		radius = newRadius;
	}

	public void setSpeed(double d) {
		speed = d;
	}
	
	public void killBall(){
		this.alive = false;
	}

	/**
	 * Getters
	 */
	public double getX() {
		return x;
	}
	
	public int getxDir(){
		return xDir;
	}
	

	public double getY() {
		return y;
	}
	
	public int getyDir(){
		return yDir;
	}
	

	public double getAngle() {
		return angle;
	}
	public int getRadius() {
		return radius;
	}

	public double getSpeed() {
		return speed;
	}

	public double getyBottom(){
		return y + radius;
	}
	
	public double getxRight(){
		return x + radius;
	}
	
	public double getxLeft(){
		return x - radius;
	}
	
	public double getyTop(){
		return y - radius;
	}
	
	public int getXInt() {
		return (int) x;
	}
	public int getYInt() {
		return (int) y;
	}
	
	public boolean getAlive(){
		return this.alive;
	}
	
	public double calcFutureX(){
		return getX() + Math.abs(Math.cos(getAngle()))*getxDir()*getSpeed();
	}
	
	public double calcFutureY(){
		return getY() + Math.abs(Math.sin(getAngle()))*getyDir()*getSpeed();
	}

	public void changeAngleFromPercentage(double percentage) {
		setAngle(90 - 60*(percentage)/100);
	}
	

}
