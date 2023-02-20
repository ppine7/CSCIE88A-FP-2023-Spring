package cscie88a.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class FirstStreamOperations {

    private static final Logger logger = LoggerFactory.getLogger(FirstStreamOperations.class);
    private static int listSize = 5;

    public static void doExternalIteration() {
        logger.info("doExternalIteration():");
        List<String> testList = StreamGeneration.getTestList(listSize);
        Iterator<String> iterator = testList.iterator();
        while (iterator.hasNext()) {
            logger.info("Processing next item: {}", iterator.next());
        }
    }

    public static void doInternalIteration() {
        logger.info("doInternalIteration():");
        List<String> testList = StreamGeneration.getTestList(listSize);
        testList.stream().forEach(
                item -> logger.info("Processing next item: {}", item)
        );
    }

    public static void doSimplePipeline(){
        logger.info("doSimplePipeline():");
        List<String> testList = StreamGeneration.getTestList(listSize);
        testList
                .stream()
                .filter(item -> item.length() > 3)
                .map(item -> item.replace("t", "1"))
                .forEach(item ->  logger.info("Resulting string: {}", item)
        );
    }

}
