package Model;

import Database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MrKaisar
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private int idCategory;

    public User(int id, String name, String email, String password, int idCategory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.idCategory = idCategory;
    }

    public User() {
        
    }
    
    static Database conn = new Database();
    
    public ArrayList<User> getAllUsers() {
        conn.connect();
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idcategory"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    public boolean insertDataUser(User u) {
        conn.connect();
        String query = "INSERT INTO user VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getName());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPassword());
            stmt.setInt(5, u.getIdCategory());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
           
            e.printStackTrace();
            return (false);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", idCategory=" + idCategory + '}';
    }

}
