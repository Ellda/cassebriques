package commandMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.GameController;
import executer.Executer;
import model.Game;
import view.MainFrame;
import view.Menu;

public class CommandConfiguration extends Command {
	private static MainFrame mainFrameView;
	private static JFrame frame;
	private static Game game;
	private static GameController gameController;

	@Override
	protected void executeImpl() {
		// TODO Auto-generated method stub
		Menu.getInstance().setVisible(false);
		initFrame();

	}

	private void initFrame() {
		frame = new JFrame("Casse-briques Configuration");
		frame.setLayout(new BorderLayout());
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
