/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 * La clase EWallet servira de plantilla para las "E-Wallet" asignadas a los
 * usuarios con los que se vaya a trabajar durante el programa
 *
 * @author victo
 */
public class EWallet {

    /**
     * Variables de la clase
     */
    private String DNI;
    private float saldo;
    private int puntos;

    /**
     * Constructor del objeto
     *
     * @param DNI Parametro que indicara el DNI del propietario de la EWallet
     * @param saldo Parametro que indicara el Saldo del propietario de la
     * EWallet
     * @param puntos Parametro que indicara los puntos del propietario de la
     * EWallet
     */
    public EWallet(String DNI, float saldo, int puntos) {
        this.DNI = DNI;
        this.saldo = saldo;
        this.puntos = puntos;
    }

    /**
     * Metodo que devolvera la variable DNI del objeto
     *
     * @return valor del DNI del objeto
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Metodo que devolvera la variable Saldo del objeto
     *
     * @return valor del Saldo del objeto
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Metodo que actualizara la variable Saldo del objeto
     *
     * @param saldo nuevo valor para Saldo
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
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
     * @param puntos nuevo valor para Puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Metodo que devuelve en un String una descripción del objeto con sus
     * variables
     *
     * @return String con las variables del objeto
     */
    @Override
    public String toString() {
        return "EWallet{" + "DNI=" + DNI + ", saldo=" + saldo + ", puntos=" + puntos + '}';
    }

}
