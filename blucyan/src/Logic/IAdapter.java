package Logic;
        /**
         * 
         * @author Alejandro, Carlos, Samuel
         */
public interface IAdapter {

	/**
	 * Creates an entry with the features specified in params in the list
         * listID
	 * @param params
	 */
	public Entry createEntry(String[] params, String listID);

	/**
         * Modifies the entry entry
         * @param entry 
         */
	public void modEntry(Entry entry);

}