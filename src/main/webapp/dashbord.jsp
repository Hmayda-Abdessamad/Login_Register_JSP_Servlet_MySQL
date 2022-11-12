<%--
  Created by IntelliJ IDEA.
  User: zizil
  Date: 05/11/2022
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="DAO.SimulationDao" %>
<%@ page import="java.util.Date" %>

<%
  Gson gsonObj = new Gson();
  Map<Object,Object> map = null;
  List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
  String dataPoints = null;



  try{
    Connection con = SimulationDao.getConnection();
    Statement statement = con.createStatement();
    String xVal, yVal;


    ResultSet resultSet = statement.executeQuery("select categorie ,montant from simulation");

    while(resultSet.next()){

      xVal = resultSet.getString("categorie");
      yVal = resultSet.getString("montant");
      map = new HashMap<Object,Object>(); map.put("label", xVal); map.put("y", Double.parseDouble(yVal)); list.add(map);
      dataPoints = gsonObj.toJson(list);
    }
    con.close();
  }
  catch(SQLException e){
    out.println("<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same.</div>");
    dataPoints = null;
  }
%>

<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript">
    window.onload = function() {

      <% if(dataPoints != null) { %>
      var chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        exportEnabled: true,
        title: {
          text: "categorie/montant"
        },
        data: [{
          type: "column", //change type to bar, line, area, pie, etc
          dataPoints: <%out.print(dataPoints);%>
        }]
      });
      chart.render();
      <% } %>

    }
  </script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>