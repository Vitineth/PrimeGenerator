package zx.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ryan on 10/02/15.
 */
public class MessageGenerator {
    /**
     * This will generate the message when the search starts.
     *
     * @param generations long - The amount of generations the prime search should do.
     * @param length long - The length of the prime to be generated.
     *
     * @return {@link String} - The begin message
     */
    public static String generateBeginMessage(long generations, long length) {
        return "[Gen - ENAB] Attempting to generate " + generations + " prime number" + (generations > 1 ? "s" : "") + " with " + length + " digits. This test is being run by: '" + System.getProperty("user.name") + "' at: '" + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "' on: '" + new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime()) + "'";
    }

    /**
     * This will generate the message when the program tries a prime starts.
     *
     * @param currentNumber BigInteger - The prime number
     * @param localCounter long - The amount of generations took to get to the number
     * @param length long - The prime digits
     * @param isCurrentPrime - Whether the value is prime
     *
     * @return {@link String} - The try message
     */
    public static String generateTryMessage(BigInteger currentNumber, long localCounter, long length, boolean isCurrentPrime) {
        //Character count
        int chount = currentNumber.toString().length();

        //Set the default extension
        String extension = "th";
        //Get the last character in the local counter string
        char last = String.valueOf(localCounter).charAt(String.valueOf(localCounter).length());
        //If the last character is a 1 it should be st (Eg. 1st)
        if (last == '1') extension = "st";
        //If the last character is a 2 it should be nd (Eg. 2nd)
        if (last == '2') extension = "nd";
        //If the last character is a 3 it should be rd (Eg. 3rd)
        if (last == '3') extension = "rd";

        //Then return the generated string using the values and the extension
        return "[Gen - TRYS] This is the " + localCounter + extension + " attempt to find a prime number with " + length + " digits. The current number is: " + currentNumber + " (This number is " + chount + " characters long. This is a " + (chount == length ? "good" : "bad") + " result). This number " + (isCurrentPrime ? "IS" : "IS NOT") + " a prime number.";
    }

    /**
     * This will generate the message when the program finds a prime.
     *
     * @param currentNumber BigInteger - The prime number
     * @param localCounter long - The amount of generations took to get to the number
     * @param length long - The prime digits
     * @param currentTime long - The time generation ended
     * @param startTime long - The time generation started.
     *
     * @return {@link String} - The semi-final message
     */
    public static String generateSemiFinalMessage(BigInteger currentNumber, long localCounter, long length, long currentTime, long startTime) {
        //Character count of the prime number
        int chount = currentNumber.toString().length();
        //Then generate the string and return it.
        return "\n[Gen - SEMI] It took " + localCounter + " attempts to find a prime number with " + length + " digits. That prime number was: " + currentNumber + " (This prime number ended up being " + chount + " characters long. This is a " + (chount == length ? "good" : "bad") + " result) and according to the system it took approximatly " + ((currentTime - startTime) / 1000) + " seconds (" + (currentTime - startTime) + " millis)";
    }

    /**
     * This will generate the message when the program completes its search.
     *
     * @param globalCounter - long - The amount of generation it took in total
     * @param generations- long - The amount of prime numbers it generated
     * @param length long - The prime digits
     * @param finalEndTime long - The time generation ended.
     * @param startTime long - The time generation started.
     *
     * @return {@link String} - The final message
     */
    public static String generateFinalMessage(long globalCounter, long generations, long length, long startTime, long finalEndTime) {
        return "\n[Gen - FULL] It took " + globalCounter + " attempts to find " + generations + " prime number" + (generations > 1 ? "s" : "") + " with " + length + " digits. According to the system this complete opperation took approximatly " + ((finalEndTime - startTime) / 1000) + " seconds or " + (finalEndTime - startTime) + " milliseconds.";
    }

}
