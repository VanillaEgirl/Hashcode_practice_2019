package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<String> readFile() {

        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath.path));

            String line = " ";
            while (!line.isEmpty()) {
                line = reader.readLine();
                lines.add(line);
                System.out.println(line);
            }

            reader.close();

            return lines;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
