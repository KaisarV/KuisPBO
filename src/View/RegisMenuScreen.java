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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author MrKaisar
 */
public class RegisMenuScreen {

    JButton insert, back, edit, delete;

    public RegisMenuScreen(User user) {
        Controller c = new Controller();

        //Frame
        JFrame f = new JFrame("Registration Menu");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(54, 33, 89, 255));
        f.setLayout(null);
        f.setVisible(true);

        JLabel name = new JLabel("Name                      : ");
        name.setBounds(50, 120, 220, 100);
        name.setFont(new Font("Serif", Font.PLAIN, 25));
        name.setForeground(Color.white);
        f.add(name);

        JTextField name1 = new JTextField();
        name1.setBounds(300, 150, 220, 50);
        Font newTextFieldFont = new Font(name1.getFont().getName(), name1.getFont().getStyle(), 20);
        name1.setFont(newTextFieldFont);
        f.add(name1);

        JLabel email = new JLabel("Email                       : ");
        email.setBounds(50, 175, 210, 100);
        email.setFont(new Font("Serif", Font.PLAIN, 25));
        email.setForeground(Color.white);
        f.add(email);

        JTextField email1 = new JTextField();
        email1.setBounds(300, 205, 220, 50);
        Font newTextFieldFont1 = new Font(email1.getFont().getName(), email1.getFont().getStyle(), 20);
        email1.setFont(newTextFieldFont1);
        f.add(email1);

        JLabel password = new JLabel("Password                : ");
        password.setBounds(50, 230, 250, 100);
        password.setFont(new Font("Serif", Font.PLAIN, 25));
        password.setForeground(Color.white);
        f.add(password);

        JPasswordField pw = new JPasswordField();
        pw.setBounds(300, 260, 220, 50);
        Font newTextFieldFont5 = new Font(pw.getFont().getName(), pw.getFont().getStyle(), 20);
        pw.setFont(newTextFieldFont5);
        f.add(pw);

        ArrayList<CategoryUser> category = new ArrayList();
        category = c.getAllCategory();
        String ca[] = new String[category.size()];

        for (int i = 0; i < ca.length; i++) {
            ca[i] = category.get(i).getName();
        }

        JComboBox cb = new JComboBox(ca);
        cb.setBounds(50, 350, 350, 50);
        Font newTextFieldFont7 = new Font(cb.getFont().getName(), cb.getFont().getStyle(), 20);
        cb.setFont(newTextFieldFont7);
        f.add(cb);

        if (user == null) {
            System.out.println(user);
            insert = new JButton("Insert Data");
            insert.setBounds(210, 440, 170, 50);
            Font newTextFieldFont12 = new Font(insert.getFont().getName(), insert.getFont().getStyle(), 20);
            insert.setFont(newTextFieldFont12);
            f.add(insert);

            back = new JButton("Back");
            back.setBounds(390, 440, 170, 50);
            Font newTextFieldFont13 = new Font(back.getFont().getName(), back.getFont().getStyle(), 20);
            back.setFont(newTextFieldFont13);
            f.add(back);

            f.setDefaultCloseOperation(EXIT_ON_CLOSE);

            back.addActionListener((ActionEvent e) -> {
                f.dispose();
                new MainMenuScreen();
            });

            insert.addActionListener((ActionEvent e) -> {
                f.dispose();
                Controller cont = new Controller();
                int idUser = cont.getAllUsers().size() + 1;
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

                User u = new User(idUser, name1.getText(), email1.getText(), pw.getText(), idCategory);
                boolean cek = cont.insertDataUser(u);
                if (cek == true) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    new LoginMenuScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
                }

                new MainMenuScreen();
            });
        } else {
            name1.setText(user.getName());
            email1.setText(user.getEmail());
            String pwd = new String(user.getPassword());
            pw.setText(pwd);

            if (user.getIdCategory() == 1) {
                cb.setSelectedItem("Private Account");
            }
            if (user.getIdCategory() == 2) {
                cb.setSelectedItem("Creator Account");
            }
            if (user.getIdCategory() == 3) {
                cb.setSelectedItem("Business Account");
            }
            
            edit = new JButton("Edit Data");
            edit.setBounds(210, 440, 170, 50);
            Font newTextFieldFont12 = new Font(edit.getFont().getName(), edit.getFont().getStyle(), 20);
            edit.setFont(newTextFieldFont12);
            f.add(edit);

            delete = new JButton("Delete Data");
            delete.setBounds(390, 440, 170, 50);
            Font newTextFieldFont13 = new Font(delete.getFont().getName(), delete.getFont().getStyle(), 20);
            delete.setFont(newTextFieldFont13);
            f.add(delete);
            
            back = new JButton("Back");
            back.setBounds(570, 440, 170, 50);
            Font newTextFieldFont14 = new Font(back.getFont().getName(), back.getFont().getStyle(), 20);
            back.setFont(newTextFieldFont14);
            f.add(back);

            f.setDefaultCloseOperation(EXIT_ON_CLOSE);

            edit.addActionListener((ActionEvent e) -> {
                f.dispose();
                Controller a = new Controller();

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

                User u = new User(user.getId(), name1.getText(), email1.getText(), pw.getText(), idCategory);
                boolean cek = a.editProfil(u);
                
                if (cek == true) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    new LoginMenuScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
                }
                
               
                new UserMenuScreen(user);
            });
            
            delete.addActionListener((ActionEvent e) -> {
                f.dispose();
                Controller a = new Controller();

                boolean cek = a.deleteProfil(user.getId());
                if (cek == true) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    new LoginMenuScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                }
               
                new LoginMenuScreen();
            });

            

        }

    }

}
