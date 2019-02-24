package Other;

public class Pizza {
    public static int Y;
    public static int X;
    public static int MIN_INGREDIENTS;
    public static int MAX_SIZE;

    public static char[][] map;

    public static void print() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
