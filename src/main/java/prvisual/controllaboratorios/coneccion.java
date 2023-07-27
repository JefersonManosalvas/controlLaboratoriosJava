/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prvisual.controllaboratorios;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jefferson
 */
public class coneccion {
    
    public ResultSet EjecutaSql(String sql) {
        ResultSet resultado = null;
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\Jefferson\\Documents\\NetBeansProjects\\VentaCelulares\\ConexionBdd.txt");
            props.load(fis);

            // Obtener las propiedades de conexión
            String url = props.getProperty("url");
            String usuario = props.getProperty("usuario");
            String clave = props.getProperty("clave");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, usuario, clave);
            PreparedStatement pst = con.prepareStatement(sql);
            resultado = pst.executeQuery();
        } catch (IOException | SQLException | ClassNotFoundException e) {
        }
        return resultado;
    }
    
}
