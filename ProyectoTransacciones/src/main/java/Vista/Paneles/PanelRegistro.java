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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelRegistro extends PanelBackground {

    private JLabel titulo;
    private JLabel txtDNI, txtNombre, txtApellido, txtPassword;
    private JTextField campoDNI, campoNombre, campoApellido, campoPassword;
    private JButton botonConfirmar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelRegistro() {
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
        //g.insets = new Insets(0, 0,30, 0);
        g.weightx = 1;
        g.gridx = 0;
        g.ipady = 20;
        g.gridy = 0;
        g.gridwidth = 2;
        this.add(titulo, g);
        limpiarConstraints(g);

        txtNombre = new JLabel("Introduce tu Nombre:");
        txtNombre.setForeground(colorPrincipal);
        txtNombre.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(20, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 2;
        this.add(txtNombre, g);
        limpiarConstraints(g);

        campoNombre = new JTextField();
        campoNombre.setPreferredSize(new Dimension(300, 35));
        campoNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        campoNombre.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        campoNombre.setOpaque(false);
        campoNombre.setBorder(new MatteBorder(0, 0, 2, 0, colorSecundario));
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 2;
        this.add(campoNombre, g);
        limpiarConstraints(g);

        txtApellido = new JLabel("Introduce tu Apellido:");
        txtApellido.setForeground(new Color(7, 65, 35));
        txtApellido.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(20, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 2;
        this.add(txtApellido, g);
        limpiarConstraints(g);

        campoApellido = new JTextField();
        campoApellido.setPreferredSize(new Dimension(300, 35));
        campoApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        campoApellido.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        campoApellido.setOpaque(false);
        campoApellido.setBorder(new MatteBorder(0, 0, 2, 0, colorSecundario));
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 2;
        this.add(campoApellido, g);
        limpiarConstraints(g);

        txtDNI = new JLabel("Introduce tu DNI:");
        txtDNI.setForeground(new Color(7, 65, 35));
        txtDNI.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(20, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
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
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 2;
        this.add(campoDNI, g);
        limpiarConstraints(g);
        
        txtPassword = new JLabel("Introduce tu Contraseña:");
        txtPassword.setForeground(new Color(7, 65, 35));
        txtPassword.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        g.insets = new Insets(20, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 2;
        this.add(txtPassword, g);
        limpiarConstraints(g);

        campoPassword = new JTextField();
        campoPassword.setPreferredSize(new Dimension(300, 35));
        campoPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        campoPassword.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        campoPassword.setOpaque(false);
        campoPassword.setBorder(new MatteBorder(0, 0, 2, 0, colorSecundario));
        g.gridx = 0;
        g.gridy = 8;
        g.gridwidth = 2;
        this.add(campoPassword, g);
        limpiarConstraints(g);

        botonConfirmar = new JButton("REGISTRATE");
        botonConfirmar.setPreferredSize(new Dimension(140, 40));
        botonConfirmar.setBackground(colorSecundario);
        botonConfirmar.setForeground(colorPrincipal);
        botonConfirmar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonConfirmar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonConfirmar.setFocusPainted(false);
        g.insets = new Insets(40, 0, 0, 43);
        g.anchor = GridBagConstraints.LINE_END;
        g.gridx = 1;
        g.gridy = 9;
        this.add(botonConfirmar, g);
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
