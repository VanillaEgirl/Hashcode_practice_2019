import FileHandling.FileHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> file = FileHandler.readFile();

        printStringList(file);
    }

    public static void printStringList(List<String> lines) {
        for(String line : lines) {
            System.out.println(line);
        }
    }
}
