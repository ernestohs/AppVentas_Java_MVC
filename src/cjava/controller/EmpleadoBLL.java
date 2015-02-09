
package cjava.controller;

import cjava.dao.EmpleadoDAO;
import cjava.entity.EmpleadoDTO;
import java.util.List;

/**
 *
 * @author Edith
 */
public class EmpleadoBLL {
    
    private EmpleadoDAO dao;

    public EmpleadoBLL() {
        
        dao = new EmpleadoDAO();
    }
    
    
     public List<EmpleadoDTO> EmpleadoListar() throws Exception{
    
    return dao.readAll();
    }
    public EmpleadoDTO EmpleadoBuscar(String id) throws Exception
    {
    
        return dao.query(id);
    }
    
    public boolean EmpleadoAdicionar(EmpleadoDTO e) throws Exception
    {
    return dao.Create(e);
    
    }
    
    public boolean EmpleadoUpdate (EmpleadoDTO e) throws Exception
    {
    return dao.Update(e);
    }
    
    public boolean EmpleadoEliminar (EmpleadoDTO e) throws Exception
    {
    return dao.Delete(e);
    }
    
    
}
