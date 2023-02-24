package cscie88a.week5;

import cscie88a.week5.hw.AnimalType;
import cscie88a.week5.hw.StreamAnimal;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class CoreFIExamplesTest {

    private Random random = new Random();

    @Test
    public void testCalculations() {
        // can be implemented as any FI - via anonymous class
        Function<String, Integer> calcFnSafe = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                if (s != null)
                    return s.length();
                else
                    return 0;
            }
        };

        Function<String, Integer> calcFn1 = inputString -> inputString.length();
        Function<String, Integer> calcFn_plus10 = inputString -> inputString.length() + 10;
        Function<String, Integer> calcFn_double = inputString -> inputString.length() * 2;

        String inputString = "class";
        CoreFIExamples.calculateLength(calcFn1, inputString);
        CoreFIExamples.calculateLength(calcFn_plus10, inputString);
        CoreFIExamples.calculateLength(calcFn_double, inputString);

        // we could also provide an in-line lambda as implementation:
        CoreFIExamples.calculateLength(
                inputStringArg -> inputStringArg.length() + 100,
                inputString);
    }

    @Test
    public void testSupplierAndConsumer_anonymous() {
        Supplier<StreamAnimal> catSupplier = new Supplier<StreamAnimal>() {
            @Override
            public StreamAnimal get() {
                StreamAnimal newCat = new StreamAnimal(
                        AnimalType.CAT, "SuppliedCat", true, random.nextInt());
                System.out.println("I've supplied a new cat: " + newCat);
                return newCat;
            }
        };

        Consumer<StreamAnimal> animalConsumer = new Consumer<StreamAnimal>() {
            @Override
            public void accept(StreamAnimal StreamAnimal) {
                System.out.println("I'm accepting this animal: " + StreamAnimal);
            }
        };

        CoreFIExamples.chainSupplierAndConsumer(catSupplier, animalConsumer);
    }

    @Test
    public void testSupplierAndConsumer_lambda() {
        Supplier<StreamAnimal> catSupplier = () -> {
            return new StreamAnimal(
                    AnimalType.CAT, "SuppliedCat", random.nextBoolean(), 10);
        };

        Consumer<StreamAnimal> animalConsumer = animal -> {
            if (animal.isHasCurrentShots()) {
                System.out.println("We can accept this animal");
            } else {
                System.out.println("We can NOT accept this animal");
            }
        };

        CoreFIExamples.chainSupplierAndConsumer(catSupplier, animalConsumer);
    }

}