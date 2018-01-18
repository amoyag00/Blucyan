package Persistence;

import java.util.List;

public interface IConversor<T,D> {

	/**
	 * 
	 * @param id
	 */
	public T get(String id)throws Exception;

	/**
	 * 
	 * @param id
	 * @param classType
	 */
	public void delete(String id)throws Exception;

	/**
	 * 
	 * @param obj
	 */
	public void put(T obj)throws Exception;

        /**
	 * 
	 * @param name
	 */
	//public void modify(T element)throws Exception;
        
	/**
	 * 
	 * @param id
	 */
	public boolean exists(String id)throws Exception;

	/**
	 * 
	 * @param name
	 */
	public List<D> search(String name)throws Exception;

}