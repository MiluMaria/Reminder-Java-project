package reminder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MILU
 */
public class AddReminder extends javax.swing.JFrame {

    /**
     *  creates reminders
     */
    Connection con = dbcon.dbConnector();

    public AddReminder() {

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        jButton2 = new javax.swing.JButton();
        r1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setTitle("Add Reminder");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(214748364, 2147483647));
        jPanel1.setPreferredSize(new java.awt.Dimension(57, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(dateTimePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 280, 30));

        jButton2.setText("Add");
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 100, 30));
        jPanel1.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 280, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Remainder");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 88, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Data and time");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 159, 140, -1));

        jButton1.setText("Cancel");
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 110, -1));

        jLabel4.setText("Use arrow key after selecting time adjust time to minute");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 340, -1));

        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new AddReminder().setVisible(true);        //  go to the previous form
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // This fuction Inserts data into table
        try {

            String remainder = r1.getText();
            DatePicker dt = dateTimePicker1.getDatePicker();
            TimePicker ti = dateTimePicker1.getTimePicker();
            String d = dt.toString();
            String t = ti.toString();
            boolean flag = DateTimeValidator.validator(d, t,remainder);
            if (flag == true) {
                System.out.println(remainder);
                System.out.println(d);
                System.out.println(t);
                String query = "INSERT INTO `rem`(`Reminder`, `Reminder_date`, `Reminder_time`) VALUES (?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, remainder);
                pst.setString(2, d);
                pst.setString(3, t);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Reminder Added");
                this.dispose();
                new AddReminder().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Enter Valid Remainder");
                this.dispose();
                new AddReminder().setVisible(true);
            }
        } catch (HeadlessException | SQLException e) {
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReminder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField r1;
    // End of variables declaration//GEN-END:variables
}
