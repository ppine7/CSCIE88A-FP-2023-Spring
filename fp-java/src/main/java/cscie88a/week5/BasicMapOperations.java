package cscie88a.week5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Function;

/**
* Feb 27, 2020 marinapopova
*/

public class BasicMapOperations {

	private static final Logger logger = LoggerFactory.getLogger(BasicMapOperations.class);
	private static int listSize = 5;

	/**
	 * Example of a map operation using an anonymous Function FI implementation
	 */
	public static void mapToCapitalize_anonymous(){
		logger.info("mapToCapitalize_anonymous():");
		List<String> testList = StreamGeneration.getTestList(listSize);

		// create a new anonymous class implementing Function FI
		Function<String, String> myMapper = new Function<String, String>() {
			@Override
			public String apply(String s) {
				if (s != null && s.length() > 0) {
					return s.substring(0, 1).toUpperCase() + s.substring(1);
				} else
					return "x";
			}
		};

		// apply this mapper to the stream
		testList.stream()
				.map(myMapper)
				.forEach(logger::info);
	}

	public static String capitalizeString(String inputString){
		if (inputString != null && inputString.length() > 0) {
			return inputString.substring(0, 1).toUpperCase() +
					inputString.substring(1);
		} else
			return "x";
	}

	/**
	 * Example of a map operation using a method reference as a parameter
	 */
	public static void mapToCapitalize_methodRef(){
		logger.info("mapToCapitalize_methodRef():");
		List<String> testList = StreamGeneration.getTestList(listSize);
		testList.stream()
				.map(BasicMapOperations::capitalizeString)
				.forEach(logger::info);
	}

	/**
	 * Example of a map operation using a Lambda function as a parameter
	 * NOTE: this is an unsafe implementation of capitalization as it does not check
	 * for a null string.... but it would make a Lambda expression too unwieldy otherwise
	 */
	public static void mapToCapitalize_lambda(){
		logger.info("mapToCapitalize_lambda():");
		List<String> testList = StreamGeneration.getTestList(listSize);
		testList.stream()
				.map(inputString -> inputString.toUpperCase())
				.forEach(logger::info);
	}

}
