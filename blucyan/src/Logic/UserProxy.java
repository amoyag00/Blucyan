package Logic;

import Persistence.Facade;
import Persistence.UserDAO;

public class UserProxy extends User{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getRealUser() {
        return realUser;
    }

    public void setRealUser(User realUser) {
        this.realUser = realUser;
    }

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