package cscie88a.week5;

import org.junit.jupiter.api.Test;

class BasicReduceOperationsTest {

    @Test
    void sumByLoop() {
        BasicReduceOperations.sumByLoop();
    }

    @Test
    void sumByReduction() {
        BasicReduceOperations.sumByReduction();
    }

    @Test
    void sumBySpecializedSum() {
        BasicReduceOperations.sumBySpecializedSum();
    }

    @Test
    void concatStringsAsReduce() {
        BasicReduceOperations.concatStringsAsReduce(50);
    }

    @Test
    void concatStringAsCollect() {
        BasicReduceOperations.concatStringAsCollect(5);
    }

    @Test
    void reduceSameType() {
        BasicReduceOperations.reduceSameType(5);
    }

    @Test
    void reduceDiffType() {
        BasicReduceOperations.reduceDiffType(5);
    }

    @Test
    void test_reduceIntoArrayGenericCollect(){
        BasicReduceOperations.reduceIntoArrayGenericCollect(5);
    }

    @Test
    void test_reduceIntoArrayViaCollectors(){
        BasicReduceOperations.reduceIntoArrayViaCollectors(5);
    }

}