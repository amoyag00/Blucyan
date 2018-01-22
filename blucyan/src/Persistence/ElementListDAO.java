package Persistence;

import Logic.ElementList;
import Logic.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that interacts with the database
 *
 * @author Aleandro, Carlos, Samuel
 */
public class ElementListDAO extends DBConnection implements IConversor<ElementList, ElementList[]> {

    /**
     * Deletes the list whose list_id equals to id
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception {
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM Lists WHERE list_id=?");
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Method Delete list " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Metodo Delete List " + e.getMessage());
            }
        }
    }

    /**
     * Checks if a list exists
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean exists(String id) throws Exception {
        boolean exists = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(list_id) FROM Lists WHERE list_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method Delete List " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete List " + e.getMessage());
            }
        }
        return exists;

    }

    /**
     * Gets the list that corresponds to id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public ElementList get(String id) throws Exception {
        ElementList eList = new ElementList();
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Lists WHERE list_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            eList.setListID(rs.getString("list_id"));
            eList.setNickname(rs.getString("nickname"));
            eList.setTypeList(rs.getString("type_list"));

        } catch (Exception e) {
            throw new Exception("Method Delete review " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete review " + e.getMessage());
            }
        }
        return eList;
    }

    /**
     * Gets the lists of an user
     *
     * @param id
     * @return
     * @throws Exception
     */
    public ElementList[] getLists(String id) throws Exception {
        ElementList[] lists = new ElementList[3];
        Connection cn;
        PreparedStatement st;
        ResultSet rs;

        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("Select * FROM Lists WHERE nickname = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ElementList();
        }
        for (int i = 0; i < lists.length; i++) {
            rs.next();
            lists[i].setListID(String.valueOf(rs.getInt("list_id")));
            lists[i].setNickname(rs.getString("nickname"));
            lists[i].setTypeList(rs.getString("typeList"));
        }

        this.closeConnection();

        return sort(lists);

    }

    /**
     * Sorts the three lists
     * 
     * @param unsortedLists
     * @return 
     */
    private ElementList[] sort(ElementList[] unsortedLists) {
        ElementList[] sortedLists = new ElementList[unsortedLists.length];
        for (int i = 0; i < unsortedLists.length; i++) {
            if (unsortedLists[i].getTypeList().equalsIgnoreCase("Videogame")) {
                sortedLists[0] = unsortedLists[i];
            } else if (unsortedLists[i].getTypeList().equalsIgnoreCase("Comic")) {
                sortedLists[1] = unsortedLists[i];
            } else if (unsortedLists[i].getTypeList().equalsIgnoreCase("Show")) {
                sortedLists[2] = unsortedLists[i];
            }

        }
        return sortedLists;
    }

    /**
     * Puts a list into the database
     * 
     * @param eList
     * @throws Exception 
     */
    public void put(ElementList eList) throws Exception {
        try {
            Connection cn;
            this.openConnection();
            cn = this.getConnection();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO Lists (typeList,nickname) VALUES (?,?)");
            st.setString(1, eList.getTypeList());
            st.setString(2, eList.getNickname());
            //?

            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Inserting review " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Closing connection insert user " + e.getMessage());
            }
        }
    }

    /**
     * Unsupported operation
     * 
     * @param name
     * @return Nothing
     * @throws UnsupportedOperationException 
     */
    public List<ElementList[]> search(String name) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Method not implmented");
    }

    /**
     * Unsupported operation
     * 
     * @param element
     * @throws Exception 
     */
    @Override
    public void modify(ElementList element) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
