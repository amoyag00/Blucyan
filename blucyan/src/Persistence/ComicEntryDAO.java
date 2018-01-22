package Persistence;

import Logic.ComicEntry;
import Logic.ShowEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that interacts with the database
 * 
 * @author Alejandro, Carlos, Samuel
 */
public class ComicEntryDAO extends DBConnection implements IConversor<ComicEntry, ComicEntry> {
    
    /**
     * Checks if a comic entry has been added
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
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(entry_id) FROM ComicEntries WHERE comic_id=? AND comicList_id=?");
            st.setString(1, element_id);
            st.setString(2,list_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            isAdded = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method isAdded ComicList " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method isAdded ComicList " + e.getMessage());
            }
        }
        return isAdded;
    }
    
    /**
     * Deletes the comic entry whose entry_id equals id
     * 
     * @param id
     * @throws Exception 
     */
    public void delete(String id) throws Exception {
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM ComicEntries WHERE entry_id=?");
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Method Delete comicEntry " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Metodo Delete ComicListEntry " + e.getMessage());
            }
        }
    }

    /**
     * Checks if a comic entry exists
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    public boolean exists(String id) throws Exception {
        boolean exists = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(entry_id) FROM ComicEntries WHERE entry_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method Delete ComicList " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete ComicList " + e.getMessage());
            }
        }
        return exists;

    }

    /**
     * Gets the entry that corresponds to id
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    public ComicEntry get(String id) throws Exception {
        ComicEntry cE = new ComicEntry();
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM ComicEntries WHERE entry_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            cE.setEntryID(rs.getString("entry_id"));
            cE.setListID(rs.getString("comicList_id"));
            cE.setComicID(rs.getString("comic_id"));
            cE.setValoration(rs.getInt("valoration"));
            cE.setStatus(rs.getString("status_in_list"));
            cE.setNumReadChapters(rs.getInt("number_read_chapters"));

        } catch (Exception e) {
            throw new Exception("Method Delete comicEntry " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete comicEntry " + e.getMessage());
            }
        }
        return cE;
    }

    /**
     * Gets a list of entries that corresponds to id
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    public ArrayList<ComicEntry> getList(String id) throws Exception {
        ArrayList<ComicEntry> comics = new ArrayList<ComicEntry>();
        Connection cn;
        PreparedStatement st;
        ResultSet rs;

        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement(("SELECT Elements.name,ComicEntries.number_read_chapters,ComicEntries.comicList_id, ComicEntries.entry_id,ComicEntries.comic_id, ComicEntries.valoration, ComicEntries.status_in_list\n" +
"FROM ComicEntries\n" +
"INNER JOIN Elements ON  Elements.element_id = ComicEntries.comic_id WHERE ComicEntries.comicList_id= ?"));
        st.setString(1, id);
        rs = st.executeQuery();

        while (rs.next()) {
            ComicEntry entry = new ComicEntry();
            entry.setEntryID(String.valueOf(rs.getInt("entry_id")));
            entry.setListID(id);
            entry.setName(rs.getString("name"));
            entry.setComicID(String.valueOf(rs.getInt("comic_id")));
            entry.setValoration(rs.getInt("valoration"));
            entry.setNumReadChapters(rs.getInt("number_read_chapters"));
            entry.setStatus(rs.getString("status_in_list"));

            comics.add(entry);
        }

    this.closeConnection();
        
        return comics;
    }

    /**
     * Puts a comic entry into the database
     * 
     * @param cE
     * @throws Exception 
     */
    public void put(ComicEntry cE) throws Exception {
        try {
            Connection cn;
            this.openConnection();
            cn = this.getConnection();
            PreparedStatement st = cn.prepareStatement("INSERT INTO ComicEntries(comicList_id,comic_id,valoration,status_in_list,number_read_chapters)"
                    + " VALUES (?,?,?,?,?)");
         
            st.setString(1, cE.getListID());
            st.setString(2, cE.getComicID());
            st.setByte(3, (byte) cE.getValoration());
            st.setString(4, cE.getStatus());
            st.setInt(5, cE.getNumReadChapters());

            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Inserting ComicEntry " + e.getMessage());
        }
        this.closeConnection();

    }

    /**
     * Unsupported operation
     * 
     * @param name
     * @return
     * @throws Exception 
     */
    public List<ComicEntry> search(String name) throws Exception {
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Updates the modifications in an entry
     * 
     * @param cE
     * @throws Exception 
     */
    public void modify(ComicEntry cE) throws Exception {
        Connection cn;
        this.openConnection();
        cn = this.getConnection();
        PreparedStatement st = cn.prepareStatement("UPDATE ComicEntries SET valoration=?, number_read_chapters=?, status_in_list=? WHERE entry_id = ?");
        st.setByte(1, (byte) cE.getValoration());
        st.setInt(2, cE.getNumReadChapters());
        st.setString(3, cE.getStatus());
        st.setString(4, cE.getEntryID());
       

        st.executeUpdate();
        this.closeConnection();
    }
}
