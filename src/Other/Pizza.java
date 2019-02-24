package Other;

public class Pizza {
    public static int ROWS;
    public static int COLS;
    public static int MIN_INGREDIENTS;
    public static int MAX_SIZE;

    public static char[][] map;

    public static void print() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
