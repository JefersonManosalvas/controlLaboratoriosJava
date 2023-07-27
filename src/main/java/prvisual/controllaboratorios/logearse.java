/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prvisual.controllaboratorios;

import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jefferson
 */
public class logearse {
    coneccion c1= new coneccion();

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    

    public void guardarDatos() throws SQLException {

        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
//            String sql = "call telefoonos.login('1','" + contrasenia + "','" + nombre + "','" + apellido + "','" + correo + "');";
//            System.out.println("--" + sql);
//
//            try {
//
        JOptionPane.showMessageDialog(null, "se guardo exitosamente.", "Error", JOptionPane.ERROR_MESSAGE);

//               // ResultSet res = c1.EjecutaSql(sql);
//
//                if (res.getMetaData().getColumnName(1).equals("0")) {
//                    JOptionPane.showMessageDialog(null, "calve incorrecta", "Información", JOptionPane.INFORMATION_MESSAGE);
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "el usuario se guardo correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
//
//                }
//
//            } catch (HeadlessException e) {
//                JOptionPane.showMessageDialog(null, "el usuario  no se guardo ", "Información", JOptionPane.ERROR_MESSAGE);
//
//            }
        }
        this.limpiar();

    }

    public void logear() throws ClassNotFoundException {
      
        if (correo.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tiene campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            String consulta = ("call telefoonos.login('2','" + correo + "','" + contrasenia + "','',' ');");
            System.out.println("--" + consulta);
       
            ResultSet rs = c1.EjecutaSql(consulta);

            try {
                if (rs.next()) {

                      JOptionPane.showMessageDialog(null, "Usuario correcto");
//                    Menu p1 = new Menu();
//                    p1.setVisible(true);
//                    this.dispose();

                    LocalDateTime horaIngreso = LocalDateTime.now();
                    System.out.println("Hora de ingreso: " + horaIngreso);

                    String registro = "Usuario ingresoc correcto: " + correo + ", Hora de ingreso: " + horaIngreso;
                    guardarRegistro(registro);

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                    LocalDateTime horaFalla = LocalDateTime.now();
                    System.out.println("Hora de falla: " + horaFalla);

                    String registros = "fallido el ingreso del usuario " + correo + ", Hora de falla: " + horaFalla;

                    guardarRegistro(registros);
                }
            } catch (SQLException ex) {
                Logger.getLogger(logearse.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void guardarRegistro(String registro) {
        try {
            String rutaArchivo = "C:\\Users\\Jefferson\\Desktop\\JAVA PROGRAMS\\3A programacion visual\\loging\\Usuario.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
                writer.write(registro);
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public void limpiar() {

        setNombre(nombre);
        setApellido(apellido);
        setContrasenia(contrasenia);
        setCorreo(correo);

    }

}
