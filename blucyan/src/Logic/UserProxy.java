package Logic;

import Persistence.Facade;
import Persistence.UserDAO;
/**
 * Class representating a user. it does not contain the password of the user
 * @author Alejandro, Carlos, Samuel
 */
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
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String path){
        image = path;
    }
        Facade facade = Facade.getInstance();
        User realInstance;
        
        private String name;
        private String image;
        /**
         * Returns the real instance associated to this user.
         * @return
         * @throws Exception 
         */
	public User getRealInstance( ) throws Exception{
            
            if(realInstance==null){
                realInstance = (User) facade.search(getUserName(), UserDAO.class);
            }
            return realInstance;
        }
        
        

	private User realUser;

}