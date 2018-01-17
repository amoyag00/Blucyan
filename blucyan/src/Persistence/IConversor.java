package Persistence;

import java.util.List;

public interface IConversor {

	/**
	 * 
	 * @param id
	 */
	public Object get(String id);

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public void delete(String id, Class classType);

	/**
	 * 
	 * @param obj
	 */
	public void put(Object obj)throws Exception;

	/**
	 * 
	 * @param id
	 */
	public boolean exists(String id);

	/**
	 * 
	 * @param name
	 */
	public List<Object> search(String name);

}