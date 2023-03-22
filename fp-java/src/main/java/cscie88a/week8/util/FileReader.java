package cscie88a.week8.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);
    public static final String DELIMITER_COMMA = ",";

    public static List<Object[]> readFromFile(String filename, String delimiter){
        List<Object[]> list = null;
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()))) {
            list = stream
                .filter(line -> StringUtils.isNotBlank(line) && !line.startsWith("#"))
                .map(line -> StringUtils.split(line, StringUtils.defaultString(delimiter, DELIMITER_COMMA)))
                .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
           logger.error("Error reading file: {}",filename, e);
        }
        return list;
    }

    public static Set<String> readAllValuesFile(String filename){
        Set<String> list = null;
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()))) {
            list = stream
                    .filter(line -> StringUtils.isNotBlank(line) && !line.startsWith("#"))
                    .map(line -> StringUtils.split(line, StringUtils.defaultString(DELIMITER_COMMA))[0])
                    .collect(Collectors.toSet());
        } catch (IOException | URISyntaxException e) {
            logger.error("Error reading file: {}",filename, e);
        }
        return list;
    }


}
