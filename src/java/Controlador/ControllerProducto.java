package controlador;

import java.util.List;
import modelo.dao.ProductoDaoImpl;
import uml.Producto;
import modelo.idao.IProductoDao;

public class ControllerProducto {

    public List<Producto> getLista() {
        IProductoDao dao = new ProductoDaoImpl();
        List<Producto> productos = dao.getLista();
        return productos;
    }
}
