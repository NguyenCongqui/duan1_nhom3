/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import DomainModel.TaiKhoan;
import Service.Impl.TaiKhoanImpl;
import Services.TaiKhoanService;
import javax.swing.JOptionPane;
import view.logiin.Auth;

/**
 *
 * @author ADMIN
 */
public class DoiMatKhau extends javax.swing.JPanel {

    TaiKhoanService taiKhoanService = new TaiKhoanImpl();
    
    public DoiMatKhau() {
        initComponents();
        edit();
        
    }
    public void edit() {
        TaiKhoan a = taiKhoanService.getdoimatkhau(Auth.user.getIdUser());;
        setForm(a);
    }
     public void setForm(TaiKhoan b) {
       txt_userName.setText(b.getUsersName());
       txt_pass.setText(b.getMatKhau());
    }
     TaiKhoan getForm() {
        TaiKhoan tk = new TaiKhoan();
        tk.setMatKhau(new String(txt_NhapLaiMatKhau.getPassword()));
        return tk;
    }
public void reset(){
        txt_matKhauMoi.setText("");
        txt_NhapLaiMatKhau.setText("");
    }
public void updatePassword() {
        try {
            if (!new String(txt_matKhauMoi.getPassword()).equals(new String(txt_NhapLaiMatKhau.getPassword()))) {
                JOptionPane.showMessageDialog(this,"Mật khẩu không trùng khớp");
                return;
            } else if (new String(txt_NhapLaiMatKhau.getPassword()).equals(new String(txt_pass.getPassword()))) {
                JOptionPane.showMessageDialog(this,"Mật mới không được trùng mật khẩu trước đó");
                return;
            } else {
           
                TaiKhoan a = getForm();
                int idUser = Auth.user.getIdUser();
                a.setIdUsers(idUser);
                JOptionPane.showMessageDialog(this,taiKhoanService.update(a));
               reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
           // System.out.println("doi khong thanh cong");
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

        txt_userName = new chucNang.TextField();
        jLabel1 = new javax.swing.JLabel();
        btn_DoiMatkhau = new chucNang.MyButton();
        txt_pass = new chucNang.PasswordField();
        txt_matKhauMoi = new chucNang.PasswordField();
        txt_NhapLaiMatKhau = new chucNang.PasswordField();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_userName.setLabelText("Username");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Đổi Mật Khẩu");

        btn_DoiMatkhau.setText("Đổi Mật Khẩu");
        btn_DoiMatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoiMatkhauActionPerformed(evt);
            }
        });

        txt_pass.setEditable(false);
        txt_pass.setLabelText("PassWord");

        txt_matKhauMoi.setLabelText("New PassWord");

        txt_NhapLaiMatKhau.setLabelText("VerifyPassWord");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_DoiMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_matKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_NhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_matKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(btn_DoiMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DoiMatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoiMatkhauActionPerformed
        // TODO add your handling code here:
        updatePassword();
    }//GEN-LAST:event_btn_DoiMatkhauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btn_DoiMatkhau;
    private javax.swing.JLabel jLabel1;
    private chucNang.PasswordField txt_NhapLaiMatKhau;
    private chucNang.PasswordField txt_matKhauMoi;
    private chucNang.PasswordField txt_pass;
    private chucNang.TextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
