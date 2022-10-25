package components;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import entities.Marque;

public class RecupFichier {
	public static HashMap<String, Marque> marques;
	
	private RecupFichier() {
		super();
		RecupFichier.marques = new HashMap<>();
	}
	
	public static RecupFichier getInstance() throws IOException
	{
		RecupFichier recupFichier = new RecupFichier();
		Path path = Paths.get(".\\src\\main\\resources\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(0);
		
		for (String line : lines) {
			String[] tokens = line.replace("|", ";").split(";");
			Marque marque = marques.get(tokens[1]);
			if(marque == null) {
				marque = new Marque(tokens[1]);
				marques.put(tokens[1], marque);
			}
		}

		return recupFichier;
	}
}
