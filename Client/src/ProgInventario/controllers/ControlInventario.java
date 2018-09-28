package ProgInventario.controllers;


import ProgInventario.intergazGraf.FormularioInventario;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ProgInventario.entitys.*;

import java.awt.event.ActionListener;


public class ControlInventario implements ActionListener {
    private FormularioInventario formInv;
    private Producto producto;
    private int contador;
    private int cantidad;
    private String listaProductos;
    private Producto[] arregloProductos;
    private ProductoExistencias productoExistencias;

    public ControlInventario() {
        iniciar();
        //instancia Unica del arreglo de existencias de productos
        productoExistencias = ProductoExistencias.getSingletonInstance();
        this.formInv
            .getBtnAddProductos()
            .addActionListener(this);
        this.formInv
            .getBtnVerExistenciasProd()
            .addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formInv.getBtnVerExistenciasProd()) {
            verExistenciaProd();
        } else if (e.getSource() == formInv.getBtnAddProductos()) {
            agregarProductos();
        }
    }

    public void verExistenciaProd() {
        if (productoExistencias.cantidad() == 0)
            JOptionPane.showMessageDialog(formInv.getRootPane(), "No hay productos en la lista para mostrar.",
                                          "Listado de personas", JOptionPane.WARNING_MESSAGE);
        else {
            JOptionPane.showMessageDialog(formInv.getRootPane(), productoExistencias.toString(),
                                          "Listado de productos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void agregarProductos() {
        int cantidadProductos = 0;
        cantidadProductos =
            Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos productos desea registrar?",
                                                         "Registro De Productos Nuevos", JOptionPane.QUESTION_MESSAGE));
        if (cantidadProductos < 0) {
            cantidadProductos = 4;
        }
   
        ControlProducto controlProd = new ControlProducto(cantidadProductos);
        controlProd.iniciar();
    }

    public void iniciar() {
        if (formInv == null) {
            formInv = new FormularioInventario();
            formInv.setVisible(true);
        } else {
            formInv.setVisible(true);
        }
    }


}
