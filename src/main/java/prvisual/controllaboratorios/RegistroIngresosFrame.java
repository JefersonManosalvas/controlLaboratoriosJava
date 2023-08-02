 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prvisual.controllaboratorios;

/**
 *
 * @author SAID
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroIngresosFrame extends JFrame {
    private JComboBox<String> laboratorioComboBox;
    private JComboBox<String> materiaComboBox;
    private JComboBox<String> horarioComboBox;

    public RegistroIngresosFrame() {
        setTitle("Registro de Ingresos a Laboratorios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear JComboBox para seleccionar el laboratorio
        laboratorioComboBox = new JComboBox<>();
        laboratorioComboBox.addItem("Laboratorio 1");
        laboratorioComboBox.addItem("Laboratorio 2");
        // Agregar más laboratorios según la lista de laboratorios disponibles en la base de datos

        // Crear JComboBox para seleccionar la materia o actividad
        materiaComboBox = new JComboBox<>();
        materiaComboBox.addItem("Física");
        materiaComboBox.addItem("Química");
        // Agregar más materias según la lista de materias disponibles en la base de datos

        // Crear JComboBox para seleccionar el horario
        horarioComboBox = new JComboBox<>();
        horarioComboBox.addItem("08:00 - 10:00");
        horarioComboBox.addItem("10:00 - 12:00");
        // Agregar más horarios según la lista de horarios disponibles en la base de datos

        // Panel para los campos de registro y botón de guardar
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("Laboratorio:"));
        formPanel.add(laboratorioComboBox);
        formPanel.add(new JLabel("Materia:"));
        formPanel.add(materiaComboBox);
        formPanel.add(new JLabel("Horario:"));
        formPanel.add(horarioComboBox);
        add(formPanel, BorderLayout.CENTER);

        // Botón para registrar el ingreso
        JButton registrarButton = new JButton("Registrar Ingreso");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String laboratorioSeleccionado = (String) laboratorioComboBox.getSelectedItem();
                String materiaSeleccionada = (String) materiaComboBox.getSelectedItem();
                String horarioSeleccionado = (String) horarioComboBox.getSelectedItem();

                // Validar que se haya seleccionado un laboratorio, materia y horario
                if (laboratorioSeleccionado != null && materiaSeleccionada != null && horarioSeleccionado != null) {
                    // Guardar los datos en la base de datos o realizar las acciones necesarias para registrar el ingreso

                    // Mostrar mensaje de confirmación
                    JOptionPane.showMessageDialog(RegistroIngresosFrame.this,
                            "Ingreso registrado correctamente.",
                            "Registro Exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(RegistroIngresosFrame.this,
                            "Por favor, selecciona el laboratorio, la materia y el horario.",
                            "Campos Incompletos",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(registrarButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegistroIngresosFrame frame = new RegistroIngresosFrame();
                frame.setVisible(true);
            }
        });
    }
}