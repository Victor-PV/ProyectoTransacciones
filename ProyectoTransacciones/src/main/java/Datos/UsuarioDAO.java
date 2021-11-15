/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.Posicion;
import Dominio.Usuario;
import Vista.Paneles.PanelAlerta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author victo
 */
public class UsuarioDAO {

    private JFrame ventana;
    private Connection conexionTransaccion;

    public UsuarioDAO(JFrame ventana, Connection conexionTransaccion) {
        this.ventana = ventana;
        this.conexionTransaccion = conexionTransaccion;
    }
    public UsuarioDAO(JFrame ventana) {
        this.ventana = ventana;
    }
    
    private EWalletDAO ewalletDAO = new EWalletDAO(this.ventana);

    private String SQL_SELECT = "SELECT * FROM usuarios WHERE DNI LIKE ?";
    private String SQL_INSERT = "INSERT INTO usuarios VALUES(?, ?, ?, ?, ?, ?, ?)";
    private String SQL_SEARCH_DNI = "SELECT * FROM usuarios WHERE DNI LIKE ?";
    private String SQL_LOGIN = "SELECT * FROM usuarios WHERE DNI LIKE ? AND password LIKE ?";
    private String SQL_UPDATE_POSICION = "UPDATE usuarios SET Posicion = 'ClienteAdministrador' WHERE DNI LIKE ?";
    private String SQL_UPDATE_USER = "UPDATE usuarios SET nombre = ?, apellidos = ?, correo = ? WHERE DNI LIKE ?";
    private String SQL_DELETE = "DELETE FROM usuarios WHERE DNI = ?";


    public Usuario select(String DNI) {
        Usuario usuario = new Usuario();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, DNI);
            rs = stmt.executeQuery();

            String nombre, apellidos, password, correo;
            Date nacimiento;
            Posicion posicion;

            while (rs.next()) {
                nombre = rs.getString("Nombre");
                apellidos = rs.getString("Apellidos");
                correo = rs.getString("Correo");
                nacimiento = rs.getDate("FechaNacimiento");
                password = rs.getString("Password");
                posicion = Posicion.valueOf(rs.getString("Posicion"));

                usuario = new Usuario(DNI, nombre, apellidos, correo, password, nacimiento, posicion);
            }

        } catch (Exception e) {
            PanelAlerta ventanaError = new PanelAlerta(ventana, true, e.getMessage(), "ERROR");
            ventanaError.setVisible(true);
        }

        return usuario;
    }

    public ArrayList<String> login(String DNI, String password) {
        ArrayList<String> usuarios = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_LOGIN);
            stmt.setString(1, DNI);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(rs.getString("DNI"));
            }
        } catch (Exception e) {
            PanelAlerta ventanaError = new PanelAlerta(ventana, true, e.getMessage(), "ERROR");
            ventanaError.setVisible(true);
        } finally {

            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                PanelAlerta ventanaError = new PanelAlerta(ventana, true, ex.getMessage(), "ERROR");
                ventanaError.setVisible(true);
            }
        }

        return usuarios;
    }

    /**
     * metodo que tal
     *
     * -2: El usuario ya existe 1: Usuario introducido 2: Usuario actualizado
     *
     * @param usuario
     * @return
     * @throws ExceptionDAO
     */
    public int insertar(Usuario usuario) throws ExceptionDAO {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<String> listaUsuarios = new ArrayList<>();
        ResultSet rs = null;
        int resultado = 0;

        try {
            //Se comprueba si existe algun usuario con ese DNI
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SEARCH_DNI);
            stmt.setString(1, usuario.getDNI());

            rs = stmt.executeQuery();
            while (rs.next()) {
                listaUsuarios.add(rs.getString("DNI"));

                //Si el usuario es el mismo pero cambia la posicion (antes era cliente y ahora lo resgistran como administrador), se lanzara una sentencia UPDATE
                //para modificar al usuario a ClienteAdministrador
                if (rs.getString("DNI").equalsIgnoreCase(usuario.getDNI())
                        && rs.getString("Nombre").equalsIgnoreCase(usuario.getNombre())
                        && rs.getString("Apellidos").equalsIgnoreCase(usuario.getApellidos())
                        && rs.getString("Password").equalsIgnoreCase(usuario.getPassword())
                        && !rs.getString("Posicion").equalsIgnoreCase(usuario.getPosicion() + "")) {

                    stmt = conn.prepareStatement(SQL_UPDATE_POSICION);
                    stmt.setString(1, usuario.getDNI());

                    resultado = stmt.executeUpdate();
                    if (resultado == 1) {
                        return 2;
                    }
                }

            }
            //Si existe un usuario con el mismo DNI saldra del metodo
            if (listaUsuarios.size() > 0) {
                return -2;
            }

            //Consulta donde se insertara el usuario despues de revisar que no haya otro con el mismo DNI
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getDNI());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getCorreo());
            stmt.setDate(5, usuario.getNacimiento());
            stmt.setString(6, usuario.getPassword());
            stmt.setString(7, usuario.getPosicion() + "");

            resultado = stmt.executeUpdate();
            if (resultado == 1) {
                ewalletDAO.inertar(usuario.getDNI(), 0.0f, 0);
                return 1;
            }

        } catch (Exception e) {
            PanelAlerta ventanaError = new PanelAlerta(ventana, true, e.getMessage(), "ERROR");
            ventanaError.setVisible(true);
        }

        return 5;
    }

    public int actualizar(String nombre, String apellidos, String correo, Usuario usuario) {
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_USER);

            stmt.setString(1, nombre);
            stmt.setString(2, apellidos);
            stmt.setString(3, correo);
            stmt.setString(4, usuario.getDNI());

            resultado = stmt.executeUpdate();
        } catch (Exception e) {
            PanelAlerta ventanaError = new PanelAlerta(ventana, true, e.getMessage(), "ERROR");
            ventanaError.setVisible(true);
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
    
    public int borrar(String DNI) {
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
