package Model;

import java.util.ArrayList;

public class Client {

    private int num;
    private String nom;
    private String prenom;
    private String adresse;
    private ArrayList<Compte> comptes = new ArrayList<Compte>();
    public Client(int num, String nom, String prenom, String ad)
    {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = ad;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client{" +
                "num=" + num +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", comptes=" + comptes +
                '}';
    }
}
