/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Vista.FrameAplicacion;
import Vista.FrameInicio;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author victo
 */
public class PanelMenuAside extends JPanel {

    private JLabel labelHome, labelSalir, labelHistorial, labelCatalogo, labelDepositar;
    private ImageIcon imgHome, imgSalir, imgHistorial, imgCatalogo, imgDepositar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelMenuAside(JFrame ventana) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        /**
         * Icono del Home
         */
        imgHome = new ImageIcon("./src/main/java/Imagenes/home.png");
        labelHome = new JLabel();
        Image imgEscalada = imgHome.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        labelHome.setIcon(iconoEscalado);
        labelHome.setHorizontalAlignment(JLabel.CENTER);
        labelHome.setToolTipText("Home");
        g.insets = new Insets(0, -20, 10, -20);
        g.gridx = 0;
        g.gridy = 0;
        this.add(labelHome, g);
        limpiarConstraints(g);
        /**
         * Añade interaccion al label Home
         */
        labelHome.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ventana.setContentPane(new PanelAplicacion(ventana, new PanelUsuario()));
                ventana.invalidate();
                ventana.validate();
            }
        });

        /**
         * Icono del Home
         */
        imgCatalogo = new ImageIcon("./src/main/java/Imagenes/catalogo.png");
        labelCatalogo = new JLabel();
        Image imgEscalada2 = imgCatalogo.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado2 = new ImageIcon(imgEscalada2);
        labelCatalogo.setIcon(iconoEscalado2);
        labelCatalogo.setHorizontalAlignment(JLabel.CENTER);
        labelCatalogo.setToolTipText("Catalogo");
        g.insets = new Insets(10, -20, 10, -20);
        g.gridx = 0;
        g.gridy = 1;
        this.add(labelCatalogo, g);
        limpiarConstraints(g);

        /**
         * Icono del Historial
         */
        imgHistorial = new ImageIcon("./src/main/java/Imagenes/historial.png");
        labelHistorial = new JLabel();
        Image imgEscalada3 = imgHistorial.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado3 = new ImageIcon(imgEscalada3);
        labelHistorial.setIcon(iconoEscalado3);
        labelHistorial.setHorizontalAlignment(JLabel.CENTER);
        labelHistorial.setToolTipText("Catalogo");
        g.insets = new Insets(10, -20, 10, -20);
        g.gridx = 0;
        g.gridy = 2;
        this.add(labelHistorial, g);
        limpiarConstraints(g);
        /**
         * Añade interaccion al label Home
         */
        labelHistorial.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ventana.setContentPane(new PanelAplicacion(ventana, new PanelHistorial()));
                ventana.invalidate();
                ventana.validate();
            }
        });

        /**
         * Icono del Historial
         */
        imgDepositar = new ImageIcon("./src/main/java/Imagenes/pedido.png");
        labelDepositar = new JLabel();
        Image imgEscalada4 = imgDepositar.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado4 = new ImageIcon(imgEscalada4);
        labelDepositar.setIcon(iconoEscalado4);
        labelDepositar.setHorizontalAlignment(JLabel.CENTER);
        labelDepositar.setToolTipText("Catalogo");
        g.insets = new Insets(10, -20, 0, -20);
        g.gridx = 0;
        g.gridy = 3;
        this.add(labelDepositar, g);
        limpiarConstraints(g);

        /**
         * Icono del Salir
         */
        imgSalir = new ImageIcon("./src/main/java/Imagenes/salir.png");
        labelSalir = new JLabel();
        Image imgEscalada5 = imgSalir.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado5 = new ImageIcon(imgEscalada5);
        labelSalir.setIcon(iconoEscalado5);
        labelSalir.setHorizontalAlignment(JLabel.CENTER);
        labelSalir.setToolTipText("Salir");
        g.insets = new Insets(360, -20, 0, -20);
        g.gridx = 0;
        g.gridy = 4;
        this.add(labelSalir, g);
        limpiarConstraints(g);

        labelSalir.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
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
}
