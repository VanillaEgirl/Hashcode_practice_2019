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

    public static void print() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(map[i][j].signifier + " ");
            }
            System.out.println();
        }
    }

    public boolean isValid() {
        boolean[][] takenCells = new boolean[Y][X];

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                takenCells[i][j] = false;
            }
        }


        for (Slice slice : slices) {
            if (!slice.isValid()) {
                return false;
            }

            boolean successfull = writeTakenCells(takenCells, slice);

            if(!successfull) {
                return false;
            }
        }

        return true;
    }

    private boolean writeTakenCells(boolean[][] takenCells, Slice slice) {
        for (int i = 0; i < slice.getHeight(); i++) {
            for (int j = 0; j < slice.getLength(); j++) {
                takenCells[slice.y1 + i][slice.x1 + j] = true;
            }
        }
    }
}
