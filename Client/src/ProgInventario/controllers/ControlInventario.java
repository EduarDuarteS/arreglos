package ProgInventario.controllers;


import ProgInventario.intergazGraf.FormularioInventario;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ProgInventario.entitys.*;

import java.awt.event.ActionListener;


public class ControlInventario implements ActionListener {
    private FormularioInventario formulario;
    private Producto producto;
    private int contador;
    private int cantidad;
    private String listaProductos;
    private Producto[] arregloProductos;
    private ProductoExistencias productoExistencias;

    public ControlInventario() {
        //instancia Unica del arreglo de existencias de productos
        iniciar();
        productoExistencias = ProductoExistencias.getSingletonInstance();
        this.formulario
            .getBtnAddProductos()
            .addActionListener(this);
        this.formulario
            .getBtnVerExistenciasProd()
            .addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formulario.getBtnVerExistenciasProd()) {
            verExistenciaProd();
        } else if (e.getSource() == formulario.getBtnAddProductos()) {

        }
    }

    public void verExistenciaProd() {
        System.out.println( productoExistencias.getProducto().size());
        if (productoExistencias.getProducto().size()<=0)
            JOptionPane.showMessageDialog(formulario.getRootPane(), "No hay productos en la lista para mostrar.",
                                          "Listado de personas", JOptionPane.WARNING_MESSAGE);
        else {

        }
    }

    public void listarProductos() {
        listaProductos = "";
        int cant = 0;
        for (Producto p : arregloProductos) {
            if (p != null) {
                listaProductos +=
                    "Producto " + ++cant + ": " + p.getNomb() + " con identificación: " + p.getNumIdentif() +
                    " con valor: " + p.getValor() + "$ con proveedor: " + p.getNombProv() + "\n";
            }
        }

        if (listaProductos == "") {
            JOptionPane.showMessageDialog(formulario.getRootPane(), "No hay productos en la lista para mostrar.",
                                          "Listado de personas", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(formulario.getRootPane(), listaProductos, "Listado de productos",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
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
