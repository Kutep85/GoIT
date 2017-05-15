package FileOperations;

import java.io.IOException;

/**
 * Created by Evgeny.Kutepov on 14.05.2017.
 */
public class FileRunner {

    public static void main(String[] args) throws IOException {
        FileOperator operator = new FileOperator();
        operator.fileWriter("Example.txt");
        operator.fileReader("Example.txt");
    }
}
