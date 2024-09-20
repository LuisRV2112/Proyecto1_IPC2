package org.example.proyecto_ipc2.controller;
import jakarta.servlet.annotation.WebServlet;
import org.example.proyecto_ipc2.data.UsuarioDAO;
import org.example.proyecto_ipc2.model.Usuario;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "User", urlPatterns = {"/Controlusuario"} )
public class UsuarioController extends HttpServlet{
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        Usuario nuevoUsuario = new Usuario(0, nombre, email, password, Usuario.Rol.valueOf(rol));

        if (UsuarioDAO.crearUsuario(nuevoUsuario)) {
            response.sendRedirect("listarUsuarios.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
