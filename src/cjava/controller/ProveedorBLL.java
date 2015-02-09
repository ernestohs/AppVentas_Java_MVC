/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjava.controller;

import cjava.dao.ProveedorDAO;
import cjava.entity.ProveedorDTO;
import java.util.List;

/**
 *
 * @author Edith
 */
public class ProveedorBLL {
    
    private ProveedorDAO pro;
    
     public  ProveedorBLL() 
     {
        pro = new ProveedorDAO();
     }
    
     
     public List<ProveedorDTO> ProveedorListar() throws Exception
     {
     
     return pro.readAll();
     }
     
     public ProveedorDTO ProveedorBuscar (String id) throws Exception
     {
     
         return pro.query(id);
     }
    
    public boolean ProveedorAdicionar(ProveedorDTO o) throws Exception
    {
    
        return pro.Create(o);
    
    }
    
    public boolean ProveedorEliminar (ProveedorDTO o) throws Exception
    {
         return  pro.Delete(o);
    }
    
    public boolean ProveedorActualizar (ProveedorDTO o) throws Exception
    {
    return pro.Update(o);
    }
}

