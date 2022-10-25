package components;

public class Marque {
	String nom;

	private Marque(String nom) {
	
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Marque [nom=" + nom + "]";
	}
	
	
}
