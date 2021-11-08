/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author victo
 */
public class Compra {

    private String DNI, codProducto;
    private float precio;
    private int puntos;
    private Date fechaCompra;

    public Compra(String DNI, Producto producto, Date fechaCompra) {
        this.DNI = DNI;
        this.codProducto = producto.getCodigo();
        this.precio = producto.getPrecio();
        this.puntos = producto.getPuntos();
        this.fechaCompra = fechaCompra;
    }

    /**
     * Metodo que devolvera la variable DNI del objeto
     *
     * @return valor del DNI del objeto
     */
    public String getDNI() {
        return this.DNI;
    }

    /**
     * Metodo que devolvera la variable codProducto del objeto
     *
     * @return valor del codProducto del objeto
     */
    public String getCodProducto() {
        return this.codProducto;
    }

    /**
     * Metodo que devolvera la variable Precio del objeto
     *
     * @return valor del Precio del objeto
     */
    public float getPrecio() {
        return this.precio;
    }

    /**
     * Metodo que devolvera la variable Puntos del objeto
     *
     * @return valor del Puntos del objeto
     */
    public int getPuntos() {
        return this.puntos;
    }

    /**
     * Metodo que devolvera la variable FechaCompra del objeto
     *
     * @return valor del FechaCompra del objeto
     */
    public Date getFechaCompra() {
        return this.fechaCompra;
    }
    
    /**
     * Metodo que devuelve en un String una descripción del objeto con sus
     * variables
     *
     * @return String con las variables del objeto
     */
    @Override
    public String toString() {
        return "Compra{" + "DNI=" + DNI + ", codProducto=" + codProducto + ", precio=" + precio + ", puntos=" + puntos + ", fechaCompra=" + fechaCompra + '}';
    }

}
