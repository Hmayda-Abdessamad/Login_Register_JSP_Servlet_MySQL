<%@ page import="web.CreditModel" %>

<%@ page import="classes.Simulation" %>
<%@ page import="DAO.SimulationDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="metier.SimulaionModel" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Similateur Crédit</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="vueCredit.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<%
    CreditModel model = (CreditModel) request.getAttribute("model");
    SimulationDao simd = new SimulationDao();
    List<Simulation> list = simd.getAllSimulation();
%>
<%
    Integer visitCount = new Integer(0);
    String montant = new String("montant");
    String duree = new String("duree");
    String taux = new String("Taux");


    if (session.isNew()){
        session.setAttribute("visitCount",visitCount);
        session.setAttribute("montant",montant);
        session.setAttribute("taux",taux);
        session.setAttribute("duree",duree);
    } else if((Integer)session.getAttribute("visitCount")==null) {
        session.setAttribute("montant", session.getAttribute("montant"));
        session.setAttribute("taux",   session.getAttribute("taux"));
        session.setAttribute("duree",   session.getAttribute("duree"));
        visitCount = 1;
        session.setAttribute("visitCount",visitCount);
    }
    else {
        visitCount = (Integer)session.getAttribute("visitCount");
        visitCount += 1;
        session.setAttribute("visitCount",visitCount);
        session.setAttribute("montant",montant);
        session.setAttribute("taux",taux);
        session.setAttribute("duree",duree);

    }
%>


<div align="clear" class="flex-container">
    <div id="search" >
        <form action="ControllerServlet" style="float: left" method="post">
            <input hidden name="cherch" value="cherch">
            <table>
                <tr>
                    <td>Mot clé:</td>
                    <td><input type="text" name="motCle"/></td>
                    <td><input id="navbar-toggle-button" type="submit" value="chercher"/></td>
                </tr>
            </table>
        </form>

        <form action="LogOut" method="post" style="float: right">
            <button type="submit" class="btn btn-danger"> <i class="fa fa-sign-out"></i> Logout</button>
        </form>
    </div>
</div>
<br> <br>
<div class="flex-container" align="clear">

    <div style="display: inline-block">
        <table border='1' width='100%'>
            <tr>
                <th>Id</th>
                <th>Montant</th>
                <th>Duree</th>
                <th>Taux</th>
                <th>Mensualite</th>
                <th>date</th>
                <th>categorie</th>

            </tr>
            <c:forEach items="${sim.simulations}" var="p">
                <tr>
                    <td>${p.getId()}</td>
                    <td>${p.getMontant()}</td>
                    <td>${p.getDuree()}</td>
                    <td>${p.getTaux()}</td>
                    <td>${p.getMensualite()}</td>
                    <td>${p.getDate()}</td>
                    <td>${p.getCategorie()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br> <br>
    <div >
        <form id="stripe-login"  action="ControllerServlet" method="post">
            <div class="formbg-outer">
                <input hidden name="calc" value="calc">
                <div class="formbg">
                    <div class="formbg-inner padding-horizontal--48">
                        <span class="padding-bottom--15"></span>
                        <div class="field padding-bottom--24">
                            <tr>
                                <td>MONTANT :</td>
                                <td><input type="text" name="montant" <%if (model!=null){%> value="<%=model.getMontant()%>"<%}%>></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>DUREE :</td>
                                <td><input type="number" name="duree"<%if (model!=null){%> value="<%=model.getDuree()%>"<%}%>></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>TAUX :</td>
                                <td><input name="taux" type="text" <%if (model!=null){%> value="<%=model.getTaux()%>"<%}%>></td>
                                <td></td>
                            </tr>
                            <td>DATE :</td>
                            <td><input name="date" type="date" <%if (model!=null){%> value="<%=model.getDate()%>"<%}%>></td>
                            <td></td>


                            <tr>
                                <td>CATEGORIE :</td>
                                <td><input name="categorie" type="text" <%if (model!=null){%> value="<%=model.getCategorie()%>"<%}%>></td>
                                <td></td>
                            </tr>

                            <td>
                                <input type="submit" value="Calculer">
                            </td>

                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

</div>





<div>
    <div class="formbg-outer">
    <table >
        <tr>
            <td>
                Mensualité :
            </td>
            <td>
               ${model.getMensualite()}

            </td>


        </tr>
        </td>

        <td>session nombre</td><br/>


        <td><%=session.getAttribute("visitCount")%></td>
        <tr>
        <td><div class="box-root">
            <a href="dashbord.jsp"> Dashbord</a>
        </div></td>
        </tr>


    </table>
    </div>
</div>
<div style="overflow-x:auto;">
    <table border='1' width='100%'>
        <tr>
            <th>Id</th>
            <th>Montant</th>
            <th>Duree</th>
            <th>Taux</th>
            <th>Mensualite</th>
            <th>Date</th>
            <th>Categorie</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
            Connection con = SimulationDao.getConnection();
            String sql = "select * from simulation";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){

        %>
        <tr>

            <td><%=rs.getInt("id")%></td>
            <td><%=rs.getDouble("montant")%></td>
            <td><%=rs.getInt("duree")%></td>
            <td><%=rs.getDouble("taux")%></td>
            <td><%=rs.getDouble("mensualite")%></td>
            <td><%=rs.getString("date")%></td>
            <td><%=rs.getString("categorie")%></td>
            <td><a href='edit.jsp?id=<%=rs.getInt("id")%>'>edit</a></td>

            <td><a href='DeleteServlet?id=<%=rs.getInt("id")%>' onclick="return theFunction();">delete</a></td>
        </tr><%}%>
    </table>

</div>

</div>

</body>
</html>