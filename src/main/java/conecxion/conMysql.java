/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conecxion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jefferson
 */
public class conMysql {

    private String url = "jdbc:mysql://localhost:3306/accesolab?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String usuario = "root";
    private String clave = "root";

    public ResultSet EjecutaSql(String sql) throws ClassNotFoundException {
        ResultSet resultado = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, usuario, clave);
            PreparedStatement pst = con.prepareStatement(sql);
            resultado = pst.executeQuery();
           // con.close();
            return resultado;
        } catch (SQLException e) {
            return resultado;
        }

    }
    
    
    public void EjecutaSqlIUD(String sql) throws ClassNotFoundException {
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, usuario, clave);
            PreparedStatement pst = con.prepareStatement(sql);
           // con.close();
            pst.execute();
           } catch (SQLException e) {
            
        }
   
    
}
}
