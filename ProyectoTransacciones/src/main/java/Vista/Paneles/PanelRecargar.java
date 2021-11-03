/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import java.awt.Color;
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
public class PanelRecargar extends JPanel {

    /**
     * Variables de la clase
     */
    private ImageIcon img;
    private JLabel imgUser, titulo;
    private JLabel txtSaldoActual, txtPuntosActual;
    private JTextField campoSaldoActual, campoPuntosActual;
    private JButton botonConsulta;

    private JLabel espacio;

    private JPanel panelFecha;
    
    private JLabel labelNumeroTarjeta, labelTitularTarjeta, labelCodigoTarjeta;
    private JTextField campoNumeroTarjeta, campoTitularTarjeta, campoCodigoTarjet;

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
        g.insets = new Insets(30, 90, 30, 50);
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
        g.insets = new Insets(0, 90, 0, 100);
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
        g.insets = new Insets(0, 90, 15, 0);
        g.gridx = 0;
        g.gridy = 2;
        g.weightx = 0.2;
        this.add(txtSaldoActual, g);
        limpiarConstraints(g);
        /**
         * Campo de texto la cantidad disponible
         */
        campoSaldoActual = new JTextField("");
        campoSaldoActual.setPreferredSize(new Dimension(140, 35));
        campoSaldoActual.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoSaldoActual.setEditable(false);
        g.insets = new Insets(0, 90, 40, 30);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 3;
        g.weightx = 0.2;
        this.add(campoSaldoActual, g);
        limpiarConstraints(g);
        
                    /**
         * Texto para la cantidad disponible
         */
        txtPuntosActual = new JLabel("Puntos actuales: ");
        txtPuntosActual.setForeground(colorSecundario);
        txtPuntosActual.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(50, 90, 15, 0);
        g.gridx = 0;
        g.gridy = 4;
        g.weightx = 0.2;
        this.add(txtPuntosActual, g);
        limpiarConstraints(g);
        /**
         * Campo de texto la cantidad disponible
         */
        campoPuntosActual = new JTextField("");
        campoPuntosActual.setPreferredSize(new Dimension(140, 35));
        campoPuntosActual.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPuntosActual.setEditable(false);
        g.insets = new Insets(0, 90, 40, 30);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 5;
        g.weightx = 0.2;
        this.add(campoPuntosActual, g);
        limpiarConstraints(g);
        
        espacio = new JLabel();
        espacio.setBorder(new MatteBorder(0, 1, 0, 0, colorSecundario));
        g.fill = GridBagConstraints.VERTICAL;
        g.gridx = 1;
        g.gridy = 2;
        g.gridheight = 10;
        this.add(espacio, g);

        labelNumeroTarjeta = new JLabel("Numero tarjeta: ");
        labelNumeroTarjeta.setForeground(colorSecundario);
        labelNumeroTarjeta.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 2;
        this.add(labelNumeroTarjeta, g);
        limpiarConstraints(g);
        
        campoNumeroTarjeta = new JTextField("sasas");
        campoNumeroTarjeta.setPreferredSize(new Dimension(140, 35));
        campoNumeroTarjeta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoNumeroTarjeta.setEditable(false);
        g.gridx = 2;
        g.gridy = 3;
        this.add(campoNumeroTarjeta, g);
        limpiarConstraints(g);

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
