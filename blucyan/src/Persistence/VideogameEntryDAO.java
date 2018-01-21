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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class VideogameEntryDAO extends DBConnection implements IConversor<VideogameEntry, VideogameEntry> {

    public void delete(String id) throws Exception {
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM VideogameEntries WHERE entry_id=?");
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Method Delete list " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Metodo Delete VideogameListEntry " + e.getMessage());
            }
        }
    }
    
    public boolean isAdded(String element_id, String list_id) throws Exception{
        boolean isAdded = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(entry_id) FROM VideogameEntries WHERE videogame_id=? AND videogameList_id=?");
            st.setString(1, element_id);
            st.setString(2,list_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            isAdded = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method isAdded VideogameList " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method isAdded VideogameList " + e.getMessage());
            }
        }
        return isAdded;
    }

    public boolean exists(String id) throws Exception {
        boolean exists = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(entry_id) FROM VideogameEntries WHERE entry_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method Delete VideogameEntries " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete VideogameEntries " + e.getMessage());
            }
        }
        return exists;

    }

    public VideogameEntry get(String id) throws Exception {
        VideogameEntry vE = new VideogameEntry();
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM VideogameEntries WHERE entry_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            vE.setEntryID("entry_id");
            vE.setListID(rs.getString("videogameList_id"));
            vE.setVideogameID(rs.getString("videogame_id"));
            vE.setValoration(rs.getInt("valoration"));
            vE.setStatus(rs.getString("status_in_list"));

        } catch (Exception e) {
            throw new Exception("Method Delete VideogameEntry " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete VideogameEntry " + e.getMessage());
            }
        }
        return vE;
    }
    
    public ArrayList<VideogameEntry> getList(String id) throws Exception{
        ArrayList<VideogameEntry> videogames = new ArrayList<VideogameEntry>();
        Connection cn;
        PreparedStatement st;
        ResultSet rs;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT Elements.name,VideogameEntries.videogameList_id, VideogameEntries.entry_id,VideogameEntries.videogame_id, VideogameEntries.valoration, VideogameEntries.status_in_list\n" +
"FROM VideogameEntries\n" +
"INNER JOIN Elements ON  Elements.element_id = VideogameEntries.videogame_id WHERE VideogameEntries.videogameList_id= ?");
        
        st.setString(1,id);
        rs = st.executeQuery();
        
        while(rs.next()){
            VideogameEntry entry = new VideogameEntry();
            entry.setEntryID(String.valueOf(rs.getString("entry_id")));
            entry.setListID(id);
            entry.setName(rs.getString("name"));
            entry.setStatus(rs.getString("status_in_list"));
            entry.setValoration(rs.getInt("valoration"));
           
            entry.setVideogameID(String.valueOf(rs.getInt("videogame_id")));
            
            videogames.add(entry);
            
        }
        
        this.closeConnection();
        
        return videogames;
    }
     
    public void put(VideogameEntry vE) throws Exception {
        try {
            Connection cn;
            this.openConnection();
            cn = this.getConnection();
            PreparedStatement st = cn.prepareStatement("INSERT INTO VideogameEntries VALUES (?,?,?,?)");
            st.setString(1, vE.getListID());
            st.setString(2, vE.getVideogameID());
            st.setByte(3, (byte) vE.getValoration());
            st.setString(4, vE.getStatus());

            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Inserting VideogameEntry " + e.getMessage());
        }
        this.closeConnection();

    }

    public List<VideogameEntry> search(String name) throws Exception {
        throw new UnsupportedOperationException("Method not implemented");
    }

    public void modify(VideogameEntry vE) throws Exception {
        Connection cn;
        this.openConnection();
        cn = this.getConnection();
        PreparedStatement st = cn.prepareStatement("UPDATE VideogameEntries SET valoration=?, status_in_list=? WHERE entry_id = ? ");
        st.setByte(1, (byte) vE.getValoration());
        st.setString(2, vE.getStatus());
        st.setString(3, vE.getEntryID());
        st.setString(4, vE.getEntryID());
        
        st.executeUpdate();
        this.closeConnection();
    }
    
    public static void main(String args[]) {
        VideogameEntry vE;

        try {
            VideogameEntryDAO vEDAO = new VideogameEntryDAO();
            vEDAO.delete("1");

        } catch (Exception ex) {
            Logger.getLogger(ElementListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
