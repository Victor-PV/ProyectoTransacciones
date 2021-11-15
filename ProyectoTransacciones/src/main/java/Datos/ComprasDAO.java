/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Compra;
import Dominio.Producto;
import Dominio.Usuario;
import Vista.Paneles.PanelAlerta;
import java.sql.Connection;
import java.sql.Date;
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
public class ComprasDAO {

    private JFrame ventana;
    private Connection conexionTransaccion;

    public ComprasDAO(JFrame ventana) {
        this.ventana = ventana;
        this.conexionTransaccion = null;
    }

    public ComprasDAO(JFrame ventana, Connection conexionTransaccion) {
        this.ventana = ventana;
        this.conexionTransaccion = conexionTransaccion;
    }
    private String SQL_INSERT = "INSERT INTO compras VALUES(null, ?, ? , ? , ?, ?)";
    private String SQL_SELECT = "SELECT c.*, p.Nombre FROM compras c INNER JOIN productos p ON c.CodigoProducto = p.Codigo WHERE c.DNI LIKE ? ORDER BY c.ID DESC LIMIT 10";
    private String SQL_SELECT_COMPRA = "SELECT * FROM compras WHERE DNI LIKE ? AND ID = ?";
    private String SQL_DELETE = "DELETE FROM compras WHERE ID = ?";
    private String SQL_DELETE_COMPRA = "DELETE FROM compras WHERE DNI = ?";

    public List<Compra> seleccionar(String DNIUsuario) {
        /**
         * Atributos del metodo
         */
        List<Compra> compras = new ArrayList();
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
            stmt.setString(1, DNIUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String DNI = rs.getString("DNI");
                String codigoProducto = rs.getString("CodigoProducto");
                String nombreProducto = rs.getString("Nombre");
                float precio = rs.getFloat("precio");
                int puntos = rs.getInt("puntos");
                Date fechaCompra = rs.getDate("FechaCompra");
                compras.add(new Compra(ID, DNI, codigoProducto, nombreProducto, precio, puntos, fechaCompra));
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

        return compras;
    }

    public void inertar(Usuario usuario, Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            //Se comprueba si existe algun usuario con ese DNI
            conn = this.conexionTransaccion == null ? Conexion.getConnection() : this.conexionTransaccion;
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getDNI());
            stmt.setString(2, producto.getCodigo());
            stmt.setFloat(3, producto.getPrecio());
            stmt.setInt(4, producto.getPuntos());

            //Fecha actual formato sql
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            stmt.setDate(5, date);

            resultado = stmt.executeUpdate();

        } catch (Exception e) {
            PanelAlerta ventanaError = new PanelAlerta(ventana, true, e.getMessage(), "ERROR");
            ventanaError.setVisible(true);
        }
        try {
            stmt.close();
            if (this.conexionTransaccion == null) {
                Conexion.close(conn);
            }
        } catch (SQLException ex) {
        }

    }

    public Compra seleccionarCompra(String DNIUsuario, int IDCompra) {
        /**
         * Atributos del metodo
         */
        Compra compra = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        //Comprueba si la compra esta dentro de las ultimas 10 que ha realizado
        boolean isValida = false;
        List<Compra> listaCompras = seleccionar(DNIUsuario);
        for (Compra c : listaCompras) {
            isValida = c.getID() == IDCompra;
            if (isValida) {
                break;
            }
        }

        if (isValida) {
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_COMPRA);
                stmt.setString(1, DNIUsuario);
                stmt.setInt(2, IDCompra);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    int ID = rs.getInt("ID");
                    String DNI = rs.getString("DNI");
                    String codigoProducto = rs.getString("CodigoProducto");
                    float precio = rs.getFloat("precio");
                    int puntos = rs.getInt("puntos");
                    Date fechaCompra = rs.getDate("FechaCompra");
                    compra = new Compra(ID, DNI, codigoProducto, "", precio, puntos, fechaCompra);
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
            }
        }
        return compra;
    }

    public int borrar(Compra compra) {
        /**
         * Variables del metodo
         */
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        /**
         * Dentro del try se establece la conexión con la base de datos, se
         * genera la consulta DELETE con el coche que queramos borrar de la base
         * de datos Dentro del catch se recogen los posibles errores que se
         * pueden generar dentro del try Dentro del finally se finalizan las
         * variables de conexión con la base de datos con sus respectivos try &
         * catch
         */
        try {
            conn = this.conexionTransaccion == null ? Conexion.getConnection() : this.conexionTransaccion;
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, compra.getID());

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
    
    public int borrarCompras(String DNI) {
        /**
         * Variables del metodo
         */
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        /**
         * Dentro del try se establece la conexión con la base de datos, se
         * genera la consulta DELETE con el coche que queramos borrar de la base
         * de datos Dentro del catch se recogen los posibles errores que se
         * pueden generar dentro del try Dentro del finally se finalizan las
         * variables de conexión con la base de datos con sus respectivos try &
         * catch
         */
        try {
            conn = this.conexionTransaccion == null ? Conexion.getConnection() : this.conexionTransaccion;
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, DNI);

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

}
