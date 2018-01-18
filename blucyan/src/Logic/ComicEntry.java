package Logic;

public class ComicEntry extends Entry {
    private String listID;
    private String comicID;
    private int valoration;
    private String status;
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

    public int getValoration() {
        return valoration;
    }

    public void setValoration(int valoration) {
        this.valoration = valoration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumReadChapters() {
        return numReadChapters;
    }

    public void setNumReadChapters(int numReadChapters) {
        this.numReadChapters = numReadChapters;
    }

    @Override
    public String toString() {
        return "ComicEntry{" + "listID=" + listID + ", comicID=" + comicID + ", valoration=" + valoration + ", status=" + status + ", numReadChapters=" + numReadChapters + '}';
    }
    
    
}