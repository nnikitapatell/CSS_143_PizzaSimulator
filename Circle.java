import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * Circle class: is one of the two subclasses for managing Pizza Shapes
 * inherits from Shape class
 * @author Nikita Patel
 * @version 1
 */
//Build a new class called Circle that uses the inheritance keyword extends the shape class
public class Circle extends Shape {
	// instance variables
	// radius is private, static and final set to 4
	private static final int radius = 4;
	// double final area is set to 0.0
	private double area = 0.0;
	// shape type is set to circle
	public final static String shapeType = "circle";
	
	/**
	 * Main method to test the Circle class methods
	 * getArea, getShapeType
	 * @param args
	 */
	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println("c1 getShapeType: " + c1.toString()); //test toString method
		System.out.println("c1 getShapeType: " + c1.getShapeType()); //test getShapeType method
		System.out.println("c1 getArea: " + c1.getArea()); //test getArea method
	}
	
	/**
	 * No-argument constructor intialize the varibles of the class by calling super
	 * and the set area method
	 * @param none
	 * @return nothing
	 */
	public Circle() {
		super(radius, shapeType);
		setArea();
	}

	/**
	 * Square Constructor that calls the super Shape class Constructor and set the
	 * area by calling the setarea method
	 * 
	 * @param newCopy
	 * @return nothing
	 * 
	 */
	public Circle(Circle newCopy) {
		//set radius and shapeType
		super(newCopy.radius, newCopy.shapeType);
		//set area
		setArea();
	}

	/**
	 * Method getRadius- accessor for radius
	 *
	 * @return The return value
	 */
	// public double getRadius() { // return radius return this.radius; }

	/**
	 * Method setRadius- mutator for radius
	 *
	 * @param rad A parameter
	 */
	// public void setRadius(int rad) {
	// this.radius = rad;
	// }

	/**
	 * Method getArea: This method should return a double corresponding to the area
	 * of the shape
	 * override the method from the parent class
	 * @param none
	 * @return The return value
	 */
	@Override // override the method from parent class
	public double getArea() {
		// return area
		double retVal = 0.0;
		retVal = this.area;
		return retVal;
	}

	/**
	 * setArea method- sets the area by using pi*r^2 formula
	 * @param none
	 * @return nothing
	 */
	public void setArea() {
		this.area = Math.PI * radius * radius;
	}

	/**
	 * setArea 
	 */
	//@Override
	//public void setArea(double a) {
	//	area = a;
	//}

	/**
	 * getShapeType method return the
	 * @param none
	 * @return String value
	 */
	public String getShapeType() {
		String retVal = "";
		retVal = "circle";
		//return circle
		return retVal;
	}

	/**
	 * Method draw- draws the shape
	 * override the method from the parent class
	 *
	 * @param drawing A parameter
	 * @return nothing
	 */
	@Override
	public void draw(Graphics drawing) {
		// draw shape
		Graphics2D draw2D = (Graphics2D) drawing;
		// set color of shape
		drawing.setColor(Color.pink);
		// draw circle
		draw2D.drawOval(getX(), getX(), radius, radius);
	}

	/**
	 * clone method returns a copy
	 * override the method from the parent class
	 * @param none
	 * @return Shape 
	 */
	@Override
	public Shape clone() {
		//return copy
		Shape retVal = new Circle(this);
		return retVal;
	}
}
