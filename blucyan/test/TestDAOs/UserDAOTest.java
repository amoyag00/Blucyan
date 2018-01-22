/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDAOs;

import Logic.User;
import Logic.UserProxy;
import Persistence.UserDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        try {
            UserDAO u = new UserDAO();
            u.delete("TestUser");
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void GetExists() {
        UserDAO u= new UserDAO();
        User user=new User();
        user.setUserName("TestUser");
        user.setIsAdmin(true);
        user.setPass("TestPass");
        user.setIsPrivate(true);
        try {
            u.put(user);
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            assertTrue(user.toString().compareTo(u.get("TestUser").toString())==0);
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            assertTrue(u.exists("TestUser"));
           
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @Test
    public void Search(){
        UserDAO u= new UserDAO();
        User user=new User();
        user.setUserName("TestUser");
        user.setIsAdmin(true);
        user.setPass("TestPass");
        user.setIsPrivate(true);
        try {
            u.put(user);
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List<UserProxy> list=u.search("TestUser");
            assertTrue(list.get(0).getName().compareTo(user.getUserName())==0);
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
     public void Modify(){
        UserDAO u= new UserDAO();
        User user=new User();
        user.setUserName("TestUser");
        user.setIsAdmin(true);
        user.setPass("TestPass");
        user.setIsPrivate(true);
        try {
            u.put(user);
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            user.setIsAdmin(false);
            u.modify(user);
            assertTrue(user.getIsAdmin()==u.get("TestUser").getIsAdmin());
        } catch (Exception ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
