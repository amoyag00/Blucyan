package Persistence;

public interface IConversor {

	/**
	 * 
	 * @param id
	 */
	Object get(String id);

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	void delete(String id, Class classType);

	/**
	 * 
	 * @param obj
	 */
	void put(Object obj);

	/**
	 * 
	 * @param id
	 */
	boolean exists(String id);

	/**
	 * 
	 * @param name
	 */
	List<Object> search(String name);

}