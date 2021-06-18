import java.util.Scanner;
/**
 * This class keeps track of pizzas over the course of its existence
 * When a Pizza is first made, it has 100% (1/1) of its surface area available for eating.  
 * As a pizza is eaten, fractions are removed from the ratio of pizza remaining, until the pizza is 
 * gone and the ratio reaches 0. 
 *
 * @author Nikita Patel
 * @version 1

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */
//Create a class called Pizza Manager
public class PizzaManager {
    /*
     *  TODO: Data definitions here.  
     */
    //The pizza Manager has a ArrayList that only holds Pizza Objects
    ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
    	// selection is the type char which is set to q
       char selection='q';
       //declare the object foo and initialize with input object
       Scanner foo = new Scanner(System.in);
       //while true
       while(true) {
    	   //call the method displayAllPizzas
           displayAllPizzas();
           //call the method displayInstructions
           displayInstructions();
           //selection is set the char inputed by the user
           selection = foo.next().charAt(0);

            //utilize the switch statement go case by case
            switch(selection) {
            	//case a adds a random pizza to the ArrayList<Pizza> by call the addRandomPizza method
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                //todo: add a new pizza to the arrayList 
                addRandomPizza();
                //break
                break;
                //case h adds 100 random pizzas to the ArrayList<Pizza>
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                //iterate through the array that is 100 elements long
                for(int i = 0; i < 100; i++){
                	//call addRandomPizza method
                    addRandomPizza();
                }
                //break
                break;         
                //case e asks the user input how much of the fraction of a pizza the ate 
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                	int num = 0;
                	int denom = 0;
                	int fractionIndex = 0;
                	//declare the object foo and initialize with input object
                	Scanner userInput = new Scanner(System.in);
                	String frac = userInput.next();
                	//split the fraction
                	String[] fraction = String.valueOf(frac).split("\\/");
					num = Integer.valueOf(fraction[0]);
					denom = Integer.valueOf(fraction[1]);
					System.out.println("At which pizza index?");
					fractionIndex = userInput.nextInt();
					//call the method eatSomePizza
					eatSomePizza(new Fraction(num,denom),fractionIndex);
                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                	//call the method sortByPrice
                	sortByPrice();
                break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                	//call the method sortBySize
                	sortBySize();
                break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                	//call the method sortByCalories
                	sortByCalories();
                break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
	                //call scanner 
                	Scanner calorieInput = new Scanner(System.in);
					int calories = calorieInput.nextInt();
					//call the binarySearchByCalories method 
					int index = binarySearchByCalories(calories);
					if(index == -1){
						System.out.println("Pizza with " + calories + " calories not found.");
					}
					else {
						System.out.println("Pizza with " + calories + " calories found:");
						System.out.println(pizzas.get(index) + "\n\n");
					}	

                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                	//exit system
                	System.exit(0);
                	foo.close();
                break;
                default:    System.out.println("Unrecognized input - try again");
            }
        }  
    }

	/**
	 * addRandomPizza method- call the add method from the array 
	 * list class to add a random pizza 
	 * @param none
	 * @return nothing
	 */
	private void addRandomPizza() {
        //call add a pizza
    	pizzas.add(new Pizza());
    }

    /**
     * method displayAllPizzas- call the get method from the arrayList class to display all the 
     * pizzas by iterating through the size of the list
     * @param none
     * @return nothing
     */
    private void displayAllPizzas() {
        //iterate through array to display all the pizzas
        for(int i=0; i<pizzas.size(); i++){
            System.out.println(pizzas.get(i));
        }
    }

    /**
     * method sortByPrice- calls the helper method helperMethodSortPrice which has two parameters 
     * used selection sort mechanism to sort the prices
     * @param none
     * @return nothing
     */
    private void sortByPrice() {  
    	//iterate through the for loop
    	for(int i = 0; i < pizzas.size(); i++) {
            int smallestIndex = i;
            //iterate through the for loop
            for(int j = i; j < pizzas.size(); j++) {
            	//check if when comparing the prices the outcome is -1
                if(pizzas.get(j).compareTo(pizzas.get(smallestIndex)) == -1) {
                    smallestIndex = j;
                }
            }
            //creat a temporary pizza
            Pizza tempPizza = pizzas.set(pizzas.get(smallestIndex), i);
            //set the pizza
            pizzas.set(tempPizza, smallestIndex);
        }
    }
    
    /**
     * sortBySize method - This sorts Pizzas based on the remaining area left
     * used selection sort mechanism for the is method
     * @param none
     */
    private void sortBySize() {
    	//iterate through the the for loop
    	for(int i = 0; i < pizzas.size(); i++) {
    		//se the smallest index to 
            int smallestIndex = i;
            //iterate through the for loop
            for(int j = i; j < pizzas.size(); j++) {
            	//check if when comparing the sizes that outcome is 1
                if(pizzas.get(j).compareToBySize(pizzas.get(smallestIndex)) == 1) {
                	//set the smallest index to j
                    smallestIndex = j;
                }
            }
            
            Pizza temp = pizzas.set(pizzas.get(smallestIndex), i);
            pizzas.set(temp, smallestIndex);
        }
	}
    
    /**
     * method sortCalories- this method is a function that sorts the pizza in the list 
     * by calories
     * Used insertion sort the pizzas by calories
     * 
     * @param none
     * @return nothing
     */
    private void sortByCalories() {
    		//iterate through the for loop
    	  for(int i = 0; i < pizzas.size(); i++) {
              int smallestIndex = i;
              //iterate through the for loop
              for(int j = i; j < pizzas.size(); j++) {
                  if(pizzas.get(j).compareToByCalories(pizzas.get(smallestIndex)) == -1) {
                      smallestIndex = j;
                  }
              }
            //swap the pizzas
      		pizzas.swap(smallestIndex, i);
          }
    }

    /**
     * method binarySearchByCalories- is a function that searches by calories
     * so the input is the target amount of calories
     * 
     * @param targetCal
     * @return int
     */
    private int binarySearchByCalories(int targetAmountOfCalories) {
    	//call the sortByCalories method
    	sortByCalories();
    	//int variables 
		int low = 0;
		int high = 0;
		int mid = 0;
		//change high to the size of pizzas -1
		high = pizzas.size()-1;
		//while low is less than or equal to high
		while(low <= high){
			// mid is the average of low and high
			mid = (low + high)/2;
			//check if the mid calories is targetAmountOfCalories
			if(pizzas.get(mid).getCalories() == targetAmountOfCalories){
				//return mid
				return mid;
			}
			//check if the mid calories is less than targetAmountOfCalories
			else if(pizzas.get(mid).getCalories() < targetAmountOfCalories){
				//low is then set to mid +1 
				low = mid + 1;
			}
			//otherwise set high to mid - 1
			else {
				//high is set to mid-1
				high = mid - 1;
			}
		}
		//return -1
		return -1;
    }
    
    /**
     * eatSomePizza is a method of the PizaManager class 
     * It takes in two parameters: a fraction amount and an index
     * this function subtracts the fraction amount of pizza "eaten" from the remaining amount of pizza
     * 
     * @param amount
     * @param index
     */
    public void eatSomePizza(Fraction fractionAmount, int index){
    	//check if the fraction amount input is null or not an instance of Fraction class
		if(fractionAmount == null || !(fractionAmount instanceof Fraction)){
			//throw an excpetion 
			throw new PizzaException("Exception in eatSomePizza method: The Fraction amount " + fractionAmount 
					+ " is null or not an instance of the class Fraction.");
		}
		//try catch block
		try{
			//get the index of the fractionAmount
			pizzas.get(index).eatSomePizza(fractionAmount);
		}
		//catch any exception that may occur in the process of obtaining the fraction amount
		catch(PizzaException p){
			System.out.println(p.toString());
			//remove index that was inputed
			pizzas.remove(index);
		}
	}

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
    	//print the instructions out
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
