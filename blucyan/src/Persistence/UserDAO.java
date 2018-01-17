package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logic.*;
//TO DO implements IConversor
public class UserDAO extends DBConnection {

    public User get(String name) throws Exception {
        Connection cn;
        User user;
        ResultSet rs;
        PreparedStatement st;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT * FROM Users WHERE nickname = ?");
        st.setString(1, name);
        rs = st.executeQuery();
        rs.first();
        
        user = new User();
        user.setUserName(rs.getString("nickname"));
        user.setPass(rs.getString("pass"));
        user.setIsAdmin(rs.getBoolean("isAdmin"));
        user.setIsPrivate(rs.getBoolean("private"));
        
        this.closeConnection();
        
        return user;
    }
    
    public void delete(String name) throws Exception {
        Connection cn;
        PreparedStatement st;
        try{
            this.openConnection();
            cn = this.getConnection();
            st = cn.prepareStatement("DELETE FROM Users WHERE nickname = ?");
            st.setString(1, name);
            st.executeUpdate();
        }catch (Exception e){
            throw new Exception("Method Delete user " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Metodo Eliminar un usuario " + e.getMessage());
            }
        }
    }
    
    public void put(User user) throws Exception{
        try {
            Connection cn;
             PreparedStatement st;
            
            this.openConnection();
            cn=this.getConnection();
            st = cn.prepareStatement("INSERT INTO Users VALUES (?,?,?,?)");
            st.setString(1, user.getUserName());
            st.setString(2, user.getPass());
            st.setBoolean(3, user.getIsAdmin());
            st.setBoolean(4, user.getIsPrivate());
            st.executeUpdate();
        }catch(Exception e){
            throw new Exception("Inserting user " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Closing connection insert user " + e.getMessage());
            }
        }
    }
    
    public boolean exists(String id) throws Exception{
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        boolean exist = false;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT count(nickname) FROM Users WHERE nickname = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        rs.first();
        exist = rs.getBoolean(1);
        
        System.out.println(exist);
        this.closeConnection();
        
        return exist;
    }
    
    public List<User> search(String name) throws Exception {
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        List<User> searched = new ArrayList<User>();
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT nickname FROM Users WHERE nickname LIKE '%"+name+"%'");
        rs = st.executeQuery();
        
            while(rs.next()){
                User user = new User();
                user.setUserName(rs.getString("nickname"));
                searched.add(user);
            }
            
        this.closeConnection();
        return searched;
    }
    
    public static void main(String[] args) throws Exception{
        UserDAO u=new UserDAO();
        User user = new User();
        User us;
        
        user.setUserName("Notch");
        user.setIsAdmin(false);
        user.setIsPrivate(false);
        user.setPass("minecraft");
            
            u=new UserDAO();
            u.exists("Al");
            
            u.put(user);
            u.exists("Notch");
            
            u.delete(user.getUserName());
            us = u.get("Terminator");
            System.out.println(us.getUserName());
            
            u=new UserDAO();
            ArrayList<User> result = (ArrayList<User>) u.search("r");
            for(int i=0;i<result.size();i++){
               System.out.println(result.get(i).getUserName());
            }
    }
}
