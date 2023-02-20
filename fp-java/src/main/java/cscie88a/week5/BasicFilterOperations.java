package cscie88a.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

/**
* Feb 25, 2020 marinapopova
*/

public class BasicFilterOperations {

	private static final Logger logger = LoggerFactory.getLogger(BasicFilterOperations.class);

	public static void filterByNumber_anonymous(){
		int listSize = 30;
		logger.info("filterByNumber_anonymous():");
		List<String> testList = StreamGeneration.getTestList(listSize);

		// create an anonymous class implementing Predicate FI
		Predicate<String> myFilter = new Predicate<String>() {
			@Override
			public boolean test(String s) {
				if (s != null && s.contains("2"))
					return true;
				else
					return false;
			}
		};

		// now apply this filter to the stream of strings
		testList
				.stream()
				.filter(myFilter)
				.forEach(logger::info);
	}

	public static void filterByNumber_lambda(){
		int listSize = 30;
		logger.info("filterByNumber_lambda():");
		List<String> testList = StreamGeneration.getTestList(listSize);
		testList
				.stream()
				.filter(item -> item.contains("2"))
				.forEach(logger::info);
	}

}
