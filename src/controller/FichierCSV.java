package controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
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
		ClassLoader classLoader = getClass().getClassLoader();
		Path file = Paths.get(URLDecoder.decode(classLoader.getResource(this.nomFichier).getFile(), "UTF-8" ));
		Files.write(file, lines, Charset.forName("UTF-8"));
	}
	
	public List<String> readAll() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		Path file = Paths.get(URLDecoder.decode(classLoader.getResource(this.nomFichier).getFile(), "UTF-8" ));
		List<String> lines = Files.readAllLines(file, Charset.forName("UTF-8"));
		return lines;
	}
	
}