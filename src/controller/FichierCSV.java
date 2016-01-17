package controller;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FichierCSV {
	
	private String nomFichier;
	
	public FichierCSV(String nom){
		this.nomFichier = nom;
	}
	
	public void writeAndReplace(List<String> lines) throws IOException, URISyntaxException{
		ClassLoader classLoader = getClass().getClassLoader();
		Path file = Paths.get(classLoader.getResource(this.nomFichier).toURI());
		Files.write(file, lines, Charset.forName("UTF-8"));
	}
	
	public List<String> readAll() throws NullPointerException, IOException, URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		if(classLoader == null)
			System.out.println("caca");
		URL fichier = classLoader.getResource(this.nomFichier);
		if(fichier == null)
			throw new IOException();
	
		Path path = Paths.get(fichier.toURI());
		if(path == null)
			System.out.println("pipi");
		List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
		return lines;
	}
	
}