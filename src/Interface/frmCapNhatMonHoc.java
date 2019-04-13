/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Process.MonHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class frmCapNhatMonHoc extends javax.swing.JFrame {

    private final MonHoc monHoc = new MonHoc();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private boolean isNew = true;
    
    public final void LoadDataCombo() {
        ResultSet result = null;
        try {
            result = monHoc.LoadBoMon();
            while (result.next()) {
                cboBoMon.addItem(result.getString("MaBM"));
            }
        } catch (SQLException e) {
        }
    }
    
    public final void LoadDataTable() throws SQLException {
    ResultSet result = null;
    result = monHoc.LoadMonHoc();
    try {
        ClearDataTable();
        while (result.next()) {
            String rows[] = new String[4];
            rows[0] = result.getString(1);
            rows[1] = result.getString(2);
            rows[2] = result.getString(3);
            rows[3] = result.getString(5);
            tableModel.addRow(rows);
        }
        } catch (SQLException e) {
        }
    }
    
    private void setEmptyTextBox() {
        txtMaMH.setText(null);
        txtMaMH.requestFocus();
        txtTenMH.setText(null);
        txtSoTiet.setText(null);
        txtTenBM.setText(null);
    }
    private void lockTextBox(boolean e) {
        txtMaMH.setEnabled(!e);
        txtTenMH.setEnabled(!e);
        txtSoTiet.setEnabled(!e);
        cboBoMon.setEnabled(!e);
        txtTenBM.setEnabled(!e);
    }
    
    private void enableButton(boolean e) {
        btnThem.setEnabled(e);
        btnXoa.setEnabled(e);
        btnSua.setEnabled(e);
        
        btnLuu.setEnabled(!e);
        btnKhongLuu.setEnabled(!e);
        btnThoat.setEnabled(e);
    }
    
    public void ClearDataTable() throws SQLException {
    int n = tableModel.getRowCount() - 1;
    for (int i = n; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    public frmCapNhatMonHoc() {
        initComponents();
                // Define table columns
        String[] colsName = {"Mã MH", "Tên Môn Học", "Số Tiết", " Mã BM"};
        tableModel.setColumnIdentifiers(colsName);
        jTableMonHoc.setModel(tableModel); 
        try {
            // Load data table
            LoadDataTable();
        } catch (SQLException ex) {
            Logger.getLogger(frmCapNhatMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Load combobox BoMon
        LoadDataCombo();
        // set empty all textboxes
        setEmptyTextBox();     
        // Dsiable all textboxes
        lockTextBox(true);
        // Enable some buttons and disable others
        enableButton(true);


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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaMH = new javax.swing.JTextField();
        txtSoTiet = new javax.swing.JTextField();
        txtTenMH = new javax.swing.JTextField();
        txtTenBM = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKhongLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMonHoc = new javax.swing.JTable();
        cboBoMon = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QUAN LI MON HOC");

        jLabel2.setText("Ma MH");

        jLabel3.setText("So Tiet");

        jLabel4.setText("Ten MH");

        jLabel5.setText("Bo Mon");

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setText("Luu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKhongLuu.setText("Khong Luu");
        btnKhongLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongLuuActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoat");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jTableMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma MH", "Ten Mon Hoc", "So Tiet ", "Ma MH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMonHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMonHoc);

        cboBoMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBoMonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKhongLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThoat))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtSoTiet)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboBoMon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenBM, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBoMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnKhongLuu)
                    .addComponent(btnThoat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMonHocMouseClicked
        try {
            int row = jTableMonHoc.getSelectedRow();
            String maMH = (jTableMonHoc.getModel().getValueAt(row, 0)).toString();
            ResultSet rs = monHoc.LoadMonHoc(maMH);
            if (rs.next())
            {
                txtMaMH.setText(rs.getString("MaMH"));
                txtTenMH.setText(rs.getString("TenMH"));
                txtSoTiet.setText(rs.getString("SoTiet"));
                cboBoMon.setSelectedItem(rs.getString("MaBM"));
                txtTenBM.setText(rs.getString("TenBM"));
            }
        } catch (SQLException e) {
        }

    }//GEN-LAST:event_jTableMonHocMouseClicked

    private void cboBoMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBoMonItemStateChanged
        try {
            String maBM = cboBoMon.getSelectedItem().toString();
            ResultSet result = monHoc.LoadBoMon(maBM);
            if (result.next()) {
                txtTenBM.setText(result.getString("TenBM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmCapNhatMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboBoMonItemStateChanged

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       String maMH = txtMaMH.getText();
        try {
            if(maMH.length() == 0) {
                JOptionPane.showMessageDialog(null, "Can chon 1 mon hoc de xoa", "Thong bao", 1);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Ban muon xoa mon hoc " + maMH
                    + " nay hay khong?", "Thong bao", 2) == 0) {
                monHoc.DeleteMonHoc(maMH);
                ClearDataTable();
                LoadDataTable();
                setEmptyTextBox();
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(frmCapNhatMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        setEmptyTextBox();
        lockTextBox(false);
        enableButton(false);
        isNew = true;
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String maMH = txtMaMH.getText();
        if (maMH.length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Vui long chon loi can sua",
                "Thong Bao", 1);
        } else {
            lockTextBox(false);
            enableButton(false);
            isNew = false;
            txtMaMH.setEnabled(false);
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String maMH = txtMaMH.getText();
        String soTietTemp = txtSoTiet.getText();
        String tenMH = txtTenMH.getText();
        int soTiet = Integer.parseInt(soTietTemp);
        String tenBM = cboBoMon.getSelectedItem().toString();
        if (maMH.length() == 0 || soTiet == 0 ||tenMH.length() == 0 || tenBM.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui long nhap du truong", "Thong bao", 1);
        } else if (maMH.length() >4 || soTiet <= 0) {
            JOptionPane.showMessageDialog(null,"Ma loai chi 2 ky tu, ten loai la 20", "Thong bao", 1);
        } else {
            try {
                if (isNew == true) //Luu cho tthem moi
                {
                    monHoc.InsertMonHoc(maMH,tenMH,soTiet,tenBM);
                } else {
                    monHoc.EditMonHoc(maMH, tenMH, soTiet, tenBM);
                }
                ClearData(); 
                LoadDataTable(); 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cap nhat that bai","Thong bao", 1);
            }
            lockTextBox(true);
            enableButton(true);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKhongLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuuActionPerformed
        // TODO add your handling code here:
        setEmptyTextBox();
        lockTextBox(true);
        enableButton(true);
    }//GEN-LAST:event_btnKhongLuuActionPerformed
     public void ClearData() throws SQLException {
        //Lay chi so dong cuoi cung
        int n = tableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            tableModel.removeRow(i);//Remove tung dong
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
    frmCapNhatMonHoc f = new frmCapNhatMonHoc();
       f.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhongLuu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboBoMon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMonHoc;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtSoTiet;
    private javax.swing.JTextField txtTenBM;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
