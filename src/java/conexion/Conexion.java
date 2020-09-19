package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static String usuario = "root";
    private static String clave = "";
    private static String bbdd = "restaurante";
    private static String url = "jdbc:mysql://localhost/" + bbdd;
    private Connection conexion;

    public Conexion() {
        conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException ec) {
            System.err.println("classnotfound");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ec);
        } catch (SQLException es) {
            System.err.println("Error de enlace canal");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
