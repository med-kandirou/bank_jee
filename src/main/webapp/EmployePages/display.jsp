<%@ page import="DTO.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DTO.Employe" %><%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 10/10/2023
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../Styles/style.css">
<html>
<head>
    <title>Display</title>
</head>
<body>
<table>
    <jsp:include page="../Component/header.jsp" />

    <form action="/employe-search" action="GET">
        <div class="search-container">
            <input type="text" name="param" class="search-bar" placeholder="Rechercher...">
            <button type="submit" class="search-button">Rechercher</button>
        </div>
    </form>
    <tr>
        <th>Matricule</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Birthday</th>
        <th>Phone</th>
        <th>Adresse email</th>
        <th>Recrutement Date</th>
        <th>update</th>
    </tr>
    <%
        ArrayList<Employe> employes =(ArrayList<Employe>)request.getAttribute("employes");
        for(Employe emp:employes){%>
    <tr>
        <td><%= emp.getMatricule() %></td>
        <td><%= emp.getFirstName() %></td>
        <td><%= emp.getLastName() %></td>
        <td><%= emp.getBirthday() %></td>
        <td><%= emp.getPhone() %></td>
        <td><%= emp.getAdresseemail() %></td>
        <td><%= emp.getDaterecrutement() %></td>
        <td><a href="/employe-update?mat=<%=emp.getMatricule()%>">Update</a></td>
    </tr>
    <%}%>
</table>
</body>
</html>
