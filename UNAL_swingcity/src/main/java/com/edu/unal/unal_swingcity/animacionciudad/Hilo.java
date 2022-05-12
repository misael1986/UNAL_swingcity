/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unal.unal_swingcity.animacionciudad;

import com.edu.unal.unal_swingcity.ciudad.Ciudad;
import com.edu.unal.unal_swingcity.ciudad.ParametrosDibujo;
import com.edu.unal.unal_swingcity.ciudad.Posicion;
import com.edu.unal.unal_swingcity.ciudad.Sitio;
import java.util.ArrayList;
import java.util.List;
import com.edu.unal.unal_swingcity.vehiculo.Automovil;
import com.edu.unal.unal_swingcity.vehiculo.Deportivo;
import com.edu.unal.unal_swingcity.vehiculo.Furgon;
import com.edu.unal.unal_swingcity.vehiculo.Platon;
import com.edu.unal.unal_swingcity.vehiculo.Vehiculo;
import javax.swing.JOptionPane;

/**
 * Hilo utilizado para iniciar un proceso independiente
 *
 * @author Camiku
 */
public class Hilo extends Thread {

    private PanelControles panelControles;

    private boolean parar;

    private int valorMaxIteraciones;

    public Hilo(PanelControles panelControles) {
        this.panelControles = panelControles;
    }

    /**
     * Inicializa la ejecución de la aplicación de forma independiente
     */
    @Override
    public void run() {

        int valorMaxIteraciones = ParametrosDibujo.NUMERO_SITIOS;
        Automovil automovil = new Automovil(new Posicion(), 5);
        Deportivo deportivo = new Deportivo(new Posicion(), 5);
        Platon camioneta = new Platon(new Posicion(), 3, 4);
        camioneta.llevar(Integer.parseInt(
                panelControles.getjTextFieldPlaton().getText()));
        Furgon furgon = new Furgon(new Posicion(2, 50), 3, 4);
        furgon.llevar(panelControles.getjTextFieldCarga().getText());

        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

        if (panelControles.getjCheckBoxVehiculosCarga().isSelected()) {
            listaVehiculos.add(camioneta);
            listaVehiculos.add(furgon);
        }
        if (panelControles.getjCheckBoxVehiculoDeportivo().isSelected()) {
            listaVehiculos.add(deportivo);
        }
        if (panelControles.getjCheckBoxVehiculoAutomovil().isSelected()) {
            listaVehiculos.add(automovil);
        }

        List<Sitio> listaSitios = new ArrayList<Sitio>();
        for (int i = 0; i < ParametrosDibujo.NUMERO_SITIOS; i++) {
            listaSitios.add(new Sitio(new Posicion()));
        }

        Ciudad ciudad = new Ciudad(listaVehiculos, listaSitios);
        parar = false;
        for (int i = 0; i < valorMaxIteraciones; i++) {
            if (panelControles.getjRadioButtonAdelante().isSelected()) {
                ciudad.mover();
            } else if (panelControles.getjRadioButtonAtras().isSelected()) {
                ciudad.moverReversa();
            }
            panelControles.getjTextArea().setText(ciudad.pintar());
            try {
                sleep((Integer) panelControles.getjSpinnerDormir().getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (parar) {
                i = ParametrosDibujo.ITERACIONES_CIUDAD;
                JOptionPane.showMessageDialog(null,
                        "La animaci\u00F3n fue detenida");
            }

        }
        // Reactiva el boton de ejecución
        panelControles.getjButtonIniciar().setEnabled(true);

    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    public void setValorMaxIteraciones(int max) {
        this.valorMaxIteraciones = max;
    }

}
