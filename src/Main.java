import FileHandling.FileReader;
import Other.Pizza;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> file = FileReader.readFile();

        Pizza.print();
    }

    public static void printStringList(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
