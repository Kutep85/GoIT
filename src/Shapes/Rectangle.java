package Shapes;

public class Rectangle extends Shape {
	
	Rectangle (int a, int b) {
		ar = a;
		br = b;
		area = shapeArea();
	}
	
	public int shapeArea() {
		return ar * br;
	}
	
	public int compareTo(Shape shape){
		return super.compareTo(shape);
	}
}
