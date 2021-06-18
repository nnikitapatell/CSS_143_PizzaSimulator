
/**
 * Base class is one of the four interior subclasses of the Ingredient hierarchy
 * this holds the sauces marinara and alfredo
 *
 * @author Nikita Patel
 * @version 1
 */
//create a Base class that extends Ingredient 
public class Base extends Ingredient{
	/**
     * Main method to tests the Base class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a money object
    	Money m1 = new Money(3);
    	//create a string
    	String s1 = "sauce";
    	//create an int
    	int c1 = 450;		
    	//create a Base object
    	Base p1 = new Base(s1, m1, c1);
    	//test toString
    	System.out.println("Test toString: " + p1.toString());
    	//create a base object
    	Base p2 = new Base(s1, m1, c1);
    	//test toString
    	System.out.println("Test toString: " + p2.toString());
    	//test equals method
    	System.out.println("Test equals: " + p1.equals(p2));
    }
	
    /**
     * Constructor for objects of class Base
     * calls super constructor that has 3 parameters
     * 
     * @param none
     */
    public Base(String description, Money cost, int calories){
    	//calls super constructor that has 3 parameters
        super(description, cost, calories);
    }
    /**
     * Default constructor for objects of class Base
     * 
     * @param none
     */
    public Base() {
    	
    }
    
    /**
     * toString method to test the the leaf classes
     * @return String
     * @param none
     */
    public String toString() {
		String retVal = "Description: " + getDescription()+ " Cost: " + getCost() + " Calories: " +  getCalories() ;
		return retVal;
	}
}

