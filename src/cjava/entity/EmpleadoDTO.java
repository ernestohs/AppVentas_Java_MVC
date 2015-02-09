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
public class EmpleadoDTO {

    private String idempleado;
    private String apellido;
    private String nombres;
    private String email;
    private String usuario;
    private String clave;

    public EmpleadoDTO(String idempleado, String apellido, String nombres, String email, String usuario, String clave) {
        this.idempleado = idempleado;
        this.apellido = apellido;
        this.nombres = nombres;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
    }

    public EmpleadoDTO() {
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    

}
