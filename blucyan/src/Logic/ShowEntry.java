package Logic;

public class ShowEntry extends Entry {
    private String listID;
    private String showID;
    private int numWatchedEpisodes;

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    @Override
    public String toString() {
        return "ShowEntry{" + "listID=" + listID + ", showID=" + showID + "name=" + name + ", valoration=" + valoration + ", status=" + status + ", numWatchedEpisodes=" + numWatchedEpisodes + '}';
    }

    public int getNumWatchedEpisodes() {
        return numWatchedEpisodes;
    }

    public void setNumWatchedEpisodes(int numWatchedEpisodes) {
        this.numWatchedEpisodes = numWatchedEpisodes;
    }
    
}