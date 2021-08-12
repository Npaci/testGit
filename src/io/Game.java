package io;

public class Game {
    private int id;
    private int age_min;
    private int nbr_joueur_min;
    private int nbr_joueur_max;
    private String nom;
    private String editeur;

    public Game(int id, int age_min, int nbr_joueur_min, int nbr_joueur_max, String nom, String editeur) {
        this.id = id;
        this.age_min = age_min;
        this.nbr_joueur_min = nbr_joueur_min;
        this.nbr_joueur_max = nbr_joueur_max;
        this.nom = nom;
        this.editeur = editeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge_min() {
        return age_min;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public int getNbr_joueur_min() {
        return nbr_joueur_min;
    }

    public void setNbr_joueur_min(int nbr_joueur_min) {
        this.nbr_joueur_min = nbr_joueur_min;
    }

    public int getNbr_joueur_max() {
        return nbr_joueur_max;
    }

    public void setNbr_joueur_max(int nbr_joueur_max) {
        this.nbr_joueur_max = nbr_joueur_max;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    @Override
    public String toString() {
        return "Game[" +
                "id=" + id +
                ", age_min=" + age_min +
                ", nbr_joueur_min=" + nbr_joueur_min +
                ", nbr_joueur_max=" + nbr_joueur_max +
                ", nom='" + nom + '\'' +
                ", editeur='" + editeur + '\'' +
                ']';
    }
}
