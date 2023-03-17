/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import Service.Impl.DanhMucIplm;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class DanhMuc extends javax.swing.JFrame {

    private DanhMucIplm danhMucIplm;
    private DefaultTableModel dtm;

    /**
     * Creates new form DanhMuc
     */
    public DanhMuc() {
        initComponents();
        dtm = (DefaultTableModel) tblRow.getModel();
        danhMucIplm = new DanhMucIplm();
        String[] header = {"ID", "Tên danh mục", "Ngày tạo", "Ngày sửa", "Trạng thái"};
        dtm.setColumnIdentifiers(header);
        fillData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table011 = new chucNang.Table01();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new chucNang.TextField();
        txtNgayTao = new chucNang.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRow = new chucNang.Table01();
        btnAdd = new chucNang.MyButton();
        btnEdit = new chucNang.MyButton();
        btnDelete = new chucNang.MyButton();
        btnNew = new chucNang.MyButton();
        txtNgaySua = new chucNang.TextField();
        rdoCon = new javax.swing.JRadioButton();
        rdoHet = new javax.swing.JRadioButton();

        table011.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table011);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DANH MỤC");

        txtTen.setLabelText("Tên danh mục");

        txtNgayTao.setLabelText("Ngày tạo");

        tblRow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID danh mục", "Tên danh mục", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ));
        tblRow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRowMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRow);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        txtNgaySua.setLabelText("Ngày sửa");

        buttonGroup1.add(rdoCon);
        rdoCon.setText("Còn");

        buttonGroup1.add(rdoHet);
        rdoHet.setText("Hết");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoCon)
                                .addGap(18, 18, 18)
                                .addComponent(rdoHet))
                            .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoCon)
                    .addComponent(rdoHet))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtTen.setText("");
        txtNgayTao.setText("");
        txtNgaySua.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        DomainModel.DanhMuc dm = new DomainModel.DanhMuc();
        dm.setTenDanhMuc(txtTen.getText());
        dm.setNgayTao(txtNgayTao.getText());
        dm.setNgaySua(txtNgaySua.getText());
        if (dm.isTrangThai() == true) {
            rdoCon.isSelected();
        } else if (dm.isTrangThai() == false) {
            rdoHet.isSelected();
        }
        if (danhMucIplm.add(dm)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            showTable(danhMucIplm.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại!");
            return;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblRowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRowMouseClicked
        // TODO add your handling code here:
        int index = tblRow.getSelectedRow();
        if (index == -1) {
            return;
        }
        List<DomainModel.DanhMuc> danhMucs = danhMucIplm.getAll();
        DomainModel.DanhMuc dm = danhMucs.get(index);
        txtTen.setText(dm.getTenDanhMuc());
        txtNgayTao.setText(dm.getNgayTao());
        txtNgaySua.setText(dm.getNgaySua());
        if (dm.isTrangThai() == true) {
            rdoCon.setSelected(true);
        }
        if (dm.isTrangThai() == false) {
            rdoHet.setSelected(true);
        }
    }//GEN-LAST:event_tblRowMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int index = tblRow.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn!");
            return;
        }
        int kq = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa!", "Cảnh báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
            List<DomainModel.DanhMuc> danhMucs = danhMucIplm.getAll();
            DomainModel.DanhMuc dm = danhMucs.get(index);
            try {
                String id = danhMucs.get(index).getId();
                danhMucIplm.delete(id);
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                showTable(danhMucIplm.getAll());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int index = tblRow.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn để sửa!");
            return;
        }
        List<DomainModel.DanhMuc> danhMucs = danhMucIplm.getAll();
        DomainModel.DanhMuc dm = danhMucs.get(index);
        dm.setTenDanhMuc(txtTen.getText());
        dm.setNgayTao(txtNgayTao.getText());
        dm.setNgaySua(txtNgaySua.getText());
        if (dm.isTrangThai() == true) {
            rdoCon.isSelected();
        } else {
            rdoHet.isSelected();
        }
        try {
            String id = danhMucs.get(index).getId();
            danhMucIplm.update(dm, id);
            JOptionPane.showMessageDialog(this, "Update thành công!");
            showTable(danhMucIplm.getAll());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    public void fillData() {
        List<DomainModel.DanhMuc> danhMucs = danhMucIplm.getAll();
        if (danhMucs == null) {
            JOptionPane.showMessageDialog(this, "Lỗi");
            return;
        } else if (danhMucs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rỗng");
            return;
        }
        showTable(danhMucIplm.getAll());

    }

    public void showTable(List<DomainModel.DanhMuc> list) {
        dtm.setRowCount(0);
        for (DomainModel.DanhMuc dm : list) {
            Object[] row = new Object[]{
                dm.getId(), dm.getTenDanhMuc(),
                dm.getNgayTao(), dm.getNgaySua(),
                dm.isTrangThai() == true ? "Còn" : "Hết"
            };
            dtm.addRow(row);
        }
    }

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
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhMuc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnAdd;
    private chucNang.MyButton btnDelete;
    private chucNang.MyButton btnEdit;
    private chucNang.MyButton btnNew;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoHet;
    private chucNang.Table01 table011;
    private chucNang.Table01 tblRow;
    private chucNang.TextField txtNgaySua;
    private chucNang.TextField txtNgayTao;
    private chucNang.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}
