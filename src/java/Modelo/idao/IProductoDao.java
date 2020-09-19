package modelo.idao;

import java.util.List;
import uml.Producto;

public interface IProductoDao {

    public void insertar(Producto obj);

    public void eliminar(Producto obj);

    public void modificar(Producto obj);

    public List<Producto> getLista();

    public List<Producto> filtrar(String campo, String criterio);

    public int getNumeroRegistros();

}
