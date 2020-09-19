package modelo.idao;

import java.util.List;
import uml.CuentaUsuario;

public interface ICuentaUsuarioDao {

    public void insertar(CuentaUsuario obj);

    public void eliminar(CuentaUsuario obj);

    public void modificar(CuentaUsuario obj);

    public List<CuentaUsuario> getLista();

    public List<CuentaUsuario> filtrar(String campo, String criterio);
    
    public int validar(String usuario, String clave);

    public int getNumeroRegistros();

}
