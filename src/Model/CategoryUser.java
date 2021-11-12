
package Model;

import Database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MrKaisar
 */
public class CategoryUser {
    
    private int id;
    private String name;

    public CategoryUser(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public CategoryUser() {
    }
    
    static Database conn = new Database();
    
    public ArrayList<CategoryUser> getAllCategory() {
        conn.connect();
        ArrayList<CategoryUser> categories = new ArrayList<>();
        String query = "SELECT * FROM categoryuser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser category = new CategoryUser();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
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

    @Override
    public String toString() {
        return "CategoryUser{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
