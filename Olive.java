
import java.awt.*;
/**
 * Olive class is a Vegetable
 * one of the final level of leaf subclasses that inherit from Vegetable class
 * @author Nikita Patel
 * @version 1
 */
//Create a class called Olive that extends Vegetable
public class Olive extends Vegetable {
    //instance variables
	//public static final int is set to 75
    public static final int calories = 75;
    //public static final Money set to .75
    public static final Money cost = new Money(0,75);
    //public static final String 
    public static final String description = "olives circularly sliced";
    
    /**
     * Main method to tests the Olive class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a Olive object
    	Olive p1 = new Olive();
    	//test tostring mehtod
    	System.out.println(p1.toString());
    	//create a olive obejct
    	Olive p2 = new Olive();
    	//test toString method
    	System.out.println(p2.toString());
    	//test equals method
    	System.out.println(p1.equals(p2));
    }
    
    /**
     * Constructor for objects of class Olive -  calls the super class constructor that has 3 parameter
     * @param Color
     */
    public Olive(Color color){
    	//call super constructor
        super(description, cost, calories, color);
    }
    
    /**
    * Constructor for objects of class Olive with no arguments
    * @param none
    * @return nothing
    */
   public Olive(){
	   //call super constructor
	   super();
   }
}