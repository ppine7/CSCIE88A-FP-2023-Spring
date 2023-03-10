package cscie88a.week7;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
* Mar 22, 2021 marinapopova
*/

@SuppressWarnings("ALL")
public class StateOperations {

	private static final Logger logger = LoggerFactory.getLogger(StateOperations.class);


	/**
	 * Example of a non-concurrent simple groupBy aggregaion operation
	 */
	public static void groupByRegularOneArg(int listSize){
		logger.info("groupByRegularOneArg():");
		List<String> testList = getListOfRandomStrings(listSize);
		Map<Integer, List<String>> stringsByLength = testList.stream()
				.parallel()
				.collect(
						Collectors.groupingBy(e -> e.length())
				);
		stringsByLength.forEach(StateOperations::printMapEntry);
	}

	/**
	 * Example of a non-concurrent generic groupBy aggregaion operation
	 */
	public static void groupByRegularThreeArg(int listSize){
		logger.info("groupByRegularThreeArg():");
		List<String> testList = getListOfRandomStrings(listSize);
		Map<Integer, List<String>> stringsByLength = testList.stream()
				.parallel()
				.collect(
						Collectors.groupingBy(
								e -> e.length(),
								HashMap::new,
								Collectors.toList())
				);
		stringsByLength.forEach(StateOperations::printMapEntry);
	}

	/**
	 * Example of a concurrent simple groupBy aggregaion operation
	 */
	public static void groupByConcurrentOneArg(int listSize){
		logger.info("groupByConcurrentOneArg():");
		List<String> testList = getListOfRandomStrings(listSize);
		Map<Integer, List<String>> stringsByLength = testList.stream()
				.parallel()
				.collect(
						Collectors.groupingByConcurrent(e -> e.length())
				);
		stringsByLength.forEach(StateOperations::printMapEntry);
	}

	/**
	 * Example of a concurrent generic groupBy aggregaion operation
	 */
	public static void groupByConcurrentThreeArg(int listSize){
		logger.info("groupByConcurrentThreeArg():");
		List<String> testList = getListOfTestStrings();
		Map<Integer, List<String>> stringsByLength = testList.stream()
				.parallel()
				.collect(
						Collectors.groupingByConcurrent(
								e -> e.length(),
								ConcurrentHashMap::new,
								Collectors.toList())
				);
		stringsByLength.forEach(StateOperations::printMapEntry);
	}

	private static void printMapEntry(Integer key, List<String> values) {
		logger.info("{} : {}", key, values);
	}

	private static List<String> getListOfRandomStrings(int listSize){
		List<String> testList = new ArrayList<>();
		int stringLengthMin = 5;
		int stringLengthMax = 10;
		for (int i=0; i<listSize; i++) {
			String generatedString = RandomStringUtils.randomAlphanumeric(stringLengthMin, stringLengthMax);
			testList.add(generatedString);
		}
		return testList;
	}

	// TODO implement this in HW
	public static Map<String, List<String>> groupByFirstCharRegular(List<String> list_of_strings) {
		return null;
	}

	// TODO implement this in HW
	public static Map<String, List<String>> groupByFirstCharConcurrent(List<String> list_of_strings) {
		return null;
	}

	/**
	 * Adopted from the poem by Ogden Nash:
	 * The Cat
	 *
	 * (Ogden Nash)
	 *
	 * You get a wife, you get a house,
	 * Eventually you get a mouse.
	 * You get some words regarding mice,
	 * You get a kitty in a trice.
	 *
	 * By two a.m. or thereabouts,
	 * The mouse is in, the cat is out.
	 * It dawns upon you, in your cot,
	 * The mouse is silent, the cat is not.
	 *
	 * Instead of kitty, says your spouse,
	 * You should have got another mouse.
	 *
	 * @param listSize
	 * @return
	 */
	private static List<String> getListOfTestStrings(){
		List<String> testList = List.of(
				"The",
				"Cat",
				"Ogden",
				"Nash",
				"You",
				"get",
				"wife",
				"house",
				"Eventually",
				"a",
				"mouse",
				"words",
				"regarding",
				"mice" ,
				"kitty",
				"in",
				"trice",
				"two",
				"a.m.",
				"or",
				"thereabouts",
				"cat",
				"out",
				"dawns",
				"upon",
				"cot",
				"silent",
				"Instead",
				"says",
				"spouse",
				"should",
				"have",
				"got",
				"another"
		);
		return testList;
	}

}
