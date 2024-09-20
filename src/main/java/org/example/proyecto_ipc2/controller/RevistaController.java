package org.example.proyecto_ipc2.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import org.example.proyecto_ipc2.model.Revista;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Revista", urlPatterns = {"/Revistacontrol"} )
public class RevistaController  extends HttpServlet {
    private ArrayList<Revista> revistas = new ArrayList<>();

    // Simular la creación de una revista
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String categoria = request.getParameter("categoria");
        String autor = String.valueOf(Integer.valueOf(request.getParameter("autor")));
        double costoPorDia = Double.parseDouble(request.getParameter("costoPorDia"));

        Revista revista = new Revista(revistas.size() + 1, titulo, descripcion, categoria, autor, costoPorDia);
        revistas.add(revista);

        request.setAttribute("revistas", revistas);
        try {
            request.getRequestDispatcher("/webapp/listarRevistas.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    // Simular la obtención de revistas
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("revistas", revistas);
        try {
            request.getRequestDispatcher("/webapp/listarRevistas.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
