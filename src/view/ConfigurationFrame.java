package view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import commandMenu.ToucheButton;
import model.Configuration;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ConfigurationFrame extends JPanel{
	
	private JButton btnTouches ;
	private Configuration config;

	public ConfigurationFrame() {
		config = new Configuration("configuration/default.csv");
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblGauche = new JLabel("Gauche");
		panel.add(lblGauche);
		
		btnTouches = new JButton(KeyEvent.getKeyText(config.getGauche()));
		panel.add(btnTouches);
		btnTouches.addActionListener( new ToucheButton(btnTouches, config, 0));

		JLabel lblDroite = new JLabel("Droite");
		panel.add(lblDroite);
		
		JButton btnTouche = new JButton(KeyEvent.getKeyText(config.getDroite()));
		panel.add(btnTouche);
		btnTouche.addActionListener( new ToucheButton(btnTouche, config, 1));

		JLabel lblQuitter = new JLabel("Quitter");
		panel.add(lblQuitter);
		
		JButton btnTouche_1 = new JButton(KeyEvent.getKeyText(config.getQuitter()));
		panel.add(btnTouche_1);
		btnTouche_1.addActionListener( new ToucheButton(btnTouche_1, config, 2));

		JLabel lblSon = new JLabel("Son");
		panel.add(lblSon);
		
		JCheckBox checkBox = new JCheckBox("");
		panel.add(checkBox);
		
		JLabel lblConfiguration = new JLabel("Configuration");
		add(lblConfiguration, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnValider = new JButton("Valider");
		panel_1.add(btnValider);
		
		JButton btnRetour = new JButton("Retour");
		panel_1.add(btnRetour);
		
		btnRetour.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	Menu.getInstance().setVisible(true);		    }
		});

		btnValider.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	//TODO sauvegarde configuration
		    	try {
					config.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Impossible d'enregistrer la configuration, le système est peut-etre occupé. Veuillez reessayez plus tards.");

					e1.printStackTrace();
				}
		    }
		});
		
		checkBox.addItemListener( new ItemListener()
		{
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		    	if(e.getStateChange() == 1)
		    		config.setSon(true);
		    	else		    		
		    		config.setSon(false);		    		
		    }
		});

	}


}
