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

public class GestionLaboratoriosFrame extends JFrame {
    private JTable laboratoriosTable;
    private DefaultTableModel tableModel;
    private JTextField nombreTextField;
    private JTextField ubicacionTextField;

    public GestionLaboratoriosFrame() {
        setTitle("Gestión de Laboratorios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear la tabla para mostrar los laboratorios
        String[] columnNames = {"ID", "Nombre", "Ubicación"};
        tableModel = new DefaultTableModel(columnNames, 0);
        laboratoriosTable = new JTable(tableModel);

        // Agregar la tabla en un JScrollPane para que tenga scroll si hay muchos laboratorios
        JScrollPane scrollPane = new JScrollPane(laboratoriosTable);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los campos de nombre, ubicación y botones de agregar/editar
        JPanel formPanel = new JPanel(new GridLayout(2, 2));
        nombreTextField = new JTextField();
        ubicacionTextField = new JTextField();
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreTextField);
        formPanel.add(new JLabel("Ubicación:"));
        formPanel.add(ubicacionTextField);
        add(formPanel, BorderLayout.NORTH);

        // Botones para agregar y editar laboratorios
        JButton agregarButton = new JButton("Agregar");
        JButton editarButton = new JButton("Editar");
        formPanel.add(agregarButton);
        formPanel.add(editarButton);

        // Botón para eliminar laboratorios seleccionados en la tabla
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = laboratoriosTable.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });
        add(eliminarButton, BorderLayout.SOUTH);

        // Manejador para agregar laboratorios
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String ubicacion = ubicacionTextField.getText();

                // Validar que se hayan ingresado datos
                if (!nombre.isEmpty() && !ubicacion.isEmpty()) {
                    // Agregar el nuevo laboratorio a la tabla
                    Object[] rowData = {tableModel.getRowCount() + 1, nombre, ubicacion};
                    tableModel.addRow(rowData);

                    // Limpiar los campos de texto después de agregar
                    nombreTextField.setText("");
                    ubicacionTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(GestionLaboratoriosFrame.this,
                            "Por favor, ingresa el nombre y la ubicación del laboratorio.",
                            "Campos vacíos",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Manejador para editar laboratorios
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = laboratoriosTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String nombre = nombreTextField.getText();
                    String ubicacion = ubicacionTextField.getText();

                    // Validar que se hayan ingresado datos
                    if (!nombre.isEmpty() && !ubicacion.isEmpty()) {
                        // Actualizar los datos del laboratorio seleccionado en la tabla
                        laboratoriosTable.setValueAt(nombre, selectedRow, 1);
                        laboratoriosTable.setValueAt(ubicacion, selectedRow, 2);

                        // Limpiar los campos de texto después de editar
                        nombreTextField.setText("");
                        ubicacionTextField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(GestionLaboratoriosFrame.this,
                                "Por favor, ingresa el nombre y la ubicación del laboratorio.",
                                "Campos vacíos",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(GestionLaboratoriosFrame.this,
                            "Selecciona un laboratorio de la tabla para editar.",
                            "Ningún laboratorio seleccionado",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GestionLaboratoriosFrame frame = new GestionLaboratoriosFrame();
                frame.setVisible(true);
            }
        });
    }
}