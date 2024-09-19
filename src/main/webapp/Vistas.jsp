<%--
  Created by IntelliJ IDEA.
  User: boika_fire
  Date: 9/19/24
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Vistas</title>
</head>
<body>
<form action="RevistaController" method="post">
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo" required><br><br>

    <label for="descripcion">Descripción:</label>
    <textarea id="descripcion" name="descripcion" required></textarea><br><br>

    <label for="categoria">Categoría:</label>
    <input type="text" id="categoria" name="categoria" required><br><br>

    <label for="autor">Autor:</label>
    <input type="text" id="autor" name="autor" required><br><br>

    <label for="costoPorDia">Costo por Día:</label>
    <input type="number" id="costoPorDia" name="costoPorDia" required><br><br>

    <input type="submit" value="Crear Revista">
</form>
</body>
</html>
