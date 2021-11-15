/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Datos.ComprasDAO;
import Datos.Conexion;
import Datos.EWalletDAO;
import Datos.ExceptionDAO;
import Datos.UsuarioDAO;
import Dominio.Compra;
import Dominio.EWallet;
import Dominio.Usuario;
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
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelReembolso extends JPanel {

    /**
     * Variables de la clase
     */
    private ComprasDAO comprasDAO;
    private EWalletDAO ewalletDAO;
    private List<Compra> listaCompras;
    private EWallet ewallet;
    private Compra compraReembolso;

    private ImageIcon img;
    private JLabel imgUser, titulo;
    private JLabel labelNumeroTarjeta, txtPuntosActual, txtSaldoActual;
    private JTextField campoSaldoActual, campoPuntosActual;
    private JButton botonRecargar;

    private JLabel espacio;

    private JPanel panelFecha;

    private JLabel labelTabla, labelCasilla, labelPedirID, labelTitularTarjetaApellidos, labelCodigoTarjeta, labelFechaTarjeta;
    private JTextField campoPedirID, campoTitularTarjetaNombre, campoTitularTarjetaApellidos, campoCodigoTarjet;

    private JPanel panelTabla;

    private JComboBox listaDias, listaMeses, listaAños;
    private String[] dias = new String[32], meses = new String[13], años = new String[201];

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelReembolso(JFrame ventana, Usuario usuario) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        comprasDAO = new ComprasDAO(ventana);
        ewalletDAO = new EWalletDAO(ventana);
        ewallet = ewalletDAO.seleccionar(usuario.getDNI());

        titulo = new JLabel("Reembolsar compra:");
        titulo.setForeground(colorSecundario);
        titulo.setFont(new Font(fuenteSecundaria, Font.BOLD, 26));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 30;
        g.insets = new Insets(-90, 50, 30, 50);
        this.add(titulo, g);
        limpiarConstraints(g);

        /**
         * JLabel para espaciar entre zonas
         */
        espacio = new JLabel();
        espacio.setForeground(colorSecundario);
        espacio.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        espacio.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 50, 0, 50);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 30;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);

        /**
         * Texto para la cantidad disponible
         */
        labelTabla = new JLabel("Tus ultimas 10 compras: ");
        labelTabla.setForeground(colorSecundario);
        labelTabla.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(30, 50, 0, 0);
        g.gridx = 0;
        g.gridy = 2;
        //g.weightx = 0.2;
        this.add(labelTabla, g);
        limpiarConstraints(g);
        /**
         * Campo de texto la cantidad disponible
         */
        panelTabla = new JPanel(new GridBagLayout());
        panelTabla.setOpaque(false);
        g.insets = new Insets(0, 50, 0, 0);
        g.gridx = 0;
        g.gridy = 3;
        g.gridheight = 10;
        g.fill = GridBagConstraints.HORIZONTAL;
        //g.weightx = 0.2;
        this.add(panelTabla, g);
        limpiarConstraints(g);

        labelCasilla = new JLabel("ID");
        labelCasilla.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        labelCasilla.setHorizontalAlignment(JLabel.CENTER);
        labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        labelCasilla.setPreferredSize(new Dimension(20, 30));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(0, 0, 0, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 0;
        g.ipady = 20;
        panelTabla.add(labelCasilla, g);
        limpiarConstraints(g);

        labelCasilla = new JLabel("Producto");
        labelCasilla.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        labelCasilla.setHorizontalAlignment(JLabel.CENTER);
        labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        labelCasilla.setPreferredSize(new Dimension(140, 30));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 0;
        g.ipady = 20;
        panelTabla.add(labelCasilla, g);
        limpiarConstraints(g);

        labelCasilla = new JLabel("Precio");
        labelCasilla.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        labelCasilla.setHorizontalAlignment(JLabel.CENTER);
        labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        labelCasilla.setPreferredSize(new Dimension(55, 30));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 0;
        g.ipady = 20;
        panelTabla.add(labelCasilla, g);
        limpiarConstraints(g);

        labelCasilla = new JLabel("Puntos");
        labelCasilla.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        labelCasilla.setHorizontalAlignment(JLabel.CENTER);
        labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        labelCasilla.setPreferredSize(new Dimension(55, 30));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 0, 0, 0);
        g.gridx = 3;
        g.gridy = 0;
        g.ipady = 20;
        panelTabla.add(labelCasilla, g);
        limpiarConstraints(g);

        labelCasilla = new JLabel("Fecha");
        labelCasilla.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        labelCasilla.setHorizontalAlignment(JLabel.CENTER);
        labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        labelCasilla.setPreferredSize(new Dimension(70, 30));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 0, 0, 0);
        g.gridx = 4;
        g.gridy = 0;
        g.ipady = 20;
        panelTabla.add(labelCasilla, g);
        limpiarConstraints(g);

        listaCompras = comprasDAO.seleccionar(usuario.getDNI());
        int cantidadLineas = listaCompras.size() > 10 ? 10 : listaCompras.size();

        for (int i = 0; i < cantidadLineas; i++) {
            labelCasilla = new JLabel(listaCompras.get(i).getID() + "");
            labelCasilla.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
            labelCasilla.setPreferredSize(new Dimension(60, 30));
            labelCasilla.setHorizontalAlignment(JLabel.CENTER);
            labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));

            g.fill = GridBagConstraints.HORIZONTAL;
            g.anchor = GridBagConstraints.LINE_START;
            g.gridx = 0;
            g.gridy = i + 1;
            g.ipady = 3;
            panelTabla.add(labelCasilla, g);
            limpiarConstraints(g);
            //////

            labelCasilla = new JLabel(listaCompras.get(i).getNombreProducto());
            labelCasilla.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
            labelCasilla.setPreferredSize(new Dimension(100, 30));
            labelCasilla.setHorizontalAlignment(JLabel.CENTER);
            labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));

            g.fill = GridBagConstraints.HORIZONTAL;
            g.anchor = GridBagConstraints.LINE_START;
            g.gridx = 1;
            g.gridy = i + 1;
            g.ipady = 3;
            panelTabla.add(labelCasilla, g);
            limpiarConstraints(g);
            //////

            labelCasilla = new JLabel(listaCompras.get(i).getPrecio() + "€");
            labelCasilla.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
            labelCasilla.setPreferredSize(new Dimension(60, 30));
            labelCasilla.setHorizontalAlignment(JLabel.CENTER);
            labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));

            g.fill = GridBagConstraints.HORIZONTAL;
            g.anchor = GridBagConstraints.LINE_START;
            g.gridx = 2;
            g.gridy = i + 1;
            g.ipady = 3;
            panelTabla.add(labelCasilla, g);
            limpiarConstraints(g);
            //////

            labelCasilla = new JLabel(listaCompras.get(i).getPuntos() + "");
            labelCasilla.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
            labelCasilla.setPreferredSize(new Dimension(60, 30));
            labelCasilla.setHorizontalAlignment(JLabel.CENTER);
            labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));

            g.fill = GridBagConstraints.HORIZONTAL;
            g.anchor = GridBagConstraints.LINE_START;
            g.gridx = 3;
            g.gridy = i + 1;
            g.ipady = 3;
            panelTabla.add(labelCasilla, g);
            limpiarConstraints(g);
            //////

            labelCasilla = new JLabel(listaCompras.get(i).getFechaCompra() + "");
            labelCasilla.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
            labelCasilla.setPreferredSize(new Dimension(60, 30));
            labelCasilla.setHorizontalAlignment(JLabel.CENTER);
            labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));

            g.fill = GridBagConstraints.HORIZONTAL;
            g.anchor = GridBagConstraints.LINE_START;
            g.gridx = 4;
            g.gridy = i + 1;
            g.ipady = 3;
            panelTabla.add(labelCasilla, g);
            limpiarConstraints(g);

        }

        espacio = new JLabel();
        espacio.setBorder(new MatteBorder(0, 1, 0, 0, colorSecundario));
        g.fill = GridBagConstraints.VERTICAL;
        g.insets = new Insets(0, 13, 0, 0);
        g.gridx = 1;
        g.gridy = 2;
        g.gridheight = 10;
        this.add(espacio, g);
        limpiarConstraints(g);

        txtSaldoActual = new JLabel("Saldo actual: ");
        txtSaldoActual.setForeground(colorSecundario);
        txtSaldoActual.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(30, 10, 10, 0);
        g.gridx = 2;
        g.gridy = 2;
        this.add(txtSaldoActual, g);
        limpiarConstraints(g);

        campoSaldoActual = new JTextField(ewallet.getSaldo() + "€");
        campoSaldoActual.setPreferredSize(new Dimension(130, 35));
        campoSaldoActual.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoSaldoActual.setEditable(false);
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(0, 10, 0, 0);
        g.gridx = 2;
        g.gridy = 3;
        g.gridwidth = 2;
        this.add(campoSaldoActual, g);
        limpiarConstraints(g);

        txtPuntosActual = new JLabel("Saldo actual: ");
        txtPuntosActual.setForeground(colorSecundario);
        txtPuntosActual.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(30, 10, 10, 0);
        g.gridx = 3;
        g.gridy = 2;
        this.add(txtPuntosActual, g);
        limpiarConstraints(g);

        campoPuntosActual = new JTextField(ewallet.getPuntos() + " Pts");
        campoPuntosActual.setPreferredSize(new Dimension(130, 35));
        campoPuntosActual.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPuntosActual.setEditable(false);
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(0, 10, 0, 0);
        g.gridx = 3;
        g.gridy = 3;
        g.gridwidth = 2;
        this.add(campoPuntosActual, g);
        limpiarConstraints(g);

        labelPedirID = new JLabel("ID Compra a reembolsar: ");
        labelPedirID.setForeground(colorSecundario);
        labelPedirID.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(30, 10, 10, 0);
        g.gridx = 2;
        g.gridy = 4;
        g.gridwidth = 2;
        this.add(labelPedirID, g);
        limpiarConstraints(g);

        campoPedirID = new JTextField("");
        campoPedirID.setPreferredSize(new Dimension(130, 35));
        campoPedirID.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPedirID.setEditable(true);
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(0, 10, 0, 0);
        g.gridx = 2;
        g.gridy = 5;
        g.gridwidth = 2;
        this.add(campoPedirID, g);
        limpiarConstraints(g);

        /**
         * Boton para consultar el codigoPreoducto
         */
        botonRecargar = new JButton("REEMBOLSAR");
        botonRecargar.setPreferredSize(new Dimension(140, 38));
        botonRecargar.setBackground(colorSecundario);
        botonRecargar.setForeground(colorPrincipal);
        botonRecargar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonRecargar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonRecargar.setFocusPainted(false);
        botonRecargar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(220, 0, 0, 0);
        g.gridx = 3;
        g.gridy = 6;
        this.add(botonRecargar, g);
        botonRecargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                compraReembolso = comprasDAO.seleccionarCompra(usuario.getDNI(), Integer.parseInt(campoPedirID.getText()));

                if (compraReembolso != null) {
                    if ((ewallet.getPuntos() - compraReembolso.getPuntos()) >= 5) {
                        //Aqui empieza la transaccion puto gilipollas
                        try {
                            Connection conexionTransaccion = Conexion.getConnection();
                            ComprasDAO comprasDAOTra = new ComprasDAO(ventana, conexionTransaccion);
                            EWalletDAO ewalletDAOra = new EWalletDAO(ventana, conexionTransaccion);
                            
                            try {

                                if (conexionTransaccion.getAutoCommit()) {
                                    conexionTransaccion.setAutoCommit(false);
                                }

                                ewalletDAOra.actualizarDevolucion(compraReembolso, ewallet);//Suma el precio del objeto y resta los puntos del mismo a la ewallet
                                //Añadir 1 al stock del producto ¿?
                                comprasDAOTra.borrar(compraReembolso);//Borrar el registro de la cmpra

                                conexionTransaccion.commit();

                                PanelAlerta ventanaCommit = new PanelAlerta(ventana, true, "El reembolso se ha realizado con exito", "");
                                ventanaCommit.setVisible(true);

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

                        //Se notifica del borrado                
                        PanelAlerta ventanaComprado = new PanelAlerta(ventana, true, "Se ha borrado la comra con id \"" + compraReembolso.getID() + "\"", "");
                        ventanaComprado.setVisible(true);

                        //Recarga la pagina
                        ventana.setContentPane(new PanelAplicacion(ventana, new PanelReembolso(ventana, usuario), usuario));
                        ventana.invalidate();
                        ventana.validate();
                    } else {
                        PanelAlerta alerta = new PanelAlerta(ventana, true, "No puedes quedarte con menos de 5 puntos", "ERROR");
                        alerta.setVisible(true);
                    }
                } else {
                    PanelAlerta alerta = new PanelAlerta(ventana, true, "No se encontro la compra", "ERROR");
                    alerta.setVisible(true);
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
