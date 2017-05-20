package Shapes;

public class Circle extends Shape {
	
	private int radius;
	
	Circle (int r) {
		radius = r;
		area = shapeArea();
	}
	
	int shapeArea() {
		return (int) (Math.PI * (radius * radius));
	}
	
	public int compareTo(Shape shape){
		return super.compareTo(shape);
	}
}