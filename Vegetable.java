import java.awt.*;
/**
 * Vegetable class is a Ingredient
 * use Java’s Color24 class (called java.awt.Color) for use in tracking Vegetable colors. 
 * 
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class Vegetable that extends Ingredient 
public class Vegetable extends Ingredient{
	//A variable to manage the Vegetable’s Color (this is not a String we must use the Color class)
    private Color myColor;
    
    /**
     * Main method to tests the Vegetable class methods
     * @param args A parameter
     */
    public static void main(String[] args){
    	Money m1 = new Money(50);
    	Color c1 = Color.green;
    	Vegetable v1 = new Vegetable("okra", m1,100, c1);
    	System.out.println("v1: " + v1.toString());
    	Vegetable v2 = new Vegetable("okra", m1,100, c1);
    	System.out.println("v1: " + v2.toString());
    	System.out.println("equals: " + v1.equals(v2));
    	Color c2 = Color.black;
    	v1.setColor(c2);
    	System.out.println("v1 set color and equals methods: " + v1.equals(v2));
    }
    
    /**
     * Constructor for objects of class Vegetable
     * 
     * @param description
     * @param cost
     * @param calories
     * @param color
     */
    public Vegetable(String description, Money cost, int calories, Color color){
        //call super constructor with 3 parameters
    	super(description, cost, calories, color);
    }
    
    /**
     * Constructor for objects of class Vegetable with no arguments
     * @param none
     * @return nothing
     */
    public Vegetable() {
		
	}

	/**
     * getColor method that is a getter method for the color
     * @param none
     * @return Color value
     */
    public Color getColor() {
        return myColor;
    }

    /**
     * Method setColor that is a setter for color
     * @param o
     * @return nothing
     */
    public void setColor(Object o){
        //check if the object is null of not an instance of Color
        if(o == null || !(o instanceof Color)){
            throw new PizzaException("Exception in th setColor method: the object is null or not an instance of color");
        }
        Color that = (Color) o;
        myColor = that;
    }

  
    /**
     *equals method that return true if the vegetable colors are the same
     *@param o
     *@return value that is of the type boolean
     */
    @Override
    public boolean equals(Object o) {
    	//check if it is null or object o is an instance of Vegetable
        if(o == null || !(o instanceof Vegetable)){
            throw new PizzaException("Exception in th equals method: the object is null or not an instance of vegetable");
        }
        
        Vegetable that = (Vegetable) o;
        if(this.myColor == that.myColor){
            return true;
        }
        else{
            return false;
        }
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
