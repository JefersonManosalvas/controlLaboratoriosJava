/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prvisual.controllaboratorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Jefferson
 */
public class coneccionArchivos {
    
    private String url = "jdbc:mysql://localhost:3306/acceso_lab?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String usuario = "root";
    private String clave = "j2003";

    public void obtener() {
       
        String rutaArchivo = "C:\\Users\\Jefferson\\Documents\\NetBeansProjects\\controlLaboratorios\\ConexionBdd.txt";

        try {
            File archivo = new File(rutaArchivo);

          
            if (archivo.exists()) {
              
                Properties propiedadesExistentes = new Properties();
                propiedadesExistentes.load(new FileInputStream(archivo));

              
                String urlActual = propiedadesExistentes.getProperty("url");
                String usuarioActual = propiedadesExistentes.getProperty("usuario");
                String contraseniaActual = propiedadesExistentes.getProperty("clave");

               
                if (!url.equals(urlActual) || !usuario.equals(usuarioActual) || !clave.equals(contraseniaActual)) {
                    // Crear objeto Properties
                    Properties conex = new Properties();

                
                    conex.setProperty("url", url);
                    conex.setProperty("usuario", usuario);
                    conex.setProperty("clave", clave);

                   
                    try (FileOutputStream archivoPropiedades = new FileOutputStream(archivo)) {
                        conex.store(archivoPropiedades, "Propiedades de conexión MySQL");
                    }

                    System.out.println("Archivo de propiedades actualizado en: " + rutaArchivo);
                } else {
                    System.out.println("El archivo de propiedades ya está actualizado en: " + rutaArchivo);
                }
            } else {
              
                Properties conex = new Properties();

                
                conex.setProperty("url", url);
                conex.setProperty("usuario", usuario);
                conex.setProperty("clave", clave);

                try (FileOutputStream archivoPropiedades = new FileOutputStream(archivo)) {
                    conex.store(archivoPropiedades, "Propiedades de conexión MySQL");
                }

                System.out.println("Archivo de propiedades creado en: " + rutaArchivo);
            }
        } catch (IOException e) {
            System.out.println("Error al crear o acceder al archivo de propiedades: " + e.getMessage());
        }
    }
    
}
