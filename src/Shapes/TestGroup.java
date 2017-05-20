package Shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Map;

public class TestGroup {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private Group group;
	
	TestGroup() throws IOException {
		group = new Group();
		Shape shape;
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < (int) (1 + Math.random() * 10); k++){
				shape = new Rectangle((int) (1 + Math.random() * 200), (int) (1 + Math.random() * 200));
				group.add(shape);				
			}
			for (int k = 0; k < (int) (1 + Math.random() * 10); k++){
				shape = new Square((int) (1 + Math.random() * 200));
				group.add(shape);				
			}
			for (int k = 0; k < (int) (1 + Math.random() * 10); k++){
				shape = new Circle((int) (1 + Math.random() * 200));
				group.add(shape);				
			}	
		}
		System.out.println(group.toString());
	}

	void menu() throws IOException{
		System.out.println("1. Add shape\n"
				+ "2. Add group of shapes\n"
				+ "3. Remove shape by index\n"
				+ "4. Remove group of shapes\n"
				+ "5. Remove type of shapes\n"
				+ "6. Find max area\n"
				+ "7. Find min area\n"
				+ "8. Calculate sum area of all shapes\n"
				+ "9. Separate group by shapes\n"
				+ "10. Clear group\n"
				+ "11. Print group\n"
				+ "0. Stop programm");
		System.out.println("Enter command for menu:");
		String command = reader.readLine();
		menuLogic(command);
	}
	
	void menuLogic(String command) throws IOException{
		try {
			switch (command) {
				case "1":
					System.out.println("What type of shape do you want to add:\n"
							+ "1. Rectangle\n"
							+ "2. Square\n"
							+ "3. Circle\n");
							String type = reader.readLine();
							switch (type) {
								case "1":
									Shape rectngle = new Rectangle((int) (1 + Math.random() * 200), (int) (1 + Math.random() * 200));
									group.add(rectngle);
									break;
								case "2":
									Shape square = new Square((int) (1 + Math.random() * 200));
									group.add(square);
									break;
								case "3":
									Shape circle = new Circle((int) (1 + Math.random() * 200));
									group.add(circle);
									break;
								default :
									System.err.println("Enter number from 1 till 3!!!!");
									menuLogic("1");
									break;
							}
							System.out.println(group.toString());
							System.err.println("SHAPE ADDED!");
							menu();
							break;
				case "2":
					TestGroup group1 = new TestGroup();
					group.addAll(group1.group);
					System.out.println(group.toString());
					System.err.println("GROUP ADDED!");
					menu();
					break;
				case "3":
					System.out.println("Enter index of shape:");
					int index = Integer.parseInt(reader.readLine()) - 1;
					group.remove(index);
					System.out.println(group.toString());
					System.err.println("SHAPE " + group.get(index).getClass() + " WAS DELETED");
					menu();
					break;
				case "4":
					Group group2 = new Group();
					for (int i = 10; i < 50; i++)
						group2.add(group.get(i + 10));
					group.removeAll(group2);
					System.out.println(group.toString());
					System.err.println("GROUP DELETED!");
					menu();
					break;
				case "5":
					System.out.println("What type of shape do you want to remove:\n"
							+ "1. Rectangle\n"
							+ "2. Square\n"
							+ "3. Circle\n");
							String typeRemove = reader.readLine();
							switch (typeRemove) {
							case "1":
								group.removeAll("class Shapes.Rectangle");
								System.out.println(group.toString());
								System.err.println("ALL RECTANGLES DELETED!!");
								break;
							case "2":
								group.removeAll("class Shapes.Square");
								System.out.println(group.toString());
								System.err.println("ALL SQUARES DELETED!!");
								break;
							case "3":
								group.removeAll("class Shapes.Circle");
								System.out.println(group.toString());
								System.err.println("ALL CIRCLES DELETED!!");
								break;
							default :
								System.err.println("Enter number from 1 till 3!!!!");
								menuLogic("5");
								break;
						}
						menu();
						break;
				case "6":
					ArrayList<Integer> max = group.getMaxArea();
					System.err.println("The shape with max area have index:");
					for (int i = 0; i < max.size(); i++)
						System.err.println((max.get(i) + 1) + " area is: " + group.get(max.get(i)).area);
					menu();
					break;
				case "7":
					ArrayList<Integer> min = group.getMinArea();
					System.err.println("The shape with min area have index:");
					for (int i = 0; i < min.size(); i++)
						System.err.println((min.get(i) + 1) + " area is: " + group.get(min.get(i)).area);
					menu();
					break;
				case "8":
					System.out.println("The sum of all areas is: " + group.sumArea());
					menu();
					break;
				case "9":
					Map<String, Group> map = group.getShapesSeparatedByType();
					System.out.println("What type of shapes do you want to see:\n"
							+ "1. Rectangle\n"
							+ "2. Square\n"
							+ "3. Circle\n");
							String mapReader = reader.readLine();
							switch (mapReader) {
							case "1":
								System.out.println(map.get("Rectangle").toString());
								break;
							case "2":
								System.out.println(map.get("Square").toString());
								break;
							case "3":
								System.out.println(map.get("Circle").toString());
								break;
							default :
								System.err.println("Enter number from 1 till 3!!!!");
								menuLogic("5");
								break;
						}
						menu();
						break;
				case "10":
					group.clear();
					System.err.println("GROUP CLEARED!");
					System.out.println("Do you want to create new group?   Y/N");
					String gr = reader.readLine();
						switch(gr) {
							case "Y":
								TestGroup testY = new TestGroup();
								menu();
								break;
							case "y":
								TestGroup testy = new TestGroup();
								menu();
								break;
							case "N":
								menuLogic("0");
								break;
							case "n":
								menuLogic("0");
								break;
							default:
								System.out.println("Enter Y or N");
								menuLogic("10");
								break;
							}
					break;
				case "11":
					System.out.println(group.toString());
					menu();
					break;
				case "0":
					System.err.println("PROGRAMM STOPPED!");
					return;
				default:
					System.err.println("Enter number from 1 till 10!!!!");
					menu();
					break;
			}
		}
        catch (NumberFormatException e) {
            System.err.println("VALUE IS NOT INTEGER!!!");
            menu();
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("NUMBER MORE THAN COLLECTIONS SIZE!!!");
            menu();
        }
	}
}
