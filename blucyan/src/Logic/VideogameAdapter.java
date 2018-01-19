package Logic;

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
    public Entry modEntry(Entry entry, String attribute, String newValue){

        VideogameEntry videogameEntry =  (VideogameEntry) entry;
        
        switch(attribute){
        
            case "status": videogameEntry.setStatus(newValue);
                            break;
            case "valoration": videogameEntry.setValoration(parseInt(newValue));
                            break;

        }
        
        return videogameEntry;
    }
    
}