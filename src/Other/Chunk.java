package Other;

public class Chunk {
    public int y1;
    public int x1;
    public int y2;
    public int x2;

    public Chunk() {

    }

    public Chunk(int y1, int x1, int y2, int x2) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public int getWidth() {
        return x2 - x1;
    }
}
