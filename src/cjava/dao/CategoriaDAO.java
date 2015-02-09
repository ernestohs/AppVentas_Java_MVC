
package cjava.dao;

import cjava.database.ConexionBD;
import cjava.entity.CategoriaDTO;
import cjava.interfases.Icrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO implements Icrud<CategoriaDTO>{

    @Override
    public boolean Create(CategoriaDTO o) throws Exception {
      
          boolean sw = false; //create devuelve boolean
        Connection cn = null;

       
        try {
         
            cn = ConexionBD.getconecion();

            String sql = "insert into Categorias (idCategoria, nombre, descripcion) "
                    + " value(?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);
           
            ps.setInt(1, o.getIdcategoria());
            ps.setString(2, o.getNombre()); 
            ps.setString(3, o.getdescripcion());
        
            //EJECUTAR EL COMANDO INSERT
            //executeUpdate DEVUELVE UN NÙMERO ; CANTIDAD DE REGISTRO AFECTADOS
            sw = ps.executeUpdate() == 1 ? true : false;
            ps.close();

            //mètodo para crear 
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
    public boolean Update(CategoriaDTO o) throws Exception {
        
         boolean sw = false; 

        Connection cn = null; 

        try {                

            cn = ConexionBD.getconecion(); // ABRIR CONEXIÓN A LA BD
            String Sql = "update categorias set nombre =?, descripcion=? "
                    + "where idCategoria = ?"; // PREPARAR EL COMANDO INSERT

            PreparedStatement ps = cn.prepareStatement(Sql);//PREPARAR COMANDO PARA ENVIARLO A MOTOR

            ps.setString(1, o.getNombre());
            ps.setString(2, o.getdescripcion());            
            ps.setInt(3, o.getIdcategoria());
       
            
            sw = ps.executeUpdate() == 1 ? true : false; // DEVUELVE UN ENTERO
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
    public boolean Delete(CategoriaDTO o) throws Exception {
       boolean sw = false;
       
       Connection cn = null;
       
        try {
            cn =  ConexionBD.getconecion();
            String Sql = "delete from Categorias where categoriaid = ?";
            
            PreparedStatement ps = cn.prepareStatement(Sql);
            
            ps.setInt(1, o.getIdcategoria());
            
            sw = ps.executeUpdate()== 1?true:false;
            
            ps.close();          
            
            
        } catch (Exception e) {
            throw e;
        }
        finally{
        
            try {
                cn.close();
            } catch (Exception e) {
                
                
            }
            return sw;
        }
      
    }

    @Override
    public List<CategoriaDTO> readAll() throws Exception {
        
         //Devuelve una  collection de tipo producto .
        //list es la interfas
        //array lista lo que 
        List<CategoriaDTO> lista = new ArrayList<CategoriaDTO>();
        Connection cn = null;

        try {            //ABRIR CONEXION A LA BD

            cn = ConexionBD.getconecion();
            String sql = "select * from Categorias";
            //mètodo para crear 
            Statement stm = cn.createStatement();
            //ejecutar comando
            ResultSet rs = stm.executeQuery(sql);
            //el registro del result set ahora se tiene que cargar a una Collecciòn
            // desupuès se pueden manejar los datos

            while (rs.next()) {
                //se lee un registro del resultset y se adiciona a la colleccion
                CategoriaDTO ca = new CategoriaDTO();
                //se extrae el valor del cursos y se asigna al obj pro
                //ASIGNANDO VALORES AL OBJ PRO
                ca.setIdcategoria(rs.getInt("idCategoria"));
                ca.setNombre(rs.getString("nombre"));
                ca.setDescripcion(rs.getString("descripcion"));
                
                lista.add(ca);

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
    public CategoriaDTO query(String id) throws Exception {
        
        CategoriaDTO cat = null;
        Connection cn= null;
        
        try {
            cn=ConexionBD.getconecion();
            String Sql = "select * from Categorias where idCategoria = ?";
            PreparedStatement ps = cn.prepareStatement(Sql);
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
                        
            if (rs.next()) {
                
                cat = new CategoriaDTO();
                cat.setIdcategoria(rs.getInt("idCategoria"));
                cat.setNombre(rs.getString("nombre"));
                cat.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
        }
        return cat;        
    }
    
  public List<CategoriaDTO> readAll_cat() throws Exception {
        
        List<CategoriaDTO> lista = new ArrayList<CategoriaDTO>();
        Connection cn = null;

        try {           

            cn = ConexionBD.getconecion();
            String sql = "select nombre from Categorias";
          
            Statement stm = cn.createStatement();
           
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                 CategoriaDTO ca = new CategoriaDTO();
                 ca.setNombre(rs.getString("nombre"));
                                
                lista.add(ca);

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

   
  

}    
    

