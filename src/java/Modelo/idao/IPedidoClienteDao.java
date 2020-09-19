package modelo.idao;

import java.util.List;
import uml.PedidoCliente;

public interface IPedidoClienteDao {

    public void insertar(PedidoCliente obj);

    public void eliminar(PedidoCliente obj);

    public void modificar(PedidoCliente obj);

    public List<PedidoCliente> getLista();

    public List<PedidoCliente> filtrar(String campo, String criterio);

    public int getNumeroRegistros();

}
