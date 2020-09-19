package uml;

public class Producto {

    private int idProducto;
    private String nomProducto;
    private int valor;

    public Producto() {
        this.idProducto = 0;
        this.nomProducto = "";
        this.valor = 0;
    }

    public Producto(int idProducto, String nomProducto, int valor) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.valor = valor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public int getValor() {
        return valor;
    }
}
