package Logic;

import java.util.List;

public class ElementList {
    private String listID;
    private String typeList;
    private String nickname;
    List<Entry> entryList;

    public String getListID() {
        return listID;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
}