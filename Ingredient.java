import java.awt.Color;
/**
 *  The Ingredient Hierarchy: This set of classes will be used to decorate Pizza Objects.  
 *  They’ll manage their cost and calorie count per serving, as well as define some custom 
 *  characteristics (read member variables) like Colors for the Vegetable subclass. 
 * 
 * The class Ingredient is a superclass which "implements comparable" based on cost
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called the Ingredient 
public class Ingredient implements Comparable{
    //Add private data items to track the Ingredient’s String description, cost, and calorie count
    private String description = "";
    private Money cost = null;
    private Color theColor = null;
    private int calories = 0;
    

    /**
	 * Main method to tests the Money class methods
	 * test the following methods:
	 *  compareTo, equals,  getCalories, getCost, 
	 * @param args
	 */
	public static void main(String[] args) {
		//create a money object
		Money m1 = new Money(3);
		String s1 = "ingredient";
		int c1 = 450;		
		//create an ingredient class
		Ingredient i1 = new Ingredient(s1, m1, c1);
		
		Money m2 = new Money(4);
		String s2 = "ice cream";
		int c2 = 450;
		Ingredient i2 = new Ingredient(s2, m2, c2);
		
		System.out.println("m1 equals m2: " + i1.equals(i2)); //test equals method
		
		System.out.println("compareTo: " + i1.compareTo(i1)); //test compareTo method
    	System.out.println("compareTo: " + i1.compareTo(i2)); //test compareTo method
    	System.out.println("compareTo: " + i2.compareTo(i1)); //test compareTo method
		
    	System.out.println("getCalories: " + i1.getCalories()); //test getCalories method
    	System.out.println("getCost: " + i1.getCost()); //test getCost method
	}
	
    /**
     * Default constructor for objects of class Ingredient
     * @param none
     */
    public Ingredient(){
        
    }
    
    /**
     * Ingredient Constructor that passes the description, cost and calories
     *
     * @param description A parameter
     * @param cost A parameter
     * @param calories A parameter
     */
    public Ingredient(String description, Money cost, int calories){
        //use the setters methods to set description, cost, calories
        setDescription(description);
        setCost(cost);
        setCalories(calories);
    }
    
    /**
     * Ingredient Constructor
     *
     * @param description A parameter
     * @param cost A parameter
     * @param calories A parameter
     * @param color A parameter
     */
    public Ingredient(String description, Money cost, int calories, Color color){
        //use the setters methods to set description, cost, calories, color
        setDescription(description);
        setCost(cost);
        setCalories(calories);
        setColor(color);
    }
    
    /**
     * Method getCost- getter method for cost
     * 
     * @param none
     * @return The return value
     */
    public Money getCost(){
        return this.cost;
    }

    /**
     * Method setCost- setter method for cost
     * 
     * @param obj A parameter
     * @return nothing
     */
    public void setCost(Money obj){
    	//check if the object is null or not an instance of Money
        if(obj == null || !(obj instanceof Money)){
        	//throw an exception
            throw new PizzaException("Exception in the setCost method: the object is null or not an instance of money");
        }
        //casting
        Money m = (Money) obj;
        //set the cost to the clone of m
        this.cost = m.clone();
    }

    /**
     * Method getCalories- getter method for calories
     * 
     * @param none
     * @return The return value
     */
    public int getCalories(){
    	int retVal = this.calories;
        return retVal;
    }

    /**
     * Method setCalories- setter method for calories. calories cannot be less than or equal to 0
     *
     * @return nothing
     * @param c A parameter
     */
    public void setCalories(int c){
    	//check if c is less than ot equal to 0
        if (c <= 0){
        	//throw an exception
            throw new PizzaException("exception in the setCalories method: the calories are less than or equal to 0");
        }
        //otherwise
        else{
        	//calories is set to c
            this.calories = c;
        }        
    }
    
    /**
     * Method setDescription- setter method for description
     * string cannot be null or the length of 0
     * 
     * @return nothing
     * @param s A parameter
     */
    public void setDescription(String s){
    	// check is s is null or the length of the string is 0
        if(s == null || s.length() == 0) {
        	//throw an exception
             throw new PizzaException("exception in the setDescription method: string is null or the length of string is 0");                                     
        }
        this.description = s;
    }
    
    /**
     * Method getDescription- getter method for description
     * 
     * @param none
     * @return The return value
     */
    public String getDescription(){
    	String retVal = this.description;
        return retVal;
    }
    
    /**
     * Method setColor- setter method for the colors red, black and green
     * 
     * @return nothing
     * @param that A parameter
     */
    public void setColor(Color that){
    	//set this to that
        this.theColor = that;
        if(this.theColor.getRed() == 255 && this.theColor.getGreen() == 0 && this.theColor.getBlue() == 0){
            this.theColor = Color.red;
        }
        if(this.theColor.getRed() == 0 && this.theColor.getGreen() == 0 && this.theColor.getBlue() == 255){
            this.theColor = Color.black;
        }
        if(this.theColor.getRed() == 0 && this.theColor.getGreen() == 255 && this.theColor.getBlue() == 0){
            this.theColor = Color.green;
        }
    }
    
    /**
     * Method compareTo- compare to method that compares the given ingredient 
     * to this one based on price
     * returning if the price of this ingredient is greater
     * if it is equal 
     * and if it is less
     *
     * @param obj A parameter
     * @return The return value
     */
    public int compareTo(Object obj){
    	//check if the object is null or not an instance of the class ingrident 
        if(obj == null || !(obj instanceof Ingredient)) {
        	//throw an exception 
            throw new PizzaException("Exception in the compareTo method the object is null or is not an instance of Ingredient");
        }          
        int retVal = this.cost.compareTo(((Ingredient) obj).cost);
        return retVal;
    }
        
    /**
     * Method equals- compares to the given ingredient to this one for
     * strict equality, meanign that their cost, calorie count and the descriptions 
     * have to be the same for it to return true 
     *
     * @param obj A parameter
     * @return The return boolean value
     */
    public boolean equals(Object obj){
        //check if o is null or if o is 
        if (obj == null || !(obj instanceof Ingredient)) {
        	//throw an exception
             throw new PizzaException("Exception in the equals method the object is null or is not an instance of Ingredient");
        }
        //create object that
        Ingredient that = (Ingredient) obj;
        
        boolean retVal = this.cost.equals(that.cost) &&
                this.calories == that.calories &&
                this.description.equals(that.description);
        return retVal;
    }

	/**
	 * Method getColor- is a getter method for the colorName 
	 * @param nothing
	 * @return the colorName
	 */
	public Color getColor() {
		Color retVal = theColor;
		return retVal;
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
