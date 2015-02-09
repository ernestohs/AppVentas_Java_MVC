
package cjava.dao;

import cjava.database.ConexionBD;
import cjava.entity.ProveedorDTO;
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
public class ProveedorDAO implements Icrud<ProveedorDTO> {

    @Override
    public boolean Create(ProveedorDTO o) throws Exception {
       
     boolean  sw = false;
     Connection cn = null;
     
     int nro;
     
        try {
            
            cn= ConexionBD.getconecion();
            
            String consulta = "select valor from control where parametro = 'proveedores'";
            
            Statement stm1 = cn.createStatement();
            ResultSet rset = stm1.executeQuery(consulta);
            rset.next();
            nro = rset.getInt("valor");
            
            rset.close();
            consulta = "update control set valor= valor +1 where parametro = 'proveedores'";
            
            stm1 = cn.createStatement();
            stm1.executeUpdate(consulta);
            
            String cod = null;
            
            if (nro<10) {
                cod = "P000" + nro;
                               
            }
            else
            {
                cod = "P00" + nro;
            }
                         
            o.setIdProveedor(cod);
            
            //INSERTAR PROVEEDOR
                
            String Sql = "insert into proveedores(idProveedor,razonsocial,direccion,ruc, telefono )"
                    + " value(?,?,?,?,?)";
            
            PreparedStatement ps = cn.prepareStatement(Sql);
            
            
            ps.setString(1,o.getIdProveedor());
            ps.setString(2,o.getRazonSocial());
            ps.setString(3,o.getDireccion());
            ps.setString(4,o.getRuc());
            ps.setString(5,o.getTelefono());
            
            sw = ps.executeUpdate()== 1 ? true:false;
            ps.close();
            
            
        } catch (Exception e) {
            
            throw e;
            
        }
        finally {
            try {
                cn.close();
            } catch (Exception e) {
                
                
            }
            return sw;
        
        }      
        
    }

    @Override
    public boolean Update(ProveedorDTO o) throws Exception {
        boolean sw = false; // EL CREATE DEVULVE UN VALOR DE TIPO BOOLEAN

        Connection cn = null; // VARIABLE DE TIPO COLLECTION

        try {                 //

            cn = ConexionBD.getconecion(); 
            String Sql = "update proveedores set RazonSocial =?, direccion=?,ruc=?,telefono=?  "
                    + "where idProveedor = ?"; 

            PreparedStatement ps = cn.prepareStatement(Sql);

            ps.setString(1, o.getRazonSocial());
            ps.setString(2, o.getDireccion());
            ps.setString(3, o.getRuc());
            ps.setString(4, o.getTelefono());
            ps.setString(5, o.getIdProveedor());

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
    public boolean Delete(ProveedorDTO o) throws Exception {
        
        boolean sw = false; 

        Connection cn = null; 

        try {               

            cn = ConexionBD.getconecion(); 
            String Sql = "delete from proveedores where idproveedor = ?"; 

            PreparedStatement ps = cn.prepareStatement(Sql);

            ps.setString(1, o.getIdProveedor());

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
   public List<ProveedorDTO> readAll() throws Exception {
            
         List<ProveedorDTO> lista = new ArrayList<ProveedorDTO>();
         
         Connection cn = null;

        try {

            cn = ConexionBD.getconecion();
            String Sql = "Select * from Proveedores";

            Statement stm = cn.createStatement();

            ResultSet rs = stm.executeQuery(Sql);

            while (rs.next()) {

                ProveedorDTO pro = new ProveedorDTO();

                pro.setIdProveedor(rs.getString("idProveedor"));
                pro.setRazonSocial(rs.getString("RazonSocial"));
                pro.setDireccion(rs.getString("Direccion"));
                pro.setRuc(rs.getString("Ruc"));
                pro.setTelefono(rs.getString("Telefono"));
                
                lista.add(pro);

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
 public ProveedorDTO query(String id) throws Exception {
       
        ProveedorDTO pro = null;
        Connection cn = null;
        try {            //ABRIR CONEXION A LA BD
            cn = ConexionBD.getconecion();
            String sql = "select * from proveedores where idProveedor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pro = new ProveedorDTO();

                pro.setIdProveedor(rs.getString("idProveedor"));
                pro.setRazonSocial(rs.getString("RazonSocial"));
                pro.setDireccion(rs.getString("Direccion"));
                pro.setRuc(rs.getString("ruc"));
                pro.setTelefono(rs.getString("telefono"));
                
         
    
    

            }
            rs.close(); 
            ps.close(); 
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e1) {
            }
            return pro;

        }
    }
    
    
    
}
