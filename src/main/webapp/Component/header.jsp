<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 10/9/2023
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>

<style>
    .navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 20px;
    }

    .navbar a {
        text-decoration: none;
        color: #000000;
        margin: 0 15px;
        font-weight: bold;
    }

    .logo {
        font-size: 24px;
    }

    .nav-links {
        list-style: none;
        display: flex;
    }

    .nav-links li {
        margin: 0 10px;
    }

    .nav-links a:hover {
        border-bottom: 2px solid #007bff;
        padding-bottom: 5px;
        transition: all 0.3s ease;
    }
</style>
<nav class="navbar">
    <div class="logo">
        <a href="#">Mon Site Web</a>
    </div>
    <ul class="nav-links">
        <li><a href="../index.jsp">Accueil</a></li>
        <li><a href="/client-display">Display clients</a></li>
        <li><a href="/client-create">Create client</a></li>
        <li><a href="/employe-display">Display employes</a></li>
        <li><a href="/employe-create">Create employe</a></li>
    </ul>
</nav>

