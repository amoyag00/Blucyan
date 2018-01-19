package Logic;

public class VideogameEntry extends Entry {
    private String listID;
    private String videogameID;

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