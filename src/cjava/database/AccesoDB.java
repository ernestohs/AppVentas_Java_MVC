package cjava.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

    public AccesoDB() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost:3306/ventas";
            String usuario = "";
            String contrasenia = "";
            conexion = (Connection) DriverManager.getConnection(servidor, usuario, contrasenia);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            return conexion;
        }
    }
}
