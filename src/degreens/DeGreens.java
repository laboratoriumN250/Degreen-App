/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package degreens;

import View.frm_transaksi;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Ari
 */
public class DeGreens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                try {
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                     UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                    //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    // UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                    // TAMPILKAN MAIN UTAMA APLIKASI ANDA DI PERINTAH DIBAWAH INI
                  } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Terjadi error Thema, Pada : \n"+e);
                  }
                new frm_transaksi().setVisible(true);
        
    }
    
}
