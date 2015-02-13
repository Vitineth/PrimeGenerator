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
        //Set the current value to 0
        int value = 0;
        //While the number is divisible by 2
        while (value % 2 == 0) {
            //Then set the number to a number between 1 - 9
            value = random.nextInt(9) + 1;
        }
        //Then return the value
        return value;
    }

    /**
     * This method will generate a random number up to the length that was given
     *
     * @param length long - The length of the number
     *
     * @return {@link String} - The number
     */
    public static String generateRandomNumber(long length) {
        //Create a string builder for forming the number
        StringBuilder builder = new StringBuilder();
        //Until i equals the length
        for (int i = 0; i != (length - 1); i++) {
            //Append a new random number 1-9
            builder.append(random.nextInt(9) + 1);
        }
        //Finally add a random odd number to the end
        builder.append(generatePseudoRandomOddNumber());
        //Then return the string version of the number
        return builder.toString();
    }

    /**
     * This method will return the next value in the counter generation system.
     *
     * @param threadKey The threads key for generation.
     * @param length long - The length of the number if it does not exist in the hashmap already
     *
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
