package cscie88a.hw0;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem1 {

    public Optional<String> convertTemp(String line) {
        try {
            return Optional.of(String.valueOf(Double.parseDouble(line) * 1.8 + 32.0));
        }
        catch (NumberFormatException nx)
        {
            System.err.println("Invalid temperature in C. The input value: " + line);
            return Optional.empty();
        }
    }

    public List<String> readFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            //1. filter line that starts with #
            //2. convert C to F
            //3. ignore Bad values in C
            //4. Generate list with temp in F
            list = stream
                    .filter(line -> !line.startsWith("#"))
                    .map(this::convertTemp)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
        //list.forEach(System.out::println);
    }

    public int writeFile(List<String> list, String fileName) {
        Charset utf8 = StandardCharsets.UTF_8;
        try {
            Files.write(Paths.get(fileName), list, utf8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.size();
    }
}
