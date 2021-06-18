
/**
 * Mozzarella class is a Cheese
 * one of the final level of leaf subclasses that inherit from Cheese class
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called Mozzarella that extends Cheese
public class Mozzarella extends Cheese{
    //instance variables 
	//public static final int variable ste to 78
    public static final int calories = 78;
    //public static final Money set to 1.10
    public static final Money cost = new Money (1, 10);
    //public static final String 
    public static final String description = "mozzarella made from buffalo's milk";

    /**
     * Main method to tests the Mozzarella class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create  mozzarella object
    	Mozzarella p1 = new Mozzarella();
    	///test toString method
    	System.out.println(p1.toString());
    	//create  a mozzarela object
    	Mozzarella p2 = new Mozzarella();
    	//test tostring method again
    	System.out.println(p2.toString());
    	//equals method beig tested
    	System.out.println(p1.equals(p2));
    }
    
    /**
     * Constructor for objects of class Mozzarella 
     * that calls a super class method with 3 parameters
     * @param none
     */
    public Mozzarella() {
    	//call the super class that has 3 parameters
        super(description, cost, calories);
    }
}
