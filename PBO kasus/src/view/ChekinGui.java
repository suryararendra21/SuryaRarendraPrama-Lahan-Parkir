package view;

import controller.ParkirController;
import model.ParkirModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChekinGui extends Frame{
    private JLabel adminLabel,parkir;
    private JTextField platNomorField;
    private JButton keluarBtn, saveBtn;

    public ChekinGui(){
        super("Page Admin", 600, 700);
        setLocation(40, 40);
    }

    @Override
    protected void component() {
        adminLabel = new JLabel("Chekin");
        adminLabel.setFont(new Font("Arial", Font.BOLD, 20));
        adminLabel.setForeground(Color.GREEN);
        setBound(adminLabel, 150, 100, 200, 45);

        parkir = new JLabel("chekin");
        parkir.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(parkir, 65, 170, 150, 18);

        platNomorField = new JTextField();
        setBound(platNomorField, 65, 190, 270, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(Color.DARK_GRAY);
        keluarBtn.setFocusPainted(false);
        setBound(keluarBtn, 85, 565, 85, 30);

        saveBtn = new JButton("Chekin");  // Initialize the saveBtn
        saveBtn.setForeground(Color.white);
        saveBtn.setBackground(Color.GREEN);
        saveBtn.setFocusPainted(false);
        setBound(saveBtn, 185, 565, 85, 30);
    }

    @Override
    protected void event() {

        keluarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuGui().setVisible(true);
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String platNomor = platNomorField.getText();

                if (!platNomor.isEmpty()) {
                    ParkirController parkirController = new ParkirController();
                    parkirController.chekIn(platNomor);

                    JOptionPane.showMessageDialog(null, "Check-in successful.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the license plate number.");
                }
            }
        });
    }
    public static void main(String[] args){
        new ChekinGui().setVisible(true);
    }
}
