import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Evgeny.Kutepov on 16.04.2017.
 */
public class HomeTask_01_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[5];
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter number " + i + ":");
            a[i - 1] = Integer.parseInt(reader.readLine());
        }

        System.out.print("Initial array: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(a[i]);
            if (i < 4)
                System.out.print(", ");
        }
        System.out.println();

        sort(a);
        System.out.print("Sorted array: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(a[i]);
                if (i < 4)
                    System.out.print(", ");
                else
                    System.out.println(".");
        }
    }

    public static void sort (int[] a) {
        int min;
        for (int j = 0; j < a.length - 1; j++) {
            min = a[j];
            for (int i = j + 1; i < a.length; i++) {
                if (a[i] < min){
                    min = a[i];
                    a[i] = a[j];
                    a[j] = min;
                }
             }
        }
    }
}
