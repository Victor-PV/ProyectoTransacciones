/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    private JPanel panelGeneral, panelSalir;

    private JLabel labelPlantilla;
    private ImageIcon imgPlantilla;

    private JLabel labelHome, labelSalir, labelReembolso, labelCatalogo, labelDepositar, labelEncargos, labelRecargar, labelEncargar;
    private ImageIcon imgHome, imgSalir, imgReembolso, imgCatalogo, imgDepositar, imgEncargos, imgRecargar, imgEncargar;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    private String[] listaPanelesAdminCliente = {"home", "catalogo", "historial", "encargos", "recargar", "encargar"};
    private String[] listaPanelesAdmin = {"home", "catalogo", "encargos", "encargar"};
    private String[] listaPanelesCliente = {"home", "catalogo", "historial", "recargar"};

    public PanelMenuAside(JFrame ventana) {
        this.setLayout(new BorderLayout());
        panelGeneral = new JPanel(new GridBagLayout());
        this.add(panelGeneral, BorderLayout.NORTH);
        GridBagConstraints g = new GridBagConstraints();

        int posicionY = 0;

        /**
         * Icono del Home
         */
        imgHome = new ImageIcon("./src/main/java/Imagenes/home.png");
        labelHome = new JLabel();
        Image imgEscalada = imgHome.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        labelHome.setIcon(iconoEscalado);
        labelHome.setHorizontalAlignment(JLabel.CENTER);
        labelHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelHome.setToolTipText("Home");
        g.insets = new Insets(15, -20, 20, -20);
        g.gridx = 0;
        g.gridy = posicionY++;
        panelGeneral.add(labelHome, g);
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
        labelCatalogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(0, -20, 20, -20);
        g.gridx = 0;
        g.gridy = posicionY++;
        panelGeneral.add(labelCatalogo, g);
        limpiarConstraints(g);
        /**
         * Añade interaccion al label Catalogo
         */
        labelCatalogo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ventana.setContentPane(new PanelAplicacion(ventana, new PanelCatalogo()));
                ventana.invalidate();
                ventana.validate();
            }
        });

        /**
         * Icono de los encargos
         */
        imgRecargar = new ImageIcon("./src/main/java/Imagenes/recargar.png");
        labelRecargar = new JLabel();
        Image imgEscalada5 = imgRecargar.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado5 = new ImageIcon(imgEscalada5);
        labelRecargar.setIcon(iconoEscalado5);
        labelRecargar.setHorizontalAlignment(JLabel.CENTER);
        labelRecargar.setToolTipText("Recargar");
        labelRecargar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(0, -20, 15, -20);
        g.gridx = 0;
        g.gridy = posicionY++;
        panelGeneral.add(labelRecargar, g);
        limpiarConstraints(g);
        /**
         * Añade interaccion al label Encargos
         */
        labelRecargar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ventana.setContentPane(new PanelAplicacion(ventana, new PanelRecargar()));
                ventana.invalidate();
                ventana.validate();
            }
        });

        
        /**
         * Icono del Historial
         */
        
        imgReembolso = new ImageIcon("./src/main/java/Imagenes/reembolso.png");
        labelReembolso = new JLabel();
        Image imgEscalada6 = imgReembolso.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado6 = new ImageIcon(imgEscalada6);
        labelReembolso.setIcon(iconoEscalado6);
        labelReembolso.setHorizontalAlignment(JLabel.CENTER);
        labelReembolso.setToolTipText("Reembolsar");
        labelReembolso.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(0, -20, 20, -20);
        g.gridx = 0;
        g.gridy = posicionY++;
        panelGeneral.add(labelReembolso, g);
        limpiarConstraints(g);
        /**
         * Añade interaccion al label Depositar
         */
        labelReembolso.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ventana.setContentPane(new PanelAplicacion(ventana, new PanelReembolso()));
                ventana.invalidate();
                ventana.validate();
            }
        });
        
        /**
         * Icono del Historial
         */
        imgEncargar = new ImageIcon("./src/main/java/Imagenes/encargar.png");
        labelEncargar = new JLabel();
        Image imgEscalada7 = imgEncargar.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado7 = new ImageIcon(imgEscalada7);
        labelEncargar.setIcon(iconoEscalado7);
        labelEncargar.setHorizontalAlignment(JLabel.CENTER);
        labelEncargar.setToolTipText("Encargar");
        labelEncargar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(0, -20, 25, -20);
        g.gridx = 0;
        g.gridy = posicionY++;
        panelGeneral.add(labelEncargar, g);
        limpiarConstraints(g);
        /**
         * Añade interaccion al label Depositar
         */
        labelEncargar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ventana.setContentPane(new PanelAplicacion(ventana, new PanelReponer()));
                ventana.invalidate();
                ventana.validate();
            }
        });
        
        panelSalir = new JPanel(new GridBagLayout());
        this.add(panelSalir, BorderLayout.SOUTH);

        imgSalir = new ImageIcon("./src/main/java/Imagenes/salir.png");
        labelSalir = new JLabel();
        Image imgEscaladaSalir = imgSalir.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscaladoSalir = new ImageIcon(imgEscaladaSalir);
        labelSalir.setIcon(iconoEscaladoSalir);
        labelSalir.setHorizontalAlignment(JLabel.CENTER);
        labelSalir.setToolTipText("Salir");
        labelSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(0, -20, 10, -20);
        g.gridx = 0;
        g.gridy = 0;
        panelSalir.add(labelSalir, g);
        limpiarConstraints(g);
        /**
         * Añade interaccion al label Home
         */
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
