<%--
  Created by IntelliJ IDEA.
  User: boika_fire
  Date: 9/19/24
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
<h2>Iniciar Sesión</h2>
<form action="LoginController" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Iniciar Sesión">
</form>

<% if (request.getParameter("error") != null) { %>
<p style="color:red;">Email o contraseña incorrectos</p>
<% } %>
</body>
</html>
