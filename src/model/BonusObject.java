package model;

public class BonusObject
{
	private double speed;
	private double dir;
	private double x, y;
	private double size;
	private int type;

	public BonusObject(int type, double x, double y, double speed, double dir, double size)
	{
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.type = type;
		this.size = size;
	}
	public BonusObject(int type, double x, double y, double speed, double dir)
	{
		this(type, x, y, speed, dir, 10);
	}
	public BonusObject(int type, double x, double y, double speed)
	{
		this(type, x, y, speed, Math.PI / 2);
	}
	public BonusObject(int type, double x, double y)
	{
		this(type, x, y, 3);
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getDir(){
		return dir;
	}
	public double getSpeed(){
		return speed;
	}
	public int getType(){
		return type;
	}
	public double getSize(){
		return size;
	}

	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setDir(double dir) {
		this.dir = dir;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void setSize(double size){
		this.size = size;
	}
}
