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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ShowEntryDAO extends DBConnection implements IConversor<ShowEntry, ShowEntry> {

    public void delete(String id) throws Exception {
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM ShowEntries WHERE entry_id=?");
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Method Delete showEntry " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Metodo Delete VideogameListEntry " + e.getMessage());
            }
        }
    }

    public boolean exists(String id) throws Exception {
        boolean exists = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(entry_id) FROM ShowEntries WHERE entry_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method Delete ShowEntry " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete ShowEntry " + e.getMessage());
            }
        }
        return exists;

    }

    public ShowEntry get(String id) throws Exception {
        ShowEntry sE = new ShowEntry();
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM ShowEntries WHERE entry_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            sE.setEntryID(String.valueOf(rs.getInt("entry_id")));
            sE.setListID(rs.getString("showList_id"));
            sE.setShowID(rs.getString("show_id"));
            sE.setValoration(rs.getInt("valoration"));
            sE.setStatus(rs.getString("status_in_list"));
            sE.setNumWatchedEpisodes(rs.getInt("number_watched_episodes"));

        } catch (Exception e) {
            throw new Exception("Method Delete showEntry " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete showEntry " + e.getMessage());
            }
        }
        return sE;
    }
    
    public ArrayList<ShowEntry> getList(String id) throws Exception {
        ArrayList<ShowEntry> shows = new ArrayList<ShowEntry>();
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT Elements.name,ShowEntries.number_watched_episodes,ShowEntries.showList_id, ShowEntries.entry_id,ShowEntries.show_id, ShowEntries.valoration, ShowEntries.status_in_list\n" +
"FROM ShowEntries\n" +
"INNER JOIN Elements ON  Elements.element_id = ShowEntries.show_id WHERE ShowEntries.showList_id= ?");
        st.setString(1, id);
        rs = st.executeQuery();
        
        while(rs.next()){
            ShowEntry entry = new ShowEntry();
            entry.setEntryID(String.valueOf(rs.getInt("entry_id")));
            entry.setListID(id);
            entry.setName(rs.getString("name"));
            entry.setNumWatchedEpisodes(rs.getInt("number_watched_episodes"));
            entry.setShowID(String.valueOf(rs.getInt("show_id")));
            entry.setStatus(rs.getString("status_in_list"));
            entry.setValoration(rs.getInt("valoration"));
            
            shows.add(entry);
        }
        
        this.closeConnection();
        
        return shows;
    }

    public void put(ShowEntry sE) throws Exception {
        try {
            Connection cn;
            this.openConnection();
            cn = this.getConnection();
            PreparedStatement st = cn.prepareStatement("INSERT INTO ShowEntries(showList_id,show_id,valoration,status_in_list,number_watched_episodes)"
                    + " VALUES (?,?,?,?,?)");
            st.setString(1, sE.getListID());
            st.setString(2, sE.getShowID());
            st.setByte(3, (byte) sE.getValoration());
            st.setString(4, sE.getStatus());
            st.setInt(5, sE.getNumWatchedEpisodes());

            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Inserting ShowEntry " + e.getMessage());
        }
        this.closeConnection();

    }

    public List<ShowEntry> search(String name) throws Exception {
        throw new UnsupportedOperationException("Method not implemented");
    }

    public void modify(ShowEntry sE) throws Exception {
        Connection cn;
        this.openConnection();
        cn = this.getConnection();
        PreparedStatement st = cn.prepareStatement("UPDATE ShowEntries SET valoration=?, number_watched_episodes=?, status_in_list=? WHERE entry_id=?");
        st.setByte(1, (byte) sE.getValoration());
        st.setInt(2, sE.getNumWatchedEpisodes());
        st.setString(3, sE.getStatus());
        st.setString(4, sE.getEntryID());

        st.executeUpdate();
        this.closeConnection();
    }

    public static void main(String args[]) {
        ShowEntry vE = new ShowEntry();

        try {
            ShowEntryDAO vEDAO = new ShowEntryDAO();
            vEDAO.delete("2");

        } catch (Exception ex) {
            Logger.getLogger(ElementListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
