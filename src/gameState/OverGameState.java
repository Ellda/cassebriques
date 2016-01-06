package gameState;

import javax.swing.*;

import view.Menu;
import controller.FichierCSV;
import controller.GameController;

import model.Game;

import java.io.*;
import java.net.URLDecoder;
import java.util.*;

/**
 * 
 * This 'pause' state is called when the game is over. It stops the timer and displays a
 * option panel. According to the answer given by the user, it can switch to a
 * new game or close the program.
 * 
 * @author Antoine Fonfria - 14 129 748
 * @author Baptiste Jaeckert 14 129 775
 * @author Jonathan Diaz-Muy 13 041 479
 * @author Adrien Burel 14 126 607
 * @author Landry Modeste Goutondji  14 000 626
 * @author Jérémy Collard 14 129 766
 * @author Mentor Bajraktari 14 129 757
 * @author Olivier Scheffler 12 179 288
 * @author Elliot Gémus-Prévost 13 111 198
 * @author Samuel Arseneault 13 161 801
 * @author Djenebou Monique Dembele 10 103 210
 * @author Florent Gargot 14 129 784
 */

public class OverGameState implements GameState {

	private GameController gameController;

	public OverGameState(GameController gameController) {
		this.gameController = gameController;
	}

	@Override
	public void runGame() {

		System.out.println("Game Over");
		
		Game.playSound("smb_gameover.wav");

		// Stop of the game timer
		gameController.getTimer().cancel();

		// Computation of scores
		
		
		JOptionPane.showMessageDialog(gameController.getView(),computeScores("scores/bestscores.csv"));

		// Ask window if new game
		int option = JOptionPane.showConfirmDialog(gameController.getView(),
				"Vous avez perdu ! Voulez vous rejouer ?", "Game Over",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		// If yes : reseting and restart timer
		if (option == JOptionPane.YES_OPTION) {
		
			gameController.initGame();

		} else {
						
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(gameController.getView());
			topFrame.dispose();
			Menu.getInstance().setVisible(true);
		}

	}

	/**
	 * Fonction qui récupère le score final pour l'enregistrer avec le pseudo du joueur
	 * @param scoresFile , String, contient le chemin du fichier dans les ressources
	 * @return panel, une fenêtre pop-up dans laquelle on voit les scores
	 */
	private JPanel computeScores(String scoresFile) {
		
		//score corresponds au score final de la partie
		int score = gameController.getGame().getBrickController().getScore();
		
		//On créé une JTable contenant les scores
		JTable table_scores = getScoresFromFile(scoresFile, score);
		
		//On met le tableau des scores dans une fenêtre déroulante
		JScrollPane spTable = new JScrollPane(table_scores);
		
		//On créé une fenêtre pop-up
		JPanel panel = new JPanel();
		
		//On ajoute la fenêtre déroulante dans la fenêtre pop-up
		panel.add(spTable);
		
		return panel;
	}
	
	/**
	 * Fonction qui lit le fichier des scores puis ajoute le score à ceux-ci
	 * @param resource, le chemin vers le fichier dans les ressources
	 * @param score, le score du joueur à la fin du jeu
	 * @return table, une JTable contenant les scores avec le nouveau ajouté
	 */
	private JTable getScoresFromFile(String resource, int score) {
		
		FichierCSV f = new FichierCSV(resource);

	
		
		String pseudoDefaut = "PSEUDO";
		
		//Liste qui va recupérer les scores
		List<String[]> scores = new ArrayList<String[]>();

		try {
			//Get file from resources folder
			List<String> listeScore = f.readAll();
			
			//Tant que la ligne lue n'est pas "null" on ajoute la ligne à la liste des scores. La ligne est de la forme : "pseudo;score"

			for (String item : listeScore) {
				String[] record= item.split(";");
				if(record[0].contains("*")){
					record[0] = record[0].replace("*", "");
					pseudoDefaut = record[0];
				}
				scores.add(record);

			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// On affiche une fenêtre pour demander le pseudo du joueur
		String s = (String)JOptionPane.showInputDialog(
				gameController.getView(),
				"Entrez votre pseudo pour sauvegarder votre score:\n",
				"Félicitations. Score = " + String.valueOf(score),
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				pseudoDefaut);
		
		//On ajoute le score à la liste des scores
		if ((s != null) && (s.length() > 0)) {
			String[] toAdd = new String[2];
			toAdd[1] = String.valueOf(score);
			toAdd[0] = "*" + s;
			scores.add(toAdd);
		}
		
		//On trie la liste des scores pour ordonner le dernier score ajouté
		Collections.sort(scores, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
			}
		});
		
		try {
			//Get file from resources folder
			
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(URLDecoder.decode(classLoader.getResource(resource).getFile(),"UTF-8"));
			
			List<String> listeScoreWrite = new ArrayList<String>();
			//On ecrit chaque ligne une par une dans l'ordre
			for( String[] line : scores){
				listeScoreWrite.add(line[0] + ";" + line[1]);
			}
			f.writeAndReplace(listeScoreWrite);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//On remplit la table des scores pour la renvoyer
		JTable table=new JTable(scores.size(),2);
		int row=0;
		for(String[] entry: scores){
			table.setValueAt(entry[0],row,0);
			table.setValueAt(entry[1],row,1);
			row++;
		}

		return table;

	}

}
