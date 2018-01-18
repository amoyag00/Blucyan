package Logic;

import Persistence.Facade;
import Persistence.UserDAO;

public class UserProxy extends User{

        Facade facade = Facade.getInstance();
        User realInstance;
        
        private String name;
        
	public User getRealInstance( ) throws Exception{
            
            if(realInstance==null){
                realInstance = (User) facade.search(getUserName(), UserDAO.class);
            }
            return realInstance;
        }
        
        

	private User realUser;

}