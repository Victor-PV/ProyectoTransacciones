/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Vista.FrameAplicacion;
import Vista.FrameInicio;
import java.awt.BorderLayout;
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

    private JPanel panelGeneral, panelSalir;

    private JLabel labelSalir, labelPlantilla;
    private ImageIcon imgSalir, imgPlantilla;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    private String[] listaPaneles = {"home", "catalogo", "historial", "encargos", "recargar", "encargar"};

    public PanelMenuAside(JFrame ventana) {
        this.setLayout(new BorderLayout());
        panelGeneral = new JPanel(new GridBagLayout());
        this.add(panelGeneral, BorderLayout.NORTH);
        GridBagConstraints g = new GridBagConstraints();

        //listaPaneles = null;
        String variableTemporal = "AdminClient";
        if (variableTemporal.equals("AdminClient")) {
            //Si la variable coincide carga x paneles
        }

        for (int i = 0; i < listaPaneles.length; i++) {
            imgPlantilla = new ImageIcon("./src/main/java/Imagenes/" + listaPaneles[i] + ".png");
            labelPlantilla = new JLabel();
            Image imgEscalada = imgPlantilla.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            Icon iconoEscalado = new ImageIcon(imgEscalada);
            labelPlantilla.setIcon(iconoEscalado);
            labelPlantilla.setHorizontalAlignment(JLabel.CENTER);
            labelPlantilla.setToolTipText(listaPaneles[i]);
            if (i != 0) {
                g.insets = new Insets(0, -20, 20, -20);
            } else {
                g.insets = new Insets(15, -20, 20, -20);
            }
            g.gridx = 0;
            g.gridy = i;
            panelGeneral.add(labelPlantilla, g);
            limpiarConstraints(g);
            /**
             * Añade interaccion al label Home
             */
            labelPlantilla.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    //Depende que listaPaneles haya pones un panel
                    //if (listaPaneles[i] instanceof PanelUsuario){
                    ventana.setContentPane(new PanelAplicacion(ventana, new PanelUsuario()));
                    // }
                    ventana.invalidate();
                    ventana.validate();
                }
            });
        }

        panelSalir = new JPanel(new GridBagLayout());
        this.add(panelSalir, BorderLayout.SOUTH);

        imgSalir = new ImageIcon("./src/main/java/Imagenes/salir.png");
        labelSalir = new JLabel();
        Image imgEscalada = imgSalir.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        labelSalir.setIcon(iconoEscalado);
        labelSalir.setHorizontalAlignment(JLabel.CENTER);
        labelSalir.setToolTipText("Salir");
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
