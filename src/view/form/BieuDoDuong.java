/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import chartBieuDoDuong.ModelChart;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BieuDoDuong extends javax.swing.JFrame {

    /**
     * Creates new form BieuDoDuong
     */
    public BieuDoDuong(DefaultTableModel tbl_BieuDoDuong) {
        initComponents();
         init(tbl_BieuDoDuong);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
     public BieuDoDuong(DefaultTableModel model, String str) {
        initComponents();
        initRevenue(model);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
      public String deleteLastKey(String str) {
        if (str.charAt(str.length() - 1) == 'đ') {
            str = str.replace(str.substring(str.length() - 1), "");
            return str;
        } else {
            return str;
        }
    }
    public String fomartFloat(String txt) {
        String pattern = deleteLastKey(txt);
        return pattern = pattern.replaceAll(",", "");
    }
     private void init(DefaultTableModel tbl_BieuDoDuong) {
        chart.addLegend("Sản phẩm", new Color(12, 84, 175), new Color(0, 108, 247));
        for (int j = 0; j < tbl_BieuDoDuong.getRowCount(); j++) {
            if (j == 10) {
                break;
            }
            chart.addData(new ModelChart(  (String) tbl_BieuDoDuong.getValueAt(j, 1), new double[]{(int) tbl_BieuDoDuong.getValueAt(j, 2)}));
        }
        chart.start();
    }

    private BieuDoDuong() {
        
    }
     private void initRevenue(DefaultTableModel tbl_thongkedoanhso) {
        chart.addLegend("Tổng giá bán", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.addLegend("Tống giá nhập", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addLegend("Tổng giá khuyến mãi", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Doanh thu", new Color(12, 84, 175), new Color(0, 108, 247));

        for (int j = 0; j < tbl_thongkedoanhso.getRowCount(); j++) {
            chart.addData(new ModelChart((int) tbl_thongkedoanhso.getValueAt(j, 0) + "", new double[]{
                //                (int) tableShow.getValueAt(j, 1),
                Float.parseFloat(fomartFloat((String) tbl_thongkedoanhso.getValueAt(j, 2))),
                Float.parseFloat(fomartFloat((String) tbl_thongkedoanhso.getValueAt(j, 3))),
                Float.parseFloat(fomartFloat((String) tbl_thongkedoanhso.getValueAt(j, 4))),
                Float.parseFloat(fomartFloat((String) tbl_thongkedoanhso.getValueAt(j, 5)))

            }));
        }
        chart.start();
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
        chart = new chartBieuDoDuong.CurveChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(BieuDoDuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BieuDoDuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BieuDoDuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BieuDoDuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BieuDoDuong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chartBieuDoDuong.CurveChart chart;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
