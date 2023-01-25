package cscie88a.hw0;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    private static Problem1 problem1;

    @BeforeAll
    static void setUpBeforeClass() {
        problem1 = new Problem1();
    }

    @Test
    void convertTemp() {
        Optional<String> expectedNumber = Optional.of("32.0");
        Optional<String> resultNumber = problem1.convertTemp("0");
        assertEquals(expectedNumber, resultNumber);
    }

    @Test
    void convertBadTemp() {
        Optional<String> expectedNumber = Optional.empty();
        Optional<String> resultNumber = problem1.convertTemp("AB10");
        assertEquals(expectedNumber, resultNumber);
    }

    @Test
    void readFile() {
        List<String> expectedList = Arrays.asList("32.0","-40.0");
        List<String> resultList =  problem1.readFile("src/test/resources/celsius-data.txt");
        assertEquals(expectedList, resultList);
    }
}