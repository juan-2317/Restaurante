package modelo.idao;

import java.util.List;
import uml.Funcionario;

public interface IFuncionarioDao {

    public void insertar(Funcionario obj);

    public void eliminar(Funcionario obj);

    public void modificar(Funcionario obj);

    public List<Funcionario> getLista();

    public List<Funcionario> filtrar(String campo, String criterio);

    public int getNumeroRegistros();

}
