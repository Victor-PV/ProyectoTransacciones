/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Producto;
import Vista.Paneles.PanelAlerta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author victo
 */
public class ProductoDAO {

    private JFrame ventana;
    
    public ProductoDAO(JFrame ventana){
        this.ventana = ventana;
    }
    
    private String SQL_SELECT = "SELECT * FROM productos";
    private String SQL_UPDATE = "UPDATE productos SET cantidad = (cantidad - 1) WHERE Codigo LIKE ?";
    private String SQL_SELECT_ONE = "SELECT * FROM productos WHERE Codigo LIKE ?";
    private String SQL_UPDATE_STOCK = "UPDATE productos SET cantidad = cantidad + ? WHERE Codigo LIKE ?";
    private String SQL_UPDATE_PUNTOS = "UPDATE productos SET puntos = ? WHERE Codigo LIKE ?";

    public List<Producto> seleccionar() {
        /**
         * Atributos del metodo
         */
        List<Producto> productos = new ArrayList();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        /**
         * Dentro del try se establece la conexión con la base de datos, se
         * genera la consulta SELECT y se rellena con su resutado la lista de
         * Coches Dentro del catch se recogen los posibles errores que se pueden
         * generar dentro del try Dentro del finally se finalizan las variables
         * de conexión con la base de datos con sus respectivos try & catch
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

    public int actualizar(Producto producto) {
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, producto.getCodigo());

            resultado = stmt.executeUpdate();
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
        }

        return resultado;
    }

    public Producto seleccionarProducto(String codigoP) {
        Producto producto = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean existe = false;

        for (Producto p : seleccionar()) {
            if (p.getCodigo().equalsIgnoreCase(codigoP)) {
                existe = true;
            }
        }

        if (existe) {
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_ONE);
                stmt.setString(1, codigoP);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String codigo = rs.getString("Codigo");
                    String nombre = rs.getString("Nombre");
                    float precio = rs.getFloat("Precio");
                    int puntos = rs.getInt("Puntos");
                    int cantidad = rs.getInt("Cantidad");

                    producto = new Producto(codigo, nombre, precio, puntos, cantidad);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
                PanelAlerta ventanaError = new PanelAlerta(ventana, true, "El producto no se ha encontrado", "ERROR");
                ventanaError.setVisible(true);
        }

        return producto;
    }
    
    public void inertarStock(int cantidad, Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            //Se comprueba si existe algun usuario con ese DNI
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_STOCK);
            stmt.setInt(1, cantidad);
            stmt.setString(2, producto.getCodigo());

            resultado = stmt.executeUpdate();

        } catch (Exception e) {
            PanelAlerta ventanaError = new PanelAlerta(ventana, true, e.getMessage(), "ERROR");
            ventanaError.setVisible(true);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
        }
        try {
            stmt.close();
        } catch (SQLException ex) {
        }

    }
        public void actualizarPuntos(int cantidad, Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            //Se comprueba si existe algun usuario con ese DNI
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_PUNTOS);
            stmt.setInt(1, cantidad);
            stmt.setString(2, producto.getCodigo());

            resultado = stmt.executeUpdate();

        } catch (Exception e) {
            PanelAlerta ventanaError = new PanelAlerta(ventana, true, e.getMessage(), "ERROR");
            ventanaError.setVisible(true);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
        }
        try {
            stmt.close();
        } catch (SQLException ex) {
        }

    }

}
