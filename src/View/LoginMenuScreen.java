
package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginMenuScreen {
    
    
    public LoginMenuScreen(){


        //Frame
        JFrame f = new JFrame("Login Menu");
        f.setSize(800, 1000);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);

        JLabel email = new JLabel("Email                      : ");
        email.setBounds(50, 100, 210, 100);
        email.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(email);
        
        JTextField email1 = new JTextField();
        email1.setBounds(300, 120, 220, 50);
        Font newTextFieldFont1 = new Font(email1.getFont().getName(), email1.getFont().getStyle(), 20);
        email1.setFont(newTextFieldFont1);
        f.add(email1);

        JLabel password = new JLabel("Password                   : ");
        password.setBounds(50, 250, 250, 100);
        password.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(password);
        
        JPasswordField pw = new JPasswordField();
        pw.setBounds(300, 270, 220, 50);
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
            f.dispose();

            new MainMenuScreen();
        });
    }
}
