package uml;

public class CuentaUsuario {

    private int idCuenta;
    private String nombreUsuario;
    private String clave;
    private int nivel;

    public CuentaUsuario() {
        this.idCuenta = 0;
        this.nombreUsuario = "";
        this.clave = "";
        this.nivel = 0;
    }

    public CuentaUsuario(int idCuenta, String nombreUsuario, String clave, int nivel) {
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nivel = nivel;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public int getNivel() {
        return nivel;
    }
}
