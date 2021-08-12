package io;

public class Personne {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String profession;
    private String dialogue;

    public Personne() {
    }

    public Personne(String nom, String dialogue) {
        this.nom = nom;
        this.dialogue = dialogue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    @Override
    public String toString() {
        return "Personne[" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                ", dialogue='" + dialogue + '\'' +
                ']';
    }
}
