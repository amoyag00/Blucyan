package Persistence;

import Logic.*;
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
public class ReviewDAO extends DBConnection implements IConversor<Review, Review> {

    /**
     * Deletes the show review whose review_id equals id
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM Reviews WHERE review_id=?");
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Method Delete user " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Metodo Eliminar un usuario " + e.getMessage());
            }
        }
    }

    /**
     * Checks if a review exists
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean exists(String id) throws Exception {
        boolean exists = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(review_id) FROM Reviews WHERE review_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method Delete review " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete review " + e.getMessage());
            }
        }
        return exists;

    }

    /**
     * Checks if an entry has a review written by a user
     *
     * @param element_id
     * @param nickname
     * @return
     * @throws Exception
     */
    private boolean exists(String element_id, String nickname) throws Exception {
        boolean exists = false;
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT COUNT(review_id) FROM Reviews WHERE element_id=? AND  nickname=?");
            st.setString(1, element_id);
            st.setString(2, nickname);
            ResultSet rs = st.executeQuery();
            rs.next();
            exists = rs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Method Delete review " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete review " + e.getMessage());
            }
        }
        return exists;

    }

    /**
     * Gets the review that corresponds to the id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Review get(String id) throws Exception {
        Review rev = new Review();
        try {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Reviews WHERE review_id=?");
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            rev.setReviewID(rs.getString("review_id"));
            rev.setUserName(rs.getString("nickname"));
            rev.setElementID(rs.getString("element_id"));
            rev.setText(rs.getString("review_text"));

        } catch (Exception e) {
            throw new Exception("Method Delete review " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (Exception e) {
                throw new Exception("Method delete review " + e.getMessage());
            }
        }
        return rev;
    }

    /**
     * Put a review into the database
     *
     * @param rev
     * @throws Exception
     */
    public void put(Review rev) throws Exception {
        try {
            if (exists(rev.getElementID(), rev.getUserName())) {
                modify(rev);
            } else {
                Connection cn;
                this.openConnection();
                cn = this.getConnection();
                PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO Reviews (nickname,element_id,review_text) VALUES (?,?,?)");
                st.setString(1, rev.getUserName());
                st.setString(2, rev.getElementID());
                st.setString(3, rev.getText());
                st.executeUpdate();
            }
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
    public List<Review> search(String name) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Method not implmented");
    }

    /**
     * Gets the review of an element written by a user
     * 
     * @param element_id
     * @param nickname
     * @return
     * @throws Exception 
     */
    public Review getReview(String element_id, String nickname) throws Exception {
        Review rev = null;
        if (exists(element_id, nickname)) {
            this.openConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Reviews WHERE element_id=? AND nickname=?");
            st.setInt(1, Integer.parseInt(element_id));
            st.setString(2, nickname);
            ResultSet rs = st.executeQuery();
            rs.next();
            rev = new Review();
            rev.setReviewID(String.valueOf(rs.getString("review_id")));
            rev.setUserName(rs.getString("nickname"));
            rev.setElementID(String.valueOf(rs.getString("element_id")));
            rev.setText(rs.getString("review_text"));
        } else {
            rev = new Review();
            rev.setText("");
        }

        this.closeConnection();

        return rev;
    }

    /**
     * Updates the modifications in a review
     * 
     * @param rev
     * @throws Exception 
     */
    public void modify(Review rev) throws Exception {

        Connection cn;
        this.openConnection();
        cn = this.getConnection();

        PreparedStatement st = this.getConnection().prepareStatement("UPDATE Reviews SET review_text=? WHERE element_id = ? AND nickname=?");
        st.setString(1, rev.getText());
        st.setString(2, rev.getElementID());
        st.setString(3, rev.getUserName());
        st.executeUpdate();

        this.closeConnection();
    }
}
