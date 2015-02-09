
package cjava.controller;

import cjava.dao.ClienteDAO;
import cjava.entity.ClienteDTO;
import java.util.List;

/**
 *
 * @author Edith
 */
public class ClienteBLL {
    
private ClienteDAO dao;

    public ClienteBLL() {
        dao = new ClienteDAO();
               
    }
    //METODOS
    public List<ClienteDTO> ClienteListar() throws Exception{
    
    return dao.readAll();
    }
    
    public ClienteDTO ClienteBuscar(String id) throws Exception
    {
        return dao.query(id);
    }
    public boolean ClienteAdicionar(ClienteDTO c) throws Exception{
        return dao.Create(c);
    
    }
    public boolean ClienteActualizar (ClienteDTO c) throws Exception
    {
        return dao.Update(c);
    
    }
    public boolean CLienteEliminar (ClienteDTO c) throws Exception
    {
    return dao.Delete(c);
    }
    

}
