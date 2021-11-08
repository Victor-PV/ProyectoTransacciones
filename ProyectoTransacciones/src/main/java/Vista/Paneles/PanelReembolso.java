/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Vista.FrameAplicacion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    public PanelReembolso(JFrame ventana) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

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

        labelCasilla = new JLabel("ID compra");
        labelCasilla.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        labelCasilla.setHorizontalAlignment(JLabel.CENTER);
        labelCasilla.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        labelCasilla.setPreferredSize(new Dimension(60, 30));
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
        labelCasilla.setPreferredSize(new Dimension(100, 30));
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
        labelCasilla.setPreferredSize(new Dimension(60, 30));
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
        labelCasilla.setPreferredSize(new Dimension(60, 30));
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
        labelCasilla.setPreferredSize(new Dimension(60, 30));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 0, 0, 0);
        g.gridx = 4;
        g.gridy = 0;
        g.ipady = 20;
        panelTabla.add(labelCasilla, g);
        limpiarConstraints(g);

        for (int i = 0; i < 10; i++) {
            labelCasilla = new JLabel("000" + i);
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

            labelCasilla = new JLabel("Tomaticos 4Kg");
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

            labelCasilla = new JLabel("3.45€");
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

            labelCasilla = new JLabel("210");
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

            labelCasilla = new JLabel("04/12/21");
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

        campoSaldoActual = new JTextField("16.3€");
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

        campoPuntosActual = new JTextField("1214");
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

        campoPedirID = new JTextField("0121");
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
                PanelAlerta alerta = new PanelAlerta( ventana, true, "Error al reembolsar", "ERROR");
                alerta.setVisible(true);
                System.out.println("ALERTAS");
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
