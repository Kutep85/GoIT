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

    public int setElement(int j) throws IOException {
        return this.array[j] = Integer.parseInt(reader.readLine());
    }

    public void ArraySort() {

        System.out.println("Array: " + Arrays.toString(this.array));
        Arrays.sort(this.array);
        System.out.println("Sorted Array: " + Arrays.toString(this.array));
    }

    public void ArrayFind(int value) {

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

    public void PrintArray(int[] array) {

        System.out.println(Arrays.toString(this.array));
    }
}

