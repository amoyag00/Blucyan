package Logic;

public class Videogame extends Element {
    /**
     * Class representing a videogame. Inherits from Element
     * @author Carlos, Samuel, Alejandro
     */
    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }


	private String[] platforms;
        private String developer;

 
    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
        

}
