package cjava.database;

import java.sql.Connection;

public class prueba {

    public static void main(String[] args) {
        try {
            Connection cn = ConexionBD.getconecion();
            //se abre la conexion a la BD
            // se asigna a cn
            System.out.println("Conexion conforme....");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

    }
}
