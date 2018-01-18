package Logic;

public class ShowEntry extends Entry {
    private String listID;
    private String showID;
    private int valoration;
    private String status;
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
        return "ShowEntry{" + "listID=" + listID + ", showID=" + showID + ", valoration=" + valoration + ", status=" + status + ", numWatchedEpisodes=" + numWatchedEpisodes + '}';
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

    public int getNumWatchedEpisodes() {
        return numWatchedEpisodes;
    }

    public void setNumWatchedEpisodes(int numWatchedEpisodes) {
        this.numWatchedEpisodes = numWatchedEpisodes;
    }
    
}