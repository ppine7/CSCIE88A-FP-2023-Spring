package cscie88a.week4;

import com.google.common.base.Objects;

public class Toy {

	private String name;
	private boolean isSqueaky = true;
	private boolean isBouncy = true;
	private boolean hasFeathers = false;
	
	public Toy() {}
	
	public Toy(String name, boolean isSqueaky, boolean isBouncy, boolean hasFeathers) {
		super();
		this.name = name;
		this.isSqueaky = isSqueaky;
		this.isBouncy = isBouncy;
		this.hasFeathers = hasFeathers;
	}


	public boolean isSqueaky() {
		return isSqueaky;
	}

	public void setSqueaky(boolean isSqueaky) {
		this.isSqueaky = isSqueaky;
	}

	public boolean isBouncy() {
		return isBouncy;
	}

	public void setBouncy(boolean isBouncy) {
		this.isBouncy = isBouncy;
	}

	public boolean isHasFeathers() {
		return hasFeathers;
	}

	public void setHasFeathers(boolean hasFeathers) {
		this.hasFeathers = hasFeathers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Toy{" +
				"name='" + name + '\'' +
				", isSqueaky=" + isSqueaky +
				", isBouncy=" + isBouncy +
				", hasFeathers=" + hasFeathers +
				"}\n";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Toy toy = (Toy) o;
		return isSqueaky == toy.isSqueaky && isBouncy == toy.isBouncy && hasFeathers == toy.hasFeathers && Objects.equal(name, toy.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, isSqueaky, isBouncy, hasFeathers);
	}
}
