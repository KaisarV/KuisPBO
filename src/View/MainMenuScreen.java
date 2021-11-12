package View;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author MrKaisar
 */
public class MainMenuScreen {

    public MainMenuScreen() {

        //Frame
        JFrame f = new JFrame("Main Menu");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(54, 33, 89, 255));
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel judul = new JLabel("Main Menu");
        judul.setBounds(270, 70, 250, 50);
        judul.setFont(new Font("Verdana", Font.BOLD, 40));
        judul.setForeground(Color.white);
        f.add(judul);

        JButton login = new JButton("Login Pengguna");
        login.setBounds(270, 200, 250, 50);
        Font newTextFieldFont12 = new Font(login.getFont().getName(), login.getFont().getStyle(), 20);
        login.setFont(newTextFieldFont12);
        f.add(login);

        JButton registrasi = new JButton("Registrasi Pengguna Baru");
        registrasi.setBounds(150, 300, 500, 50);
        Font newTextFieldFont13 = new Font(registrasi.getFont().getName(), registrasi.getFont().getStyle(), 20);
        registrasi.setFont(newTextFieldFont13);
        f.add(registrasi);
        
        JButton lihatData = new JButton("Lihat Data Pengguna Baru \nBerdasarkan Kategori Dipilih");
        lihatData.setBounds(100, 400, 600, 80);
        Font newTextFieldFont14 = new Font(lihatData.getFont().getName(), lihatData.getFont().getStyle(), 20);
        lihatData.setFont(newTextFieldFont14);
        f.add(lihatData);

        
        registrasi.addActionListener((ActionEvent e) -> {
            f.dispose();
           
            new RegisMenuScreen();
        });
        
        login.addActionListener((ActionEvent e) -> {
            f.dispose();
            new LoginMenuScreen();
        });
    }
}
