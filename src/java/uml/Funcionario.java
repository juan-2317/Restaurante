package uml;

public class Funcionario {

    private int idFuncionario;
    private String nombres;
    private String apellidos;
    private int idCuenta;

    public Funcionario() {
        this.idFuncionario = 0;
        this.nombres = "";
        this.apellidos = "";
        this.idCuenta = 0;
    }

    public Funcionario(int idFuncionario, String nombres, String apellidos, int idCuenta) {
        this.idFuncionario = idFuncionario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idCuenta = idCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
}
