package Logic;

import Persistence.ComicEntryDAO;
import Persistence.ElementListDAO;
import Persistence.Facade;
import Persistence.ShowEntryDAO;
import Persistence.VideogameEntryDAO;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    /**
     * Controller class used for communicating the graphical interface and
     * other logic classes
     * @author Alejandro, Carlos, Samuel
     */
    private Facade facade = Facade.getInstance();
    private User actualUser;
    private static UserController instance;
    private ElementList vList,cList,sList;
    /**
     * Returns the User instance of the current logged user
     * @return 
     */
    public User getActualUser() {
        return actualUser;
    }
    /**
     * Changes the current user
     * @param actualUser 
     */
    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }

    /**
     * Creates a User and adds it to the database by calling the facade
     * @param userName
     * @param pass1
     * @param pass2
     * @param isPrivate
     * @throws Exception 
     */
    public void createAccount(String userName, String pass1, String pass2, boolean isPrivate) throws Exception {
        
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPass(pass1);
        newUser.setIsPrivate(isPrivate);
        newUser.setIsAdmin(false);
        facade.put(newUser, User.class);
        
    }
    /**
     * Asks the facade if a user of nikckname name exists
     * @param name
     * @return true if exists, false otherwise
     * @throws Exception 
     */
    public boolean UserExists(String name) throws Exception {
        return facade.exists(name, User.class);
    }

    /**
     * Checks if the credentials introduced for the user exist in the database.
     * 
     * @param userName
     * @param pass
     * @return true if the credentials are correct, false otherwise
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
     * Checks that two passwords are equal
     * @param pass1
     * @param pass2
     * @return true if they are equal, false otherwise
     */
    public boolean checkPass(String pass1, String pass2) {
       
        return pass1.equals(pass2);
    }
    /**
     * Returns the lists of a user of nickname nickname
     * @param nickname
     * @return the three lists of that user.
     * @throws Exception 
     */
    public ElementList[] getOtherLists(String nickname) throws Exception{
        ElementList[] lists = facade.getLists(nickname, ElementList.class);
        
        ArrayList<VideogameEntry> videogameList = facade.getVideogameList(lists[0].getListID(), VideogameEntry.class);
        ArrayList<ComicEntry> comicList = facade.getComicList(lists[1].getListID(), ComicEntry.class);
        ArrayList<ShowEntry> showList = facade.getShowList(lists[2].getListID(), ShowEntry.class);
        
        lists[0].setEntryList(videogameList);
        lists[1].setEntryList(comicList);
        lists[2].setEntryList(showList);
        return sort(lists);
    }
    /**
     * returns the lists of the current user
     * @return the three lists of the current user.
     * @throws Exception 
     */
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
        vList=lists[0];
        cList=lists[1];
        sList=lists[2];
        
        return sort(lists);
    }
    
    /**
     * Sorts the three types of list passed as parameter in the following order:
     * 1- VideogameList
     * 2- ComicList
     * 3- ShowList
     * @param unsortedLists
     * @return the lists ordered
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
     * Calls the Factory of adapters and asks for an adapter according to type
     * elementType. Delegates the responsability of create the entry on the 
     * adapter
     * @param params
     * @param elementType
     */
    public void addEntry(String[] params, String elementType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO - implement UserController.addElement
        AdapterFactory adapter = AdapterFactory.getInstance();
        IAdapter adap = adapter.getAdapter(elementType);
        
        Entry entry;
        
        if (elementType.equalsIgnoreCase("videogame")) {
            entry = adap.createEntry(params, vList.getListID());
            facade.put(entry, VideogameEntry.class);
        } else if (elementType.equalsIgnoreCase("comic")) {
            entry = adap.createEntry(params, cList.getListID());
            facade.put(entry, ComicEntry.class);
        } else if (elementType.equalsIgnoreCase("show")) {
            entry = adap.createEntry(params, sList.getListID());
            facade.put(entry, ShowEntry.class);
        }
        
    }
    /**
     * Checks if an entry is already added in the list of type typeElement of 
     * the current user.
     * @param element_id
     * @param typeElement
     * @return true if it is already addded, false otherwise
     * @throws Exception 
     */
    public boolean isEntryAdded(String element_id, String typeElement) throws Exception{
        boolean isAdded=false;
        if(!actualUser.getIsAdmin()){ 
        if(typeElement.equalsIgnoreCase("Videogame")){
                isAdded=facade.isComicEntryAdded(element_id,this.vList.getListID());
            }else if(typeElement.equalsIgnoreCase("Show")){
                isAdded=facade.isComicEntryAdded(element_id,this.sList.getListID());
            }else if(typeElement.equalsIgnoreCase("Comic")){
                isAdded=facade.isComicEntryAdded(element_id,this.cList.getListID());
            }
        }else{
            isAdded=true;
        }
        return isAdded;
        
    }
    
    /**
     * Adds a new element to the database
     * @param params 
     */
    public void addElement(String[] params) {
        
        if (params[1].equalsIgnoreCase("Videogame")) {
            Videogame videogameElement = new Videogame();
            
            videogameElement.setName(params[0]);
            videogameElement.setType(params[1]);
            videogameElement.setCover(params[2]);
            videogameElement.setReleaseDate(params[3]);            
            videogameElement.setPlatforms(params[4].split(","));
            videogameElement.setDeveloper(params[5]);
            videogameElement.setGenre(params[6].split(","));
            videogameElement.setCover(params[8]);
           
            
            facade.put(videogameElement, Element.class);            
        } else if (params[1].equalsIgnoreCase("comic")) {
            Comic comicElement = new Comic();
            
            comicElement.setName(params[0]);
            comicElement.setType(params[1]);
            comicElement.setCover(params[2]);
            comicElement.setReleaseDate(params[3]);            
            comicElement.setNumberChapters(Integer.parseInt(params[4]));
            comicElement.setWriters(params[5].split(","));
            comicElement.setIllustrators(params[6].split(","));
            comicElement.setGenre(params[7].split(","));
            comicElement.setStatusComic(params[8]);
            comicElement.setCover(params[9]);
            
            facade.put(comicElement, Element.class);            
        } else if (params[1].equalsIgnoreCase("show")) {
            Show showElement = new Show();
            
            showElement.setName(params[0]);
            showElement.setType(params[1]);
            showElement.setCover(params[2]);
            showElement.setReleaseDate(params[3]);            
            showElement.setNumberSeasons(Integer.parseInt(params[4]));
            showElement.setNumberEpisodes(Integer.parseInt(params[5]));
            showElement.setDuration(Integer.parseInt(params[6]));
            showElement.setDirectors(params[7].split(","));
            showElement.setActors(params[8].split(","));
            showElement.setProducers(params[9].split(","));
            showElement.setGenre(params[10].split(","));
            showElement.setStatus(params[11]);     
            showElement.setCover(params[12]);
            
            
            facade.put(showElement, Element.class);
        }
    }

    /**
     * Deletes the object of class classType indetified by name 
     * @param name
     * @param classType
     * @throws Exception 
     */
    public void delete(String name, Class classType) throws Exception {

        facade.delete(name, classType);
    }
    
    /**
     * Modifies an entry of type elementType by delegating that responsability
     * in the correspondant adapter
     * @param entry
     * @param elementType
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void modify(Entry entry, String elementType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        IAdapter adapter = AdapterFactory.getInstance().getAdapter(elementType);
        adapter.modEntry(entry);
        
    }

    /**
     * Checks that a password has at least 5 characters and one number
     * @param pass1
     */
    public boolean verifyRequirements(String pass) {
        
        int nChars = 0;
        int nNum = 0;
        boolean achieved = false;
        if(pass.length()>=5 && pass.matches(".*[0-9].*")){
            achieved =true;
        }
        
        
        return achieved;
    }

    /**
     * returns the elements which contains in their name the pattern name
     * It returns a proxy of that element, which contains less information than
     * the real element, according to the Proxy pattern
     * @param name
     */
    public List<ElementProxy> searchElement(String name) throws Exception {
        // TODO - implement UserController.operation

        Class elementClass = Element.class;
        
        return facade.search(name, elementClass);
    }
    
    /**
     * returns the users which contains in their name the pattern name
     * It returns a proxy of those, which contains less information than
     * the real user, according to the Proxy pattern
     * @param name
     * @return the lists of user proxies
     * @throws Exception 
     */
    public List<UserProxy> searchUser(String name) throws Exception {
        // TODO - implement UserController.operation

        Class elementClass = User.class;
        
        return facade.search(name, elementClass);
    }

    /**
     * Returns the element identified by id
     * @param id
     * @returns the element
     */
    public Element showChart(String id) throws Exception {
        // TODO - implement UserController.showChart
        return (Element) facade.get(id, Element.class);
    }

    /**
     * Adds a review to the database 
     * @param rev 
     */
    public void addReview(Review rev) {
        // TODO - implement UserController.addReview
       rev.setUserName(this.actualUser.getUserName());
      
        facade.put(rev, Review.class);
        
    }
    
    /**
     * Returns the review written by the current user of the element element_id
     * @param element_id
     * @return the review
     * @throws Exception 
     */
    public Review  getReview(String element_id) throws Exception{
        return facade.getReview(element_id, this.actualUser.getUserName());
    }
    
    /**
     * Performs a backup
     */
    public void backup() {
        // TODO - implement UserController.backup
        facade.backup();
    }
    
    /**
     * Registers an element in the databse by delegating that responsability in
     * the facade
     * @param el 
     */
    public void putElement(Element el) {
        facade.put(el, Element.class);
    }
    
    /**
     * Returns a unique instance of this class
     * @return 
     */
    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }
    
}
