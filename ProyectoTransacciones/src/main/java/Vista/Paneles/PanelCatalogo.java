/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
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

    private JPanel panelMain;

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

        campoSaldo = new JTextField("121,3€");
        campoSaldo.setPreferredSize(new Dimension(75, 35));
        campoSaldo.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoSaldo.setEditable(false);
        panelSaldo.add(campoSaldo);

        labelPuntos = new JLabel("Puntos:");
        labelPuntos.setForeground(colorSecundario);
        labelPuntos.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        panelSaldo.add(labelPuntos);

        campoPuntos = new JTextField("12.928");
        campoPuntos.setPreferredSize(new Dimension(75, 35));
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

        labelNombreCesta = new JLabel("Naranjas 4Kg  |  2,45€");
        labelNombreCesta.setForeground(colorSecundario);
        labelNombreCesta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        panelCesta.add(labelNombreCesta);
        
//        imgProductoCesta = new ImageIcon("./src/main/java/Imagenes/Productos/1.jpg");
//        labelProductoCesta = new JLabel();
//        Image imgEscalada = imgProductoCesta.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
//        Icon iconoEscalado = new ImageIcon(imgEscalada);
//        labelProductoCesta.setIcon(iconoEscalado);
//        labelProductoCesta.setHorizontalAlignment(JLabel.RIGHT);
//        labelProductoCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
//        panelCesta.add(labelProductoCesta);

        botonCesta = new JButton("COMPRAR");
        botonCesta.setPreferredSize(new Dimension(140, 38));
        botonCesta.setBackground(colorSecundario);
        botonCesta.setForeground(colorPrincipal);
        botonCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonCesta.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonCesta.setFocusPainted(false);
        panelCesta.add(botonCesta);
        
        panelFooter.add(panelCesta, g);

        limpiarConstraints(g);

//        imgProductoCesta = new ImageIcon("./src/main/java/Imagenes/Productos/1.jpg");
//        labelProductoCesta = new JLabel();
//        Image imgEscalada = imgProductoCesta.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
//        Icon iconoEscalado = new ImageIcon(imgEscalada);
//        labelProductoCesta.setIcon(iconoEscalado);
//        labelProductoCesta.setHorizontalAlignment(JLabel.RIGHT);
//        labelProductoCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
//        labelProductoCesta.setToolTipText("Home");
//        g.anchor = GridBagConstraints.LINE_END;
//        g.gridx = 0;
//        g.gridy = 1;
//        g.weightx = 0.8;
//        panelFooter.add(labelProductoCesta, g);
//        limpiarConstraints(g);
//
//        labelNombreCesta = new JLabel("Naranjas 4Kgaaaaaaaaaaaaaaaa");
//        labelNombreCesta.setForeground(colorSecundario);
//        labelNombreCesta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
//        labelNombreCesta.setPreferredSize(new Dimension(100, 40));
//        g.anchor = GridBagConstraints.LINE_END;
//        g.gridx = 1;
//        g.gridy = 1;
//        g.weightx = 0.1;
//        panelFooter.add(labelNombreCesta, g);
//        limpiarConstraints(g);
//
//        botonCesta = new JButton("CONSULTAR");
//        botonCesta.setPreferredSize(new Dimension(140, 38));
//        botonCesta.setBackground(colorSecundario);
//        botonCesta.setForeground(colorPrincipal);
//        botonCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
//        botonCesta.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
//        botonCesta.setFocusPainted(false);
//        g.anchor = GridBagConstraints.LINE_START;
//        g.gridx = 2;
//        g.gridy = 1;
//        g.insets = new Insets(0, 10, 0, 4);
//        g.weightx = 0.1;
//        panelFooter.add(botonCesta, g);
//        limpiarConstraints(g);
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
