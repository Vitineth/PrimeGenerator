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
    public static int generatePseudoRandomOddNumber() {//pseudo-random
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
        builder.append(generatePseudoRandomOddNumber());
        return builder.toString();//Then return the string version of the number
    }

    /**
     * This method will return the next value in the counter generation system.
     *
     * @param threadKey The threads key for generation.
     * @return BigInteger - The next value.
     */
    public static BigInteger getNextValue(int threadKey, long length) {
        //If the current generated threads does not contain the current thread key
        if (!currentGenerated.containsKey(threadKey)) {

            //Then create a number starting with one
            String number = "1";
            //Then add a 0 to the number for the length minus 2
            for (int i = 0; i < length - 2; i++) {
                number = number + "0";
            }
            //Then finally add a 1 so its odd.
            number = number + "1";

            //And add the number to the thread
            currentGenerated.put(threadKey, new BigInteger(number));
        }
        //Get the number from the thread numbers and add two to it.
        BigInteger next = currentGenerated.get(threadKey).add(new BigInteger("2"));
        //Then if it is divisible by two then subtract 1 from it.
        if (next.mod(new BigInteger("2")).equals(BigInteger.ZERO)) next = next.subtract(BigInteger.ONE);
        //And finally put the key back in it
        currentGenerated.put(threadKey, next);
        //And return the new thread value.
        return currentGenerated.get(threadKey);
    }

}
