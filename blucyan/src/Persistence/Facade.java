package Persistence;

import Logic.Element;
import Logic.ElementList;
import Logic.Review;
import Logic.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Facade {
    
        Map<Class,IConversor> mapaDAO = new HashMap<Class,IConversor>();
        
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
	public Object get(String id, Class classType){
            return mapaDAO.get(classType).get(id);
	}

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public void delete(String id, Class classType) {
             mapaDAO.get(classType).delete(id,classType);
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
	public boolean exists(String id, Class classType) {
            return mapaDAO.get(classType).exists(id);
	}

	/**
	 * 
	 * @param name
	 * @param classType
	 */
	public List<Object> search(String name, Class classType) {
	     return mapaDAO.get(classType).search(name);
	}

	public void backup() {
		Backup savior = new Backup();
	}

	public static Facade getInstance() {
		return instance;
	}
	private static Facade instance;
	IConversor conversors;

      
    /*public static void main(String[] args){
        Facade algo = new Facade();
        algo.get("3", UserDAO.class);
    }*/
        
}