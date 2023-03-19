/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import Service.Impl.CameraImpl;
import Services.ICameraService;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import DomainModel.Camera;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author trung
 */
public class CameraForm extends javax.swing.JFrame {
    private ICameraService service ;
    
    /**
     * Creates new form Camera
     */
    public CameraForm() {
        try {
            initComponents();
            service = new CameraImpl();
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void HienThi () throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tbCamera.getModel();
        model.setRowCount(0);
        List<Camera> list = service.getAll();
        
        for (Camera camera : list) {
            Integer trangThai = 0 ;
            if (camera.isTrangThai() == false) {
                trangThai = 0 ;
            }
            else{
                trangThai = 1 ;
            }
            if(trangThai == 0){
                Object[] data = new Object[]{
                    camera.getId(),
                    camera.getName(),
                };
               model.addRow(data);
            }
        }
    }
    
    public Camera LayTT(){
        String ten = txtCamera.getText();
        return new Camera(0, ten, true);
    }
    public void fill(){
        int index = tbCamera.getSelectedRow();
        String id = tbCamera.getValueAt(index, 0).toString();
        String ten = tbCamera.getValueAt(index, 1).toString();
        txtCamera.setText(ten);
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

        jLabel1 = new javax.swing.JLabel();
        txtCamera = new chucNang.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCamera = new chucNang.Table01();
        btnThem = new chucNang.MyButton();
        btnSua = new chucNang.MyButton();
        btnXoa = new chucNang.MyButton();
        btnClear = new chucNang.MyButton();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Camera");

        txtCamera.setLabelText("Tên Camera");

        tbCamera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Tên Camera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCameraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCamera);

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnThemMousePressed(evt);
            }
        });

        btnSua.setText("Sửa ");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSuaMousePressed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXoaMousePressed(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtCamera.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void tbCameraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCameraMousePressed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_tbCameraMousePressed

    private void btnThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMousePressed
        // TODO add your handling code here:
        if(txtCamera.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Không được để trống");
        }
        if(txtCamera.getText().length() > 30){
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return;
        }
        Camera c = LayTT();
        try {
            if(service.them(c)){
               JOptionPane.showMessageDialog(this, "Them thanh cong");
               HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Them that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemMousePressed

    private void btnSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMousePressed
        // TODO add your handling code here:
          if(txtCamera.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Không được để trống");
        }
        if(txtCamera.getText().length() > 30){
            JOptionPane.showMessageDialog(this, "Tên không được quá 30 kí tự");
            return;
        }
        Camera c = LayTT();
        Integer id = Integer.parseInt(txtId.getText());
        try {
            if(service.sua(c,id)){
               JOptionPane.showMessageDialog(this, "Sua thanh cong");
               HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Sua that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaMousePressed

    private void btnXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMousePressed
        // TODO add your handling code here:
        Integer id = Integer.parseInt(txtId.getText());
        try {
            if(service.xoa(id)){
               JOptionPane.showMessageDialog(this, "Xoa thanh cong");
               HienThi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Xoa that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaMousePressed

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
            java.util.logging.Logger.getLogger(CameraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CameraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CameraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CameraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CameraForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnClear;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private chucNang.Table01 tbCamera;
    private chucNang.TextField txtCamera;
    private javax.swing.JLabel txtId;
    // End of variables declaration//GEN-END:variables
}
