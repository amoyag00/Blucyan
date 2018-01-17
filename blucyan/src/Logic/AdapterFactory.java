package Logic;

public class AdapterFactory {

	/**
	 * 
	 * @param type
	 */
	public IAdapater getAdapter(String type) {
		// TODO - implement AdapterFactory.getAdapter
		throw new UnsupportedOperationException();
	}

	public static AdapterFactory getInstance() {
		return this.instance;
	}

	private static AdapterFactory instance;

}