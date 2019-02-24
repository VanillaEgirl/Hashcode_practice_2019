import FileHandling.FileReader;
import FileHandling.FileWriter;
import Other.Pizza;
import Other.Shape;
import Other.Slice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        FileReader.readFile();

        Pizza pizza = new Pizza();
        Pizza temp_pizza = new Pizza();

        List<Slice> possibleSlices = getPossibleSlices();

        int i = 0;
        for (Slice slice : possibleSlices) {
            temp_pizza.slices.add(slice);

            if (temp_pizza.isValid()) {
                pizza.slices.add(slice);
            } else {
                temp_pizza.slices.remove(slice);
            }

            i++;
            if (i % 10000 == 0) {
                System.out.println(i);
            }
        }

        FileWriter.writeFile(pizza.slices);
    }

    public static List<Slice> getPossibleSlices() {
        List<Slice> possibleSlices = new ArrayList<>();

        List<Shape> shapes = FileReader.readShapes();

        for (Shape shape : shapes) {
            for (int i = 0; i <= Pizza.Y - shape.y; i++) {
                for (int j = 0; j <= Pizza.X - shape.x; j++) {
                    Slice slice = new Slice(i, j, i + shape.y, j + shape.x);
                    if (slice.isValid() && !listContainsSlice(possibleSlices, slice)) {
                        possibleSlices.add(slice);
                    }
                }
            }
        }

        System.out.println(possibleSlices.size() + " Slices generated");

        return possibleSlices;
    }

    public static boolean listContainsSlice(List<Slice> slices, Slice sliceInQuestion) {
        for (Slice slice : slices) {
            if (slice.x1 <= sliceInQuestion.x1 && slice.y1 <= sliceInQuestion.y1 && slice.x2 >= sliceInQuestion.x2 && slice.y2 >= sliceInQuestion.y2) {
                return true;
            }
        }

        return false;
    }
}
