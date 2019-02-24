package FileHandling;

import Other.Ingredient;
import Other.Pizza;
import Other.Shape;

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

    public static List<Shape> readShapes() {

        List<Shape> shapes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(FilePath.possibilitiesPath));

            String line = reader.readLine();

            while (line != null && !line.isEmpty()) {
                Shape shape = new Shape();

                String fractals[] = line.split(" ");
                shape.y = Integer.parseInt(fractals[0]);
                shape.x = Integer.parseInt(fractals[1]);

                shapes.add(shape);

                line = reader.readLine();
            }

            reader.close();

            return shapes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void parseRows(List<String> rows) {
        Pizza.map = new Ingredient[Pizza.Y][Pizza.X];

        int i = 0;
        for (String row : rows) {
            char[] chars = row.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                Ingredient ingredient;
                if (chars[j] == Ingredient.TOMATO.signifier) {
                    ingredient = Ingredient.TOMATO;
                } else {
                    ingredient = Ingredient.MUSHROOM;
                }

                Pizza.map[i][j] = ingredient;
            }
            i++;
        }
    }
}
