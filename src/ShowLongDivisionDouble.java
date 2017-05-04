import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Evgeny.Kutepov on 19.04.2017.
 */
public class ShowLongDivisionDouble {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter dividend");
        double divD = Double.parseDouble(reader.readLine());
        System.out.println("Enter divider");
        double divR = Double.parseDouble(reader.readLine());



        String outputString = LongDivisionAsString(divD, divR);
        System.out.println(outputString);
      }

    public static String LongDivisionAsString(double divD, double divR) {

        if (divD <= 0 | divR <= 0)
            return "divider or dividend less than zero";

        Transformation dividend = new Transformation(divD);
        Transformation divider = new Transformation(divR);
        Transformation result = new Transformation(divD / divR);
        Transformation stream = new Transformation(result.arrayDigits.get(0) * divR);
        Transformation fit;
        Transformation com;

/*
        ArrayList<Integer> dvd = cutDigits(dividend);
        ArrayList<Integer> dvr = cutDigits(divider);
        ArrayList<Integer> result = ListUtils.union(cutDigits(dividend / divider), cutDigitsAfterPoint(dividend / divider));
        ArrayList<Integer> stream = new ArrayList<Integer>();
        ArrayList<Integer> fit = new ArrayList<Integer>();
        ArrayList<Integer> com = new ArrayList<Integer>();
*/


        String s;
        if (dividend.number.length() > stream.number.length())
            s = dividend.number + "|" + divider.number + "\n";
        else{
            s = dividend.number;
            for (int i = 0; i < stream.number.length() - dividend.number.length(); i++) {
                s += " ";
            }
            s += "|" + divider.number + "\n";
        }

        String s1 = stream.number;
        for (int i = 0; i < dividend.number.length() - stream.number.length(); i++)
            s1 += " ";
        s1 += "+";
        int z;
        if (divider.number.length() >= result.number.length())
            z = divider.number.length();
        else
            z = result.number.length();
        for (int i = 0; i < z; i++)
            s1 = s1 + "-";
        s = s + s1 + "\n";

        s1 = "";

        for (int i = 0; i < stream.number.length(); i++)
            s1 = s1 + "_";
        for (int i = 0; i < dividend.number.length() - stream.number.length(); i++)
            s1 = s1 + " ";
        s1 = s1 + "|" + (result.number);
        s = s + s1 + "\n";

// ********************    HERE EVERYTHING IS OK    ********************

        String s2;
        s1 = "";

        int k = 0;
        double c, f = dividend.arrayDigits.get(k);

        for (int i = 0; i < result.arrayDigits.size(); i++) {
            while (f < divR & k < dividend.arrayDigits.size() - 1) {
                k++;
                s2 = "" + f + dividend.arrayDigits.get(k);
                f = Double.parseDouble(s2);
            }
            c = f - result.arrayDigits.get(i) * divR;

            stream = new Transformation(result.arrayDigits.get(i) * divR);
            fit = new Transformation(f);
            com = new Transformation(c);

            if (i > 0 & result.arrayDigits.get(i) * divR != 0) {

                for (int j = 0; j < k - fit.number.length() + 1; j++)
                    s1 += " ";
                s1 += f + "\n";
                for (int j = 0; j < k - stream.number.length() + 1; j++)
                    s1 += " ";
                s1 += (result.arrayDigits.get(i) * divR) + "\n";
                for (int j = 0; j < k - stream.number.length() + 1; j++)
                    s1 += " ";
                for (int j = 0; j < stream.number.length(); j++)
                    s1 += "_";
                s1 += "\n";

                if (i == result.number.length() - 1){
                    if (c == 0)
                        k -= 1;
                    for (int j = 0; j < k - com.number.length() + 1; j++)
                        s1 += " ";
                    s1 += c;
                }
            }

            f = c;

        }


        s += s1;
        return s;

    }

}