/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
public class ProductoDAO {
    private String SQL_SELECT = "SELECT * FROM productos";
    
     public List<Producto> seleccionar() {
        /**
         * Atributos del metodo
         */
        List<Producto> productos = new ArrayList();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        /**
         * Dentro del try se establece la conexión con la base de datos, se genera la consulta SELECT y se rellena con su resutado la lista de Coches
         * Dentro del catch se recogen los posibles errores que se pueden generar dentro del try
         * Dentro del finally se finalizan las variables de conexión con la base de datos con sus respectivos try & catch
         */
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                int puntos = rs.getInt("puntos");
                int cantidad = rs.getInt("cantidad");
                productos.add(new Producto(codigo, nombre, precio, puntos, cantidad));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
            }
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }

        return productos;
    }
    
}
