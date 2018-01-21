package Logic;

import Persistence.ComicEntryDAO;
import Persistence.ElementListDAO;
import Persistence.Facade;
import Persistence.ShowEntryDAO;
import Persistence.VideogameEntryDAO;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    private Facade facade = Facade.getInstance();
    private User actualUser;
    private static UserController instance;

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }

    /**
     *
     * @param userName
     * @param pass1
     * @param pass2
     */
    public void createAccount(String userName, String pass1, String pass2) throws Exception {

        if (checkPass(pass1, pass2)) {

            if (verifyRequirements(pass1)) {

                if (!facade.exists(userName, User.class)) {

                    User newUser = new User();
                    newUser.setUserName(userName);
                    newUser.setPass(pass1);
                    facade.put(newUser, User.class);
                }

            }

        }

    }

    /**
     *
     * @param userName
     * @param pass
     */
    public boolean initiateSession(String userName, String pass) throws Exception {

        boolean correctPassword = false;

        if (facade.exists(userName, User.class)) {
            User temp = (User) facade.get(userName, User.class);
            correctPassword = checkPass(pass, temp.getPass());
            if (correctPassword) {
                actualUser = temp;
                return correctPassword;
            }
        }

        return correctPassword;
    }

    /**
     *
     * @param pass1
     * @param pass2
     */
    public boolean checkPass(String pass1, String pass2) {
        // TODO - implement UserController.checkPass
        return pass1.equals(pass2);
    }

    public ElementList[] getLists() throws Exception {
        // TODO - implement UserController.getLists
        //Videogame->0     Comic ->1     Show->2
        ElementList[] lists = facade.getLists(actualUser.getUserName(), ElementList.class);

        ArrayList<VideogameEntry> videogameList = facade.getVideogameList(lists[0].getListID(), VideogameEntry.class);
        ArrayList<ComicEntry> comicList = facade.getComicList(lists[1].getListID(), ComicEntry.class);
        ArrayList<ShowEntry> showList = facade.getShowList(lists[2].getListID(), ShowEntry.class);

        lists[0].setEntryList(videogameList);
        lists[1].setEntryList(comicList);
        lists[2].setEntryList(showList);

        return sort(lists);
    }

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
     *
     * @param params
     * @param elementType
     */
    public void addEntry(String[] params, String elementType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO - implement UserController.addElement
        AdapterFactory adapter = AdapterFactory.getInstance();
        IAdapter adap = adapter.getAdapter(elementType);

        Entry entry = adap.createEntry(params);

        if (elementType.equalsIgnoreCase("videogame")) {
            facade.put(entry, VideogameEntryDAO.class);
        } else if (elementType.equalsIgnoreCase("comic")) {
            facade.put(entry, ComicEntryDAO.class);
        } else if (elementType.equalsIgnoreCase("show")) {
            facade.put(entry, ShowEntryDAO.class);
        }

    }

    public void addElement(String[] params) {

        if (params[1].equalsIgnoreCase("Videogame")) {
            Videogame videogameElement =new Videogame();
            
            videogameElement.setName(params[0]);
            videogameElement.setType(params[1]);
            videogameElement.setCover(params[2]);
            videogameElement.setReleaseDate(params[3]);           
            videogameElement.setPlatforms(params[4].split(","));
            videogameElement.setDeveloper(params[5]);
            videogameElement.setGenre(params[6].split(","));
            //facade.put(entry, VideogameEntryDAO.class);
        } else if (params[1].equalsIgnoreCase("comic")) {
            //facade.put(entry, ComicEntryDAO.class);
        } else if (params[1].equalsIgnoreCase("show")) {
            //facade.put(entry, ShowEntryDAO.class);
        }
    }

    /**
     *
     * @param name
     */
    public void delete(String name, Class classType) throws Exception {

        //TODO - implement UserController.delete
        //facade.delete(name, classType??); How? Maybe an Object with a cast to User or Review depending the classType; or we could change the argument parameter and pass a reference to de realObject then we can take de classTyppe whenever we want
        facade.delete(name, classType);
    }

    public void modify(Entry entry, String elementType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        IAdapter adapter = AdapterFactory.getInstance().getAdapter(elementType);
        adapter.modEntry(entry);

    }

    /**
     *
     * @param pass1
     */
    public boolean verifyRequirements(String pass) {

        int nChars = 0;
        int nNum = 0;
        boolean achieved = false;

        for (int i = 0; i < pass.length(); i++) {
            char aux = pass.charAt(i);
            if (aux > 47 && aux < 58) {
                nNum++;
            } else {
                nChars++;
            }
        }

        // Requirements 5 characters + 1 number
        if (nChars >= 5 && nNum >= 1) {
            achieved = true;
        }

        return achieved;
    }

    /**
     *
     * @param name
     */
    public List<ElementProxy> searchElement(String name) throws Exception {
        // TODO - implement UserController.operation

        Class elementClass = Element.class;

        return facade.search(name, elementClass);
    }

    public List<UserProxy> searchUser(String name) throws Exception {
        // TODO - implement UserController.operation

        Class elementClass = User.class;

        return facade.search(name, elementClass);
    }

    /**
     *
     * @param id
     */
    public Element showChart(String id) throws Exception {
        // TODO - implement UserController.showChart
        return (Element) facade.get(id, Element.class);
    }

    /**
     *
     * @param text
     * @param elementID
     */
    public void addReview(String text, String elementID) {
        // TODO - implement UserController.addReview
        Review newReview = new Review(actualUser.getUserName(), elementID, text);

        facade.put(newReview, Review.class);

    }

    public void backup() {
        // TODO - implement UserController.backup
        facade.backup();
    }

    public void putElement(Element el) {
        facade.put(el, Element.class);
    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

}
