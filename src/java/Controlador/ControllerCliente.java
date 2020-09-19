package controlador;

import java.util.List;
import modelo.dao.ClienteDaoImpl;
import uml.Cliente;
import modelo.idao.IClienteDao;

public class ControllerCliente {

    public List<Cliente> getLista() {
        IClienteDao dao = new ClienteDaoImpl();
        List<Cliente> clientes = dao.getLista();
        return clientes;
    }
}
