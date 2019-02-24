package FileHandling;

import Other.Slice;

import java.io.PrintWriter;
import java.util.List;

public class FileWriter {
    private static final String ENCODING = "UTF-8";

    public static void writeFile(List<Slice> slices) {
        String filePath = FilePath.outputPath;

        try {
            PrintWriter writer = new PrintWriter(filePath, ENCODING);

            System.out.println(slices.size());
            writer.println(slices.size());
            
            for (Slice slice : slices) {
                String string = slice.y1 + " " + slice.x1 + " " + (slice.y2 - 1) + " " + (slice.x2 - 1);
                System.out.println(string);
                writer.println(string);
            }

            writer.close();
        } catch (Exception e) {
            System.err.println("Exception occurred trying to write " + filePath);
            e.printStackTrace();
        }
    }
}
