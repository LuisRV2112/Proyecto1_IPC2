<%--
  Created by IntelliJ IDEA.
  User: boika_fire
  Date: 9/19/24
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<div class="container mt-5">
    <h2>Comprar Anuncio</h2>
    <form action="AnuncioController" method="post">
        <div class="form-group">
            <label for="tipo">Tipo de Anuncio:</label>
            <select class="form-control" id="tipo" name="tipo">
                <option value="Texto">Texto</option>
                <option value="Texto e Imagen">Texto e Imagen</option>
                <option value="Video">Video</option>
            </select>
        </div>

        <div class="form-group">
            <label for="contenido">Contenido del Anuncio (Texto o URL):</label>
            <input type="text" class="form-control" id="contenido" name="contenido" required>
        </div>

        <div class="form-group">
            <label for="duracionDias">Duración (días):</label>
            <input type="number" class="form-control" id="duracionDias" name="duracionDias" required>
        </div>

        <div class="form-group">
            <label for="precio">Precio del Anuncio:</label>
            <input type="number" class="form-control" step="0.01" id="precio" name="precio" required>
        </div>

        <button type="submit" class="btn btn-primary">Comprar Anuncio</button>
    </form>
</div>
</body>
</html>
