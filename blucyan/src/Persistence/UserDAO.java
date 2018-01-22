package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logic.*;

/**
 * Class that interacts with the database
 * 
 * @author Alejandr, Carlos, Samuel
 */
public class UserDAO extends DBConnection implements IConversor<User,UserProxy> {

    /**
     * Gets the entry that corresponds to the name
     * 
     * @param name
     * @return
     * @throws Exception 
     */
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
    
    /**
     * Deletes the user whose nickname corresponds to name
     * 
     * @param name
     * @throws Exception 
     */
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
    
    /**
     * Puts a user into the database
     * 
     * @param user
     * @throws Exception 
     */
    public void put(User user) throws Exception{
        try {
            Connection cn;
             PreparedStatement st;
            
            this.openConnection();
            String nickname=user.getUserName();
            cn=this.getConnection();
            st = cn.prepareStatement("INSERT INTO Users VALUES (?,?,?,?)");
            st.setString(1, user.getUserName());
            st.setString(2, user.getPass());
            st.setBoolean(3, user.getIsAdmin());
            st.setBoolean(4, user.getIsPrivate());
            st.executeUpdate();
            
             st = cn.prepareStatement("INSERT INTO Lists(typeList,nickname) VALUES (?,?)");
             st.setString(1,"Comic");
             st.setString(2, nickname);
             st.executeUpdate();
             
             st = cn.prepareStatement("INSERT INTO Lists(typeList,nickname) VALUES (?,?)");
             st.setString(1,"Videogame");
             st.setString(2, nickname);
             st.executeUpdate();
             
             st = cn.prepareStatement("INSERT INTO Lists(typeList,nickname) VALUES (?,?)");
             st.setString(1,"Show");
             st.setString(2, nickname);
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
    
    /**
     * Checks if an user exists
     * @param id
     * @return
     * @throws Exception 
     */
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
    
    /**
     * Checks if the username and the password corresponds
     * to a registered user
     * 
     * @param username
     * @param password
     * @return
     * @throws Exception 
     */
    public boolean match(String username,String password) throws Exception{
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        boolean match= false;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT count(nickname) FROM Users WHERE nickname = ? AND pass =?");
        st.setString(1, username);
        st.setString(2, password);
        rs = st.executeQuery();
        rs.first();
        match = rs.getBoolean(1);
        System.out.println(match);
        
        
        this.closeConnection();
        
        return match;
    }
    
    /**
     * Searches users that contains the name string
     * 
     * @param name
     * @return
     * @throws Exception 
     */
    public List<UserProxy> search(String name) throws Exception {
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        List<UserProxy> searched = new ArrayList<UserProxy>();
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT nickname FROM Users WHERE nickname LIKE '%"+name+"%'");
        rs = st.executeQuery();
        
            while(rs.next()){
                UserProxy user = new UserProxy();
                user.setName(rs.getString("nickname"));
                searched.add(user);
            }
            
        this.closeConnection();
        return searched;
    }
    
    /**
     * Updates the modifications in an user
     * 
     * @param user
     * @throws Exception 
     */
    public void modify(User user) throws Exception{
    
        Connection cn;
        this.openConnection();
        cn = this.getConnection();
        PreparedStatement st = cn.prepareStatement("UPDATE User SET pass=?, private=? WHERE nickname = ?");
        st.setString(1, user.getPass());;
        st.setBoolean(2, user.getIsPrivate());
        st.setString(3, user.getUserName());
        
        st.executeUpdate();
        this.closeConnection();
    
    
    }
}
