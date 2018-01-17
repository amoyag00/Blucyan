package blucyan;

public class Facade {

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public Object get(String id, Class classType) {
		// TODO - implement Facade.get
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public void delete(String id, Class classType) {
		// TODO - implement Facade.delete
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param obj
	 * @param classType
	 */
	public void put(Object obj, Class classType) {
		// TODO - implement Facade.put
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public boolean exists(String id, Class classType) {
		// TODO - implement Facade.exists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param classType
	 */
	public List<Object> search(String name, Class classType) {
		// TODO - implement Facade.search
		throw new UnsupportedOperationException();
	}

	public void backup() {
		// TODO - implement Facade.backup
		throw new UnsupportedOperationException();
	}

	public static Facade getInstance() {
		return this.instance;
	}
	private static Facade instance;
	IConversor conversors;

}