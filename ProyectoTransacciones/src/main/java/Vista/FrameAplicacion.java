/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Paneles.PanelUsuario;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class FrameAplicacion extends JFrame {

    private JPanel panelPrincipal, panelMenu;
    
    private JPanel panelContenido, panelContenidoIn;
    
    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public FrameAplicacion() {
        this.setSize(1000, 700);
        this.setTitle("Supercomprín");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("./src/main/java/Imagenes/logo.png").getImage());

        panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        /**
         * Crear el panel donde van a ir las opciones del menu
         */
        panelMenu = new JPanel();
        panelMenu.setBackground(new Color(210, 210, 210));
        panelMenu.setBorder(new MatteBorder(0, 0, 0, 4, colorSecundario));
        g.gridx = 0;
        g.gridy = 0;
        g.weightx = 0.3;
        g.weighty = 1;
        g.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(panelMenu, g);

        /**
         * Crear el panel donde va a ir todo el contenido de la aplicación
         */
        panelContenido = new JPanel(new GridBagLayout());
        GridBagConstraints g2 = new GridBagConstraints();
        g.gridx = 1;
        g.gridy = 0;
        g.weightx = 0.7;
        g.weighty = 1;
        g.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(panelContenido, g);
        
        /**
         * Contenido del panelContenido
         */
        panelContenidoIn = new PanelUsuario();
        panelContenidoIn.setBackground(Color.WHITE);
        g2.gridx = 0;
        g2.gridy = 0;
        g2.weightx = 1;
        g2.weighty = 1;
        g2.fill = GridBagConstraints.BOTH;
        panelContenido.add(panelContenidoIn, g2);
        limpiarConstraints(g2);
        
        this.add(panelPrincipal);
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
