package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<String> readFile() {

        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath.path));

            String line = reader.readLine();
            while (line != null && !line.isEmpty()) {
                lines.add(line);
                line = reader.readLine();
            }

            reader.close();

            return lines;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
