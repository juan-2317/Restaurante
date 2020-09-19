package uml;

public class Cliente {

    private int idCliente;
    private String nombres;
    private String apellidos;
    private int idFuncionario;

    public Cliente() {
        this.idCliente = 0;
        this.nombres = "";
        this.apellidos = "";
        this.idFuncionario = 0;
    }

    public Cliente(int idCliente, String nombres, String apellidos, int idFuncionario) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
}
