  
import java.awt.Color;
/**
 * Pizza
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called pizza that implements PizzaComparable
public class Pizza implements PizzaComparable{
    //private money object called price 
    private Money price = new Money(0,0);
    //private Fraction object called fractionSize
    private Fraction fractionSize = new Fraction();
    //Private shape object called myShape
    private Shape myShape;
    //private int calories set to 0
    private int calories = 0;
    //ArrayList of the type ingredients
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    
    /**
	 * Main method to test the Pizza class methods
	 * getCalories, toString, compareToByCalories, eatSomePizza
	 * compareTo, compareToBySize, getCost, getShape, 
	 *   
	 * @param args
	 */
	public static void main(String[] args) {
		//create a pizza object
		Pizza p1 = new Pizza();
		System.out.println("p1: " + p1.toString()); //test toString method
		System.out.println("p1 getCalories: " + p1.getCalories()); //test getCalories method
		System.out.println("p1 getRemainingArea: " + p1.getRemainingArea()); //test getRemainingArea method
		System.out.println("p1 getCost: " + p1.getCost()); //test getCost method
		System.out.println("p1 getShape: " + p1.getShape()); //test getShape method
		
		Pizza p2 = new Pizza();
		System.out.println("p2: " + p2.toString());
		Fraction f1 = new Fraction (1,2);
		p2.eatSomePizza(f1); //test eatSomePizza method
		System.out.println("p2.eatSomePizza(1,2): " + p2.toString());
		
		System.out.println("compareToByCalories: " + p1.compareToByCalories(p2)); //test compareToByCalories method
		System.out.println("compareToByCalories: " + p2.compareToByCalories(p1));
		System.out.println("compareToByCalories: " + p2.compareToByCalories(p2));
		
		System.out.println("compareTo: " + p1.compareTo(p2)); //test compareTo method
		System.out.println("compareTo: " + p2.compareTo(p1));
		System.out.println("compareTo: " + p2.compareTo(p2));
		
		System.out.println("compareToBySize: " + p1.compareToBySize(p2)); //test compareToBySize method
		System.out.println("compareToBySize: "  + p2.compareToBySize(p1));
		System.out.println("compareToBySize: " + p2.compareToBySize(p2));
	}
    
    /**
     * Pizza Constructor- that uses the Math.random to randomly choose the base, cheese, shap, meat 
     * and vegetable
     *
     */
    public Pizza() {
    	//double reandomNumber variable
    	double randomNumber = 0.0;
    	randomNumber = Math.random();
    	//randomly chooses a circle or square

    	//generate a number greater than .5 
    	if(randomNumber > 0.5){
            Circle c = new Circle();
            this.myShape = c;
        }
        else{
            Square s = new Square();
            this.myShape = s;
        }
        
        //generate a number greater than .5 Randomly chooses between marinara base or alfredo base
        if(randomNumber > 0.5){
        	this.ingredients.add(new Marinara());
        }
        else{
        	this.ingredients.add(new Alfredo());
        }
        
        //generate a number greater than .5 randomly choose a between goat chesse and mozzarella cheese 
        if(randomNumber > 0.5){
        	this.ingredients.add(new Goat());
        }
        else{
        	this.ingredients.add(new Mozzarella());
        }
        
        //randomly chooses between whether the pizz will have no meat, sausage or pepperoni       
        //generate a number greater than .33 
        if(randomNumber < 0.33){
        	this.ingredients.add(new Sausage());
        }
        //generate a number greater than .33  and less than .66
        else if(randomNumber > 0.33 && randomNumber < 0.66){
        	this.ingredients.add(new Pepperoni());
        }
  
        //chooses  between green or red pepper
        //generate a number greater than .33 
        if(randomNumber < 0.33){
        	//generate a number greater than .5
        	if(Math.random() > 0.5){
        		this.ingredients.add(new Pepper(Color.GREEN));
            }
            else{
            	this.ingredients.add(new Pepper(Color.RED));
            }
        }
        //chooses between green or black olives
      //generate a number greater than .33  and less than .66
        else if(randomNumber > 0.33 && randomNumber < 0.66){
            if(randomNumber > 0.5){
            	this.ingredients.add(new Olive(Color.GREEN));
            }
            else{
            	this.ingredients.add(new Olive(Color.BLACK));
            }
        }
        //set all int values to 0
        int currentCents = 0;
        int currentDollars = 0;
        int ingredientCents = 0;
        int ingredientDollars = 0;
        
        //Iterates through each of the ingredients in the arrayList
        for(int i=0; i < this.ingredients.size(); i++){
        	//gets the calories of the ingredient
        	this.calories += this.ingredients.get(i).getCalories();
            //get the cents
            currentCents = this.price.getCents();
            //get he dollars
            currentDollars = this.price.getDollars();
            ingredientCents = this.ingredients.get(i).getCost().getCents();
            ingredientDollars = this.ingredients.get(i).getCost().getDollars();            
            //set the price of pizza
            this.price.setDollars(currentDollars+ingredientDollars);
            this.price.setCents(currentCents+ingredientCents);
        }    
    }
    
    /**
     * Method getFraction- getter method for the amount of pizza that is remaining 
     *
     * @return The return value
     */
    public Fraction getFraction(){
        //return the size
        return this.fractionSize;
    }
    
    /**
     * Method setFraction- setter method for the amount of pizza that is remaining
     *
     * @param num A parameter
     * @param denom A parameter
     */
    public void setFraction(int num, int denom){
        this.fractionSize.setNumerator(num);
        this.fractionSize.setDenominator(denom);
    }
    
    /**
     * Method getRemainingArea- calculates the remaining Area
     *
     * @return The return value
     */
    public double getRemainingArea(){
        //get the numerator and cast it to a double
        double numAvail = (double) this.fractionSize.getNumerator();
        //get the denominator and cast to a double
        double denomAvail = (double) this.fractionSize.getDenominator();
        //Divide numerator and denominator as doubles
        double amountRemaining = numAvail/denomAvail;
        //calculate the area of the remaining part of the pizza
        return myShape.getArea() * amountRemaining;
    }
   
    /**
     * Method getCost- calculates the cost of the remaining amount of pizza
     *
     * @return The return value
     */
    public Money getCost(){
        //get the numerator
        double numAvail = (double) this.fractionSize.getNumerator();
        //get the denominator
        double denomAvail = (double) this.fractionSize.getDenominator();
        //Divide numerator and denominator
        double amountRemaining = numAvail/denomAvail;
              
        //get the cost of whole pizza 
        double costOfWholePizza = Double.parseDouble(price.getDollars() + "." + price.getCents());
        
        //calculate the cost of the fraction of pizza remaining
        double newCost = costOfWholePizza * amountRemaining;
        
        //Differentiate the newCost into dollars and cents strings
        String[] newAmount = String.valueOf(newCost).split("\\.");
        String newDollars = newAmount[0];
        String newCents = newAmount[1] + "0000";
        newCents = newCents.substring(0, 2);
        
        //Return new Money
        return new Money(Integer.parseInt(newDollars), Integer.parseInt(newCents));
    }
    
    /**
     * Method eatSomePizza- reduce the fraction of the amount of pizza that is remaining 
     * one parameter
     * @param o A parameter
     */
    public void eatSomePizza(Object o){
        //Check if the object is null or not an instance of fraction
        if(o == null || !(o instanceof Fraction)){
        	//throw an exception 
            throw new PizzaException("Fraction is null or not an instance of Fraction");
        }
        
        //casting input object
        Fraction amount = (Fraction) o;

        //Subtract the amount coming in from the fractionSize
        this.fractionSize.subtract(amount);
        
        //the method getNumerator get the numerator of the fractionSize 
        //to check and see if the user has input a greater amount than available
        if(this.fractionSize.getNumerator() < 0){
        	//throw an exception 
            throw new PizzaException("The input is a greater amount than what is available");
        }
        //If passed amount is the same as the current Fraction amount, then someone buys the remaining pizza
        //Throwing exception that the calling function catches
        else if(this.fractionSize.getNumerator() == 0){
        	this.price = new Money(0,0);
        	//set the area to 0
            this.myShape.setArea(0);
            //throw an exception
            throw new PizzaException("Numerator of the fraction is 0. So it will be removed from the list");
        }
    }
    
    /**
     * Method setShape- set the clone Shape to myShape
     * one parameter
     * @param s A parameter
     */
    public void setShape(Shape s) {
        //cast shape and set that clone to the myshape
        this.myShape = (Shape) s.clone();
    }
    
    /**
     * Method getShape- get the shape by calling the clone method
     *
     * @return The return value
     */
    public Shape getShape() {
    	Shape retVal = (Shape) this.myShape.clone();
        //return the clone shape
        return retVal;
    }
    
    
    /**
     * Method getCalories- getter method for calories
     *
     * @return The return value
     */
    public int getCalories(){
    	int retVal = this.calories;
        //return calories
        return retVal;
    }

    /**
     * Method compareTo- pizzas get compared by price
     * object parameter input
     * override the method from the implemented PizzaComparable class
     * @param o A parameter
     * @return The return value
     */
    @Override
    public int compareTo(Object o) {
        //Check if the object is null or not an instance of pizza
        if(o == null || !(o instanceof Pizza)){
            throw new PizzaException("the object is null or not an instance of pizza");
        }
        //cast Pizza to object
        Pizza that = (Pizza) o;
        //compare the costs
        return this.getCost().compareTo(that.getCost());
    }

    /**
     * Method compareToBySize- pizzas get compared by size
     * object parameter input
     * override the method from the implemented PizzaComparable class
     *
     * @param o A parameter
     * @return The return value
     */
    @Override
    public int compareToBySize(Object o) {
        //Check if the object is null or not an instance of pizza
        if(o == null || !(o instanceof Pizza)){
            throw new PizzaException("the object is null or not an instance of pizza");
        }
        //casting Pizza to object
        Pizza that = (Pizza) o;
        //check if this area is larger than that area
        if(this.getRemainingArea() > that.getRemainingArea()) {
            return 1;
        } else if(this.getRemainingArea() == that.getRemainingArea()) {
            return 0;
        } else {
            return -1;
        }
    }
    
    /**
     * Method compareToByCalories- pizza get compared by calories
     * override the method from the implemented PizzaComparable class
     * object parameter input
     *
     * @param o A parameter
     * @return The return value
     */
    @Override
    public int compareToByCalories(Object o) {
        //Check if the object is null or not an instance of pizza
        if(o == null || !(o instanceof Pizza)){
            throw new PizzaException("Exception in the compareToByCalories method: o is null or not an instance of Pizza class");
        }
        //casting Pizza
        Pizza that = (Pizza) o;
        //check if this calorie is larger than that calorie
        if(this.calories > that.calories) {
            return 1;
        } else if(this.calories == that.calories) {
            return 0;
        } else {
            return -1;
        }

    }
    /**
     * Method toString- overrides and formats the output of the details of a pizza
     * including the shape of pizza, cost of pizza,fraction remaining of the pizza, the calories
     * and the toppings of the pizz
     *
     * @return The return value
     */
    @Override
    public String toString(){
        String pizzaToppings = "";
        double area = 0.0;
        
        //Iterate through the for loop to get all the pizza toppings
        for(int i = 0; i < this.ingredients.size(); i++){
        	//check if i is 0
            if(i == 0){
                pizzaToppings = this.ingredients.get(i).getDescription();
            }
            else {
                pizzaToppings = pizzaToppings + " and " + ingredients.get(i).getDescription();    
            }
        }
        //calculate the remaining area  of pizza by call the getRemainingArea method
        area = getRemainingArea();
        String stringAreaValue = String.valueOf(area);
        //check if the length of the string is 7
        if(stringAreaValue.length()>7){
        	stringAreaValue = stringAreaValue.substring(0, 7);
        }
        //add 0s to the string lengths that are less than 7
        else if(stringAreaValue.length()<7){
            int temp = 0;
            temp = 7 - stringAreaValue.length();
            for(int i=0;i<temp;i++){
            	stringAreaValue = stringAreaValue + "0";
            }            
        }
        
        String retVal = "The " + myShape.getShapeType() + " shaped pizza has a price:" + getCost().toString() 
            + " and calories: " + this.calories 
            + ", the fraction remaining: " + this.fractionSize 
            + " and area left: " + stringAreaValue  
            + ". The toppings include: " + pizzaToppings;
        return retVal;
    }
}