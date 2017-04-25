package HT_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Evgeny.Kutepov on 25.04.2017.
 */
public class ConsoleHelper {

    public static int corr;
    public static ArrayHolder arr1;


    public static void menuStart() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (corr == 0 || corr > 1) {
            System.out.println("What do you want:");
            System.out.println();
            System.out.println("1. Create array and fill.");
            System.out.println("2. Find element in created array.");
            System.out.println("3. Sort created array.");
            System.out.println("4. Close program.");
            System.out.println();
        }

        if (corr == 1){
            arr1 = MenuLogic();
            System.out.println("What do you want:");
            System.out.println();
            System.out.println("1. Create array and fill.");
            System.out.println("2. Find element in creted array.");
            System.out.println("3. Sort created array.");
            System.out.println("4. Close program.");
            System.out.println();
            int com1 = Integer.parseInt(reader.readLine());
            AfterFill(com1);
        }
        if (corr > 1) {
            int com1 = Integer.parseInt(reader.readLine());
            corr = com1;
            AfterFill(com1);
            menuStart();
        }
        DefineCom();
    }

    private static void DefineCom() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(reader.readLine());
        if (com != 1) {

            if (com > 1 & com < 4) {
                System.err.println("For continue, you need create and fill array.");
                corr = com;
                menuStart();
            }
            if (com > 4) {
                AfterFill(com);
                com = corr = 0;
                menuStart();
        }
        AfterFill(com);
        }
        if (com == 1)
        {
            corr = com;
            menuStart();
        }

    }

    private static ArrayHolder MenuLogic() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize;
        System.out.println("Enter size of array:");
        arraySize = Integer.parseInt(reader.readLine());
        arr1 = new ArrayHolder(arraySize);

        for (int j = 0; j < arraySize; j++) {
            System.out.println("Enter element " + (j + 1));
            arr1.setElement(j);
        }
        System.out.println("Array created and filled");
        return arr1;
    }

    private static void AfterFill(int com1) throws IOException{
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        int value;
        if (com1 == 1) {
            corr = com1;
            MenuLogic();
        }
        corr = com1;

            switch (com1) {

                case 2:
                    System.out.println("Enter value: ");
                        value = Integer.parseInt(reader1.readLine());
                        arr1.ArrayFind(value);
                        menuStart();
                        break;

                case 3:
                        arr1.ArraySort();
                        menuStart();
                        break;

                case 4:
                    System.out.println("Program was stopped");
                    corr = -1;
                    break;

                default:
                    System.err.println("Wrong command, number must be from 1 till 4.");
                    menuStart();
                    break;
            }
        }
    }
