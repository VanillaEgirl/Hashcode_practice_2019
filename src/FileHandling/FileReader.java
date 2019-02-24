package FileHandling;

import Other.Pizza;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<String> readFile() {

        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(FilePath.inputPath));

            String rows = reader.readLine();
            String fractals[] = rows.split(" ");
            Pizza.Y = Integer.parseInt(fractals[0]);
            Pizza.X = Integer.parseInt(fractals[1]);
            Pizza.MIN_INGREDIENTS = Integer.parseInt(fractals[2]);
            Pizza.MAX_SIZE = Integer.parseInt(fractals[3]);

            for (int i = 0; i < Pizza.Y; i++) {
                rows = reader.readLine();
                lines.add(rows);
            }

            parseRows(lines);

            reader.close();

            return lines;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void parseRows(List<String> rows) {
        Pizza.map = new char[Pizza.Y][Pizza.X];

        int i=0;
        for(String row : rows) {
            char[] chars = row.toCharArray();
            System.arraycopy(chars, 0, Pizza.map[i], 0, chars.length);
            i++;
        }
    }
}
