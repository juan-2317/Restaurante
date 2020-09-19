package modelo.dao;

import conexion.Conexion;
import uml.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.idao.IClienteDao;

public class ClienteDaoImpl implements IClienteDao {

    @Override
    public void insertar(Cliente obj) {
        String sql = "INSERT INTO clientes (id_cliente, nombres, apellidos,"
                + " id_funcionario) VALUES (?, ?, ?, ?)";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdCliente());
            stmt.setString(2, obj.getNombres());
            stmt.setString(3, obj.getApellidos());
            stmt.setInt(4, obj.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void eliminar(Cliente obj) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void modificar(Cliente obj) {
        String sql = "UPDATE clientes SET nombres = ?, apellidos = ?, id_funcionario = ? WHERE id_cliente = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, obj.getNombres());
            stmt.setString(2, obj.getApellidos());
            stmt.setInt(3, obj.getIdFuncionario());
            stmt.setInt(4, obj.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public List<Cliente> getLista() {
        List<Cliente> listaClientes = new LinkedList<>();
        String sql = "SELECT * FROM clientes";
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombres"),
                        rs.getString("apellidos"), rs.getInt("id_funcionario"));

                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return listaClientes;
    }

    @Override
    public List<Cliente> filtrar(String campo, String criterio) {
        List<Cliente> busqueda = new LinkedList<>();
        String sql = "SELECT * FROM clientes WHERE `" + campo + "` LIKE ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombres"),
                        rs.getString("apellidos"), rs.getInt("id_funcionario"));

                busqueda.add(cliente);
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return busqueda;
    }

    @Override
    public int getNumeroRegistros() {
        String sql = "SELECT COUNT(*) FROM clientes";
        int cantidadFilas = -1;
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cantidadFilas = rs.getInt(1);

        } catch (SQLException e) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return cantidadFilas;
    }
}
