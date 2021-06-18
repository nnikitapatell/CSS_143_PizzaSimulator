/**
 * Meat class is one of the four interior subclasses of the Ingredient hierarchy
 *
 * @author Nikita Patel
 * @version 1
 */
//create a Meat class that extends Ingredient
public class Meat extends Ingredient{
	
    /**
     * Constructor for objects of class Meat
     * this holds the meat like sausage and pepperoni
     * 
     * @param description A parameter
     * @param cost A parameter
     * @param calories A parameter
     */
	
	/**
     * Main method to tests the Meat class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a money object
    	Money m1 = new Money(3);
    	//create a strign variable 
    	String s1 = "meat";
    	//int varibale 
    	int c1 = 450;	
    	//create a meat object
    	Meat p1 = new Meat(s1, m1, c1);
    	//test toString
    	System.out.println("Test toString: " + p1.toString());
    	//create a meat object
    	Meat p2 = new Meat(s1, m1, c1);
    	//toString method tested
    	System.out.println("Test toString: " + p1.toString());
    	//equals method tested
    	System.out.println("Test equals: " + p1.equals(p2));
    }
    
    public Meat(String description, Money cost, int calories) {
    	//call the super class that has 3 parameters
    	super(description, cost, calories);
    }
    
    /**
     * Constructor for objects of class Meat with no arguments
     * @param none
     * @return nothing
     */
    public Meat(){
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
