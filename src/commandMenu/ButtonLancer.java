package commandMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import view.MainFrame;
import view.Menu;
import model.Game;
import controller.GameController;
import executer.Executer;

/**
 * Concrete command that handles a menu event.
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

public class ButtonLancer extends Command{
	private static MainFrame mainFrameView;
	private static JFrame frame;
	private static Game game;
	private static GameController gameController;

	@Override
	protected void executeImpl() {
		// TODO Auto-generated method stub
		Menu.getInstance().setVisible(false);
		initFrame();
		
		game = new Game(3);
		gameController = new GameController(game, mainFrameView);

		gameController.initGame();
		
	}

	private void initFrame() {

		mainFrameView = new MainFrame();

		frame = new JFrame("Casse-briques XP");
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("/pictures/arrierePlan.png"))));
		frame.setLayout(new FlowLayout());
		frame.setSize(Executer.WIN_WIDTH, Executer.WIN_HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(mainFrameView);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	

	}
}
