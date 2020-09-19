package modelo.dao;

import conexion.Conexion;
import uml.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.idao.IFuncionarioDao;

public class FuncionarioDaoImpl implements IFuncionarioDao {

    @Override
    public void insertar(Funcionario obj) {
        String sql = "INSERT INTO funcionarios (id_funcionario, nombres,"
                + " apellidos, id_cuenta) VALUES (?, ?, ?, ?)";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdFuncionario());
            stmt.setString(2, obj.getNombres());
            stmt.setString(3, obj.getApellidos());
            stmt.setInt(4, obj.getIdCuenta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void eliminar(Funcionario obj) {
        String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, obj.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public void modificar(Funcionario obj) {
        String sql = "UPDATE funcionarios SET nombres = ?, apellidos = ?,"
                + " id_cuenta = ? WHERE id_funcionario = ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, obj.getNombres());
            stmt.setString(2, obj.getApellidos());
            stmt.setInt(3, obj.getIdCuenta());
            stmt.setInt(4, obj.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
    }

    @Override
    public List<Funcionario> getLista() {
        List<Funcionario> listaFuncionarios = new LinkedList<>();
        String sql = "SELECT * FROM funcionarios";
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Funcionario producto = new Funcionario(rs.getInt("id_funcionario"), rs.getString("nombres"),
                        rs.getString("apellidos"), rs.getInt("id_cuenta"));

                listaFuncionarios.add(producto);
            }

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return listaFuncionarios;
    }

    @Override
    public List<Funcionario> filtrar(String campo, String criterio) {
        List<Funcionario> busqueda = new LinkedList<>();
        String sql = "SELECT * FROM funcionarios WHERE `" + campo + "` LIKE ?";
        Conexion conn = new Conexion();

        try (PreparedStatement stmt = conn.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario producto = new Funcionario(rs.getInt("id_funcionario"),
                        rs.getString("nombres"), rs.getString("apellidos"), rs.getInt("id_cuenta"));

                busqueda.add(producto);
            }

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return busqueda;
    }

    @Override
    public int getNumeroRegistros() {
        String sql = "SELECT COUNT(*) FROM funcionarios";
        int cantidadFilas = -1;
        Conexion conn = new Conexion();

        try (Statement st = conn.getConnection().createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cantidadFilas = rs.getInt(1);

        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        conn.desconectar();
        return cantidadFilas;
    }
}
