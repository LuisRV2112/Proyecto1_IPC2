package org.example.proyecto_ipc2.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_revistas";
    private static final String USER = "root";  // Cambia esto si tienes otro usuario
    private static final String PASSWORD = "tu_contraseña";  // Cambia esto por tu contraseña

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de MySQL", e);
        }
    }
}
