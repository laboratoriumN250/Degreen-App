/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

/**
 *
 * @author ASUS
 */
public class EntitasTamu {
    String ID,Kode_Tamu, KTP, nama, gender, alamat, telpon;

    public String getKode_Tamu() {
        return Kode_Tamu;
    }

    public void setKode_Tamu(String Kode_Tamu) {
        this.Kode_Tamu = Kode_Tamu;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getKTP() {
        return KTP;
    }

    public void setKTP(String KTP) {
        this.KTP = KTP;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }
}
