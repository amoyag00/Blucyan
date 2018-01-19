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
        
	/**
	 * 
	 * @param userName
	 * @param pass1
	 * @param pass2
	 */
	public void createAccount(String userName, String pass1, String pass2) throws Exception {
	    
                if(checkPass(pass1,pass2)){
                    
                    if(verifyRequirements(pass1)){
                        
                        if(!facade.exists(userName, User.class)){
                            
                            User newUser = new User();
                            newUser.setUserName(userName);
                            newUser.setPass(pass1);
                            facade.put(newUser,User.class);
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
            
            if(facade.exists(userName, User.class)){
		User temp = (User) facade.get(userName,User.class);
                correctPassword = checkPass(pass,temp.getPass());
                if(correctPassword){
                    actualUser=temp;
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
		ElementList[] lists = facade.getLists(actualUser.getUserName(), ElementList.class);
                
                ArrayList<VideogameEntry> videogameList = facade.getVideogameList(lists[2].getListID(), VideogameEntry.class);
                ArrayList<ComicEntry> comicList = facade.getComicList(lists[1].getListID(), ComicEntry.class);
                ArrayList<ShowEntry> showList = facade.getShowList(lists[0].getListID(), ShowEntry.class);
                
                lists[0].setEntryList(showList);
                lists[1].setEntryList(comicList);
                lists[2].setEntryList(videogameList);
                
                return lists;
	}

	/**
	 * 
	 * @param params
	 * @param elementType
	 */
	public void addElement(String[] params, String elementType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO - implement UserController.addElement
                AdapterFactory adapter = AdapterFactory.getInstance();
		IAdapter adap = adapter.getAdapter(elementType);
                
                Entry entry = adap.createEntry(params);
                
                if(elementType.equalsIgnoreCase("videogame")){
                     facade.put(entry, VideogameEntryDAO.class);
                }
                else if(elementType.equalsIgnoreCase("comic")){
                     facade.put(entry, ComicEntryDAO.class);
                }
                else if(elementType.equalsIgnoreCase("show")){
                     facade.put(entry, ShowEntryDAO.class);
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

        public void modify(String[] params, String elementType) throws ClassNotFoundException{
        
           Element element = new Element();
                  
            
           facade.modify(element, Class.forName(elementType));
            
        }
        
	/**
	 * 
	 * @param pass1
	 */
	public boolean verifyRequirements(String pass) {
		
		int nChars = 0;
                int nNum = 0;
                boolean achieved=false;
               
                for(int i=0; i<pass.length(); i++){
                    char aux = pass.charAt(i);
                    if(aux>47 && aux<58 ){
                        nNum++;
                    }else{
                        nChars++;
                    }
                }
                
                // Requirements 5 characters + 1 number
                if(nChars>=5 && nNum>=1){
                    achieved=true;
                }
                
                return achieved;
	}

	/**
	 * 
	 * @param name
	 */
	public List<Object> search(String name, String elementType) throws Exception {
		// TODO - implement UserController.operation
                
                Class elementClass=null;
                
                switch(elementType){
                
                    case "Videogames":            
                    case "Shows":               
                    case "Comics": elementClass=Element.class;
                                break;
                    case "Users": elementClass=User.class;
                                break;
                
                }
                
		return facade.search(name, elementClass);
	}

	/**
	 * 
	 * @param id
	 */
	public Element showChart(String id) throws Exception {
		// TODO - implement UserController.showChart
                return (Element) facade.get(id,Element.class);
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
        
        public static UserController getInstance() {
            if(instance==null){
                instance= new UserController();
            }
		return instance;
	}

}
