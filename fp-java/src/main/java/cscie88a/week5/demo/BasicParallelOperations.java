package cscie88a.week5.demo;

import cscie88a.week5.StreamGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

/**
* Feb 25, 2020 marinapopova
*/

public class BasicParallelOperations {

	private static final Logger logger = LoggerFactory.getLogger(BasicParallelOperations.class);
	
	static {
		logger.info("number of available Cores: {}", Runtime.getRuntime().availableProcessors());
	}

	public static void executeAsNotParallel(int listSize){
		logger.info("executeAsNotParallel():");
		List<String> testList = StreamGeneration.getTestList(listSize);
		Stream<String> streamOfItems = testList.stream()
				.map(item -> mapItem(item))
				;
		logger.info("streamOfItems.isParallel(): {}", streamOfItems.isParallel());
		streamOfItems.forEach(item -> handleItem(item));
	}

	// is there a difference between Before and After ??? 
	public static void executeAsParallelAfterMap(int listSize){
		logger.info("executeAsParallelAfterMap():");
		List<String> testList = StreamGeneration.getTestList(listSize);
		Stream<String> streamOfItems = testList.stream()
				.map(item -> mapItem(item))
				.parallel();
		logger.info("streamOfItems.isParallel(): {}", streamOfItems.isParallel());
		streamOfItems.forEach(item -> handleItem(item));
	}

	public static void executeAsParallelBeforeMap(int listSize){
		logger.info("executeAsParallelBeforeMap():");
		List<String> testList = StreamGeneration.getTestList(listSize);
		Stream<String> streamOfItems = testList.stream()
				.parallel()
				.map(item -> mapItem(item))
				;
		logger.info("streamOfItems.isParallel(): {}", streamOfItems.isParallel());
		streamOfItems.forEach(item -> handleItem(item));
	}

	private static String mapItem(String item){
		// do some map work with the item - just print for now
		logger.info("in mapItem: {}", item);
    	// sleep for a bit - to slow down the execution
		try {
			Thread.sleep(8);
		} catch (InterruptedException e) {
			logger.warn("InterruptedException happened: ", e);
		}
		return item + "_mapped";
	}

	private static String handleItem(String item){
		// do something with the item - just print for now
		logger.info("I'm handling item: {}", item);
    	// sleep for a bit - to slow down the execution
		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			logger.warn("InterruptedException happened: ", e);
		}
		return item;
	}
	
	public static void executeWithCustomPool(int listSize) {
		logger.info("executeWithCustomPool():");
		ForkJoinPool myThreadPool = new ForkJoinPool(3);		
		List<String> testList = StreamGeneration.getTestList(listSize);

		myThreadPool.submit(() -> {
			Stream<String> streamOfItems = testList.stream()
					.parallel()
					.map(item -> mapItem(item))
					;
			logger.info("streamOfItems.isParallel(): {}", streamOfItems.isParallel());
			streamOfItems.forEach(item -> handleItem(item));
	    }).join();
	}

}
