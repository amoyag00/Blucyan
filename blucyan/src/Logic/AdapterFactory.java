package Logic;

public class AdapterFactory {

    private ComicAdapter comicAdp;
    private ShowAdapter showAdp;
    private VideogameAdapter videogameAdp;

    /**
     *
     * @param type
     */
    public IAdapter getAdapter(String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (type.compareToIgnoreCase("comic") == 0) {

            if (comicAdp == null) {
                String nombreClase = System.getProperty(ComicAdapter.class.getName());
                comicAdp =  (ComicAdapter) Class.forName(nombreClase).newInstance();
            }

            return comicAdp;

        } else if (type.compareToIgnoreCase("show") == 0) {

            if (comicAdp == null) {
                String nombreClase = System.getProperty(ShowAdapter.class.getName());
                showAdp = (ShowAdapter) Class.forName(nombreClase).newInstance();
            }

            return showAdp;

        } else if (type.compareToIgnoreCase("videogame") == 0) {

            if (comicAdp == null) {
                String nombreClase = System.getProperty(VideogameAdapter.class.getName());
                videogameAdp = (VideogameAdapter) Class.forName(nombreClase).newInstance();
            }

            return videogameAdp;
        }
        return null;
    }

    public static AdapterFactory getInstance() {
        if (instance == null) {
            instance = new AdapterFactory();
        }
        return instance;
    }

    private static AdapterFactory instance;

}
