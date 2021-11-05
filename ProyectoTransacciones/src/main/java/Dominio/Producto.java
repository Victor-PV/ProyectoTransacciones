/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 * La clase Producto servira de plantilla para los productos con los que se vaya
 * a trabajar durante el programa
 *
 * @author victo
 */
public class Producto {

    /**
     * Variables de la clase
     */
    private String codigo, nombre;
    private float precio;
    private int puntos;

    /**
     * Constructor del objeto
     *
     * @param codigo Parametro que indicara el Codigo del objeto
     * @param nombre Parametro que indicara el Nombre del objeto
     * @param precio Parametro que indicara el Precio del objeto
     * @param puntos Parametro que indicara los Puntos del objeto
     */
    public Producto(String codigo, String nombre, float precio, int puntos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.puntos = puntos;
    }

    /**
     * Metodo que devolvera la variable Codigo del objeto
     *
     * @return valor del Codigo del objeto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo que devolvera la variable Nombre del objeto
     *
     * @return valor del Nombre del objeto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que devolvera la variable Precio del objeto
     *
     * @return valor del Precio del objeto
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Metodo que devolvera la variable Puntos del objeto
     *
     * @return valor del Puntos del objeto
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Metodo que actualizara la variable Puntos del objeto
     *
     * @param puntos nuevo valor para DNI
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
