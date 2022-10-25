package components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import entities.Categorie;

public class RecupFichier {
	public static Categorie categorie;
	

	public static void main(String[] args) throws IOException  
	{
		RecupFichier recupFichier = new RecupFichier();
		Path path = Paths.get(".\\src\\main\\data\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(0);
//		
 for (int i = 0; i < lines.size(); i++) {
     String replaceString=lines.get(i).replace("|",";"); 
		String[] line = replaceString.split(";");

  categorie = new Categorie(line[0]) ;
  System.out.println(categorie.getLibelle());
 	}


	

 
}
}
 