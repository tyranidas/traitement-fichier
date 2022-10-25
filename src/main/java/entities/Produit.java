package entities;

import java.util.List;
import java.util.Map;

public class Produit {
    private Categorie categorie;
    private Marque marque;
    private String scoreNutritionnel;
    private Map<String,String> lstAttributs;
    private List<Ingredient> lstIngredient;
    private List<Additif> lstAdditif;
    private List<Allergene> lstAllegerne;


    public Produit(Categorie categorie, Marque marque, String scoreNutritionnel, Map<String, String> lstAttributs, List<Ingredient> lstIngredient, List<Additif> lstAdditif, List<Allergene> lstAllergene) {
        this.categorie = categorie;
        this.marque = marque;
        this.scoreNutritionnel = scoreNutritionnel;
        this.lstAttributs = lstAttributs;
        this.lstIngredient = lstIngredient;
        this.lstAdditif = lstAdditif;
        this.lstAllegerne = lstAllergene;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public Map<String, String> getLstAttributs() {
        return lstAttributs;
    }

    public void setLstAttributs(Map<String, String> lstAttributs) {
        this.lstAttributs = lstAttributs;
    }

    public List<Ingredient> getLstIngredient() {
        return lstIngredient;
    }

    public void setLstIngredient(List<Ingredient> lstIngredient) {
        this.lstIngredient = lstIngredient;
    }

    public List<Additif> getLstAdditif() {
        return lstAdditif;
    }

    public void setLstAdditif(List<Additif> lstAdditif) {
        this.lstAdditif = lstAdditif;
    }

    public List<Allergene> getLstAllegerne() {
        return lstAllegerne;
    }

    public void setLstAllegerne(List<Allergene> lstAllergene) {
        this.lstAllegerne = lstAllergene;
    }
}
