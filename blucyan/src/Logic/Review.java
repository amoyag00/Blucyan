package Logic;

public class Review {
    
        private String reviewID;
	private String userName;
	private String elementID;
	private String text;
        
    public String getReviewID(){
        return this.reviewID;
        
    }
    public void setReviewID(String id){
        this.reviewID=id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getElementID() {
        return elementID;
    }

    public void setElementID(String elementID) {
        this.elementID = elementID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
        
}