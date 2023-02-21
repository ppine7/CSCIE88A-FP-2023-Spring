package cscie88a.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * author: marinapopova
 * Feb 25, 2021
 */
public class StreamGeneration {

    private static Random random = new Random();

    /**
     * create a Stream of Strings using Collection.stream() method
     * @return
     */
    public static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("string1", "string2", "string3");
        Stream<String> resultStream = list.stream();
        return resultStream;
    }

    /**
     * create a Stream of String using static methods of Stream interface, Stream.of(...)
     * @return
     */
    public static Stream<String> createStreamOf() {
        Stream<String> resultStream = Stream.of("string1", "string2", "string3");
        return resultStream;
    }


    /**
     * Create an infinite Steam of Strings,
     * by iteratively generating new strings from the previous ones
     *
     * @return
     */
    public static Stream<String> createInfiniteStreamViaIterator_lambda() {
        Stream<String> resultStream = Stream.iterate(
                "mySeedString",
                previousString -> previousString + random.nextInt(100));
        return resultStream;
    }

    public static Stream<String> createInfiniteStreamViaIterator_methodRef() {
        Stream<String> resultStream = Stream.iterate(
                "mySeedString",
                MyStringGenerator::getNewStringFromOld);
        return resultStream;
    }

    /**
     * create an infinite stream of String by using Stream.generate()
     * and a method reference to a Supplier<String>
     * @return
     */
    public static Stream<String> createInfiniteStreamViaGenerator() {
        Stream<String> resultStream = Stream.generate(
                MyStringGenerator::getNewString);
        return resultStream;
    }


    public static List<String> getTestList(int listSize){
        List<String> testList = new ArrayList<>();
        for (int i=0; i<listSize; i++)
            testList.add("item_" + i);
        return testList;
    }
}
