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
public class Cliente extends Usuario{
    private float saldo;
    private int puntos;

    public Cliente(String DNI, String nombre, String apellidos, String password, Date nacimiento) {
        super(DNI, nombre, apellidos, password, nacimiento);
        this.saldo = 0;
        this.puntos = 0;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "DNI=" + this.DNI + ", nombre=" + this.nombre + ", apellidos=" + this.apellidos + ", password=" + this.password + ", nacimiento=" + this.nacimiento +"saldo=" + this.saldo + ", puntos=" + this.puntos + '}';
    }
    
    
}
