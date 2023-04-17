package menubarjava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class CustomerUpdate extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public CustomerUpdate() {
        initComponents();
        this.setLocation(300, 200);
        this.setSize(500, 500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        address = new javax.swing.JTextField();
        mobileNo = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        data = new javax.swing.JLabel();
        customerId = new javax.swing.JTextField();
        getCustomer = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        address.setText("Address");
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        getContentPane().add(address);
        address.setBounds(20, 100, 270, 40);

        mobileNo.setText("Mobile No.");
        getContentPane().add(mobileNo);
        mobileNo.setBounds(20, 150, 270, 40);

        city.setText("City");
        getContentPane().add(city);
        city.setBounds(20, 200, 270, 40);

        name.setText("Name");
        getContentPane().add(name);
        name.setBounds(20, 50, 270, 40);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(210, 260, 72, 23);

        saveBtn.setText("save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn);
        saveBtn.setBounds(30, 260, 72, 23);
        getContentPane().add(data);
        data.setBounds(40, 10, 240, 30);

        customerId.setText("Customer ID");
        getContentPane().add(customerId);
        customerId.setBounds(310, 50, 100, 40);

        getCustomer.setText("Get Customer");
        getCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(getCustomer);
        getCustomer.setBounds(310, 110, 110, 23);

        homeBtn.setText("Home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(homeBtn);
        homeBtn.setBounds(310, 260, 100, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        customerId.setEditable(true);
        customerId.setEnabled(true);
        
        this.clearData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            Connection conn = InitConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("UPDATE customer SET name=?, address=?, mobile=?, city=? WHERE id=?");

            ps.setString(1, name.getText());
            ps.setString(2, address.getText());
            ps.setString(3, mobileNo.getText());
            ps.setString(4, city.getText());
            ps.setInt(5, Integer.parseInt(customerId.getText()));

            int x = ps.executeUpdate();
            data.setText(x + " Data updated.");
            
            this.clearData();
            
        } catch (Exception e) {
            System.out.println(" -- customer error :- " + e);
        }        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clearData() {
        name.setText("Name");
        address.setText("Address");
        mobileNo.setText("Mobile No."); 
        city.setText("City");
        customerId.setText("Customer ID");
    }
    
    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void getCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCustomerActionPerformed
        try {
            Connection conn = InitConnection.getConn();
            Statement stm = conn.createStatement();
            
            try(ResultSet rs = stm.executeQuery("SELECT * FROM customer WHERE id=" + customerId.getText())) {
                while(rs.next()) {
                    name.setText(rs.getString(2));
                    address.setText(rs.getString(3));
                    mobileNo.setText(rs.getString(4));
                    city.setText(rs.getString(5));
                }
                customerId.setEditable(false);
                customerId.setEnabled(false);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            System.out.println(" -- customer error :- " + e);
        }
    }//GEN-LAST:event_getCustomerActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        this.setVisible(false);
        Product.main(new String [2]);
    }//GEN-LAST:event_homeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField city;
    private javax.swing.JTextField customerId;
    private javax.swing.JLabel data;
    private javax.swing.JButton getCustomer;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField mobileNo;
    private javax.swing.JTextField name;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}