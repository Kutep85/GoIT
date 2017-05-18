package Shapes;

import java.lang.Math;

public class Main {
	
	public static void main(String[] args) {
		Group group = new Group();
		Shape shape;
		for (int i = 0; i < 10; i++) {
			int m = (int) (1 + Math.random() * 10);
			for (int k = 0; k < m; k++){
				shape = new Rectangle((int) (1 + Math.random() * 10), (int) (1 + Math.random() * 10));
				group.add(shape);				
			}
			m = (int) (1 + Math.random() * 10);
			for (int k = 0; k < m; k++){
				shape = new Square((int) (1 + Math.random() * 10));
				group.add(shape);				
			}
			m = (int) (1 + Math.random() * 10);
			for (int k = 0; k < m; k++){
				shape = new Circle((int) (1 + Math.random() * 10));
				group.add(shape);				
			}	
		}
		System.out.println(group.toString());
		
		group.removeAll("class Shapes.Circle");
		System.out.println(group.toString());
	}

}
