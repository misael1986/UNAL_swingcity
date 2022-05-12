/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unal.unal_swingcity.animacionciudad;

import com.edu.unal.unal_swingcity.ciudad.ParametrosDibujo;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Panel utilizado para ubicar los controles de dibujo
 *
 * @author Camiku
 */
public class PanelControles extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 3116611926032812478L;
    // Área de texto para dibujar la ciudad
    private JTextArea jTextArea;
    // Etiqueta del campo de texto de la carga
    private JLabel jLabelCarga;
    // Etiqueta de la lista de cadenas del control del tiempo
    private JLabel jLabelDormir, jLabelIter;
    // Campo de texto del valor de la carga de los furgones
    private JTextField jTextFieldCarga;
    // Boton usado para iniciar la animación
    private JButton jButtonIniciar;
    // Lista de números del control del tiempo
    private JSpinner jSpinnerDormir, jSpinnerIter;
    // Boton de chequeo para establecer si aparecen los carros de carga
    private JCheckBox jCheckBoxVehiculosCarga;
    // Componente que agrupa un conjunto de botones de opción para 
    // que actuen sincronizados (i.e. que sólo uno pueda ser seleccionado) 
    private ButtonGroup buttonGroupDireccion;
    // Botón de la opción de la dirección hacia adelante
    private JRadioButton jRadioButtonAdelante, jRadioButtonAtras;

    private JButton jButtonParar;

    private JLabel jLabelPlaton;
    private JTextField jTextFieldPlaton;

    private JCheckBox jCheckBoxVehiculoDeportivo;
    private JCheckBox jCheckBoxVehiculoAutomovil;

    /**
     * Crea un panel que servirá para ubicar los controles de dibujo
     *
     * @param panelCiudad
     */
    public PanelControles(PanelCiudad panelCiudad) {
        this.jTextArea = panelCiudad.getjTextArea();
        initComponents();
    }

    /**
     * Inicia la creación de las componentes de control de dibujo
     */
    private void initComponents() {
        // Establece el gestor de organización en forma de retícula de tamaño 10x1
        setLayout(new GridLayout(16, 1));

        jButtonIniciar = new JButton("Iniciar animación");
        // Adiciona el botón a éste panel
        add(jButtonIniciar);

        jButtonParar = new JButton("Parar animaci\u00F3n");
        add(jButtonParar);

        jLabelCarga = new JLabel("Carga del Furgon: ");
        add(jLabelCarga);

        jTextFieldCarga = new JTextField(ParametrosDibujo.CONTENIDO_CARGA);
        add(jTextFieldCarga);

        jLabelPlaton = new JLabel("Carga del Platon:");
        add(jLabelPlaton);

        jTextFieldPlaton = new JTextField(
                Integer.toString(ParametrosDibujo.CONTENIDO_PLATON));
        add(jTextFieldPlaton);

        jLabelDormir = new JLabel("Lapso de dormir: ");
        add(jLabelDormir);

        jSpinnerDormir = new JSpinner();
        // Establece el valor por defecto de la lista de números
        jSpinnerDormir.setValue(ParametrosDibujo.PAUSA_MILISEGUNDOS);
        add(jSpinnerDormir);
        
        jLabelIter = new JLabel("Iteraciones maximas:");
        add(jLabelIter);

        jSpinnerIter = new JSpinner();
        // Establece el valor por defecto de la lista de números
        jSpinnerIter.setValue(ParametrosDibujo.ITERACIONES_CIUDAD);
        add(jSpinnerIter);
        

        jCheckBoxVehiculosCarga = new JCheckBox("Carga");
        
        jCheckBoxVehiculoDeportivo = new JCheckBox("Deportivo");
        jCheckBoxVehiculoAutomovil = new JCheckBox("Automovil");
        // El boton de chequeo aparecerá seleccionado
        jCheckBoxVehiculosCarga.setSelected(true);
        add(jCheckBoxVehiculosCarga);
        add(jCheckBoxVehiculoDeportivo);
        add(jCheckBoxVehiculoAutomovil);
        

        jRadioButtonAdelante = new JRadioButton("Adelante");
        // El boton de opción aparecerá seleccionado
        jRadioButtonAdelante.setSelected(true);
        add(jRadioButtonAdelante);
        
        jRadioButtonAtras = new JRadioButton("Reversa");
        // El boton de opción aparecerá seleccionado
        add(jRadioButtonAtras);

        buttonGroupDireccion = new ButtonGroup();
        // Adiciona el boton de opción a un grupo de botones
        buttonGroupDireccion.add(jRadioButtonAdelante);
        buttonGroupDireccion.add(jRadioButtonAtras);

        // Crea un auditor que tramitará los eventos generados por el boton
        EventoClic eventoClic = new EventoClic(this);

        jButtonParar.addActionListener(eventoClic);

        // Establece como auditor al objeto eventoClic cuando se presiona el boton
        jButtonIniciar.addActionListener(eventoClic);

        /* Crea un auditor que tramitará los eventos generados por la 
        lista de números del control del tiempo**/
        EventoCambioLista eventoCambioLista = new EventoCambioLista(jSpinnerDormir);

        // Establece como auditor al objeto eventoCambioLista cuando se 
        // gira la rueda del ratón
        jSpinnerDormir.addMouseWheelListener(eventoCambioLista);
        // Establece como auditor al objeto eventoCambioLista cuando se 
        // modifica la lista de números
        jSpinnerDormir.addChangeListener(eventoCambioLista);
        
        jSpinnerIter.addChangeListener(eventoCambioLista);

    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public JTextField getjTextFieldCarga() {
        return jTextFieldCarga;
    }

    public JButton getjButtonIniciar() {
        return jButtonIniciar;
    }

    public JSpinner getjSpinnerDormir() {
        return jSpinnerDormir;
    }

    public JCheckBox getjCheckBoxVehiculosCarga() {
        return jCheckBoxVehiculosCarga;
    }

    public JRadioButton getjRadioButtonAdelante() {
        return jRadioButtonAdelante;
    }
    
    public JRadioButton getjRadioButtonAtras() {
        return jRadioButtonAtras;
    }

    public JButton getjButtonParar() {
        return jButtonParar;
    }

    public JTextField getjTextFieldPlaton() {
        return jTextFieldPlaton;
    }
    
    public JCheckBox getjCheckBoxVehiculoDeportivo() {
        return this.jCheckBoxVehiculoDeportivo;
    }
    
    public JCheckBox getjCheckBoxVehiculoAutomovil() {
        return this.jCheckBoxVehiculoAutomovil;
    }
    
    public JSpinner getjSpinnerIter() {
        return this.jSpinnerIter;
    }

}
