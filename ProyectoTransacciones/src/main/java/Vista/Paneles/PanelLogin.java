/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Datos.UsuarioDAO;
import Vista.FrameAplicacion;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelLogin extends PanelBackground {

    private UsuarioDAO usuarioDAO;
    
    private JLabel titulo;
    private JTextField campoDNI;
    private JPasswordField campoPassword;
    private JLabel txtDNI, txtPassword, espacio;
    private JButton botonConfirmar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelLogin(JFrame ventana) {
        this.setLayout(new GridBagLayout());
        //this.setBackground("./src/main/java/Imagenes/fondoInicio3.png");
        this.setBackground(Color.WHITE);
        GridBagConstraints g = new GridBagConstraints();

        titulo = new JLabel("SUPERCOMPRÍN");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(Color.WHITE);
        titulo.setForeground(colorSecundario);
        titulo.setFont(new Font(fuentePrincipal, Font.BOLD, 34));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(0, 43, 0, 43);
        g.weightx = 1;
        g.gridx = 0;
        g.ipady = 20;
        g.gridy = 0;
        g.gridwidth = 2;
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
        g.insets = new Insets(0, 43, 70, 43);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 3;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);


        txtDNI = new JLabel("DNI:");
        txtDNI.setForeground(colorSecundario);
        txtDNI.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(40, 90, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 2;
        this.add(txtDNI, g);
        limpiarConstraints(g);

        //http://javaswingcomponents.blogspot.com/2012/05/how-to-create-simple-hinttextfield-in.html
        campoDNI = new JTextField();
        campoDNI.setPreferredSize(new Dimension(315, 35));
        campoDNI.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        g.ipady = 10;
        g.gridwidth = 2;
        g.insets = new Insets(0, 90, 0, 90);
        this.add(campoDNI, g);
        limpiarConstraints(g);

        txtPassword = new JLabel("Contraseña:");
        txtPassword.setForeground(colorSecundario);
        txtPassword.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(40, 90, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 2;
        this.add(txtPassword, g);
        limpiarConstraints(g);

        //http://javaswingcomponents.blogspot.com/2012/05/how-to-create-simple-hinttextfield-in.html
        campoPassword = new JPasswordField();
        campoPassword.setPreferredSize(new Dimension(0, 35));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        g.ipady = 10;
        g.insets = new Insets(0, 90, 0, 90);
        g.gridwidth = 2;
        this.add(campoPassword, g);
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
        g.insets = new Insets(130, 43, 0, 43);
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 3;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);

        
        botonConfirmar = new JButton("ACCEDER");
        botonConfirmar.setPreferredSize(new Dimension(140, 40));
        botonConfirmar.setBackground(colorSecundario);
        botonConfirmar.setForeground(colorPrincipal);
        botonConfirmar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonConfirmar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonConfirmar.setFocusPainted(false);
        botonConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(20, 0, 0, 43);
        g.anchor = GridBagConstraints.LINE_END;
        g.gridx = 0;
        g.gridy = 7;
        g.ipadx = 50;
        g.ipady = 20;
        this.add(botonConfirmar, g);
        limpiarConstraints(g);

        botonConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usuarioDAO = new UsuarioDAO(ventana);
                
                if(usuarioDAO.login(campoDNI.getText(), campoPassword.getText()).size() != 1){
                    PanelAlerta panelError = new PanelAlerta(ventana, true, "Datos incorrectos", "ERROR");
                    panelError.setVisible(true);
                    campoPassword.setText("");
                    campoDNI.requestFocus();
                }else{
                    FrameAplicacion frameAplicacion = new FrameAplicacion();
                    frameAplicacion.setVisible(true);
                    ventana.dispose();
                }
                //ventana.dispose();
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

}
