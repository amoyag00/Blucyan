/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author alex
 */
public class ComicEntryDAO extends DBConnection implements IConversor<ComicEntry, ComicEntry> {

    public void delete(String id) throws Exception {
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM ComicLists WHERE comicList_id=?");
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

    public boolean exists(String id) throws Exception {
        boolean exists = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(comicList_id) FROM ComicLists WHERE comicList_id=?");
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

    public ComicEntry get(String id) throws Exception {
        ComicEntry cE = new ComicEntry();
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM ComicLists WHERE comicList_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
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

    public ArrayList<ComicEntry> getList(String id) throws Exception {
        ArrayList<ComicEntry> comics = new ArrayList<ComicEntry>();
        Connection cn;
        PreparedStatement st;
        ResultSet rs;

        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT * FROM ComicLists WHERE comicList_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();

        while (rs.next()) {
            ComicEntry entry = new ComicEntry();

            entry.setListID(id);
            entry.setComicID(String.valueOf(rs.getInt("comic_id")));
            entry.setValoration(rs.getInt("valoration"));
            entry.setNumReadChapters(rs.getInt("number_read_chapters"));
            entry.setStatus(rs.getString("status_in_list"));

            comics.add(entry);
        }

        return comics;
    }

    public void put(ComicEntry cE) throws Exception {
        try {
            Connection cn;
            this.openConnection();
            cn = this.getConnection();
            PreparedStatement st = cn.prepareStatement("INSERT INTO ComicLists VALUES (?,?,?,?,?)");
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

    public List<ComicEntry> search(String name) throws Exception {
        throw new UnsupportedOperationException("Method not implemented");
    }

    public void modify(ComicEntry cE) throws Exception {
        Connection cn;
        this.openConnection();
        cn = this.getConnection();
        PreparedStatement st = cn.prepareStatement("UPDATE ComicLists SET valoration=?, number_read_chapters=?, status_in_list=? WHERE comic_id = ? AND comicList_id=?");
        st.setByte(1, (byte) cE.getValoration());
        st.setInt(2, cE.getNumReadChapters());
        st.setString(3, cE.getStatus());
        st.setString(4, cE.getComicID());
        st.setString(5, cE.getListID());

        st.executeUpdate();
        this.closeConnection();
    }

    public static void main(String args[]) {
        ComicEntry vE = new ComicEntry();
        vE.setValoration(75);
        vE.setComicID("3");
        vE.setListID("3");
        vE.setStatus("Planned to read");
        vE.setNumReadChapters(2);

        try {
            ComicEntryDAO vEDAO = new ComicEntryDAO();
//vEDAO.put(vE);
            vEDAO.delete("3");

        } catch (Exception ex) {
            Logger.getLogger(ElementListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
