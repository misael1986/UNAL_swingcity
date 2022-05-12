/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unal.unal_swingcity.ciudad;

/**
 * Interfaz donde se definen los parámetros para iniciar la aplicación 
 * @author Camiku
 */
public interface ParametrosDibujo {
    
    final int ANCHO = 100;
    final int ALTO = 30;
    final int ITERACIONES_CIUDAD = 200;
    final int PAUSA_MILISEGUNDOS = 100;
    final int NUMERO_SITIOS = 5;
    final String CONTENIDO_CARGA = "UNAL";
    final int CONTENIDO_PLATON = 12345;
    
    public int sumar(int x, int y);
    
    
    
}
