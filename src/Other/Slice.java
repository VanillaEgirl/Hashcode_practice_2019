package Other;

public class Slice {
    public int y1;
    public int x1;
    public int y2;
    public int x2;

    public Slice() {

    }

    public Slice(int y1, int x1, int y2, int x2) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
    }

    public boolean isValid() {
        return calcSize() <= Pizza.MAX_SIZE && hasAllIngredients();
    }

    public int calcSize() {
        return getHeight() * getLength();
    }

    public int getHeight() {
        return y2 - y1;
    }

    public int getLength() {
        return x2 - x1;
    }

    private boolean hasAllIngredients() {
        int tomatoCount = 0;
        int mushroomCount = 0;

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (Pizza.map[y1 + i][x1 + j] == Ingredient.TOMATO) {
                    tomatoCount++;
                }

                if (Pizza.map[y1 + i][x1 + j] == Ingredient.MUSHROOM) {
                    mushroomCount++;
                }
            }
        }

        return tomatoCount >= Pizza.MIN_INGREDIENTS && mushroomCount >= Pizza.MIN_INGREDIENTS;
    }
}
