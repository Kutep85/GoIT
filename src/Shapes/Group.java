package Shapes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group extends ArrayList {
	
	private List<Shape> shapes;
	
	Group () {
		this.shapes = new ArrayList<Shape>();
	}
	
	public Shape get (int index) {
		return shapes.get(index);
	}
	
	public void add (Shape shape) {
		this.shapes.add(shape);
	}
	
	public void addAll (Group group) {
		shapes.addAll(group.shapes);
	}
	
	public void addAll (Group group, String shapeType) {
		for (int index = 0; index < group.shapes.size(); index++){
			if (group.shapes.get(index).getClass().equals(shapeType))
					this.shapes.add(group.shapes.get(index));
		}
	}
	
	public Shape remove (int index) {
		return this.shapes.remove(index);
	}
	
	public void removeAll(Group group) {
		this.shapes.removeAll(group.shapes);
	}
	
	public void removeAll(String shapeType) {
		for (int index = 0; index < this.shapes.size(); index++) {
			if (this.shapes.get(index).getClass().toString().equals(shapeType)){
				this.shapes.remove(index);
				index--;
			}
		}
	}
	
	public boolean isEmpty() {
		return this.shapes.size() == 0;
	}
	
	public int size() {
		return this.shapes.size();
	}
	
	
	public void clear() {
		this.shapes.clear();
	}
	
	public ArrayList<Integer> getMaxArea() {
		ArrayList<Integer> indexes = new ArrayList<>();
		Shape max = this.shapes.get(0);
		for (int index = 0; index < this.shapes.size(); index++) {
			if (max.compareTo(this.shapes.get(index)) < 0) {
				max = this.shapes.get(index);
				indexes.clear();
				indexes.add(index);
			}
			else
			if (max.compareTo(this.shapes.get(index)) == 0) {
					indexes.add(index);
			}
		}
		return indexes;
	}
	
	public ArrayList<Integer> getMinArea() {
		ArrayList<Integer> indexes = new ArrayList<>();
		Shape min = this.shapes.get(0);
		for (int index = 0; index < this.shapes.size(); index++) {
			if (min.compareTo(this.shapes.get(index)) > 0) {
				min = this.shapes.get(index);
				indexes.clear();
				indexes.add(index);
			}
			else
			if (min.compareTo(this.shapes.get(index)) == 0) {
					indexes.add(index);
			}
		}
		return indexes;
	}
	
	public int sumArea() {
		int sum = 0;
		for (int index = 0; index < this.shapes.size(); index++) {
			sum += this.shapes.get(index).area;
		}
		return sum;
	}
	
	public String toString() {
		String string = "";
		for (int index = 0; index < this.shapes.size(); index++)
		string += "Shape ¹" + (index + 1) + 
				"\nType: " + this.shapes.get(index).getClass() + 
				"\nArea is: " + this.shapes.get(index).area + "\n\n";
		return string;
	}
	
	public Map <String, Group> getShapesSeparatedByType () {
		Map<String, Group>shapesSeparatedByClass = new HashMap<String, Group>();
		Group rectangle = new Group();
		Group square = new Group();
		Group circle = new Group();
		for (int index = 0; index < this.shapes.size(); index++) {
			switch (this.shapes.get(index).getClass().toString()) {
				case "class Shapes.Rectangle":
					rectangle.add(this.shapes.get(index));
					break;
				case "class Shapes.Square":
					square.add(this.shapes.get(index));
					break;
				case "class Shapes.Circle":
					circle.add(this.shapes.get(index));
					break;
			}
		}
		if (rectangle.isEmpty() == false)
			shapesSeparatedByClass.put("Rectangle", rectangle);
		if (square.isEmpty() == false)
			shapesSeparatedByClass.put("Square", square);
		if (circle.isEmpty() == false)
			shapesSeparatedByClass.put("Circle", circle);
		return shapesSeparatedByClass;
	}
}
