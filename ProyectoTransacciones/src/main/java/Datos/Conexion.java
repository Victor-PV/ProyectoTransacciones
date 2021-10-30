/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * La clase Conexion almacena los datos de la base de datos y da opción desde otras clases a establecer conexión con la misma
 * @author victo
 */
public class Conexion {
    /**
     * Variables de la clase
     */
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/proyectotransacciones?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
        /**
     * La función getConnection establece la conexión y la devuelve
     * @return El return devuelve el objeto con el cual se ha establacido la conexión
     * @throws SQLException La excepción que lanza es el posible error que puede devolver el objeto Connection
     */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    /**
     * Recibe un objeto ResultSet y lo cierra
     * @param rs El parametro rs tiene como valor el objero ResultSet que se quiere cerrar
     * @throws SQLException La excepción que lanza es el posible error que puede devolver el objeto rs al cerrarse
     */
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    /**
     * Recibe un objeto, PreparedStatement y lo cierra
     * @param stmt El parametro stmt tiene como valor el objero PreparedStatement que se quiere cerrar
     * @throws SQLException La excepción que lanza es el posible error que puede devolver el objeto stmt al cerrarse
     */
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    
    /**
     * Recibe un objeto Connection y lo cierra
     * @param conn El parametro conn tiene como valor el objero Connection que se quiere cerrar
     * @throws SQLException La excepción que lanza es el posible error que puede devolver el objeto conn al cerrarse
     */
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
