<%@ page import="web.CreditModel" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="DAO.SimulationDao" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="classes.Simulation" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 24/10/2022
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%
    Simulation model = (Simulation) request.getAttribute("model");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Similateur Crédit</title>
</head>
<body>

<div>
    <form  action="EditServlet" method="GET">
        <%
            String id = request.getParameter("id");

            Connection con = SimulationDao.getConnection();
            String sql = "select * from simulation where id="+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
        %>
        <table>
            <tr>
                <td>DUREE :</td>
                <td><input type="text" name="duree" value="<%= rs.getInt("duree")%>"><input type="hidden" name="id" value="<%= rs.getInt("id")%>" ></td>
                <td></td>
            </tr>
            <tr>
                <td>MONTANT :</td>
                <td><input type="text" name="montant" value="<%= rs.getDouble("montant")%>" ></td>
                <td></td>
            </tr>
            <tr>
                <td>TAUX :</td>
                <td><input name="taux" type="text" value="<%= rs.getDouble("taux")%>" ></td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="update" value="Update">
                </td>
            </tr>
        </table>
        <% }%>
    </form>
</div>
<div>


</div>
</body>
</html>