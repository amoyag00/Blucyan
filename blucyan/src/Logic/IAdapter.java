package Logic;

public interface IAdapter {

	/**
	 * 
	 * @param params
	 */
	public Entry createEntry(String[] params);

	/**
	 * 
	 * @param entry
	 * @param attribute
	 * @param newValue
	 */
	public void modEntry(Entry entry);

}