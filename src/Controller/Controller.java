/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.CategoryUser;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MrKaisar
 */
public class Controller {

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

    public User loginUser(String email, String password) {
        conn.connect();
        ArrayList<User> users = new ArrayList<>();
        users = this.getAllUsers();
        boolean cek = false;
        User u = new User();
        for (int i = 0; i < users.size(); i++) {
            u = users.get(i);
            if (u.getEmail().equals(email)) {
                if (u.getPassword().equals(password)) {
                    cek = true;
                }
                if (cek == true) {
                    break;
                }
            }
        }

        if (cek == true) {
            return u;
        } else {
            return null;
        }
    }

    public ArrayList<User> getAllUsersByCategory(int id) {
        conn.connect();
        ArrayList<User> users = new ArrayList<>();
        System.out.println(users);
        String query = "SELECT * FROM user WHERE idCategory = '" + id + "';";
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
    
    public boolean editProfil(User u){
    conn.connect();
        String query = "UPDATE user SET name = '" + u.getName() + "', "
                + "email='" + u.getEmail() + "', "
                + "password='" + u.getPassword() +"' WHERE id='" + u.getId() +"';";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
        
    }
    
    public boolean deleteProfil(int id){
    conn.connect();
        String query = "DELETE FROM user WHERE id = '" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
        
    }

}
