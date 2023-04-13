/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import DomainModel.BoNhoTrong;
import Service.Impl.BoNhoTrongImpl;
import Services.IBoNhoTrongService;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hodangquan
 */
public class BoNhoTrongForm extends javax.swing.JFrame {

    private IBoNhoTrongService boNhoTrongService;

    /**
     * Creates new form BoNhoTrongForm
     */
    public BoNhoTrongForm() {

        try {
            initComponents();
            boNhoTrongService = new BoNhoTrongImpl();
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HienThi() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tbBoNhoTrong.getModel();
        model.setRowCount(0);
        List<BoNhoTrong> boNhoTrongs = boNhoTrongService.getAll();

        for (BoNhoTrong boNhoTrong : boNhoTrongs) {
            Integer trangThai = 0;
            if (boNhoTrong.isTrangThai() == false) {
                trangThai = 0;
            } else {
                trangThai = 1;
            }
            if (trangThai == 0) {
                Object[] data = new Object[]{
                    boNhoTrong.getId(),
                    boNhoTrong.getName(),
                    boNhoTrong.getNgaySua(),
                    boNhoTrong.getNgayTao()
                };
                model.addRow(data);
            }
        }
    }

    public BoNhoTrong LayTT() {
        String ten = txtBoNhoTrong.getText();
        return new BoNhoTrong(0, ten, true);
    }

    public void fill() {
        int index = tbBoNhoTrong.getSelectedRow();
        String id = tbBoNhoTrong.getValueAt(index, 0).toString();
        String ten = tbBoNhoTrong.getValueAt(index, 1).toString();
        txtBoNhoTrong.setText(ten);
        txtId.setText(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnXoa = new chucNang.MyButton();
        btnClear = new chucNang.MyButton();
        txtId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBoNhoTrong = new chucNang.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBoNhoTrong = new chucNang.Table01();
        btnThem = new chucNang.MyButton();
        btnSua = new chucNang.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setText("clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtId.setText("ID");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Bộ nhớ trong");

        txtBoNhoTrong.setLabelText("Tên Bộ nhớ trong");

        tbBoNhoTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên Bộ nhớ trong", "Ngày sửa", "Ngày ngày tạo"
            }
        ));
        tbBoNhoTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbBoNhoTrongMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbBoNhoTrong);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBoNhoTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(txtId)
                .addGap(18, 18, 18)
                .addComponent(txtBoNhoTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add y  Integer id = Integer.parseInt(txtId.getText());
//        Integer id = Integer.parseInt(txtId.getText());
//        try {
//            if (boNhoTrongService.xoa(id)) {
//                JOptionPane.showMessageDialog(this, "Xoa thanh cong");
//                HienThi();
//                txtBoNhoTrong.setText("");
//                txtId.setText("");
//            } else {
//                JOptionPane.showMessageDialog(this, "Xoa that bai");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            // TODO add your handling code here:
            int index = tbBoNhoTrong.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 bản ghi trước khi xóa :)) ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
//            int index1 = tbCpu.getRowCount();
//            if (index1 == 0) {
//                JOptionPane.showMessageDialog(this, "Không có dữ kiệu có dữ liệu để xóa :))");
//                return;
//            }
            int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không ? ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            if (check != JOptionPane.YES_OPTION) {
                return;
            } else {
                String idString = tbBoNhoTrong.getValueAt(index, 0).toString();
                Integer id = Integer.parseInt(idString);
                if (boNhoTrongService.xoa(id) == true) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công   ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
                HienThi();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here
        txtBoNhoTrong.setText("");
        txtId.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String checkChu = "^[a-zA-Z\\s]*$";
        String khoangTrang = "^[\\s]*$";
        String checkKiTu = "^[a-zA-Z0-9\\s+]*$";
        if (txtBoNhoTrong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên bộ nhớ trong trước khi thêm !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!txtBoNhoTrong.getText().matches(checkKiTu)) {
            JOptionPane.showMessageDialog(this, "Tên bộ nhớ trong không được chưa kí tự đặc biệt !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtBoNhoTrong.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên bộ nhớ trong không được nhập toàn khoản trắng !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if(txtCpu.getText().trim().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Không được để trống");
//        }
        if (txtBoNhoTrong.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BoNhoTrong boNhoTrong = LayTT();
        try {
            if (boNhoTrongService.them(boNhoTrong)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                HienThi();
                txtBoNhoTrong.setText("");
                txtId.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String checkChu = "^[a-zA-Z\\s]*$";
        String khoangTrang = "^[\\s]*$";
        String checkKiTu = "^[a-zA-Z0-9\\s+]*$";
        if (txtBoNhoTrong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập chọn 1 bản ghi trước khi sửa !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!txtBoNhoTrong.getText().matches(checkKiTu)) {
            JOptionPane.showMessageDialog(this, "Tên Bộ nhớ trong không được chưa kí tự đặc biệt !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtBoNhoTrong.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên Bộ nhớ trong không được nhập toàn khoản trắng !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if(txtCpu.getText().trim().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Không được để trống");
//        }
        if (txtBoNhoTrong.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BoNhoTrong c = LayTT();
        Integer id = Integer.parseInt(txtId.getText());
        try {
            if (boNhoTrongService.sua(c, id)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                HienThi();
                txtId.setText("");
                txtBoNhoTrong.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbBoNhoTrongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBoNhoTrongMousePressed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_tbBoNhoTrongMousePressed

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
            java.util.logging.Logger.getLogger(BoNhoTrongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoNhoTrongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoNhoTrongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoNhoTrongForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoNhoTrongForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnClear;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private chucNang.Table01 tbBoNhoTrong;
    private chucNang.TextField txtBoNhoTrong;
    private javax.swing.JLabel txtId;
    // End of variables declaration//GEN-END:variables
}
