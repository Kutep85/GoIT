package HT_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Evgeny.Kutepov on 25.04.2017.
 */
public class ConsoleHelper {

    public static ArrayHolder arr1;


    public static void menuStart() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What do you want:");
        System.out.println();
        System.out.println("1. Create array and fill.");
        System.out.println("2. Find element in created array.");
        System.out.println("3. Sort created array.");
        System.out.println("4. Close program.");
        System.out.println();

        String com = reader.readLine();
        afterFill(com);
    }

    private static ArrayHolder fillArray() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize;
        System.out.println("Enter size of array:");
        arraySize = Integer.parseInt(reader.readLine());
        arr1 = new ArrayHolder(arraySize);
        arr1.setArray(arraySize);
        System.out.println("Array created and filled");
        menuStart();
        return arr1;
    }

    private static void afterFill(String com) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        int value;

        switch (com) {

            case "1":
                fillArray();
                menuStart();
                break;

            case "2":
                if (arr1 == null) {
                    System.err.println("For continue, you need create and fill array.");
                    menuStart();
                } else {
                    System.out.println("Enter value: ");
                    value = Integer.parseInt(reader1.readLine());
                    arr1.arrayFind(value);
                    menuStart();
                }
                break;

            case "3":
                if (arr1 == null) {
                    System.err.println("For continue, you need create and fill array.");
                    menuStart();
                } else {
                    arr1.arraySort();
                    menuStart();
                }
                break;

            case "4":
                System.out.println("Programm was stopped");
                break;

            default:
                System.err.println("Wrong command, must be number from 1 till 4.");
                if (arr1 == null) {
                    System.err.println("For continue, you need create and fill array.");
                    menuStart();
                } else
                    menuStart();
                break;
        }
    }
}
