package cscie88a.week5;

import cscie88a.week5.demo.BasicParallelOperations;
import org.junit.jupiter.api.Test;

/**
* Feb 25, 2020 marinapopova
*/
public class BasicParallelOperationsTest {
	private int listSize = 20;

	@Test
	public void testExecuteAsNotParallel() {
		BasicParallelOperations.executeAsNotParallel(listSize);
	}
	
	@Test
	public void testExecuteAsParallelAfterMap() {
		BasicParallelOperations.executeAsParallelAfterMap(listSize);
	}
	
	@Test
	public void testExecuteAsParallelBeforeMap() {
		BasicParallelOperations.executeAsParallelBeforeMap(listSize);
	}

	@Test
	public void testExecuteWithCustomPool() {
		BasicParallelOperations.executeWithCustomPool(listSize);
	}

}
