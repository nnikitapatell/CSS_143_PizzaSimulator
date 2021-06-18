import java.io.Serializable;
/**
 *  Money class, to be used to represent costs for Ingredients and Pizzas
 *   the Money class must also implement Comparable
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called Money that implements Comparable, Cloneable and Serializable
public class Money implements Comparable <Object>, Cloneable, Serializable{
	//private in dollars set to 0
	private int dollars = 0;
	//private int cents is 0
	private int cents = 0;
	
	/**
	 * Main method to tests the Money class methods
	 * test the following methods: setDollars, setMoney, setCents, toString, equals, 
	 * getDollars, getMoney, getCents, compareTo, add, clone
	 * @param args
	 */
	public static void main(String[] args) {
		Money m1 = new Money(0);
		Money m2 = m1.clone(); //test clone method
		
		System.out.println("m1: " + m1.toString()); //test toString method
		System.out.println("clone of m1: " + m2.toString()); 
		System.out.println("m1 equals m2: " + m1.equals(m2)); //test equals method
		
		Money m3 = new Money(3); 
		System.out.println("m3: " + m3.toString());
		m1.setAmount(m3); //test setAmount method
		System.out.println("setAmount m1: " +m1.toString());
		
		m2.setCents(50); //test setCents method
		System.out.println("setCents m2: " +m2.toString());
		
		m3.setMoney(9,40); //test setMoney method
		System.out.println("setMoney m3: " + m3.toString());
		
		System.out.println("m1 equals m2: " + m1.equals(m2)); //test equals method
		m1.add(3); //test add method
		System.out.println("add 3 to m1 : " + m1.toString());
		
    	System.out.println("compareTo: " + m1.compareTo(m1)); //test compareTo method
    	System.out.println("compareTo: " + m1.compareTo(m2)); //test compareTo method
    	System.out.println("compareTo: " + m2.compareTo(m1)); //test compareTo method
    	
    	System.out.println("getAmount from m3: " + m3.getAmount()); //test getAmount method
    	System.out.println("getCents from m3: " + m3.getCents()); //test getCents method
    	System.out.println("getDollars from m3: " + m3.getDollars()); //test getDollars method
	}
	
		/**
		 * Default constructor that has no parameters
		 * @param none
		 */
		public Money() {
			
		}
		
		/**
		 * Money constructor that takes in dollars as a parameter
		 * @param d
		 */
		public Money(int d) {
			this.dollars = d;
		}
		
		/**
		 * Copy constructor that takes a Money object
		 * @param amount
		 */
		public Money(Money amount){
			//set the dollars
			setDollars(amount.dollars);
			//set the cents
			setCents(amount.cents);
		}
		
		/**
		 * Constructor that take in dollars and cents 
		 * @param d
		 * @param c
		 */
		public Money(int d, int c){
			//set the dolalrs and cents
			setMoney(d, c);
		}
		
	/**
	 * Method setDollars that is a setter method for the dollars
	 * @param dollar
	 * @return nothing
	 */
	public void setDollars(int dollar){
		//check if d is less than 
		if(dollar < 0) {
			//throw an exception 
			throw new PizzaException("Exception in the setDollars mehtod. the dollar amount is negative ");
		} 
		else {
			//set this to dollar
			this.dollars = dollar;
		}
	}
	
	/**
	 * setCents method - is a setter method for the cents
	 * @param c
	 * @return nothing
	 */
	public void setCents(int c){
		//check if the c is less than 0
		if(c < 0) {
			//throw an exception 
			throw new PizzaException("Exception in the setCents mehtod. the cents amount is negative ");
		}
		//If c > 99 add tot he dollar amount 
		else if(c > 99){
			cents = c % 100;
			dollars += (c - cents)/100;
		} 
		else {
			cents = c;
		}
	}
	
	/**
	 * getDollars method is the getter method for dollars
	 * @return int 
	 * @param none
	 */
	public int getDollars() {
		int retVal = this.dollars;
		return retVal;
	}
	
	
	/**
	 * getCents method is the getter method for the cents
	 * @return int
	 * @param none
	 */
	public int getCents() {
		int retVal = this.cents;
		return retVal;
	}
	
	/**
	 * clone mehtod utilizes the copy constructor adn overrides
	 * @return Money
	 * @param none
	 */
	@Override
	public Money clone(){
		Money retVal =  new Money(this);
		return retVal;
	}
	
	/**
	 * getAmount method is a getter method for the amount
	 * @return String 
	 * @param none
	 */
	public String getAmount(){ 	
		String retVal = String.format("$%d.%d", dollars, cents);
		return retVal;
	}

	/**
	 * setAmount method sets the amount of money
	 * @return nothing
	 * @param amount
	 */
	public void setAmount(Money amount){
		setDollars(amount.dollars);
		setCents(amount.cents);
	}
	
	/**
	 * toString method overrides and calls the getAmount method
	 * @return String 
	 */
	@Override
	public String toString(){
		String retVal = getAmount();
		return retVal;
	}
	
	/**
	 * equal method overrides and checks to see if the input is an instance of the money class and not null
	 * @param Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o){
		if(o == null || ! (o instanceof Money)){
			//throw an exception 
			throw new PizzaException("Exception in the equals method. the obeject is not an instance of money");
		} 
		else {
			//casting
			Money that = (Money) o;
			boolean retVal = this.dollars == that.dollars && this.cents == that.cents;
			return retVal;
		}
	}
	
	/**
	 * compareTo method- implements the comparable interface and compares the amounts 
	 * @return int
	 * @param Object
	 */
	@Override
	public int compareTo(Object o) {
		if(o == null || !(o instanceof Money)){
			throw new PizzaException("Passed Object isn't Money");
		}
		Money that = (Money) o;
		//retrieve the string value of the Bill in terms of dollars and cents
		String this_money = this.getDollars() + "." + this.getCents();
		String that_money = that.getDollars() + "." + that.getCents();
		//parse this string value into a double and then subtract 
		Double retVal = Double.parseDouble(this_money) - Double.parseDouble(that_money);
		// return 0 if equal, 1 if this is greater, and -1 if that object is greater
		if(retVal == 0){
			return 0;
		}
		else if(retVal>0){
			return 1;
		}
		else{
			return -1;
		}
	}
	
	 /**
     * Method add- Adds the int passed into the function to dollars
     * @param dol A parameter
     * @return nothing
     */
    public void add(int dol) {
        //sets the dollars by adding the dol and the dollars
        setDollars(getDollars() + dol);
    }

    /**
     * Method add
     * Adds to dollars and cents the two ints passed into the function.
     * 
     * @param d  A parameter
     * @param c A parameter
     * @return nothing
     */
    public void add(int d, int c) {
        //newDollars is set dollars added the parameter value
        int newDollars = (getDollars() + d);
        //newCents is set cents added the parameter value
        int newCents = (getCents() + c);
        //check if the newCents > than 99
        if (newCents > 99){
            //temporaryVaraibleForDollars is set to newCents/ 100
            int temporaryVaraibleForDollars = (newCents / 100);
            //temporaryVariableForCents
            int temporaryVariableForCents = (newCents % 100);
            setDollars(newDollars + temporaryVaraibleForDollars);
            setCents(temporaryVariableForCents);
        }
        //otherwise,
        else{
            //set dollars to newDollars
            setDollars(newDollars);
            //set Cents to newCents
            setCents(newCents);
        }
    }

    /**
     * Method add- Adds to this object the dollars and cents stored in the other object.
     *
     * @param other A parameter
     * @return nothing
     */
    public void add(Money other) {
        //Adds to this object the dollars stored in the other object
        int newDollars = other.getDollars() + getDollars();
        //Adds to this object the cents stored in the other object
        int newCents = other.getCents() + getCents();
        //check if newCents is greater than 99
        if (newCents > 99) {
            //temporaryDollars are set to newCents divided by 100
            int temporaryDollars = (newCents / 100);
            //temprorary cents are set to newCents mod 100
            int temporaryCents = (newCents % 100);
            //setDollars to newDollars + temporaryDollars
            setDollars(newDollars + temporaryDollars);
            //set cents to the temporaryCents
            setCents(temporaryCents);
        } 
        //otherwise
        else {
            //Set dollars to newDollars
            setDollars(newDollars);
            //set cents to newCents
            setCents(newCents);
        }
    }	
    /**
     * Method getMoney- A getter for the total monetary amount, as a double
     * Returns 5.75, for example
     *
     * @return The return value
     */
    public double getMoney(){
        //returns the money formated as a double
        return this.dollars + (this.cents / 100);
    }

    /**
     * Method setMoney- Sets our dollars and cents, accordingly 
     * This function should make use of setters for dollars and cents
     *
     * @param dol A parameter
     * @param cent A parameter
     */
    public void setMoney(int dol, int cent){
        //sets dollar and cent
        setDollars(dol);
        setCents(cent);
    }
}
