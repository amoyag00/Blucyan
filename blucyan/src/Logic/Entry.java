package Logic;
/**
 * Class representing an entry
 * @author Carlos, Alejandro, Samuel
 */
public class Entry {
    protected String entryID;
    protected int valoration;
    protected String name;
    protected String status;

    public String getEntryID() {
        return entryID;
    }

    public void setEntryID(String entryID) {
        this.entryID = entryID;
    }
    
    public int getValoration() {
        return valoration;
    }

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

}