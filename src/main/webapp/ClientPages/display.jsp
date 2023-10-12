<%@ page import="DTO.Client" %>
<%@ page import="java.util.ArrayList" %><%--
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

    <form action="/client-search" action="GET">
        <div class="search-container">
            <input type="text" name="param" class="search-bar" placeholder="Rechercher...">
            <button type="submit" class="search-button">Rechercher</button>
        </div>
    </form>
    <tr>
        <th>Code</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Birthday</th>
        <th>Phone</th>
        <th>Adresse</th>
        <th>update</th>
    </tr>
        <%
            ArrayList<Client> clients =(ArrayList<Client>)request.getAttribute("clients");
            for(Client c:clients){%>
        <tr>
            <td><%=c.getCode()%></td>
            <td><%=c.getFirstName()%></td>
            <td><%=c.getLastName()%></td>
            <td><%=c.getBirthday()%></td>
            <td><%=c.getPhone()%></td>
            <td><%=c.getAdresse()%></td>
            <td><a href="/client-update?code=<%=c.getCode()%>">Update</a></td>
        </tr>
        <%}%>
</table>
</body>
</html>
