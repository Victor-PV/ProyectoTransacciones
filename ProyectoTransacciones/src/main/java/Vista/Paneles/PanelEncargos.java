/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import java.awt.BorderLayout;
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
public class PanelEncargos extends JPanel {

    /**
     * Variables de la clase
     */
    private ImageIcon img;
    private JLabel imgUser;

    private JLabel txtDNI, txtCasilla, txtCodUsuario, txtProducto, txtCantidad, txtFecha;
    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelEncargos() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        /**
         * Texto para el campo DNI
         */
        txtDNI = new JLabel("Historial de pedidos (Nombre provisional): ");
        txtDNI.setForeground(colorSecundario);
        txtDNI.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        txtDNI.setHorizontalAlignment(JLabel.CENTER);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(-25, 100, 50, 100);
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 4;
        this.add(txtDNI, g);
        limpiarConstraints(g);

        txtCodUsuario = new JLabel("Codigo Admin");
        txtCodUsuario.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        txtCodUsuario.setHorizontalAlignment(JLabel.CENTER);
        txtCodUsuario.setBorder(new MatteBorder(0, 0, 1, 1, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(0, 100, 0, 0);
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 1;
        g.ipady = 20;
        g.weightx = 0.25;
        this.add(txtCodUsuario, g);
        limpiarConstraints(g);

        txtFecha = new JLabel("Fecha");
        txtFecha.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        txtFecha.setHorizontalAlignment(JLabel.CENTER);
        txtFecha.setBorder(new MatteBorder(0, 0, 1, 1, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 1;
        g.gridy = 1;
        g.ipady = 20;
        g.weightx = 0.25;
        this.add(txtFecha, g);
        limpiarConstraints(g);

        txtProducto = new JLabel("Codigo Producto");
        txtProducto.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        txtProducto.setHorizontalAlignment(JLabel.CENTER);
        txtProducto.setBorder(new MatteBorder(0, 0, 1, 1, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 2;
        g.gridy = 1;
        g.ipady = 20;
        g.weightx = 0.25;
        this.add(txtProducto, g);
        limpiarConstraints(g);

        txtCantidad = new JLabel("Cantidad");
        txtCantidad.setFont(new Font(fuenteSecundaria, Font.BOLD, 14));
        txtCantidad.setHorizontalAlignment(JLabel.CENTER);
        txtCantidad.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 0, 0, 100);
        g.gridx = 3;
        g.gridy = 1;
        g.ipady = 20;
        g.weightx = 0.25;
        this.add(txtCantidad, g);
        limpiarConstraints(g);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                txtCasilla = new JLabel("Texto ejemplo");

                txtCasilla.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
                txtCasilla.setHorizontalAlignment(JLabel.CENTER);
                if (i == 0) {
                    txtCasilla.setBorder(new MatteBorder(0, 0, 0, 1, colorSecundario));
                    g.insets = new Insets(0, 100, 0, 0);
                } else if (i == 3) {
                    txtCasilla.setBorder(new MatteBorder(0, 0, 0, 0, colorSecundario));
                    g.insets = new Insets(0, 0, 0, 100);
                } else {
                    txtCasilla.setBorder(new MatteBorder(0, 0, 0, 1, colorSecundario));
                }

                g.fill = GridBagConstraints.HORIZONTAL;
                g.anchor = GridBagConstraints.LINE_START;
                g.gridx = i;
                g.gridy = (j + 2);
                g.ipady = 15;
                g.weightx = 0.25;
                this.add(txtCasilla, g);
                limpiarConstraints(g);
            }
        }

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
