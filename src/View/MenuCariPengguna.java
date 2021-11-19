package View;

import Controller.Controller;
import Model.CategoryUser;
import Model.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MenuCariPengguna {
JTable j;
    public MenuCariPengguna() {
        Controller c = new Controller();
        
        //Frame
        JFrame f = new JFrame("Search User Menu");
        f.setSize(800, 600);
        f.getContentPane().setBackground(new Color(54, 33, 89, 255));
        JLabel judul = new JLabel("Search User Menu");
        judul.setBounds(235, 100, 500, 50);
        judul.setFont(new Font("Verdana", Font.BOLD, 35));
        judul.setForeground(Color.white);
        f.add(judul);
        
        ArrayList<CategoryUser> category = new ArrayList();
        category = c.getAllCategory();
        String ca[] = new String[category.size()];
        for (int i = 0; i < ca.length; i++) {
            ca[i] = category.get(i).getName();
        }

        JComboBox cb = new JComboBox(ca);
        cb.setBounds(50, 220, 400, 50);
        Font newTextFieldFont7 = new Font(cb.getFont().getName(), cb.getFont().getStyle(), 20);
        cb.setFont(newTextFieldFont7);
        f.add(cb);

        JButton search = new JButton("Search Data");
        search.setBounds(270, 350, 250, 50);
        Font newTextFieldFont12 = new Font(search.getFont().getName(), search.getFont().getStyle(), 20);
        search.setFont(newTextFieldFont12);
        f.add(search);

        JButton back = new JButton("Back");
        back.setBounds(270, 420, 250, 50);
        Font newTextFieldFont13 = new Font(back.getFont().getName(), back.getFont().getStyle(), 20);
        back.setFont(newTextFieldFont13);
        f.add(back);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        back.addActionListener((ActionEvent e) -> {
            f.dispose();

            new LoginMenuScreen();
        });

        search.addActionListener((ActionEvent e) -> {
            
            Controller cont = new Controller();

            int idCategory = 0;
            if (cb.getSelectedItem().equals("Private Account")) {
                idCategory = 1;
            }
            if (cb.getSelectedItem().equals("Creator Account")) {
                idCategory = 2;
            }
            if (cb.getSelectedItem().equals("BusinessAccount")) {
                idCategory = 3;
            }

            ArrayList<User> users = new ArrayList();
            users = cont.getAllUsersByCategory(idCategory);

            if (users.size() != 0) {
                JOptionPane.showMessageDialog(null, "Pengguna Ditemukan");
                new HasilCariPengguna(users);
            } else {
                JOptionPane.showMessageDialog(null, "Pengguna Gagal Ditemukan");
            }
        });
    }
}
