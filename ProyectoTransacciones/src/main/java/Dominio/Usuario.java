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
public class Usuario {
    protected String DNI, nombre, apellidos, password;
    protected Date nacimiento;

    public Usuario(String DNI, String nombre, String apellidos, String password, Date nacimiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.nacimiento = nacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getNacimiento() {
        return this.nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Usuario{" + "DNI=" + this.DNI + ", nombre=" + this.nombre + ", apellidos=" + this.apellidos + ", password=" + this.password + ", nacimiento=" + this.nacimiento + '}';
    }
    
    
    
}
