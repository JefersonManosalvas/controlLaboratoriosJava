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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    	import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestionHorariosFrame extends JFrame {
    private JTable horariosTable;
    private DefaultTableModel tableModel;
    private JTextField materiaTextField;
    private JComboBox<String> diaSemanaComboBox;
    private JTextField horaInicioTextField;
    private JTextField horaFinTextField;

    public GestionHorariosFrame() {
        setTitle("Gestión de Horarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el JTable para mostrar los horarios
        String[] columnNames = {"ID", "Materia", "Día de la Semana", "Hora Inicio", "Hora Fin"};
        tableModel = new DefaultTableModel(columnNames, 0);
        horariosTable = new JTable(tableModel);

        // Agregar el JTable en un JScrollPane para que tenga scroll si hay muchos horarios
        JScrollPane scrollPane = new JScrollPane(horariosTable);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los campos de horario y botones de agregar/editar
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        materiaTextField = new JTextField();
        diaSemanaComboBox = new JComboBox<>(getDiasSemana());
        horaInicioTextField = new JTextField();
        horaFinTextField = new JTextField();
        formPanel.add(new JLabel("Materia:"));
        formPanel.add(materiaTextField);
        formPanel.add(new JLabel("Día de la Semana:"));
        formPanel.add(diaSemanaComboBox);
        formPanel.add(new JLabel("Hora Inicio (HH:mm):"));
        formPanel.add(horaInicioTextField);
        formPanel.add(new JLabel("Hora Fin (HH:mm):"));
        formPanel.add(horaFinTextField);
        add(formPanel, BorderLayout.NORTH);

        // Botones para agregar y editar horarios
        JButton agregarButton = new JButton("Agregar");
        JButton editarButton = new JButton("Editar");
        formPanel.add(agregarButton);
        formPanel.add(editarButton);

        // Manejador para agregar horarios
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String materia = materiaTextField.getText();
                String diaSemana = (String) diaSemanaComboBox.getSelectedItem();
                String horaInicioStr = horaInicioTextField.getText();
                String horaFinStr = horaFinTextField.getText();

                // Validar que se hayan ingresado datos
                if (!materia.isEmpty() && !diaSemana.isEmpty() && !horaInicioStr.isEmpty() && !horaFinStr.isEmpty()) {
                    try {
                        // Convertir las horas a LocalTime (HH:mm)
                        LocalTime horaInicio = LocalTime.parse(horaInicioStr);
                        LocalTime horaFin = LocalTime.parse(horaFinStr);

                        // Validar que la hora de inicio sea anterior a la hora de fin
                        if (horaInicio.isBefore(horaFin)) {
                            // Validar que no haya superposición de horarios
                            if (!haySuperposicionHorarios(diaSemana, horaInicio, horaFin)) {
                                // Agregar el nuevo horario a la tabla
                                Object[] rowData = {tableModel.getRowCount() + 1, materia, diaSemana, horaInicioStr, horaFinStr};
                                tableModel.addRow(rowData);

                                // Limpiar los campos de texto después de agregar
                                materiaTextField.setText("");
                                diaSemanaComboBox.setSelectedIndex(0);
                                horaInicioTextField.setText("");
                                horaFinTextField.setText("");
                            } else {
                                JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                                        "El horario se superpone con otro horario existente.",
                                        "Superposición de Horarios",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                                    "La hora de inicio debe ser anterior a la hora de fin.",
                                    "Horario Inválido",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                                "Por favor, ingresa las horas en el formato HH:mm.",
                                "Formato de Hora Incorrecto",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                            "Por favor, ingresa la materia, el día de la semana y los horarios.",
                            "Campos vacíos",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

            private boolean haySuperposicionHorarios(String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        // Manejador para editar horarios
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = horariosTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String materia = materiaTextField.getText();
                    String diaSemana = (String) diaSemanaComboBox.getSelectedItem();
                    String horaInicioStr = horaInicioTextField.getText();
                    String horaFinStr = horaFinTextField.getText();

                    // Validar que se hayan ingresado

  if (!materia.isEmpty() && !diaSemana.isEmpty() && !horaInicioStr.isEmpty() && !horaFinStr.isEmpty()) {
                        try {
                            // Convertir las horas a LocalTime (HH:mm)
                            LocalTime horaInicio = LocalTime.parse(horaInicioStr);
                            LocalTime horaFin = LocalTime.parse(horaFinStr);

                            // Validar que la hora de inicio sea anterior a la hora de fin
                            if (horaInicio.isBefore(horaFin)) {
                                // Validar que no haya superposición de horarios
                                if (!haySuperposicionHorarios(diaSemana, horaInicio, horaFin, selectedRow)) {
                                    // Actualizar los datos del horario seleccionado en la tabla
                                    horariosTable.setValueAt(materia, selectedRow, 1);
                                    horariosTable.setValueAt(diaSemana, selectedRow, 2);
                                    horariosTable.setValueAt(horaInicioStr, selectedRow, 3);
                                    horariosTable.setValueAt(horaFinStr, selectedRow, 4);

                                    // Limpiar los campos de texto después de editar
                                    materiaTextField.setText("");
                                    diaSemanaComboBox.setSelectedIndex(0);
                                    horaInicioTextField.setText("");
                                    horaFinTextField.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                                            "El horario se superpone con otro horario existente.",
                                            "Superposición de Horarios",
                                            JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                                        "La hora de inicio debe ser anterior a la hora de fin.",
                                        "Horario Inválido",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                                    "Por favor, ingresa las horas en el formato HH:mm.",
                                    "Formato de Hora Incorrecto",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                                "Por favor, ingresa la materia, el día de la semana y los horarios.",
                                "Campos vacíos",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(GestionHorariosFrame.this,
                            "Selecciona un horario de la tabla para editar.",
                            "Ningún horario seleccionado",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private String[] getDiasSemana() {
        // Devolver un array con los días de la semana de lunes a viernes
        return new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
    }

    private boolean haySuperposicionHorarios(String diaSemana, LocalTime horaInicio, LocalTime horaFin, int excludeRow) {
        // Validar si hay superposición con otros horarios en la tabla
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (i != excludeRow) {
                String diaSemanaExistente = (String) tableModel.getValueAt(i, 2);
                LocalTime horaInicioExistente = LocalTime.parse((String) tableModel.getValueAt(i, 3));
                LocalTime horaFinExistente = LocalTime.parse((String) tableModel.getValueAt(i, 4));

                if (diaSemanaExistente.equals(diaSemana) &&
                    ((horaInicio.isAfter(horaInicioExistente) && horaInicio.isBefore(horaFinExistente)) ||
                     (horaFin.isAfter(horaInicioExistente) && horaFin.isBefore(horaFinExistente)) ||
                     (horaInicio.equals(horaInicioExistente) || horaFin.equals(horaFinExistente)))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GestionHorariosFrame frame = new GestionHorariosFrame();
                frame.setVisible(true);
            }
        });
    }
}