/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Paneles.PanelAplicacion;
import Vista.Paneles.PanelHistorial;
import Vista.Paneles.PanelMenuAside;
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

    private JPanel panelPrincipal;
    
    private JPanel panelMenu, panelMenuIn;
    
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

        panelPrincipal = new PanelAplicacion(FrameAplicacion.this, new PanelHistorial());
        
        
        this.add(panelPrincipal);
    }
    
    public JPanel getContenidoIn(){
        return this.panelContenido;
    }
}
