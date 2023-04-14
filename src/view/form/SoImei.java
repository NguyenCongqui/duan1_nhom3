/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import Service.Impl.ChiTietSanPhamImpl;
import Services.IChiTietSanPham;
import Services.ImeiServices;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Dell
 */
public class SoImei extends javax.swing.JFrame {

    /**
     * Creates new form SoImei
     */
    private ImeiServices service ;
    private IChiTietSanPham chiTietSanPham;
    private List<String> listAdd;
    private List<String> listXoa ;
    public SoImei() {
        initComponents();
        listAdd = new ArrayList<>();
        listXoa = new ArrayList();
        chiTietSanPham = new ChiTietSanPhamImpl();
        
        txtSoLuong.setText("Số lượng : 0");
        DefaultTableModel model = (DefaultTableModel) tbImei.getModel();
       
        List<String> list = service.getList();
        if (list == null) {
            return;
        }
        for (String string : list) {
            Object[] data = new Object[]{
                string
            };
            model.addRow(data);
        }
        int row = model.getRowCount();

        txtSoLuong.setText("Số lượng : " + String.valueOf(row));
    }
    
    public void loadSoLuong() {
        int soLuong = tbImei.getRowCount();
        txtSoLuong.setText("Số lượng : " + String.valueOf(soLuong));
    }
    public void loadCbbImei() {
        List<String> items = service.getList();
        ChiTietSanPham.cbbImei(items);
    }

    public void loadTxtSoLuong() {
        List<String> list = service.getList();
        ChiTietSanPham.txtSoLuong(String.valueOf(list.size()));

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
        txtImei = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImei = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Imei");

        tbImei.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        tbImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbImei);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 102, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Danh Sách Imei");

        txtSoLuong.setFont(new java.awt.Font("Bahnschrift", 3, 14)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(255, 0, 51));
        txtSoLuong.setText("jLabel2");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(101, Short.MAX_VALUE))
        );

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        int index = tbImei.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bản ghi nào !");
            return;
        }
        int check = tbImei.getSelectedRowCount();
        if (check > 1) {
            JOptionPane.showMessageDialog(this, "Chỉ được xóa 1 bản ghi một lần !");
            return;
        }
        int check1 = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa ?");
        if (check1 != JOptionPane.YES_OPTION) {
            return;
        }
        List<String> list = new ArrayList();

        DefaultTableModel model = (DefaultTableModel) tbImei.getModel();
        
        String imei = tbImei.getValueAt(index, 0).toString();
        listXoa.add(imei);
                    service.setListXoa(listXoa);
//        listXoa.add(imei);
//        service.setListXoa(listXoa);
        model.removeRow(index);
        loadSoLuong();
        for (int i = 0; i < tbImei.getRowCount(); i++) {
            list.add(tbImei.getValueAt(i, 0).toString());
        }
        service.setList(list);
        loadCbbImei();
        loadTxtSoLuong();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        String checkSo = "^[0-9]*$";
        File exelFile;
        FileInputStream exelFIS = null;
        BufferedInputStream exelBIS = null;
        XSSFWorkbook exelJableImport = null;
        String pach = "D:\\";
        JFileChooser fileChooser = new JFileChooser(pach);
        int index = fileChooser.showOpenDialog(null);
        if (index == JFileChooser.CANCEL_OPTION) {
            return;
        }
        if (index == JFileChooser.APPROVE_OPTION) {
            try {
                exelFile = fileChooser.getSelectedFile();
                String fileType = fileChooser.getTypeDescription(exelFile);
                if (!fileType.equals("Microsoft Excel Worksheet")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn file Microsoft Excel Worksheet !");
                    return;
                }
                exelFIS = new FileInputStream(exelFile);
                exelBIS = new BufferedInputStream(exelFIS);
                exelJableImport = new XSSFWorkbook(exelBIS);
                XSSFSheet exelSheet = exelJableImport.getSheetAt(0);
                DefaultTableModel model = (DefaultTableModel) tbImei.getModel();
                List<String> list = new ArrayList();
                for (int i = 0; i <= exelSheet.getLastRowNum(); i++) {
                    XSSFRow exelRow = exelSheet.getRow(i);
                    if (exelRow == null) {
                        JOptionPane.showMessageDialog(this, "File bạn vừa thêm không chứa Imei nào. Vui lòng kiểm tra lại !");
                        return;
                    }
                    XSSFCell cell = exelRow.getCell(0);
                    listAdd.add(cell.getStringCellValue());
                    service.setListThem(listAdd);
                    int row = tbImei.getRowCount();
                    for (int k = 0; k < row; k++) {
                        if (cell.getStringCellValue().equals(tbImei.getValueAt(k, 0).toString())) {
                            JOptionPane.showMessageDialog(this, "File bạn vừa thêm chứa Imei đã tồn tại trong list. Vui lòng kiểm tra lại !");
                            return;
                        }
                    }

                    if (!cell.getStringCellValue().matches(checkSo)) {
                        JOptionPane.showMessageDialog(this, "File bạn vừa thêm có chứa Imei không phải là một chuỗi toàn số !");
                        return;
                    }
                    if (cell.getStringCellValue().length() != 15) {
                        JOptionPane.showMessageDialog(this, "File bạn vừa thêm có chứa Imei không không là độ dài 15 kí tự !");
                        return;
                    }
                    List<DomainModel.ChiTietSanPham> list1 = chiTietSanPham.getAll();
                    for (DomainModel.ChiTietSanPham chiTietSP : list1) {
                        for (int j = 0; j < row; j++) {
                            if (chiTietSP.getSoImei().equals(cell.getStringCellValue())) {
                                JOptionPane.showMessageDialog(this, "List Imei chứa Imei đã tồn tại trên hệ thống !");
                                return;
                            }
                        }
                    }
                    Object[] data = new Object[]{
                        cell
                    };
                    model.addRow(data);

                    list.removeAll(list);
                    for (int j = 0; j <= row; j++) {

                        list.add(tbImei.getValueAt(j, 0).toString());

                    }
                    service.setList(list);

                    loadSoLuong();
                    loadCbbImei();
                    loadTxtSoLuong();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SoImei.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SoImei.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SoImei.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            String imei = txtImei.getText();
            
                    listAdd.add(imei);
                    service.setListThem(listAdd);
            String checkSo = "^[0-9]*$";
            if (imei.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Imei không được để trống !");
                return;
            }
            if (!imei.matches(checkSo)) {
                JOptionPane.showMessageDialog(this, "Imei phải là chuỗi toàn số !");
                return;
            }
            if (imei.length() != 15) {
                JOptionPane.showMessageDialog(this, "Imei phải 15 kí tự !");
                return;
            }
            DefaultTableModel model = (DefaultTableModel) tbImei.getModel();
            int index = tbImei.getRowCount();
            for (int i = 0; i < index; i++) {
                if (imei.equals(model.getValueAt(i, 0))) {
                    JOptionPane.showMessageDialog(this, "Imei đã có trong danh sách !");
                    return;
                }
            }
            List<DomainModel.ChiTietSanPham> list1 = chiTietSanPham.getAll();
            int row = tbImei.getRowCount();
            for (DomainModel.ChiTietSanPham chiTietSP : list1) {
                for (int j = 0; j < row; j++) {
                    if (chiTietSP.getSoImei().equals(txtImei.getText())) {
                        JOptionPane.showMessageDialog(this, "Imei đã tồn tại trên hệ thống !");
                        return;
                    }
                }
            }
            List<String> list = new ArrayList();
            list.removeAll(list);
            
            Object[] data = new Object[]{
                imei
            };
            model.addRow(data);
            
            loadSoLuong();
            for (int i = 0; i < tbImei.getRowCount(); i++) {
                list.add(tbImei.getValueAt(i, 0).toString());
               
                    
                
            }
            
            service.setList(list);
            loadCbbImei();
            loadTxtSoLuong();
        } catch (SQLException ex) {
            Logger.getLogger(SoImei.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbImei.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(SoImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SoImei().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbImei;
    private javax.swing.JTextField txtImei;
    private javax.swing.JLabel txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
