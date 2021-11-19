
package View;

import Controller.Controller;
import Model.User;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class LoginMenuScreen {
    
    
    public LoginMenuScreen(){


        //Frame
        JFrame f = new JFrame("Login Menu");

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(800, 1000);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel menuTitle = new JLabel("Login");
        menuTitle.setFont(new Font("Serif", Font.PLAIN, 50));
        menuTitle.setBounds(340, 170, 250, 80);
        f.add(menuTitle);
        
        ImageIcon logoPic;
        JLabel labelLogoPic;
        labelLogoPic = new JLabel();
        logoPic = new ImageIcon( new ImageIcon("assets/fb.png").getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT));
        labelLogoPic.setIcon(logoPic);
        labelLogoPic.setBounds(230, 50, 600, 100);
        f.add(labelLogoPic);
        
        JLabel email = new JLabel("Email                         : ");
        email.setBounds(50, 270, 300, 100);
        email.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(email);
        
        JTextField email1 = new JTextField();
        email1.setBounds(300, 300, 220, 50);
        Font newTextFieldFont1 = new Font(email1.getFont().getName(), email1.getFont().getStyle(), 20);
        email1.setFont(newTextFieldFont1);
        f.add(email1);

        JLabel password = new JLabel("Password                   : ");
        password.setBounds(50, 350, 250, 100);
        password.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(password);
        
        JPasswordField pw = new JPasswordField();
        pw.setBounds(300, 380, 220, 50);
        Font newTextFieldFont5 = new Font(pw.getFont().getName(), pw.getFont().getStyle(), 20);
        pw.setFont(newTextFieldFont5);
        f.add(pw);
        
        JButton login = new JButton("Login");
        login.setBounds(270, 600, 250, 50);
        Font newTextFieldFont12 = new Font(login.getFont().getName(), login.getFont().getStyle(), 20);
        login.setFont(newTextFieldFont12);
        f.add(login);
        
        JButton back = new JButton("Back");
        back.setBounds(270, 700, 250, 50);
        Font newTextFieldFont13 = new Font(back.getFont().getName(), back.getFont().getStyle(), 20);
        back.setFont(newTextFieldFont13);
        f.add(back);
        
        back.addActionListener((ActionEvent e) -> {
            f.dispose();

            new MainMenuScreen();
        });
        
        login.addActionListener((ActionEvent e) -> {
            
            Controller c = new Controller();
            String pwd = new String(pw.getPassword());
            User p = c.loginUser(email1.getText(), pwd);
            
            if (p!= null) {
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                f.dispose();
                new UserMenuScreen(p);
            }
            if (p == null) {
                JOptionPane.showMessageDialog(null, "Login Gagal");
            }
            
        });
    }
}
