/**
 * Sausage class is extends the meat class
 * one of the final level of leaf subclasses that inherit from Meat class
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called Sausage that extends meat
public class Sausage extends Meat{
    // public, static, final instance variables 
	//calories set to 229
    public static final int calories = 229;
    //cost set to 1.10
    public static final Money cost = new Money (1,10);
    // public static final String descrpiton 
    public static final String description = "Sausage made from ground meat with seasonings";
    
    /**
     * Main method to tests the Sausage class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create a sausage object
    	Sausage p1 = new Sausage();
    	//ctest toString method
    	System.out.println(p1.toString());
    	//create  asausage object
    	Sausage p2 = new Sausage();
    	//test tostring
    	System.out.println(p1.toString());
    	//test equals method
    	System.out.println(p1.equals(p2));
    }
    
    /**
     * Constructor for objects of class Sausage
     * @param none
     */
    public Sausage(){
    	//call super that has 3 parameters
        super(description, cost, calories);
    }
}
