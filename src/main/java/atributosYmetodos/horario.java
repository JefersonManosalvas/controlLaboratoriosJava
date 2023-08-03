/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atributosYmetodos;

import conecxion.conMysql;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jefferson
 */
public class horario {

    private String materia;
    private String hora_inicio;
    private String hora_fin;
    private String dia_semana;
    private String laboratorio;
    private String cbxlab;
    private String docente;

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getCbxlab() {
        return cbxlab;
    }

    public void setCbxlab(String cbxlab) {
        this.cbxlab = cbxlab;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void registrar_horario() {
        if (getMateria().isEmpty() || getLaboratorio().isEmpty() || getHora_inicio().isEmpty() || getHora_fin().isEmpty() || getDocente().isEmpty() || getDia_semana().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            String insertar = ("call acceso_lab.registro_horarios('" + getMateria() + "', '" + getHora_inicio() + "', '" + getHora_fin() + "', '" + getDia_semana() + "','" + getLaboratorio() + "','" + getDocente() + "');");

            System.out.println("--" + insertar);

            conMysql c1 = new conMysql();

            try {
                c1.EjecutaSql(insertar);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(horario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
   
    

}
