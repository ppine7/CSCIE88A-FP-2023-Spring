package cscie88a.hw0;

import java.util.ArrayList;
import java.util.List;

public class Problem1Main {
    public static void main(String[] args) {
        String directory = "src/main/resources";
        String inputFileName = "/celsius-data.txt";
        String outputFileName = "/fahrenheit-data1.txt";

        Problem1 p1 = new Problem1();

        // Get input parameters - directory name
        try {
            if (args.length > 0) {
                directory = args[0];
            }
            List<String> input = p1.readFile(directory + inputFileName);
            int numberOfLines = p1.writeFile(input, directory + outputFileName );
            System.out.println("File writing done.");
            System.out.println("Number of lines: " + numberOfLines);
        } catch (Exception e) {
            System.err.println("General Exception.");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
