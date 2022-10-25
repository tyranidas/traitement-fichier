package components;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RecupFichier {

	public static List<String>  recupFichier() throws IOException{
		
		Path path = Paths.get("./open-food-facts.csv");
		
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		return lines;
		//test
		
	}
		

}
