/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjava.entity;

/**
 *
 * @author Alumno06
 */
public class ProductoDTO {

    //campos
    private String idproducto;
    private String nombre;
    private int idcategoria;
    private double preciocompra;
    private double precioventa;
    private int stock;

    public ProductoDTO(String idproducto, String nombre, int idcategoria, double preciocompra, double precioventa, int stock) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.idcategoria = idcategoria;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
        this.stock = stock;
    }

    public ProductoDTO() {
    }

    //mètodos get y set
    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    
}


