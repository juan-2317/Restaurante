package modelo.dao;

import conexion.Conexion;
import uml.PedidoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.idao.IPedidoClienteDao;

public class PedidoClienteDaoImpl implements IPedidoClienteDao {

    @Override
    public void insertar(PedidoCliente obj) {
        String sql = "INSERT INTO pedido_clientes (id_producto,"
                + " id_cliente, cantidad, fecha) VALUES (?, ?, ?, ?)";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdProducto());
            stmt.setInt(2, obj.getIdCliente());
            stmt.setInt(3, obj.getCantidad());
            stmt.setString(4, obj.getFecha());
            stmt.executeUpdate(); // Esta consulta devuelve el número de filas afectadas
        } catch (SQLException e) {
            Logger.getLogger(PedidoClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void eliminar(PedidoCliente obj) {
        String sql = "DELETE FROM pedido_clientes WHERE id_producto = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PedidoClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void modificar(PedidoCliente obj) {
        String sql = "UPDATE pedido_clientes SET id_cliente = ?, cantidad = ?,"
                + " fecha = ? WHERE id_producto = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdCliente());
            stmt.setInt(2, obj.getCantidad());
            stmt.setString(3, obj.getFecha());
            stmt.setInt(4, obj.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PedidoClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public List<PedidoCliente> getLista() {
        List<PedidoCliente> listaPedidos = new LinkedList<>();
        String sql = "SELECT * FROM pedido_clientes";
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                PedidoCliente pedido = new PedidoCliente(rs.getInt("id_producto"), rs.getInt("id_cliente"),
                        rs.getInt("cantidad"), rs.getString("fecha"));

                listaPedidos.add(pedido);
            }

        } catch (SQLException e) {
            Logger.getLogger(PedidoClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return listaPedidos;
    }

    @Override
    public List<PedidoCliente> filtrar(String campo, String criterio) {
        List<PedidoCliente> busqueda = new LinkedList<>();
        String sql = "SELECT * FROM pedido_clientes WHERE `" + campo + "` LIKE ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PedidoCliente pedido = new PedidoCliente(rs.getInt("id_producto"),
                        rs.getInt("id_cliente"), rs.getInt("cantidad"), rs.getString("fecha"));

                busqueda.add(pedido);
            }

        } catch (SQLException e) {
            Logger.getLogger(PedidoClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return busqueda;
    }

    @Override
    public int getNumeroRegistros() {
        String sql = "SELECT COUNT(*) FROM pedido_clientes";
        int cantidadFilas = -1;
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cantidadFilas = rs.getInt(1);

        } catch (SQLException e) {
            Logger.getLogger(PedidoClienteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return cantidadFilas;
    }
}
