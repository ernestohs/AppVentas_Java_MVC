
package cjava.controller;

import cjava.dao.CategoriaDAO;
import cjava.entity.CategoriaDTO;
import java.util.List;


public class CategoriaBLL {

    private CategoriaDAO dao;
        
    public CategoriaBLL() {
        dao = new CategoriaDAO();
    }

    public List<CategoriaDTO> CategoriaListar() throws Exception {

        return dao.readAll();
    }   
   
    
    public CategoriaDTO CategoriaBuscar(String id) throws Exception
    {
        return dao.query(id);
    }
    public boolean CategoriaAdicionar(CategoriaDTO c) throws Exception{
        return dao.Create(c);    
    }
    public boolean CategoriaActualizar (CategoriaDTO c) throws Exception
    {
        return dao.Update(c);    
    }
    public boolean CategoriaEliminar (CategoriaDTO c) throws Exception
    {
    return dao.Delete(c);
    }
    
    public List<CategoriaDTO> CategoriaListar_Combo() throws Exception 
    {
    return dao.readAll_cat();
    }   
   
}
