package controller;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FichierCSV {
	
	private String nomFichier;
	private String nomDefault;
	
	public FichierCSV(String nom){
		this(nom, nom);
	}
	
	public FichierCSV(String nom, String nomDefault){
		this.nomFichier = nom;
		this.nomDefault= nomDefault;

	}
	
	
	public void writeAndReplace(List<String> lines) throws IOException{
		Path file = Paths.get(this.nomFichier);
		System.out.println(file.toString());
		Files.write(file, lines, Charset.forName("UTF-8"));
	}
	
	public List<String> readAll() throws IOException {
		Path file = Paths.get(this.nomFichier);
		List<String> lines = Files.readAllLines(file, Charset.forName("UTF-8"));
		return lines;
	}
	
}
