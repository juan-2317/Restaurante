package modelo.dao;

import conexion.Conexion;
import uml.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.idao.IProductoDao;

public class ProductoDaoImpl implements IProductoDao {

    @Override
    public void insertar(Producto obj) {
        String sql = "INSERT INTO productos (id_producto, nom_producto,"
                + " valor) VALUES (?, ?, ?)";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdProducto());
            stmt.setString(2, obj.getNomProducto());
            stmt.setInt(3, obj.getValor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void eliminar(Producto obj) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void modificar(Producto obj) {
        String sql = "UPDATE productos SET nom_producto = ?, valor = ? WHERE id_producto = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, obj.getNomProducto());
            stmt.setInt(2, obj.getValor());
            stmt.setInt(3, obj.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public List<Producto> getLista() {
        List<Producto> listaProductos = new LinkedList<>();
        String sql = "SELECT * FROM productos";
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("id_producto"), rs.getString("nom_producto"),
                        rs.getInt("valor"));

                listaProductos.add(producto);
            }

        } catch (SQLException e) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return listaProductos;
    }

    @Override
    public List filtrar(String campo, String criterio) {
        List<Producto> busqueda = new LinkedList<>();
        String sql = "SELECT * FROM productos WHERE `" + campo + "` LIKE ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("id_producto"), rs.getString("nom_producto"),
                        rs.getInt("valor"));

                busqueda.add(producto);
            }

        } catch (SQLException e) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return busqueda;
    }

    @Override
    public int getNumeroRegistros() {
        String sql = "SELECT COUNT(*) FROM productos";
        int cantidadFilas = -1;
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cantidadFilas = rs.getInt(1);

        } catch (SQLException e) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return cantidadFilas;
    }
}
