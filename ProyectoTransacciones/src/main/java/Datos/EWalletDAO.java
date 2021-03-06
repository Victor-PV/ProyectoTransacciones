/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Compra;
import Dominio.EWallet;
import Dominio.Producto;
import Vista.Paneles.PanelAlerta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author victo
 */
public class EWalletDAO {

    private JFrame ventana;
    private Connection conexionTransaccion;

    public EWalletDAO(JFrame ventana, Connection conexionTransaccion) {
        this.ventana = ventana;
        this.conexionTransaccion = conexionTransaccion;
    }

    public EWalletDAO(JFrame ventana) {
        this.ventana = ventana;
    }

    private String SQL_INSERT = "INSERT INTO EWallet VALUES(?, ?, ?)";
    private String SQL_SELECT = "SELECT * FROM ewallet WHERE DNI LIKE ?";
    private String SQL_UPDATE_COMPRA = "UPDATE ewallet SET Saldo = ?, Puntos = ? WHERE DNI LIKE ?";
    private String SQL_UPDATE_COMPRA_PUNTOS = "UPDATE ewallet SET Puntos = ? WHERE DNI LIKE ?";
    private String SQL_UPDATE_RECARGAR = "UPDATE ewallet SET Saldo = Saldo + ? WHERE DNI LIKE ?";
    private String SQL_DELETE = "DELETE FROM ewallet WHERE DNI = ?";

    public void inertar(String DNI, float saldo, int puntos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, DNI);
            stmt.setFloat(2, saldo);
            stmt.setInt(3, puntos);

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

    public EWallet seleccionar(String DNI) {
        /**
         * Atributos del metodo
         */
        EWallet ewallet = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        /**
         * Dentro del try se establece la conexi??n con la base de datos, se
         * genera la consulta SELECT y se rellena con su resutado la lista de
         * Coches Dentro del catch se recogen los posibles errores que se pueden
         * generar dentro del try Dentro del finally se finalizan las variables
         * de conexi??n con la base de datos con sus respectivos try & catch
         */
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, DNI);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dni = rs.getString("DNI");
                float precio = rs.getFloat("Saldo");
                int puntos = rs.getInt("Puntos");
                ewallet = new EWallet(dni, precio, puntos);
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

        return ewallet;
    }

    public int actualizarCompra(Producto producto, EWallet ewallet) {
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.conexionTransaccion == null ? Conexion.getConnection() : this.conexionTransaccion;
            stmt = conn.prepareStatement(SQL_UPDATE_COMPRA);

            stmt.setFloat(1, ewallet.getSaldo() - producto.getPrecio());
            stmt.setInt(2, ewallet.getPuntos() + producto.getPuntos());
            stmt.setString(3, ewallet.getDNI());

            resultado = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmt.close();
                if (this.conexionTransaccion == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
            }
        }

        return resultado;
    }

    public int actualizarCompraPuntos(Producto producto, EWallet ewallet, int puntosGastado) {
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.conexionTransaccion == null ? Conexion.getConnection() : this.conexionTransaccion;
            stmt = conn.prepareStatement(SQL_UPDATE_COMPRA_PUNTOS);
            stmt.setInt(1, ewallet.getPuntos() - puntosGastado);
            stmt.setString(2, ewallet.getDNI());

            resultado = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmt.close();
                if (this.conexionTransaccion == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
            }
        }

        return resultado;
    }

    public int actualizarDevolucion(Compra compra, EWallet ewallet) {
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = this.conexionTransaccion == null ? Conexion.getConnection() : this.conexionTransaccion;
            stmt = conn.prepareStatement(SQL_UPDATE_COMPRA);

            stmt.setFloat(1, ewallet.getSaldo() + compra.getPrecio());
            stmt.setInt(2, ewallet.getPuntos() - compra.getPuntos());
            stmt.setString(3, ewallet.getDNI());

            resultado = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmt.close();
                if (this.conexionTransaccion == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
            }
        }

        return resultado;
    }

    public void inertarSaldo(float saldo, String DNI) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_RECARGAR);
            stmt.setFloat(1, saldo);
            stmt.setString(2, DNI);

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

    public int borrar(String DNI) {
        /**
         * Variables del metodo
         */
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        /**
         * Dentro del try se establece la conexi??n con la base de datos, se
         * genera la consulta DELETE con el coche que queramos borrar de la base
         * de datos Dentro del catch se recogen los posibles errores que se
         * pueden generar dentro del try Dentro del finally se finalizan las
         * variables de conexi??n con la base de datos con sus respectivos try &
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
                stmt.close();
                if (this.conexionTransaccion == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
            }
        }

        return resultado;
    }

}
