package Shapes;

public class Square extends Shape {
	
	Square (int a) {
		ar = a;
		area = shapeArea();
	}
	
	int shapeArea() {
		return ar * ar;
	}
	
	public int compareTo(Shape shape){
		return super.compareTo(shape);
	}
}