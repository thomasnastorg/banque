package Model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Compte {
    private int num;
    private Client client;
    private double solde;
    private double decouvert;

    public Compte()
    {

    }

    public Compte(int n, Client c)
    {
        num = n;
        solde = 0;
        this.client = c;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double unDecouvert) {

        if(this.solde >= (-unDecouvert)) { decouvert = unDecouvert; }
    }

    public void crediter(double mont)
    {
        solde = solde + mont;
    }

    public boolean debiter(double mont)
    {
        if (solde - mont < -decouvert)
        {
            return false;
        }
        else
        {
            solde = solde - mont;
            return true;
        }
    }

    @Override
    public String toString() {
        return"Nom: " + client.getNom() + " Prenom: " + client.getPrenom() + " Adresse: " + client.getAdresse() + " solde: "+ getSolde()  ;

    }
}
