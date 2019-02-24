import FileHandling.FileReader;
import Other.Pizza;
import Other.Slice;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FileReader.readFile();

        Random random = new Random();

        int randX = random.nextInt();

        Pizza.print();
    }
}
