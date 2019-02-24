package Other;

import FileHandling.FileReader;
import FileHandling.FileWriter;
import Other.Chunk;
import Other.Pizza;
import Other.Shape;
import Other.Slice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static int CHUNK_X = 20;
    public static int CHUNK_Y = 20;

    public static void main(String[] args) {
        FileReader.readFile();
        FileReader.readShapes();

        List<Slice> possibleSlices = getAllPossibleSlices();

        Pizza pizza = new Pizza();

        List<Chunk> chunks = new ArrayList<>();

        for (int iY_chunk = 0; iY_chunk < Pizza.Y / CHUNK_Y; iY_chunk++) {
            for (int iX_chunk = 0; iX_chunk < Pizza.X / CHUNK_X; iX_chunk++) {
                Chunk chunk = new Chunk(iY_chunk * CHUNK_Y, iX_chunk * CHUNK_X, (iY_chunk + 1) * CHUNK_Y, (iX_chunk + 1) * CHUNK_X);
                chunks.add(chunk);
            }
        }

        for (Chunk chunk : chunks) {
            chunk.calcPerfectOption();
            for (Slice slice : chunk.slices) {
                if (pizza.canAddSlice(slice)) {
                    pizza.addSlice(slice);
                }
            }
        }

//        for (Slice slice : possibleSlices) {
//            if (pizza.canAddSlice(slice)) {
//                pizza.addSlice(slice);
//            }
//        }

        FileWriter.writeFile(pizza.slices);
        System.out.println(pizza.calcScore());
    }

    public static List<Slice> getAllPossibleSlices() {
        List<Slice> possibleSlices = new ArrayList<>();

        List<Shape> shapes = FileReader.shapes;

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
