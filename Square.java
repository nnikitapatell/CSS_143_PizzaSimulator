/**
 * Square class: is one of the  two subclasses for managing Pizza Shapes
 * inherits from the shape class
 * 
 * @author Nikita Patel 
 * @version 1
 */
//create a class called Square that extends Shape
public class Square extends Shape{
	//private variables
	//set int side to 4
	public final static int side = 4;
	//double area set to 0.0
	private double area = 0.0;
	//shapeType is a string and it is set to square
	public final static String shapeType = "square";
	/**
	 * Main method to test the Circle class methods
	 * getArea, getShapeType
	 * @param args
	 */
	public static void main(String[] args) {
		//create a square object
		Square s1 = new Square();
		System.out.println("s1 getShapeType: " + s1.toString()); //test toString method
		System.out.println("s1 getShapeType: " + s1.getShapeType()); //test getShapeType method
		System.out.println("s1 getArea: " + s1.getArea()); //test getArea method
		
	}
	
	/*
	 * Square constructor with no arguments
	 * @param none
	 */
	public Square() { 
		//call super
		super(side, shapeType);
		//set area
		setArea();
	}
	
	/**
	 * Square Constructor that calls the Shape Constructor and set the area
	 * @param newCopy
	 * @return nothing
	 */
	public Square(Square newCopy) {
		//call super
		super(newCopy.side, newCopy.shapeType);
		//set the area by calling the setter mehtod
		setArea();
	}

	/**
	 * Getter for the Square constructor that get the area
	 *@return area 
	 *@param none
	 */
	@Override
	public double getArea() {
		//set the retVal to are
		double retVal = this.area;
		//return retVal
		return retVal;
	}
	
	/**
	 * Setter for the Square constructor that sets the area.
	 * area it set by calling the methods getX and getY
	 *@param none
	 *@return nothing
	 */
	public void setArea() {
		//set area to X*X
		this.area = this.getX() * this.getX();
	}
	
	/**
	 * Setter for the Square constructor that sets the area
	 *@param a Input variable that is double 
	 *@return nothing
	 */
	@Override
	public void setArea(double a) {
		//set area to input value
		this.area = a;
	}
	
	/**
	 * getShapeType method that returns a String type
	 * @param none 
	 * @return retVal A String value 
	 */
    public String getShapeType() {
    	String retVal = "";
    	//set String retVal to square
    	retVal = "square";
    	//return retVal
    	return retVal;
    }
	
	/**
	 * clone method that returns a Square type
	 * @param none 
	 * @return retVal A String value 
	 */
	@Override
	public Shape clone() {
		//return new Square(this);
		Square retVal = new Square(this);
		//return retVal
		return retVal;
	}
	
}
