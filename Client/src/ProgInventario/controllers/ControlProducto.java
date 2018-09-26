package ProgInventario.controllers;

import ProgInventario.entitys.Producto;

import ProgInventario.intergazGraf.FormularioProd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Asistencia.Formulario;


public class ControlProducto implements ActionListener {
    private FormularioProd formulario;
    private Producto producto;
    private int contador;
    private int cantidad;
    private String listaProductos;
    private Producto[] arregloProductos;

    public ControlProducto(int cantidad) {
        this.contador = 0;
        this.cantidad = cantidad;
        this.arregloProductos = new Producto[this.cantidad];
        this.formulario = new FormularioProd();
        this.formulario.setIconImage(new ImageIcon(getClass().getResource("../assets/logo.png")).getImage());
        this.formulario
            .getBtnGuardar()
            .addActionListener(this);
        this.formulario
            .getBtnLimpiar()
            .addActionListener(this);
        this.formulario
            .getBtnVerListaProductos()
            .addActionListener(this);
        this.formulario
            .getLblLimite()
            .setText("de " + cantidad);
    }

    public void iniciar() {
        if (formulario == null) {
            formulario = new FormularioProd();
            formulario.setVisible(true);
        } else {
            formulario.setVisible(true);
        }
    }

    public Producto obtenerProducto() {
        
        producto = new Producto();
        if (validarDatos()) {
            contador++;
            formulario.getLblCantidadProductos().setText(String.valueOf(contador));
            producto.setNumIdentif(Integer.parseInt(formulario.getNumIdentJTF().getText()));
            producto.setNomb(formulario.getNombProductoJTF().getText());
            producto.setNumSerie(Integer.parseInt(formulario.getNumSerieJTF().getText()));
            producto.setValor(Double.parseDouble(formulario.getValorJTF().getText()));
            producto.setNombProv(formulario.getNomProveeJTF().getText());
        }
        return producto;
    }

    public void limpiar() {
        formulario.getNomProveeJTF().setText("");
        formulario.getNombProductoJTF().setText("");
        formulario.getNumIdentJTF().setText("");
        formulario.getNumSerieJTF().setText("");
        formulario.getValorJTF().setText("");
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

    public void verificar() {
        if (contador == cantidad) {
            JOptionPane.showMessageDialog(formulario.getRootPane(), "Se han registrado todos los productos",
                                          "Ha finalizado", JOptionPane.WARNING_MESSAGE);
            listarProductos();
            formulario.dispose();
            formulario = null;
        }
    }

    public boolean validarDatos() {
        boolean valido = true;
        if (formulario.getNumIdentJTF()
                      .getText()
                      .isEmpty()) {
            JOptionPane.showMessageDialog(formulario.getRootPane(), "Se detectado un dato nulo",
                                          "El Número de Identificación es requerido", JOptionPane.WARNING_MESSAGE);
            valido = false;
        }
        return valido;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formulario.getBtnGuardar()) {
            arregloProductos[contador] = obtenerProducto();
            limpiar();
            verificar();
        } else if (e.getSource() == formulario.getBtnLimpiar()) {
            limpiar();
        } else if (e.getSource() == formulario.getBtnVerListaProductos()) {
            listarProductos();

        }
    }
}
