package modelo.idao;

import java.util.List;
import uml.Cliente;

public interface IClienteDao {

    public void insertar(Cliente obj);

    public void eliminar(Cliente obj);

    public void modificar(Cliente obj);

    public List<Cliente> getLista();

    public List<Cliente> filtrar(String campo, String criterio);

    public int getNumeroRegistros();

}
