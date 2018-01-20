package Logic;

import Persistence.Facade;
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
    
   
    public void  modEntry(Entry entry){
        ShowEntry showEntry =  (ShowEntry) entry;
        Facade.getInstance().modify(entry, ShowEntry.class);

    }

        
      
    
    
}