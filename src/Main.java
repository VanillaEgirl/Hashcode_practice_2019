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

        List<Slice> possibleSlices = getPossibleSlices();

        int i = 0;
        for (Slice slice : possibleSlices) {
            if (pizza.canAddSlice(slice)) {
                pizza.addSlice(slice);
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
                    if (slice.isValid()) {
                        possibleSlices.add(slice);
                    }
                }
            }
        }

        System.out.println(possibleSlices.size() + " Slices generated");

        return possibleSlices;
    }
}
