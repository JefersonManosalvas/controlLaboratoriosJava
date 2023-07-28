/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prvisual.controllaboratorios;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jefferson
 */
public class consulta {
    
    public static void main(String[] args) throws ClassNotFoundException {
        Coneccion  con = new Coneccion();
        ResultSet resultado = con.EjecutaSql("SELECT * FROM login");
        try {
            while (resultado.next()) {
                System.out.println(resultado.getString(1)+" "+resultado.getString(2)+" "+resultado.getString(3)+" "+resultado.getString(4));
                
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONSULTA");
        }

    }
    
}
