package Persistence;

import Logic.ElementList;
import Logic.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElementListDAO extends DBConnection /*implements IConversor*/ {

	    public void delete(String id) throws Exception {
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM Lists WHERE list_id=?");
            st.setString(1, id);
            st.executeUpdate();
        }catch (Exception e){
            throw new Exception("Method Delete list " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Metodo Delete List " + e.getMessage());
            }
        }
    }
    
    public boolean exists(String id) throws Exception{
        boolean exists=false;
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(list_id) FROM Lists WHERE list_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists=rs.getBoolean(1);
        }catch (Exception e){
            throw new Exception("Method Delete List " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Method delete List " + e.getMessage());
            }
        }
        return exists;
        
    }
    
    
     public ElementList get(String id) throws Exception{
         ElementList eList=new ElementList();
       try{
                this.openConnection();
                PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Lists WHERE list_id=?");
                st.setString(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                eList.setListID(rs.getString("list_id"));
                eList.setNickname(rs.getString("nickname"));
                eList.setTypeList(rs.getString("type_list"));
               

            }catch (Exception e){
                throw new Exception("Method Delete review " + e.getMessage());
            }finally{
                try{
                    this.closeConnection();
                }catch (Exception e){
                    throw new Exception("Method delete review " + e.getMessage());
                }
            }
       return eList;
   }
    
    public void put(ElementList eList) throws Exception{
        try {
            Connection cn;
            this.openConnection();
            cn=this.getConnection();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO Lists (typeList,nickname) VALUES (?,?)");   
            st.setString(1, eList.getTypeList());
            st.setString(2, eList.getNickname());
            
            
            st.executeUpdate();
        }catch(Exception e){
            throw new Exception("Inserting review " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Closing connection insert user " + e.getMessage());
            }
        }
    }
    
   public List<Review> search(String name) throws UnsupportedOperationException{
       throw new UnsupportedOperationException("Method not implmented");
    }
   
   public static void main (String args[]){
       ElementList l=new ElementList();
       l.setNickname("Altair");
       l.setTypeList("Videogame");
                try {
                    new ElementListDAO().put(l);
                } catch (Exception ex) {
                    Logger.getLogger(ElementListDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
       
   }

}