package Logic;

public class VideogameEntry extends Entry {
    /**
     * @author Alejandro, Carlos, Samuel
     * Class representing a videogame entry
     */
    private String listID;
    private String videogameID;

   

    

    public void setValoration(int valoration) {
        this.valoration = valoration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getVideogameID() {
        return videogameID;
    }

    public void setVideogameID(String videogameID) {
        this.videogameID = videogameID;
    }
    
    @Override
    public String toString() {
        return "VideogameEntry{" + "listID=" + listID + ", videogameID=" + videogameID + "name=" + name + ", valoration=" + valoration + ", status=" + status + '}';
    }
    
}