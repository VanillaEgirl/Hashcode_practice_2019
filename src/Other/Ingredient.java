package Other;

public enum Ingredient {
    TOMATO('T'),
    MUSHROOM('M');

    public char signifier;

    Ingredient(char signifier) {
        this.signifier = signifier;
    }
}
