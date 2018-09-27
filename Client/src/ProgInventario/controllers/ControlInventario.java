package ProgInventario.controllers;

import ProgInventario.entitys.Producto;

import ProgInventario.intergazGraf.FormularioInventario;


public class ControlInventario {
    private FormularioInventario formulario;
    private Producto producto;
    private int contador;
    private int cantidad;
    private String listaProductos;
    private Producto[] arregloProductos;
    
    public ControlInventario() {

    }
    
    public void iniciar() {
        if (formulario == null) {
            formulario = new FormularioInventario();
            formulario.setVisible(true);
        } else {
            formulario.setVisible(true);
        }
    }
}
