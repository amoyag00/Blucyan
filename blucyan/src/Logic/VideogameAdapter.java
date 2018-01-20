package Logic;

import Persistence.Facade;
import static java.lang.Integer.parseInt;

public class VideogameAdapter extends VideogameEntry implements IAdapter {
    
    @Override
    public Entry createEntry(String[] params){

        VideogameEntry videogameEntry = new VideogameEntry();
        
        videogameEntry.setVideogameID(params[0]);
        videogameEntry.setValoration(parseInt(params[1]));
        videogameEntry.setStatus(params[2]);
        videogameEntry.setName(params[3]);
        videogameEntry.setListID(params[4]);

        return videogameEntry;
    }
    
    @Override
    public void modEntry(Entry entry){

        VideogameEntry videogameEntry =  (VideogameEntry) entry;
        Facade.getInstance().modify(entry, VideogameEntry.class);
        
       }
    
}