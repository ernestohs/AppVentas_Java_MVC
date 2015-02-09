
package cjava.dao;

import cjava.database.ConexionBD;
import cjava.entity.ClienteDTO;
import cjava.interfases.Icrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO implements Icrud<ClienteDTO> {

    @Override
    public boolean Create(ClienteDTO o) throws Exception {

        boolean sw = false; 
        Connection cn = null;

        int nro;

        try {
           
            cn = ConexionBD.getconecion();

            
            String consulta = "select valor from control where parametro='Clientes'";
            Statement stm1 = cn.createStatement();
            ResultSet rset = stm1.executeQuery(consulta);
            rset.next();
            nro = rset.getInt("valor");
            rset.close();
            consulta = "update control set valor=valor+1 where parametro='Clientes'";
            stm1 = cn.createStatement();
            stm1.executeUpdate(consulta);
            String cod = null;
            if (nro < 10) {
                cod = "A000" + nro;
            } else {
                cod = "A00" + nro;
            }
            o.setIdCLiente(cod); 

          
            String sql = "insert into clientes (idcliente,nombre,direccion,rucdni,telefono) "
                    + " value(?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);
           
            ps.setString(1, o.getIdCLiente());
            ps.setString(2, o.getNombre()); 
            ps.setString(3, o.getDirección());
            ps.setString(4, o.getRucDni());
            ps.setString(5, o.getTelefono());

            
            sw = ps.executeUpdate() == 1 ? true : false;
            ps.close();

        } catch (Exception e) {

            throw e;
        } finally {
            try {
                cn.close(); 
            } catch (SQLException e1) {

            }
            return sw;

        }

    }

    @Override
    public boolean Update(ClienteDTO o) throws Exception {
        boolean sw = false; 

        Connection cn = null; 

        try {                

            cn = ConexionBD.getconecion(); 
            String Sql = "update clientes set nombre =?, direccion=?,rucdni=?,telefono=?  "
                    + "where idCLiente = ?"; 

            PreparedStatement ps = cn.prepareStatement(Sql);

            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDirección());
            ps.setString(3, o.getRucDni());
            ps.setString(4, o.getTelefono());
            ps.setString(5, o.getIdCLiente());

            sw = ps.executeUpdate() == 1 ? true : false; 
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e1) {
            }
            return sw;
        }
    }

    @Override
    public boolean Delete(ClienteDTO o) throws Exception {
        boolean sw = false; 

        Connection cn = null; 

        try {                

            cn = ConexionBD.getconecion(); 
            String Sql = "delete from clientes where idCLiente = ?"; 

            PreparedStatement ps = cn.prepareStatement(Sql);

            ps.setString(1, o.getIdCLiente());

            sw = ps.executeUpdate() == 1 ? true : false; 
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e1) {
            }
            return sw;
        }
    }

    @Override
    public List<ClienteDTO> readAll() throws Exception {

        List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
        Connection cn = null;

        try {

            cn = ConexionBD.getconecion();
            String Sql = "Select * from Clientes";

            Statement stm = cn.createStatement();

            ResultSet rs = stm.executeQuery(Sql);

            while (rs.next()) {

                ClienteDTO cli = new ClienteDTO();

                cli.setIdCLiente(rs.getString("idCliente"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setDirección(rs.getString("Direccion"));
                cli.setRucDni(rs.getString("RucDNI"));
                cli.setTelefono(rs.getString("Telefono"));
                lista.add(cli);

            }
            rs.close();
            stm.close();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e1) {
            }
            return lista;
        }

    }

    @Override
    public ClienteDTO query(String id) throws Exception {
        ClienteDTO cli = null;//new ProductoDTO();
        Connection cn = null;
        try {            //ABRIR CONEXION A LA BD
            cn = ConexionBD.getconecion();
            String sql = "select * from Clientes where idCliente = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cli = new ClienteDTO();

                cli.setIdCLiente(rs.getString("idcliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setDirección(rs.getString("direccion"));
                cli.setRucDni(rs.getString("rucdni"));
                cli.setTelefono(rs.getString("telefono"));

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
            return cli;

        }
    }
}
