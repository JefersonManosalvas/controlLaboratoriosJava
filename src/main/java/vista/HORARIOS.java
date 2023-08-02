/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import atributosYmetodos.horario;
import conecxion.conMysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jefferson
 */
public final class HORARIOS extends javax.swing.JFrame {

    Map<String, String> labMap = new HashMap<>();

    /**
     * Creates new form HORARIOS
     */
    public HORARIOS() throws ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        cargarDatos();
      
            MOSTRAR_HORARIOS();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtHorafin = new javax.swing.JTextField();
        txtHoraini = new javax.swing.JTextField();
        txtMateria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaconH = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbxlab = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("materia");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jLabel2.setText("hora fin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        jLabel3.setText("dia");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        jLabel4.setText("laboratorio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        jLabel5.setText("hora de inicio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));
        jPanel1.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 100, -1));
        jPanel1.add(txtHorafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 100, -1));
        jPanel1.add(txtHoraini, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 100, -1));
        jPanel1.add(txtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 100, -1));

        tblaconH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblaconH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaconHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblaconH);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 820, 230));

        jButton1.setText("buscar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jButton2.setText("eliminar");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        jButton3.setText("agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jPanel1.add(cbxlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar
        horario hr = new horario();
        String nombreSeleccionado = cbxlab.getSelectedItem().toString();
        String idSeleccionado = labMap.get(nombreSeleccionado);
        hr.setMateria(txtMateria.getText());
        hr.setDia_semana(txtDia.getText());
        hr.setHora_inicio(txtHoraini.getText());
        hr.setHora_fin(txtHorafin.getText());
        hr.setLaboratorio(idSeleccionado);
        hr.registrar_horario();
        try {
            MOSTRAR_HORARIOS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HORARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_agregar

    private void tblaconHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaconHMouseClicked
        txtMateria.setText(tblaconH.getValueAt(tblaconH.getSelectedRow(), 0).toString());
        txtHoraini.setText(tblaconH.getValueAt(tblaconH.getSelectedRow(), 1).toString());
        txtHorafin.setText(tblaconH.getValueAt(tblaconH.getSelectedRow(), 2).toString());
        txtDia.setText(tblaconH.getValueAt(tblaconH.getSelectedRow(), 3).toString());
 
    }//GEN-LAST:event_tblaconHMouseClicked

    private void cargarDatos() {
        // Conectar a la base de datos
        conMysql c1 = new conMysql();
        try {
            // Obtener las marcas
            String query = "SELECT nombre,idLaboratorio FROM acceso_lab.laboratorios;";
            ResultSet resultSet = c1.EjecutaSql(query);

            while (resultSet.next()) {
                String id = resultSet.getString("idLaboratorio");

                String nombre = resultSet.getString("nombre");
                cbxlab.addItem(nombre);
                labMap.put(nombre, id);
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HORARIOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void MOSTRAR_HORARIOS() throws ClassNotFoundException {

        String sql = ("SELECT  materia,hora_inicio,hora_fin,dia_semana,nombre FROM tb_horarios,laboratorios where tb_horarios.idLaboratorio=laboratorios.idLaboratorio;");
        System.out.println("648" + sql);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("MATERIA");
        modelo.addColumn("HORA DE INICIO");
        modelo.addColumn("HORA DE SALIDA");
        modelo.addColumn("DIA");
        modelo.addColumn("LABORATORIO");
        tblaconH.setModel(modelo);
        String[] datos = new String[5];
        try {
            conMysql c1 = new conMysql();
            try (ResultSet res = c1.EjecutaSql(sql)) {
                while (res.next()) {
                    datos[0] = res.getString(1);
                    datos[1] = res.getString(2);
                    datos[2] = res.getString(3);
                    datos[3] = res.getString(4);
                    datos[4] = res.getString(5);
                    modelo.addRow(datos);

                }
            }
            tblaconH.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showInternalMessageDialog(null, "error" + e.toString());
        }
    }
    

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
            java.util.logging.Logger.getLogger(HORARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HORARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HORARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HORARIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HORARIOS().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HORARIOS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxlab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblaconH;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtHorafin;
    private javax.swing.JTextField txtHoraini;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables
}
