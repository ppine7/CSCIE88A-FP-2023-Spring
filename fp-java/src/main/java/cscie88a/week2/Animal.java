package cscie88a.week2;

public class Animal {

	protected String name;
	protected String eyeColor;
	protected String bodyColor;

	public Animal() {
		super();
	}

	public Animal(String name, String eyeColor, String bodyColor) {
		super();
		this.name = name;
		this.eyeColor = eyeColor;
		this.bodyColor = bodyColor;
	}

	public boolean takeMedicine(boolean withTreat) {
		if (withTreat) {
			return true;
		} else {
			return false;
		}
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

}