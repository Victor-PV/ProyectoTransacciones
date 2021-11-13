/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Dominio.Posicion;
import Dominio.Usuario;
import java.sql.Date;

/**
 * Clase con la que va a inicar el programa
 * @author victo
 */
public class Main {
    /**
     * Metodo main del programa
     * @param args 
     */
    public static void main(String[] args) {
        /**
         * Crear la ventana principal de la aplicación
         */
        //FrameAplicacion ventana = new FrameAplicacion(new Usuario("123", "Victor", "Rayo", "", "123", new Date(2001, 11, 12), Posicion.ClienteAdministrador));
        FrameInicio ventana = new FrameInicio();
        ventana.setVisible(true);
        
        
    }
}
