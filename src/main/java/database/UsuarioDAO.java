package database;

import config.DBConn;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {

    public Connection connection;
    private String tabla = "usuarios";

    public UsuarioDAO() {
        DBConn conn = new DBConn();
        String DB = "codo";
        String userDB = "root";
        String passDB = "sabrinakilian1";
        connection = conn.getConnection(DB, userDB, passDB);
    }

    public List<Usuario> getAllUsers(String tableName) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<Usuario> listUser = new ArrayList<>();

        String sql = "SELECT * FROM " + tableName;
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String name = rs.getString("name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");

            listUser.add(new Usuario(id, username, password, name, last_name, email));
        }

        return listUser;
    }

    public Usuario getUserById(int idUser) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Usuario u = null;

        ps = connection.prepareStatement("SELECT * FROM " + tabla + " WHERE id = ?");
        ps.setInt(1, idUser);

        rs = ps.executeQuery();

        if (rs.next()) {
            Integer id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String name = rs.getString("name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");

            u = new Usuario(id, username, password, name, last_name, email);
        }
        return u;
    }

    public int createUser(Usuario u) throws SQLException {
        PreparedStatement ps;
        int lineasAfectadas;

        String pQuery = "INSERT INTO " + tabla + "(username, password, name, last_name, email)"
                + " VALUES(?, ?, ?, ?, ?);";
        ps = connection.prepareStatement(pQuery);

        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getName());
        ps.setString(4, u.getLast_name());
        ps.setString(5, u.getEmail());

        lineasAfectadas = ps.executeUpdate();
        return lineasAfectadas;
    }

    public int updateUser(Usuario u) throws SQLException {
        PreparedStatement ps;
        int lineasAfectadas;

        String pQuery = "UPDATE " + tabla + " SET username = ?, password = ?, name = ?, last_name = ?, email = ?"
                + " WHERE id = ?;";
        ps = connection.prepareStatement(pQuery);

        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getName());
        ps.setString(4, u.getLast_name());
        ps.setString(5, u.getEmail());
        ps.setInt(6, u.getId());

        lineasAfectadas = ps.executeUpdate();
        return lineasAfectadas;
    }

    public int deleteUser(int userId) throws SQLException {
        PreparedStatement ps;
        int lineasAfectadas;

        String pQuery = "DELETE FROM " + tabla + " WHERE id = ?;";
        ps = connection.prepareStatement(pQuery);

        ps.setInt(1, userId);

        lineasAfectadas = ps.executeUpdate();
        return lineasAfectadas;
    }


}
