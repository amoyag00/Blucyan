/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Logic.ElementList;
import Logic.VideogameEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class VideogameEntryDAO extends DBConnection implements IConversor<VideogameEntry,VideogameEntry>{
    	    
    public void delete(String id) throws Exception {
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM VideogameLists WHERE videogameList_id=?");
            st.setString(1, id);
            st.executeUpdate();
        }catch (Exception e){
            throw new Exception("Method Delete list " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Metodo Delete VideogameListEntry " + e.getMessage());
            }
        }
    }
    
    public boolean exists(String id) throws Exception{
        boolean exists=false;
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(videogameList_id) FROM VideogameLists WHERE videogameList_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists=rs.getBoolean(1);
        }catch (Exception e){
            throw new Exception("Method Delete VideogameList " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Method delete VideogameList " + e.getMessage());
            }
        }
        return exists;
        
    }
    
    
     public VideogameEntry get(String id) throws Exception{
         VideogameEntry vE=new VideogameEntry();
       try{
                this.openConnection();
                PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM VideogameLists WHERE videogameList_id=?");
                st.setString(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                vE.setListID(rs.getString("videogameList_id"));
                vE.setVideogameID(rs.getString("videogame_id"));
                vE.setValoration(rs.getInt("valoration"));
                vE.setStatus(rs.getString("status_in_list"));
               

            }catch (Exception e){
                throw new Exception("Method Delete review " + e.getMessage());
            }finally{
                try{
                    this.closeConnection();
                }catch (Exception e){
                    throw new Exception("Method delete review " + e.getMessage());
                }
            }
       return vE;
   }
    
    public void put(VideogameEntry vE) throws Exception{
        try {
            Connection cn;
            this.openConnection();
            cn=this.getConnection();
            PreparedStatement st = cn.prepareStatement("INSERT INTO VideogameLists VALUES (?,?,?,?)");   
            st.setString(1, vE.getListID());
            st.setString(2, vE.getVideogameID());
            st.setByte(3, (byte) vE.getValoration());
            st.setString(4, vE.getStatus());
            
            st.executeUpdate();
        }catch(Exception e){
            throw new Exception("Inserting VideogameEntry " + e.getMessage());
        }
                this.closeConnection();
         
    }
    
   public List<VideogameEntry> search(String name) throws Exception{
       throw new UnsupportedOperationException("Method not implemented");
    }
   
   public static void main (String args[]){
       VideogameEntry vE;
       
      
                try {
                    VideogameEntryDAO vEDAO=new VideogameEntryDAO();
                    vEDAO.delete("1");
                    
                     
                } catch (Exception ex) {
                    Logger.getLogger(ElementListDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
       
   }
}