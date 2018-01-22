package Logic;

import Persistence.Facade;
import static java.lang.Integer.parseInt;
/**
 * Class implementing the adapter pattern used for create and modify entries of
 * type comic
 * @author Carlos, Alejandro, Samuel
 */
public class ComicAdapter extends ComicEntry implements IAdapter   {
    /**
     * Creates an entry with params included in params and belonging to 
     * a list with ID = listID
     * @param params
     * @param listID
     * @return the entry created 
     */
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
    /**
     * Modifies the entry received by parameter. Facade class is called to 
     * update the changes in the database
     * @param params
     * @param listID
     * @return void
     */
    public void  modEntry(Entry entry){
        ComicEntry showEntry =  (ComicEntry) entry;
        Facade.getInstance().modify(entry, ComicEntry.class);

    }

    
    

}
