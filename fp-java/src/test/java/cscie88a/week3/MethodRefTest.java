package cscie88a.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MethodRefTest {

    @Test
    public void testMethodReference_static(){
        AdoptionService service = new AdoptionService();
        boolean adoptionFeePaid = true;
        IAdoptable lambdaMethodRef = CatFP::checkForAdoptionStatusStatic;
        boolean result = service.tryToAdoptNoArg(lambdaMethodRef, adoptionFeePaid);
        assertTrue(result);
    }

    @Test
    public void testMethodReference_instance(){
        AdoptionService service = new AdoptionService();
        boolean adoptionFeePaid = true;
        CatFP myCat = new CatFP("Piggy");
        myCat.setGoodMood(false);
        IAdoptable lambdaMethodRef = myCat::checkForAdoptionStatusInstance;
        boolean result = service.tryToAdoptNoArg(lambdaMethodRef, adoptionFeePaid);
        assertFalse(result);
    }

}