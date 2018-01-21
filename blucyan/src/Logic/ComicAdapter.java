package Logic;

import Persistence.Facade;
import static java.lang.Integer.parseInt;

public class ComicAdapter extends ComicEntry implements IAdapter   {
    
    @Override
    public Entry createEntry(String[] params, String listID){

        ComicEntry comicEntry = new ComicEntry();

        comicEntry.setListID(listID);
        comicEntry.setComicID(params[0]);
        comicEntry.setName(params[1]);
        comicEntry.setValoration(parseInt(params[2]));
        comicEntry.setNumReadChapters(parseInt(params[3]));
        comicEntry.setStatus(params[4]);


        return comicEntry;
    }
    
    public void  modEntry(Entry entry){
        ComicEntry showEntry =  (ComicEntry) entry;
        Facade.getInstance().modify(entry, ComicEntry.class);

    }

    
    

}
