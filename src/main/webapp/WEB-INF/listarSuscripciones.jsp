<%@ page import="org.example.proyecto_ipc2.model.Suscripcion" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <title>Suscripcion</title>
</head>
<body>
<h2>Revistas Suscritas</h2>
<ul>
    <%
        ArrayList<Suscripcion> suscripciones = (ArrayList<Suscripcion>) request.getAttribute("suscripciones");
        if (suscripciones != null) {
            for (Suscripcion suscripcion : suscripciones) {
    %>
    <li>Suscriptor: <%= suscripcion.getSuscriptor().getNombre() %> | Revista: <%= suscripcion.getRevista().getTitulo() %></li>
    <%
        }
    } else {
    %>
    <li>No hay suscripciones.</li>
    <% } %>
</ul>
</body>
</html>
