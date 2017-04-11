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
            JOptionPane.showMessageDialog(null, "Berhasil Koneksi");

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

}
