package cscie88a.week3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalManagerFP {

    private static final Logger logger = LoggerFactory.getLogger(AnimalManagerFP.class);

    /**
     * method with one argument of ITrainable type - not a Functional interface
     * @param animalToTrain
     * @return
     */

    public static boolean trainForTricksNotFP(ITrainable animalToTrain){
        String trickName = "run";
        logger.info("About to ask subject [{}] to run", animalToTrain.toString());
        return animalToTrain.doTrick(trickName);
    }

    /**
     * method with multiple arguments, first one is an FI ITrainableFP, second - name of the trick to do
     * @param animalToTrain
     * @param trickName
     * @return
     */
    public static boolean trainForTricksFP(
            ITrainableFP animalToTrain, String trickName) {
        logger.info("About to ask subject [" + animalToTrain.toString() +
                "] to do the trick: " + trickName);
        return animalToTrain.doTrick(trickName);
    }

    /**
     * method with one arguments,  FI ITrainableFP; name of the trick is hardcoded to "run"
     * @param animalToTrain
     * @return
     */
    public static boolean trainToRun(ITrainableFP animalToTrain) {
        String trickName = "run";
        logger.info("About to ask subject [{}] to run ...", animalToTrain.toString());
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
