
package menubarjava;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;

public class Purchase extends javax.swing.JFrame{

    Connection conn = null;
    Vector v1 = null;
    Vector v2 = null;
    Vector v3 = null;
    Vector v4 = null;
    HashMap stockQtyMaping = null;
    int invoiceNo = 100;

    public Purchase() throws SQLException {
        initComponents();
        this.setLocation(300, 200);
        this.setSize(700, 500);
        this.getData();
    }
    
    private void getData() throws SQLException {
        try{
            v1 = new Vector();
            v2 = new Vector();
            v3 = new Vector();
            v4 = new Vector();
            stockQtyMaping = new HashMap();

            conn = InitConnection.getConn();
            Statement stm = conn.createStatement();
    
            qty.setText("Quantity");
            totalAmount.setText("Total Amount");

            customers.removeAllItems();
            products.removeAllItems();

            try (ResultSet stockResult = stm.executeQuery("SELECT * FROM stock")) {
                while(stockResult.next()){
                    stockQtyMaping.put(stockResult.getInt(3), stockResult.getInt(2));

                }
            }

            try (ResultSet purchaseResult = stm.executeQuery("SELECT invoice_no FROM purchase")) {
                while(purchaseResult.next()){
                    invoiceNo = purchaseResult.getInt(1);
                }
                invoiceNo = invoiceNo + 1;
            }

            try (ResultSet customerResult = stm.executeQuery("SELECT id, name, city FROM customer")) {
                while(customerResult.next()){
                    v1.addElement(customerResult.getInt(1));
                    customers.addItem(customerResult.getString(2));
                    v2.addElement(customerResult.getString(3));
                }
                city.setText(v2.get(0).toString());
            }

            try (ResultSet productResult = stm.executeQuery("SELECT id, name, price FROM product")) {
                while(productResult.next()){
                    v3.addElement(productResult.getInt(1));
                    products.addItem(productResult.getString(2));
                    v4.addElement(productResult.getString(3));
                }
                purchasePrice.setText(v4.get(0).toString());
            }

            System.out.println(" -- invoiceNo :- " + invoiceNo);

            invoiceNo1.setText(invoiceNo + "");
            this.setStockMapping();
        } catch(Exception error) {
            System.out.println(" -- getData Catch error :- " + error);
        } finally {
            conn.close();
        }
    }
    
    private void setStockMapping(){
        if(!stockQtyMaping.isEmpty() && !v3.isEmpty() && stockQtyMaping.containsKey(v3.get(products.getSelectedIndex()))){
            stock.setText(stockQtyMaping.get(v3.get(products.getSelectedIndex())).toString());
        } else {
            stock.setText("Stock");
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

        totalAmount = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        invoiceNo1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        products = new javax.swing.JComboBox<>();
        customers = new javax.swing.JComboBox<>();
        purchasePrice = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        updateLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        totalAmount.setText("Total Amount");
        totalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountActionPerformed(evt);
            }
        });
        getContentPane().add(totalAmount);
        totalAmount.setBounds(360, 190, 140, 40);

        city.setText("City");
        getContentPane().add(city);
        city.setBounds(10, 70, 140, 40);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn);
        cancelBtn.setBounds(160, 260, 72, 23);

        submitBtn.setText("Save");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn);
        submitBtn.setBounds(260, 260, 72, 23);

        invoiceNo1.setText("Invoice No");
        invoiceNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceNo1ActionPerformed(evt);
            }
        });
        getContentPane().add(invoiceNo1);
        invoiceNo1.setBounds(10, 20, 140, 40);

        jLabel1.setText("Select Product");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 70, 130, 40);

        jLabel2.setText("Select Customer");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 20, 130, 40);

        products.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsActionPerformed(evt);
            }
        });
        getContentPane().add(products);
        products.setBounds(360, 70, 140, 40);

        customers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersActionPerformed(evt);
            }
        });
        getContentPane().add(customers);
        customers.setBounds(360, 20, 140, 40);

        purchasePrice.setText("Purchase Price");
        purchasePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchasePriceActionPerformed(evt);
            }
        });
        getContentPane().add(purchasePrice);
        purchasePrice.setBounds(10, 120, 140, 40);

        stock.setText("Stock");
        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });
        getContentPane().add(stock);
        stock.setBounds(360, 130, 140, 40);

        qty.setText("Quantity");
        qty.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                qtyInputMethodTextChanged(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });
        getContentPane().add(qty);
        qty.setBounds(10, 180, 140, 40);
        getContentPane().add(updateLabel);
        updateLabel.setBounds(180, 190, 150, 30);

        jLabel3.setText("Available Stock");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 130, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
        Product.main(new String [2]);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void invoiceNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceNo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceNo1ActionPerformed

    private void productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsActionPerformed
        System.out.println(v4 + " -- Size :- " + v4.size() + " -- value of x :- " + products.getSelectedIndex());

        if(!v4.isEmpty()) {
            purchasePrice.setText(v4.get(products.getSelectedIndex()).toString());
        }

        this.setStockMapping();
    }//GEN-LAST:event_productsActionPerformed

    private void customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersActionPerformed
        if(!v2.isEmpty()) {
            city.setText(v2.get(customers.getSelectedIndex()).toString());
        }
    }//GEN-LAST:event_customersActionPerformed

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockActionPerformed

    private void qtyInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_qtyInputMethodTextChanged
    }//GEN-LAST:event_qtyInputMethodTextChanged

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        String qtyVal = qty.getText();
        if(qtyVal.matches("\\d+") && Integer.parseInt(qtyVal) >= 0) {
            totalAmount.setText((Integer.parseInt(qtyVal) * Integer.parseInt(purchasePrice.getText())) + "");
        } else {
            totalAmount.setText("0");
        }
        updateLabel.setText("''");
    }//GEN-LAST:event_qtyKeyReleased

    private void totalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        try {
            Date date = new Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            
            conn = InitConnection.getConn();
            PreparedStatement preparedStm = conn.prepareStatement("INSERT INTO purchase (invoice_no, customer_id, product_id, price, qty, "
                    + "amount, purchase_date) VALUES (?,?,?,?,?,?,?)");
            preparedStm.setInt(1, Integer.parseInt(invoiceNo1.getText()));
            preparedStm.setInt(2, Integer.parseInt(v1.get(customers.getSelectedIndex()).toString()));
            preparedStm.setInt(3, Integer.parseInt(v3.get(products.getSelectedIndex()).toString()));
            preparedStm.setInt(4, Integer.parseInt(purchasePrice.getText()));
            preparedStm.setInt(5, Integer.parseInt(qty.getText()));
            preparedStm.setInt(6, Integer.parseInt(totalAmount.getText()));
            preparedStm.setDate(7,sqlDate);
            
            int x = preparedStm.executeUpdate();
            updateLabel.setText(x + " Data is updated.");

            if(!stockQtyMaping.isEmpty() && !v3.isEmpty() && stockQtyMaping.containsKey(v3.get(products.getSelectedIndex()))){            
                PreparedStatement stockUpdate = conn.prepareStatement("UPDATE stock SET product_id=?, qty=? WHERE product_id=?");

                int stockValue = Integer.parseInt(stockQtyMaping.get(v3.get(products.getSelectedIndex())).toString());

                stockUpdate.setInt(1, Integer.parseInt(v3.get(products.getSelectedIndex()).toString()));
                stockUpdate.setInt(2, (Integer.parseInt(qty.getText())) + stockValue );
                stockUpdate.setInt(3, Integer.parseInt(v3.get(products.getSelectedIndex()).toString()));
                stockUpdate.executeUpdate();

                System.out.println("-- Stock details updated successfully.");
            } else {
                PreparedStatement stockInsert = conn.prepareStatement("INSERT INTO stock (product_id, qty) VALUES (?, ?)");
                stockInsert.setInt(1, Integer.parseInt(v3.get(products.getSelectedIndex()).toString()));
                stockInsert.setInt(2, Integer.parseInt(qty.getText()));
                stockInsert.executeUpdate();

                System.out.println("-- Stock details inserted successfully.");
            }

            this.getData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void purchasePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchasePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchasePriceActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Purchase().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField city;
    private javax.swing.JComboBox<String> customers;
    private javax.swing.JTextField invoiceNo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> products;
    private javax.swing.JTextField purchasePrice;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField stock;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField totalAmount;
    private javax.swing.JLabel updateLabel;
    // End of variables declaration//GEN-END:variables
}
