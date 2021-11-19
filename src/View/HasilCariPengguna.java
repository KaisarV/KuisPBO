package View;

import Model.User;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HasilCariPengguna {
    
    JFrame f;
    
    public HasilCariPengguna(ArrayList<User> users) {
        f = new JFrame();
        String data[][] = new String[users.size()][2];        
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i).getName();
            data[i][1] = users.get(i).getEmail();
        }

        String column[] = {"Name", "Email"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 300, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setLocationRelativeTo(null);
        f.setSize(300, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
