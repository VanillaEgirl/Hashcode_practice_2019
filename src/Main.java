import FileHandling.FileReader;
import FileHandling.FileWriter;
import Other.Pizza;
import Other.Slice;

import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        FileReader.readFile();

        Pizza pizza = new Pizza();
        Pizza temp_pizza = new Pizza();
        boolean activ = true;

        while (activ) {

            Slice randomSlice = new Slice();

            randomSlice.x1 = random.nextInt(Pizza.X);
            randomSlice.y1 = random.nextInt(Pizza.Y);
            randomSlice.x2 = randomSlice.x1 + random.nextInt(Pizza.X - randomSlice.x1);
            randomSlice.y2 = randomSlice.y1 + random.nextInt(Pizza.X - randomSlice.y1);

            if (randomSlice.isValid()) {
                temp_pizza.slices.add(randomSlice);

                if (temp_pizza.isValid()) {
                    pizza.slices.add(randomSlice);
                } else {
                    activ = false;
                }
            }
        }

        FileWriter.writeFile(pizza.slices);
    }
}
