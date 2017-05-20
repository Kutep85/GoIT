package Shapes;

abstract class Shape implements Comparable<Shape> {
	
	protected int area; 
	
	abstract int shapeArea();
	
	public int compareTo(Shape shape){
		return this.area - shape.area;
	}
}