package cscie88a.week3;

public class CatFP  implements ITrainableFP {

	private boolean goodMood = false;
	private String name;

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
