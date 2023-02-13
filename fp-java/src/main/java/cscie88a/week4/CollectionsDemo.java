package cscie88a.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsDemo {
    private static final Logger logger = LoggerFactory.getLogger(CollectionsDemo.class);

    public static List<Toy> createToyList(){
        List<Toy> toyList = new LinkedList<>();
        toyList.add(new Toy("ball", false, true, false));
        toyList.add((new Toy("birdie", false, false, true)));
        return toyList;
    }

    /**
     * test functionality of UnModifiable collections (List)
     * they are "structurally unmodifiable" - but not
     */
    public static void playWithUnmodifiableLists(){
        List<Toy> mutableToys = createToyList();
        List<Toy> unmodifiableToys = Collections.unmodifiableList(mutableToys);
        logger.info("Original mutableToys = {},\n unmodifiableToys = {}", mutableToys, unmodifiableToys);
        // try to add one more toy?
        Toy newToy = new Toy("mousey", true, true, false);
        //unmodifiableToys.add(newToy);
        logger.info("After adding newToy 1: \n unmodifiableToys = \n{}", unmodifiableToys);
        mutableToys.add(newToy);
        logger.info("After adding newToy 2: \n mutableToys = \n{},\n unmodifiableToys = \n{}", mutableToys, unmodifiableToys);
        // try to update one toy - ball - as a broken ball
        Toy toy1 = mutableToys.get(0);
        toy1.setName("broken_ball");
        toy1.setBouncy(false);
        logger.info("After updating the ball: \n mutableToys = {},\n unmodifiableToys = {}", mutableToys, unmodifiableToys);
    }

    public static void playWithImmutableLists(){
        List<Toy> mutableToys = createToyList();
        Toy ball = new Toy("ball", false, true, false);
        Toy birdie = new Toy("birdie", false, false, true);
        List<Toy> immutableToys = List.of(ball, birdie);
        logger.info("Original mutableToys = \n{},\n immutableToys = \n{}", mutableToys, immutableToys);
        // try to modify a toy
        ball.setName("broken_ball");
        // try to delete a toy - what will happen??
        //immutableToys.remove(1);
    }

    public static void main(String[] args) throws Exception {
        CollectionsDemo.playWithUnmodifiableLists();
        //CollectionsDemo.playWithImmutableLists();
    }

}
