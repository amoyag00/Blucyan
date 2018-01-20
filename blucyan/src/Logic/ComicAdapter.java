package Logic;

import Persistence.Facade;
import static java.lang.Integer.parseInt;

public class ComicAdapter extends ComicEntry implements IAdapter   {
    
    @Override
    public Entry createEntry(String[] params){

        ComicEntry comicEntry = new ComicEntry();

        comicEntry.setListID(params[0]);
        comicEntry.setComicID(params[1]);
        comicEntry.setName(params[2]);
        comicEntry.setValoration(parseInt(params[3]));
        comicEntry.setNumReadChapters(parseInt(params[4]));
        comicEntry.setStatus(params[5]);


        return comicEntry;
    }
    
    public void  modEntry(Entry entry){
        ComicEntry showEntry =  (ComicEntry) entry;
        Facade.getInstance().modify(entry, ComicEntry.class);

    }

    
    

}
