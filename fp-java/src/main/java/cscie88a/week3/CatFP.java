package cscie88a.week3;

public class CatFP implements ITrainableFP {

	public static String FAVORITE_TRICK = "sleep";
	private boolean goodMood = false;
	private String name;

	/**
	 * class level method - Cat's version of the doTrick() FI's method
	 * - can be used as a method ref for ITrainableFP since it is static;
	 * but it is not an implementation of the ITrainableFP's one and only one abstract method: doTrick(String trickName)
	 * @param trickName
	 * @return
	 */
	public static boolean doTrickStatic(String trickName){
		if (FAVORITE_TRICK.equalsIgnoreCase(trickName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * instance level method - has access to instance state - satisfies the requirement for and implementation
	 * of the ONE and only ONE method abstract method in the FI ITrainableFP: doTrick(String trickName)
 	 * @param trickName
	 * @return
	 */
	@Override
	public boolean doTrick(String trickName) {
		if (goodMood) {
			System.out.println(getName() + " says: fine, I'll do the trick... ");
			return true;
		} else {
			System.out.println(getName() + " says: not in the mood to do tricks");
			return false;
		}
	}

	// class level method - always returns TRUE
	public static boolean checkForAdoptionStatusStatic() {
		return true;
	};

	public CatFP(String name) {
		this.name = name;
	}

	// instance level method - has access to instance state
	public boolean checkForAdoptionStatusInstance() {
		if (goodMood)
			return true;
		else
			return false;
	};

	public String getName() {
		return name;
	}

	public boolean isGoodMood() {
		return goodMood;
	}

	public void setGoodMood(boolean goodMood) {
		this.goodMood = goodMood;
	}

	@Override
	public String toString() {
		return "CatFP{" +
				"goodMood=" + goodMood +
				", name='" + name + '\'' +
				'}';
	}
}
