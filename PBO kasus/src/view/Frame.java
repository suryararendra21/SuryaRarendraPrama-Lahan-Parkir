package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.io.File;

public abstract class Frame extends JFrame{
    public Frame (String title, int width, int height){
        setTitle(title);
        setSize(width, height);
        setLayout(null);
        setLocation(500, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
    }

    @Override
    public void setVisible(boolean b){
        if (b == true){
            component();
            event();
        }
        super.setVisible(b);
    }

    protected abstract void component();
    protected abstract void event();

    protected void setBound(Component com, int x, int y, int width, int height){
        com.setBounds(x, y, width, height);
        add(com);
    }
}
