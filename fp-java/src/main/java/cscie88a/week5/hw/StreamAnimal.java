package cscie88a.week5.hw;

import com.google.common.base.Objects;

public class StreamAnimal {

	private AnimalType animalType;
	private String name;
	private boolean hasCurrentShots;
	private int age;

	public StreamAnimal(){}

	public StreamAnimal(AnimalType animalType, String name, boolean hasCurrentShots, int age) {
		this.animalType = animalType;
		this.name = name;
		this.hasCurrentShots = hasCurrentShots;
		this.age = age;
	}

	@Override
	public String toString() {
		return "StreamAnimal{" +
				"animalType=" + animalType +
				", name='" + name + '\'' +
				", hasCurrentShots=" + hasCurrentShots +
				", age=" + age +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StreamAnimal that = (StreamAnimal) o;
		return hasCurrentShots == that.hasCurrentShots &&
				age == that.age &&
				animalType == that.animalType &&
				Objects.equal(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(animalType, name, hasCurrentShots, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimalType getAnimalType() {
		return animalType;
	}

	public boolean isHasCurrentShots() {
		return hasCurrentShots;
	}

	public void setHasCurrentShots(boolean hasCurrentShots) {
		this.hasCurrentShots = hasCurrentShots;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}