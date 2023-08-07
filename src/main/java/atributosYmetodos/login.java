/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atributosYmetodos;

import conecxion.conMysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.MenuLaboratorios;
import vista.admFuncional;

import prvisual.controllaboratorios.Nuevo_usuario;

/**
 *
 * @author Jefferson
 */
public class login {

    private String usuario;
    private String contrasenia;
    private String rol;
    private String nombreUsuario;
    private String cargoUsuario;
//    
//    public login(){
//        
//    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCargoUsuario() {
        return cargoUsuario;
    }

    public void setCargoUsuario(String cargoUsuario) {
        this.cargoUsuario = cargoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void login() throws ClassNotFoundException, SQLException {
        conMysql c1 = new conMysql();
        boolean respuesta = false;
        String con = "call acceso_lab.verificarLogin1('" + getUsuario() + "','" + getContrasenia() + "');";
        System.out.println("///" + con);

        ResultSet rs = c1.EjecutaSql(con);

        if (getUsuario().isEmpty()) {

            JOptionPane.showMessageDialog(null, "INGRESE EL USUARIO");
        } else if (getContrasenia().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESE LA CONTRASEÑA");
        } else if (rs.next()) {
            int existe = rs.getInt("result");
            if (existe == 1) {
                admFuncional h1 = new admFuncional();
                h1.setVisible(true);

            } else if (existe == 2) {

                Nuevo_usuario adj = new Nuevo_usuario();
                adj.setVisible(true);

            } else if (existe == 3) {

                MenuLaboratorios me = new MenuLaboratorios();
                me.setcedula(usuario);
                me.setVisible(true);

                
                
            } else if (existe == 4) {
                MenuLaboratorios me = new MenuLaboratorios();

                me.setcedula(usuario);
                me.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario incorrecto");
            }
        }

    }

}
