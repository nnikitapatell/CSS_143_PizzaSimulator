/**
 *  ArrayList that holds Comparable Objects and is dynamically resizable.  
 *  Modified this ArrayList so it uses generics so that we can build an ArrayList<Pizza>.
 *
 * @author Nikita Patel
 * @version 1
 * @param <TBA> A parameter
 */
//create a class called ArrayList that implements COmparable and cloneable
public class ArrayList<TBA> implements Comparable<TBA>, Cloneable {
	//maximum capacity for the arrayList
	private int maximumCapacity;
	//Object array called data 
	private Object[] data;
	//numElments
	private int numElements;
	
	/**
	 * Main method to test the ArrayList class methods
	 * add, indexOf, insert, set, equals, toString, remove, swap, size
	 * @param args
	 */
	public static void main(String[] args) {
		//Create a pizzaList
		ArrayList<Pizza> pizzaListOne = new ArrayList<Pizza> ();
		
		//create 3 pizza objects a, b and c
		Pizza a = new Pizza();
		Pizza b = new Pizza();
		Pizza c = new Pizza();
		
		//add the pizza objects a, b and c
		pizzaListOne.add(a); //test add method
		pizzaListOne.add(b);
		pizzaListOne.add(c);
		
		System.out.println("pizzaListOne add(a,b,c): ");
		System.out.println(pizzaListOne.toString());
		
		System.out.println("pizzaListOne get(2): " );
		System.out.println(pizzaListOne.get(2)); //test get method
		System.out.println("pizzaListOne indexOf(b):" + pizzaListOne.indexOf(b)); //test indexOf method
		//create pizza object d
		Pizza d = new Pizza();
		System.out.println("pizzaListOne d: " + d.toString());
		pizzaListOne.insert(d, 2); //test insert method
		System.out.println("pizzaListOne insert(d,2): ");
		System.out.println(pizzaListOne.toString());
		pizzaListOne.set(a, 3); //test set method
		System.out.println("pizzaListOne set(a,3): ");
		System.out.println(pizzaListOne.toString());
		
		ArrayList<Pizza> pizzaListTwo = new ArrayList<Pizza> ();
		//create 3 pizza objects e, f, and g
		Pizza e = new Pizza();
		Pizza f = new Pizza();
		Pizza g = new Pizza();
		//add the pizza objects e,f,g
		pizzaListTwo.add(e);
		pizzaListTwo.add(f);
		pizzaListTwo.add(g);
		System.out.println("pizzaListTwo add(e,f,g): ");
		System.out.println(pizzaListTwo.toString()); //test toString method
		System.out.println("pizzaListOne.equals(pizzaListTwo): ");
		System.out.println(pizzaListOne.equals(pizzaListTwo)); //test equals method
		
		pizzaListTwo.remove(0); //test remove method
		System.out.println("pizzaListTwo remove(0): ");
		System.out.println(pizzaListTwo.toString());
		
		pizzaListTwo.swap(1, 2); //test swap method
		System.out.println("pizzaListTwo swap(1,2): ");
		System.out.println(pizzaListTwo.toString());
		
		System.out.println("pizzaListTwo size: " + pizzaListTwo.size()); //test size method
		
		System.out.println("pizzaListTwo compareTo: " + f.compareTo(f));
		System.out.println("pizzaListTwo compareTo: " + f.compareTo(g));
		
		System.out.println("pizzaListTwo clone: " + pizzaListTwo.clone());
	}
	
	/**
	 * no-argument constructor that just intializes the ArrayList
	 * @param none
	 */
	public ArrayList() {
		//maximum capacity for the arrayList
		maximumCapacity = 100;
		//Object array called data is set to the length of maximumCapacity
		data = new Object[maximumCapacity];
		//numElments set to 0
		numElements = 0;
	}
	
	/**
	 * Copy constructor- makes copies of the maximumCapacity, numElements, and data
	 * @param toCopy A parameter
	 */
	public ArrayList(ArrayList<TBA> toCopy){
		//copies the maximumCapacity
		this.maximumCapacity = toCopy.maximumCapacity;
		//copies the numElements
		this.numElements = toCopy.numElements;
		//Iterate through each numElement
		for(int i = 0; i < toCopy.numElements; i++){
			//copies the numElements
			this.data[i] = toCopy.data[i];
		}
	}
	
	/**
	 * getObject method that returns a TBA object for any given index
	 * @param index A parameter
	 * @return TBA object
	 */
	public TBA get(int index){
		//check if the index is > numElements or < 0
		if(index > numElements || index < 0){
			throw new PizzaException("Index is greater than numELements or less than 0");
		}
		//Cast return data value as TBA object
		return (TBA) data[index];
	}
	
	/**
	 * set method- will write or rewrite the data at the index
	 * @param o A parameter
	 * @param index A parameter
	 */
	public TBA set(TBA o, int index){
		//Check for bad index
		if(index > numElements || index < 0){
			throw new PizzaException("Bad index");
		}
		  TBA element = get(index);
	      data[index] = o;
	      return element;
	}
	
	/**
	 * insert method- inserts a object at a given index
	 * 
	 * @param o A parameter
	 * @param index A parameter
	 * @return nothing
	 */
	public void insert(TBA o, int index){
		//Invariants for object and index
		if(o == null || index < 0 || index > numElements){
			throw new PizzaException("Bad input");
		}
		
		//Resize data array if reach max size
		if(numElements == maximumCapacity){
			//Call resize method to increase size
			resize();
		}
		TBA that = (TBA) o;
		
		//Shift array to insert new TBA
		shiftRight(index);
		data[index] = that;
		//Increase number of elements after inserting new TBA
		numElements++;
	}
	
	/**
	 * add method is a function that calls the insert method
	 * @param o A parameter
	 * @return nothing
	 */
	public void add(TBA o){
		insert(o, numElements);
	}
	
	/**
	 * resize is a method that resizes the arraylist when necessary
	 * creates a new array and copies the data of the old array over
	 * @param none
	 * @return nothing
	 */
	private void resize(){
		//Increasing by factor of 10
		maximumCapacity = maximumCapacity * 2;
		Object tempData[] = new Object[maximumCapacity];
		//Copy old array into new array
		for(int i = 0; i < numElements; i++){
			//set the old day to data
			tempData[i] = data[i];
		}
		//data is set to tempData
		data = tempData;
	}
	
	/**
	 * shiftRight is method that shift the data in the list to the right 
	 * so there is space for to insert object
	 * @param input
	 * @return nothing
	 */
	private void shiftRight(int input){
		//iterate through the array
		for(int i=numElements-1; i >= input; i--){
			data[i+1] = data[i];
		}
	}
	
	/**
	 * remove method removes the TBA object fromt he Arraylist
	 * @param index A parameter
	 * @return TBA object
	 */
	public TBA remove(int index){
		//check if the index is less than 0 or the index is greater than or equal to the length of the data
		if(index < 0 || index >= data.length){
			throw new PizzaException("the index is less than 0 or the index is greater than or equal to the length of the data");
		}
		//move the data to the left
		Object retval = shiftLeft(index);
		//decrement the variable numELements because we are removing one element
		numElements--;
		//Return the object of the type TBA
		return (TBA) retval;
	}

	/**
	 * shiftLsft method will move the elements of the list to the left
	 * @param input A parameter
	 * @return Object object
	 */
	private Object shiftLeft(int input){
		Object retVal = data[input];
			//Iterate over the arrayList
			for(int i = input; i < numElements-1; i++) {
				data[i] = data[i+1];
			}
		//Return value
		return retVal;
	}

	/**
	 * indexOf mehtod fid the index of a given TBA object
	 * @param o A parameter
	 * @return int Value
	 */
	public int indexOf(TBA o){
		//check if the object is null
		if(o == null){
			throw new PizzaException("TBA object is null");
		}
		//Iterate through the arrayList to find TBA object
		for(int i=0; i<numElements; i++){
			//check if the data at the given index is o
			if(data[i] == o) {
				//if so return the index at which it equals o
				return i;
			}
		}
		//return -1
		return -1;
	}
	
	//Return size of arraylist
	/**
	 * size method return the number of elements in the arraylist
	 * @return int value
	 * @param none
	 */
	public int size(){
		//return numElements
		return numElements;
	}

	/**
	 * toString method helps format the ArrayList elements
	 * override the method 
	 * @param none
	 * @return String
	 */
	@Override
	public String toString(){
		String retVal = "";
		//print out each data
		for(int i = 0; i < numElements; i++){
			retVal = retVal + data[i].toString() + "\n";
		}
		//return retVal
		return retVal;
	}
	
	/**
	 * swap method that takes in two parameters that are the specific indexes that need to be swapped
	 * 
	 * @param index1 A parameter
	 * @param index2 A parameter
	 * @return nothing
	 */
	public void swap(int index1, int index2){
		//create a retVal object
		Object retVal = null; 
		retVal = data[index1];
		//set the data at index1 to the data of index 2
		data[index1] = data[index2];
		//set the data of index2 to retVal object
		data[index2] = retVal;
	}

	/**
     * Method compareTo- implents comparable to compare the elements in the ArrayList
     * override the method from the parent class
     *
     * @param o A parameter
     * @return The return value
     */
	@Override
	public int compareTo(TBA o) {
		int retVal = 0;
		//check if o is null or not an instance of ArrayList
        if (o == null || !(o instanceof ArrayList)) {
        	//throw an exception
            throw new PizzaException("compareTo() method with either a null or something that wasn't an ArrayList.");
        }
        //casting
        ArrayList<TBA> that = (ArrayList<TBA>) o;
        for (int i = 0; i < numElements; i++) {
            //check if amount compared to the object amount is greater than 0
            if (((Comparable<TBA>) this.get(i)).compareTo(that.get(i)) > 0){
                //return 1
                retVal++;
            }
            //check if amount compared to the objecta amount is ;ess than 0
            else if (((Comparable) this.get(i)).compareTo(that.get(i)) < 0){
                //return -1
                retVal--;
            } 
            //else 
            else 
            //return 0
            retVal = 0;
        }  
        return retVal;
	}
	
    /**
     * Method isEmpty- checks if arraylist is empty. if it is it will return ture and otherwise 
     * it will return false
     *
     * @return The return value
     */
    public boolean isEmpty(){
        //check if this element is 0
        if(this.numElements  == 0){
            //return true
            return true;
        }
        //otherwise
        else{
            //return false           
            return false;
        }
    }
    
    /**
     * Method clone- return a clone of the ArrayList<TBA> object
     *
     * @return The return value
     */
    public ArrayList<TBA> clone() {
        return new ArrayList((ArrayList<TBA>) this);
    }
    
	
}
	
