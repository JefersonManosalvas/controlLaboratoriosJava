/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import prvisual.controllaboratorios.Coneccion;

/**
 *
 * @author Jefferson
 */
public class LoginControlador {

    public boolean logear(Login log) throws ClassNotFoundException {

        String correo = log.getCorreo();
        String clave = log.getContrasenia();

        boolean respuesta = false;
        Coneccion c = new Coneccion();
        String sql = " call acceso_lab.login(1, '"+correo+"', '"+clave+"');";
        
        System.out.println("--"+sql);

        try {

            ResultSet rs = c.EjecutaSql(sql);
            if (rs.next()) {
                respuesta = true;
                
                JOptionPane.showMessageDialog(null, "usuario correocto");
//                Menu m = new Menu();
//                m.show();
                        
            }else{
                JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
            
        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respuesta;
    }
}
