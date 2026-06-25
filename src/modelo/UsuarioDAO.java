package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    Connection con;

    public boolean insertar(String nombre, String correo) {

        try {

            con = new Conexion().conectar();

            String sql = "INSERT INTO usuarios(nombre, correo) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, correo);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error insertar: " + e.getMessage());
            return false;
        }
    }

    public ResultSet consultar() {

        try {

            con = new Conexion().conectar();

            String sql = "SELECT * FROM usuarios";

            PreparedStatement ps = con.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            System.out.println("Error consultar: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizar(int id, String nombre, String correo) {

        try {

            con = new Conexion().conectar();

            String sql = "UPDATE usuarios SET nombre=?, correo=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, id);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {

        try {

            con = new Conexion().conectar();

            String sql = "DELETE FROM usuarios WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error eliminar: " + e.getMessage());
            return false;
        }
    }
}