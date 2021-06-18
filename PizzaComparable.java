
/**
 * This interface implements more than the Comparable Interface.  
 * No additions or changes made to this class.
 * interface inherit
 *
 * @author Nikita Patel
 * @version 1
 * 
 */
//interface called pizzaCOmparable that extends Comparable
public interface PizzaComparable extends Comparable { 
	/**
	 *compareTo method- compares by comparing the two integer objects
	 *@param Object
	 *@return int value
	 */
	@Override
	public int compareTo(Object o);          //a.k.a compareToByPrice//non-overrides
	/**
	 * compareToBySize mehtod- compares size by comparing the two integer objects
	 * @param Object
	 * @return int
	 */
	public int compareToBySize(Object o);    //a.k.a. compareToByAreaLeft
	/**
	 * compareToByCalories method- compares calories by comparing the two integer objects 
	 * @param object
	 * @return int
	 */
	public int compareToByCalories(Object o);
}
