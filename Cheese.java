

/**
 * Cheese is one of the four interior subclasses of the Ingredient hierarchy
 *
 * @author Nikita Patel
 * @version 1
 */
//create a Cheese class that extends Ingredient
public class Cheese extends Ingredient{
	/**
     * Main method to tests the Cheese class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a money object
    	Money m1 = new Money(3);
    	//create a string
    	String s1 = "cheese";
    	//create an int variable
    	int c1 = 450;		
    	//create a cheese object
    	Cheese p1 = new Cheese(s1, m1, c1);
    	//test ToString method
    	System.out.println("Test toString: " + p1.toString());
    	//create a cheese object
    	Cheese p2 = new Cheese(s1, m1, c1);
    	//test ToString method
    	System.out.println("Test toString: " + p2.toString());
    	//test equals method
    	System.out.println("Test equals: " + p1.equals(p2));
    }
	
    /**
     * Constructor for objects of class Cheese
     * this holds the cheeses goat and mozzarella
     *
     * @param description A parameter
     * @param cost A parameter
     * @param calories A parameter
     */
    public Cheese(String description, Money cost, int calories){
    	//call the super class that has 3 parameters
    	super(description, cost, calories);
    }
    
    /**
     * Default constructor for objects of class Cheese
     * 
     * @param none
     */
    public Cheese() {
    	
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
