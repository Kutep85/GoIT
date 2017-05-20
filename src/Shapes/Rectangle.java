package Shapes;

public class Rectangle extends Shape {
	
	private int length;
	private int height;
	
	Rectangle (int l, int h) {
		length = l;
		height = h;
		area = shapeArea();
	}
	
	@Override
	public int shapeArea() {
		return length * height;
	}
	
	public int compareTo(Shape shape){
		return super.compareTo(shape);
	}
}
