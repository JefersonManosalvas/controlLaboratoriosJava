/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
  import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author Jefferson
 */
public class diasSEmana {
    
  


    public static void main(String[] args) {
        // Obtenemos una instancia de LocalDate con la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        // Obtenemos el día de la semana como un objeto DayOfWeek
        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        
        // Convertimos el objeto DayOfWeek a nombre del día de la semana
        String nombreDiaSemana = diaSemana.getDisplayName(TextStyle.FULL, Locale.getDefault());
        
        System.out.println("Hoy es: " + nombreDiaSemana);
    }

    
}
