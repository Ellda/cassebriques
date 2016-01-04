package model;

import java.awt.event.KeyEvent;

public class Configuration {
	private int gauche, droite, quitter;
	private boolean son;
	
	public Configuration() {
		this.droite = KeyEvent.VK_RIGHT;
		this.gauche = KeyEvent.VK_LEFT;
		this.quitter = KeyEvent.VK_ESCAPE;
		this.son = true;
	}
	
	public int getGauche() {
		return gauche;
	}
	public void setGauche(int gauche) {
		this.gauche = gauche;
	}
	public int getDroite() {
		return droite;
	}
	public void setDroite(int droite) {
		this.droite = droite;
	}
	public int getQuitter() {
		return quitter;
	}
	public void setQuitter(int quitter) {
		this.quitter = quitter;
	}
	public boolean isSon() {
		return son;
	}
	public void setSon(boolean son) {
		this.son = son;
	}
	
	
}
