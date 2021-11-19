package View;
import Model.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;


/**
 *
 * @author MrKaisar
 */
public class UserMenuScreen {

    public UserMenuScreen(User u) {
        //Frame
        JFrame f = new JFrame("User Menu");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(54, 33, 89, 255));
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel judul = new JLabel(getGreeting() + " " + u.getName());
        judul.setBounds(50, 50, 500, 50);
        judul.setFont(new Font("Verdana", Font.BOLD, 40));
        judul.setForeground(Color.white);
        f.add(judul);
        
        JLabel judul2 = new JLabel("User Menu");
        judul2.setBounds(285, 140, 250, 50);
        judul2.setFont(new Font("Verdana", Font.BOLD, 35));
        judul2.setForeground(Color.white);
        f.add(judul2);
        
        JButton edit = new JButton("Edit Pengguna");
        edit.setBounds(270, 250, 250, 50);
        Font newTextFieldFont12 = new Font(edit.getFont().getName(), edit.getFont().getStyle(), 20);
        edit.setFont(newTextFieldFont12);
        f.add(edit);

        JButton cari = new JButton("Cari Pengguna Baru");
        cari.setBounds(150, 330, 500, 50);
        Font newTextFieldFont13 = new Font(cari.getFont().getName(), cari.getFont().getStyle(), 20);
        cari.setFont(newTextFieldFont13);
        f.add(cari);

        JButton lihatData = new JButton("Lihat Data Pengguna Baru \nBerdasarkan Kategori Dipilih");
        lihatData.setBounds(100, 410, 600, 80);
        Font newTextFieldFont14 = new Font(lihatData.getFont().getName(), lihatData.getFont().getStyle(), 20);
        lihatData.setFont(newTextFieldFont14);
        f.add(lihatData);

        cari.addActionListener((ActionEvent e) -> {
            f.dispose();
            new MenuCariPengguna();
        });

        edit.addActionListener((ActionEvent e) -> {
            f.dispose();
            new RegisMenuScreen(u);
        });
    }

    public static String getGreeting() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            return "Selamat Pagi, ";
        } else if (timeOfDay < 15) {
            return "Selamat Siang, ";
        } else if (timeOfDay < 18) {
            return "Selamat Sore, ";
        } else {
            return "Selamat Malam, ";
        }
    }
}
