package uml;

public class PedidoCliente {

    private int idProducto;
    private int idCliente;
    private int cantidad;
    private String fecha;

    public PedidoCliente() {
        this.idProducto = 0;
        this.idCliente = 0;
        this.cantidad = 0;
        this.fecha = "";
    }

    public PedidoCliente(int idProducto, int idCliente, int cantidad, String fecha) {
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }
}
