/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjava.entity;


public class CategoriaDTO {
    private int idcategoria;
    private String nombre;
    private String descripcion;

    public CategoriaDTO() {
    }

    public CategoriaDTO(int idcategoria, String nombre, String descripcion) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getdescripcion ()
    {
    return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //METODO SOBRECARGADO --REDEFINIR  MÈTODOS TOSTRING
    
    //MÈTODO QUE DEVUELVE SOLO EL NOMBRE : TOSTRING 
    
    @Override //REDEFINIR 
    public String toString() { //
        return nombre;
    }
    
    
    
    
    
}
