package Logic;

public class AdapterFactory {

	/**
	 * 
	 * @param type
	 */
	public IAdapter getAdapter(String type) {
		// TODO - implement AdapterFactory.getAdapter
		throw new UnsupportedOperationException();
	}

	public static AdapterFactory getInstance() {
		 if(instance==null){
                instance= new AdapterFactory();
            }
		return instance;
	}

	private static AdapterFactory instance;

}