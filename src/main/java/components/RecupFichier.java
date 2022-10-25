package components;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RecupFichier {

	public static List<String>  recupFichier() throws IOException{
		// TODO Auto-generated method stub
		///traitement-fichier/src/main/java/components/RecupFichier.java
		//:\Users\tyran\Documents\workspace-spring-tool-suite-4-4.16.0.RELEASE\traitement-fichier\src\main\resources\open-food-facts.csv
		Path path = Paths.get("./open-food-facts.csv");
		boolean exists = Files.exists(path);
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		return lines;
		
	}
		

}
