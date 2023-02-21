package cscie88a.week5;

import cscie88a.week5.hw.StreamAnimal;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CoreFIExamples {

    /**
     * Example of using a Function FI - with simple types
     */
    public static void calculateLength(Function<String, Integer> calculatorFunction, String inputString) {
        Integer resultLength = calculatorFunction.apply(inputString);
        System.out.println("Calculated length for string: " + inputString + " --> " + resultLength);
    }

    /**
     * a verbose but easier to inspect/debug implementation
     */
    public static void chainSupplierAndConsumer(Supplier<StreamAnimal> animalSupplier,
                                                Consumer<StreamAnimal> animalConsumer) {
        int numberOfRuns = 5;
        for (int i=0; i<numberOfRuns; i++){
            System.out.println("Run #" + i);
            StreamAnimal animal = animalSupplier.get();
            System.out.println("supplied animal: " + animal);
            animalConsumer.accept(animal);
        }
    }

}
