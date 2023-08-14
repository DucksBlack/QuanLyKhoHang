/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package View;
import Entity.*;
import ConnectDatabase.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.table.TableModel;

/**
 *
 * @author MRSTHAO
 */
public class QLyTaiKhoan extends javax.swing.JFrame {
    
    
    /**
     * Creates new form QLyTaiKhoan
     * @return 
     */
    public boolean CheckInput(){
        return !(Id_TextField.getText().equals("")||
                UserName_TextField.getText().equals("")||
                Password_TextField.getText().equals("")||
                FullName_TextField.getText().equals("")||
                Address_TextField.getText().equals("")||
                Phone_TextField.getText().equals(""));
    }
    public void JTable_ConnectDb(){
        try {
            String query = "SELECT * FROM users";
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel) Users_Table.getModel(); //tạo liên kết model với User_Table
            // hoặc sau khi gán cho model thì có thể User_Table.setModel(model);
            while (rs.next()){
                Object objList[] = {
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fullname"),
                    rs.getInt("role"),
                    rs.getString("address"),
                    rs.getString("phone")
                };
                model.addRow(objList);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void Reload_View(){
        Id_TextField.setText("");
        UserName_TextField.setText("");
        Password_TextField.setText("");
        FullName_TextField.setText("");
        Role_ComboBox.setSelectedIndex(0);
        Address_TextField.setText("");
        Phone_TextField.setText("");
        //Remove all row of jtable and connect again;
        DefaultTableModel dm = (DefaultTableModel) Users_Table.getModel();
        int rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        JTable_ConnectDb();
    }
    public QLyTaiKhoan() {
        initComponents();
        JTable_ConnectDb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Users_Table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Id_TextField = new javax.swing.JTextField();
        UserName_TextField = new javax.swing.JTextField();
        Password_TextField = new javax.swing.JTextField();
        FullName_TextField = new javax.swing.JTextField();
        Address_TextField = new javax.swing.JTextField();
        Phone_TextField = new javax.swing.JTextField();
        Insert_Button = new javax.swing.JButton();
        Update_Button = new javax.swing.JButton();
        Delete_Button = new javax.swing.JButton();
        Role_ComboBox = new javax.swing.JComboBox<>();
        MesId_Label = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Tài Khoản");

        Users_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tk", "Tên đăng nhập", "Mật khẩu", "Họ tên", "Chức vụ", "Địa chỉ", "SDT"
            }
        ));
        Users_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Users_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Users_Table);

        jLabel2.setText("Mã tk");

        jLabel3.setText("Tên đăng nhập");

        jLabel4.setText("Mật khẩu");

        jLabel5.setText("Chức vụ");

        jLabel6.setText("Họ tên");

        jLabel7.setText("Địa chỉ");

        jLabel8.setText("SĐT");

        Id_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Id_TextFieldKeyPressed(evt);
            }
        });

        Insert_Button.setText("Thêm");
        Insert_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insert_ButtonActionPerformed(evt);
            }
        });

        Update_Button.setText("Sửa");
        Update_Button.setToolTipText("");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });

        Delete_Button.setText("Xóa");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });

        Role_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        MesId_Label.setText("      ");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Password_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(UserName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MesId_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FullName_TextField)
                                    .addComponent(Address_TextField)
                                    .addComponent(Phone_TextField)
                                    .addComponent(Role_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(Insert_Button)
                .addGap(148, 148, 148)
                .addComponent(Update_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Delete_Button)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FullName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Role_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Address_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MesId_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(UserName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Password_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Phone_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert_Button)
                    .addComponent(Update_Button)
                    .addComponent(Delete_Button))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        int yes_no = JOptionPane.showConfirmDialog(this, "Thoát chương trình ?","Thoát",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(yes_no == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void Insert_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert_ButtonActionPerformed
        // TODO add your handling code here:
        if(CheckInput()){
            int id = Integer.parseInt(Id_TextField.getText());
            String username = UserName_TextField.getText();
            String password = Password_TextField.getText();
            int role = Integer.parseInt(Role_ComboBox.getSelectedItem().toString());
            String fullname = FullName_TextField.getText();
            String address = Address_TextField.getText();
            String phone = Phone_TextField.getText();
            Users user1 = UserDAO.getUserById(id);
            Users user2 = UserDAO.getUserByUserName(username);
            if (user1 == null && user2 == null){
                int rs = UserDAO.insert(id,username,password,role,fullname,address,phone);
                if (1 == rs)
                    JOptionPane.showMessageDialog(null,"Thêm thành công !");
                else 
                    JOptionPane.showMessageDialog(null,"Lỗi");
                Reload_View();
            } else if (user1 != null) JOptionPane.showMessageDialog(null,"Đã tồn tại user mã id:"+id);
            else if(user2 != null) JOptionPane.showMessageDialog(null,"Đã tồn tại người dùng tên "+username+". Vui lòng nhập lại");
        } else JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
    }//GEN-LAST:event_Insert_ButtonActionPerformed

    private void Update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ButtonActionPerformed
        // TODO add your handling code here:
        if(CheckInput()){
            int id = Integer.parseInt(Id_TextField.getText());
            String username = UserName_TextField.getText();
            String password = Password_TextField.getText();
            int role = Integer.parseInt(Role_ComboBox.getSelectedItem().toString());
            String fullname = FullName_TextField.getText();
            String address = Address_TextField.getText();
            String phone = Phone_TextField.getText();
            
            Users user = UserDAO.getUserById(id);
            if (user != null){
                int rs = UserDAO.update(id,username,password,role,fullname,address,phone);
                if (1 == rs)
                    JOptionPane.showMessageDialog(null,"Cập nhật thành công");
                else 
                    JOptionPane.showMessageDialog(null,"Lỗi");
                Reload_View();
            }else JOptionPane.showMessageDialog(null,"Ko tìm thấy user mã id:"+id);
        }else JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
    }//GEN-LAST:event_Update_ButtonActionPerformed

    private void Users_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Users_TableMouseClicked
        // TODO add your handling code here:
        int i = Users_Table.getSelectedRow();
        TableModel model = Users_Table.getModel();
        Id_TextField.setText(model.getValueAt(i,0).toString());
        UserName_TextField.setText(model.getValueAt(i,1).toString());
        Password_TextField.setText(model.getValueAt(i,2).toString());
        Role_ComboBox.setSelectedItem(model.getValueAt(i,4).toString());
        FullName_TextField.setText(model.getValueAt(i,3).toString());
        Address_TextField.setText(model.getValueAt(i,5).toString());
        Phone_TextField.setText(model.getValueAt(i,6).toString());
    }//GEN-LAST:event_Users_TableMouseClicked

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        // TODO add your handling code here:
        if(!Users_Table.getSelectionModel().isSelectionEmpty()){ 
            int i = Users_Table.getSelectedRow();
            TableModel model = Users_Table.getModel();
            int id =(int) model.getValueAt(i, 0);
            if (id == 0){
                JOptionPane.showMessageDialog(null,"Tài khoản mặc định này ko được xoá");
            }
            else{
                Users user = UserDAO.getUserById(id);
                if(user != null){
                    int rs = UserDAO.deleteById(id);
                    if (1 == rs)
                        JOptionPane.showMessageDialog(null,"Xóa thành công !");
                    else 
                        JOptionPane.showMessageDialog(null,"Lỗi");
                    Reload_View();
                }else JOptionPane.showMessageDialog(null,"Ko tìm thấy user mã id:"+id);
            }
        }else JOptionPane.showMessageDialog(null,"Vui lòng chọn user");
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Id_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Id_TextFieldKeyPressed
        // TODO add your handling code here:
        String value = Id_TextField.getText();
        MesId_Label.setForeground(Color.RED);
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'|| evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            Id_TextField.setEditable(true);
            MesId_Label.setText("");
        } else {
            Id_TextField.setEditable(false);
            MesId_Label.setText("Chỉ nhập số(0-9)");
        }
    }//GEN-LAST:event_Id_TextFieldKeyPressed

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
            java.util.logging.Logger.getLogger(QLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLyTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address_TextField;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JTextField FullName_TextField;
    private javax.swing.JTextField Id_TextField;
    private javax.swing.JButton Insert_Button;
    private javax.swing.JLabel MesId_Label;
    private javax.swing.JTextField Password_TextField;
    private javax.swing.JTextField Phone_TextField;
    private javax.swing.JComboBox<String> Role_ComboBox;
    private javax.swing.JButton Update_Button;
    private javax.swing.JTextField UserName_TextField;
    private javax.swing.JTable Users_Table;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
