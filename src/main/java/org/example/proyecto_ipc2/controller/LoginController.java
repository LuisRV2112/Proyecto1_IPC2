package org.example.proyecto_ipc2.controller;
import org.example.proyecto_ipc2.model.Autenticacion;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginController extends HttpServlet {
    private Autenticacion autenticacion = new Autenticacion("admin@ejemplo.com", "1234");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (autenticacion.autenticar(email, password)) {
            // Crear sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", email);

            // Redirigir a la página principal
            response.sendRedirect("home.jsp");
        } else {
            // Redirigir a la página de login con error
            response.sendRedirect("login.jsp?error=1");
        }
        }
}
