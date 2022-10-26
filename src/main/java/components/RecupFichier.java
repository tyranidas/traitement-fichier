package components;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import entities.Marque;
import entities.Categorie;
import entities.Ingredient;
import entities.Allergene;

public class RecupFichier {

	public static HashMap<String, Categorie> categories;
	public static HashMap<String, Marque> marques;
	public static HashMap<String, Ingredient> ingredients;
	public static HashMap<String, Allergene> allergenes;

	private RecupFichier() {
		super();
		RecupFichier.categories = new HashMap<>();
		RecupFichier.marques = new HashMap<>();
		RecupFichier.ingredients = new HashMap<>();
		RecupFichier.allergenes = new HashMap<>();
	}

	public static RecupFichier getInstance() throws IOException {
		RecupFichier recupFichier = new RecupFichier();
		Path path = Paths.get(".\\src\\main\\resources\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(0);

		for (String line : lines) {

			String[] tokens = new String[30];
			for (int i = 0; i < line.split("\\|").length; i++) {
				tokens[i] = line.split("\\|")[i];
			}

			Categorie categorie = categories.get(tokens[0]);
			if (categorie == null) {
				categorie = new Categorie(tokens[0]);
				categories.put(tokens[0], categorie);
			}

			Marque marque = marques.get(tokens[1]);
			if (marque == null) {
				marque = new Marque(tokens[1]);
				marques.put(tokens[1], marque);
			}

			ArrayList<Allergene> lstAllergenes = RecupFichier.initAllergenes(tokens[28]);

			ArrayList<Ingredient> lstIngredients = RecupFichier.initIngredients(tokens[4]);

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
			if (allergene == null) {
				allergene = new Allergene(newAllergene);
				RecupFichier.allergenes.put(newAllergene, allergene);
			}
			lstAllergenes.add(allergene);
		}

		return lstAllergenes;
	}

	private static ArrayList<Ingredient> initIngredients(String lineIngredients) {
		String[] arrIngredient = lineIngredients.replace("_", "").trim().split("[,\\-]");
		ArrayList<Ingredient> lstIngredients = new ArrayList<>();

		for (String strIngredient : arrIngredient) {

			strIngredient = strIngredient.replace(".", "").trim().toLowerCase();
			Ingredient newIngredient = ingredients.get(strIngredient);

			if (newIngredient == null) {
				newIngredient = new Ingredient(strIngredient);
				ingredients.put(strIngredient, newIngredient);
			}
			lstIngredients.add(newIngredient);
		}

		return lstIngredients;
	}
}
