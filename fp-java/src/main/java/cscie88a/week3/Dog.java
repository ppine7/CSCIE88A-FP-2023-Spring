package cscie88a.week3;

public class Dog implements ITrainable {

	private String name;

	public Dog(String name) {
		this.name = name;
	}

	@Override
	public boolean doTrick(String trickName) {
		System.out.println(getName() + " says: I'll do the trick! ");
		return true;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				'}';
	}
}
