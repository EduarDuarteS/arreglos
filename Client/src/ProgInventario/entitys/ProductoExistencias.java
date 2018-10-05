package ProgInventario.entitys;

import java.util.Arrays;

public class ProductoExistencias {

    //intancia estatica de la clase
    private static ProductoExistencias productoExistencias;

    private Producto[] productoAcumulado;
    private int[] cantidad;
    private Producto[] allProducts;


    //singlenton
    // El constructor es privado, no permite que se genere un constructor por defecto.
    private ProductoExistencias() {
        allProducts = new Producto[0];
        productoAcumulado = new Producto[0];
        cantidad = new int[0];
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

    // Se crea un array de tamaño 0 y redimensionando con cada nuevo producto
    public void addProducto(Producto producto) {
        allProducts = Arrays.copyOf(allProducts, allProducts.length + 1);
        allProducts[allProducts.length - 1] = producto;
        if (!productoExiste(producto)) {
            nuevoProductoAcum(producto);
        }
    }
    // Se Consulta si un producto existe en la lista y se retorna este
    public Producto obtProdLista(int numId) {
        for (Producto prod : allProducts) {
            if (prod.getNumIdentif() == numId) {
                return prod;
            }
        }
        return null;
    }
    
    public boolean ModificarProd(int numId, Producto newProd){
        int cont=0;
        for (Producto prod : allProducts) {
            if (prod.getNumIdentif() == numId) {
                allProducts[cont]=newProd;
                return true;
            }
            cont+=1;
        }
        
        return false;
    }

    //Se elimina el producto indicado de la lista
    public boolean deleteProdLista(int numId) {
        int cont = 0;
        boolean eliminado = false;
        for (Producto prod : allProducts) {
            if (eliminado && cont < allProducts.length-1) {
                allProducts[cont] = allProducts[cont + 1];
            }
            if (prod.getNumIdentif() == numId) {
                allProducts[cont] = null;
                eliminado = true;
            }
            cont += 0;
        }
        if (eliminado)
            allProducts = Arrays.copyOf(allProducts, allProducts.length - 1);
        return eliminado;
    }


    //Si producto ya existe le sumo uno al conteo de
    private boolean productoExiste(Producto productNew) {
        int index = 0;
        for (Producto prodComp : productoAcumulado) {
            if (prodComp.getNomb() == productNew.getNomb() && prodComp.getNumIdentif() == productNew.getNumIdentif()) {
                cantidad[index] = +1;
                return true;
            }
            index += 1;
        }
        return false;
    }

    private void nuevoProductoAcum(Producto newProducto) {
        //Se agrega el nuevo Producto
        productoAcumulado = Arrays.copyOf(productoAcumulado, productoAcumulado.length + 1);
        productoAcumulado[productoAcumulado.length - 1] = newProducto;
        //Se inicia el conteo del mismo en 1
        cantidad = Arrays.copyOf(cantidad, cantidad.length + 1);
        cantidad[cantidad.length - 1] = 1;
    }

    public int cantidad() {
        return allProducts.length;
    }

    @Override
    public String toString() {
        String listProduts = "";
        int index = 0;
        for (Producto prod : allProducts) {
            listProduts +=
                listProduts + " El producto: " + prod.getNomb() + " Con Num Ident: " + prod.getNumIdentif() + "Tiene " +
                cantidad[index] + " Existencias \n";

            index += 1;
        }
        return listProduts;
    }

}
