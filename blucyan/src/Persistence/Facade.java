package Persistence;

import Logic.Element;
import Logic.ElementList;
import Logic.Review;
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
            UserDAO userDAO = new UserDAO();
            ElementDAO elementDAO = new ElementDAO();
            ElementListDAO elementListDAO = new ElementListDAO();
            ReviewDAO reviewDAO = new ReviewDAO();
            
           mapaDAO.put(User.class, (IConversor) userDAO);
           mapaDAO.put(Element.class, (IConversor) elementDAO);
           mapaDAO.put(ElementList.class,(IConversor) elementListDAO);
           mapaDAO.put(Review.class,(IConversor) reviewDAO);
        
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
        
        public ArrayList<VideogameEntry> getList(String id, Class classType){
            VideogameEntryDAO videogameList= (VideogameEntryDAO) mapaDAO.get(classType);
            
            return videogameList.getList(id);
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
	 * @param id
	 * @param classType
	 */
	public boolean exists(String id, Class classType) throws Exception {
            return mapaDAO.get(classType).exists(id);
	}

	/**
	 * 
	 * @param name
	 * @param classType
	 */
	public List<Object> search(String name, Class classType) throws Exception {
	     return mapaDAO.get(classType).search(name);
	}

	public void backup() {
		Backup savior = new Backup();
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