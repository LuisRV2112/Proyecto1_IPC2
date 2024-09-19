package org.example.proyecto_ipc2.data;
import org.example.proyecto_ipc2.data.ConexionDB;
import org.example.proyecto_ipc2.model.Suscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class SuscripcionDAO {
    // Crear una nueva suscripción
    public static boolean crearSuscripcion(Suscripcion suscripcion) {
        String sql = "INSERT INTO suscripciones (id_suscriptor, id_revista, fecha_suscripcion) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, suscripcion.getSuscriptor().getId());
            ps.setInt(2, suscripcion.getRevista().getId());
            ps.setDate(3, new java.sql.Date(suscripcion.getFechaSuscripcion().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener suscripciones por suscriptor
   /* public static ArrayList<Suscripcion> obtenerSuscripcionesPorSuscriptor(int idSuscriptor) {
        String sql = "SELECT * FROM suscripciones WHERE id_suscriptor = ?";
        ArrayList<Suscripcion> listaSuscripciones = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSuscriptor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Suscripcion suscripcion = new Suscripcion(
                        rs.getInt("id"),
                        SuscriptorDAO.obtenerSuscriptorPorId(rs.getInt("id_suscriptor")),
                        RevistaDAO.obtenerRevistaPorId(rs.getInt("id_revista")),
                        rs.getDate("fecha_suscripcion")
                );
                listaSuscripciones.add(suscripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaSuscripciones;
    }

    // Eliminar una suscripción
    public static boolean eliminarSuscripcion(int id) {
        String sql = "DELETE FROM suscripciones WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
