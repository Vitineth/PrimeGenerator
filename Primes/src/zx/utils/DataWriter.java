package zx.utils;

import zx.primes.PrimeConfiguration;

/**
 * Created by ryan on 10/02/15.
 */
public class DataWriter {

    /**
     * This will attempt to write the given string to file.
     *
     * @param message String - The message to write to file.
     * @param configuration PrimeConfiguration - The configuration used in the prime generation
     */
    public static void writeToFile(String message, PrimeConfiguration configuration) {
        writeToStdOut("Writing to file: [" + message + "]");
        configuration.getWriter().println(message);
        configuration.getWriter().flush();
    }

    /**
     * This will attempt to write the given string to the standard output.
     *
     * @param message - The message
     */
    public static void writeToStdOut(String message) {
        System.out.println(message);
    }

}
