package ProgInventario.controllers;

import ProgInventario.entitys.Producto;

import ProgInventario.intergazGraf.FormularioProd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Asistencia.Formulario;

import ProgInventario.entitys.ProductoExistencias;

import ProgInventario.intergazGraf.FormularioModProd;


public class ControlModProd implements ActionListener {
    private FormularioModProd formModProd;
    private Producto producto, prodMod;
    private int contador;
    private int cantidad;
    private String listaProductos;
    //  private Producto[] arregloProductos;

    public ControlModProd(Producto prodMod) {
        this.prodMod = prodMod;
        this.contador = 0;
        this.formModProd = new FormularioModProd(prodMod);
        this.formModProd.setIconImage(new ImageIcon(getClass().getResource("../assets/logo.png")).getImage());
        this.formModProd
            .getBtnModificar()
            .addActionListener(this);
        this.formModProd
            .getBtnLimpiar()
            .addActionListener(this);

    }

    public void iniciar() {
        if (formModProd == null) {
            formModProd = new FormularioModProd(prodMod);
            formModProd.setVisible(true);
        } else {
            formModProd.setVisible(true);
        }
    }

    public Producto obtenerProducto() {

        producto = new Producto();
        if (validarDatos()) {
            contador++;
            producto.setNumIdentif(Integer.parseInt(formModProd.getNumIdentJTF().getText()));
            producto.setNomb(formModProd.getNombProductoJTF().getText());
            producto.setNumSerie(Integer.parseInt(formModProd.getNumSerieJTF().getText()));
            producto.setValor(Double.parseDouble(formModProd.getValorJTF().getText()));
            producto.setNombProv(formModProd.getNomProveeJTF().getText());
        }
        return producto;
    }

    public void limpiar() {
        formModProd.getNomProveeJTF().setText("");
        formModProd.getNombProductoJTF().setText("");
        formModProd.getNumSerieJTF().setText("");
        formModProd.getValorJTF().setText("");
    }


    public boolean validarDatos() {
        boolean valido = true;
        if (formModProd.getNumIdentJTF()
                       .getText()
                       .isEmpty()) {
            JOptionPane.showMessageDialog(formModProd.getRootPane(), "Se detectado un dato nulo",
                                          "El Número de Identificación es requerido", JOptionPane.WARNING_MESSAGE);
            valido = false;
        }
        return valido;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formModProd.getBtnLimpiar()) {
            limpiar();
        }

        if (e.getSource() == formModProd.getBtnModificar()) {
            Producto prodTem;
            prodTem = obtenerProducto();
            ProductoExistencias pe = ProductoExistencias.getSingletonInstance();
            if (pe.ModificarProd(prodMod.getNumIdentif(), prodTem))
                JOptionPane.showMessageDialog(formModProd.getRootPane(),
                                              "La producto: " + prodMod.getNumIdentif() + " Se modifico exitosamente",
                                              "Producto Modificado", JOptionPane.INFORMATION_MESSAGE);
            formModProd.dispose();
            formModProd = null;
        }

    }
}

