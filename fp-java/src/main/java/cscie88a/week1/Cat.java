package cscie88a.week1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cat {

	private static final Logger logger = LoggerFactory.getLogger(Cat.class);
	public static final String species_name = "Felis catus";
	private String name;
	private String eyeColor;
	private String bodyColor;
	
	public Cat() {}

	public Cat(String name, String eyeColor, String bodyColor) {
		this.name = name;
		this.eyeColor = eyeColor;
		this.bodyColor = bodyColor;
	}
	
	public String saySomething(String somethingToSay){
		String whatISay = "I don't care what you asked me to say - I say MEOW only";
		return whatISay;
	}

	public void whoAmIInstance(){
		logger.info("I am a Cat, of species {}! I am an instance method: My name is {}, I have {} eyes and {} body",
				species_name, name, eyeColor, bodyColor);
	}

	public static void whoAmIStatic() {
		logger.info("I am a Cat, of species {}! no access to instance state",
				species_name);
	}

	public static void main(String[] args) throws Exception {
		// create a new instance of a Cat - with no initialization
		Cat emptyCat = new Cat();
		// create a new instance of a Cat with initialization of the state
		Cat demon = new Cat("Demon", "green", "black");
		Cat sneaky = new Cat("Sneaky", "blue", "gray");
		// call instance methods
		emptyCat.whoAmIInstance();
		sneaky.whoAmIInstance();
		demon.whoAmIInstance();

		//call static method:
		Cat.whoAmIStatic();

		String somethingToSay = "Hello!";
		logger.info("emptyCat says: {}", emptyCat.saySomething(somethingToSay));
		logger.info("Demon says: {}", demon.saySomething(somethingToSay));
		logger.info("Sneaky says: {}", sneaky.saySomething(somethingToSay));
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", eyeColor=" + eyeColor + ", bodyColor=" + bodyColor + "]";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyColor == null) ? 0 : bodyColor.hashCode());
		result = prime * result + ((eyeColor == null) ? 0 : eyeColor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (bodyColor == null) {
			if (other.bodyColor != null)
				return false;
		} else if (!bodyColor.equals(other.bodyColor))
			return false;
		if (eyeColor == null) {
			if (other.eyeColor != null)
				return false;
		} else if (!eyeColor.equals(other.eyeColor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	

}
