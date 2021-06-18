
import java.awt.Color;
/**
 * Pepper is a Vegetable
 * one of the final level of leaf subclasses that inherit from Vegetable class
 *
 * @author Nikita Patel
 * @version 1
 */
//Create a class called pepper that extends Vegetable
public class Pepper extends Vegetable{
    // instance variables 
	//public static final int set to 26
    public static final int calories = 26;
    //public static final Money set to 1.00
    public static final Money cost = new Money(1,00);
    //public static final String 
    public static final String description = "peppers sliced vertically";

    /**
     * Main method to tests the Pepper class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a peper object
    	Pepper p1 = new Pepper();
    	//test toString
    	System.out.println(p1.toString());
    	//create a peper object
    	Pepper p2 = new Pepper();
    	//test toString
    	System.out.println(p1.toString());
    	//test equals method
    	System.out.println(p1.equals(p2));
    }
    
    /**
     * Pepper Constructor- calls the super class constructor that has 3 parameter
     *
     * @param color A parameter
     */
    public Pepper(Color color){  
    	//call super
        super(description, cost, calories, color);
    }
    /**
    * Constructor for objects of class Pepper with no arguments
    * @param none
    * @return nothing
    */
   public Pepper(){
   }
}