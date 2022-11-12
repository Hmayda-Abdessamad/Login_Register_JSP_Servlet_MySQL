package metier;
import DAO.SimulationDao;
import classes.Simulation;
import web.CreditModel;

import java.util.List;

public class TestMetier {
    public static void main(String[] args){
        Simulation sim=new Simulation(4,5555,4,4,"6","cat1");
        SimulationDao s=new SimulationDao();

        List<Simulation> sims=s.getAllSimulation();
        for(Simulation r:sims){
            System.out.println(r.getId());
        }

    }
}
