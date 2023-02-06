package cscie88a.week3;

@FunctionalInterface
public interface ITrainableFP {

	// The only abstract method !
	public boolean doTrick(String trickName);

	default public boolean doTrickForTreat(String trickName, String treatName) {
		System.out.println("I love the " + treatName + 
			" and will happily do the trick [" + trickName + "] !!");
		return true;
	}
}
