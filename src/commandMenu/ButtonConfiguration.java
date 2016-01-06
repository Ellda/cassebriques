package commandMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.GameController;
import executer.Executer;
import model.Game;
import view.ConfigurationFrame;
import view.MainFrame;
import view.Menu;

public class ButtonConfiguration extends Command {
	private static ConfigurationFrame configurationFrameView;
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
		configurationFrameView = new ConfigurationFrame();

		frame = new JFrame("Casse-briques Configuration");
		frame.setLayout(new BorderLayout());
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(configurationFrameView);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
	}

}
