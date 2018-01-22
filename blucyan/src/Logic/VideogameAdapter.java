package Logic;

import Persistence.Facade;
import static java.lang.Integer.parseInt;

public class VideogameAdapter extends VideogameEntry implements IAdapter {
    
    @Override
    public Entry createEntry(String[] params, String listID){

       VideogameEntry videogameEntry = new VideogameEntry();

        videogameEntry.setListID(listID);
        videogameEntry.setVideogameID(params[0]);
        videogameEntry.setName(params[1]);
        videogameEntry.setValoration(parseInt(params[2]));
        videogameEntry.setStatus(params[3]);
        return videogameEntry;
    }
    
    @Override
    public void modEntry(Entry entry){

        VideogameEntry videogameEntry =  (VideogameEntry) entry;
        Facade.getInstance().modify(entry, VideogameEntry.class);
        
       }
    
}