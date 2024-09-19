package org.example.proyecto_ipc2.data;
import org.example.proyecto_ipc2.data.UsuarioDAO;
import org.example.proyecto_ipc2.model.Usuario;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = UsuarioDAO.obtenerUsuarioPorEmail(email);

        if (usuario != null && usuario.getPassword().equals(password)) {
            // Crear sesión
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Redirigir a la página principal
            response.sendRedirect("home.jsp");
        } else {
            // Redirigir a la página de login con error
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
