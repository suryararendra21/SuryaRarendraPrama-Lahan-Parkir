package view;

import controller.ParkirController;
import model.KeluarModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChekoutGui extends Frame{
    private JLabel adminLabel,parkir;
    private JTextField platNomorField;
    private JButton keluarBtn, saveBtn, checkOutBtn;

    public ChekoutGui(){
        super("Page Admin", 600, 700);
        setLocation(40, 40);
    }

    @Override
    protected void component() {
        adminLabel = new JLabel("Chekout");
        adminLabel.setFont(new Font("Arial", Font.BOLD, 20));
        adminLabel.setForeground(Color.GREEN);
        setBound(adminLabel, 150, 100, 200, 45);

        parkir = new JLabel("chekout");
        parkir.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(parkir, 65, 170, 150, 18);

        platNomorField = new JTextField();
        setBound(platNomorField, 65, 190, 270, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(Color.DARK_GRAY);
        keluarBtn.setFocusPainted(false);
        setBound(keluarBtn, 85, 565, 85, 30);

        checkOutBtn = new JButton("Check Out");
        checkOutBtn.setForeground(Color.white);
        checkOutBtn.setBackground(Color.RED);
        checkOutBtn.setFocusPainted(false);
        setBound(checkOutBtn, 285, 565, 105, 30);
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
        checkOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String platNomor = platNomorField.getText();

                if (!platNomor.isEmpty()) {
                    ParkirController parkirController = new ParkirController();

                    int hargaParkir = parkirController.chekOut(platNomor);

                    JOptionPane.showMessageDialog(null, "Check-out successful");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the license plate number.");
                }
            }
        });


    }
    public static void main(String[] args){
        new ChekoutGui().setVisible(true);
    }
}
