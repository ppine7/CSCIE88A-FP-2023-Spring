package cscie88a.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalManagerFPTest {

    @Test
    public void testTrainForTricksNotFP_concrete(){
        Cat myCat = new Cat("Sneaky");
        boolean result = AnimalManagerFP.trainForTricksNotFP(myCat);
        assertFalse(result);

        myCat.setGoodMood(true);
        result = AnimalManagerFP.trainForTricksNotFP(myCat);
        assertTrue(result);
    }

    @Test
    public void testTrainForTricksNotFP_anonymous(){
        boolean result = AnimalManagerFP.trainForTricksNotFP(
                new ITrainable() {
                    @Override
                    public boolean doTrick(String trickName) {
                        System.out.println("anonymous ITrainable - will do the trick " + trickName);
                        return true;
                    }
                });
        assertTrue(result);
    }

    /**
     * test calling a method that takes an FI as parameter, using the regular implementation of the FI
     */
    @Test
    public void testTrainToRun_concrete(){
        CatFP sneaky = new CatFP("Sneaky");
        boolean result = AnimalManagerFP.trainToRun(sneaky);
        assertFalse(result);
    }

    /**
     * test calling a method that takes an FI as parameter, using the anonymous class as an implementation of the FI
     */
    @Test
    public void testTrainToRun_anonymous(){
        boolean result = AnimalManagerFP.trainToRun(
                new ITrainableFP() {
                    @Override
                    public boolean doTrick(String trickName) {
                        System.out.println("I hate running!");
                        return false;
                    }
                }
        );
        assertFalse(result);
    }

    /**
     * the first Lambda function - as an implementation
     * of the ITrainableFP interface;
     * as close to the class syntax as possible
     */
    @Test
    public void testTrainToRun_lambda1(){
        boolean result = AnimalManagerFP.trainToRun(
                (String trickName) -> {
                    System.out.println("I hate running!");
                    return false;
                }
        );
        assertFalse(result);
    }

    /**
     * the first Lambda function - as an implementation of the ITrainableFP interface;
     * simplifying syntax: omitting brackets and type for a single method argument
     */
    @Test
    public void testTrainToRun_lambda2(){
        boolean result = AnimalManagerFP.trainToRun(
                trickName -> {
                    System.out.println("I hate running!");
                    return false;
                }
        );
        assertFalse(result);
    }

    /**
     * the first Lambda function - as an implementation of the ITrainableFP interface;
     * simplifying syntax: one line body
     */
    @Test
    public void testTrainToRun_lambda3(){
        boolean result = AnimalManagerFP.trainToRun(
                trickName -> false
        );
        assertFalse(result);
    }

    /**
     * Lambda function implementing ITrainable1 interface -
     * with no arguments and no return value;
     * no action in the body
     */
    @Test
    public void testDoAnyTrick1_doNothing(){
        boolean result = AnimalManagerFP.doAnyTrick1(
                () -> { }
        );
        assertTrue(result);
    }

    /**
     * Lambda function implementing ITrainable2 interface -
     * with no arguments but with a return value
     */
    @Test
    public void testDoAnyTrick2(){
        boolean result = AnimalManagerFP.doAnyTrick2(
                () -> true
        );
        assertTrue(result);
    }

    /**
     * Lambda function implementing ITrainable3 interface -
     * with multiple arguments
     */
    @Test
    public void testDoAnyTrick3(){
        boolean result = AnimalManagerFP.doManyTricks(
                (trick1, trick2) -> true
        );
        assertTrue(result);
    }

    /**
     * Named Lambda function implementing ITrainable3 interface
     */
    @Test
    public void testDoAnyTrick3_namedLambda(){
        ITrainable3 animalToTrainAsNamedLambda =
                (trick1, trick2) -> true;

        boolean result = AnimalManagerFP.doManyTricks(animalToTrainAsNamedLambda);
        assertTrue(result);
    }


    /**
     * test calling a method that takes an FI as an argument;
     * pass a method reference to a static method as the FI parameter
     */
    @Test
    public void testDoTrick_methodRef_static(){
        ITrainableFP lambdaMethodRef = CatFP::doTrickStatic;
        boolean result = AnimalManagerFP.trainForTricksFP(lambdaMethodRef, "run");
        assertFalse(result);

        result = AnimalManagerFP.trainForTricksFP(lambdaMethodRef, "sleep");
        assertTrue(result);
    }

    /**
     * test calling a method that takes an FI as an argument;
     * pass a method reference to an instance method of some class as the FI parameter
     */
    @Test
    public void testDoTrick_methodRef_instance(){
        CatFP myCat = new CatFP("Piggy");
        myCat.setGoodMood(true);
        ITrainableFP lambdaMethodRef = myCat::doTrick;
        boolean result = AnimalManagerFP.trainForTricksFP(lambdaMethodRef, "run");
        // since the mood == True - the name of the trick does not matter, the cat will do it anyway
        assertTrue(result);

        myCat.setGoodMood(false);
        result = AnimalManagerFP.trainForTricksFP(lambdaMethodRef, "sleep");
        // since the mood == False - the name of the trick does not matter, the cat will NOT do it
        assertFalse(result);
    }

}