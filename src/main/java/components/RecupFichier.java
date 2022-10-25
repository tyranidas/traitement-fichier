package components;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import entities.Allergene;
import entities.Marque;

public class RecupFichier {
	public static HashMap<String, Marque> marques;
	public static HashMap<String, Allergene> allergenes;
	
	private RecupFichier() {
		super();
		RecupFichier.marques = new HashMap<>();
		RecupFichier.allergenes = new HashMap<>();
	}
	
	public static RecupFichier getInstance() throws IOException
	{
		RecupFichier recupFichier = new RecupFichier();
		Path path = Paths.get(".\\src\\main\\resources\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(0);
		
		for (String line : lines) {

			String[] tokens = new String[30];
			for (int i = 0; i < line.split("\\|").length; i++) {
				tokens[i] = line.split("\\|")[i];
			}
			Marque marque = marques.get(tokens[1]);
			if(marque == null) {
				marque = new Marque(tokens[1]);
				marques.put(tokens[1], marque);
			}
			
			ArrayList<Allergene> lstAllergenes = RecupFichier.initAllergenes(tokens[28]);
		}
		
		return recupFichier;
	}
	
	private static ArrayList<Allergene> initAllergenes(String lineAllergenes) {
		lineAllergenes = lineAllergenes == null ? "" : lineAllergenes;
		String[] allergenes = lineAllergenes.split(",");
		ArrayList<Allergene> lstAllergenes = new ArrayList<>();
		for (String newAllergene : allergenes) {
			newAllergene = newAllergene.toLowerCase().replace("fr:", "").replace("en:", "").replace("*", "").trim();
			Allergene allergene = RecupFichier.allergenes.get(newAllergene);
			if(allergene == null) {
				allergene = new Allergene(newAllergene);
				RecupFichier.allergenes.put(newAllergene, allergene);
			}
			lstAllergenes.add(allergene);
		}
		
		return lstAllergenes;
	}
}
