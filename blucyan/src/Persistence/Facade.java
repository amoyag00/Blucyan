package Persistence;

import GUI.JDialogBackup;
import Logic.ComicEntry;
import Logic.Element;
import Logic.ElementList;
import Logic.Review;
import Logic.ShowEntry;
import Logic.User;
import Logic.VideogameEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface between logic and persistence
 *
 * @author Alejandro, Carlos, Samuel
 */
public class Facade {

    private Map<Class, IConversor> mapaDAO = new HashMap<Class, IConversor>();
    private static Facade instance;
    private IConversor conversors;

    public Facade() {
        mapaDAO.put(User.class, (IConversor) new UserDAO());
        mapaDAO.put(Element.class, (IConversor) new ElementDAO());
        mapaDAO.put(ElementList.class, (IConversor) new ElementListDAO());
        mapaDAO.put(Review.class, (IConversor) new ReviewDAO());
        mapaDAO.put(VideogameEntry.class, (IConversor) new VideogameEntryDAO());
        mapaDAO.put(ShowEntry.class, (IConversor) new ShowEntryDAO());
        mapaDAO.put(ComicEntry.class, (IConversor) new ComicEntryDAO());

    }

    /**
     * Gets the element of the class classtype identified by id
     *
     * @param id
     * @param classType
     */
    public Object get(String id, Class classType) throws Exception {
        return mapaDAO.get(classType).get(id);
    }

    /**
     * Gets the review identified by id of the use with name nickname
     *
     * @param element_id
     * @param nickname
     * @return
     * @throws Exception
     */
    public Review getReview(String element_id, String nickname) throws Exception {
        return ((ReviewDAO) mapaDAO.get(Review.class)).getReview(element_id, nickname);
    }

    /**
     * Checks if a comic entry has been added into a list
     *
     * @param element_id
     * @param list_id
     * @return
     * @throws Exception
     */
    public boolean isComicEntryAdded(String element_id, String list_id) throws Exception {
        boolean isAdded = false;
        ComicEntryDAO comicEntryDAO = (ComicEntryDAO) mapaDAO.get(ComicEntry.class);
        return comicEntryDAO.isAdded(element_id, list_id);
    }

    /**
     * Checks if a videogame entry has been added into a list
     * 
     * @param element_id
     * @param list_id
     * @return
     * @throws Exception 
     */
    public boolean isVideogameEntryAdded(String element_id, String list_id) throws Exception {
        boolean isAdded = false;
        VideogameEntryDAO vEntryDAO = (VideogameEntryDAO) mapaDAO.get(VideogameEntry.class);
        return vEntryDAO.isAdded(element_id, list_id);
    }

    /**
     * Checks if a show entry has been added into a list
     * 
     * @param element_id
     * @param list_id
     * @return
     * @throws Exception 
     */
    public boolean isShowEntryAdded(String element_id, String list_id) throws Exception {
        boolean isAdded = false;
        ShowEntryDAO sEntryDAO = (ShowEntryDAO) mapaDAO.get(ShowEntry.class);
        return sEntryDAO.isAdded(element_id, list_id);
    }

    /**
     * Gets the three lists of an user
     * 
     * @param id
     * @param classType
     * @return
     * @throws Exception 
     */
    public ElementList[] getLists(String id, Class classType) throws Exception {
        ElementListDAO elList = (ElementListDAO) mapaDAO.get(classType);

        return elList.getLists(id);
    }

    /**
     * Gets the videogame list of an user
     * 
     * @param id
     * @param classType
     * @return
     * @throws Exception 
     */
    public ArrayList<VideogameEntry> getVideogameList(String id, Class classType) throws Exception {
        VideogameEntryDAO videogameEntryDAO = (VideogameEntryDAO) mapaDAO.get(classType);

        ArrayList<VideogameEntry> list = videogameEntryDAO.getList(id);

        return list;
    }

    /**
     * Gets the comic list of an user
     * 
     * @param id
     * @param classType
     * @return
     * @throws Exception 
     */
    public ArrayList<ComicEntry> getComicList(String id, Class classType) throws Exception {
        ComicEntryDAO comicListDAO = (ComicEntryDAO) mapaDAO.get(classType);

        return comicListDAO.getList(id);
    }

    /**
     * Gets the show list of an user
     * 
     * @param id
     * @param classType
     * @return
     * @throws Exception 
     */
    public ArrayList<ShowEntry> getShowList(String id, Class classType) throws Exception {
        ShowEntryDAO showListDAO = (ShowEntryDAO) mapaDAO.get(classType);

        return showListDAO.getList(id);
    }

    /**
     * Deletes the element of the class classtype identified by id
     * 
     * @param id
     * @param classType
     */
    public void delete(String id, Class classType) throws Exception {
        mapaDAO.get(classType).delete(id);
    }

    /**
     * Puts an object of the class classtype into the database
     * 
     * @param obj
     * @param classType
     */
    public void put(Object obj, Class classType) {
        try {
            mapaDAO.get(classType).put(obj);
        } catch (Exception ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Modifies an object of the class classtype
     * 
     * @param obj
     * @param classType
     */
    public void modify(Object obj, Class classType) {
        try {
            mapaDAO.get(classType).modify(obj);
        } catch (Exception ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Checks if an element of the class classtype identified by id exists
     * @param id
     * @param classType
     */
    public boolean exists(String id, Class classType) throws Exception {
        return mapaDAO.get(classType).exists(id);
    }

    /**
     * Searches an element or an user by its name
     * @param <T>
     * @param name
     * @param classType
     */
    public <T> List<T> search(String name, Class<T> classType) throws Exception {
        return mapaDAO.get(classType).search(name);
    }

    /**
     * Checks if the username and the password corresponds
     * to a registered user
     * 
     * @param username
     * @param password
     * @return
     * @throws Exception 
     */
    public boolean matches(String username, String password) throws Exception {
        return ((UserDAO) mapaDAO.get(User.class)).match(username, password);
    }

    /**
     * Creates a backup of the database
     */
    public void backup() {
        JDialogBackup b = new JDialogBackup(new javax.swing.JDialog(), true);
        b.setVisible(true);
        b.dispose();
    }

    /**
     * If there is no instance of Facade it is created, otherwise it
     * is returned
     * 
     * @return instance of facade if it is not created
     */
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }
}
