<%@ page import="org.example.proyecto_ipc2.model.Anuncio" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
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
<h2>Anuncios Activos</h2>
<ul>
    <%
        ArrayList<Anuncio> anuncios = (ArrayList<Anuncio>) request.getAttribute("anuncios");
        Date ahora = new Date();
        if (anuncios != null) {
            for (Anuncio anuncio : anuncios) {
                if (anuncio.getFechaFin().after(ahora)) {  // Mostrar solo anuncios activos
    %>
    <li><%= anuncio.getTipo() %> - <%= anuncio.getContenido() %> (Activo hasta <%= anuncio.getFechaFin() %>)</li>
    <%
            }
        }
    } else {
    %>
    <li>No hay anuncios activos.</li>
    <% } %>
</ul>

</body>
</html>
