/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author agusseputra
 */
public class paneltransparant extends JPanel {
     public Color warna;
    //konstruktor untuk class panelTransparan
    public paneltransparant() {
        //setting awal biar bisa transparan
        //warna di hilngkan dulu
        setOpaque(false);
        //setting rgb nya dan alpha ..
        //alpha untuk transparasi nya -- nilainya 0 sampai 255
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 100);
    }
    //memberi warna background
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);

        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 100);
        //backgound di repaint
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //membuat objek g2
        Graphics2D g2 = (Graphics2D) g.create();
        //memberi warna
        g2.setColor(warna);
        //mengisikan warna
        //getwidth dan get height agar warna mengikuti luas panel
        g2.fillRect(0, 0, getWidth(), getHeight());
        //menutup g2
        g2.dispose();
    }

}
