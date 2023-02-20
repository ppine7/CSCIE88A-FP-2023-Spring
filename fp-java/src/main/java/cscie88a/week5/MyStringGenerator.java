package cscie88a.week5;

import java.util.Random;

public class MyStringGenerator {

    private static Random random = new Random();
    private static String baseString = "baseString";

    /**
     * a method that can be used as a Supplier<String>  FI implementation
     * @return
     */
    public static String getNewString(){
        return baseString + random.nextInt(99);
    }

    /**
     * a method that can be used as a UnaryOperation FI implementation
     * @param oldString
     * @return
     */
    public static String getNewStringFromOld(String oldString){
            if (oldString == null || oldString.length() < 2)
                return oldString + "x";
            else
                return oldString.substring(0, oldString.length()-2) + random.nextInt(99);
    }

}
