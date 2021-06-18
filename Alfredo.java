
/**
 * The class Alfredo is a base 
 * one of the final level of leaf subclasses that inherit from Base class
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called Alfredo that extends Base
public class Alfredo extends Base{
    //instance variables
	//Variable is a public, static, final, int that is set to 535 
    public static final int calories = 535;
    //Variable is a public static final Money objec that is set to .75
    public static final Money cost = new Money(0,99);
    //variable is public static final String
    public static final String description = "alfredo made from milk, butter and Parmesan cheese";
	
    /**
     * Main method to tests the Alfredo class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a Alfredo object 
    	Alfredo p1 = new Alfredo();
    	//test the toString
    	System.out.println("Test toString: " + p1.toString());
    	//create a Alfredo object 
    	Alfredo p2 = new Alfredo();
    	//test the toString
    	System.out.println("Test toString: " + p2.toString());
    	//test the equals
    	System.out.println("Test equals: " + p1.equals(p2));
    }
    
    /**
     * Constructor for objects of class Alfredo
     * calls the super constructor
     * @param none
     */
    public Alfredo() {
        //call super constructor that has 3 parameters
    	super(description, cost, calories);
    }
}