package cscie88a.week4;

import com.google.common.base.Objects;

public class Cat {

	protected String name;
	protected String eyeColor;
	protected String bodyColor;

	public Cat() {
		super();
	}

	public Cat(String name, String eyeColor, String bodyColor) {
		super();
		this.name = name;
		this.eyeColor = eyeColor;
		this.bodyColor = bodyColor;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cat cat = (Cat) o;
		return Objects.equal(name, cat.name) && Objects.equal(eyeColor, cat.eyeColor) && Objects.equal(bodyColor, cat.bodyColor);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, eyeColor, bodyColor);
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + name + '\'' +
				", eyeColor='" + eyeColor + '\'' +
				", bodyColor='" + bodyColor + '\'' +
				'}';
	}
}