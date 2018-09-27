package ProgInventario.entitys;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductoExistencias {

    //intancia estatica de la clase
    private static ProductoExistencias productoExistencias;

    private ArrayList <Producto> producto;
    private ArrayList<Integer> cantidad;


    //singlenton
    // El constructor es privado, no permite que se genere un constructor por defecto.
    private ProductoExistencias() {
        producto = new ArrayList<Producto>();
        this.cantidad = new ArrayList<Integer>();
    }

    //Clase estatica q permite instanciar una sola vez
    public static ProductoExistencias getSingletonInstance() {
        if (productoExistencias == null) {
            productoExistencias = new ProductoExistencias();
        } else {
            System.out.println("No se puede instaciar, porque ya existe un objeto de la clase ProductoExistencias");
        }

        return productoExistencias;
    }


    public void setProducto(ArrayList<Producto> producto) {
        this.producto = producto;
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

}
