package cjava.dao;

import cjava.database.ConexionBD;
import cjava.entity.ProductoDTO;
import cjava.interfases.Icrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements Icrud<ProductoDTO> {

    @Override

    public boolean Create(ProductoDTO o) throws Exception {
        boolean sw = false; 
        Connection cn = null;
          
        int nro;
        
        try {
            
            cn = ConexionBD.getconecion();
            
          
            String consulta = "select valor from control where parametro='Productos'";
            Statement stm1 = cn.createStatement();
            ResultSet rset = stm1.executeQuery(consulta);
            rset.next();
            nro = rset.getInt("valor");
            rset.close();
            consulta = "update control set valor=valor+1 where parametro='Productos'";
            stm1 = cn.createStatement();
            stm1.executeUpdate(consulta);
            String cod=null;
            if (nro<10) {
                cod="A000"+nro;
            }else{
               cod="A00"+nro; 
            }
            o.setIdproducto(cod); 
            
          
            String sql = "insert into productos (idProducto,descripcion,idcategoria,preciocompra,precioventa,stock) "
                    + " value(?,?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);
          
            ps.setString(1, o.getIdproducto());
            ps.setString(2, o.getNombre()); 
            ps.setInt(3, o.getIdcategoria());
            ps.setDouble(4, o.getPreciocompra());
            ps.setDouble(5, o.getPrecioventa());
            ps.setInt(6, o.getStock());

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
    public boolean Update(ProductoDTO o) throws Exception {

        boolean sw = false; 
        Connection cn = null;

        try {
            
            cn = ConexionBD.getconecion();
            String sql = "update productos set descripcion = ?,idcategoria=?,preciocompra=?,precioventa=?,stock=?"
                    + " where idproducto=?";

            PreparedStatement ps = cn.prepareStatement(sql);
            
          
            ps.setString(1, o.getNombre()); 
            ps.setInt(2, o.getIdcategoria());
            ps.setDouble(3, o.getPreciocompra());
            ps.setDouble(4, o.getPrecioventa());
            ps.setInt(5, o.getStock());
            ps.setString(6, o.getIdproducto());

            
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
    public boolean Delete(ProductoDTO o) throws Exception {
        
        boolean sw = false; 
        Connection cn = null;

        try {
           
            cn = ConexionBD.getconecion();
            String sql = "delete from productos where idproducto=?";

            PreparedStatement ps = cn.prepareStatement(sql);
           
            ps.setString(1, o.getIdproducto());

            
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
    public List<ProductoDTO> readAll() throws Exception {
       
        List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
        Connection cn = null;

        try {           

            cn = ConexionBD.getconecion();
            String sql = "select * from Productos";
            
            Statement stm = cn.createStatement();
         
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                
                ProductoDTO pro = new ProductoDTO();
                
                pro.setIdproducto(rs.getString("idProducto"));
                pro.setNombre(rs.getString("Descripcion"));
                pro.setIdcategoria(rs.getInt("IdCategoria"));
                pro.setPreciocompra(rs.getDouble("PrecioCompra"));
                pro.setPrecioventa(rs.getDouble("PrecioVenta"));
                pro.setStock(rs.getInt("Stock"));

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

        } //FIN

    }

    @Override
    public ProductoDTO query(String id  ) {
        ProductoDTO pro = null;
        Connection cn = null;
        try {            
            cn = ConexionBD.getconecion();
            String sql = "select * from Productos where idproducto = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
       
            if (rs.next()) {
                pro=new ProductoDTO();
               
                pro.setIdproducto(rs.getString("idProducto"));
                pro.setNombre(rs.getString("Descripcion"));
                pro.setIdcategoria(rs.getInt("IdCategoria"));
                pro.setPreciocompra(rs.getDouble("PrecioCompra"));
                pro.setPrecioventa(rs.getDouble("PrecioVenta"));
                pro.setStock(rs.getInt("Stock"));
   

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
