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

		for (String line : lines){
			String[]  arrLine = line.replace("|", ";").split(";");
			getIngredients(arrLine[4]);
			i++;
		}

		return lines;
	}

	public static void getIngredients(String lineIngredients){

		String[]  arrIngredient = lineIngredients.replace("_","").split("[,\\-]");

		for(String unIngredient : arrIngredient){
			unIngredient = unIngredient.replace(".","").trim().replace(" ,",",");

			lstIngredient.add(new Ingredient(unIngredient));

			//System.out.print(unIngredient+",");

		}
		//System.out.println("");
	}
}
