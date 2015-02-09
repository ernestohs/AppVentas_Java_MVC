
package cjava.controller;

import cjava.dao.ProductoDAO;
import cjava.entity.ProductoDTO;
import java.util.List;

public class ProductoBLL {
//ATRIBUTO
    
    private ProductoDAO dao ;

    //CONSTRUCTOR
    public ProductoBLL() {
        
        dao = new ProductoDAO();
        
    }
    
    //METODOS
    public List<ProductoDTO> ProductoListar() throws Exception{
    
    return dao.readAll();
    
    
    }
    
    public ProductoDTO ProductoBuscar(String id) throws Exception
    {
    
        return dao.query(id);
    }
    
    public boolean ProductoAdicionar(ProductoDTO p) throws Exception
    {
    return dao.Create(p);
    
    }
    
    public boolean ProductoUpdate (ProductoDTO p) throws Exception
    {
    return dao.Update(p);
    }
    
    public boolean ProductoEliminar (ProductoDTO p) throws Exception
    {
    return dao.Delete(p);
    }
}
