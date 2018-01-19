package Logic;

import static java.lang.Integer.parseInt;

public class ShowAdapter extends ShowEntry implements IAdapter {
    
      @Override
    public Entry createEntry(String[] params){

        ShowEntry showEntry = new ShowEntry();
        
        showEntry.setShowID(params[0]);
        showEntry.setValoration(parseInt(params[1]));
        showEntry.setNumWatchedEpisodes(parseInt(params[2]));
        showEntry.setStatus(params[3]);
        showEntry.setName(params[4]);
        showEntry.setListID(params[5]);

        return showEntry;
    }
    
    @Override
    public Entry modEntry(Entry entry, String attribute, String newValue){

        ShowEntry showEntry =  (ShowEntry) entry;
        
        switch(attribute){
        
            case "status": showEntry.setStatus(newValue);
                            break;
            case "numWatchedEpisodes": showEntry.setNumWatchedEpisodes(parseInt(newValue));
                            break;
            case "valoration": showEntry.setValoration(parseInt(newValue));
                            break;

        }

        
        return showEntry;
    }
    
}