package HT_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Evgeny.Kutepov on 25.04.2017.
 */
public class ArrayHolder {

    private int[] array;
    private int arraySize;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ArrayHolder(int arraySize) {

        this.arraySize = arraySize;
        this.array = new int[arraySize];


    }

    public int[] setArray(int arraySize) throws IOException {
        for (int j = 0; j < arraySize; j++) {
            System.out.println("Enter element " + (j + 1));
            array[j] = Integer.parseInt(reader.readLine());
        }
        return array;
    }

    public void arraySort() {

        System.out.println("Array: " + Arrays.toString(this.array));
        Arrays.sort(this.array);
        System.out.println("Sorted Array: " + Arrays.toString(this.array));
    }

    public void arrayFind(int value) {

        int count = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == value) {
                System.out.println("Value found:");
                System.out.println("Value is " + (i + 1) + " element.");
                System.out.println();
                count++;
            }
        }
        if (count == 0)
            System.out.println("Value is not found.");
    }

    public void printArray(int[] array) {

        System.out.println(Arrays.toString(this.array));
    }
}

