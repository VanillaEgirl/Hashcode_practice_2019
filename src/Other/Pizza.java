package Other;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    public static int Y;
    public static int X;
    public static int MIN_INGREDIENTS;
    public static int MAX_SIZE;

    public static Ingredient[][] map;
    public List<Slice> slices = new ArrayList<>();
    private boolean[][] takenCells;

    public Pizza() {
        takenCells = new boolean[Y][X];

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                takenCells[i][j] = false;
            }
        }
    }

    public void addSlice(Slice slice) {
        slices.add(slice);
        writeTakenCells(slice);
    }

    public int calcScore() {
        int score = 0;

        for (Slice slice : slices) {
            score += slice.calcSize();
        }

        return score;
    }

    public static void print() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(map[i][j].signifier + " ");
            }
            System.out.println();
        }
    }

    public boolean canAddSlice( Slice slice) {
        for (int i = 0; i < slice.getHeight(); i++) {
            for (int j = 0; j < slice.getLength(); j++) {
                if (takenCells[slice.y1 + i][slice.x1 + j]) {
                    return false;
                }
            }
        }

        return true;
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
}
