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
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelRecargar extends JPanel {

    /**
     * Variables de la clase
     */
    private ImageIcon img;
    private JLabel imgUser, titulo;
    private JLabel txtSaldoActual, txtPuntosActual;
    private JTextField campoSaldoActual, campoPuntosActual;
    private JButton botonRecargar;
    
    private JLabel espacio;
    
    private JPanel panelFecha;
    
    private JLabel labelNumeroTarjeta, labelTitularTarjetaNombre, labelTitularTarjetaApellidos, labelCodigoTarjeta, labelFechaTarjeta;
    private JTextField campoNumeroTarjeta, campoTitularTarjetaNombre, campoTitularTarjetaApellidos, campoCodigoTarjet;
    
    private JComboBox listaDias, listaMeses, listaAños;
    private String[] dias = new String[32], meses = new String[13], años = new String[201];
    
    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);
    
    public PanelRecargar() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        
        titulo = new JLabel("Recargar E-Wallet:");
        titulo.setForeground(colorSecundario);
        titulo.setFont(new Font(fuenteSecundaria, Font.BOLD, 26));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 30;
        g.insets = new Insets(-90, 90, 30, 50);
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
        g.insets = new Insets(0, 90, 0, 90);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 30;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);

        /**
         * Texto para la cantidad disponible
         */
        txtSaldoActual = new JLabel("Saldo actual: ");
        txtSaldoActual.setForeground(colorSecundario);
        txtSaldoActual.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(30, 90, 10, 0);
        g.gridx = 0;
        g.gridy = 2;
        //g.weightx = 0.2;
        this.add(txtSaldoActual, g);
        limpiarConstraints(g);
        /**
         * Campo de texto la cantidad disponible
         */
        campoSaldoActual = new JTextField("");
        campoSaldoActual.setPreferredSize(new Dimension(140, 35));
        campoSaldoActual.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoSaldoActual.setEditable(false);
        g.insets = new Insets(0, 90, 0, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 3;
        //g.weightx = 0.2;
        this.add(campoSaldoActual, g);
        limpiarConstraints(g);

        /**
         * Texto para la cantidad disponible
         */
        txtPuntosActual = new JLabel("Puntos actuales: ");
        txtPuntosActual.setForeground(colorSecundario);
        txtPuntosActual.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(40, 90, 10, 0);
        g.gridx = 0;
        g.gridy = 4;
        //g.weightx = 0.2;
        this.add(txtPuntosActual, g);
        limpiarConstraints(g);
        /**
         * Campo de texto la cantidad disponible
         */
        campoPuntosActual = new JTextField("");
        campoPuntosActual.setPreferredSize(new Dimension(140, 35));
        campoPuntosActual.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPuntosActual.setEditable(false);
        g.insets = new Insets(0, 90, 0, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 5;
        //g.weightx = 0.2;
        this.add(campoPuntosActual, g);
        limpiarConstraints(g);
        
        espacio = new JLabel();
        espacio.setBorder(new MatteBorder(0, 1, 0, 0, colorSecundario));
        g.fill = GridBagConstraints.VERTICAL;
        g.gridx = 1;
        g.gridy = 2;
        g.gridheight = 10;
        this.add(espacio, g);
        limpiarConstraints(g);
        
        labelNumeroTarjeta = new JLabel("Numero tarjeta: ");
        labelNumeroTarjeta.setForeground(colorSecundario);
        labelNumeroTarjeta.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(30, 0, 0, 0);
        g.gridx = 2;
        g.gridy = 2;
        g.gridwidth = 2;
        this.add(labelNumeroTarjeta, g);
        limpiarConstraints(g);
        
        campoNumeroTarjeta = new JTextField("sasas");
        campoNumeroTarjeta.setPreferredSize(new Dimension(400, 35));
        campoNumeroTarjeta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoNumeroTarjeta.setEditable(true);
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(0, 0, 0, 0);
        g.gridx = 2;
        g.gridy = 3;
        g.gridwidth = 2;
        this.add(campoNumeroTarjeta, g);
        limpiarConstraints(g);
        
        labelTitularTarjetaNombre = new JLabel("Nombre: ");
        labelTitularTarjetaNombre.setForeground(colorSecundario);
        labelTitularTarjetaNombre.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(40, 0, 10, 0);
        g.gridx = 2;
        g.gridy = 4;
        g.gridwidth = 1;
        this.add(labelTitularTarjetaNombre, g);
        limpiarConstraints(g);
        
        campoTitularTarjetaNombre = new JTextField("sasas");
        campoTitularTarjetaNombre.setPreferredSize(new Dimension(130, 35));
        campoTitularTarjetaNombre.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoTitularTarjetaNombre.setEditable(true);
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(0, 0, 0, 10);
        g.gridx = 2;
        g.gridy = 5;
        this.add(campoTitularTarjetaNombre, g);
        limpiarConstraints(g);
        
        labelTitularTarjetaApellidos = new JLabel("Apellidos del titular: ");
        labelTitularTarjetaApellidos.setForeground(colorSecundario);
        labelTitularTarjetaApellidos.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(40, -50, 10, 0);
        g.gridx = 3;
        g.gridy = 4;
        g.gridwidth = 1;
        this.add(labelTitularTarjetaApellidos, g);
        limpiarConstraints(g);
        
        campoTitularTarjetaApellidos = new JTextField("sasas");
        campoTitularTarjetaApellidos.setPreferredSize(new Dimension(225, 35));
        campoTitularTarjetaApellidos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoTitularTarjetaApellidos.setEditable(true);
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(0, -50, 0, 10);
        g.gridx = 3;
        g.gridy = 5;
        this.add(campoTitularTarjetaApellidos, g);
        limpiarConstraints(g);
        
        labelCodigoTarjeta = new JLabel("Codigo: ");
        labelCodigoTarjeta.setForeground(colorSecundario);
        labelCodigoTarjeta.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(40, 0, 10, 0);
        g.gridx = 2;
        g.gridy = 6;
        g.gridwidth = 1;
        this.add(labelCodigoTarjeta, g);
        limpiarConstraints(g);
        
        campoCodigoTarjet = new JTextField("sasas");
        campoCodigoTarjet.setPreferredSize(new Dimension(100, 35));
        campoCodigoTarjet.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoCodigoTarjet.setEditable(true);
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.insets = new Insets(0, 0, 0, 10);
        g.gridx = 2;
        g.gridy = 7;
        this.add(campoCodigoTarjet, g);
        limpiarConstraints(g);
        
        labelFechaTarjeta = new JLabel("Fecha valida: ");
        labelFechaTarjeta.setForeground(colorSecundario);
        labelFechaTarjeta.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(40, -50, 10, 0);
        g.gridx = 3;
        g.gridy = 6;
        g.gridwidth = 1;
        this.add(labelFechaTarjeta, g);
        limpiarConstraints(g);
        
        panelFecha = new JPanel(new GridLayout(1, 3, 6, 5));
        panelFecha.setOpaque(false);
        //panelFecha.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(5, -50, 10, 0);
        g.gridx = 3;
        g.gridy = 7;
        this.add(panelFecha, g);
        limpiarConstraints(g);

        /**
         * Panel donde iran los 3 comboBox del nacimiento
         */
        dias[0] = "- Dia -";
        for (int i = 1; i < dias.length; i++) {
            dias[i] = "" + (i);
        }
        listaDias = new JComboBox(dias);
        listaDias.setPreferredSize(new Dimension(50, 25));
        listaDias.setBackground(Color.WHITE);
        g.anchor = GridBagConstraints.LINE_START;
        panelFecha.add(listaDias);
        limpiarConstraints(g);
        
        meses[0] = "- Mes -";
        for (int i = 1; i < meses.length; i++) {
            meses[i] = "" + (i);
        }
        listaMeses = new JComboBox(meses);
        listaMeses.setPreferredSize(new Dimension(70, 25));
        listaMeses.setBackground(Color.WHITE);
        panelFecha.add(listaMeses);
        limpiarConstraints(g);
        
        años[0] = "- Año -";
        for (int i = 1; i < años.length; i++) {
            años[i] = "" + (i + 1900);
        }
        listaAños = new JComboBox(años);
        listaAños.setBackground(Color.WHITE);
        listaAños.setPreferredSize(new Dimension(70, 25));
        panelFecha.add(listaAños);
        limpiarConstraints(g);
        
                /**
         * Boton para consultar el codigoPreoducto
         */
        botonRecargar = new JButton("RECARGAR");
        botonRecargar.setPreferredSize(new Dimension(140, 38));
        botonRecargar.setBackground(colorSecundario);
        botonRecargar.setForeground(colorPrincipal);
        botonRecargar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonRecargar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonRecargar.setFocusPainted(false);
        botonRecargar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(40, -65, 0, 0);
        g.gridx = 3;
        g.gridy = 8;
        this.add(botonRecargar, g);
        
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
