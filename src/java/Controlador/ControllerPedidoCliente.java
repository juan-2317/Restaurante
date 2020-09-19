package controlador;

import java.util.List;
import modelo.dao.PedidoClienteDaoImpl;
import uml.PedidoCliente;
import modelo.idao.IPedidoClienteDao;

public class ControllerPedidoCliente {

    public List<PedidoCliente> getLista() {
        IPedidoClienteDao dao = new PedidoClienteDaoImpl();
        List<PedidoCliente> pedClientes = dao.getLista();
        return pedClientes;
    }
}
