/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 * La clase Usuario servira de plantilla para los usuarios con los que se vaya a
 * trabajar durante el programa
 *
 * @author victo
 */
public class Usuario {

    /**
     * Variables de la clase
     */
    private String DNI, nombre, apellidos, password;
    private Date nacimiento;
    private Posicion posicion;

    /**
     * Constructor del objeto
     *
     * @param DNI Parametro que indicara el DNI del objeto
     * @param nombre Parametro que indicara el nombre del objeto
     * @param apellidos Parametro que indicara los apellidos del objeto
     * @param password Parametro que indicara la contraseña del objeto
     * @param nacimiento Parametro que indicara la fecha de nacimiento del
     * objeto
     * @param posicion Parametro que indicara la posicion del objeto
     */
    public Usuario(String DNI, String nombre, String apellidos, String password, Date nacimiento, Posicion posicion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.nacimiento = nacimiento;
        this.posicion = posicion;
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
     * Metodo que actualizara la variable DNI del objeto
     *
     * @param DNI nuevo valor para DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Metodo que devolvera la variable Nombre del objeto
     *
     * @return valor del Nombre del objeto
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que actualizara la variable Nombre del objeto
     *
     * @param nombre nuevo valor para Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que devolvera la variable Apellidos del objeto
     *
     * @return valor de los apellidos del objeto
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Metodo que actualizara la variable Apellidos del objeto
     *
     * @param apellidos nuevo valor para Apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Metodo que devolvera la variable Password del objeto
     *
     * @return valor de la contraseña del objeto
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Metodo que actualizara la variable Password del objeto
     *
     * @param password nuevo valor para Nombre
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo que devolvera la variable Nacimiento del objeto
     *
     * @return valor de la fecha de nacimiento del objeto
     */
    public Date getNacimiento() {
        return this.nacimiento;
    }

    /**
     * Metodo que actualizara la variable Nacimiento del objeto
     *
     * @param nacimiento nuevo valor para Nacimiento
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * Metodo que devolvera la variable Posicion del objeto
     *
     * @return valor de la posicion del objeto
     */
    public Posicion getPosicion() {
        return this.posicion;
    }

    /**
     * Metodo que actualizara la variable Posicion del objeto
     *
     * @param posicion nuevo valor para Posicion
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    /**
     * Metodo que devuelve en un String una descripción del objeto con sus
     * variables
     *
     * @return String con las variables del objeto
     */
    @Override
    public String toString() {
        return "Usuario{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", password=" + password + ", nacimiento=" + nacimiento + ", posicion=" + posicion + '}';
    }

}
