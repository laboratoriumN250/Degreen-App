/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ari
 */
public class manager {
Connection konek=null;
Statement sta=null;

    public manager() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            konek=DriverManager.getConnection("jdbc:mysql://localhost/db_hotel","root","");
            sta=konek.createStatement();
            //JOptionPane.showMessageDialog(null, "Berhasil Koneksi");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    //=============================================================================================
    public void simpanBooking(entitas.entitas_booking A){
        try {
            String simpan ="INSERT INTO tb_booking VALUES ('"+A.getNopesan()+"','"+A.getNoktp()+"','"+A.getNama_tamu()+"','"+A.getTelp()+"','"+A.getKdkamar()+"','"+A.getTipekamar()+"','"+A.getCheckin()+"','";
            sta.execute(simpan);
            JOptionPane.showMessageDialog(null, "Data Buku Terimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan","Peringatan",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    
    
    //""""""""""""""""""""""""""Query Master Tamu""""""""""""""""""""""""""""""""
    
    public void Simpan(entitas.EntitasTamu tamu){
        
        try {
         String simpan = "insert into tb_tamu values (NULL,'"+tamu.getKTP()+"','"+tamu.getNama()+"', '"+tamu.getGender()+"','"+tamu.getAlamat()+"', '"+tamu.getTelpon()+"')";
         sta.executeUpdate(simpan);
         JOptionPane.showMessageDialog(null, "Data Tamu Berhasil Ditambah!","Success",JOptionPane.INFORMATION_MESSAGE);
     } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal Simpan");
        JOptionPane.showMessageDialog(null, ""+e.getLocalizedMessage());
        e.printStackTrace();
     }
        
        
    }
    
    public void Update(entitas.EntitasTamu tamu){
        
       try {
         String update = "Update tb_tamu set Nama_Tamu ='"+tamu.getNama()+"', Jenis_Kelamin='"+tamu.getGender()+"', Alamat ='"+tamu.getAlamat()+"', No_Telpon ='"+tamu.getTelpon()+"' where No_KTP='"+tamu.getKTP()+"' ";
       sta.execute(update);
       
       JOptionPane.showMessageDialog(null, "Data Tamu Berhasil diubah!","Success",JOptionPane.INFORMATION_MESSAGE);
       
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Gagal Update");
         e.printStackTrace();
     }
}
    
    public void Delete(entitas.EntitasTamu tamu){
        
        try {
            String delete = "Delete from tb_tamu where No_KTP='"+tamu.getKTP()+"'";
            sta.execute(delete);
            JOptionPane.showMessageDialog(null, "Data Tamu dihapus!","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Update");
         e.printStackTrace();
        }
    }

}
