package Other;

public enum Ingredient {
    TOMATO('T'),
    MUSHROOM('M');

    char signifier;

    Ingredient(char signifier) {
        this.signifier = signifier;
    }
}
