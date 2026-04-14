/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.newpackage;
import Conn.DatabaseConn.newpackage.DB;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulj
 */
public class AdminDashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDashboard.class.getName());

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        setResizable(false); 
        DisplayData();
    }
    
    private void DisplayData(){
        try {
                String sql = "SELECT id, foods, category, price, status FROM foods";
                PreparedStatement pst = DB.con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();

                String[] columns = {"ID", "FOODS", "CATEGORY", "PRICE", "STATUS"};
                javax.swing.table.DefaultTableModel model =
                    new javax.swing.table.DefaultTableModel(columns, 0);

                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("id"),
                        rs.getString("foods"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("status")
                    };
                    model.addRow(row);
                }
                jTableProduct.setModel(model);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabelAdminDashboard = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbuttonProducts = new javax.swing.JButton();
        jButtonSale = new javax.swing.JButton();
        jbuttonLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelProduct = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        textFieldSearchBar = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jPanelSales = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMonthlySales = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblWeeklySales = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblDailySales = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelDeleteFunction = new javax.swing.JPanel();
        jPanelUpdateFunction = new javax.swing.JPanel();
        jPanelAddFunction = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(false);
        setLocation(new java.awt.Point(180, 20));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelAdminDashboard.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelAdminDashboard.setText("ADMIN DASHBOARD");

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Category", "Price", "Status", "Image(jpeg/img)"
            }
        ));
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(jLabelAdminDashboard)
                .addGap(341, 341, 341))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabelAdminDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 70));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbuttonProducts.setText("Products");
        jbuttonProducts.addActionListener(this::jbuttonProductsActionPerformed);

        jButtonSale.setText("Sales");
        jButtonSale.addActionListener(this::jButtonSaleActionPerformed);

        jbuttonLogout.setText("Log Out");
        jbuttonLogout.addActionListener(this::jbuttonLogoutActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbuttonLogout))
                    .addComponent(jbuttonProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jButtonSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jbuttonProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 513, Short.MAX_VALUE)
                .addComponent(jbuttonLogout)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 140, 640));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.CardLayout());

        jButtonAdd.setBackground(new java.awt.Color(0, 255, 51));
        jButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonAdd.setText("ADD");
        jButtonAdd.addActionListener(this::jButtonAddActionPerformed);

        jButtonUpdate.setBackground(new java.awt.Color(204, 204, 204));
        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonUpdate.setText("UPDATE");
        jButtonUpdate.addActionListener(this::jButtonUpdateActionPerformed);

        jButtonDelete.setBackground(new java.awt.Color(255, 51, 51));
        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonDelete.setText("DELETE");
        jButtonDelete.addActionListener(this::jButtonDeleteActionPerformed);

        textFieldSearchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldSearchBar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textFieldSearchBar.setText("\n");
        textFieldSearchBar.addActionListener(this::textFieldSearchBarActionPerformed);

        jLabel1.setText("Search Item:");

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FOODS", "CATEGORY", "PRICE", "STATUS", "IMG/PNG"
            }
        ));
        jScrollPane3.setViewportView(jTableProduct);

        javax.swing.GroupLayout jPanelProductLayout = new javax.swing.GroupLayout(jPanelProduct);
        jPanelProduct.setLayout(jPanelProductLayout);
        jPanelProductLayout.setHorizontalGroup(
            jPanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButtonAdd)
                .addGap(18, 18, 18)
                .addComponent(jButtonUpdate)
                .addGap(18, 18, 18)
                .addComponent(jButtonDelete)
                .addGap(237, 237, 237)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanelProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanelProductLayout.setVerticalGroup(
            jPanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAdd)
                        .addComponent(jButtonUpdate)
                        .addComponent(jButtonDelete)
                        .addComponent(jLabel1))
                    .addComponent(textFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanelProduct, "card2");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setText("Total Monthly Sales");

        lblMonthlySales.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMonthlySales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonthlySales.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMonthlySales, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMonthlySales, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.green, null, null));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setText("Total Weekly Sales");

        lblWeeklySales.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblWeeklySales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWeeklySales.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 117, Short.MAX_VALUE)
                .addComponent(jLabel3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWeeklySales, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(lblWeeklySales, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.red, null, null));

        lblDailySales.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblDailySales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDailySales.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setText("Total Daily Sales");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 139, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDailySales, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDailySales, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name", "Price", "Date"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelSalesLayout = new javax.swing.GroupLayout(jPanelSales);
        jPanelSales.setLayout(jPanelSalesLayout);
        jPanelSalesLayout.setHorizontalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelSalesLayout.setVerticalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSalesLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
        );

        jPanel2.add(jPanelSales, "card3");

        javax.swing.GroupLayout jPanelDeleteFunctionLayout = new javax.swing.GroupLayout(jPanelDeleteFunction);
        jPanelDeleteFunction.setLayout(jPanelDeleteFunctionLayout);
        jPanelDeleteFunctionLayout.setHorizontalGroup(
            jPanelDeleteFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jPanelDeleteFunctionLayout.setVerticalGroup(
            jPanelDeleteFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelDeleteFunction, "card4");

        javax.swing.GroupLayout jPanelUpdateFunctionLayout = new javax.swing.GroupLayout(jPanelUpdateFunction);
        jPanelUpdateFunction.setLayout(jPanelUpdateFunctionLayout);
        jPanelUpdateFunctionLayout.setHorizontalGroup(
            jPanelUpdateFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jPanelUpdateFunctionLayout.setVerticalGroup(
            jPanelUpdateFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelUpdateFunction, "card4");

        javax.swing.GroupLayout jPanelAddFunctionLayout = new javax.swing.GroupLayout(jPanelAddFunction);
        jPanelAddFunction.setLayout(jPanelAddFunctionLayout);
        jPanelAddFunctionLayout.setHorizontalGroup(
            jPanelAddFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jPanelAddFunctionLayout.setVerticalGroup(
            jPanelAddFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelAddFunction, "card4");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 1010, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaleActionPerformed
        jPanel2.removeAll();
        jPanel2.add(jPanelSales);
        jPanel2.repaint();
        jPanel2.revalidate();       
    }//GEN-LAST:event_jButtonSaleActionPerformed

    private void jbuttonProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonProductsActionPerformed
    jPanel2.removeAll();
    jPanel2.add(jPanelProduct);  // not jPanelSales!
    jPanel2.repaint();
    jPanel2.revalidate();
    DisplayData();
    }//GEN-LAST:event_jbuttonProductsActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        jPanel2.removeAll();
        jPanel2.add(jPanelDeleteFunction);  // not jPanelSales!
        jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void textFieldSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSearchBarActionPerformed
        String search = textFieldSearchBar.getText();

            try {
                String sql = "SELECT id, foods, category, price, status FROM foods " +
             "WHERE BINARY foods LIKE ? " +
             "OR BINARY status = ? " +        // ← exact match, no LIKE
             "OR CAST(id AS CHAR) LIKE ? " +
             "OR BINARY category LIKE ?";
                PreparedStatement pst = DB.con.prepareStatement(sql);
                pst.setString(1, "%" + search + "%");
                pst.setString(2, search );
                pst.setString(3, "%" + search + "%");
                pst.setString(4, "%" + search + "%");
                ResultSet rs = pst.executeQuery();

                String[] columns = {"ID", "FOODS", "CATEGORY", "PRICE", "STATUS"};
                javax.swing.table.DefaultTableModel model =
                    new javax.swing.table.DefaultTableModel(columns, 0);

                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("id"),
                        rs.getString("foods"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("status")
                    };
                    model.addRow(row);
                }

                jTableProduct.setModel(model); 

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
    }//GEN-LAST:event_textFieldSearchBarActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        jPanel2.removeAll();
        jPanel2.add(jPanelAddFunction);  // not jPanelSales!
        jPanel2.repaint();
        jPanel2.revalidate();
          
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jbuttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonLogoutActionPerformed
    new DashBoard().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbuttonLogoutActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        jPanel2.removeAll();
        jPanel2.add(jPanelUpdateFunction);  // not jPanelSales!
        jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private static double monthlyTotal = 0;
    private static double weeklyTotal = 0;
    private static double dailyTotal = 0;

    public void updateSalesData(double amount) {
        // 1. Increment totals
        monthlyTotal += amount;
        weeklyTotal += amount;
        dailyTotal += amount;

        // 2. Update the labels (using your specific variable names)
        lblMonthlySales.setText(String.format("%.2f", monthlyTotal));
        lblWeeklySales.setText(String.format("%.2f", weeklyTotal));
        lblDailySales.setText(String.format("%.2f", dailyTotal));

        // 3. Add a row to the sales table (jTable1)
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.util.Date());
        model.addRow(new Object[]{"ID-" + (model.getRowCount() + 1), "POS Sale", amount, currentDate});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSale;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAdminDashboard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelAddFunction;
    private javax.swing.JPanel jPanelDeleteFunction;
    private javax.swing.JPanel jPanelProduct;
    private javax.swing.JPanel jPanelSales;
    private javax.swing.JPanel jPanelUpdateFunction;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JButton jbuttonLogout;
    private javax.swing.JButton jbuttonProducts;
    private javax.swing.JLabel lblDailySales;
    private javax.swing.JLabel lblMonthlySales;
    private javax.swing.JLabel lblWeeklySales;
    private java.awt.TextField textFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
