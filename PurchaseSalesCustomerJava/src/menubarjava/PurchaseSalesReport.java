package menubarjava;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class PurchaseSalesReport extends javax.swing.JFrame {
    Connection conn = null;

    public PurchaseSalesReport() throws SQLException {
        initComponents();
        this.setLocation(200, 200);
        this.setSize(930, 500);
        this.getData();
    }

    private void getData() throws SQLException {
        try{
            conn = InitConnection.getConn();
            Statement stm = conn.createStatement();

            try (ResultSet stockResult = stm.executeQuery("SELECT product.name AS product_name, pur.purchase_date, pur.purchase_qty, customer.name AS customer_name, "
              + "sal.sales_qty, sal.sales_customer_name, pur.amount AS purchase_amount, stok.stock_qty FROM "
              + "(SELECT amount, product_id, purchase_date, customer_id, SUM(purchase.qty) AS purchase_qty FROM `purchase` GROUP BY product_id) pur\n"
              + "INNER JOIN product ON pur.product_id = product.id\n"
              + "INNER JOIN customer ON pur.customer_id = customer.id\n"
              + "LEFT JOIN (SELECT product_id, SUM(sales.qty) AS sales_qty, customer.name as sales_customer_name FROM sales\n"
                    + "INNER JOIN customer ON sales.customer_id = customer.id\n"
                + "GROUP BY product_id) sal ON sal.product_id = pur.product_id\n"
              + "LEFT JOIN (SELECT product_id, SUM(stock.qty) AS stock_qty FROM stock GROUP BY product_id) stok ON stok.product_id = pur.product_id")
            ) {
                DefaultTableModel model = (DefaultTableModel) purchaseReportTable.getModel();

                while(stockResult.next()){
                    Object[] data0 = {stockResult.getString(1), stockResult.getDate(2), stockResult.getInt(3), stockResult.getString(4),
                        stockResult.getInt(5), stockResult.getString(6), stockResult.getInt(7), stockResult.getString(8)
                    };
                    model.addRow(data0);
                }
            }
        } catch(Exception error) {
            System.out.println(" -- getData Catch error :- " + error);
        } finally {
            conn.close();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseReportTable = new javax.swing.JTable();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        purchaseReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ", "Date", "Qty", "Last Purchase by", "Sales", "Last Sales By", "Amount", "Available stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(purchaseReportTable);

        homeBtn.setText("home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(757, 757, 757)
                        .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PurchaseSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PurchaseSalesReport().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PurchaseSalesReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseReportTable;
    // End of variables declaration//GEN-END:variables
}
