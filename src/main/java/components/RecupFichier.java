package components;

import entities.Ingredient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RecupFichier {

	private static List<Ingredient> lstIngredient = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		recupData();
	}

	public static List<String> recupData() throws IOException
	{
	
		Path path = Paths.get(".\\src\\main\\data\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(1);


		//for (String line : lines){
		for(int i = 1; i< 10; i++){
			String[]  arrLine = lines.get(i).replace("|", ";").split(";");
			getIngredients(arrLine[4]);
		}

		return lines;
	}

	public static void getIngredients(String lineIngredients){

		String[]  arrIngredient = lineIngredients.split(",");

		for(String unIngredient : arrIngredient){
			lstIngredient.add(new Ingredient(unIngredient));
		}
	}
}
