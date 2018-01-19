package Persistence;

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

public class Facade {
    
        private Map<Class,IConversor> mapaDAO = new HashMap<Class,IConversor>();
        private static Facade instance;
	private IConversor conversors;
        
        public Facade(){
           mapaDAO.put(User.class, (IConversor) new UserDAO());
           mapaDAO.put(Element.class, (IConversor) new ElementDAO());
           mapaDAO.put(ElementList.class,(IConversor) new ElementListDAO());
           mapaDAO.put(Review.class,(IConversor) new ReviewDAO());
           mapaDAO.put(VideogameEntry.class,(IConversor) new VideogameEntryDAO());
           mapaDAO.put(ShowEntry.class,(IConversor) new ShowEntryDAO());
           mapaDAO.put(ComicEntry.class,(IConversor) new ComicEntryDAO());
        
        }

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public Object get(String id, Class classType) throws Exception{
            return mapaDAO.get(classType).get(id);
	}
        
        public ElementList[] getLists(String id, Class classType) throws Exception{
            ElementListDAO elList = (ElementListDAO) mapaDAO.get(classType);
            
            return elList.getLists(id);
        }
        
        public ArrayList<VideogameEntry> getVideogameList(String id, Class classType) throws Exception{
            VideogameEntryDAO videogameList= (VideogameEntryDAO) mapaDAO.get(classType);
            
            return videogameList.getList(id);
        }
        
        public ArrayList<ComicEntry> getComicList(String id, Class classType) throws Exception{
            ComicEntryDAO comicList= (ComicEntryDAO) mapaDAO.get(classType);
            
            return comicList.getList(id);
        }
        
        public ArrayList<ShowEntry> getShowList(String id, Class classType) throws Exception{
            ShowEntryDAO showList= (ShowEntryDAO) mapaDAO.get(classType);
            
            return showList.getList(id);
        }

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public void delete(String id, Class classType) throws Exception {
             mapaDAO.get(classType).delete(id);
	}

	/**
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
	 * 
	 * @param id
	 * @param classType
	 */
	public boolean exists(String id, Class classType) throws Exception {
            return mapaDAO.get(classType).exists(id);
	}

	/**
	 * 
     * @param <T>
	 * @param name
	 * @param classType
	 */
	public <T> List<T> search(String name, Class<T> classType) throws Exception {
            if(name==null) System.out.println("Mal");
	     return mapaDAO.get(classType).search(name);
	}

	public void backup() {
		Backup.backup();
	}

	public static Facade getInstance() {
            if(instance==null){
                instance= new Facade();
            }
		return instance;
	}
	

      
    /*public static void main(String[] args){
        Facade algo = new Facade();
        algo.get("3", UserDAO.class);
    }*/
        
}
