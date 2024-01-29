package view;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.ParkirController;
import model.AdminModel;


public class LoginGui extends Frame {
    private JLabel prLabel, usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginBtn;

    public LoginGui() {
        super("Login", 400, 600);
        setLocation(500, 150);
    }

    @Override
    protected void component() {
        prLabel = new JLabel("Lahan Parkir");
        prLabel.setFont(new Font("Arial", Font.BOLD, 24));
        setBound(prLabel, 65, 200, 300, 45);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(usernameLabel, 65, 250, 100, 18);

        usernameField = new JTextField();
        setBound(usernameField, 65, 270, 270, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(passwordLabel, 65, 315, 100, 18);

        passwordField = new JPasswordField();
        setBound(passwordField, 65, 335, 270, 30);

        loginBtn = new JButton("Masuk");
        loginBtn.setForeground(Color.white);
        loginBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setFocusPainted(false);
        setBound(loginBtn, 157, 380, 85, 30);
    }

    @Override
    protected void event() {
        ParkirController objekAdmin = new ParkirController();

        loginBtn.addActionListener((e) -> {
            try {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean status = objekAdmin.login(username, password);
                if (status) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang", "Login Sukses",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new MenuGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Login Gagal",
                            JOptionPane.ERROR_MESSAGE);
                    dispose();
                    new LoginGui().setVisible(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan Inputan Yang benar", "Login Sukses",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new LoginGui().setVisible(true);
            }

        });
    }
    public static void main(String[] args){
        AdminModel.dataAdmin();
        new LoginGui().setVisible(true);
    }
}
