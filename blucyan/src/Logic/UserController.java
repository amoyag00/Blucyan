package Logic;

import Persistence.Facade;

public class UserController {

    
        Facade facade = Facade.getInstance();
        User actualUser; 
        
	/**
	 * 
	 * @param userName
	 * @param pass1
	 * @param pass2
	 */
	public void createAccount(String userName, String pass1, String pass2) {
	    
                if(checkPassEquals(pass1,pass2)){
                    
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
	public boolean initiateSession(String userName, String pass) {
            
            if(facade.exists(userName, User.class)){
		User temp = (User) facade.get(userName,User.class);
                boolean correctPassword = checkPass(pass,temp.getPass());
                if(correctPassword){
                    actualUser=temp;
                    return correctPassword;
                }
            }    
            
            return false;
	}

	/**
	 * 
	 * @param pass1
	 * @param pass2
	 */
	public boolean checkPass(String pass1, String pass2) {
		// TODO - implement UserController.checkPass
		throw new UnsupportedOperationException();
	}

	public ElementList getLists() {
		// TODO - implement UserController.getLists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param params
	 * @param elementType
	 */
	public void addElement(String[] params, String elementType) {
		// TODO - implement UserController.addElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void delete(String name) {
        
                //TODO - implement UserController.delete
                //facade.delete(name, classType??); How? Maybe an Object with a cast to User or Review depending the classType; or we could change the argument parameter and pass a reference to de realObject then we can take de classTyppe whenever we want
                
        }


	/**
	 * 
	 * @param pass1
	 * @param pass2
	 */
	public boolean checkPassEquals(String pass1, String pass2) {
		
            return pass1.compareTo(pass2)==0;
            
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
                if(nChars==5 && nNum==1){
                    achieved=true;
                }
                
                return achieved;
	}

	/**
	 * 
	 * @param name
	 */
	public List<Object> search(String name) {
		// TODO - implement UserController.operation
		
	}

	/**
	 * 
	 * @param id
	 */
	public Element showChart(String id) {
		// TODO - implement UserController.showChart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param text
	 * @param elementID
	 */
	public void addReview(String text, String elementID) {
		// TODO - implement UserController.addReview
		throw new UnsupportedOperationException();
	}

	public void backup() {
		// TODO - implement UserController.backup
		throw new UnsupportedOperationException();
	}

}