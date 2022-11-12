package web;
import DAO.SimulationDao;
import classes.Simulation;
import classes.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.CreditMetier;
import metier.SimulaionModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static java.lang.System.out;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet","*.php"})
public class ControllerServlet extends HttpServlet {
    private CreditMetier cm;
    private SimulationDao simulation;
    @Override
    public void init() throws ServletException{
        cm = new CreditMetier();
        simulation = new SimulationDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("model",new CreditModel());
        //request.setAttribute("sim",new Simulation());
        request.getRequestDispatcher("vueCredit.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("calc") != null) {
            double montant = Double.parseDouble(request.getParameter("montant"));
            double taux = Double.parseDouble(request.getParameter("taux"));
            int duree = Integer.parseInt(request.getParameter("duree"));
            String date = request.getParameter("date");
            String categorie = request.getParameter("categorie");
            //int visitCount = Integer.parseInt(request.getParameter("visitCount"));
            CreditModel model = new CreditModel();
            model.setDuree(duree);
            model.setMontant(montant);
            model.setTaux(taux);
            double res = cm.calculMensualite(montant, duree, taux);
            model.setMensualite(res);
            request.setAttribute("model", model);
            Simulation sima = new Simulation();
            sima.setDuree(duree);
            sima.setMensualite(res);
            sima.setTaux(taux);
            sima.setMontant(res);
            sima.setDate(date);
            sima.setCategorie(categorie);
            request.setAttribute("sima", sima);
            // request.getRequestDispatcher("vueCredit.jsp").forward(request,response);
            int status = SimulationDao.save(sima);
            if (status > 0) {
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("vueCredit.jsp").include(request, response);
            } else {
                out.println("Sorry! unable to save record");
            }
            out.close();
        } else if (request.getParameter("cherch") != null){
            SimulaionModel sim=new SimulaionModel();
            sim.setMotCle(request.getParameter("motCle"));
            List<Simulation> simulations=  SimulationDao.simulationsParMC(sim.getMotCle());
            sim.setSimulations(simulations);
            request.setAttribute("sim",sim);
            request.getRequestDispatcher("vueCredit.jsp").forward(request,response);
        }


    }
}