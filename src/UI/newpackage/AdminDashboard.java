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
import java.sql.Statement;

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
        refreshDashboardData();
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
    
public void loadTable() {
    DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
    model.setRowCount(0); 

    String url = "jdbc:mysql://localhost:3306/bytebitedb";
    String user = "root";
    
    try (Connection cn = DriverManager.getConnection(url, user, "");
         PreparedStatement psTable = cn.prepareStatement("SELECT * FROM sales");
         ResultSet rsTable = psTable.executeQuery()) {

        while (rsTable.next()) {
            model.addRow(new Object[]{rsTable.getString(1), rsTable.getString(2), rsTable.getDouble(3), rsTable.getString(4)});
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Table Load Error: " + e.getMessage());
    }
}
   
public void refreshDashboardData() {
    String url = "jdbc:mysql://localhost:3306/bytebitedb";
String user = "root";

try (Connection cn = DriverManager.getConnection(url, user, "")) {
    
    // LOAD THE TOTALS ---
    
    // Daily
    String queryDaily = "SELECT IFNULL(SUM(Price), 0) FROM sales WHERE Date = CURDATE()";
    try (PreparedStatement psDaily = cn.prepareStatement(queryDaily);
         ResultSet rsDaily = psDaily.executeQuery()) {
        // Added the ₱ symbol right before the %.2f
        if (rsDaily.next()) lblDailySales.setText(String.format("₱ %.2f", rsDaily.getDouble(1)));
    }

    // Weekly
    String queryWeekly = "SELECT IFNULL(SUM(Price), 0) FROM sales WHERE YEARWEEK(Date, 1) = YEARWEEK(CURDATE(), 1)";
    try (PreparedStatement psWeekly = cn.prepareStatement(queryWeekly);
         ResultSet rsWeekly = psWeekly.executeQuery()) {
        if (rsWeekly.next()) lblWeeklySales.setText(String.format("₱ %.2f", rsWeekly.getDouble(1)));
    }

    // Monthly
    String queryMonthly = "SELECT IFNULL(SUM(Price), 0) FROM sales WHERE MONTH(Date) = MONTH(CURDATE()) AND YEAR(Date) = YEAR(CURDATE())";
    try (PreparedStatement psMonthly = cn.prepareStatement(queryMonthly);
         ResultSet rsMonthly = psMonthly.executeQuery()) {
        if (rsMonthly.next()) lblMonthlySales.setText(String.format("₱ %.2f", rsMonthly.getDouble(1)));
    }

    // Yearly
    String queryYearly = "SELECT IFNULL(SUM(Price), 0) FROM sales WHERE YEAR(Date) = YEAR(CURDATE())";
    try (PreparedStatement psYearly = cn.prepareStatement(queryYearly);
         ResultSet rsYearly = psYearly.executeQuery()) {
        if (rsYearly.next()) lblYearlySales.setText(String.format("₱ %.2f", rsYearly.getDouble(1)));
    }

} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblYearlySales = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblWeeklySales = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblMonthlySales = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblDailySales = new javax.swing.JLabel();

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

        jPanel3.setBackground(new java.awt.Color(235, 229, 229));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 72)); // NOI18N
        jLabel2.setText("SALES SUMMARY");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(93, 93, 93))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Yearly Sales", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 48))); // NOI18N
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(327, 206));

        lblYearlySales.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblYearlySales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblYearlySales.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblYearlySales, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblYearlySales, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weekly Sales", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 48))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(327, 206));

        lblWeeklySales.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblWeeklySales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWeeklySales.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWeeklySales, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblWeeklySales, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monthly Sales", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 48))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(327, 206));

        lblMonthlySales.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMonthlySales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonthlySales.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMonthlySales, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblMonthlySales, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Daily Sales", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 1, 48))); // NOI18N

        lblDailySales.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblDailySales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDailySales.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDailySales, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblDailySales, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanelSalesLayout = new javax.swing.GroupLayout(jPanelSales);
        jPanelSales.setLayout(jPanelSalesLayout);
        jPanelSalesLayout.setHorizontalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSalesLayout.setVerticalGroup(
            jPanelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelSales, "card3");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 1010, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaleActionPerformed
      jPanel2.removeAll();
        jPanel2.add(jPanelSales);
        
        loadTable(); 
        
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
new Delete().setVisible(true);
        
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
        new AddProducts().setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jbuttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonLogoutActionPerformed
        new DashBoard().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jbuttonLogoutActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        new UpdateProducts().setVisible(true);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSale;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAdminDashboard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelProduct;
    private javax.swing.JPanel jPanelSales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JButton jbuttonLogout;
    private javax.swing.JButton jbuttonProducts;
    private javax.swing.JLabel lblDailySales;
    private javax.swing.JLabel lblMonthlySales;
    private javax.swing.JLabel lblWeeklySales;
    private javax.swing.JLabel lblYearlySales;
    private java.awt.TextField textFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
