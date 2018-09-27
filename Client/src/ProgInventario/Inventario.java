package ProgInventario;

import ProgInventario.controllers.ControlInventario;
import ProgInventario.controllers.ControlProducto;

import javax.swing.JOptionPane;

public class Inventario {
    public static void main(String[] args) {
        int cantidadProductos = 0;
        
        //Ver los productos Ingresados
        
        ControlInventario controlInventario = new ControlInventario();
        controlInventario.iniciar();
            
        
        //Ingresar productos
        /*
        cantidadProductos =
            Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos productos desea registrar?",
                                                         "Registro De Productos Nuevos", JOptionPane.QUESTION_MESSAGE));
        if (cantidadProductos < 0) {
            cantidadProductos = 4;
        }
        ControlProducto controlProd = new ControlProducto(cantidadProductos);
        controlProd.iniciar();
*/
    }
}
