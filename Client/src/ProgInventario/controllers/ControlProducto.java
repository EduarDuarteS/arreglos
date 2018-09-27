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
    private FormularioProd formProd;
    private Producto producto;
    private int contador;
    private int cantidad;
    private String listaProductos;
    private Producto[] arregloProductos;

    public ControlProducto(int cantidad) {
        this.contador = 0;
        this.cantidad = cantidad;
        this.arregloProductos = new Producto[this.cantidad];
        this.formProd = new FormularioProd();
        this.formProd.setIconImage(new ImageIcon(getClass().getResource("../assets/logo.png")).getImage());
        this.formProd
            .getBtnGuardar()
            .addActionListener(this);
        this.formProd
            .getBtnLimpiar()
            .addActionListener(this);
        this.formProd
            .getBtnVerListaProductos()
            .addActionListener(this);
        this.formProd
            .getBtnTerminar()
            .addActionListener(this);
        this.formProd
            .getLblLimite()
            .setText("de " + cantidad);
    }

    public void iniciar() {
        if (formProd == null) {
            formProd = new FormularioProd();
            formProd.setVisible(true);
        } else {
            formProd.setVisible(true);
        }
    }

    public Producto obtenerProducto() {

        producto = new Producto();
        if (validarDatos()) {
            contador++;
            formProd.getLblCantidadProductos().setText(String.valueOf(contador));
            producto.setNumIdentif(Integer.parseInt(formProd.getNumIdentJTF().getText()));
            producto.setNomb(formProd.getNombProductoJTF().getText());
            producto.setNumSerie(Integer.parseInt(formProd.getNumSerieJTF().getText()));
            producto.setValor(Double.parseDouble(formProd.getValorJTF().getText()));
            producto.setNombProv(formProd.getNomProveeJTF().getText());
        }
        return producto;
    }

    public void limpiar() {
        formProd.getNomProveeJTF().setText("");
        formProd.getNombProductoJTF().setText("");
        formProd.getNumIdentJTF().setText("");
        formProd.getNumSerieJTF().setText("");
        formProd.getValorJTF().setText("");
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
            JOptionPane.showMessageDialog(formProd.getRootPane(), "No hay productos en la lista para mostrar.",
                                          "Listado de personas", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(formProd.getRootPane(), listaProductos, "Listado de productos",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void verificar() {
        if (contador == cantidad) {
            JOptionPane.showMessageDialog(formProd.getRootPane(), "Se han registrado todos los productos",
                                          "Ha finalizado", JOptionPane.WARNING_MESSAGE);
            listarProductos();
            formProd.dispose();
            formProd = null;
        }
    }

    public boolean validarDatos() {
        boolean valido = true;
        if (formProd.getNumIdentJTF()
                    .getText()
                    .isEmpty()) {
            JOptionPane.showMessageDialog(formProd.getRootPane(), "Se detectado un dato nulo",
                                          "El Número de Identificación es requerido", JOptionPane.WARNING_MESSAGE);
            valido = false;
        }
        return valido;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formProd.getBtnGuardar()) {
            arregloProductos[contador] = obtenerProducto();
            limpiar();
            verificar();
        } else if (e.getSource() == formProd.getBtnLimpiar()) {
            limpiar();
        } else if (e.getSource() == formProd.getBtnVerListaProductos()) {
            listarProductos();

        } else if (e.getSource() == formProd.getBtnTerminar()) {
            formProd.dispose();
            System.out.println("ent");
        }
    }
}
