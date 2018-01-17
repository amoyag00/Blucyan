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
public class UserDAO extends DBConnection{

    public List<User> list() throws Exception{
        
        ArrayList<User> userList = new <User>ArrayList();
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * from Users");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUserName(rs.getString("nickname"));
                user.setPass(rs.getString("pass"));
               user.setIsAdmin(rs.getBoolean("isAdmin"));
                user.setIsAdmin(rs.getBoolean("private"));
                userList.add(user);
            }
            this.closeConnection();
        }catch (Exception e){
            throw new Exception("Listar usuarios " + e.getMessage());
        }
        return(userList);
    }
    public void delete(User user) throws Exception {
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM usuarios WHERE IdUsuario=?");
            st.setString(1, user.getUserName());
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
    
    public void registrar(User user) throws Exception{
        try {
            Connection cn;
            this.openConnection();
            cn=this.getConnection();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO usuarios (user, password, tipo) VALUES (?,?,?)");
            st.setString(1, user.getUserName());
            st.setString(2, user.getPass());
            st.setBoolean(3, user.getIsAdmin());
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
    
    public static void main(String[] args){
        UserDAO u=new UserDAO();
        try {
            ArrayList<User> uList=(ArrayList<User>) u.list();
            for(int i=0;i<uList.size();i++){
                System.out.println(uList.get(i).getUserName());
                System.out.println(uList.get(i).getPass());
                System.out.println(uList.get(i).getIsAdmin());
                System.out.println(uList.get(i).getIsPrivate());
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
