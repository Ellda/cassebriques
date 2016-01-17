package commandMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Configuration;

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
		  //System.out.println("Key pressed code=" + e.getExtendedKeyCode() + ", char=" + e.getKeyChar() + " " + KeyEvent.getKeyText(e.getKeyCode()));
		  String touche = KeyEvent.getKeyText(e.getKeyCode());
		  if (touche.equals("Inconnu keyCode: 0x0"))
			  this.button.setText(""+e.getKeyChar());
		  else
			  this.button.setText(KeyEvent.getKeyText(e.getKeyCode()));
		  switch(this.numTouchePresse) {
		  case 0:  this.cfg.setGauche(e.getExtendedKeyCode());  break;
		  case 1:  this.cfg.setDroite(e.getExtendedKeyCode());  break;
		  case 2:  this.cfg.setQuitter(e.getExtendedKeyCode());  break;
		}
	    	JPanel grandparent = (JPanel)this.button.getParent().getParent();
	    	JFrame parentFrame = (JFrame) grandparent.getRootPane().getParent();
	    	parentFrame.pack();
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