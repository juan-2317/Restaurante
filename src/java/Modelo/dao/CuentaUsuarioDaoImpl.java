package modelo.dao;

import conexion.Conexion;
import uml.CuentaUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.idao.ICuentaUsuarioDao;

public class CuentaUsuarioDaoImpl implements ICuentaUsuarioDao {

    @Override
    public void insertar(CuentaUsuario obj) {
        String sql = "INSERT INTO cuentas_usuario (id_cuenta,"
                + " nombre_usuario, clave, nivel) VALUES (?, ?, ?, ?)";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdCuenta());
            stmt.setString(2, obj.getNombreUsuario());
            stmt.setString(3, obj.getClave());
            stmt.setInt(4, obj.getNivel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CuentaUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void eliminar(CuentaUsuario obj) {
        String sql = "DELETE FROM cuentas_usuario WHERE id_cuenta = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdCuenta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CuentaUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void modificar(CuentaUsuario obj) {
        String sql = "UPDATE cuentas_usuario SET nombre_usuario = ?, clave = ? WHERE id_cuenta = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, obj.getNombreUsuario());
            stmt.setString(2, obj.getClave());
            stmt.setInt(3, obj.getIdCuenta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CuentaUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public List<CuentaUsuario> getLista() {
        List<CuentaUsuario> listaCuentas = new LinkedList<>();
        String sql = "SELECT * FROM cuentas_usuario";
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                CuentaUsuario cuenta = new CuentaUsuario(rs.getInt("id_cuenta"),
                        rs.getString("nombre_usuario"), rs.getString("clave"), rs.getInt("nivel"));

                listaCuentas.add(cuenta);
            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return listaCuentas;
    }

    @Override
    public List<CuentaUsuario> filtrar(String campo, String criterio) {
        List<CuentaUsuario> busqueda = new LinkedList<>();
        String sql = "SELECT * FROM cuentas_usuario WHERE `" + campo + "` LIKE ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CuentaUsuario cuenta = new CuentaUsuario(rs.getInt("id_cuenta"),
                        rs.getString("nombre_usuario"), rs.getString("clave"), rs.getInt("nivel"));

                busqueda.add(cuenta);
            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return busqueda;
    }

    @Override
    public int validar(String usuario, String clave) {
        String sql = "SELECT nivel FROM cuentas_usuario WHERE nombre_usuario = ? and clave = ?";
        int nivel = -1;
        Conexion con = new Conexion();

        try (PreparedStatement pst = con.getConnection().prepareStatement(sql)) { // Preparar consulta
            pst.setString(1, usuario);
            pst.setString(2, clave);

            ResultSet rs = pst.executeQuery(); // Ejecutar consulta
            nivel = rs.next() ? rs.getInt(1) : 0; // Si la consulta no devuelve nada el nivel será cero

        } catch (SQLException e) {
            Logger.getLogger(CuentaUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        con.desconectar();
        return nivel;
    }

    @Override
    public int getNumeroRegistros() {
        String sql = "SELECT COUNT(*) FROM cuentas_usuario";
        int cantidadFilas = -1;
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cantidadFilas = rs.getInt(1);

        } catch (SQLException e) {
            Logger.getLogger(CuentaUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return cantidadFilas;
    }
}
