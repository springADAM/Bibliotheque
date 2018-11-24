package Bibliotheque;

import java.util.Date;

public class Livre {
    private String titre ;
    private String auteur ;
    private String categorie;
    private int quantity;
    private Date dateDeSortie ;



    public Livre(String titre, String auteur, String categorie,int quantity, Date dateDeSortie) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.quantity=quantity;
        this.dateDeSortie = dateDeSortie;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateDeSortie() {
        return dateDeSortie;
    }
    public void setDateDeSortie(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    @Override
    public String toString() {
        return "Livre : " +
                "titre :'" + titre + '\'' +
                ", auteur :'" + auteur + '\'' +
                ", categorie :'" + categorie + '\'' +
                ", quantity :'" + quantity + '\'' +
                ", dateDeSortie :" + dateDeSortie +"\n";
    }
}
