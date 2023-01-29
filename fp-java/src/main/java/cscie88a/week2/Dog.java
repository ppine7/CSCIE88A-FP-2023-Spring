package cscie88a.week2;

public class Dog extends Animal implements ITrainable{

	public Dog() {
	}

	public Dog(String name, String eyeColor, String bodyColor) {
		super(name, eyeColor, bodyColor);
	}

	@Override
	public boolean doTrick(String trickName) {
		System.out.println(name + " says: I LOVE doing tricks! I'm doing "
				+ trickName + " now!");
		return true;
	}

}
