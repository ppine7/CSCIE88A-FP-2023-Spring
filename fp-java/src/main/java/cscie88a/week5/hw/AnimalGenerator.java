package cscie88a.week5.hw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class AnimalGenerator {

    private static final Logger logger = LoggerFactory.getLogger(AnimalGenerator.class);
    public static Random random = new Random();

    /**
     * generate a list of new randomized StreamAnimal objects of the specified size
     *
     * @param numberOfAnimals
     * @return
     */
    public static List<StreamAnimal> generateListOfAnimals(int numberOfAnimals){
        List<StreamAnimal> generatedAnimals = new LinkedList<>();
        if (numberOfAnimals == 0) {
            return generatedAnimals;
        }
        for (int i=0; i<numberOfAnimals; i++) {
            // we will be generating only 3 types of animals: Cats, Dogs and Hedgehogs
            int animalTypeFlag = i % 3;
            generatedAnimals.add(getNewAnimalByTypeFlag(animalTypeFlag, i));
        }
        generatedAnimals.forEach(animal -> logger.info("generated animal: {}", animal));
        return generatedAnimals;
    }

    /**
     * generate a new randomized StreamAnimal object
     * @return
     */
    public static StreamAnimal getNewAnimal(){
        int animalTypeFlag = random.nextInt(3);
        int nameSuffix = random.nextInt();
        return getNewAnimalByTypeFlag(animalTypeFlag, nameSuffix);
    }

    /**
     * this method generates a StreamAnimal object, based on the typeFlag and nameSuffix:
     *  typeFlag == 0 --> CAT, name = "GeneratedCat" + nameSuffix
     *  typeFlag == 1 --> DOG, name = "GeneratedDog" + nameSuffix
     *  typeFlag == 2 --> HEDGEHOG, name = "GeneratedHedgehog" + nameSuffix
     *
     *  it sets hasCurrentShots to a random boolean,
     *  it sets animals's age to a random integer in the range [0, 20)
     *
     * @param typeFlag
     * @param nameSuffix
     * @return
     */
    public static StreamAnimal getNewAnimalByTypeFlag(int typeFlag, int nameSuffix){
        StreamAnimal animal = null;
        switch (typeFlag) {
            case 0: // Cat
                animal = new StreamAnimal(
                        AnimalType.CAT,
                        "GeneratedCat" + nameSuffix,
                        random.nextBoolean(),
                        random.nextInt(20)
                );
                break;
            case 1: // Dog
                animal = new StreamAnimal(
                        AnimalType.DOG,
                        "GeneratedDog" + nameSuffix,
                        random.nextBoolean(),
                        random.nextInt(20)
                );
                break;
            case 2: // Hedgehog
                animal = new StreamAnimal(
                        AnimalType.HEDGEHOG,
                        "GeneratedHedgehog" + nameSuffix,
                        random.nextBoolean(),
                        random.nextInt(20)
                );
                break;
            default: // should not happen but ...
                break;
        }
        return animal;
    }

    public static Stream<StreamAnimal> generateStreamOfAnimalsFromCollection(int numberOfAnimals){
        // TODO implement this and return a correct object
         return null;
    }

    public static Stream<StreamAnimal> generateStreamOfAnimals_lambda(){
        // TODO implement this and return a correct object
        return null;
    }

}
