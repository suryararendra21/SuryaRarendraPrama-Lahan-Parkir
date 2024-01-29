package view;

import javax.swing.*;
import java.awt.*;

public class MenuGui extends Frame {
    private JLabel prLabel;
    private JButton parkirBtn, chekinBtn, chekoutBtn, semuaBtn;

    public MenuGui(){
        super("Menu", 400, 600);
        setLocation(500, 150);
    }

    @Override
    protected void component(){
        prLabel = new JLabel("Lahan Parkir");
        prLabel.setFont(new Font("Arial", Font.BOLD, 24));
        prLabel.setForeground(Color.GREEN);
        setBound(prLabel, 125, 200, 300, 45);

        parkirBtn = new JButton("Daftar Parkir");
        parkirBtn.setForeground(Color.white);
        parkirBtn.setBackground(Color.DARK_GRAY);
        parkirBtn.setFocusPainted(false);
        setBound(parkirBtn, 140, 350, 124, 30);

        chekinBtn = new JButton("Chekin");
        chekinBtn.setForeground(Color.white);
        chekinBtn.setBackground(Color.DARK_GRAY);
        chekinBtn.setFocusPainted(false);
        setBound(chekinBtn, 140,250,124,30);

        chekoutBtn = new JButton("Chekout");
        chekoutBtn.setForeground(Color.white);
        chekoutBtn.setBackground(Color.DARK_GRAY);
        chekoutBtn.setFocusPainted(false);
        setBound(chekoutBtn, 140,300,124,30);

        semuaBtn = new JButton("Daftar Semua Mobil");
        semuaBtn.setForeground(Color.white);
        semuaBtn.setBackground(Color.DARK_GRAY);
        semuaBtn.setFocusPainted(false);
        setBound(semuaBtn, 140, 400, 124, 30);
    }

    @Override
    protected void event() {
        chekinBtn.addActionListener((e) ->{
            dispose();
            new ChekinGui().setVisible(true);
        });
        chekoutBtn.addActionListener((e) ->{
            dispose();
            new ChekoutGui().setVisible(true);
        });
        parkirBtn.addActionListener((e) ->{
            dispose();
            new DaftarParkirGui().setVisible(true);
        });
        semuaBtn.addActionListener((e) ->{
            dispose();
            new SemuaMobilGui().setVisible(true);
        });
    }
    public static void main(String[] args){
        new MenuGui().setVisible(true);
    }
}
