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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelAlerta extends JDialog {

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelAlerta(JFrame frameAplicacion, boolean b, String msg, String modo) {
        super(frameAplicacion, b);
        this.setSize(300, 200);
        this.setResizable(false);
        this.setTitle("Error wey");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        /**
         * Si se pasa "ERROR" por parametro se cambiara el tema a rojo
         */
        if (modo.equalsIgnoreCase("ERROR")) {
            colorPrincipal = new Color(255, 205, 205);
            colorSecundario = new Color(216, 100, 100);
        }

        GridBagConstraints g = new GridBagConstraints();

        JPanel panel = new JPanel(new GridBagLayout());

        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel(msg);
        label.setForeground(colorSecundario);
        label.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        g.insets = new Insets(20, 40, 0, 40);
        panel.add(label, g);
        limpiarConstraints(g);

        JButton botonCerrar = new JButton("OK");
        botonCerrar.setPreferredSize(new Dimension(50, 30));
        botonCerrar.setBackground(colorSecundario);
        botonCerrar.setForeground(colorPrincipal);
        botonCerrar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonCerrar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonCerrar.setFocusPainted(false);
        botonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.gridx = 0;
        g.gridy = 1;
        g.insets = new Insets(20, 0, 20, 0);
        g.anchor = GridBagConstraints.CENTER;
        panel.add(botonCerrar, g);
        limpiarConstraints(g);
        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelAlerta.this.dispose();
            }
        });

        this.add(panel);

        this.pack();

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
