package cscie88a.week3;

public class Cat implements ITrainable {

	private boolean goodMood = false;
	private String name;

	public Cat(String name) {
		this.name = name;
	}

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
		return "Cat{" +
				"goodMood=" + goodMood +
				", name='" + name + '\'' +
				'}';
	}
}
