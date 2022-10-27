package services;

import components.RecupFichier;
import entities.Produit;
import java.util.List;
import java.util.Scanner;


public abstract class MenuService {
	
	/**
	 * Permet de traiter le fichier food
	 * @param food
	 * @param scanner
	 */
	public abstract void traiter(Integer food ,Scanner scanner);

	public static String afficherMessage(String message){
		Scanner scan = new Scanner(System.in).useDelimiter("\n");

		System.out.println("Ecrire un nom de "+ message);

		return  scan.nextLine();
	}

	public static void afficherProduitParMarque(String nom){
		List<Produit> lstStock = RecupFichier.leStock.getLstProduit();
		boolean test = false;


		if(RecupFichier.marques.get(nom) == null){
			System.out.println("Non trouvé dans la base");
			return;
		}

		nom = nom.toLowerCase();

		for(Produit produit : lstStock){
			String marque = produit.getMarque().getNom().toLowerCase();
			// Meilleur produit ici considéré avc le score nutritionnel A
			// A voir si on fait sur B ou autre ?
			if(produit.getScoreNutritionnel().contains("a") && marque.equals(nom)){
				System.out.println(marque+ " " + produit.getNom() + " " + produit.getScoreNutritionnel());
				test = true;
			}
		}

		if(!test){
			System.out.println("Pas de produit ayant un bon nutriscore dans cette marque");
		}
	}
}
