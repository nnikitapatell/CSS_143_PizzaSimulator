/**
 * LinkedListException was copied over to this new class called 
 * PizzaException. it is used to throw these in place of standard 
 * RuntimeExceptions throughout the software.
 *
 * @author Nikita Patel
 * @version 1
 */
//create a class called PizzaException that extends RuntimeException
public class PizzaException extends RuntimeException {
    /**
     * PizzaException Constructor- class super from RuntimeException
     *
     * @param message A parameter
     */
    public PizzaException(String message){
    	//call super constructor with a parameter 
        super(message);
    }

    /**
     * PizzaException Constructor- class super from RuntimeException
     * @param none
     *
     */
    public PizzaException(){
    	//call the super constructor with no parameters 
        super();
    }
}