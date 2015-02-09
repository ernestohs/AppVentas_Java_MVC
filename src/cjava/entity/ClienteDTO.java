/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjava.entity;

/**
 *
 * @author Edith
 */
public class ClienteDTO {
    private String idCLiente;
    private String nombre;
    private String dirección;
    private String RucDni;
    private String telefono;

    public ClienteDTO() {
    }

    public ClienteDTO(String idCLiente, String nombre, String dirección, String RucDni, String telefono) {
        this.idCLiente = idCLiente;
        this.nombre = nombre;
        this.dirección = dirección;
        this.RucDni = RucDni;
        this.telefono = telefono;
    }

  

    public String getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(String idCLiente) {
        this.idCLiente = idCLiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getRucDni() {
        return RucDni;
    }

    public void setRucDni(String RucDni) {
        this.RucDni = RucDni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    
    
}
