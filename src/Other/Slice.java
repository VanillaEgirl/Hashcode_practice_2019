package Other;

public class Slice {
    public int y1;
    public int x1;
    public int y2;
    public int x2;

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
        boolean hasTomato = false;
        boolean hasMushroom = false;

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if(Pizza.map[y1+i][x1+j] == Ingredient.TOMATO) {
                    hasTomato = true;
                }

                if(Pizza.map[y1+i][x1+j] == Ingredient.MUSHROOM) {
                    hasMushroom = true;
                }
            }
        }

        return hasTomato && hasMushroom;
    }
}
