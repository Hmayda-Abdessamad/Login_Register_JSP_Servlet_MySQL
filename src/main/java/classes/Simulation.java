package classes;
import DAO.SimulationDao;

import java.io.Serializable;
import java.util.Date;

public class Simulation implements Serializable {
    private int id;
    private double montant;
    private int duree;
    private double taux;
    private double mensualite;
    private String date;
    private String categorie;

    private static int comp;


    public Simulation(double montant, int duree, double taux, double mensualite,String date,String categorie) {
        super();
        this.date=date;this.categorie=categorie;
        this.id +=comp;this.montant = montant;this.duree = duree;this.taux = taux;this.mensualite = mensualite;comp+=1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Simulation() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public int getDuree() {
        return duree;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }
    public double getTaux() {
        return taux;
    }
    public void setTaux(double taux) {
        this.taux = taux;
    }
    public double getMensualite() {
        return mensualite;
    }
    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
    }

}
