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
 *Class that interacts with the database
 * 
 * @author Aleandro, Carlos, Samuel
 */
public class ShowEntryDAO extends DBConnection implements IConversor<ShowEntry, ShowEntry> {

    /**
     * Deletes the show entry whose entry_id equals to id
     * 
     * @param id
     * @throws Exception 
     */
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

    /**
     * Checks if a show entry exists
     * 
     * @param id
     * @return
     * @throws Exception 
     */
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
    
    /**
     * Checks if a show entry has been added
     * 
     * @param element_id
     * @param list_id
     * @return
     * @throws Exception 
     */
    public boolean isAdded(String element_id, String list_id) throws Exception{
        boolean isAdded = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(entry_id) FROM ShowEntries WHERE show_id=? AND showList_id=?");
            st.setString(1, element_id);
            st.setString(2,list_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            isAdded = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method isAdded ShowList " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method isAdded ShowList " + e.getMessage());
            }
        }
        return isAdded;
    }

    /**
     * Gets the entry that corresponds to the id
     * 
     * @param id
     * @return
     * @throws Exception 
     */
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
    
    /**
     * Gets a list of entries that corresponds to the id
     * 
     * @param id
     * @return
     * @throws Exception 
     */
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

    /**
     * Puts a videogame entry into the database
     * 
     * @param sE
     * @throws Exception 
     */
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

    /**
     * Unsupported operation
     * 
     * @param name
     * @return Nothing
     * @throws Exception 
     */
    public List<ShowEntry> search(String name) throws Exception {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Updates the modifications in an entry
     * 
     * @param sE
     * @throws Exception 
     */
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
}
