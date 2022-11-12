package metier;

import classes.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulaionModel {
    private String motCle;
    private List<Simulation> simulations=new ArrayList<Simulation>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Simulation> getSimulations() {
        return simulations;
    }

    public void setSimulations(List<Simulation> simulations) {
        this.simulations = simulations;
    }





}
