package web;

import DAO.SimulationDao;
import classes.Simulation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import metier.CreditMetier;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "EditServlet", value = "/EditServlet")
public class EditServlet extends HttpServlet {
    private CreditMetier cm = new CreditMetier();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double montant = Double.parseDouble(request.getParameter("montant"));
        double taux = Double.parseDouble(request.getParameter("taux"));
        int duree = Integer.parseInt(request.getParameter("duree"));
        Simulation model = new Simulation();
        model.setId(id);
        model.setDuree(duree);
        model.setMontant(montant);
        model.setTaux(taux);
        double res = cm.calculMensualite(montant,duree,taux);
        model.setMensualite(res);

        try {
            Connection con = SimulationDao.getConnection();
            String sql = "update simulation set montant=?, taux=?, duree=?, mensualite=? where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1,model.getMontant());
            pst.setDouble(2,model.getTaux());
            pst.setInt(3,model.getDuree());
            pst.setDouble(4,model.getMensualite());
            pst.setInt(5,model.getId());
            int value = pst.executeUpdate();
            if (value > 0){
                request.getSession().setAttribute("sm","Product Saved Successfully");
            }else{
                request.getSession().setAttribute("em","Product not Saved");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("vueCredit.jsp").forward(request,response);
    }
}

