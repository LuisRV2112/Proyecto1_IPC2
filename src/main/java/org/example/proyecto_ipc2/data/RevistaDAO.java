package org.example.proyecto_ipc2.data;
import org.example.proyecto_ipc2.data.ConexionDB;
import org.example.proyecto_ipc2.model.Revista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class RevistaDAO {
    public static boolean crearRevista(Revista revista) {
        String sql = "INSERT INTO revistas (titulo, descripcion, categoria, autor, costo_por_dia) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, revista.getTitulo());
            ps.setString(2, revista.getDescripcion());
            ps.setString(3, revista.getCategoria());
            ps.setString(4, revista.getAutor());  // ID del autor (usuario)
            ps.setDouble(5, revista.getCostoPorDia());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las revistas
    public static ArrayList<Revista> obtenerRevistas() {
        String sql = "SELECT * FROM revistas";
        ArrayList<Revista> listaRevistas = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Revista revista = new Revista(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getString("categoria"),
                        rs.getString("autor"),
                        rs.getDouble("costo_por_dia")
                );
                listaRevistas.add(revista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaRevistas;
    }

    // Actualizar una revista
    public static boolean actualizarRevista(Revista revista) {
        String sql = "UPDATE revistas SET titulo = ?, descripcion = ?, categoria = ?, costo_por_dia = ? WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, revista.getTitulo());
            ps.setString(2, revista.getDescripcion());
            ps.setString(3, revista.getCategoria());
            ps.setDouble(4, revista.getCostoPorDia());
            ps.setInt(5, revista.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar una revista
    public static boolean eliminarRevista(int id) {
        String sql = "DELETE FROM revistas WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
