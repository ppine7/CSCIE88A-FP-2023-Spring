package cscie88a.week3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalManagerFP {

    private static final Logger logger = LoggerFactory.getLogger(AnimalManagerFP.class);

    public static boolean trainForTricksNotFP(ITrainable animalToTrain){
        String trickName = "run";
        logger.info("About to ask subject [{}] to run", animalToTrain.toString());
        return animalToTrain.doTrick(trickName);
    }

    // one-argument method
    public static boolean trainToRun(ITrainableFP animalToTrain) {
        String trickName = "run";
        logger.info("About to ask subject [{}] to run ...", animalToTrain.toString());
        return animalToTrain.doTrick(trickName);
    }

    // multi-argument method
    public static boolean trainForTricks(ITrainableFP animalToTrain, String trickName) {
        logger.info("About to ask subject [" + animalToTrain.toString() +
                "] to do the trick: " + trickName);
        return animalToTrain.doTrick(trickName);
    }

    // use FI with no arguments and no return value
    public static boolean doAnyTrick1(ITrainable1 animalToTrain) {
        animalToTrain.doAnyTrick();
        return true;
    }

    // use FI with a return value
    public static boolean doAnyTrick2(ITrainable2 animalToTrain) {
        return animalToTrain.doAnyTrick();
    }

    // use FI with multiple arguments
    public static boolean doManyTricks(ITrainable3 animalToTrain) {
        return animalToTrain.doManyTricks("jump", "roll");
    }

}
