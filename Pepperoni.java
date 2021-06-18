
/**
 * Pepperoni class is a meat
 * one of the final level of leaf subclasses that inherit from Meat class
 *
 * @author Nikita Patel
 * @version 1
 */

//create a class called pepperoni that extends meat
public class Pepperoni extends Meat{
    // instance variables 
	// public static final int variable set to 150
    public static final int calories = 150;
    // public static final Money object set to 1.00
    public static final Money cost = new Money(1,00);
    //public static final string variable
    public static final String description = "pepperoni made from cured pork and beef";

    /**
     * Main method to tests the Pepperoni class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a peperoni object
    	Pepperoni p1 = new Pepperoni();
    	//test toString method
    	System.out.println(p1.toString());
    	//create  apeperoni object
    	Pepperoni p2 = new Pepperoni();
    	//test toSrtring method
    	System.out.println(p1.toString());
    	//test equals method
    	System.out.println(p1.equals(p2));
    }
    
    /**
     * Constructor for objects of class Pepperoni
     */
    public Pepperoni() {
    	//call the super class that has 3 parameters
        super(description, cost, calories);
    }
}
