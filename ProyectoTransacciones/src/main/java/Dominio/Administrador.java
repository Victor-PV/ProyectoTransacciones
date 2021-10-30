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
public class Administrador extends Usuario{
    private String codigoAdministrador;

    public Administrador(String codigoAdministrador, String DNI, String nombre, String apellidos, String password, Date nacimiento) {
        super(DNI, nombre, apellidos, password, nacimiento);
        this.codigoAdministrador = codigoAdministrador;
    }

    public String getCodigoAdministrador() {
        return this.codigoAdministrador;
    }

    public void setCodigoAdministrador(String codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    @Override
    public String toString() {
        return "Administrador{" + "DNI=" + super.DNI + ", nombre=" + super.nombre + ", apellidos=" + super.apellidos + ", password=" + super.password + ", nacimiento=" + super.nacimiento +"codigoAdministrador=" + this.codigoAdministrador + '}';
    }
    
    
    
}
