/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Datos.ComprasDAO;
import Datos.EWalletDAO;
import Datos.ProductoDAO;
import Datos.UsuarioDAO;
import Dominio.EWallet;
import Dominio.Posicion;
import Dominio.Producto;
import Dominio.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelCatalogo extends JPanel {

    /**
     * Variables de la clase
     */
    private ProductoDAO productoDAO;
    private EWalletDAO ewalletDAO;
    private ComprasDAO comprasDAO;
    private EWallet ewallet;
    private Producto productoComprar;
    private float saldoUsuario;
    private int puntosUsuario;

    private List<Producto> listaProductos;

    private JPanel panelHeader;
    private JLabel txtTitulo, espacio;

    private JPanel panelMain, panelProducto, panelPasarProductos;
    private ImageIcon imgProducto;
    private JLabel labelProductoImg, labelProducto, labelPrecio, labelPuntosProducto, labelPaginas;
    private JButton botonProducto, botonLeft, botonRight;

    private JPanel panelFooter, panelSaldo, panelCesta, panelPagarPuntos;
    private ImageIcon imgProductoCesta;
    private JLabel labelProductoCesta, labelNombreCesta, labelSaldo, labelPuntos;
    private JTextField campoSaldo, campoPuntos;
    private JButton botonCesta;
    private JCheckBox checkPagarPuntos;

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelCatalogo(Usuario usuario, JFrame ventana) {
        /**
         * Conexion con la base de datos
         */
        productoDAO = new ProductoDAO(ventana);
        ewalletDAO = new EWalletDAO(ventana);
        comprasDAO = new ComprasDAO(ventana);

        listaProductos = productoDAO.seleccionar();
        ewallet = ewalletDAO.seleccionar(usuario.getDNI());
        saldoUsuario = ewallet.getSaldo();
        puntosUsuario = ewallet.getPuntos();

        this.setLayout(new BorderLayout());
        GridBagConstraints g = new GridBagConstraints();

        /**
         * Panel donde se colocaran los elementos del header del panel principal
         */
        panelHeader = new JPanel(new GridBagLayout());
        panelHeader.setOpaque(false);

        txtTitulo = new JLabel("Catalogo:");
        txtTitulo.setForeground(colorSecundario);
        txtTitulo.setFont(new Font(fuenteSecundaria, Font.BOLD, 26));
        g.anchor = GridBagConstraints.LINE_START;
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 1;
        g.insets = new Insets(30, 50, 10, 0);
        panelHeader.add(txtTitulo, g);
        limpiarConstraints(g);

        panelSaldo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //panelSaldo.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        panelSaldo.setOpaque(false);
        g.insets = new Insets(30, 0, 10, 50);
        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 1;
        g.anchor = GridBagConstraints.LINE_END;

        labelSaldo = new JLabel("Saldo:");
        labelSaldo.setForeground(colorSecundario);
        labelSaldo.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        panelSaldo.add(labelSaldo);

        campoSaldo = new JTextField(saldoUsuario + "€");
        campoSaldo.setPreferredSize(new Dimension(90, 35));
        campoSaldo.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoSaldo.setEditable(false);
        panelSaldo.add(campoSaldo);

        labelPuntos = new JLabel("Puntos:");
        labelPuntos.setForeground(colorSecundario);
        labelPuntos.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        panelSaldo.add(labelPuntos);

        campoPuntos = new JTextField(puntosUsuario + " Pts");
        campoPuntos.setPreferredSize(new Dimension(90, 35));
        campoPuntos.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        campoPuntos.setEditable(false);
        panelSaldo.add(campoPuntos);

        panelHeader.add(panelSaldo, g);

        espacio = new JLabel("");
        espacio.setForeground(colorSecundario);
        espacio.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        espacio.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 50, 0, 50);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 2;
        g.weightx = 1;
        panelHeader.add(espacio, g);
        limpiarConstraints(g);

        this.add(panelHeader, BorderLayout.NORTH);

        /**
         * Panel donde se colocaran los elementos del main del panel principal
         */
        panelMain = new JPanel(new GridBagLayout());
        panelMain.setOpaque(false);

        String[] listaProductosNombre = {"Naranjas 4Kg", "Pechuga de pavo", "Ensalada gourmet", "Jamón cocido 125g",
            "Rabo vacuno 1Kg", "Setas enteras 300g", "Pan de perrito 6Ud", "Lechuga romana"};
        String[] listaProductosPrecio = new String[8];
        String[] listaProductosPuntos = new String[8];

        for (int i = 0; i < listaProductosPrecio.length; i++) {
            listaProductosPrecio[i] = listaProductos.get(i).getPrecio() + "";
            listaProductosPuntos[i] = listaProductos.get(i).getPuntos() + "";
        }

        int indice = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                Producto productoActual = listaProductos.get(indice++);
                panelProducto = new JPanel(new GridBagLayout());
                panelProducto.setOpaque(false);
                //panelProducto.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
                g.gridx = j;
                g.gridy = i;
                g.anchor = GridBagConstraints.CENTER;
                g.insets = new Insets(10, 0, 0, 0);
                if (i == 0) {
                    g.insets = new Insets(-25, 0, 10, 0);
                }
                panelMain.add(panelProducto, g);
                limpiarConstraints(g);

                labelPuntosProducto = new JLabel(productoActual.getPuntos() + "Pts");
                labelPuntosProducto.setForeground(colorSecundario);
                labelPuntosProducto.setOpaque(true);
                labelPuntosProducto.setPreferredSize(new Dimension(60, 30));
                labelPuntosProducto.setHorizontalAlignment(JLabel.CENTER);
                labelPuntosProducto.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
                labelPuntosProducto.setBackground(new Color(255, 253, 176));
                labelPuntosProducto.setBorder(new MatteBorder(1, 1, 0, 0, colorSecundario));
                g.anchor = GridBagConstraints.LINE_END;
                g.gridx = 1;
                g.gridy = 3;
                g.gridwidth = 1;
                g.insets = new Insets(-195, 0, 0, 0);
                panelProducto.add(labelPuntosProducto, g);
                limpiarConstraints(g);

                imgProducto = new ImageIcon("./src/main/java/Imagenes/Productos/" + productoActual.getCodigo() + ".jpg");
                labelProductoImg = new JLabel();
                Image imgEscalada = imgProducto.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                Icon iconoEscalado = new ImageIcon(imgEscalada);
                labelProductoImg.setIcon(iconoEscalado);
                g.gridx = 0;
                g.gridy = 0;
                g.gridwidth = 2;
                panelProducto.add(labelProductoImg, g);
                limpiarConstraints(g);

                labelProducto = new JLabel(productoActual.getNombre());
                labelProducto.setForeground(colorSecundario);
                labelProducto.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
                labelProducto.setBackground(new Color(255, 255, 255));
                labelProducto.setOpaque(true);
                labelProducto.setBorder(new MatteBorder(1, 0, 1, 0, colorSecundario));
                labelProducto.setHorizontalAlignment(JLabel.CENTER);
                labelProducto.setPreferredSize(new Dimension(140, 30));
                g.fill = GridBagConstraints.HORIZONTAL;
                g.weightx = 1;
                g.gridx = 0;
                g.gridy = 1;
                g.ipady = 15;
                g.gridwidth = 2;
                panelProducto.add(labelProducto, g);
                limpiarConstraints(g);

                labelPrecio = new JLabel(productoActual.getPrecio() + "€");
                labelPrecio.setForeground(colorSecundario);
                labelPrecio.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
                labelProducto.setHorizontalAlignment(JLabel.CENTER);
                g.gridx = 0;
                g.gridy = 2;
                g.gridwidth = 1;
                panelProducto.add(labelPrecio, g);
                limpiarConstraints(g);

                botonProducto = new JButton("AÑADIR");
                botonProducto.setPreferredSize(new Dimension(60, 38));
                botonProducto.setBackground(colorSecundario);
                botonProducto.setForeground(colorPrincipal);
                botonProducto.setBorder(new MatteBorder(0, 1, 1, 1, colorPrincipal));
                botonProducto.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
                botonProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
                botonProducto.setFocusPainted(false);
                if (productoActual.getCantidad() <= 0) {
                    botonProducto.setEnabled(false);
                }
                g.anchor = GridBagConstraints.LINE_END;
                g.gridx = 1;
                g.gridy = 2;
                g.gridwidth = 1;
                panelProducto.add(botonProducto, g);
                limpiarConstraints(g);
                botonProducto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        productoComprar = productoActual;
                        labelNombreCesta.setText(productoComprar.getNombre() + " | " + productoComprar.getPrecio() + "€ ");
                        botonCesta.setEnabled(true);
                    }
                });

                //Si el usuario es cliente_administrador se mostrara el stock y si es solo administrador se bloqueara el boton añadir
                if (usuario.getPosicion() == Posicion.Administrador || usuario.getPosicion() == Posicion.ClienteAdministrador) {
                    panelProducto.setToolTipText("Stock: " + productoActual.getCantidad());
                    if (usuario.getPosicion() == Posicion.Administrador) {
                        botonProducto.setEnabled(false);
                    }
                }

            }
            panelPasarProductos = new JPanel();
            panelPasarProductos.setOpaque(false);
            g.anchor = GridBagConstraints.CENTER;
            g.insets = new Insets(30, 0, -30, 0);
            g.gridx = 0;
            g.gridy = 2;
            g.gridwidth = 4;
            panelMain.add(panelPasarProductos, g);
            limpiarConstraints(g);

            botonLeft = new JButton("<<");
            botonLeft.setPreferredSize(new Dimension(60, 22));
            botonLeft.setBackground(colorSecundario);
            botonLeft.setForeground(colorPrincipal);
            botonLeft.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
            botonLeft.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
            botonLeft.setEnabled(false);
            botonLeft.setFocusPainted(false);
            botonLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panelPasarProductos.add(botonLeft);

            labelNombreCesta = new JLabel("01 / 32");
            labelNombreCesta.setForeground(colorSecundario);
            labelNombreCesta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
            panelPasarProductos.add(labelNombreCesta);

            botonRight = new JButton(">>");
            botonRight.setPreferredSize(new Dimension(60, 22));
            botonRight.setBackground(colorSecundario);
            botonRight.setForeground(colorPrincipal);
            botonRight.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
            botonRight.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
            botonRight.setFocusPainted(false);
            botonRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panelPasarProductos.add(botonRight);
        }

        this.add(panelMain, BorderLayout.CENTER);

        /**
         * Panel donde se colocaran los elementos del footer del panel principal
         */
        panelFooter = new JPanel(new GridBagLayout());
        panelFooter.setOpaque(false);

        espacio = new JLabel("");
        espacio.setForeground(colorSecundario);
        espacio.setFont(new Font(fuenteSecundaria, Font.BOLD, 18));
        espacio.setBorder(new MatteBorder(0, 0, 1, 0, colorSecundario));
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(0, 50, 0, 50);
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        g.weightx = 1;
        panelFooter.add(espacio, g);
        limpiarConstraints(g);

        panelPagarPuntos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPagarPuntos.setOpaque(false);
        g.insets = new Insets(0, 50, 0, 0);
        g.gridx = 0;
        g.anchor = GridBagConstraints.LINE_START;
        g.gridy = 1;
        g.gridwidth = 1;
        panelFooter.add(panelPagarPuntos, g);
        limpiarConstraints(g);

        checkPagarPuntos = new JCheckBox("Pagar con puntos");
        checkPagarPuntos.setForeground(colorSecundario);
        checkPagarPuntos.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        checkPagarPuntos.setOpaque(false);
        checkPagarPuntos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        checkPagarPuntos.setToolTipText("100Pts = 1€");
        checkPagarPuntos.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panelPagarPuntos.add(checkPagarPuntos);

        /**
         * Panel donde ira el saldo y los puntos
         */
        panelCesta = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //panelCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorSecundario));
        panelCesta.setOpaque(false);
        g.insets = new Insets(10, 0, 10, 45);
        g.gridx = 1;
        g.gridy = 1;
        g.anchor = GridBagConstraints.LINE_END;

        //labelNombreCesta = new JLabel(listaProductosNombre[1] + "  |  " + listaProductosPrecio[1]+"€");
        labelNombreCesta = new JLabel("");
        labelNombreCesta.setForeground(colorSecundario);
        labelNombreCesta.setFont(new Font(fuenteSecundaria, Font.PLAIN, 16));
        labelNombreCesta.setPreferredSize(new Dimension(200, 30));
        panelCesta.add(labelNombreCesta);

        botonCesta = new JButton("COMPRAR");
        botonCesta.setPreferredSize(new Dimension(140, 38));
        botonCesta.setBackground(colorSecundario);
        botonCesta.setForeground(colorPrincipal);
        botonCesta.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonCesta.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonCesta.setFocusPainted(false);
        botonCesta.setEnabled(false);
        botonCesta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelCesta.add(botonCesta);
        botonCesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkPagarPuntos.isSelected()) {
                    if (productoComprar.getPrecio() >= 5) { //Si el producto cuesta mas de 5€
                        if (((float) puntosUsuario / 100) >= productoComprar.getPrecio()) {//Si los puntos son suficientes para pagar el producto, 100Pts = 1€ (Ej. 2620Pts = 26.2€)

                            comprasDAO.inertar(usuario, productoComprar);//Añade registro de la compra
                            productoDAO.actualizar(productoComprar); //Actualiza el stock del producto
                            ewalletDAO.actualizarCompraPuntos(productoComprar, ewallet, (int) (productoComprar.getPrecio() * 100)); //Actualiza los puntos del usuario tras la compra
                            
                            //Vuelve a cargar el panel
                            ventana.setContentPane(new PanelAplicacion(ventana, new PanelCatalogo(usuario, ventana), usuario));
                            ventana.invalidate();
                            ventana.validate();

                            PanelAlerta ventanaComprado = new PanelAlerta(ventana, true, "\"" + productoComprar.getNombre() + "\" comprado por "+(int) (productoComprar.getPrecio() * 100)+" puntos", "");
                            ventanaComprado.setVisible(true);

                        } else {
                            PanelAlerta ventanaComprado = new PanelAlerta(ventana, true, "No tienes suficientes puntos", "ERROR");
                            ventanaComprado.setVisible(true);
                        }
                    } else {
                        PanelAlerta ventanaComprado = new PanelAlerta(ventana, true, "El producto debe costar mas de 5€", "ERROR");
                        ventanaComprado.setVisible(true);
                    }
                } else {
                    if (saldoUsuario - productoComprar.getPrecio() >= 0) {
                        //Transaccion
                        comprasDAO.inertar(usuario, productoComprar);//Añade registro de la compra
                        productoDAO.actualizar(productoComprar); //Actualiza el stock del producto
                        ewalletDAO.actualizarCompra(productoComprar, ewallet); //Actualiza el saldo y los puntos del usuario tras la compra

                        //Vuelve a cargar el panel
                        ventana.setContentPane(new PanelAplicacion(ventana, new PanelCatalogo(usuario, ventana), usuario));
                        ventana.invalidate();
                        ventana.validate();

                        PanelAlerta ventanaComprado = new PanelAlerta(ventana, true, "\"" + productoComprar.getNombre() + "\" comprado con exito", "");
                        ventanaComprado.setVisible(true);
                    } else {
                        PanelAlerta ventanaComprado = new PanelAlerta(ventana, true, "No tienes suficiente saldo", "ERROR");
                        ventanaComprado.setVisible(true);
                    }
                }
            }
        });

        panelFooter.add(panelCesta, g);

        limpiarConstraints(g);
        this.add(panelFooter, BorderLayout.SOUTH);

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
