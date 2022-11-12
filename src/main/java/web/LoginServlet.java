package web;
import DAO.LoginDao;
import classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name="/login" , urlPatterns = {"/Login","*.hh"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    @Override
    public void init() throws ServletException {loginDao = new LoginDao();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("model",new CreditModel());}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            if (loginDao.validate(user)) {
                response.sendRedirect("exam.jsp");
            }
            else {
                response.sendRedirect("login.jsp");}
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
