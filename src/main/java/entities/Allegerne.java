package entities;


/**
 * 
 * @author MyriamAgag
 * 
 * Représente un allerge
 *
 */

public class Allegerne {

	/**
	 * Nom de l'allergène
	 */
	
	private String libelle;

	/**
	 * 
	 * @param libelle Nom de l'allergène
	 *
	 */
	public Allegerne(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	

}
