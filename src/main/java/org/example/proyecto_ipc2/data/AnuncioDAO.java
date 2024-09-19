package org.example.proyecto_ipc2.data;
import org.example.proyecto_ipc2.data.ConexionDB;
import org.example.proyecto_ipc2.model.Anuncio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class AnuncioDAO {
    // Crear un nuevo anuncio
    public static boolean crearAnuncio(Anuncio anuncio) {
        String sql = "INSERT INTO anuncios (tipo, contenido, fecha_inicio, fecha_fin, precio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, anuncio.getTipo());
            ps.setString(2, anuncio.getContenido());
            ps.setDate(3, new java.sql.Date(anuncio.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(anuncio.getFechaFin().getTime()));
            ps.setDouble(5, anuncio.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los anuncios
    public static ArrayList<Anuncio> obtenerAnuncios() {
        String sql = "SELECT * FROM anuncios";
        ArrayList<Anuncio> listaAnuncios = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Anuncio anuncio = new Anuncio(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("contenido"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"),
                        rs.getDouble("precio")
                );
                listaAnuncios.add(anuncio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAnuncios;
    }

    // Actualizar un anuncio
    public static boolean actualizarAnuncio(Anuncio anuncio) {
        String sql = "UPDATE anuncios SET tipo = ?, contenido = ?, fecha_inicio = ?, fecha_fin = ?, precio = ? WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, anuncio.getTipo());
            ps.setString(2, anuncio.getContenido());
            ps.setDate(3, new java.sql.Date(anuncio.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(anuncio.getFechaFin().getTime()));
            ps.setDouble(5, anuncio.getPrecio());
            ps.setInt(6, anuncio.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un anuncio
    public static boolean eliminarAnuncio(int id) {
        String sql = "DELETE FROM anuncios WHERE id = ?";
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
