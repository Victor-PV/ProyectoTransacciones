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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
public class PanelUsuario extends JPanel {

    /**
     * Variables de la clase
     */
    private ImageIcon img;
    private JLabel imgUser;

    private JLabel txtDNI, txtNombre, txtApellidos, txtSaldo, txtPuntos, txtPosicion;
    private JTextField campoDNI, campoNombre, campoApellidos, campoSaldo, campoPuntos, campoPosicion;
    
    private JPanel panelBotones;
    private JButton botonActualizar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelUsuario() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
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
         * Campo de texto para el campo DNI
         * No sera editable
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
        campoNombre = new JTextField("Victor");
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
         * Campo de texto para el campo Saldo
         * No sera editable
         */
        campoSaldo = new JTextField("124.43€");
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
        txtApellidos = new JLabel("Nombre: ");
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
        campoApellidos = new JTextField("Perez Villanueva");
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
         * Campo de texto para el campo Puntos
         * No sera editable
         */
        campoPuntos = new JTextField("2300");
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
         * Texto para el campo Posicion
         */
        txtPosicion = new JLabel("Posición: ");
        txtPosicion.setForeground(colorSecundario);
        txtPosicion.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 0, 15, 0);
        g.gridx = 2;
        g.gridy = 4;
        g.weightx = 0.55;
        this.add(txtPosicion, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Posicion
         * No sera editable
         */
        campoPosicion = new JTextField("Administrador");
        campoPosicion.setPreferredSize(new Dimension(150, 35));
        campoPosicion.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPosicion.setEditable(false);
        g.insets = new Insets(0, 0, 40, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 5;
        g.weightx = 0.55;
        this.add(campoPosicion, g);
        limpiarConstraints(g);
        
        /**
         * Panel donde se colocaran los botones
         */
        panelBotones = new JPanel(new BorderLayout());
        panelBotones.setOpaque(false);
        //panelBotones.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(150, 100, 0, 90);
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 3;
        this.add(panelBotones, g);
        limpiarConstraints(g);
        
        /**
         * Boton para actualizar los cambios
         */
        botonActualizar = new JButton("ACTUALIZAR");
        botonActualizar.setPreferredSize(new Dimension(140, 40));
        botonActualizar.setBackground(colorSecundario);
        botonActualizar.setForeground(colorPrincipal);
        botonActualizar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonActualizar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonActualizar.setFocusPainted(false);
        panelBotones.add(botonActualizar, BorderLayout.EAST);
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
