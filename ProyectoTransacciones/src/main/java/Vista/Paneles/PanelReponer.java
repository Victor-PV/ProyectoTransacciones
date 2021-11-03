/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelReponer extends JPanel {

    /**
     * Variables de la clase
     */
    private ImageIcon img;
    private JLabel imgUser, titulo;
    private JLabel txtCodProducto, txtNombreProducto, txtPrecioUd, txtCantidadDisponible;
    private JTextField campoCodProducto, campoNombreProducto, campoPrecioUd, campoCantidadDisponible;
    private JButton botonConsulta;

    private JLabel espacio;

    private JLabel txtCantidadDepos, txtPrecioDepos, txtResultado;
    private JComboBox cantidadDepos;
    private String[] listaDepos;
    private JTextField campoPrecioDepos;
    private JButton botonPedir;

    private JLabel txtPuntosActuales, txtPuntosNuevos;
    private JTextField campoPuntosActuales, camposPuntosNuevos;
    private JButton botonActualizar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelReponer() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel("Reponer productos:");
        titulo.setForeground(colorSecundario);
        titulo.setFont(new Font(fuenteSecundaria, Font.BOLD, 26));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 3;
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
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 3;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);
        
        /**
         * Texto para el campo Campo producto
         */
        txtCodProducto = new JLabel("Codigo producto: ");
        txtCodProducto.setForeground(colorSecundario);
        txtCodProducto.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 2;
        g.weightx = 0.66;
        this.add(txtCodProducto, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Producto
         */
        campoCodProducto = new JTextField("");
        campoCodProducto.setPreferredSize(new Dimension(520, 35));
        campoCodProducto.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 2;
        g.weightx = 0.66;
        this.add(campoCodProducto, g);
        limpiarConstraints(g);

        /**
         * Boton para consultar el codigoPreoducto
         */
        botonConsulta = new JButton("CONSULTAR");
        botonConsulta.setPreferredSize(new Dimension(140, 38));
        botonConsulta.setBackground(colorSecundario);
        botonConsulta.setForeground(colorPrincipal);
        botonConsulta.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonConsulta.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonConsulta.setFocusPainted(false);
        botonConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 3;
        g.weightx = 0.33;
        this.add(botonConsulta, g);

        /**
         * Texto para el campo Nombre del producto
         */
        txtNombreProducto = new JLabel("Nombre: ");
        txtNombreProducto.setForeground(colorSecundario);
        txtNombreProducto.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 4;
        g.weightx = 0.33;
        this.add(txtNombreProducto, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo Nombre del producto No sera editable
         */
        campoNombreProducto = new JTextField("");
        campoNombreProducto.setPreferredSize(new Dimension(210, 35));
        campoNombreProducto.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoNombreProducto.setEditable(false);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 5;
        g.weightx = 0.33;
        this.add(campoNombreProducto, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo DNI
         */
        txtPrecioUd = new JLabel("Precio Ud: ");
        txtPrecioUd.setForeground(colorSecundario);
        txtPrecioUd.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 4;
        g.weightx = 0.33;
        this.add(txtPrecioUd, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo DNI No sera editable
         */
        campoPrecioUd = new JTextField("");
        campoPrecioUd.setPreferredSize(new Dimension(210, 35));
        campoPrecioUd.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPrecioUd.setEditable(false);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 5;
        g.weightx = 0.33;
        this.add(campoPrecioUd, g);
        limpiarConstraints(g);

        /**
         * Texto para la cantidad disponible
         */
        txtCantidadDisponible = new JLabel("En stock: ");
        txtCantidadDisponible.setForeground(colorSecundario);
        txtCantidadDisponible.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 4;
        g.weightx = 0.33;
        this.add(txtCantidadDisponible, g);
        limpiarConstraints(g);
        /**
         * Campo de texto la cantidad disponible
         */
        campoCantidadDisponible = new JTextField("");
        campoCantidadDisponible.setPreferredSize(new Dimension(140, 35));
        campoCantidadDisponible.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoCantidadDisponible.setEditable(false);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 5;
        g.weightx = 0.33;
        this.add(campoCantidadDisponible, g);
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
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 3;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo cantidad a depositar
         */
        txtCantidadDepos = new JLabel("Cantidad: ");
        txtCantidadDepos.setForeground(colorSecundario);
        txtCantidadDepos.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 7;
        g.weightx = 0.33;
        this.add(txtCantidadDepos, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo cantidad a depositar
         */
        listaDepos = new String[50];
        for (int i = 0; i < listaDepos.length; i++) {
            listaDepos[i] = (i + 1) + "";
        }
        cantidadDepos = new JComboBox(listaDepos);
        cantidadDepos.setPreferredSize(new Dimension(210, 35));
        cantidadDepos.setBackground(Color.WHITE);
        cantidadDepos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        cantidadDepos.setEnabled(true);
        cantidadDepos.setBorder(new EmptyBorder(0, 0, 0, 0));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 8;
        g.weightx = 0.33;
        this.add(cantidadDepos, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo precio total
         */
        txtPrecioDepos = new JLabel("Precio total: ");
        txtPrecioDepos.setForeground(colorSecundario);
        txtPrecioDepos.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 7;
        g.weightx = 0.33;
        this.add(txtPrecioDepos, g);
        limpiarConstraints(g);
        /**
         * Campo de texto donde se mostrara el precio de la cantidad seleccionada
         */
        campoPrecioDepos = new JTextField("");
        campoPrecioDepos.setPreferredSize(new Dimension(210, 35));
        campoPrecioDepos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPrecioDepos.setEditable(false);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 8;
        g.weightx = 0.33;
        this.add(campoPrecioDepos, g);
        limpiarConstraints(g);

        /**
         * Boton para consultar el codigoPreoducto
         */
        botonPedir = new JButton("PEDIR");
        botonPedir.setPreferredSize(new Dimension(140, 38));
        botonPedir.setBackground(colorSecundario);
        botonPedir.setForeground(colorPrincipal);
        botonPedir.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonPedir.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonPedir.setFocusPainted(false);
        botonPedir.setEnabled(true);
        botonPedir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 8;
        g.weightx = 0.33;
        this.add(botonPedir, g);
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
        g.gridx = 0;
        g.gridy = 9;
        g.gridwidth = 3;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo cantidad a depositar
         */
        txtPuntosActuales = new JLabel("Puntos actuales: ");
        txtPuntosActuales.setForeground(colorSecundario);
        txtPuntosActuales.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 10;
        g.weightx = 0.33;
        this.add(txtPuntosActuales, g);
        limpiarConstraints(g);
        /**
         * Campo de texto para el campo cantidad a depositar
         */
        campoPuntosActuales = new JTextField("");
        campoPuntosActuales.setPreferredSize(new Dimension(210, 35));
        campoPuntosActuales.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPuntosActuales.setEditable(false);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 11;
        g.weightx = 0.33;
        this.add(campoPuntosActuales, g);
        limpiarConstraints(g);

        /**
         * Texto para el campo precio total
         */
        txtPuntosNuevos = new JLabel("Nuevos puntos: ");
        txtPuntosNuevos.setForeground(colorSecundario);
        txtPuntosNuevos.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 10;
        g.weightx = 0.33;
        this.add(txtPuntosNuevos, g);
        limpiarConstraints(g);
        /**
         * Campo de texto donde se mostrara el precio de la cantidad seleccionada
         */
        camposPuntosNuevos = new JTextField("");
        camposPuntosNuevos.setPreferredSize(new Dimension(210, 35));
        camposPuntosNuevos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        camposPuntosNuevos.setEditable(false);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 11;
        g.weightx = 0.33;
        this.add(camposPuntosNuevos, g);
        limpiarConstraints(g);

        /**
         * Boton para consultar el codigoPreoducto
         */
        botonActualizar = new JButton("ACTUALIZAR");
        botonActualizar.setPreferredSize(new Dimension(140, 38));
        botonActualizar.setBackground(colorSecundario);
        botonActualizar.setForeground(colorPrincipal);
        botonActualizar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonActualizar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonActualizar.setFocusPainted(false);
        botonActualizar.setEnabled(true);
        botonActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 11;
        g.weightx = 0.33;
        this.add(botonActualizar, g);
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
