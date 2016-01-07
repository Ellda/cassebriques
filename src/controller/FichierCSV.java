package controller;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FichierCSV {
	
	private String nomFichier;
	//private String nomDefault;
	
	public FichierCSV(String nom){
		this(nom, nom);
	}
	
	public FichierCSV(String nom, String nomDefault){
		this.nomFichier = nom;
		//this.nomDefault= nomDefault;

	}
	
	
	public void writeAndReplace(List<String> lines) throws IOException{
		ClassLoader classLoader = getClass().getClassLoader();
		try
		{
			Path file = Paths.get(classLoader.getResource(this.nomFichier).toURI());
			Files.write(file, lines, Charset.forName("UTF-8"));
		}
		catch (URISyntaxException e)
		{
			// TODO : error handling
			e.printStackTrace();
		}
	}
	
	public List<String> readAll() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		//Path file = Paths.get(URLDecoder.decode(classLoader.getResource(this.nomFichier).getFile(), "UTF-8" ));
		try
		{
			Path file = Paths.get(classLoader.getResource(this.nomFichier).toURI());
			List<String> lines = Files.readAllLines(file, Charset.forName("UTF-8"));
			return lines;
		}
		catch (URISyntaxException e)
		{
			// TODO : error handling
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
	
}