package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;

    public Connection conectar() {

        try {

            String url = "jdbc:mysql://localhost:3306/landingdb";
            String usuario = "root";
            String clave = "";

            con = DriverManager.getConnection(url, usuario, clave);

            System.out.println("Conexion exitosa");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }
}