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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelLogin2 extends PanelBackground {

    private JLabel titulo;
    private JTextField campoDNI;
    private JPasswordField campoPassword;
    private JLabel txtDNI, txtPassword;
    private JButton botonConfirmar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelLogin2(JFrame ventana) {
        this.setLayout(new GridBagLayout());
        this.setBackground("./src/main/java/Imagenes/fondoInicio3.png");
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel("SUPERCOMPRÍN");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(Color.WHITE);
        titulo.setForeground(colorSecundario);
        titulo.setFont(new Font(fuentePrincipal, Font.BOLD, 40));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(0, 0, 30, 0);
        g.weightx = 1;
        g.gridx = 0;
        g.ipady = 20;
        g.gridy = 0;
        g.gridwidth = 2;
        this.add(titulo, g);
        limpiarConstraints(g);

        txtDNI = new JLabel("Introduce tu DNI:");
        txtDNI.setForeground(new Color(7, 65, 35));
        txtDNI.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(40, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 2;
        this.add(txtDNI, g);
        limpiarConstraints(g);

        //http://javaswingcomponents.blogspot.com/2012/05/how-to-create-simple-hinttextfield-in.html
        campoDNI = new JTextField();
        campoDNI.setPreferredSize(new Dimension(300, 35));
        campoDNI.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        campoDNI.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        campoDNI.setOpaque(false);
        campoDNI.setBorder(new MatteBorder(0, 0, 2, 0, colorSecundario));
        campoDNI.addFocusListener(new focusListener());
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 2;
        this.add(campoDNI, g);
        limpiarConstraints(g);

        txtPassword = new JLabel("Introduce tu Contraseña:");
        txtPassword.setForeground(new Color(7, 65, 35));
        txtPassword.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(40, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 2;
        this.add(txtPassword, g);
        limpiarConstraints(g);

        //http://javaswingcomponents.blogspot.com/2012/05/how-to-create-simple-hinttextfield-in.html
        campoPassword = new JPasswordField();
        campoPassword.setPreferredSize(new Dimension(300, 35));
        campoPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        campoPassword.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        campoPassword.setOpaque(false);
        campoPassword.setBorder(new MatteBorder(0, 0, 2, 0, colorSecundario));
        campoPassword.addFocusListener(new focusListener());
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 2;
        this.add(campoPassword, g);
        limpiarConstraints(g);

        botonConfirmar = new JButton("ACCEDER");
        botonConfirmar.setPreferredSize(new Dimension(140, 40));
        botonConfirmar.setBackground(colorSecundario);
        botonConfirmar.setForeground(colorPrincipal);
        botonConfirmar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonConfirmar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonConfirmar.setFocusPainted(false);
        g.insets = new Insets(80, 0, 0, 43);
        g.anchor = GridBagConstraints.LINE_END;
        g.gridx = 1;
        g.gridy = 5;
        this.add(botonConfirmar, g);
        limpiarConstraints(g);

        botonConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
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

    class focusListener extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            ((JTextField) e.getSource()).setBorder(new MatteBorder(0, 0, 2, 0, colorPrincipal));
        }

        @Override
        public void focusLost(FocusEvent e) {
            ((JTextField) e.getSource()).setBorder(new MatteBorder(0, 0, 2, 0, colorSecundario));
        }
    }
}
