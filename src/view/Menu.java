package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commandMenu.*;
import executer.Executer;

/**
 * Displays the main menu's frame.
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

@SuppressWarnings("serial")
public class Menu extends JFrame{
	private static Menu instance = null ;
	private CommandButton jButtonLancerPartie ;
	private CommandButton jButtonConfiguration ;
	private CommandButton jButtonAPropos ;
	private CommandButton jButtonQuitter ;

	public synchronized static Menu getInstance(){
		if(instance == null)
			instance =  new Menu() ;
		return instance ;
	}
	
	public Menu(){
	    setTitle("Casse-briques XP - Menu principal");
	
		setPreferredSize(new Dimension(Executer.WIN_WIDTH, Executer.WIN_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initContent();
		
		pack();
        setResizable(false);
        setVisible(true);	
		setLocationRelativeTo(null); 
	}
	
	private void initContent() {
		initButtons();
		
		
		JLabel background=new JLabel(new ImageIcon(this.getClass().getResource("/pictures/logo.png")));
		add(background);
		background.setLayout(null);
		Insets insets = background.getInsets();
		
		JPanel jPanelButtons = new JPanel(new GridLayout(4,1,0,20)) ;
		
		jPanelButtons.setBackground(new Color(0,0,0,0));
		jPanelButtons.add(jButtonLancerPartie);
		jPanelButtons.add(jButtonConfiguration);
		jPanelButtons.add(jButtonAPropos);
		jPanelButtons.add(jButtonQuitter);
		
		JPanel jPanelBody = new JPanel(new GridBagLayout());
		jPanelBody.setBackground(new Color(0,0,0,0));
	    GridBagConstraints gbc = new GridBagConstraints();
	    jPanelBody.add(jPanelButtons, gbc);
	    
	    jPanelBody.setBounds(290 + insets.left, 130 + insets.top, 300, 300);
	    background.add(jPanelBody) ;	
	    
		
	}


	private void initButtons() {
		jButtonLancerPartie = new CommandButton("Lancer une nouvelle partie");
		jButtonConfiguration = new CommandButton("Configuration");
		jButtonAPropos = new CommandButton("A propos...");
		jButtonQuitter = new CommandButton("Quitter l'application");
		
		Command lancer = new ButtonLancer();
		Command apropos = new ButtonAPropos();
		Command quitter = new ButtonQuitter();

		jButtonLancerPartie.storeCommand(lancer);
		jButtonAPropos.storeCommand(apropos);
		jButtonQuitter.storeCommand(quitter);
		
	}

}
