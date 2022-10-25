package components;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RecupFichier {

	public static void main(String[] args) throws IOException {
	//public static List<String> recupData() throws IOException
	//traitement-fichier\src\main\java\components\RecupFichier.java
		//traitement-fichier\src\main\data\open-food-facts.csv
		
		Path path = Paths.get("./open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		System.out.println(lines.get(1));
		//return lines;
	}
}
