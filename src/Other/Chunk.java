package Other;

import FileHandling.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Chunk {
    public int y1;
    public int x1;
    public int y2;
    public int x2;

    public List<Slice> slices = new ArrayList<>();
    public List<Slice> possibleSlices = new ArrayList<>();

    public Chunk() {

    }

    public Chunk(int y1, int x1, int y2, int x2) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;

        getPossibleSlices();
    }

    public int getHeight() {
        return y2 - y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public List<Slice> getPossibleSlices() {
        List<Slice> possibleSlices = new ArrayList<>();

        List<Shape> shapes = FileReader.shapes;

        for (Shape shape : shapes) {
            for (int i = 0; i <= getHeight() - shape.y; i++) {
                for (int j = 0; j <= getWidth() - shape.x; j++) {
                    Slice slice = new Slice(i, j, i + shape.y, j + shape.x);
                    if (slice.isValid()) {
                        possibleSlices.add(slice);
                    }
                }
            }
        }

        return possibleSlices;
    }
}
