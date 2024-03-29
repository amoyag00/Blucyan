package Logic;

public class User {
/**
 * Class representing a user
 * @author Alejandro, Carlos, Samuel
 * 
 */
	private String userName;
	private String pass;
        private boolean isAdmin;
	private boolean isPrivate;
        
    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", pass=" + pass + ", isAdmin=" + isAdmin + ", isPrivate=" + isPrivate + '}';
    }
	

}