
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehmoona
 */
public class model {
     Connection conn;
     Statement statement;
     JPanel panel;
    public  void connection() throws SQLException{
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root","");
            JOptionPane.showMessageDialog(panel,"connected");
            System.out.println("Connection established\n");
        } catch (SQLException ex) {
            System.out.println("Connection unestablished\n");           
        }        
    }
    
    public void insert(int i,int P,int t, String p,String u) throws SQLException{
        PreparedStatement statement=conn.prepareStatement("Insert into guests Values (?,?,?,?,?)");
        statement.setInt(1,i);
        statement.setInt(2,P);
        statement.setInt(3,t);
        statement.setString(4,p);
        statement.setString(5,u);
        statement.execute();
        
    }
    
    public String retrieve(int i) throws SQLException{
        PreparedStatement statement=conn.prepareStatement("Select username from guests where id=?");
        statement.setInt(1,i);
        ResultSet rs =statement.executeQuery();
        rs.next();
        String name = rs.getString("username");
        return name;        
        
    }
    
    
    
}
