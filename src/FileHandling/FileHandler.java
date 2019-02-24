package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static String DIR = "C:\\Users\\Thomas\\Downloads\\";
    private static String FILE = "test";
    private static String EXT = ".txt";
    private static String filePath = DIR + FILE + EXT;

    public static List<String> readFile() {

        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line = " ";
            while (!line.isEmpty()) {
                line = reader.readLine();
                lines.add(line);
                System.out.println(line);
            }

            reader.close();

            return lines;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read file.");
            e.printStackTrace();
            return null;
        }
    }
}
