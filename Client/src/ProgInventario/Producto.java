package ProgInventario;

public class Producto {


    // Contructores
    public Producto() {
    }
    public Producto(int numIdentif, String nomb, int numSerie, double valor, String nombProv) {
        this.numIdentif=numIdentif;
        this.nomb=nomb;
        this.numSerie = numSerie;
        this.valor=valor;
        this.nombProv=nombProv;
    }

    private int numIdentif;
    private String nomb;
    private int numSerie; //opcional
    private double valor;
    private String nombProv; //nombre del proveedor

    public void setNumIdentif(int numIdentif) {
        this.numIdentif = numIdentif;
    }

    public int getNumIdentif() {
        return numIdentif;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setNombProv(String nombProv) {
        this.nombProv = nombProv;
    }

    public String getNombProv() {
        return nombProv;
    }

}
