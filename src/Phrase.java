import java.util.ArrayList;

/**
 * Created by Evgeny.Kutepov on 19.04.2017.
 */
public class Phrase {

    public static void main(String[] args) {

        String phrase = "aBB1d2ef  ab34cde5fgh  a6b7cd8e";
        String[] rows = phrase.split("  ");
        int a = rows.length;
        char [][] arr = new char [a][];
        phrase = "";

        for (int i = 0; i < a; i++) {
            ArrayList<Character> symbol = new ArrayList<Character>();
            arr[i] = rows[i].toCharArray();

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 48 || arr[i][j] > 57)
                    symbol.add(arr[i][j]);
            }

                int cnt = 0;

                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] < 48 || arr[i][j] > 57) {
                        cnt++;
                        arr[i][j] = symbol.get(symbol.size() - cnt);
                    }
                    phrase = phrase + arr[i][j];
                }

                if (i < a - 1)
                phrase = phrase + "  ";
            }
        System.out.println(phrase);
        }
    }

