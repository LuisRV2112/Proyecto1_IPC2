<%@ page import="org.example.proyecto_ipc2.model.Revista" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <title>Listas Revistas</title>
</head>
<body>
<h2>Listado de Revistas</h2>

<ul>
    <%
        ArrayList<Revista> revistas = (ArrayList<Revista>) request.getAttribute("revistas");
        if (revistas != null) {
            for (Revista revista : revistas) {
    %>
    <li><%= revista.getTitulo() %> - <%= revista.getAutor() %></li>
    <%
        }
    } else {
    %>
    <li>No hay revistas disponibles.</li>
    <% } %>
</ul>
</body>
</html>
