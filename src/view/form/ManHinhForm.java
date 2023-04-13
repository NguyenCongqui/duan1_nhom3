/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import DomainModel.ManHinh;
import Service.Impl.ManHinhImpl;
import Services.IManHinhService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hodangquan
 */
public class ManHinhForm extends javax.swing.JFrame {
    private IManHinhService service ;
    /**
     * Creates new form ManHinh
     */
    public ManHinhForm() {
        
        try {
            initComponents();
            service = new ManHinhImpl();
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void HienThi () throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tbManHinh.getModel();
        model.setRowCount(0);
        List<ManHinh> list = service.getAll();
        
        for (ManHinh manHinh : list) {
            Integer trangThai = 0 ;
            if (manHinh.isTrangThai() == false) {
                trangThai = 0 ;
            }
            else{
                trangThai = 1 ;
            }
            if(trangThai == 0){
                Object[] data = new Object[]{
                    manHinh.getId(),
                    manHinh.getName(),
                    manHinh.getNgayTao(),
                    manHinh.getNgaySua()
                        
                };
               model.addRow(data);
            }
            txtId.setText("");
        txtManHinh.setText("");
        }
    }
    public ManHinh LayTT(){
        String ten = txtManHinh.getText();
        return new ManHinh(0, ten, true);
    }
    public void fill(){
        int index = tbManHinh.getSelectedRow();
        String id = tbManHinh.getValueAt(index, 0).toString();
        String ten = tbManHinh.getValueAt(index, 1).toString();
        txtManHinh.setText(ten);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtManHinh = new chucNang.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbManHinh = new chucNang.Table01();
        btnThem = new chucNang.MyButton();
        btnSua = new chucNang.MyButton();
        btnXoa = new chucNang.MyButton();
        btnNew = new chucNang.MyButton();
        txtId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Màn Hình");

        txtManHinh.setLabelText("Tên màn hình");

        tbManHinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên màn hình", "Ngày Sửa", "Ngày Tạo"
            }
        ));
        tbManHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbManHinhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbManHinhMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbManHinh);

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

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnNew.setText("Clear");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        txtId.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(txtId)
                .addGap(18, 18, 18)
                .addComponent(txtManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        Integer id = Integer.parseInt(txtId.getText());
//        try {
//            if(service.xoa(id)){
//               JOptionPane.showMessageDialog(this, "Xóa thành công");
//               HienThi();
//            }
//            else{
//                JOptionPane.showMessageDialog(this, "Xóa thất bại");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            // TODO add your handling code here:
            int index = tbManHinh.getSelectedRow();
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
                String idString = tbManHinh.getValueAt(index, 0).toString();
                Integer id = Integer.parseInt(idString);
                if (service.xoa(id) == true) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công   ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
                HienThi();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtManHinh.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
//        if(txtManHinh.getText().trim().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Không được để trống");
//        }
//        if(txtManHinh.getText().length() > 30){
//            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
//            return;
//        }
        String checkChu = "^[a-zA-Z\\s]*$";
        String khoangTrang = "^[\\s]*$";
        String checkKiTu = "^[a-zA-Z0-9\\s+]*$";
        if (txtManHinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập kích thước màn hình trước khi thêm !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if (!txtManHinh.getText().matches(checkKiTu)) {
//            JOptionPane.showMessageDialog(this, "kích thước màn hình không được chưa kí tự đặc biệt !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        if (txtManHinh.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "kích thước màn hình không được nhập toàn khoản trắng !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if(txtCpu.getText().trim().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Không được để trống");
//        }
        if (txtManHinh.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "kích thước màn hình không được quá 30 kí tự", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ManHinh manHinh = LayTT();
        try {
            if(service.them(manHinh)){
               JOptionPane.showMessageDialog(this, "Thêm thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
               HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
//        if(txtManHinh.getText().trim().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Không được để trống");
//        }
//        if(txtManHinh.getText().length() > 30){
//            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        String checkChu = "^[a-zA-Z\\s]*$";
        String khoangTrang = "^[\\s]*$";
        String checkKiTu = "^[a-zA-Z0-9\\s+]*$";
        if (txtManHinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 bản ghi trước khi sửa !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if (!txtManHinh.getText().matches(checkKiTu)) {
//            JOptionPane.showMessageDialog(this, "Kích thước màn hình không được chưa kí tự đặc biệt !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        if (txtManHinh.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Kích thước màn hình không được nhập toàn khoản trắng !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if(txtCpu.getText().trim().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Không được để trống");
//        }
        if (txtManHinh.getText().length() > 30) {
            JOptionPane.showMessageDialog(this, "Kích thước màn hình không được quá 30 kí tự", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ManHinh manHinh = LayTT();
        Integer id = Integer.parseInt(txtId.getText());
        try {
            if(service.sua(manHinh,id)){
               JOptionPane.showMessageDialog(this, "Sửa thành công", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
               HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Sửa thất bại", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbManHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbManHinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbManHinhMouseClicked

    private void tbManHinhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbManHinhMousePressed
        // TODO add your handling code here:
         fill();
    }//GEN-LAST:event_tbManHinhMousePressed

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
            java.util.logging.Logger.getLogger(ManHinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinhForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnNew;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private chucNang.Table01 tbManHinh;
    private javax.swing.JLabel txtId;
    private chucNang.TextField txtManHinh;
    // End of variables declaration//GEN-END:variables
}
