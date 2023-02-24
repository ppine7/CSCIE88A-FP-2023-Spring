package cscie88a.week5;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class StreamGenerationTest {

    @Test
    void test_createStreamFromCollection() {
        Stream<String> testStream = StreamGeneration.createStreamFromCollection();
        testStream.forEach(System.out::println);
    }

    @Test
    void test_createStreamOf() {
        Stream<String> testStream = StreamGeneration.createStreamOf();
        testStream.forEach(System.out::println);
    }

    @Test
    void test_createInfiniteStream_lambda() {
        Stream<String> testStream = StreamGeneration.createInfiniteStreamViaIterator_lambda();
        testStream.limit(5).forEach(System.out::println);
    }

    @Test
    void test_createInfiniteStream_methodRef() {
        Stream<String> testStream = StreamGeneration.createInfiniteStreamViaIterator_methodRef();
        testStream.limit(5).forEach(System.out::println);
    }

    @Test
    void test_createInfiniteStreamViaGenerator() {
        Stream<String> testStream = StreamGeneration.createInfiniteStreamViaGenerator();
        testStream.limit(5).forEach(System.out::println);
    }

}