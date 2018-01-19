package Logic;

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
    
    @Override
    public Entry modEntry(Entry entry, String attribute, String newValue){

        ComicEntry comicEntry = (ComicEntry) entry;
        
        switch(attribute){
        
            case "status": comicEntry.setStatus(newValue);
                            break;
            case "numReadChapters": comicEntry.setNumReadChapters(parseInt(newValue));
                            break;
            case "valoration": comicEntry.setValoration(parseInt(newValue));
                            break;

        }
       
        return comicEntry;
    }

    
    

}
