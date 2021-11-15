/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Datos.ComprasDAO;
import Datos.Conexion;
import Datos.EWalletDAO;
import Datos.ProductoDAO;
import Datos.UsuarioDAO;
import Dominio.EWallet;
import Dominio.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelUsuario extends JPanel {

    /**
     * Variables de la clase
     */
    private UsuarioDAO usuarioDAO;
    private EWalletDAO ewalletDAO;
    private EWallet ewallet;
    private Usuario usuarioActual;

    private ImageIcon img;
    private JLabel imgUser;

    private JLabel txtDNI, txtNombre, txtApellidos, txtSaldo, txtPuntos, txtPosicion, txtCorreo;
    private JTextField campoDNI, campoNombre, campoApellidos, campoSaldo, campoPuntos, campoPosicion, campoCorreo;

    private JPanel panelBotones;
    private JButton botonActualizar;
    private JButton botonBorrar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelUsuario(JFrame ventana, Usuario usuario) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        usuarioDAO = new UsuarioDAO(ventana);
        ewalletDAO = new EWalletDAO(ventana);
        ewallet = ewalletDAO.seleccionar(usuario.getDNI());
        usuarioActual = usuarioDAO.select(usuario.getDNI());

        /**
         * Avatar del usuario
         */
        img = new ImageIcon("./src/main/java/Imagenes/imgUser.png");
        imgUser = new JLabel();
        imgUser.setIcon(img);
        //imgUser.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        g.insets = new Insets(50, 30, 40, 0);
        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 5;
        g.weightx = 0.1;
        this.add(imgUser, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo DNI
         */
        txtDNI = new JLabel("DNI: ");
        txtDNI.setForeground(colorSecundario);
        txtDNI.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(50, 30, 15, 0);
        g.gridx = 1;
        g.gridy = 0;
        g.weightx = 0.35;
        this.add(txtDNI, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo DNI No sera editable
         */
        campoDNI = new JTextField("23322973F");
        campoDNI.setPreferredSize(new Dimension(150, 35));
        campoDNI.setEditable(false);
        campoDNI.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.insets = new Insets(0, 30, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 1;
        g.weightx = 0.35;
        this.add(campoDNI, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo Nombre
         */
        txtNombre = new JLabel("Nombre: ");
        txtNombre.setForeground(colorSecundario);
        txtNombre.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(50, 0, 15, 0);
        g.gridx = 2;
        g.gridy = 0;
        g.weightx = 0.55;
        this.add(txtNombre, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Nombre
         */
        campoNombre = new JTextField(usuarioActual.getNombre());
        campoNombre.setPreferredSize(new Dimension(300, 35));
        campoNombre.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.insets = new Insets(0, 0, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 1;
        g.weightx = 0.55;
        this.add(campoNombre, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo Saldo
         */
        txtSaldo = new JLabel("Saldo: ");
        txtSaldo.setForeground(colorSecundario);
        txtSaldo.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(0, 30, 15, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 2;
        g.weightx = 0.35;
        this.add(txtSaldo, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Saldo No sera editable
         */
        campoSaldo = new JTextField(ewallet.getSaldo() + "€");
        campoSaldo.setPreferredSize(new Dimension(150, 35));
        campoSaldo.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoSaldo.setEditable(false);
        g.insets = new Insets(0, 30, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 3;
        g.weightx = 0.35;
        this.add(campoSaldo, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo Nombre
         */
        txtApellidos = new JLabel("Apellidos: ");
        txtApellidos.setForeground(colorSecundario);
        txtApellidos.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 0, 15, 0);
        g.gridx = 2;
        g.gridy = 2;
        g.weightx = 0.55;
        this.add(txtApellidos, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Nombre
         */
        campoApellidos = new JTextField(usuarioActual.getApellidos());
        campoApellidos.setPreferredSize(new Dimension(300, 35));
        campoApellidos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.insets = new Insets(0, 0, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 3;
        g.weightx = 0.55;
        this.add(campoApellidos, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo Puntos
         */
        txtPuntos = new JLabel("Puntos: ");
        txtPuntos.setForeground(colorSecundario);
        txtPuntos.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(0, 30, 10, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 4;
        g.weightx = 0.35;
        this.add(txtPuntos, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Puntos No sera editable
         */
        campoPuntos = new JTextField(ewallet.getPuntos() + " Pts");
        campoPuntos.setPreferredSize(new Dimension(150, 35));
        campoPuntos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPuntos.setEditable(false);
        g.insets = new Insets(0, 30, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 5;
        g.weightx = 0.35;
        this.add(campoPuntos, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo Nombre
         */
        txtCorreo = new JLabel("Correo: ");
        txtCorreo.setForeground(colorSecundario);
        txtCorreo.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 0, 15, 0);
        g.gridx = 2;
        g.gridy = 4;
        g.weightx = 0.55;
        this.add(txtCorreo, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Nombre
         */
        campoCorreo = new JTextField(usuarioActual.getCorreo());
        campoCorreo.setPreferredSize(new Dimension(300, 35));
        campoCorreo.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.insets = new Insets(0, 0, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 5;
        g.weightx = 0.55;
        this.add(campoCorreo, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo Posicion
         */
        txtPosicion = new JLabel("Posición: ");
        txtPosicion.setForeground(colorSecundario);
        txtPosicion.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(0, 30, 10, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 6;
        g.weightx = 0.35;
        this.add(txtPosicion, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Posicion No sera editable
         */
        campoPosicion = new JTextField(usuarioActual.getPosicion() + "");
        campoPosicion.setPreferredSize(new Dimension(150, 35));
        campoPosicion.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPosicion.setEditable(false);
        g.insets = new Insets(0, 30, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 7;
        g.weightx = 0.35;
        this.add(campoPosicion, g);
        limpiarConstraints(g);

        /**
         * Panel donde se colocaran los botones
         */
        panelBotones = new JPanel(new BorderLayout());
        panelBotones.setOpaque(false);
        //panelBotones.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(70, 100, 0, 90);
        g.gridx = 0;
        g.gridy = 8;
        g.gridwidth = 3;
        this.add(panelBotones, g);
        limpiarConstraints(g);

        /**
         * Boton para actualizar los cambios
         */
        botonBorrar = new JButton("BORRAR CUENTA");
        botonBorrar.setPreferredSize(new Dimension(160, 40));
        botonBorrar.setBackground(new Color(187, 52, 28));
        botonBorrar.setForeground(Color.WHITE);
        botonBorrar.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        botonBorrar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonBorrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonBorrar.setFocusPainted(false);
        panelBotones.add(botonBorrar, BorderLayout.WEST);
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Transaccion para borrar el cliente, su ewallet y sus compras
                //Transaccion
                try {
                    Connection conexionTransaccion = Conexion.getConnection();
                    ComprasDAO comprasDAOTra = new ComprasDAO(ventana, conexionTransaccion);
                    UsuarioDAO usuarioDAOTra = new UsuarioDAO(ventana, conexionTransaccion);
                    EWalletDAO ewalletDAOra = new EWalletDAO(ventana, conexionTransaccion);
                    
                    try {

                        if (conexionTransaccion.getAutoCommit()) {
                            conexionTransaccion.setAutoCommit(false);
                        }

                        comprasDAOTra.borrarCompras(usuario.getDNI());//Borrar todas las compras del usuario
                        ewalletDAOra.borrar(usuario.getDNI());//Borrar la ewallet del usuario
                        usuarioDAOTra.borrar(usuario.getDNI());//Borra el usuario

                        conexionTransaccion.commit();

                        PanelAlerta ventanaCommit = new PanelAlerta(ventana, true, "El usuario ha sido eliminado", "");
                        ventanaCommit.setVisible(true);

                        ventana.dispose();//Se cierra la ventana

                    } catch (Exception ec) {
                        PanelAlerta ventanaCommit = new PanelAlerta(ventana, true, ec.getMessage(), "ERROR");
                        ventanaCommit.setVisible(true);
                        try {

                            conexionTransaccion.rollback();
                        } catch (Exception er) {
                            PanelAlerta ventanaRollback = new PanelAlerta(ventana, true, er.getMessage(), "ERROR");
                            ventanaRollback.setVisible(true);
                        }
                    }
                } catch (Exception ev) {
                    PanelAlerta ventanaConnection = new PanelAlerta(ventana, true, ev.getMessage(), "ERROR");
                    ventanaConnection.setVisible(true);
                }
            }
        });

        botonActualizar = new JButton("ACTUALIZAR");
        botonActualizar.setPreferredSize(new Dimension(140, 40));
        botonActualizar.setBackground(colorSecundario);
        botonActualizar.setForeground(colorPrincipal);
        botonActualizar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonActualizar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonActualizar.setFocusPainted(false);
        panelBotones.add(botonActualizar, BorderLayout.EAST);
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioDAO.actualizar(campoNombre.getText(), campoApellidos.getText(), campoCorreo.getText(), usuarioActual) == 1) {

                    PanelAlerta ventanaComprado = new PanelAlerta(ventana, true, "Perfil actualizado", "");
                    ventanaComprado.setVisible(true);

                    ventana.setContentPane(new PanelAplicacion(ventana, new PanelUsuario(ventana, usuario), usuario));
                    ventana.invalidate();
                    ventana.validate();
                }
            }
        });
    }

    /**
     * Metodo para limpiar la variable GridBagConstraint (g) que coloca los
     * objetos
     *
     * @param g Variable a la que se van a borrar los parametros
     */
    private void limpiarConstraints(GridBagConstraints g) {
        g.gridx = 0;
        g.gridy = 0;
        g.gridheight = 1;
        g.gridwidth = 1;
        g.ipadx = 0;
        g.ipady = 0;
        g.insets = new Insets(0, 0, 0, 0);
        g.anchor = GridBagConstraints.CENTER;
        g.fill = GridBagConstraints.NONE;
    }
}
