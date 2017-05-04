import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Evgeny.Kutepov on 29.04.2017.
 */
public class Transformation {

    ArrayList<Byte> arrayDigits;
    ArrayList<Byte> arrayDigitsAfterPoint;
    String number = "";

    public Transformation (double number1) {
        arrayDigits = cutDigits(number1);
        arrayDigitsAfterPoint = cutDigitsAfterPoint(number1);
        for (int i = 0; i < arrayDigits.size(); i++)
            number += arrayDigits.get(i);
        number +=".";
        for (int i = 0; i < arrayDigitsAfterPoint.size(); i++)
            number += arrayDigitsAfterPoint.get(i);
    }

 /*   public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double a = Double.parseDouble(reader.readLine());
        System.out.println(cutDigits(a).toString() + "." + cutDigitsAfterPoint(a).toString());
    }*/


    public static ArrayList cutDigits(double ars) {

        int a = (int) ars;
        ArrayList<Byte> digits = new ArrayList<Byte>();
        if (a == 0)
            digits.add(0,(byte)0);
        int i = 1, j = a, k = j / i;

        while (k >= 1) {
            i = i * 10;
            digits.add(0, (byte)((j % i) / (i / 10)));
            j = j - digits.get(0);
            k = j / i;
        }
        return digits;
    }

    public static ArrayList cutDigitsAfterPoint(double boo) {

        ArrayList<Byte> digitsAfterPoint = new ArrayList<Byte>();
        int abs = (int) boo;
        if (boo - abs == 0){
            digitsAfterPoint.add(0, (byte)0);
        return digitsAfterPoint;
        }
        double koo = 1 + (boo - abs);
        long koop = (long) (koo * 100_000_000_000L);
        long a = (long) koop;
        long i = 10;
        long j = a, k = j / i;

        while (k >= 1) {
            i = i * 10;
            digitsAfterPoint.add(0, (byte)((j % i) / (i / 10)));
            j -= digitsAfterPoint.get(0);
            k = j / i;
        }
        digitsAfterPoint.remove(0);
        digitsAfterPoint = trimToSize0(digitsAfterPoint);
        return digitsAfterPoint;
    }

    public static ArrayList trimToSize0(ArrayList<Byte> digitsAfterPoint) {
        int count = 0;
        for (int i = digitsAfterPoint.size() - 1; i >= 0; i--) {
            if (digitsAfterPoint.get(i) == 0 & count == 0)
                digitsAfterPoint.remove(i);
            else
                count++;

        }
        if (digitsAfterPoint.isEmpty())
            digitsAfterPoint.add(0, (byte)0);
        return digitsAfterPoint;
    }
}
