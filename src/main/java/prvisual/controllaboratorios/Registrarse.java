/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prvisual.controllaboratorios;

import conecxion.conMysql;
import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SAID
 */
public class Registrarse extends javax.swing.JFrame {

    private String cedula;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    private String rolUsuario;
    conexion cn = new conexion();
    Connection con = cn.conectar();

    Map<String, String> labMap = new HashMap<>();

    public Registrarse() throws ClassNotFoundException {

        initComponents();
        //this.CargarComboCategorias();
        setLocationRelativeTo(null);
        diaSemana();
        //cargar();

    }

    public String diaSemana() {
        LocalDate fechaActual = LocalDate.now();

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();

        String nombreDiaSemana = diaSemana.getDisplayName(TextStyle.FULL, Locale.getDefault());

        System.out.println("Hoy es: " + nombreDiaSemana);

        return nombreDiaSemana;
    }

    public void cargar(String lab) throws ClassNotFoundException, SQLException {
        String sql = ("call acceso_lab.horarios('" + diaSemana() + "', '" + lab + "');");
        System.out.println("---" + sql);

        conMysql c1 = new conMysql();
        ResultSet res = c1.EjecutaSql(sql);

        while (res.next()) {
            String id = res.getString("idHorario");
            String materia = res.getString("materia");
            cbxMateria.addItem(materia);
            txtLaboratorio.setText(res.getString("nombre"));
            txtHorario.setText(res.getString("hora_inicio"));
            txtDia.setText(res.getString("dia_semana"));
            labMap.put(materia, id);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        REGISTRARSE = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtLaboratorio = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtHorario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxMateria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 450));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        REGISTRARSE.setBackground(new java.awt.Color(51, 153, 255));
        REGISTRARSE.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        REGISTRARSE.setForeground(new java.awt.Color(255, 255, 255));
        REGISTRARSE.setText("RESGISTRARSE");
        REGISTRARSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTRARSEActionPerformed(evt);
            }
        });
        jPanel1.add(REGISTRARSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, 50));

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setForeground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 10));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 10, 450));

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setForeground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        txtLaboratorio.setEnabled(false);
        jPanel1.add(txtLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 170, -1));

        txt_nombre.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txt_nombre.setEnabled(false);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 210, -1));

        txtDia.setEnabled(false);
        jPanel1.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 169, -1));

        txtHorario.setEnabled(false);
        jPanel1.add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 169, -1));

        jLabel6.setText("DIA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel4.setText("HORARIO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 62, -1));

        jLabel1.setText("LABORATORIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 93, -1));

        jLabel2.setText("ASIGNATURA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 81, -1));

        jPanel1.add(cbxMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 160, 34));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 3, 18)); // NOI18N
        jLabel5.setText("REGISTRO DE ASISTENCIA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 280, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void REGISTRARSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTRARSEActionPerformed

        try {

            String nombreSeleccionado = cbxMateria.getSelectedItem().toString();
            String idSeleccionado = labMap.get(nombreSeleccionado);
                String lab = txtLaboratorio.getText();
                String combo= cbxMateria.getSelectedItem().toString();
            if (lab.isEmpty()||combo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "tiene campos vacios");
            } else {

                String insertar = ("INSERT INTO `acceso_lab`.`tb_ingreso_laboratorio` (`Usuario`, `idHorario`) VALUES ('" + cedula + "','" + idSeleccionado + "')");
                System.out.println("888 " + insertar);
                // JOptionPane.showMessageDialog(null, "Datos registrados");
                conMysql c1 = new conMysql();
                c1.EjecutaSqlIUD(insertar);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrarse.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_REGISTRARSEActionPerformed

    public void consultar(String cedula) throws SQLException {
        String consulta = ("SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo FROM acceso_lab.tb_usuario WHERE usuario = '" + cedula + "';");
        System.out.println("+++" + consulta);
        conMysql c1 = new conMysql();
        try {
            ResultSet res = c1.EjecutaSql(consulta);
            if (res.next()) {
                txt_nombre.setText(res.getString("nombre_completo"));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrarse.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Registrarse().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Registrarse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton REGISTRARSE;
    private javax.swing.JComboBox<String> cbxMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtLaboratorio;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

//private void CargarComboCategorias() {
//        Connection cn = conexion.conectar();
//        String sql = "select * from laboratorios";
//        Statement st;
//
//        try {
//
//            st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            comboBoxLaboratorio.removeAllItems();
//            comboBoxLaboratorio.addItem("Seleccione Laboratorio:");
//            while (rs.next()) {
//                comboBoxLaboratorio.addItem(rs.getString("nombre"));
//            }
//            cn.close();
//
//        } catch (SQLException e) {
//            System.out.println("Error al cargar categorias");
//        }
//  
//}
//    public void setDatosUsuario(String nombre, String cargo) {
//        txt_nombre.setText(nombre);
//       // txt_rol.setText(cargo);
//    }
    private int obtenerIdUsuario(String nombre) {
        String sql = "select * from tb_usuario where nombre = '" + nombre + "'";
        Statement st;
        try {
            Connection cn = conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("idUsuario");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener id garantía");
        }
        return 0;
    }

    public String getString(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
