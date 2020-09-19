package controlador;

import java.util.List;
import modelo.dao.FuncionarioDaoImpl;
import uml.Funcionario;
import modelo.idao.IFuncionarioDao;

public class ControllerFuncionario {

    public List<Funcionario> getLista() {
        IFuncionarioDao dao = new FuncionarioDaoImpl();
        List<Funcionario> funcionarios = dao.getLista();
        return funcionarios;
    }
}
