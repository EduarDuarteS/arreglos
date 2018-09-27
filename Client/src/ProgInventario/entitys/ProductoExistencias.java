package ProgInventario.entitys;

import java.util.Arrays;

public class ProductoExistencias {

    //intancia estatica de la clase
    private static ProductoExistencias productoExistencias;

    private Producto[] producto;
    private int[] cantidad;


    //singlenton
    // El constructor es privado, no permite que se genere un constructor por defecto.
    private ProductoExistencias() {
        producto = new Producto[10];
        this.cantidad = new int[10];
    }

    //Clase estatica q permite instanciar una sola vez
    public static ProductoExistencias getSingletonInstance(String nombre) {
        if (productoExistencias == null) {
            productoExistencias = new ProductoExistencias();
        } else {
            System.out.println("No se puede instaciar, porque ya existe un objeto de la clase ProductoExistencias");
        }

        return productoExistencias;
    }

    public void setProducto(Producto producto, int pos) {
        this.producto[pos] = producto;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setCantidad(int cantidad, int pos) {
        this.cantidad[pos] = cantidad;
    }

    public int[] getCantidad() {
        return cantidad;
    }

}
