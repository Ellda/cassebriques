package commandMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import model.Configuration;
import view.Menu;

public class ToucheButton  implements KeyListener, ActionListener{

	private JButton button;
	private Configuration cfg;
	private int numTouchePresse;
	
	public ToucheButton(JButton btn, Configuration cfg, int i) {
		this.button = btn;
		this.cfg = cfg;
		this.numTouchePresse = i;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.button.setText("...");
		button.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		  System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
		  this.button.setText(KeyEvent.getKeyText(e.getKeyCode()));
		  switch(this.numTouchePresse) {
		  case 0:  this.cfg.setGauche(e.getKeyCode());  break;
		  case 1:  this.cfg.setDroite(e.getKeyCode());  break;
		  case 2:  this.cfg.setQuitter(e.getKeyCode());  break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}