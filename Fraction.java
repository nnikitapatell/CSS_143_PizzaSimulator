/**
 * Fraction class: manages a numerator and denominator with reduction.
 * 
 * @author Nikita Patel
 * @version 1
 */
//create a class called Fraction that implements Comparable
public class Fraction implements Comparable{
    //create two private integer variables
    private int numerator;
    private int denominator;
    /**
     * Main method to tests the Fractions class methods
     * equals, subtract, toString, compareTo, clone, setDenominator, setNumerator
     * getNumerator, getDenominator, reduce
     *
     * @param args A parameter
     */
    public static void main(String[] args){
    	//create 2 Fraction objects f1 and f2
    	Fraction f1 = new Fraction(1,2); 
    	Fraction f2 = new Fraction(2,3);
    	System.out.println("f1: " + f1.toString()); //test toString method
    	System.out.println("f2: " +f2.toString()); //test toString method
    	System.out.println("f2.getDenominator(): " + f2.getDenominator()); //test getDenominator method
    	System.out.println("f2.getNumerator(): " + f2.getNumerator()); //test getNumerator method
    	System.out.println("clone: " + f2.clone()); //test clone method
    	System.out.println("equals: " + f1.equals(f1)); //test equals method
    	System.out.println("equals: " + f2.equals(f1)); //test equals method
    	System.out.println("compareTo: " + f1.compareTo(f1)); //test compareTo method
    	System.out.println("compareTo: " + f1.compareTo(f2)); //test compareTo method
    	System.out.println("compareTo: " + f2.compareTo(f1)); //test compareTo method
    	f2.setDenominator(6); //test setDenominator method
    	System.out.println("f2.setDenominator(6): " + f2.toString());
    	f1.setNumerator(2); //test setNumerator method
    	System.out.println("f1.setNumerator(2): " + f1.toString());
    	f2.subtract(f1); //test subtract method
    	System.out.println("f1.subtract(f2): " + f2.toString());
    	f1.reduce(4, 6);
    	System.out.println("f1.reduce(4, 6); " + f1.toString()); //test reduce method
    }
    
    /**
     * Fraction Constructor is a default contructors that set the fraction to 1/1
     * @param none
     */
    public Fraction() {
    	//set Numerator to 1
        setNumerator(1);
        //set Denominator to 1
        setDenominator(1);
    }

    /**
     * Fraction Constructor is a constructor that has 2 parameters in its argument
     *
     * @param num A parameter
     * @param denom A parameter
     */
    public Fraction(int num, int denom){
        //call the reduce function with two parameters
        reduce(num, denom);
    }

    /**
     * Fraction Constructor- this constructor is a copy constructor 
     *
     * @param toCopy A parameter
     */
    public Fraction(Fraction toCopy){
        //sets the numerator by calling the getter method
        setNumerator(toCopy.getNumerator());
        //sets the denominator by calling the getter method
        setDenominator(toCopy.getDenominator());
    }

    /**
     * Method clone- overrides and utilizes the copy constructor to return new clone of the fraction
     *
     * @return The return value
     */
    @Override
    public Fraction clone(){
        //returns the new clone of fraction
        return new Fraction(this);
    }

    /**
     * Method reduce- reduces the fraction and accepts any negative values 
     * and stores them in the numerator
     *
     * @param num A parameter
     * @param denom A parameter
     */
    public void reduce(int num, int denom){
        //check if the denominator is 0
        if(denom == 0 || num < 0 || denom < 0){
        	//throw an exception 
            throw new PizzaException("Exception in the reduce method: The denominator cannot be 0 or negative OR the numerator is negative");
        }
        //counter variable set to 1
        int counter = 1;  
        //This is greatest common divisor variable
        int gcd = 1;

        //This is a boolean variable to determine if the fraction is positive or negative
        boolean theFractionIsPositive = false;

        //check if the numerator and denominator is less than 0
        if(num < 0 && denom < 0){
            //if so, set the variable to true
            theFractionIsPositive = true;
        }
        //else if check if numerator denominator are greater than 0 
        else if(num > 0 && denom > 0){
            //set the variable to true
            theFractionIsPositive = true;
        }
        //otherwise the fraction is negative
        else {
        	//set the variable to false
            theFractionIsPositive = false;
        }
        
        //create two temporary variables for the numerator and denomoinator 
        int tempNum = 0;
        int tempDenom = 0;
        tempNum= Math.abs(num);
        tempDenom = Math.abs(denom);
        //check if the temporary numerator value is less than the temporary denominator value
        if(tempNum < tempDenom){
        	//counter is set to tempNum
            counter = tempNum;
        }
        //other wise set the counter to tempDenom
        else {
            counter = tempDenom;
        }

        //iterate through the forloop to find the greatest common denominator for the numerator and denominator
        for(int i=1; i<=counter; i++){
            if((tempNum % i == 0) && (tempDenom % i == 0)) gcd = i; 
        }

        //divide the numerator by the greatest common denominator
        num = num / gcd;
        //divide the denominator by the greatest common denominator
        denom = denom / gcd;

        //set the numerator and denominator to positive numbers
        num = Math.abs(num);
        denom = Math.abs(denom);

        //check if the fraction is negative
        if(theFractionIsPositive == false) {
        	//set num to a positive
            num = num * -1;
        }
        //check if the num is 0 
        if(num == 0){
        	//set the num to 0
            setNumerator(0);
            //set the denom to 0
            setDenominator(0);
        }
        //otherwise call the setter methods for the denominator and numerator to set them
        else{
            setNumerator(num);
            setDenominator(denom);
        }
    }

    /**
     * Method getNumerator- the getter for the Numerator
     * @param none
     * @return The return value
     */
    public int getNumerator(){
    	int retVal = this.numerator;
        return retVal;
    }

    /**
     * Method setNumerator- the setter method for the fraction class
     * @return nothing
     * @param num A parameter
     */
    public void setNumerator(int num){
    	//set numerator to num
        this.numerator = num;
    }
    
    /**
     * Method getDenominator- the getter method for the denominator
     * @param none
     * @return The return value
     */
    public int getDenominator(){
    	int retVal = this.denominator;
        return retVal;
    }

    /**
     * Method setDenominator- set the denominator and throw exception if the denominator is 0
     *
     * @param denominator A parameter
     */
    public void setDenominator(int denominator){
    	//check if the denominator is not 0
        if(denominator != 0){
            this.denominator = denominator;
        } 
        //otherwise check if the numerator is 0
        else if(this.numerator == 0){
        	//set the numerator to 0
            this.denominator = 0;
        }
        else{
        	//throw an exception 
            throw new PizzaException("Exception in the set denominator method: denominator is 0");
        }
    }

    /**
     * Method equals- overrides hte default equals method to check if the numerator and denominator are the same
     *
     * @param o A parameter
     * @return The return value
     */
    public boolean equals(Object o){
    	//check if the object is null or not an instance of Fraction
        if(o == null || !(o instanceof Fraction)){
        	//throw an exception 
            throw new PizzaException("Exception in the equals method: the object is null or not an instance of Farction");
        }
        //casting Fraction to the object
        Fraction that = (Fraction) o;
        boolean retVal = this.numerator == that.numerator && this.denominator == that.denominator;
        return retVal;
    }

    /**
     * Method compareTo- uses the equals mehtod to check and see if the fraction are equal by returning 0
     * the subtract method to return a value 
     * a positive value shows that this fraction is larger 
     * and the negative means that the compared fraction is larger
     *
     * @param o A parameter
     * @return The return value
     */
    @Override
    public int compareTo(Object o) {
    	//check if the object is null or not an instance of object
        if(o == null || !(o instanceof Fraction)){
        	//throw an exception 
            throw new PizzaException("Exception in the compareTo method. the object is null or not an instance of object");
        }
        //casting
        Fraction that = (Fraction) o;
        //check if theis equals that
        if(this.equals(that)){
        	//return 0
            return 0;
        }
        // set temp obejc to clone of this
        Fraction temp = this.clone();
        //call subtract method to subtract fractions
        temp.subtract(that);
        int retVal = temp.numerator;
        return retVal;
    }
   
    /**
     * Method toString- override the default toString and formats the fractions
     *
     * @return The return value
     */
    public String toString(){
    	String retVal = "";
    	retVal = getNumerator() + "/" + getDenominator();
        return retVal;
    }

    /**
     * Method subtract- subtracts the Fraction object from the this fraction
     * exception is thrown 
     *
     * @param f A parameter
     * @return nothing
     */
    public void subtract(Fraction f){
        //check if the object is null or not an instance of object
        if(f == null || !(f instanceof Fraction)){
        	//throw an exception 
            throw new PizzaException("Exception in the subtract method: object is null or not an instance of Fraction");
        }
        //casting 
        Fraction that = (Fraction) f;
        //denom is the same
        int newDenom = this.denominator * that.denominator;
        int num1 = this.numerator * that.denominator;
        int num2 = that.numerator * this.denominator;
        //subtract the numbers
        int finalNum = num1 - num2;
        //Reduce the fraction 
        reduce(finalNum, newDenom);
    }
}

