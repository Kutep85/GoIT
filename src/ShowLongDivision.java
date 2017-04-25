import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Evgeny.Kutepov on 19.04.2017.
 */
public class ShowLongDivision {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter dividend");
        int dividend = Integer.parseInt(reader.readLine());
        System.out.println("Enter divider");
        int divider = Integer.parseInt(reader.readLine());


        String outputString = LongDivisionAsString(dividend, divider);
        System.out.println(outputString);
    }

    public static String LongDivisionAsString(int dividend, int divider) {

        if (dividend <= 0 | divider <= 0)
            return "divider or dividend less than zero";

        ArrayList<Integer> dvd = cutDigits(dividend);
        ArrayList<Integer> dvr = cutDigits(divider);
        ArrayList<Integer> result = cutDigits(dividend / divider);
        ArrayList<Integer> stream = new ArrayList<Integer>();
        ArrayList<Integer> fit = new ArrayList<Integer>();
        ArrayList<Integer> com = new ArrayList<Integer>();


        String s = dividend + "|" + divider + "\n";
        String s1 = "" + (result.get(0) * divider);
        int a = s1.length();
        for (int i = 0; i < dvd.size() - a; i++)
            s1 = s1 + " ";

        s1 = s1 + "+";
        int z;
        if (dvr.size() >= result.size())
            z = dvr.size();
        else
            z = result.size();
        for (int i = 0; i < z; i++)
            s1 = s1 + "-";
        s = s + s1 + "\n";

        s1 = "";

        stream = cutDigits(result.get(0) * divider);
        for (int i = 0; i < stream.size(); i++)
            s1 = s1 + "_";
        for (int i = 0; i < dvd.size() - stream.size(); i++)
            s1 = s1 + " ";
        s1 = s1 + "|" + (dividend / divider);
        s = s + s1 + "\n";

        String s2;
        s1 = "";

        int k = 0, count = 0, f = dvd.get(k), c;

        for (int i = 0; i < result.size(); i++) {
            while (f < divider) {
                k++;
                s2 = "" + f + dvd.get(k);
                f = Integer.parseInt(s2);
            }
            c = f - result.get(i) * divider;

            stream = cutDigits(result.get(i) * divider);
            fit = cutDigits(f);
            com = cutDigits(c);

            if (i > 0 & result.get(i) * divider != 0) {

                for (int j = 0; j < k - fit.size() + 1; j++)
                    s1 += " ";
                s1 += f + "\n";
                for (int j = 0; j < k - stream.size() + 1; j++)
                    s1 += " ";
                s1 += (result.get(i) * divider) + "\n";
                for (int j = 0; j < k - stream.size() + 1; j++)
                    s1 += " ";
                for (int j = 0; j < stream.size(); j++)
                    s1 += "_";
                s1 += "\n";

                if (i == result.size() - 1){
                    if (c == 0)
                        k -= 1;
                    for (int j = 0; j < k - com.size() + 1; j++)
                        s1 += " ";
                    s1 += c;
                }
            }

            f = c;

        }
        s += s1;
            return s;

    }

    public static ArrayList cutDigits(int a) {

        ArrayList<Integer> digits = new ArrayList<Integer>();
        int i = 1, j = a, k = j / i;

        while (k >= 1) {
            i = i * 10;
            digits.add(0, (j % i) / (i / 10));
            j = j - digits.get(0);
            k = j / i;
        }
        return digits;
    }

}
