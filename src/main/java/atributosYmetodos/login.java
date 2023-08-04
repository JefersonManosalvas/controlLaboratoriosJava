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
//        String user = txtuser.getText();
//        String pass = String.valueOf(txtpssw.getPassword());
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
                // JOptionPane.showMessageDialog(null, "Usuario administrador funcional");
//                Menu1 m1 = new Menu1();
//                m1.setVisible(true);
//                this.dispose();

                admFuncional h1 = new admFuncional();
                h1.setVisible(true);

//                String registro = "usuario=" + user + ", contraseña=" + pass + ", intento = Correcto";
//                guardarRegistro(registro);
            } else if (existe == 2) {

                Nuevo_usuario adj = new Nuevo_usuario();
                adj.setVisible(true);

//}
            } else if (existe == 3) {
                // JOptionPane.showMessageDialog(null, "Usuario docente");

                MenuLaboratorios me = new MenuLaboratorios();
                me.setcedula(usuario);
                me.setVisible(true);

            } else if (existe == 4) {

                // JOptionPane.showMessageDialog(null, "Usuario estudiante");
//                String nombreUsuarios = rs.getString("nombre");
//               String cargoUsuario = rs.getString("rol");
//
//                Registrarse lab = new Registrarse();
//                lab.setDatosUsuario(nombreUsuarios, cargoUsuario);
//                lab.setVisible(true);
//                adminTecnico me= new adminTecnico();
//                me.setVisible(true);
                MenuLaboratorios me = new MenuLaboratorios();
                // JOptionPane.showMessageDialog(null, "Usuario estudiante");
//                rs.getString("nombre");
//                rs.getString("rol");
                me.setcedula(usuario);
                me.setVisible(true);

//               // Puedes asignar directamente el valor
//           // Realizar las acciones necesarias para el usuario estudiante
////             Registrarse ad = new Registrarse();
////            ad.setDatosUsuario(nombreUsuario, cargoUsuario);
////            ad.setVisible(true);
//            
            } else {
                JOptionPane.showMessageDialog(null, "Usuario incorrecto");
//                String registro = "usuario=" + user + ", contraseña=" + pass + ", intento=Incorrecto";
//                guardarRegistro(registro);
            }
        }

    }

}
