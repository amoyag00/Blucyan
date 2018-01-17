package Logic;

public interface IAdapter {

	/**
	 * 
	 * @param params
	 */
	Entry createEntry(String[] params);

	/**
	 * 
	 * @param entry
	 * @param attribute
	 * @param newValue
	 */
	Entry modEntry(Entry entry, String attribute, String newValue);

}