package CrossesAndZeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Evgeny.Kutepov on 07.05.2017.
 */
public class GameLogic {

    void start() throws IOException {

        Field field = new Field();
        playing(field);
    }

    void playing (Field field) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9;) {
            try {
            if (i % 2 == 0) {
                System.out.println("MAKE YOUR STEP");
                int step = Integer.parseInt(reader.readLine());
                if (step >= 1 & step <= 9 && field.getPlayProcess()[step - 1] == " ") {
                    field.getPlayProcess()[step - 1] = "X";
                    if (i >= 3) {
                        if (winner(field.getPlayProcess(), "X")) {
                            field.fieldFill();
                            System.out.println("======= YOU WON =======");
                            break;
                        }
                    }
                    i++;
                } else {
                    System.err.println("WRONG VALUE. STEP MUST BE NUMBER FROM 1 TILL 9, OR POSITION IS USED");
                    field.fieldFill();
                }
            }

            if (i % 2 != 0) {
                int stepcomp;
                if (artifIntel(field.getPlayProcess()) == -1) {
                    stepcomp = (int) (1 + Math.random() * 8);
                    while (field.getPlayProcess()[stepcomp] != " ") {
                        stepcomp = (int) (1 + Math.random() * 8);
                    }
                }
                else
                 stepcomp = artifIntel(field.getPlayProcess());
                field.getPlayProcess()[stepcomp] = "0";
                field.fieldFill();
                if (i >= 3) {
                    if (winner(field.getPlayProcess(), "0")) {
                        System.out.println("======= COMPUTER WINS =======");
                        break;
                    }
                }
                i++;
            }
        }
        catch (NumberFormatException e) {
            System.err.println("IS NOT INTEGER!!!");
            field.fieldFill();
        }
        if (i == 8 & !winner(field.getPlayProcess(), "X") & !winner(field.getPlayProcess(), "0")) {
            System.out.println("======== DEAD HEAD ========");
            break;
            }
        }
    }


    private boolean winner(String[] playProcess, String mark) {

        for (int i = 0; i < 9; i += 3) {
            if (playProcess[i].equals(playProcess[i + 1]) & playProcess[i + 1].equals(playProcess[i + 2]) &
                    playProcess[i].equals(mark)) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++){
            if (playProcess[i].equals(playProcess[i + 3]) & playProcess[i + 3].equals(playProcess[i + 6]) &
                    playProcess[i].equals(mark)) {
                return true;
            }
        }

        if (playProcess[0].equals(playProcess[4]) & playProcess[4].equals(playProcess[8]) & playProcess[0].equals(mark))
        {
            return true;
        }

        if (playProcess[2].equals(playProcess[4]) & playProcess[4].equals(playProcess[6]) & playProcess[2].equals(mark))
        {
            return true;
        }
        return false;
    }


    private int artifIntel(String[] field) {

        int countX = 0, count0 = 0, countSpace = 0, indexSpace = -1, indexForWin = -1, indexForBreak = -1;
        for (int i = 0; i < 3; i++) {
            for (int j =  i; j < 9; j += 3) {
                if (field[j].equals("X")) countX++;
                if (field[j].equals("0")) count0++;
                if (field[j].equals(" ")) {
                    countSpace++;
                    indexSpace = j;
                }
            }
            if (count0 == 2 & countSpace == 1) {
                indexForWin = indexSpace;
            }
            if (countX == 2 & countSpace == 1)
                indexForBreak = indexSpace;

                countSpace = indexSpace = count0 = countX = 0;
        }

        if (indexForWin != -1) return indexForWin;
        if (indexForBreak != -1) return indexForBreak;
        indexForWin = indexForBreak = -1;

        for (int i = 0; i < 9; i += 3) {
            for (int j = i; j < i + 3; j++) {
                if (field[j].equals("X")) countX++;
                if (field[j].equals("0")) count0++;
                if (field[j].equals(" ")) {
                    countSpace++;
                    indexSpace = j;
                }
            }
            if (count0 == 2 & countSpace == 1) {
                indexForWin = indexSpace;
            }
            if (countX == 2 & countSpace == 1)
                indexForBreak = indexSpace;


            countSpace = indexSpace = count0 = countX = 0;
        }
        if (indexForWin != -1) return indexForWin;
        if (indexForBreak != -1) return indexForBreak;
        indexForWin = indexForBreak = -1;

        for (int i = 0; i < 9; i += 4) {
            if (field[i].equals("X")) countX++;
            if (field[i].equals("0")) count0++;
            if (field[i].equals(" ")) {
                countSpace++;
                indexSpace = i;
            }
            if (count0 == 2 & countSpace == 1) {
                indexForWin = indexSpace;
            }
            if (countX == 2 & countSpace == 1)
                indexForBreak = indexSpace;

        }
        countSpace = indexSpace = count0 = countX = 0;
        if (indexForWin != -1) return indexForWin;
        if (indexForBreak != -1) return indexForBreak;
        indexForWin = indexForBreak = -1;

        for (int i = 2; i < 8; i += 2) {
            if (field[i].equals("X")) countX++;
            if (field[i].equals("0")) count0++;
            if (field[i].equals(" ")) {
                countSpace++;
                indexSpace = i;
            }
            if (count0 == 2 & countSpace == 1) {
                indexForWin = indexSpace;
            }
            if (countX == 2 & countSpace == 1)
                indexForBreak = indexSpace;

        }
        if (indexForWin != -1) return indexForWin;
        if (indexForBreak != -1) return indexForBreak;

        return -1;
    }
}
