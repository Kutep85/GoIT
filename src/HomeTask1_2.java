import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Evgeny.Kutepov on 21.04.2017.
 */
public class HomeTask1_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size:");
        int size = Integer.parseInt(reader.readLine());
        int[] a = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1) +":");
            a[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println("Do you need to find value?    Y/N");
        String s = reader.readLine();
        int b;
        if (s.equals("Y")||s.equals("y")) {
            System.out.println("Enter value:");
            b = Integer.parseInt(reader.readLine());
            find(b, a);
        }
        else if (s.equals("N")||s.equals("n")) {

        }

            System.out.println("Do you need to sort dimension?    Y/N");
            s = reader.readLine();
        if (s.equals("Y")||s.equals("y"))
                sort(a);
            else if (s.equals("N")||s.equals("n"))
                System.out.println("You didn't change anything.");

    }

    public static void find(int b, int[] a) throws IOException {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b){
                System.out.println("Value is " + (i + 1) + " element.");
                count++;
            }
        }
        if (count == 0)
            System.out.println("Value is not in dimension.");
    }

    public static void sort(int[] a) {

        int min;
        System.out.println("Sorted dimension: ");
        for (int j = 0; j < a.length - 1; j++) {
            min = a[j];
            for (int i = j + 1; i < a.length; i++) {
                if (a[i] < min){
                    min = a[i];
                    a[i] = a[j];
                    a[j] = min;
                }
            }
            System.out.print(a[j] + ", ");
            if (j == a.length - 2)
                System.out.println(a[j + 1] + ".");
        }
    }
}