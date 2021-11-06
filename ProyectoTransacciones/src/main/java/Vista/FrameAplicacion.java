/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Paneles.PanelAplicacion;
import Vista.Paneles.PanelCatalogo;
import Vista.Paneles.PanelRecargar;
import Vista.Paneles.PanelReembolso;
import Vista.Paneles.PanelReponer;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

        panelPrincipal = new PanelAplicacion(FrameAplicacion.this, new PanelReembolso(FrameAplicacion.this));
        
        
        this.add(panelPrincipal);
    }
    
    public JPanel getContenidoIn(){
        return this.panelContenido;
    }
}
