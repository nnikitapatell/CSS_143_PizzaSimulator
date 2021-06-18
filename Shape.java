import java.awt.*;
/**
 * Class Shape: will implement Cloneable but define the method as abstract. 
 * This will mean that clone() for the children of Shape will need to be custom 
 * implementations for that shape rather than being reliant on Object's clone 
 * method as per Savitch.
 * Shape superclass should manage x,y, colors, etc. just as in the labs. 
 *
 * @author Nikita Patel
 * @version 1
 * 
 *          Class Shape *
 *          By Rob Nash (with minor edits by Johnny Lin) * 
 *          This is the superclass in a hierarchy of shapes that you have to
 *          construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)

//create a class called Shape that extends object
class Shape extends Object implements Cloneable, Comparable {
	// instance variables
	private int x = 0;
	// private int y = 0;
	private double area;
	//private strign shapetype 
	private String shapeType;
	
	/**
	 * Main method to test the Shape class methods
	 * getShapeType, getArea, clone, 
	 * setShapeType, setArea
	 * @param args
	 */
	public static void main(String[] args) {
		int i1 = 89;
		String str1 = "circle";
		Shape s1 = new Shape(i1, str1);
		
		System.out.println("s1 getShapeType: " + s1.getShapeType()); //test getShapeType method
		System.out.println("s1 getArea: " + s1.getArea()); //test getArea method
		//s1.setX(3); //test setX method
		//System.out.println("s1 setX: " + s1.toString());
		int i2 = 100;
		String str2 = "square";
		Shape s2 = new Shape(i2, str2);		
		System.out.println("s2 clone: " + s2.toString());  //test clone method
		String str3 = "square";
		s2.setShapeType(str2);  //test setShapeType method 
		System.out.println("s3 setShapeType: " + s2.toString());
		System.out.println("s2 getX: " + s2.getX());  //test getX method
		s2.setArea(14.98);  //test setArea method
		System.out.println("s2 setArea(14.98: " + s2.toString());
		
		System.out.println("s1.compareTo(s1): " + s1.compareTo(s1));
		System.out.println("s2.compareTo(s1): " + s2.compareTo(s1));
		System.out.println("s1.compareTo(s): " + s1.compareTo(s2)); 
	}

	/**
	 * Shape Constructor- A constructor used to initialize the data members
	 *
	 * @param a          A parameter
	 * @param shapeType2 A parameter
	 */
	public Shape(int a, String shapeType2) {
		setX(a);
		setShapeType(shapeType);
	}

	/**
	 * no argument constructor
	 * @param none
	 */
	public Shape() {

	}

	/**
	 * copy constructor that has one parameter and makes a copy of the shape
	 * @return nothing
	 * @param newCopy
	 */
	public Shape(Shape newCopy) {
		this(newCopy.x, newCopy.shapeType);
	}

	/**
	 * setShapeType method - is a setter method for shape type 
	 * 
	 * @param shape
	 */
	public void setShapeType(String shape) {
		shapeType = shape;
	}

	/**
	 * getShapeType method that is a getter for the shape type
	 * @return
	 */
	public String getShapeType() {
		return shapeType;
	}

	/**
	 * Method getArea- Calculate the area of this shape
	 *
	 * @return The return value
	 */
	public double getArea() {
		return -1;
	}

	/**
	 * Method draw- This method is called on each shape to draw itself
	 *
	 * @param g A parameter
	 */
	public void draw(Graphics g) {
	}

	/**
	 * Method getX- Accessor mehtod for x varaible
	 *
	 * @return The return value
	 */
	public int getX() {
		int retVal = this.x;
		return retVal;
	}

	/* *//**
			 * Method getY- getter method for y
			 *
			 * @return The return value
			 *//*
				 * public int getY() { return this.y; }
				 */

	/**
	 * Method setX- Mutator for x
	 *
	 * @param value A parameter
	 * @return nothing
	 */
	public void setX(int value) {
		this.x = value;
	}

	/**
	 * setArea method is a setter method that sets the area
	 * @param a
	 * @return nothing
	 */
	public void setArea(double a) {
		this.area = a;
	}

	/**
	 * Method setY- Mutator for y
	 *
	 * @param value A parameter
	 *//*
		 * public void setY(int value) { this.y = value; }
		 */

	/*	*//**
			 * getShapeType
			 * 
			 * @return A String value
			 *//*
				 * public String getShapeType() { return "Shape"; }
				 */

	/**
	 *compareTo mehtod is a function that return a int value 
	 *override the method
	 *@param Object 
	 *@return int 
	 */
	@Override
	public int compareTo(Object o) {
		int retVal = 0;
		// Check for value the shape input
		if (o == null || !(o instanceof Shape)) {
			throw new PizzaException("Invalid Square");
		}
		Shape that = (Shape) o;
		double temp = this.area - that.area;
		if (temp > 0) {
			retVal = 1;
		} else if (temp < 0) {
			retVal = -1;
		} else {
			retVal = 0;
		}
		return retVal;
	}

	/**
	 * method clone for the Shape class
	 * override the method 
	 * @param
	 * 
	 */
	@Override
	public Shape clone() {
		Shape retVal = new Shape(this);
		return retVal;
	}
	public String toString() {
		String retVal = "Shape: " + getShapeType() + " Area: " + getArea() + " X Value: " + getX();
		return retVal;
	}
}
