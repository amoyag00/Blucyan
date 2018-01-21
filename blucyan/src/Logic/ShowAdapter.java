package Logic;

import Persistence.Facade;
import static java.lang.Integer.parseInt;

public class ShowAdapter extends ShowEntry implements IAdapter {
    
      @Override
    public Entry createEntry(String[] params, String listID){

       ShowEntry showEntry = new ShowEntry();

        showEntry.setListID(listID);
        showEntry.setShowID(params[0]);
        showEntry.setName(params[1]);
        showEntry.setValoration(parseInt(params[2]));
        showEntry.setNumWatchedEpisodes(parseInt(params[3]));
        showEntry.setStatus(params[4]);
        return showEntry;
    }
    
   
    public void  modEntry(Entry entry){
        ShowEntry showEntry =  (ShowEntry) entry;
        Facade.getInstance().modify(entry, ShowEntry.class);

    }

        
      
    
    
}