package Logic;
/**
 * 
 *  This class follows the Factory pattern and it is used for create the
 *  the necesary adapters.
 * @author Carlos, Alejandro, Samuel
 */
public class AdapterFactory {
    
    private ComicAdapter comicAdp;
    private ShowAdapter showAdp;
    private VideogameAdapter videogameAdp;

    /**
     * Returns the correct adapter for the parameter type
     * @param type
     * @return adapter which implements interface IAdapter
     */
    public IAdapter getAdapter(String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (type.compareToIgnoreCase("comic") == 0) {

            if (comicAdp == null) {
                String nombreClase = System.getProperty(ComicAdapter.class.getName());
                comicAdp =  new ComicAdapter();
            }

            return comicAdp;

        } else if (type.compareToIgnoreCase("show") == 0) {

            if (comicAdp == null) {
                String nombreClase = System.getProperty(ShowAdapter.class.getName());
                showAdp = new ShowAdapter();
            }

            return showAdp;

        } else if (type.compareToIgnoreCase("videogame") == 0) {

            if (comicAdp == null) {
                String nombreClase = System.getProperty(VideogameAdapter.class.getName());
                videogameAdp = new VideogameAdapter();
            }

            return videogameAdp;
        }
        return null;
    }
    /*
    * Returns an instance of this class according to the singleton pattern
    */
    public static AdapterFactory getInstance() {
        if (instance == null) {
            instance = new AdapterFactory();
        }
        return instance;
    }

    private static AdapterFactory instance;

}
