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
     * @return {@link String} - The begin message
     */
    public static String generateBeginMessage(long generations, long length) {
        return "[Gen - ENAB] Attempting to generate " + generations + " prime number" + (generations > 1 ? "s" : "") + " with " + length + " digits. This test is being run by: '" + System.getProperty("user.name") + "' at: '" + new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + "' on: '" + new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime()) + "'";
    }

    /**
     * This will generate the message when the program tries a prime starts.
     *
     * @return {@link String} - The try message
     */
    public static String generateTryMessage(BigInteger currentNumber, long localCounter, long length, boolean isCurrentPrime) {
        int chount = currentNumber.toString().length();
        String extension = "th";
        if (localCounter == 1) extension = "st";
        if (localCounter == 2) extension = "nd";
        if (localCounter == 3) extension = "rd";
        return "[Gen - TRYS] This is the " + localCounter + extension + " attempt to find a prime number with " + length + " digits. The current number is: " + currentNumber + " (This number is " + chount + " characters long. This is a " + (chount == length ? "good" : "bad") + " result). This number " + (isCurrentPrime ? "IS" : "IS NOT") + " a prime number.";
    }

    /**
     * This will generate the message when the program finds a prime.
     *
     * @return {@link String} - The semi-final message
     */
    public static String generateSemiFinalMessage(BigInteger currentNumber, long localCounter, long length, long currentTime, long startTime) {
        int chount = currentNumber.toString().length();
        return "\n[Gen - SEMI] It took " + localCounter + " attempts to find a prime number with " + length + " digits. That prime number was: " + currentNumber + " (This prime number ended up being " + chount + " characters long. This is a " + (chount == length ? "good" : "bad") + " result) and according to the system it took approximatly " + ((currentTime - startTime) / 1000) + " seconds (" + (currentTime - startTime) + " millis)";
    }

    /**
     * This will generate the message when the program completes its search.
     *
     * @return {@link String} - The final message
     */
    public static String generateFinalMessage(long globalCounter, long generations, long length, long startTime, long finalEndTime) {
        return "\n[Gen - FULL] It took " + globalCounter + " attempts to find " + generations + " prime number" + (generations > 1 ? "s" : "") + " with " + length + " digits. According to the system this complete opperation took approximatly " + ((finalEndTime - startTime) / 1000) + " seconds or " + (finalEndTime - startTime) + " milliseconds.";
    }

}
