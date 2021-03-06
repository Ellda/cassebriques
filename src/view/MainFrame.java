package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import executer.Executer;
import model.Ball;
import model.Bar;
import model.BonusObject;
import model.Brick;
import model.Grid;

/**
 * Displays the main frame of the game.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author Jï¿½rï¿½my Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot Gï¿½mus-Prï¿½vost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

@SuppressWarnings("serial")
public class MainFrame extends JPanel{

	private Graphics gs;
	private Bar bar;
	private Ball ball;
	private ArrayList<Brick> listOfBricks;
	private List<BonusObject> boList;
	private Grid grid;
	
	private JLabel gameInfoLabel;

	public MainFrame() {

		bar = new Bar();
		ball = new Ball();
		grid = Grid.getInstance();
		listOfBricks = new ArrayList<Brick>();
		boList = new ArrayList<BonusObject>();
		gameInfoLabel = new JLabel();
		this.add(gameInfoLabel);

		this.setPreferredSize(new Dimension(Executer.WIN_WIDTH, Executer.WIN_HEIGHT));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setOpaque(false);
		this.setFocusable(true);	
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setGraph(g);
		paintBar(bar);
		paintBall(ball);
		paintBricks(listOfBricks);
		paintBonusObjects(boList);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void repaintAll(){
		paintBar(bar);
		paintBall(ball);
		paintBricks(listOfBricks);
		paintBonusObjects(boList);
		Toolkit.getDefaultToolkit().sync();
	}

	public Bar getBar() {
		return bar;
	}

	public Ball getBall() {
		return ball;
	}

	public ArrayList<Brick> getBricks() {
		return listOfBricks;
	}
	
	public void updateGameInfoPanel(int life, int maxLife, int score){
		gameInfoLabel.setText("<html>Vies restantes : "+life+" / "+maxLife + 
							   "<br>Score : "+ score+"</html>");
	}

	/**
	 * Drawing of the bar
	 */
	public void paintBar(Bar theBar) {
		if (gs == null)
			gs = this.getGraphics();

		try {
			
			gs.setColor(new Color(0, 0, 0));
			
			gs.fillRect(theBar.getX() - theBar.getWidth() / 2, theBar.getY() - theBar.getHeight()
					/ 2, theBar.getWidth(), theBar.getHeight());
			
			gs.setColor(new Color(245, 227, 71));
			
			gs.fillRect(theBar.getX() + 2 - theBar.getWidth() / 2, theBar.getY() + 2 - theBar.getHeight()
					/ 2, theBar.getWidth() - 4, theBar.getHeight() - 4);
			
		} catch (Exception e) {
			System.err.println("paintBar " + e.getMessage());
		}
		
		
		
		try {
			
		} catch (Exception e) {
			System.err.println("paintBar " + e.getMessage());
		}
		bar = theBar;
	}

	/**
	 * Drawing of the ball
	 */
	public void paintBall(Ball theBall) {
		if (gs == null)
			gs = this.getGraphics();

		gs.setColor(new Color(132, 55, 45));
		
		try {
			gs.fillOval(theBall.getXInt() - theBall.getRadius(),
					theBall.getYInt() - theBall.getRadius(), theBall.getRadius() * 2,
					theBall.getRadius() * 2);
		} catch (Exception e) {
			System.err.println("paintBall " + e.getMessage());
		}

		ball = theBall;
	}

	public void paintBricks(ArrayList<Brick> listOfBrick) {
		if (gs == null)
			gs = this.getGraphics();

		for (int i = 0; i < listOfBrick.size(); i++) {
			Brick theBrick = listOfBrick.get(i);
			
			gs.setColor(theBrick.getColor());
			//gs.setColor(new Color(.5f,.0f,.9f,.1f));
			/*try {
				if(gs==null)
					System.out.println("GS null !!!");
				gs.fillRect(grid.getXLeftFromBrick(theBrick) + 2,
						grid.getYTopFromBrick(theBrick) + 2, grid.getBrickWidth() - 4,
						grid.getBrickHeight() - 4);

			} catch (Exception e) {
				System.err.println("paintBricks " + e.getMessage());
				e.printStackTrace();
			}*/
			gs.fillRect(grid.getXLeftFromBrick(theBrick),
					grid.getYTopFromBrick(theBrick), grid.getBrickWidth(),
					grid.getBrickHeight());
			gs.setColor(Color.WHITE);
			gs.drawRect(grid.getXLeftFromBrick(theBrick), grid.getYTopFromBrick(theBrick), grid.getBrickWidth(), grid.getBrickHeight());
		}

		this.listOfBricks = listOfBrick;
	}
	
	public void paintBonusObjects(List<BonusObject> boList) {
		synchronized (boList)
		{
			this.boList = boList;
			if (gs == null)
				gs = this.getGraphics();
			// TODO : letters as static constant ?
			String letters[] = {"B", "L", "S", "W"};
			// Ball speed, Life, Score, bar Width
			for (BonusObject bo : boList)
			{
				//bo.draw(gs);
				double size = bo.getSize();
				int left = (int) Math.round(bo.getX() - size),
					top = (int) Math.round(bo.getY() - size),
					s = (int) Math.round(2 * size);
				/*try
				{
					BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource("pictures/bonus"+bo.getType()+".png"));
					gs.drawImage(img,
							left, top, left + s, top + s, 0, 0, img.getWidth(), img.getHeight(), null);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}*/
				gs.setColor(new Color(0f,0f,.5f,.7f));
				gs.fillOval(left, top, s, s);
				gs.setColor(Color.WHITE);
				gs.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
				FontMetrics fm = gs.getFontMetrics();
				Rectangle2D r = fm.getStringBounds(letters[bo.getType()], gs);
				int txtX = (int) Math.round(bo.getX() - r.getWidth() / 2);
				int txtY = (int) Math.round(bo.getY() - r.getHeight() / 2 + fm.getAscent());
				gs.drawString(letters[bo.getType()], txtX, txtY);
			}
		}
	}


	public void setGraph(Graphics g) {
		gs = g;
	}

	public void getBricksSquare(ArrayList<Brick> listOfBricks) {
		this.listOfBricks = listOfBricks;
	}

	public void setBall(Ball newBall) {
		this.ball = newBall;
	}
	
	public void setBar(Bar newBar) {
		this.bar = newBar;
	}

	public void setBrickList(ArrayList<Brick> newListOfBricks) {
		this.listOfBricks = newListOfBricks;
	}

	public void setBonusObjectsList(List<BonusObject> boList) {
		this.boList = boList;
	}
	public List<BonusObject> getBonusObjectsList() {
		return boList;
	}
}
