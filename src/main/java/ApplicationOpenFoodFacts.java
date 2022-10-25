import java.util.Scanner;

public class ApplicationOpenFoodFacts {

	/** Point d'entrée de l'application */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("******** MENU RECENSEMENT ********");
		
		boolean running = true;
		
		while (running) {
			System.out.println("	-----------------	");
			System.out.println("Choisissez une option :");
			System.out.println("1 - Rechercher les meilleurs produits pour une Marque donnée");
			System.out.println("2 - Rechercher les meilleurs produits pour une Catégorie donnée");
			System.out.println("3 - Rechercher les meilleurs produits par Marque et par Catégorie");
			System.out.println("4 - Afficher les allergènes les plus courants");
			System.out.println("5 - Afficher les additifs les plus courants");
			System.out.println("6 - Sortir");
			String userChoice = scanner.nextLine();
		
			switch (userChoice) {
			case "1":
				
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				running = false;
				break;
			}
		}
		
		scanner.close();
	}
}
