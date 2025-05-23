/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import database.JDBCUtil;
/**
 *
 * @author shypo
 */
public class Products extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
    /**
     * Creates new form Products
     */
    public Products() {  
            
        try {          
            initComponents();
            tableModel = new DefaultTableModel();
            tableSanPham.setModel(tableModel);        
            loadData();
            }catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
    } 
    //====================================//
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_dienthoai2";
        String username = "root";
        String password = "";
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_dienthoai2", "root", "");
    }
     //====================================//
    private void loadData() {
        tableModel.setColumnIdentifiers(new Object[] {"ProductID", "ProductName", "Brand", "Price", "RAM", "ROM","CPU","Pin","ScreenSize","QuantityInStock"
        });
        tableModel.setRowCount(0);// Xoa du lieu truoc khi tai lai
        
        try {
            
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getString("ProductID"),
                    resultSet.getString("ProductName"),
                    resultSet.getString("Brand"),
                    resultSet.getDouble("Price"),
                    resultSet.getString("RAM"),
                    resultSet.getString("ROM"),
                    resultSet.getString("CPU"),
                    resultSet.getString("Pin"),
                    resultSet.getString("ScreenSize"),
                    resultSet.getInt("QuantityInStock"),
                };
                tableModel.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "ProductName", "Brand", "Price", "RAM", "ROM", "Title 7", "Pin", "ScreenSize", "QuantityInStock"
            }
        ));
        jScrollPane2.setViewportView(tableSanPham);

        jButton2.setText("AddProducts");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jButton2)
                .addContainerGap(645, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton2)
                .addContainerGap(614, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new UpdateProducts().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableSanPham;
    // End of variables declaration//GEN-END:variables
}
