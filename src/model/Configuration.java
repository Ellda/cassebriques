package model;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import controller.FichierCSV;

public class Configuration {
	private int gauche, droite, quitter;
	private String configurationFile;
	private boolean son;
	
	public Configuration() {
		this.configurationFile = "configuration/default.csv";
		try {
			importConfig();
		} catch (IOException e) {
			defaultConfig();
		}

	}
	public Configuration(Configuration cfg) {
		this.configurationFile = cfg.configurationFile;
		this.gauche = cfg.gauche;
		this.droite = cfg.droite;
		this.quitter = cfg.quitter;
		this.son = cfg.son;
	}
	
	private void importConfig() throws IOException {
		try{
			FichierCSV monFichier = new FichierCSV(this.configurationFile);
			List<String> liste = monFichier.readAll();
			this.gauche = Integer.parseInt(liste.get(0).split(";")[1]);
			this.droite = Integer.parseInt(liste.get(1).split(";")[1]);
			this.quitter = Integer.parseInt(liste.get(2).split(";")[1]);
			this.son = Boolean.parseBoolean(liste.get(3).split(";")[1]);
		}
		catch(Exception e){
			defaultConfig();
		}
	}
	
	public void defaultConfig(){
		this.droite = KeyEvent.VK_RIGHT;
		this.gauche = KeyEvent.VK_LEFT;
		this.quitter = KeyEvent.VK_ESCAPE;
		this.son = true;
		this.configurationFile = "configuration/default.csv";
	}
	

	public int getGauche() {
		return gauche;
	}
	public void setGauche(int gauche) {
		if(gauche > 0)
			this.gauche = gauche;
	}
	public int getDroite() {
		return droite;
	}
	public void setDroite(int droite) {
		if(droite > 0)
			this.droite = droite;
	}
	public int getQuitter() {
		return quitter;
	}
	public void setQuitter(int quitter) {
		if(quitter > 0)
			this.quitter = quitter;
	}
	public boolean isSon() {
		return this.son;
	}
	public void setSon(boolean son) {
		this.son = son;
	}
	
	private List<String> exportLines(){
		List<String> listes = new ArrayList<String>();	
		listes.add("gauche;"+String.valueOf(this.gauche));
		listes.add("droite;"+String.valueOf(this.droite));
		listes.add("quitter;"+String.valueOf(this.quitter));
		listes.add("son;"+String.valueOf(this.son));
		return listes;
		
	}
	
	public void save() throws IOException, URISyntaxException{
		FichierCSV monFichier = new FichierCSV(this.configurationFile);
		monFichier.writeAndReplace(this.exportLines());
	}



	public void toggleSon() {
		this.son = !this.son;
	}
}
