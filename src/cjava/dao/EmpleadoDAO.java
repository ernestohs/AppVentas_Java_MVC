package cjava.dao;

import cjava.database.ConexionBD;
import cjava.entity.EmpleadoDTO;
import cjava.interfases.Icrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edith
 */
public class EmpleadoDAO implements Icrud<EmpleadoDTO> {

    @Override
    public boolean Create(EmpleadoDTO o) throws Exception {
        boolean sw = false; //create devuelve boolean
        Connection cn = null;

        int nro;

        try {
            //ABRIR CONEXION A LA BD
            cn = ConexionBD.getconecion();

            //CODIGO***********************************************************
            // genera codigo de producto
            String consulta = "select valor from control where parametro='Empleados'";
            Statement stm1 = cn.createStatement();
            ResultSet rset = stm1.executeQuery(consulta);
            rset.next();
            nro = rset.getInt("valor");// SE LE ESIGNA EN MEMORIA
            rset.close();
            consulta = "update control set valor=valor+1 where parametro='Empleados'";
            stm1 = cn.createStatement();
            stm1.executeUpdate(consulta);
            String cod = null;
            if (nro < 10) {
                cod = "E000" + nro;
            } else {
                cod = "E00" + nro;
            }
            o.setIdempleado(cod); //CODIGO GENERADO

            //CODIGO***********************************************************
            //INSERTAR PRODUCTO
            String sql = "insert into empleados (idempleado,apellido,nombre,email,usuario,clave) "
                    + " value(?,?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);
            //PREPARANDO LOS VALORES QUE SE LE PASAN AL PARÀMETRO
            //? ES REEMPLADZA X ESTOS VALORES
            ps.setString(1, o.getIdempleado());
            ps.setString(2, o.getApellido()); //DDO = transferir datos entre procesos
            ps.setString(3, o.getNombres());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getUsuario());
            ps.setString(6, o.getClave());

            //EJECUTAR EL COMANDO INSERT
            //executeUpdate DEVUELVE UN NÙMERO ; CANTIDAD DE REGISTRO AFECTADOS
            sw = ps.executeUpdate() == 1 ? true : false;
            ps.close();

            //mètodo para crear 
        } catch (Exception e) {

            throw e;
        } finally {
            try {
                cn.close(); //cerrar conexion
            } catch (SQLException e1) {

            }
            return sw;

        }
    }

    @Override
    public boolean Update(EmpleadoDTO o) throws Exception {
        boolean sw = false; //create devuelve boolean
        Connection cn = null;

        try {
            //ABRIR CONEXION A LA BD
            cn = ConexionBD.getconecion();
            String sql = "update empleados set apellido = ?,nombre=?,email=?,usuario=?,clave=?"
                    + " where idempleado=?";

            PreparedStatement ps = cn.prepareStatement(sql);
            //PREPARANDO LOS VALORES QUE SE LE PASAN AL PARÀMETRO
            //? ES REEMPLADZA X ESTOS VALORES

            ps.setString(1, o.getNombres()); //DDO = transferir datos entre procesos
            ps.setString(2, o.getApellido());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getUsuario());
            ps.setString(5, o.getClave());
            ps.setString(6, o.getIdempleado());

            //EJECUTAR EL COMANDO INSERT
            //executeUpdate DEVUELVE UN NÙMERO ; CANTIDAD DE REGISTRO AFECTADOS
            sw = ps.executeUpdate() == 1 ? true : false;
            ps.close();

            //mètodo para crear 
        } catch (Exception e) {

            throw e;
        } finally {
            try {
                cn.close(); //cerrar conexion
            } catch (SQLException e1) {

            }
            return sw;

        }
    }

    @Override
    public boolean Delete(EmpleadoDTO o) throws Exception {
        boolean sw = false; //create devuelve boolean
        Connection cn = null;

        try {
            //ABRIR CONEXION A LA BD
            cn = ConexionBD.getconecion();
            String sql = "delete from empleados where idempleado=?";

            PreparedStatement ps = cn.prepareStatement(sql);
            //PREPARANDO LOS VALORES QUE SE LE PASAN AL PARÀMETRO
            //? ES REEMPLADZA X ESTOS VALORES

            ps.setString(1, o.getIdempleado());

            //EJECUTAR EL COMANDO INSERT
            //executeUpdate DEVUELVE UN NÙMERO ; CANTIDAD DE REGISTRO AFECTADOS
            sw = ps.executeUpdate() == 1 ? true : false;
            ps.close();

            //mètodo para crear 
        } catch (Exception e) {

            throw e;
        } finally {
            try {
                cn.close(); //cerrar conexion
            } catch (SQLException e1) {

            }
            return sw;

        }

    }

    @Override
    public List<EmpleadoDTO> readAll() throws Exception {

        //Devuelve una  collection de tipo producto .
        //list es la interfas
        //array lista lo que 
        List<EmpleadoDTO> lista = new ArrayList<EmpleadoDTO>();
        Connection cn = null;

        try {            //ABRIR CONEXION A LA BD

            cn = ConexionBD.getconecion();
            String sql = "select * from Empleados";
            //mètodo para crear 
            Statement stm = cn.createStatement();
            //ejecutar comando
            ResultSet rs = stm.executeQuery(sql);
            //el registro del result set ahora se tiene que cargar a una Collecciòn
            // desupuès se pueden manejar los datos

            while (rs.next()) {
                //se lee un registro del resultset y se adiciona a la colleccion
                EmpleadoDTO emp = new EmpleadoDTO();
                //se extrae el valor del cursos y se asigna al obj pro
                //ASIGNANDO VALORES AL OBJ PRO
                emp.setIdempleado(rs.getString("idEmpleado"));
                emp.setNombres(rs.getString("apellido"));
                emp.setApellido(rs.getString("nombre"));
                emp.setEmail(rs.getString("email"));
                emp.setUsuario(rs.getString("usuario"));
                emp.setClave(rs.getString("clave"));

                lista.add(emp);

            }
            rs.close(); //cerrar  cursos
            stm.close(); //cerrar statement

        } catch (Exception e) {

            throw e;
        } finally {
            try {
                cn.close(); //cerrar conexion
            } catch (SQLException e1) {

            }
            return lista;

        } //FIN

    }

    @Override
    public EmpleadoDTO query(String id) throws Exception {
        EmpleadoDTO em = null;//new ProductoDTO();
        Connection cn = null;
        try {            //ABRIR CONEXION A LA BD
            cn = ConexionBD.getconecion();
            String sql = "select * from Empleados where idEmpleado = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                em = new EmpleadoDTO();

                em.setIdempleado(rs.getString("idempleado"));
                em.setApellido(rs.getString("apellido"));
                em.setNombres(rs.getString("nombre"));
                em.setEmail(rs.getString("email"));
                em.setUsuario(rs.getString("usuario"));
                em.setClave(rs.getString("clave"));

            }
            rs.close(); //cerrar  cursos
            ps.close(); //cerrar statement
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e1) {
            }
            return em;

        }
    }

}


