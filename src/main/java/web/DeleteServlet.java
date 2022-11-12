package web;

import DAO.SimulationDao;
import classes.Simulation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import metier.SimulaionModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Simulation model = new Simulation();
        model.setId(id);
        SimulationDao.delete(model.getId());
        response.sendRedirect("vueCredit.jsp");

}

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    }
}
