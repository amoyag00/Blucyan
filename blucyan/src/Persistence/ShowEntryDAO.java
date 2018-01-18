/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Logic.ElementList;
import Logic.ShowEntry;
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
public class ShowEntryDAO extends DBConnection implements IConversor<ShowEntry,ShowEntry>{
    	    
    public void delete(String id) throws Exception {
        try{
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM ShowLists WHERE showList_id=?");
            st.setString(1, id);
            st.executeUpdate();
        }catch (Exception e){
            throw new Exception("Method Delete showEntry " + e.getMessage());
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
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(showList_id) FROM ShowLists WHERE showList_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists=rs.getBoolean(1);
        }catch (Exception e){
            throw new Exception("Method Delete ShowList " + e.getMessage());
        }
        
        finally{
            try{
                this.closeConnection();
            }catch (Exception e){
                throw new Exception("Method delete ShowList " + e.getMessage());
            }
        }
        return exists;
        
    }
    
    
     public ShowEntry get(String id) throws Exception{
         ShowEntry sE=new ShowEntry();
       try{
                this.openConnection();
                PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM ShowLists WHERE showList_id=?");
                st.setString(1, id);
                ResultSet rs = st.executeQuery();
                rs.next();
                sE.setListID(rs.getString("showList_id"));
                sE.setShowID(rs.getString("show_id"));
                sE.setValoration(rs.getInt("valoration"));
                sE.setStatus(rs.getString("status_in_list"));
                sE.setNumWatchedEpisodes(rs.getInt("number_watched_episodes"));
               

            }catch (Exception e){
                throw new Exception("Method Delete showEntry " + e.getMessage());
            }finally{
                try{
                    this.closeConnection();
                }catch (Exception e){
                    throw new Exception("Method delete showEntry " + e.getMessage());
                }
            }
       return sE;
   }
    
    public void put(ShowEntry sE) throws Exception{
        try {
            Connection cn;
            this.openConnection();
            cn=this.getConnection();
            PreparedStatement st = cn.prepareStatement("INSERT INTO ShowLists VALUES (?,?,?,?,?)");   
            st.setString(1, sE.getListID());
            st.setString(2, sE.getShowID());
            st.setByte(3, (byte) sE.getValoration());
            st.setString(4, sE.getStatus());
            st.setInt(5, sE.getNumWatchedEpisodes());
            
            st.executeUpdate();
        }catch(Exception e){
            throw new Exception("Inserting ShowEntry " + e.getMessage());
        }
                this.closeConnection();
         
    }
    
   public List<ShowEntry> search(String name) throws Exception{
       throw new UnsupportedOperationException("Method not implemented");
    }
   
   public static void main (String args[]){
       ShowEntry vE =new ShowEntry();
       
       
      
                try {
                    ShowEntryDAO vEDAO=new ShowEntryDAO();
                   vEDAO.delete("2");
                    
                    
                     
                } catch (Exception ex) {
                    Logger.getLogger(ElementListDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
       
   }
}
