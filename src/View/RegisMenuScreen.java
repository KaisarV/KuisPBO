/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.CategoryUser;
import Model.User;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author MrKaisar
 */
public class RegisMenuScreen {

    public RegisMenuScreen() {
        CategoryUser c = new CategoryUser();

        //Frame
        JFrame f = new JFrame("Registration Menu");
        f.setSize(800, 1000);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);

        JLabel name = new JLabel("Name                      : ");
        name.setBounds(50, 100, 220, 100);
        name.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(name);

        JTextField name1 = new JTextField();
        name1.setBounds(300, 120, 220, 50);
        Font newTextFieldFont = new Font(name1.getFont().getName(), name1.getFont().getStyle(), 20);
        name1.setFont(newTextFieldFont);
        f.add(name1);

        JLabel email = new JLabel("Email                      : ");
        email.setBounds(50, 150, 210, 100);
        email.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(email);

        JTextField email1 = new JTextField();
        email1.setBounds(300, 200, 220, 50);
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

        ArrayList<CategoryUser> category = new ArrayList();
        category = c.getAllCategory();
        String ca[] = new String[category.size()];

        for (int i = 0; i < ca.length; i++) {
            ca[i] = category.get(i).getName();
        }

        JComboBox cb = new JComboBox(ca);
        cb.setBounds(50, 400, 400, 50);
        Font newTextFieldFont7 = new Font(cb.getFont().getName(), cb.getFont().getStyle(), 20);
        cb.setFont(newTextFieldFont7);
        f.add(cb);

        JButton insert = new JButton("Insert Data");
        insert.setBounds(270, 600, 250, 50);
        Font newTextFieldFont12 = new Font(insert.getFont().getName(), insert.getFont().getStyle(), 20);
        insert.setFont(newTextFieldFont12);
        f.add(insert);

        JButton back = new JButton("Back");
        back.setBounds(270, 700, 250, 50);
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
            User user = new User();
            int idUser = user.getAllUsers().size() + 1;
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

            User u = new User(idUser, name1.getText(), email1.getText(), pw.getText(),idCategory);
            user.insertDataUser(u);
            new MainMenuScreen();
        });
    }

}
