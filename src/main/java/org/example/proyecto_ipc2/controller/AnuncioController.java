package org.example.proyecto_ipc2.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import  org.example.proyecto_ipc2.model.Anuncio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "anuncio", urlPatterns = {"/Controlanuncios"} )
public class AnuncioController extends HttpServlet  {
    private ArrayList<Anuncio> anuncios = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        String contenido = request.getParameter("contenido");
        Date fechaInicio = new Date();  // Fecha actual
        int duracionDias = Integer.parseInt(request.getParameter("duracionDias"));
        double precio = calcularPrecio(tipo, duracionDias);  // Función para calcular el precio

        Date fechaFin = new Date(fechaInicio.getTime() + duracionDias * 86400000L);  // Duración en milisegundos

        // Crear un nuevo anuncio
        Anuncio anuncio = new Anuncio(anuncios.size() + 1, tipo, contenido, fechaInicio, fechaFin, precio);
        anuncios.add(anuncio);

        request.setAttribute("anuncios", anuncios);
            request.getRequestDispatcher("/webapp/listarAnuncios.jsp").forward(request, response);

    }

    // Calcular el precio del anuncio según el tipo y la duración
    private double calcularPrecio(String tipo, int duracionDias) {
        double precioBase = 0;
        switch (tipo) {
            case "Texto":
                precioBase = 10.0;
                break;
            case "Texto e Imagen":
                precioBase = 20.0;
                break;
            case "Video":
                precioBase = 50.0;
                break;
        }
        return precioBase * duracionDias;
    }

    // Mostrar anuncios activos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("anuncios", anuncios);
        try {
            request.getRequestDispatcher("/webapp/listarAnuncios.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
