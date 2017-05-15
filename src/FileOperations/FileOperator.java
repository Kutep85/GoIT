package FileOperations;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Evgeny.Kutepov on 14.05.2017.
 */
public class FileOperator {

    private String fileName;

    void fileWriter(String fileName) throws IOException{
        FileOutputStream fout = new FileOutputStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of words in file");
        int number = Integer.parseInt(reader.readLine());
        int line = 5;
        for (int i = 0; i < number; i++){
            int length = (int) (1 + Math.random() * 21);
            for (int j = 0; j < length; j++){
                char letter = (char) ((int) (97 + Math.random() * 26));
                fout.write(letter);
            }
            if (i == line){
                fout.write('\n');
                line += 6;
            }
            else
                fout.write(' ');

        }
        fout.close();
    }

    void fileReader(String fileName) throws IOException {
        FileInputStream fin = new FileInputStream(fileName);
        int i, countLines = 0;
        String fullLine = "";
        do {
            i = fin.read();
            if (i == -1){
                countLines++;
                System.out.println("LINE NUMBER " + countLines + ":");
                analize(fullLine);
            }
            if ((char) i != '\n')
                fullLine += (char) i;
                if ((char) i == '\n') {
                    countLines++;
                    System.out.println("LINE NUMBER " + countLines + ":");
                    analize(fullLine);
                    fullLine = "";
                }
            }
        while (i != -1);
        fin.close();
    }

    private void analize(String fullLine) {
        if (fullLine.equals(""))
            System.out.println("Line is empty.");
        else {
            String[] line = fullLine.split(" ");
            ArrayList<Integer> indexesLongest = new ArrayList<Integer>();
            ArrayList<Integer> indexesShortest = new ArrayList<Integer>();
            int longest = line[0].length(), shortest = line[0].length(), sum = 0, length = 0;
            for (int i = 0; i < line.length; i++) {
                if (line[i].length() > longest) {
                    longest = line[i].length();
                    indexesLongest = new ArrayList<Integer>();
                    indexesLongest.add(i);
                } else {
                    if (line[i].length() == longest)
                        indexesLongest.add(i);
                }

                if (line[i].length() < shortest) {
                    shortest = line[i].length();
                    indexesShortest = new ArrayList<Integer>();
                    indexesShortest.add(i);
                } else {
                    if (line[i].length() == shortest)
                        indexesShortest.add(i);
                }

                sum += line[i].length();
            }
            System.out.print("Longest word is: ");
            for (int i = 0; i < indexesLongest.size(); i++)
                if (i < indexesLongest.size() - 1) {
                    System.out.print(line[indexesLongest.get(i)] + ", ");
                } else {
                    System.out.println(line[indexesLongest.get(i)] + ".");
                    length = line[indexesLongest.get(i)].length();
                }
            System.out.println("Longest length is: " + length);
            System.out.print("Shortest word is: ");
            for (int i = 0; i < indexesShortest.size(); i++)
                if (i < indexesShortest.size() - 1) {
                    System.out.print(line[indexesShortest.get(i)] + ", ");
                } else {
                    System.out.println(line[indexesShortest.get(i)] + ".");
                    length = line[indexesShortest.get(i)].length();
                }
            System.out.println("Shortest length is: " + length);
            System.out.println("Line length is: " + fullLine.length() + ".");
            System.out.println("Average word length is: " + sum / line.length + ".\n");
        }
    }
}
