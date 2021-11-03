/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelCatalogo extends JPanel {

    /**
     * Variables de la clase
     */
    private JPanel panelHeader;
    private JLabel txtTitulo, espacio;

    private JPanel panelMain, panelProducto, panelPasarProductos;
    private ImageIcon imgProducto;
    private JLabel labelProductoImg, labelProducto, labelPrecio, labelPuntosProducto, labelPaginas;
    private JButton botonProducto, botonLeft, botonRight;

    private JPanel panelFooter, panelSaldo, panelCesta;
    private ImageIcon imgProductoCesta;
    private JLabel labelProductoCesta, labelNombreCesta, labelSaldo, labelPuntos;
    private JTextField campoSaldo, campoPuntos;
    private JButton botonCesta;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelCatalogo() {
        this.setLayout(new BorderLayout());
        GridBagConstraints g = new GridBagConstraints();

        /**
         * Panel donde se colocaran los elementos del header del panel principal
         */
        panelHeader = new JPanel(new GridBagLayout());
        panelHeader.setOpaque(false);

        txtTitulo = new JLabel("Catalogo:");
        txtTitulo.setForeground(colorSecundario);
        txtTitulo.setFont(new Font(fuenteSecundaria, Font.BOLD, 26));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 0;
        g.insets = new Insets(30, 50, 30, 50);
        panelHeader.add(txtTitulo, g);
        limpiarConstraints(g);

        espacio = new JLabel("");
        espacio.setForeground(colorSecundario);
        espacio.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        espacio.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 50, 0, 50);
        g.gridx = 0;
        g.gridy = 1;
        g.weightx = 1;
        panelHeader.add(espacio, g);
        limpiarConstraints(g);

        this.add(panelHeader, BorderLayout.NORTH);

        /**
         * Panel donde se colocaran los elementos del main del panel principal
         */
        panelMain = new JPanel(new GridBagLayout());
        panelMain.setOpaque(false);

        String[] listaProductosNombre = {"Naranjas 4Kg", "Pechuga de pavo", "Ensalada gourmet", "Jamón cocido 125g",
            "Rabo vacuno 1Kg", "Setas enteras 300g", "Pan de perrito 6Ud", "Lechuga romana"};
        String[] listaProductosPrecio = {"3.80", "4.11", "1.08", "1.99", "10.95", "2.99", "1.65", "1.39"};
        String[] listaProductosPuntos = {"120", "400", "120", "150", "400", "200", "100", "120"};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                panelProducto = new JPanel(new GridBagLayout());
                panelProducto.setOpaque(false);
                //panelProducto.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
                g.gridx = j;
                g.gridy = i;
                g.anchor = GridBagConstraints.CENTER;
                g.insets = new Insets(10, 0, 0, 0);
                if (i == 0) {
                    g.insets = new Insets(12, 0, 10, 0);
                }
                panelMain.add(panelProducto, g);
                limpiarConstraints(g);

                if (i == 0) {
                    labelPuntosProducto = new JLabel(listaProductosPuntos[j] + "Pts");
                } else {
                    labelPuntosProducto = new JLabel(listaProductosPuntos[j + 4] + "Pts");
                }
                labelPuntosProducto.setForeground(colorSecundario);
                labelPuntosProducto.setOpaque(true);
                labelPuntosProducto.setPreferredSize(new Dimension(60, 30));
                labelPuntosProducto.setHorizontalAlignment(JLabel.CENTER);
                labelPuntosProducto.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
                labelPuntosProducto.setBackground(new Color(255, 253, 176));
                labelPuntosProducto.setBorder(new MatteBorder(1, 1, 0, 0, colorSecundario));
                g.anchor = GridBagConstraints.LINE_END;
                g.gridx = 1;
                g.gridy = 3;
                g.gridwidth = 1;
                g.insets = new Insets(-195, 0, 0, 0);
                panelProducto.add(labelPuntosProducto, g);
                limpiarConstraints(g);

                if (i == 0) {
                    imgProducto = new ImageIcon("./src/main/java/Imagenes/Productos/" + (j + 1) + ".jpg");
                } else {
                    imgProducto = new ImageIcon("./src/main/java/Imagenes/Productos/" + (j + 5) + ".jpg");
                }
                labelProductoImg = new JLabel();
                Image imgEscalada = imgProducto.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                Icon iconoEscalado = new ImageIcon(imgEscalada);
                labelProductoImg.setIcon(iconoEscalado);
                g.gridx = 0;
                g.gridy = 0;
                g.gridwidth = 2;
                panelProducto.add(labelProductoImg, g);
                limpiarConstraints(g);

                if (i == 0) {
                    labelProducto = new JLabel(listaProductosNombre[j]);
                } else {
                    labelProducto = new JLabel(listaProductosNombre[j + 4]);
                }
                labelProducto.setForeground(colorSecundario);
                labelProducto.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
                labelProducto.setBackground(new Color(255, 255, 255));
                labelProducto.setOpaque(true);
                labelProducto.setBorder(new MatteBorder(1, 0, 1, 0, colorSecundario));
                labelProducto.setHorizontalAlignment(JLabel.CENTER);
                labelProducto.setPreferredSize(new Dimension(140, 30));
                g.fill = GridBagConstraints.HORIZONTAL;
                g.weightx = 1;
                g.gridx = 0;
                g.gridy = 1;
                g.ipady = 15;
                g.gridwidth = 2;
                panelProducto.add(labelProducto, g);
                limpiarConstraints(g);

                if (i == 0) {
                    labelPrecio = new JLabel(listaProductosPrecio[j] + "€");
                } else {
                    labelPrecio = new JLabel(listaProductosPrecio[j + 4] + "€");
                }
                labelPrecio.setForeground(colorSecundario);
                labelPrecio.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
                labelProducto.setHorizontalAlignment(JLabel.CENTER);
                g.gridx = 0;
                g.gridy = 2;
                g.gridwidth = 1;
                panelProducto.add(labelPrecio, g);
                limpiarConstraints(g);

                botonProducto = new JButton("AÑADIR");
                botonProducto.setPreferredSize(new Dimension(60, 38));
                botonProducto.setBackground(colorSecundario);
                botonProducto.setForeground(colorPrincipal);
                botonProducto.setBorder(new MatteBorder(0, 1, 1, 1, colorPrincipal));
                botonProducto.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
                botonProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
                botonProducto.setFocusPainted(false);
                g.anchor = GridBagConstraints.LINE_END;
                g.gridx = 1;
                g.gridy = 2;
                g.gridwidth = 1;
                panelProducto.add(botonProducto, g);
                limpiarConstraints(g);

            }
        }

        panelPasarProductos = new JPanel();
        panelPasarProductos.setOpaque(false);
        g.insets = new Insets(30, 0, 0, 0);
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 4;
        panelMain.add(panelPasarProductos, g);
        limpiarConstraints(g);

        botonLeft = new JButton("<<");
        botonLeft.setPreferredSize(new Dimension(60, 22));
        botonLeft.setBackground(colorSecundario);
        botonLeft.setForeground(colorPrincipal);
        botonLeft.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonLeft.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonLeft.setEnabled(false);
        botonLeft.setFocusPainted(false);
        botonLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelPasarProductos.add(botonLeft);

        labelNombreCesta = new JLabel("01 / 32");
        labelNombreCesta.setForeground(colorSecundario);
        labelNombreCesta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        panelPasarProductos.add(labelNombreCesta);

        botonRight = new JButton(">>");
        botonRight.setPreferredSize(new Dimension(60, 22));
        botonRight.setBackground(colorSecundario);
        botonRight.setForeground(colorPrincipal);
        botonRight.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonRight.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonRight.setFocusPainted(false);
        botonRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelPasarProductos.add(botonRight);

        this.add(panelMain, BorderLayout.CENTER);

        /**
         * Panel donde se colocaran los elementos del footer del panel principal
         */
        panelFooter = new JPanel(new GridBagLayout());
        panelFooter.setOpaque(false);

        espacio = new JLabel("");
        espacio.setForeground(colorSecundario);
        espacio.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        espacio.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 50, 0, 50);
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        g.weightx = 1;
        panelFooter.add(espacio, g);
        limpiarConstraints(g);

        /**
         * Panel donde ira el saldo y los puntos
         */
        panelSaldo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //panelSaldo.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        panelSaldo.setOpaque(false);
        g.insets = new Insets(10, 50, 10, 0);
        g.gridx = 0;
        g.gridy = 1;
        g.anchor = GridBagConstraints.LINE_START;

        labelSaldo = new JLabel("Saldo:");
        labelSaldo.setForeground(colorSecundario);
        labelSaldo.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        panelSaldo.add(labelSaldo);

        campoSaldo = new JTextField("121,5€");
        campoSaldo.setPreferredSize(new Dimension(90, 35));
        campoSaldo.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoSaldo.setEditable(false);
        panelSaldo.add(campoSaldo);

        labelPuntos = new JLabel("Puntos:");
        labelPuntos.setForeground(colorSecundario);
        labelPuntos.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        panelSaldo.add(labelPuntos);

        campoPuntos = new JTextField("3.080Pts");
        campoPuntos.setPreferredSize(new Dimension(90, 35));
        campoPuntos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPuntos.setEditable(false);
        panelSaldo.add(campoPuntos);

        panelFooter.add(panelSaldo, g);

        panelCesta = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //panelCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        panelCesta.setOpaque(false);
        g.insets = new Insets(10, 0, 10, 50);
        g.gridx = 1;
        g.gridy = 1;
        g.anchor = GridBagConstraints.LINE_END;

        labelNombreCesta = new JLabel("");
        labelNombreCesta.setForeground(colorSecundario);
        labelNombreCesta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        panelCesta.add(labelNombreCesta);

        botonCesta = new JButton("COMPRAR");
        botonCesta.setPreferredSize(new Dimension(140, 38));
        botonCesta.setBackground(colorSecundario);
        botonCesta.setForeground(colorPrincipal);
        botonCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonCesta.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonCesta.setFocusPainted(false);
        botonCesta.setEnabled(false);
        botonCesta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelCesta.add(botonCesta);

        panelFooter.add(panelCesta, g);

        limpiarConstraints(g);
        this.add(panelFooter, BorderLayout.SOUTH);

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
