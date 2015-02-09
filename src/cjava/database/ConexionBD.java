package cjava.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alumno06
 */
public class ConexionBD {

    //es estatic por que COnecction pertenece a la clase CoenxionBD
    public static Connection getconecion() throws Exception //devuelve un obj de tipo conexion
    {
        Connection cn = null; //cn variable de tipo conexion

        try {
            //1. cargar driver en memoria
            Class.forName("com.mysql.jdbc.Driver");
            //2. url de la base de datos
            //String url = "jdbc:mysql://localhost:3306/empresa";
            String url = "jdbc:mysql://localhost:3306/empresa";
            
            //3. Obtener la conexion a la base de datos
            //root root
            cn=DriverManager.getConnection(url,"root","");
            
            
        } catch (ClassNotFoundException e) {
        
        throw e;
        } catch (SQLException e1) {
            throw e1;
        }
        return cn;
    }

}
