package cscie88a.week3;

import org.junit.jupiter.api.Test;

class TypeInferenceTest {

	@Test
	public void testTypesInference_withReturnType(){
		ITrainableFP lambdaRef1 = trickName -> {
				return false;
		};
		boolean result = AnimalManagerFP.trainToRun(lambdaRef1);

		/*
		Object lambdaRef2 = trickName -> {
			return false;
		};

		boolean result2 = AnimalManagerFP.trainToRun(lambdaRef2);
		/*  */
	}

	@Test
	public void testTypesInference_noArgs(){
		ITrainable1 lambdaRef1 = () -> {};

		//ITrainable1 lambdaRef4 = (trickName) -> {};

		//Object lambdaRef2 = () -> {};

		Object lambdaRef3 = (ITrainable1) () -> {};
	}

}
