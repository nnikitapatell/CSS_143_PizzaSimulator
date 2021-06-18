/**
 * Goat class is a cheese
 * one of the final level of leaf subclasses that inherit from Cheese class
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class Goat that extends Cheese
public class Goat extends Cheese{
    //instance variables
	//Variable is a public, static, final, int that is set to 103
    public static final int calories = 103;
    //Variable is a public static final Money objec that is set to 4.30
    public static final Money cost = new Money(4,30);
    //variable is public static final String
    public static final String description = "goat cheese made from goat's milk";

    /**
     * Main method to tests the Mozzarella class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a Goat object
    	Goat p1 = new Goat();
    	//test the toString
    	System.out.println("Test toString: " + p1.toString());
    	//create a Goat object
    	Goat p2 = new Goat();
    	//test the toString
    	System.out.println("Test toString: " + p2.toString());
    	//test equals method
    	System.out.println(p1.equals(p2));
    }
    
    /**
     * Constructor for objects of class Goat
     * @param none
     * @return nothing
     */
    public Goat(){
    	//call the super class that has 3 parameters
        super(description, cost, calories);
    }
}

