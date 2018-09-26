package ProgInventario.controllers;

import ProgInventario.entitys.Producto;

import ProgInventario.intergazGraf.FormularioProd;

public class ControlInventario {
    private FormularioProd formulario;
    private Producto producto;
    private int contador;
    private int cantidad;
    private String listaProductos;
    private Producto[] arregloProductos;
    
    public ControlInventario() {

    }
    
    public void iniciar() {
        if (formulario == null) {
            formulario = new FormularioProd();
            formulario.setVisible(true);
        } else {
            formulario.setVisible(true);
        }
    }
}
