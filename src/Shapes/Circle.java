package Shapes;

public class Circle extends Shape {
	
	Circle (int a) {
		ar = a;
		area = shapeArea();
	}
	
	int shapeArea() {
		return (int) ((double)3.14 * (ar * ar));
	}
	
	public int compareTo(Shape shape){
		return super.compareTo(shape);
	}
}