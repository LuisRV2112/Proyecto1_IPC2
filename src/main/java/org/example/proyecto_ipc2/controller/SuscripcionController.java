package org.example.proyecto_ipc2.controller;
import org.example.proyecto_ipc2.model.Suscripcion;
import org.example.proyecto_ipc2.model.Revista;
import org.example.proyecto_ipc2.model.Suscriptor;

import java.util.ArrayList;
import java.util.Date;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class SuscripcionController extends HttpServlet {
    private ArrayList<Suscripcion> suscripciones = new ArrayList<>();

    // Manejar suscripción
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Obtener datos de la revista y suscriptor (en un escenario real, se obtendría de la sesión o base de datos)
        String idRevista = request.getParameter("revistaId");
        String idSuscriptor = request.getParameter("suscriptorId");

        Revista revista = getRevistaById(Integer.parseInt(idRevista));  // Suponiendo que se implementa esta función
        Suscriptor suscriptor = getSuscriptorById(Integer.parseInt(idSuscriptor));  // Suponiendo que se implementa esta función

        // Crear una nueva suscripción
        Suscripcion suscripcion = new Suscripcion(suscriptor, revista, new Date());
        suscripciones.add(suscripcion);

        // Redirigir o reenviar a la lista de suscripciones
        request.setAttribute("suscripciones", suscripciones);
        try {
            request.getRequestDispatcher("/view/listarSuscripciones.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simular la obtención de suscripciones
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("suscripciones", suscripciones);
        try {
            request.getRequestDispatcher("/view/listarSuscripciones.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Métodos ficticios para obtener revistas y suscriptores por su ID
    private Revista getRevistaById(int id) {
        // Aquí se implementaría la lógica para obtener una revista por su ID.
        return new Revista(id, "Revista Ejemplo", "Descripción", "Tecnología", "Autor Ejemplo", 2.0);
    }

    private Suscriptor getSuscriptorById(int id) {
        // Aquí se implementaría la lógica para obtener un suscriptor por su ID.
        return new Suscriptor(id, "Suscriptor Ejemplo", "email@ejemplo.com");
    }
}
