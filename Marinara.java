/**
 * The marinara class is a base 
 * one of the final level of leaf subclasses that inherit from Base class
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called Marinara that extends Marinara
public class Marinara extends Base{
    // instance variables - replace the example below with your own
	//variable is public static final int set to 65
    public static final int calories = 65;
    //variable is public static final Money set to .50
    public static final Money cost = new Money(0,50);
    //variable is public static final String
    public static final String description = "marinara made with basil and tomatoes";

    /**
     * Main method to tests the Alfredo class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a Marinara object 
    	Marinara p1 = new Marinara();
    	//test the toString
    	System.out.println("Test toString: " + p1.toString());
    	//create a Marinara object 
    	Marinara p2 = new Marinara();
    	//test the toString
    	System.out.println("Test toString: " + p2.toString());
    	//test the equals
    	System.out.println("Test equals: " + p1.equals(p2));
    }
    
    /**
     * Constructor for objects of class Marinara
     * @param none
     */
    public Marinara() {
    	//call super constructor that has 3 parameters
        super(description, cost, calories);
    }
}
