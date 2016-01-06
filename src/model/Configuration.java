package model;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.FichierCSV;

public class Configuration {
	private int gauche, droite, quitter;
	private String configurationFile;
	private boolean son;
	
	public Configuration() {
		this("configuration/default.csv");
	}
	
	

	public Configuration(String confFile) {
		this.configurationFile = confFile;
		try {
			importConfig();
		} catch (IOException e) {
			defaultConfig();
		}
	}
	
	private void importConfig() throws IOException {
		FichierCSV monFichier = new FichierCSV(this.configurationFile);
		List<String> liste = monFichier.readAll();
		//try{
			this.gauche = Integer.parseInt(liste.get(0).split(";")[1]);
			this.droite = Integer.parseInt(liste.get(1).split(";")[1]);
			this.quitter = Integer.parseInt(liste.get(2).split(";")[1]);
			this.son = Boolean.parseBoolean(liste.get(3).split(";")[1]);
		/*}
		catch(Exception e){
			defaultConfig();
		}*/
	}
	
	private void defaultConfig(){
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
	
	private List<String> exportLines(){
		List<String> listes = new ArrayList<String>();	
		listes.add("gauche;"+String.valueOf(this.gauche));
		listes.add("droite;"+String.valueOf(this.droite));
		listes.add("quitter;"+String.valueOf(this.quitter));
		listes.add("son;"+String.valueOf(this.son));
		return listes;
		
	}
	
	public void save() throws IOException{
		FichierCSV monFichier = new FichierCSV(this.configurationFile);
		monFichier.writeAndReplace(this.exportLines());
	}



	public void toggleSon() {
		this.son = !this.son;
	}
}
