/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Paneles.PanelBackground;
import Vista.Paneles.PanelLogin;
import Vista.Paneles.PanelRegistro;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class FrameInicio extends JFrame {

    /**
     * Variables de la clase
     */
    private PanelBackground panel;
    private JLabel titulo;
    private JButton botonLogin, botonRegister;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public FrameInicio() {
        this.setSize(400, 600);
        this.setTitle("Inicio");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setIconImage(new ImageIcon("./src/main/java/Imagenes/logo.png").getImage());

        panel = new PanelBackground();
        panel.setLayout(new GridBagLayout());

        panel.setBackground("./src/main/java/Imagenes/fondoInicio2.png");
        panel.setBackground(colorPrincipal);

        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel("SUPERCOMPRÍN");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(Color.WHITE);
        titulo.setForeground(colorSecundario);
        titulo.setFont(new Font(fuentePrincipal, Font.BOLD, 40));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 1;
        g.gridx = 0;
        g.gridy = 0;
        g.ipady = 20;
        g.gridwidth = 2;
        panel.add(titulo, g);
        limpiarConstraints(g);

        botonLogin = new JButton("INICIAR SESIÓN");
        botonLogin.setPreferredSize(new Dimension(140, 40));
        botonLogin.setBackground(colorSecundario);
        botonLogin.setForeground(colorPrincipal);
        botonLogin.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonLogin.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonLogin.setFocusPainted(false);
        g.insets = new Insets(250, 20, 0, 0);
        g.gridx = 0;
        g.gridy = 1;
        panel.add(botonLogin, g);
        limpiarConstraints(g);
        /**
         * Añadir funcionalidad al botonLogin
         * Al pulsar el boton cambia al panel donde esta el inicio de sesión "PanelLogin"
         */
        botonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameInicio.this.setTitle("Iniciar Sesión");
                FrameInicio.this.setContentPane(new PanelLogin());
                FrameInicio.this.invalidate();
                FrameInicio.this.validate();
            }
        });

        botonRegister = new JButton("REGISTRATE");
        botonRegister.setPreferredSize(new Dimension(140, 40));
        botonRegister.setBackground(colorSecundario);
        botonRegister.setForeground(colorPrincipal);
        botonRegister.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonRegister.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonRegister.setFocusPainted(false);
        g.insets = new Insets(250, 0, 0, 20);
        g.gridx = 1;
        g.gridy = 1;
        panel.add(botonRegister, g);
        limpiarConstraints(g);
        /**
         * Añadir funcionalidad al botonLogin
         * Al pulsar el boton cambia al panel donde esta el inicio de sesión "PanelLogin"
         */
        botonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameInicio.this.setTitle("Iniciar Sesión");
                FrameInicio.this.setContentPane(new PanelRegistro());
                FrameInicio.this.invalidate();
                FrameInicio.this.validate();
            }
        });

        this.add(panel);
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
