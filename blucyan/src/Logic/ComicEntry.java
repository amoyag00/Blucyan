package Logic;
/**
 * Class representing a comic Entry
 * @author Carlos, Alejandro, Samuel
 */
public class ComicEntry extends Entry {
    private String listID;
    private String comicID;
    private int numReadChapters;

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getComicID() {
        return comicID;
    }

    public void setComicID(String showID) {
        this.comicID = showID;
    }

    public int getNumReadChapters() {
        return numReadChapters;
    }

    public void setNumReadChapters(int numReadChapters) {
        this.numReadChapters = numReadChapters;
    }

    @Override
    public String toString() {
        return "ComicEntry{" + "listID=" + listID + ", comicID=" + comicID + "name=" + name + ", valoration=" + valoration + ", status=" + status + ", numReadChapters=" + numReadChapters + '}';
    }
    
    
}