package org.example.proyecto_ipc2.data;
import org.example.proyecto_ipc2.data.AnuncioDAO;
import org.example.proyecto_ipc2.model.Anuncio;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
public class AnuncioController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipo = request.getParameter("tipo");
        String contenido = request.getParameter("contenido");
        int duracionDias = Integer.parseInt(request.getParameter("duracionDias"));
        double precio = Double.parseDouble(request.getParameter("precio"));

        // Crear fechas de inicio y fin
        java.util.Date fechaInicio = new java.util.Date();
        java.util.Date fechaFin = new java.util.Date(fechaInicio.getTime() + duracionDias * 86400000L);

        Anuncio anuncio = new Anuncio(0, tipo, contenido, fechaInicio, fechaFin, precio);

        if (AnuncioDAO.crearAnuncio(anuncio)) {
            response.sendRedirect("listarAnuncios.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Anuncio> anuncios = AnuncioDAO.obtenerAnuncios();
        request.setAttribute("anuncios", anuncios);
        try {
            request.getRequestDispatcher("/webapp/listarAnuncios.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
