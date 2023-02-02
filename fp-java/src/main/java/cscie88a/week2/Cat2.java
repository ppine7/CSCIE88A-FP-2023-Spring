package cscie88a.week2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cat2 extends Animal{

	private static final Logger logger = LoggerFactory.getLogger(Cat2.class);
	public static String whatISay = "I don't care what you asked me to say - I say MEOW only";
	protected boolean isFriendly = false;
	
	public Cat2() {}

	public Cat2(String name, String eyeColor, String bodyColor) {
		super(name, eyeColor, bodyColor);
	}

	// this method is overwritten !
	public boolean takeMedicine(boolean withTreat) {
		logger.info(name + " says: you won't trick me - I'm not taking it!");
		return false;		
	}

	public static String saySomething(String somethingToSay){
		return whatISay;
	}

	public static void main(String[] args) throws Exception {
		Cat2 demon = new Cat2("Demon", "green", "black");
		Cat2 sneaky = new Cat2("Sneaky", "blue", "gray");
		String somethingToSay = "Hello!";
		System.out.println("Demon says: " + demon.saySomething(somethingToSay));
		System.out.println("Sneaky says: " + sneaky.saySomething(somethingToSay));

		System.out.println("All cats say: " + Cat2.saySomething(somethingToSay));
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", eyeColor=" + eyeColor + ", bodyColor=" + bodyColor + "]";
	}

	public boolean isFriendly() {
		return isFriendly;
	}

	public void setFriendly(boolean isFriendly) {
		this.isFriendly = isFriendly;
	}
	
}
