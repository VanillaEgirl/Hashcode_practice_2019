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
        boolean active = true;

        List<Slice> possibleSlices = getPossibleSlices();

        int invalidCounter = 0;
        while (active) {
            int randomSliceIndex = random.nextInt(possibleSlices.size());

            Slice randomSlice = possibleSlices.get(randomSliceIndex);

            temp_pizza.slices.add(randomSlice);

            if (temp_pizza.isValid()) {
                pizza.slices.add(randomSlice);
                invalidCounter = 0;
            } else {
                invalidCounter++;
            }

            if(invalidCounter>10) {
                active = false;
            }
        }

        FileWriter.writeFile(pizza.slices);
    }

    public static List<Slice> getPossibleSlices() {
        List<Slice> possibleSlices = new ArrayList<>();

        List<Shape> shapes = FileReader.readShapes();

        for (Shape shape : shapes) {
            for (int i = 0; i < Pizza.Y / shape.y; i++) {
                for (int j = 0; j < Pizza.X / shape.x; j++) {
                    Slice slice = new Slice(shape.y * i, shape.x * j, shape.y * (i + 1), shape.x * (j + 1));
                    if (slice.isValid()) {
                        possibleSlices.add(slice);
                    }
                }
            }
        }

        return possibleSlices;
    }
}
