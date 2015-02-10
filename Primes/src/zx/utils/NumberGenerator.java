package zx.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by ryan on 10/02/15.
 */
public class NumberGenerator {

    private static Random random = new Random();

    private static HashMap<Integer, BigInteger> currentGenerated = new HashMap<>();

    /**
     * This will generate an odd number using the random object
     *
     * @return {@link Integer}[In primitive form] - The odd number
     */
    public static int generatePsudorandomOddNumber() {
        int value = 0;
        while (value % 2 == 0) {
            value = random.nextInt(9) + 1;
        }
        return value;
    }

    /**
     * This method will generate a random number up to the length that was given
     *
     * @return {@link String} - The number
     */
    public static String generateRandomNumber(long length) {
        StringBuilder builder = new StringBuilder();//Create a string builder for forming the number
        for (int i = 0; i != (length - 1); i++) {//Until i equals the length
            builder.append(random.nextInt(9) + 1);//Append a new random number 1-9
        }
        builder.append(generatePsudorandomOddNumber());
        return builder.toString();//Then return the string version of the number
    }

    /**
     * This method will return the next value in the counter generation system.
     *
     * @param threadKey The threads key for generation.
     * @return BigInteger - The next value.
     */
    public static BigInteger getNextValue(int threadKey, long length) {
        if (!currentGenerated.containsKey(threadKey)) {

            String number = "1";
            for (int i = 0; i < length - 1; i++) {
                number = number + "0";
            }

            currentGenerated.put(threadKey, new BigInteger(number));
        }

        currentGenerated.put(threadKey, currentGenerated.get(threadKey).add(new BigInteger("1")));
        return currentGenerated.get(threadKey);
    }

}
