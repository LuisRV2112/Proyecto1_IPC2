<%--
  Created by IntelliJ IDEA.
  User: boika_fire
  Date: 9/19/24
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Suscribirse</title>
</head>
<body>
<h2>Suscribirse a Revista</h2>
<form action="SuscripcionController" method="post">
    <label for="suscriptorId">ID de Suscriptor:</label>
    <input type="text" id="suscriptorId" name="suscriptorId" required><br><br>

    <label for="revistaId">ID de Revista:</label>
    <input type="text" id="revistaId" name="revistaId" required><br><br>

    <input type="submit" value="Suscribirse">
</form>
</body>
</html>
