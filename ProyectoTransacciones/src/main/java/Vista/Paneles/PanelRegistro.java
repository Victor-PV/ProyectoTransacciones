/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Datos.ExceptionDAO;
import Datos.UsuarioDAO;
import Dominio.Posicion;
import Dominio.Usuario;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author victo
 */
public class PanelRegistro extends PanelBackground {

    private UsuarioDAO usuarioDAO;

    private JPanel panelNacimiento;
    private JLabel titulo;
    private JLabel txtDNI, txtNombre, txtApellido, txtPassword, txtNacimiento, espacio, txtCorreo;
    private JTextField campoDNI, campoNombre, campoApellido, campoCorreo;
    private JPasswordField campoPassword;
    private JComboBox listaDias, listaMeses, listaAños;
    private JButton botonConfirmar;
    private JCheckBox checkAdmin;

    private String[] dias = new String[32], meses = new String[13], años = new String[201];

    private String fuentePrincipal = "Monospaced", fuenteSecundaria = "Arial";
    private Color colorPrincipal = new Color(218, 254, 235), colorSecundario = new Color(76, 138, 105);

    public PanelRegistro(JFrame ventana) {
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
        g.insets = new Insets(-20, 43, 0, 43);
        g.weightx = 1;
        g.gridx = 0;
        g.ipady = 20;
        g.gridy = 0;
        g.gridwidth = 4;
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
        g.insets = new Insets(0, 23, 20, 23);
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 4;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);

        txtNombre = new JLabel("Nombre:");
        txtNombre.setForeground(colorSecundario);
        txtNombre.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(10, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 2;
        this.add(txtNombre, g);
        limpiarConstraints(g);

        campoNombre = new JTextField();
        campoNombre.setPreferredSize(new Dimension(300, 35));
        campoNombre.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.ipady = 10;
        g.insets = new Insets(10, 43, 0, 10);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 2;
        this.add(campoNombre, g);
        limpiarConstraints(g);

        txtDNI = new JLabel("DNI:");
        txtDNI.setForeground(colorSecundario);
        txtDNI.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(10, 0, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 2;
        g.gridwidth = 2;
        this.add(txtDNI, g);
        limpiarConstraints(g);

        campoDNI = new JTextField();
        campoDNI.setPreferredSize(new Dimension(300, 35));
        campoDNI.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.ipady = 10;
        g.insets = new Insets(10, 0, 0, 43);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 3;
        g.gridwidth = 2;
        this.add(campoDNI, g);
        limpiarConstraints(g);

        txtApellido = new JLabel("Apellidos:");
        txtApellido.setForeground(colorSecundario);
        txtApellido.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(20, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 4;
        g.gridwidth = 4;
        this.add(txtApellido, g);
        limpiarConstraints(g);

        campoApellido = new JTextField();
        campoApellido.setPreferredSize(new Dimension(300, 35));
        campoApellido.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.ipady = 10;
        g.insets = new Insets(10, 43, 0, 43);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 5;
        g.gridwidth = 4;
        this.add(campoApellido, g);
        limpiarConstraints(g);

        txtNacimiento = new JLabel("Edad:");
        txtNacimiento.setForeground(colorSecundario);
        txtNacimiento.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(20, 43, 0, 20);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 6;
        g.gridwidth = 1;
        this.add(txtNacimiento, g);
        limpiarConstraints(g);

        /**
         * Panel donde iran los 3 comboBox del nacimiento
         */
        dias[0] = "- Dia -";
        for (int i = 1; i < dias.length; i++) {
            dias[i] = "" + (i);
        }
        listaDias = new JComboBox(dias);
        listaDias.setPreferredSize(new Dimension(60, 25));
        listaDias.setBackground(Color.WHITE);
        g.insets = new Insets(20, 0, 0, 0);
        g.gridx = 1;
        g.gridy = 6;
        g.gridwidth = 1;
        g.anchor = GridBagConstraints.LINE_START;
        this.add(listaDias, g);
        limpiarConstraints(g);

        meses[0] = "- Mes -";
        for (int i = 1; i < meses.length; i++) {
            meses[i] = "" + (i);
        }
        listaMeses = new JComboBox(meses);
        listaMeses.setPreferredSize(new Dimension(60, 25));
        listaMeses.setBackground(Color.WHITE);
        g.insets = new Insets(20, 0, 0, 0);
        g.gridx = 2;
        g.gridy = 6;
        g.gridwidth = 1;
        g.anchor = GridBagConstraints.LINE_START;
        this.add(listaMeses, g);
        limpiarConstraints(g);

        años[0] = "- Año -";
        for (int i = 1; i < años.length; i++) {
            años[i] = "" + (i + 1900);
        }
        listaAños = new JComboBox(años);
        listaAños.setBackground(Color.WHITE);
        listaAños.setPreferredSize(new Dimension(60, 25));
        g.insets = new Insets(20, 0, 0, 35);
        g.gridx = 3;
        g.gridy = 6;
        g.gridwidth = 1;
        g.anchor = GridBagConstraints.LINE_START;
        this.add(listaAños, g);
        limpiarConstraints(g);

        txtPassword = new JLabel("Pass:");
        txtPassword.setForeground(colorSecundario);
        txtPassword.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(20, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 7;
        g.gridwidth = 1;
        this.add(txtPassword, g);
        limpiarConstraints(g);

        campoPassword = new JPasswordField();
        campoPassword.setPreferredSize(new Dimension(300, 35));
        campoPassword.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.ipady = 10;
        g.insets = new Insets(20, 0, 0, 45);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 1;
        g.gridy = 7;
        g.gridwidth = 3;
        this.add(campoPassword, g);
        limpiarConstraints(g);

        txtCorreo = new JLabel("Correo:");
        txtCorreo.setForeground(colorSecundario);
        txtCorreo.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        g.insets = new Insets(20, 43, 0, 0);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 8;
        g.gridwidth = 4;
        this.add(txtCorreo, g);
        limpiarConstraints(g);

        campoCorreo = new JTextField();
        campoCorreo.setPreferredSize(new Dimension(300, 35));
        campoCorreo.setFont(new Font(fuenteSecundaria, Font.PLAIN, 14));
        g.ipady = 10;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(10, 43, 0, 43);
        g.gridx = 0;
        g.gridy = 9;
        g.gridwidth = 4;
        this.add(campoCorreo, g);
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
        g.insets = new Insets(40, 23, 10, 23);
        g.gridx = 0;
        g.gridy = 10;
        g.gridwidth = 4;
        g.weightx = 1;
        this.add(espacio, g);
        limpiarConstraints(g);

        checkAdmin = new JCheckBox("Admin");
        checkAdmin.setForeground(colorSecundario);
        checkAdmin.setFont(new Font(fuenteSecundaria, Font.BOLD, 16));
        checkAdmin.setOpaque(false);
        checkAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        checkAdmin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        g.insets = new Insets(0, 36, 0, 0);
        g.gridx = 0;
        g.gridy = 11;
        this.add(checkAdmin, g);
        limpiarConstraints(g);

        botonConfirmar = new JButton("REGISTRATE");
        botonConfirmar.setPreferredSize(new Dimension(140, 40));
        botonConfirmar.setBackground(colorSecundario);
        botonConfirmar.setForeground(colorPrincipal);
        botonConfirmar.setBorder(new MatteBorder(1, 1, 1, 1, colorPrincipal));
        botonConfirmar.setFont(new Font(fuenteSecundaria, Font.BOLD, 12));
        botonConfirmar.setFocusPainted(false);
        botonConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.insets = new Insets(5, 0, 0, 43);
        g.anchor = GridBagConstraints.LINE_END;
        g.gridx = 1;
        g.gridy = 11;
        g.gridwidth = 3;
        g.ipadx = 53;
        g.ipady = 30;
        this.add(botonConfirmar, g);
        limpiarConstraints(g);

        botonConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usuarioDAO = new UsuarioDAO(ventana);
                try {
                    //Comprobar que el campo DNI tenga 8 numeros y 1 letra
                    if (campoDNI.getText().length() == 9) {
                        for (int i = 0; i < campoDNI.getText().length(); i++) {
                            if (i != 8) {
                                if (!Character.isDigit(campoDNI.getText().charAt(i))) {
                                    throw new ExceptionDAO("El DNI debe contener 8 numeros y 1 letra");
                                }
                            } else {
                                if (Character.isDigit(campoDNI.getText().charAt(i))) {
                                    throw new ExceptionDAO("El DNI debe contener 8 numeros y 1 letra");
                                }
                            }
                        }
                    } else {
                        throw new ExceptionDAO("El DNI debe tener 9 caracteres");
                    }

                    //Comprobar que el campo Nombre no tenga numeros
                    if (campoNombre.getText().length() > 0) {
                        for (int i = 0; i < campoNombre.getText().length(); i++) {
                            if (Character.isDigit(campoNombre.getText().charAt(i))) {
                                throw new ExceptionDAO("Error al introducir el nombre");
                            }
                        }
                    } else {
                        throw new ExceptionDAO("El Nombre es obligatorio");
                    }

                    //Comprobar que el campo Apellidos no tenga numeros
                    if (campoApellido.getText().length() > 0) {
                        for (int i = 0; i < campoApellido.getText().length(); i++) {
                            if (Character.isDigit(campoApellido.getText().charAt(i))) {
                                throw new ExceptionDAO("Error al introducir el apellido");
                            }
                        }
                    } else {
                        throw new ExceptionDAO("El apellido es obligatorio");
                    }

                    //Comprobar que todos los campos de Fecha Nacimiento estan seleccionados
                    if (listaDias.getSelectedIndex() == 0 || listaMeses.getSelectedIndex() == 0 || listaAños.getSelectedIndex() == 0) {
                        throw new ExceptionDAO("Error al introducir la fecha");
                    }

                    //Comprobar que el usuario es mayor de edad
                    LocalDate fechaHoy = LocalDate.now();
                    LocalDate fechaNacimientoa = LocalDate.of(Integer.parseInt((String) listaAños.getSelectedItem()), Integer.parseInt((String) listaMeses.getSelectedItem()), Integer.parseInt((String) listaDias.getSelectedItem()));
                    Period periodo = Period.between(fechaNacimientoa, fechaHoy);
                    if (periodo.getYears() < 18) {
                        throw new ExceptionDAO("El usuario debe ser mayor de edad");
                    }

                    //Comprobar que el campo Password esta escrito
                    if (campoPassword.getText().length() == 0) {
                        throw new ExceptionDAO("La contraseña es obligatoria");
                    }

                    //Comprobar que el campo Correo contenga @ y .
                    if (campoCorreo.getText().length() > 0) {
                        boolean arroba = false;
                        boolean punto = false;
                        for (int i = 0; i < campoCorreo.getText().length(); i++) {
                            if (campoCorreo.getText().charAt(i) == '@') {
                                arroba = true;
                            }
                            if (campoCorreo.getText().charAt(i) == '.') {
                                punto = true;
                            }
                        }
                        if (!arroba || !punto) {
                            throw new ExceptionDAO("Correo no valido");
                        }
                    }

                    Date fechaNacimiento = new Date(Integer.parseInt((String) listaAños.getSelectedItem()), Integer.parseInt((String) listaMeses.getSelectedItem()), Integer.parseInt((String) listaDias.getSelectedItem()));
                    Posicion posicion = checkAdmin.isSelected() ? Posicion.Administrador : Posicion.Cliente;
                    Usuario usuario = new Usuario(campoDNI.getText(), campoNombre.getText(), campoApellido.getText(), campoCorreo.getText(), campoPassword.getText(), fechaNacimiento, posicion);

                    int resultado = usuarioDAO.insertar(usuario);
                    if (resultado == -2) {
                        throw new ExceptionDAO("El DNI introducido ya existe");
                    }else if (resultado == 2) {
                        PanelAlerta panelException = new PanelAlerta(ventana, true, "El usuario ha sido actualizado", "");
                        panelException.setVisible(true);
                    } else {
                        
                    }
                    
                    //Cambiar de ventana a la de la aplicacion
                    FrameAplicacion frameAplicacion = new FrameAplicacion(usuarioDAO.select(usuario.getDNI()));
                    frameAplicacion.setVisible(true);
                    ventana.dispose();
                } catch (Exception ex) {
                    PanelAlerta panelException = new PanelAlerta(ventana, true, ex.getMessage(), "ERROR");
                    panelException.setVisible(true);
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

    class focusListener extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            ((JTextField) e.getSource()).setBorder(new MatteBorder(0, 0, 2, 0, colorPrincipal));
        }

        @Override
        public void focusLost(FocusEvent e) {
            ((JTextField) e.getSource()).setBorder(new MatteBorder(0, 0, 2, 0, colorSecundario));
        }
    }
}
