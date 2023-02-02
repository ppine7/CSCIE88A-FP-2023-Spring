package cscie88a.week2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllAnimalTests {

	private Cat3 sneaky;
	private Dog bolt;

	@BeforeEach
	void setUp() throws Exception {
		sneaky = new Cat3("Sneaky", "blue", "gray");
		bolt = new Dog("Bolt", "brown", "whity");
	}

	@Test
	void testTakeMedicine() {		
		assertTrue(bolt.takeMedicine(true));
		assertFalse(bolt.takeMedicine(false));
		assertFalse(sneaky.takeMedicine(true));
		assertFalse(sneaky.takeMedicine(false));
	}

	@Test
	public void testDoTrick() {
		assertFalse(sneaky.doTrick("sit"));
		assertTrue(bolt.doTrick("sit"));
	}

}
