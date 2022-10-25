package components;

import entities.Ingredient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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


public class RecupFichier {
	public static HashMap<String, Categorie> categories;
	public static HashMap<String, Marque> marques;
	private static HashMap<String, Ingredient> ingredient;

	private RecupFichier() {
		super();
		RecupFichier.ingredient = new HashMap<>();
		RecupFichier.categories = new HashMap<>();
		RecupFichier.marques = new HashMap<>();
	}

	public static RecupFichier getInstance() throws IOException
	{
		RecupFichier recupFichier = new RecupFichier();
		Path path = Paths.get(".\\src\\main\\data\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(0);

		for (String line : lines) {
			String[] tokens = line.replace("|", ";").split(";");

			Categorie categorie = categories.get(tokens[0]);
			if(categorie == null) {
				categorie = new Categorie(tokens[0]);
				categories.put(tokens[0], categorie);
			}

			Marque marque = marques.get(tokens[1]);
			if(marque == null) {
				marque = new Marque(tokens[1]);
				marques.put(tokens[1], marque);
			}

			getIngredients(tokens[4]);
		}

		return recupFichier;
	}

	public static void getIngredients(String lineIngredients){
		String[]  arrIngredient = lineIngredients.replace("_","").trim().split("[,\\-]");

		for(String unIngredient : arrIngredient){

			unIngredient = unIngredient.replace(".","").trim().toLowerCase();
			Ingredient newIngredient = ingredient.get(lineIngredients);

			if(newIngredient == null) {
				newIngredient = new Ingredient(unIngredient);
				ingredient.put(unIngredient, newIngredient);
			}

		}
	}
}