/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import DomainModel.KhachHang;
import Service.Impl.KhachHangImpl;
import Services.IKhachHangService;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hodangquan
 */
public class KhachHangForm1 extends javax.swing.JFrame {
        private IKhachHangService service;
    /**
     * Creates new form KhachHangForm1
     */
    public KhachHangForm1() {
        
        try {
            initComponents();
            setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            service = new KhachHangImpl();
            HienThi();
        } catch (SQLException ex) {
            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void HienThi() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        List<KhachHang> list = service.getAll();

        for (KhachHang khachHang : list) {
            Integer trangThai = 0;
            if (khachHang.isTrangThai() == false) {
                trangThai = 0;
            } else {
                trangThai = 1;
            }
            String gioiTinh = "Nam";
            if (khachHang.isGioiTinh() == false) {
                gioiTinh = "Nữ";
            }
            if (trangThai == 0) {
                Object[] data = new Object[]{
                    khachHang.getId(),
                    khachHang.getHoTen(),
                    khachHang.getNgaySinh(),
                    gioiTinh,
                    khachHang.getSoDienThoai(),
                    khachHang.getDiaChi(),};
                model.addRow(data);
            }
        }
    }

    public KhachHang LayTT() throws ParseException {
        String ten = txtTenKhachHang.getText();
        //String ngaySinh = "MM-dd-yyyy";
        //DateFormat df = new SimpleDateFormat(ngaySinh);
        String ngaySinhs;
        ngaySinhs = (txtNgaySinh.getText());

        //String ngaySinhs = df.format(date);
        Boolean gioiTinh = true;
        if (rbNam.isSelected() == true) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        String sdt = txtSodienthoai.getText();
        String diaChi = txtDiaChi.getText();
        KhachHang kh = new KhachHang(0, ten, ngaySinhs, gioiTinh, sdt, diaChi, true);
        return kh;
    }

    public void fill() {

        try {
            int index = tbKhachHang.getSelectedRow();
            String id = tbKhachHang.getValueAt(index, 0).toString();
            String ten = tbKhachHang.getValueAt(index, 1).toString();
            String ngaySinh = tbKhachHang.getValueAt(index, 2).toString();

            String gioiTinh = tbKhachHang.getValueAt(index, 3).toString();
            String sdt = tbKhachHang.getValueAt(index, 4).toString();
            String diaChi = tbKhachHang.getValueAt(index, 5).toString();

            txtIdKhachHang.setText(id);
            txtTenKhachHang.setText(ten);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
            txtNgaySinh.setText(ngaySinh);
            //txtNgaySinh.setDate(date);
            System.out.println(gioiTinh);
            if (gioiTinh.equals("Nam")) {
                rbNam.setSelected(true);
            } else {
                rbNu.setSelected(true);
            }
            txtSodienthoai.setText(sdt);
            txtDiaChi.setText(diaChi);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void insnsert(){
        try { 
            
            String checkChu = "^[a-zA-Z\\s]*$";
            String khoangTrang = "^[\\s]*$";
            String so = "^[-?0-9]*$"; 
            String checkPrice = "^[-?0-9\\.]*$";
            String checkSo = "^[\\s]*$";
            String checkKiTu = "^[a-zA-Z0-9\\s+]*$";
            // TODO add your handling code here:
            if (txtTenKhachHang.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, " Vui lòng nhập tên khách hàng trước khi thêm ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDiaChi.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, " Vui lòng nhập địa chỉ khách hàng trước khi thêm ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, " Vui lòng nhập số điện thoại khách hàng trước khi thêm ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().replaceAll("[^ ]", "").length() > 0) {
                JOptionPane.showMessageDialog(this, "Số điện thoại viết liền và không chứa khoảng trắng! ", "thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!txtSodienthoai.getText().matches(so)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải là số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().length() > 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải 10 số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().length() < 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải 10 số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            KhachHang kh = LayTT();
            if (service.them(kh) == true) {
                JOptionPane.showMessageDialog(this, "Thêm thành công","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                HienThi();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
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

        date = new com.raven.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new chucNang.Table01();
        jPanel1 = new javax.swing.JPanel();
        txtTenKhachHang = new chucNang.TextField();
        rbNam = new chucNang.RadioButtonCustom();
        rbNu = new chucNang.RadioButtonCustom();
        txtGioiTinh = new javax.swing.JLabel();
        txtDiaChi = new chucNang.TextField();
        btnThem = new chucNang.MyButton();
        btnSua = new chucNang.MyButton();
        btnXoa = new chucNang.MyButton();
        btnCrear = new chucNang.MyButton();
        txtSodienthoai = new chucNang.TextField();
        txtNgaySinh = new chucNang.TextField();
        txtIdKhachHang = new javax.swing.JLabel();
        txtIdKhachHang1 = new javax.swing.JLabel();

        date.setDateFormat("yyyy-MM-dd");
        date.setTextRefernce(txtNgaySinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Khách Hàng");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Giới Tính", "Số Điện Thoại", "Địa Chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbKhachHangMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTenKhachHang.setLabelText("Tên Khách Hàng");
        txtTenKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHangActionPerformed(evt);
            }
        });

        rbNam.setText("Nam");

        rbNu.setText("Nữ");

        txtGioiTinh.setText("Giới Tính");

        txtDiaChi.setLabelText("Địa chỉ\n");

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

        btnCrear.setText("Clear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        txtSodienthoai.setLabelText("Số điện thoại");
        txtSodienthoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSodienthoaiActionPerformed(evt);
            }
        });

        txtNgaySinh.setEditable(false);
        txtNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        txtNgaySinh.setLabelText("Ngày Sinh");

        txtIdKhachHang1.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(rbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdKhachHang1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdKhachHang))
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdKhachHang1)
                    .addComponent(txtIdKhachHang))
                .addGap(18, 18, 18)
                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtGioiTinh)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMousePressed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_tbKhachHangMousePressed

    private void txtTenKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHangActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
//        try {
//            String checkChu = "^[a-zA-Z\\s]*$";
//            String khoangTrang = "^[\\s]*$";
//            String so = "^[-?0-9]*$"; 
//            String checkPrice = "^[-?0-9\\.]*$";
//            String checkSo = "^[\\s]*$";
//            String checkKiTu = "^[a-zA-Z0-9\\s+]*$";
//            // TODO add your handling code here:
//            if (txtTenKhachHang.getText().isBlank()) {
//                JOptionPane.showMessageDialog(this, " Vui lòng nhập tên khách hàng trước khi sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            if (txtDiaChi.getText().isBlank()) {
//                JOptionPane.showMessageDialog(this, " Vui lòng nhập địa chỉ khách hàng trước khi sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            if (txtSodienthoai.getText().isBlank()) {
//                JOptionPane.showMessageDialog(this, " Vui lòng nhập số điện thoại khách hàng trước khi sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            if (txtSodienthoai.getText().replaceAll("[^ ]", "").length() > 0) {
//                JOptionPane.showMessageDialog(this, "Số điện thoại viết liền và không chứa khoảng trắng! ", "thông báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            if (!txtSodienthoai.getText().matches(so)) {
//                JOptionPane.showMessageDialog(this, "Số điện thoại phải là số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            if (txtSodienthoai.getText().length() > 10) {
//                JOptionPane.showMessageDialog(this, "Số điện thoại phải 10 số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            if (txtSodienthoai.getText().length() < 10) {
//                JOptionPane.showMessageDialog(this, "Số điện thoại phải 10 số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            int index = tbKhachHang.getSelectedRow();
//            if (index == -1) {
//                JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 bản ghi trước khi sửa");
//                return;
//            }
//            // TODO add your handling code here:
//            KhachHang kh = LayTT();
//            Integer id = Integer.parseInt(tbKhachHang.getValueAt(index, 0).toString());
//            if (service.sua(kh, id) == true) {
//                JOptionPane.showMessageDialog(this, "Sửa thành công");
//                HienThi();
//            } else {
//                JOptionPane.showMessageDialog(this, "Sửa thất bại");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            String checkChu = "^[a-zA-Z\\s]*$";
            String khoangTrang = "^[\\s]*$";
            String so = "^[-?0-9]*$"; 
            String checkPrice = "^[-?0-9\\.]*$";
            String checkSo = "^[\\s]*$";
            String checkKiTu = "^[a-zA-Z0-9\\s+]*$";
            // TODO add your handling code here:
            if (txtTenKhachHang.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, " Vui lòng nhập tên khách hàng trước khi sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDiaChi.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, " Vui lòng nhập địa chỉ khách hàng trước khi sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, " Vui lòng nhập số điện thoại khách hàng trước khi sửa ! ", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().replaceAll("[^ ]", "").length() > 0) {
                JOptionPane.showMessageDialog(this, "Số điện thoại viết liền và không chứa khoảng trắng! ", "thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!txtSodienthoai.getText().matches(so)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải là số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().length() > 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải 10 số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSodienthoai.getText().length() < 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải 10 số ! ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int index = tbKhachHang.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 bản ghi trước khi sửa","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // TODO add your handling code here:
            KhachHang kh = LayTT();
            Integer id = Integer.parseInt(tbKhachHang.getValueAt(index, 0).toString());
            if (service.sua(kh, id) == true) {
                JOptionPane.showMessageDialog(this, "Sửa thành công","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                HienThi();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        Integer id = Integer.parseInt(txtIdKhachHang.getText());
//        try {
//            if (service.xoa(id)) {
//                JOptionPane.showMessageDialog(this, "Xóa thành công");
//                HienThi();
//
//            } else {
//                JOptionPane.showMessageDialog(this, "Xóa thất bại");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CameraForm.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        try {
            // TODO add your handling code here:
            int index = tbKhachHang.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 bản ghi trước khi xóa :)) ","Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
//            int index1 = tbCpu.getRowCount();
//            if (index1 == 0) {
//                JOptionPane.showMessageDialog(this, "Không có dữ kiệu có dữ liệu để xóa :))");
//                return;
//            }
            int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không ? ","Thông Báo", JOptionPane.ERROR_MESSAGE);
            if (check != JOptionPane.YES_OPTION) {
                return;
            } else {
                String idString = tbKhachHang.getValueAt(index, 0).toString();
                Integer id = Integer.parseInt(idString);
                if (service.xoa(id) == true) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công  ","Thông Báo", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại ","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
                }
                HienThi();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        txtIdKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtNgaySinh.setToolTipText("");
        txtGioiTinh.setText("");
        txtSodienthoai.setText("");
        txtDiaChi.setText("");
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtSodienthoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSodienthoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSodienthoaiActionPerformed

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
            java.util.logging.Logger.getLogger(KhachHangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangForm1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chucNang.MyButton btnCrear;
    private chucNang.MyButton btnSua;
    private chucNang.MyButton btnThem;
    private chucNang.MyButton btnXoa;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private chucNang.RadioButtonCustom rbNam;
    private chucNang.RadioButtonCustom rbNu;
    private chucNang.Table01 tbKhachHang;
    private chucNang.TextField txtDiaChi;
    private javax.swing.JLabel txtGioiTinh;
    private javax.swing.JLabel txtIdKhachHang;
    private javax.swing.JLabel txtIdKhachHang1;
    private chucNang.TextField txtNgaySinh;
    private chucNang.TextField txtSodienthoai;
    private chucNang.TextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables

    void addEvenFillTable(ActionListener evt) {
       btnThem.addActionListener(evt);
    }
}
