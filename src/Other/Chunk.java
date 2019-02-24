package Other;

import FileHandling.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Chunk {
    public int highscore = 0;

    public int y1;
    public int x1;
    public int y2;
    public int x2;

    public List<Slice> slices = new ArrayList<>();
    public List<Slice> possibleSlices = new ArrayList<>();
    private boolean[][] takenCells;

    public Chunk() {

    }

    public Chunk(Chunk objectToCopy) {
        this.y1 = objectToCopy.y1;
        this.x1 = objectToCopy.x1;
        this.y2 = objectToCopy.y2;
        this.x2 = objectToCopy.x2;
        this.slices.addAll(objectToCopy.slices);
        this.takenCells = new boolean[Main.CHUNK_Y][Main.CHUNK_X];
        System.arraycopy(objectToCopy.takenCells, 0, this.takenCells, 0, objectToCopy.takenCells.length);
    }

    public Chunk(int y1, int x1, int y2, int x2) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;

        takenCells = new boolean[Main.CHUNK_Y][Main.CHUNK_X];

        for (int i = 0; i < Main.CHUNK_Y; i++) {
            for (int j = 0; j < Main.CHUNK_X; j++) {
                takenCells[i][j] = false;
            }
        }
    }

    public int calcScore() {
        int score = 0;

        for (Slice slice : slices) {
            score += slice.calcSize();
        }

        return score;
    }

    public void addSlice(Slice slice) {
        slices.add(slice);
        writeTakenCells(slice);
    }

    public boolean canAddSlice(Slice slice) {
        for (int i = 0; i < slice.getHeight(); i++) {
            for (int j = 0; j < slice.getLength(); j++) {
                if (takenCells[slice.y1 + i][slice.x1 + j]) {
                    return false;
                }
            }
        }

        return true;
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

    private boolean writeTakenCells(Slice slice) {
        for (int i = 0; i < slice.getHeight(); i++) {
            for (int j = 0; j < slice.getLength(); j++) {
                if (takenCells[slice.y1 + i][slice.x1 + j]) {
                    return false;
                }

                takenCells[slice.y1 + i][slice.x1 + j] = true;
            }
        }

        return true;
    }

    public void calcPerfectOption() {
        possibleSlices = getPossibleSlices();
        Chunk copyChunk = new Chunk(this);
        addNextSlice(copyChunk, 0);
    }

    private void addNextSlice(Chunk chunk, int position) {
        if (position < possibleSlices.size()) {
            Slice newSlice = possibleSlices.get(position);
            if (chunk.canAddSlice(newSlice)) {
                Chunk chunkCopy = new Chunk(chunk);
                chunkCopy.addSlice(newSlice);
                addNextSlice(chunkCopy, position + 1);
            }
            addNextSlice(chunk, position + 1);
        } else {
            int chunkScore = chunk.calcScore();
            if (chunkScore > highscore) {
                highscore = chunkScore;
                slices.clear();
                slices.addAll(chunk.slices);
            }
        }
    }
}
