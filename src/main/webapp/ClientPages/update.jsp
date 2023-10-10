<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 10/9/2023
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../Styles/style.css">
</head>
<body>
    <jsp:include page="../Component/header.jsp" />

    <div class="search-container">
        <input type="text" placeholder="Search...">
        <button type="submit">Search</button>
    </div>

    <div class="form-container">
        <form>
            <div class="form-group">
                <label >Code :</label>
                <input type="text" name="code">
            </div>
            <div class="form-group">
                <label >First Name :</label>
                <input type="text" name="fname">
            </div>
            <div class="form-group">
                    <label >Last Name :</label>
                    <input type="text" name="lname">
            </div>
            <div class="form-group">
                <label >Birthday :</label>
                <input type="text" name="birthday">
            </div>
            <div class="form-group">
                <label >Phone :</label>
                <input type="text" name="phone">
            </div>
            <div class="form-group">
                <label >Adresse :</label>
                <input type="text" name="adresse">
            </div>
            <button type="submit">Update</button>
        </form>
    </div>


</body>
</html>
