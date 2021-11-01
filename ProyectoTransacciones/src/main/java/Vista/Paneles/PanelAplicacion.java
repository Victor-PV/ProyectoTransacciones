/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelAplicacion extends JPanel {

    private JPanel panelPrincipal;

    private JPanel panelMenu, panelMenuIn;

    private JPanel panelContenido, panelContenidoIn;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelAplicacion(JFrame ventana, JPanel panelSustituto) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        /**
         * Crear el panel donde van a ir las opciones del menu
         */
        panelMenu = new JPanel(new GridBagLayout());
        GridBagConstraints g1 = new GridBagConstraints();
        panelMenu.setBorder(new MatteBorder(0, 0, 0, 4, colorSecundario));
        g.gridx = 0;
        g.gridy = 0;
        g.weightx = calcularTamañoMenuAside(panelSustituto);
        g.weighty = 1;
        g.fill = GridBagConstraints.BOTH;
        this.add(panelMenu, g);
        /**
         * Contenido del panel Menu
         */
        panelMenuIn = new PanelMenuAside(ventana);
        panelMenu.setBackground(new Color(210, 210, 210));
        g1.gridx = 0;
        g1.gridy = 0;
        g1.weightx = 1;
        g1.weighty = 1;
        g1.fill = GridBagConstraints.BOTH;
        panelMenu.add(panelMenuIn, g1);
        limpiarConstraints(g1);

        /**
         * Crear el panel donde va a ir todo el contenido de la aplicación
         */
        panelContenido = new JPanel(new GridBagLayout());
        GridBagConstraints g2 = new GridBagConstraints();
        g.gridx = 1;
        g.gridy = 0;
        g.weightx = calcularTamañoContenido(panelSustituto);
        g.weighty = 1;
        g.fill = GridBagConstraints.BOTH;
        this.add(panelContenido, g);

        /**
         * Contenido del panelContenido
         */
        panelContenidoIn = panelSustituto;
        panelContenidoIn.setBackground(Color.WHITE);
        g2.gridx = 0;
        g2.gridy = 0;
        g2.weightx = 1;
        g2.weighty = 1;
        g2.fill = GridBagConstraints.BOTH;
        panelContenido.add(panelContenidoIn, g2);
        limpiarConstraints(g2);
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

    private float calcularTamañoMenuAside(JPanel panel) {
        float tam = 0.0f;
        
        if(panel instanceof PanelUsuario){
            tam = 0.3f;
        }else if(panel instanceof PanelHistorial){
            tam = 0.195f;
        }else if(panel instanceof PanelReponer){
            tam = 0.43f;
        }else{
            tam = 0.3f;
        }
                
        return tam;
    }

    private float calcularTamañoContenido(JPanel panel) {
        float tam = 0.0f;
        
        if(panel instanceof PanelUsuario){
            tam = 0.7f;
        }else if(panel instanceof PanelHistorial){
            tam = 0.805f;
        }else if(panel instanceof PanelReponer){
            tam = 0.57f;
        }else{
            tam = 0.7f;
        }
                
        return tam;
    }
}
