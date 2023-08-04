/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prvisual.controllaboratorios;

import conecxion.conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAID
 */
public class GestionLaboratorios extends javax.swing.JFrame {

    conexion cn = new conexion();
    Connection con = cn.conectar();
    private int idLaboratorio;
    private DefaultTableModel tableModel;
    
    
    public GestionLaboratorios() {
        initComponents();
        this.mostrarLaboratoriosEnTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_laboratorios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_ubicacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_laboratorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb_laboratorios);

        jLabel1.setText("NOMBRE");

        jLabel2.setText("UBICACION DE DONDE QUEDA EL LAB");

        jLabel3.setText("INGRESAR LABORATORIOS");

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(90, 90, 90)
                                .addComponent(jButton2)
                                .addGap(63, 63, 63)
                                .addComponent(jButton3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(128, 128, 128)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    

   
try {
    if (con != null && !con.isClosed()) {
        String nombreLaboratorio = txt_nombre.getText();
        String consultaExistencia = "SELECT COUNT(*) FROM laboratorios WHERE nombre = ?";
        PreparedStatement psExistencia = con.prepareStatement(consultaExistencia);
        psExistencia.setString(1, nombreLaboratorio);

        ResultSet rsExistencia = psExistencia.executeQuery();
        rsExistencia.next();
        int count = rsExistencia.getInt(1);

        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Ya existe un laboratorio con ese nombre. Intente con otro nombre.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `laboratorios` (nombre, ubicacion) VALUES (?, ?)");
            ps.setString(1, nombreLaboratorio);
            ps.setString(2, txt_ubicacion.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos registrados");
            this.limpiar();

            ps.close();
        }

        psExistencia.close();
        rsExistencia.close();
    } else {
        JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
    }
} catch (SQLException e) {
    System.out.println("Error: " + e);
}
        

        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        
        
         if (idLaboratorio != -1) {
        try {
            String nombre = txt_nombre.getText();
            String ubicacion = txt_ubicacion.getText();

            // Verificar que se haya seleccionado un laboratorio
            if (nombre.isEmpty() || ubicacion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos antes de actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "UPDATE laboratorios SET nombre = ?, ubicacion = ? WHERE idLaboratorio = ?");
                pst.setString(1, nombre);
                pst.setString(2, ubicacion);
                pst.setInt(3, idLaboratorio);

                int resultado = pst.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    mostrarLaboratoriosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el laboratorio: " + e);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un laboratorio de la tabla para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      try {
    if (con != null && !con.isClosed()) {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este laboratorio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            // Verificar si se ha seleccionado un laboratorio en la tabla
            if (idLaboratorio != -1) {
                PreparedStatement ps = con  .prepareStatement("DELETE FROM laboratorios WHERE idLaboratorio = ?");
                ps.setInt(1, idLaboratorio);

                int resultado = ps.executeUpdate();
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Laboratorio eliminado correctamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    mostrarLaboratoriosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el laboratorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un laboratorio de la tabla para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
    }
} catch (SQLException e) {
    System.out.println("Error: " + e);
}
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionLaboratorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tb_laboratorios;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ubicacion;
    // End of variables declaration//GEN-END:variables

public void limpiar(){

txt_nombre.setText("");
txt_ubicacion.setText("");

}

private void mostrarLaboratoriosEnTabla() {
    
    try {
        if (con != null && !con.isClosed()) {
            String consulta = "SELECT * FROM laboratorios";
            PreparedStatement ps = con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            if (tableModel == null) {
                tableModel = new DefaultTableModel();
                tableModel.addColumn("ID");
                tableModel.addColumn("Nombre");
                tableModel.addColumn("Ubicación");

                tb_laboratorios.setModel(tableModel);
            }

            tableModel.setRowCount(0);

            while (rs.next()) {
                int idLaboratorio = rs.getInt("idLaboratorio");
                String nombre = rs.getString("nombre");
                String ubicacion = rs.getString("ubicacion");

                Object[] rowData = {idLaboratorio, nombre, ubicacion};

                tableModel.addRow(rowData);
            }

            rs.close();
            ps.close();
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e);
    }
    tb_laboratorios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tb_laboratorios.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if (fila_point > -1) {
                    idLaboratorio = (int) tableModel.getValueAt(fila_point, columna_point);
                    EnviarDatosClienteSeleccionado(idLaboratorio);//metodo
                }
            }
        });
        
    
}



private void EnviarDatosClienteSeleccionado(int idLaboratorio) {
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from laboratorios where idLaboratorio = '" + idLaboratorio + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_ubicacion.setText(rs.getString("ubicacion"));
          
               
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar Usuario: " + e);
        }
    }


}
