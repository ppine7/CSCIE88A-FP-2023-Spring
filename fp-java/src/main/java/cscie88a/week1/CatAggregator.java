package cscie88a.week1;

import java.util.ArrayList;
import java.util.Collection;

public class CatAggregator {
	
	public CatAggregator() {
	}
	
	public long countCatsByColorImperative(
		Collection<Cat> allCats, String bodyColorToMatch, String eyeColorToMatch) {

		long numOfCats = 0l;
		for (Cat cat: allCats) {
			if (cat.getBodyColor().equalsIgnoreCase(bodyColorToMatch) && 
				cat.getEyeColor().equalsIgnoreCase(eyeColorToMatch)) {
				numOfCats++;
			}
		}
		System.out.println("Imperative: Found " + numOfCats + " " + 
			bodyColorToMatch + " cats with " + eyeColorToMatch + " eyes");
		return numOfCats;
	}
	
	public long countCatsByColorFunctional(Collection<Cat> allCats, String bodyColorToMatch, String eyeColorToMatch) {
		long numOfCats = allCats.stream().parallel()
			.filter(cat -> cat.getBodyColor().equalsIgnoreCase(bodyColorToMatch))
			.filter(cat -> cat.getEyeColor().equalsIgnoreCase(eyeColorToMatch))
			.mapToLong(cat -> 1l)
			.reduce(0, (partialSum1, partialSum2) -> partialSum1 + partialSum2);
		
		System.out.println("Functional: Found " + numOfCats + " " + 
			bodyColorToMatch + " cats with " + eyeColorToMatch + " eyes");
		return numOfCats;
	}

	public static void main(String[] args) throws Exception {
		Collection<Cat> testCats = new ArrayList<Cat>();
		testCats.add(new Cat("Demon", "green", "black"));
		testCats.add(new Cat("Sneaky", "blue", "gray"));
		testCats.add(new Cat("Angel", "blue", "white"));
		testCats.add(new Cat("Pirate", "green", "black"));
		testCats.add(new Cat("Scruffy", "golden", "black"));
		testCats.add(new Cat("Princess", "green", "white"));
		
		CatAggregator catAggregator = new CatAggregator();
		catAggregator.countCatsByColorFunctional(testCats, "black", "green");
		catAggregator.countCatsByColorImperative(testCats, "black", "green");
		
		// lets make this run forever ...
		while (true) {
			System.out.println("I'm sleeping ....");
			Thread.sleep(5000l);
		}
	}
}
