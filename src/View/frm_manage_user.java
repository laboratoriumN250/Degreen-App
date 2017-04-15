/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import config.manager;
import entitas.entitasUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author Ari
 */
public class frm_manage_user extends javax.swing.JFrame {
String MenuTamu = "false";
    String MenuUser = "false";
    String MenuPemesanan = "false";
    String MenuLaporan = "false";
    
    String Level;
    
    Connection con;
    Statement st;
    
    String data[] = new String[7];
    /**
     * Creates new form frm_manage_user
     */
    public frm_manage_user() {
        initComponents();
       this.setLocationRelativeTo(null);
       this.setResizable(false);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_hotel","root","");
             st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal");
            e.printStackTrace();
        }
        
        tabeluser.setModel(tabelModel);
        Tabel(tabeluser, new int[] {150,200,150,100,100,100,100});
      setDefaultTable();
    }
    private javax.swing.table.DefaultTableModel getDefaultTableModel(){
        return new javax.swing.table.DefaultTableModel(new Object[][]{},
        new String [] {"Nama Lengkap","Username","Level","Tamu","User","Pemesanan","Laporan"}) {
        boolean[] canEdit = new boolean[]{
            false,false,false,false,false,false,false
        };
                
       @Override
            public boolean isCellEditable(int rowIndex, int ColumnIndex) {
                return canEdit[ColumnIndex]; //To change body of generated methods, choose Tools | Templates.
            }
        };
        
    }
    
    private javax.swing.table.DefaultTableModel tabelModel = getDefaultTableModel();
    
    public void tabel_kosong(){
        int count = tabeluser.getRowCount();
        int x = 1;
        while (x<=count){
            tabelModel.removeRow(0);
            x = x+ 1;
        }
    }
    
    private void Tabel(javax.swing.JTable tb, int lebar[]){
       tb.setAutoResizeMode(tb.AUTO_RESIZE_OFF);
        int kolom = tb.getColumnCount();
        
        for (int i =0; i < kolom; i++){
            javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }
    
    private void setDefaultTable() {
        try {
             st =  con.createStatement();
            
            String sql = "Select * from tb_user";
            
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next()){
            data[0] = rs.getString("Nama");
            data[1] = rs.getString("Username");
            data[2] = rs.getString("Level");
            data[3] = rs.getString("Master_Tamu");
            data[4] = rs.getString("Master_User");
            data[5] = rs.getString("Master_Pemesanan");
            data[6] = rs.getString("Master_Laporan");
            
                tabelModel.addRow(data);
           
            }
             rs.close();
          st.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }
    
    void Level(){
        
        if(cmblevel.getSelectedItem().equals("Admin")){
            Level="Admin";
        } else if (cmblevel.getSelectedItem().equals("Front Office")){
            Level = "Front Office";
        }
        
    }
    
    public void HakAkses(){
        if(checktamu.isSelected()){
            MenuTamu = "true";
          
           
        } 
        if(checkuser.isSelected()){
            MenuUser="true";
           
                   
        }
        if(checkpemesanan.isSelected()){
            MenuPemesanan="true";
            
           
        }
      if(checklaporan.isSelected()){
            MenuLaporan="true";
          
            
        }
        
    }
    
    void Clear(){
        txtusername.setText("");
        txtpassword.setText("");
        txtnama.setText("");
        checktamu.setSelected(false);
        checkuser.setSelected(false);
        checkpemesanan.setSelected(false);
        checklaporan.setSelected(false);
        txtusername.setEnabled(true);
        txtusername.requestFocus();
    }
    
    void Checked(){
        if(MenuTamu.equals("true")){
            checktamu.setSelected(true);
        }
        if(MenuUser.equals("true")){
            checkuser.setSelected(true);
        }
        if(MenuPemesanan.equals("true")){
            checkpemesanan.setSelected(true);
        }
        if(MenuLaporan.equals("true")){
            checklaporan.setSelected(true);
        }
    }
    
     void Cari () {
        tabel_kosong();
         try {
            st =  con.createStatement();
            
            String sql = "Select * from tb_user where Username like '%"+txtcari.getText()+"%'  or Nama like '%"+txtcari.getText()+"%'  order by Username ASC";
            
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next()){
           data[0] = rs.getString("Nama");
            data[1] = rs.getString("Username");
            data[2] = rs.getString("Level");
            data[3] = rs.getString("Master_Tamu");
            data[4] = rs.getString("Master_User");
            data[5] = rs.getString("Master_Pemesanan");
            data[6] = rs.getString("Master_Laporan");
            tabelModel.addRow(data);
            }
           rs.close();
           st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }

    config.manager manager = new manager();
    entitas.entitasUser user = new entitasUser();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        cmblevel = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        checktamu = new javax.swing.JCheckBox();
        checkuser = new javax.swing.JCheckBox();
        checkpemesanan = new javax.swing.JCheckBox();
        checklaporan = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        bExit = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bAdd = new javax.swing.JButton();
        bExit1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeluser = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel14.setBackground(new java.awt.Color(102, 51, 0));

        jLabel48.setFont(new java.awt.Font("Plantagenet Cherokee", 1, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Manajemen User");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Data"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Username ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nama Lengkap ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Password ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Level ");

        txtusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtnama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cmblevel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmblevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Admin", "Front Office" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpassword)
                            .addComponent(cmblevel, 0, 239, Short.MAX_VALUE))))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmblevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hak Akses"));

        checktamu.setBackground(new java.awt.Color(255, 204, 102));
        checktamu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checktamu.setText("Menu Tamu");

        checkuser.setBackground(new java.awt.Color(255, 204, 102));
        checkuser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkuser.setText("Menu User");

        checkpemesanan.setBackground(new java.awt.Color(255, 204, 102));
        checkpemesanan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkpemesanan.setText("Menu Pemesanan");

        checklaporan.setBackground(new java.awt.Color(255, 204, 102));
        checklaporan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checklaporan.setText("Menu Laporan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checktamu)
                    .addComponent(checkuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkpemesanan)
                    .addComponent(checklaporan))
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checktamu)
                    .addComponent(checkpemesanan))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkuser)
                    .addComponent(checklaporan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        bExit.setText("Menu");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        bDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove_user.png"))); // NOI18N
        bDelete.setText("Hapus");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit_user.png"))); // NOI18N
        bEdit.setText("Ubah");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveuser.png"))); // NOI18N
        bSave.setText("Simpan");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_user.png"))); // NOI18N
        bAdd.setText("Baru");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset password.png"))); // NOI18N
        bExit1.setText("Reset Password");
        bExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Data User"));

        tabeluser.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeluser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeluserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeluser);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cari User");

        txtcari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel5)
                .addGap(47, 47, 47)
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bExitActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
       int reply = JOptionPane.showConfirmDialog(null, "Are You Sure?","Information",JOptionPane.YES_NO_OPTION);
                         if(reply==0){
                             user.setUsername(txtusername.getText());
                             manager.DeleteUser(user);
                             tabel_kosong();
                             setDefaultTable();
                             Clear();
                         }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
         int reply = JOptionPane.showConfirmDialog(null, "Are You Sure?","Information",JOptionPane.YES_NO_OPTION);
                 if(reply ==0){
                     HakAkses();
                     Level();
                     user.setNama(txtnama.getText());
                     user.setLevel(Level);
                     user.setMenuTamu(MenuTamu);
                     user.setMenuUser(MenuUser);
                     user.setMenuPemesanan(MenuPemesanan);
                     user.setMenuLaporan(MenuLaporan);
                     manager.UpdateUser(user);
                     tabel_kosong();
                     setDefaultTable();
                 }
    }//GEN-LAST:event_bEditActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        // TODO add your handling code here:
         int reply = JOptionPane.showConfirmDialog(null, "Are You Sure?","Information",JOptionPane.YES_NO_OPTION);
        if(txtusername.getText().isEmpty()|| txtpassword.getText().isEmpty()||txtnama.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Semua Data harus di isi!","Warning",JOptionPane.WARNING_MESSAGE);
        } else if(reply==0){
            HakAkses();
            Level();
            user.setUsername(txtusername.getText());
            user.setPassword(txtpassword.getText());
            user.setNama(txtnama.getText());
            user.setLevel(Level);
            user.setMenuTamu(MenuTamu);
            user.setMenuUser(MenuUser);
            user.setMenuPemesanan(MenuPemesanan);
            user.setMenuLaporan(MenuLaporan);
            manager.SimpanUser(user);
            tabel_kosong();
            setDefaultTable();
        }
        
    }//GEN-LAST:event_bSaveActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        // TODO add your handling code here:
         Clear();
        bEdit.setEnabled(false);
        bDelete.setEnabled(false);
        bSave.setEnabled(true);
       
    }//GEN-LAST:event_bAddActionPerformed

    private void bExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bExit1ActionPerformed

    private void tabeluserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeluserMouseClicked
        // TODO add your handling code here:
         if(evt.getClickCount() == 2){
             bDelete.setEnabled(true);
             bEdit.setEnabled(true);
             bSave.setEnabled(false);
            txtusername.setEnabled(false);
            txtpassword.setEnabled(false);
            int Baris = tabeluser.getSelectedRow();
          
            txtusername.setText(tabeluser.getValueAt(Baris, 1).toString());
            txtnama.setText(tabeluser.getValueAt(Baris, 0).toString());
            cmblevel.setSelectedItem(tabeluser.getValueAt(Baris, 2).toString());
           
              Checked();
    }                            
    }//GEN-LAST:event_tabeluserMouseClicked

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        // TODO add your handling code here:
        Cari();
    }//GEN-LAST:event_txtcariKeyReleased

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
            java.util.logging.Logger.getLogger(frm_manage_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_manage_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_manage_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_manage_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_manage_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bExit1;
    private javax.swing.JButton bSave;
    private javax.swing.JCheckBox checklaporan;
    private javax.swing.JCheckBox checkpemesanan;
    private javax.swing.JCheckBox checktamu;
    private javax.swing.JCheckBox checkuser;
    private javax.swing.JComboBox<String> cmblevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabeluser;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
