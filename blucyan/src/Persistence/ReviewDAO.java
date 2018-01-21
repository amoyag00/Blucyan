package Persistence;

import Logic.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReviewDAO extends DBConnection implements IConversor<Review,Review>{
    
    @Override
    public void delete(String id) throws Exception {
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM Reviews WHERE review_id=?");
            st.setString(1, id);
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
    
    public boolean exists(String id) throws Exception{
        boolean exists=false;
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(review_id) FROM Reviews WHERE review_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists=rs.getBoolean(1);
        }catch (Exception e){
            throw new Exception("Method Delete review " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Method delete review " + e.getMessage());
            }
        }
        return exists;
        
    }
    
    private boolean exists(String element_id, String nickname) throws Exception{
        boolean exists=false;
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(review_id) FROM Reviews WHERE element_id=? AND  nickname=?");
            st.setString(1, element_id);
            st.setString(2,nickname);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists=rs.getBoolean(1);
        }catch (Exception e){
            throw new Exception("Method Delete review " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Method delete review " + e.getMessage());
            }
        }
        return exists;
        
    }
    
     public Review get(String id) throws Exception{
         Review rev=new Review();
       try{
                this.openConnection();
                PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Reviews WHERE review_id=?");
                st.setString(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                rev.setReviewID(rs.getString("review_id"));
                rev.setUserName(rs.getString("nickname"));
                rev.setElementID(rs.getString("element_id"));
                rev.setText(rs.getString("review_text"));

            }catch (Exception e){
                throw new Exception("Method Delete review " + e.getMessage());
            }finally{
                try{
                    this.closeConnection();
                }catch (Exception e){
                    throw new Exception("Method delete review " + e.getMessage());
                }
            }
       return rev;
   }
    
    public void put(Review rev) throws Exception{
        try {
            if(exists(rev.getElementID(),rev.getUserName())){
                modify(rev);
            }else{
                Connection cn;
                this.openConnection();
                cn=this.getConnection();
                PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO Reviews (nickname,element_id,review_text) VALUES (?,?,?)");
                st.setString(1, rev.getUserName());
                st.setString(2, rev.getElementID());
                st.setString(3, rev.getText());
                st.executeUpdate();
            }
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
   public Review getReview(String element_id, String nickname) throws Exception{
       this.openConnection();
       
       PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Reviews WHERE element_id=? AND nickname=?");
       st.setString(1, element_id);
       st.setString(2,nickname);
       ResultSet rs = st.executeQuery();
       rs.next();
       Review rev=new Review();
       rev.setReviewID(rs.getString("review_id"));
       rev.setUserName(rs.getString("nickname"));
       rev.setElementID(rs.getString("element_id"));
       rev.setText(rs.getString("review_text"));
       
       
       return rev;
   } 
   public void modify(Review rev) throws Exception {
       
        Connection cn;
        this.openConnection();
        cn = this.getConnection();
       
        PreparedStatement st = this.getConnection().prepareStatement("UPDATE Reviews SET review_text=? WHERE review_id = ?" );
        st.setString(1, rev.getText());
        st.setString(2, rev.getReviewID());
        st.executeUpdate();
        
        st.executeUpdate();
        this.closeConnection();
    }
    
    /*public static void main(String[] args){
        ReviewDAO u=new ReviewDAO();
        Review rev=new Review();
        rev.setUserName("Altair");
        rev.setElementID("2");
        rev.setText("Say my name");
       
        try {
            u.put(rev);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

}

