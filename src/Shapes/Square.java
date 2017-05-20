package Shapes;

public class Square extends Shape {
	
	private int side;
	
	Square (int s) {
		side = s;
		area = shapeArea();
	}
	
	int shapeArea() {
		return side * side;
	}
	
	public int compareTo(Shape shape){
		return super.compareTo(shape);
	}
}