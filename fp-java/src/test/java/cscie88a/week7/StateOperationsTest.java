package cscie88a.week7;

import org.junit.jupiter.api.Test;

class StateOperationsTest {

    @Test
    public void testGroupByRegularOneArg() {
        StateOperations.groupByRegularOneArg(20);
    }

    @Test
    public void testGroupByRegularThreeArg(){
        StateOperations.groupByRegularThreeArg(20);
    }

    @Test
    public void testGroupByConcurrentOneArg(){
        StateOperations.groupByConcurrentOneArg(20);
    }

    @Test
    public void testGroupByConcurrentThreeArg(){
        StateOperations.groupByConcurrentThreeArg(20);
    }

    // TODO implement this for HW
    @Test
    public void testGroupByFirstCharRegular(){}

    // TODO implement this for HW
    @Test
    public void testGroupByFirstCharConcurrent(){}

}