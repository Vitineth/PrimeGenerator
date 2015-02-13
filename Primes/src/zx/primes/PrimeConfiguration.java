package zx.primes;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

/**
 * Created by ryan on 10/02/15.
 * <p/>
 * This class stores the prime generator configuration and values that need to be stored.
 */
public class PrimeConfiguration {

    //Configuration values.

    private long primeDigits;
    private long primeAmount;
    private boolean isSequential;
    private boolean isFileLoggingEnabled;
    private boolean isBeginMessageEnabled;
    private boolean[] isFieldLoggingEnabled;

    private File outputFile;
    private PrintWriter writer;

    private JTextComponent mainLoggingArea;
    private JTextComponent primeLoggingArea;
    private JTextComponent localPrimeCounter;
    private JTextComponent globalPrimeCounter;
    private JTextComponent currentPrimeLogger;

    /**
     * Returns the amount of digits that should be in the prime number
     *
     * @return long - The amount of digits in the prime number
     */
    public long getPrimeDigits() {
        return primeDigits;
    }

    /**
     * This will set the amount of digits the prime should have
     * @param primeDigits long - The new amount of digits
     */
    public void setPrimeDigits(long primeDigits) {
        this.primeDigits = primeDigits;
    }

    /**
     * Returns the amount of primes it should generate
     * @return long - The amount of primes to generate
     */
    public long getPrimeAmount() {
        return primeAmount;
    }

    /**
     * This will set the new value for the amount of primes to generate
     * @param primeAmount long - The new amount of primes to generate
     */
    public void setPrimeAmount(long primeAmount) {
        this.primeAmount = primeAmount;
    }

    /**
     * Returns whether the generation should be sequential
     * @return boolean - Whether the program should generate primes sequentially
     */
    public boolean isSequential() {
        return isSequential;
    }

    /**
     * This will set the new value for the whether the program should generate sequentially
     * @param isSequential boolean - The new value for whether the program should generate sequentially
     */
    public void setSequential(boolean isSequential) {
        this.isSequential = isSequential;
    }

    /**
     * Returns whether file logging is enabled
     * @return boolean - If file logging is enabled
     */
    public boolean isFileLoggingEnabled() {
        return isFileLoggingEnabled;
    }

    /**
     * This will set the new value for whether file logging is enabled
     * @param isFileLoggingEnabled boolean - The new value for whether file logging is enabled
     */
    public void setFileLoggingEnabled(boolean isFileLoggingEnabled) {
        this.isFileLoggingEnabled = isFileLoggingEnabled;
    }

    /**
     * Returns whether the program should generate a begin message.
     * @return boolean - If the begin message is enabled
     */
    public boolean isBeginMessageEnabled() {
        return isBeginMessageEnabled;
    }

    /**
     * This will set the new value for whether the begin message is enabled
     * @param isBeginMessageEnabled boolean - The new value for whether the begin message is enabled
     */
    public void setBeginMessageEnabled(boolean isBeginMessageEnabled) {
        this.isBeginMessageEnabled = isBeginMessageEnabled;
    }

    /**
     * Returns whether field logging is enabled for each section
     * @return boolean[] - The array of booleans for each component
     */
    public boolean[] getIsFieldLoggingEnabled() {
        return isFieldLoggingEnabled;
    }

    /**
     * This will set the new value for the field logging
     * @param isFieldLoggingEnabled boolean[] - The new values for field logging
     */
    public void setIsFieldLoggingEnabled(boolean[] isFieldLoggingEnabled) {
        this.isFieldLoggingEnabled = isFieldLoggingEnabled;
    }

    /**
     * Returns the output file for generation
     * @return File - The output file for messages
     */
    public File getOutputFile() {
        return outputFile;
    }

    /**
     * This will set the new value for the output file
     * @param outputFile File - The new value for the output file
     */
    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Returns the print writer linked to the output file
     * @return PrintWriter - The print writer linked to the output file.
     */
    public PrintWriter getWriter() {
        return writer;
    }

    /**
     * This will set the new value for the print writer
     * @param writer PrintWriter - The new value for the print writer
     */
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    /**
     * Returns the main logging area for prime generation
     * @return JTextComponent - The field for logging the main messages
     */
    public JTextComponent getMainLoggingArea() {
        return mainLoggingArea;
    }


    /**
     * This will set the new value for the main logging area
     * @param mainLoggingArea JTextComponent - The new value for the main logging area
     */
    public void setMainLoggingArea(JTextComponent mainLoggingArea) {
        this.mainLoggingArea = mainLoggingArea;
    }

    /**
     * Returns the area the program should log prime numbers to
     * @return JTextComponent - The field for logging the generated primes
     */
    public JTextComponent getPrimeLoggingArea() {
        return primeLoggingArea;
    }

    /**
     * This will set the new value for the prime logging area
     * @param primeLoggingArea JTextComponent - The new value for the prime logging area
     */
    public void setPrimeLoggingArea(JTextComponent primeLoggingArea) {
        this.primeLoggingArea = primeLoggingArea;
    }

    /**
     * Returns the field used for the local counter.
     * @return JTextComponent - The field for logging the local prime counter
     */
    public JTextComponent getLocalPrimeCounter() {
        return localPrimeCounter;
    }

    /**
     * This will set the new value for the local prime counting area.
     * @param localPrimeCounter JTextComponent - The new value for the local prime counting area
     */
    public void setLocalPrimeCounter(JTextComponent localPrimeCounter) {
        this.localPrimeCounter = localPrimeCounter;
    }

    /**
     * Returns the field used for the global counter.
     * @return JTextComponent - The field for logging the global prime counter
     */
    public JTextComponent getGlobalPrimeCounter() {
        return globalPrimeCounter;
    }

    /**
     * This will set the new value for the global prime counter area
     * @param globalPrimeCounter JTextComponent - The new value for the global prime counter area
     */
    public void setGlobalPrimeCounter(JTextComponent globalPrimeCounter) {
        this.globalPrimeCounter = globalPrimeCounter;
    }

    /**
     * Returns the field used to log the current prime
     * @return JTextComponent - The field for logging the current prime
     */
    public JTextComponent getCurrentPrimeLogger() {
        return currentPrimeLogger;
    }

    /**
     * This will set the new value for the current prime logging area.
     * @param currentPrimeLogger JTextComponent - The new value for the current prime logging area.
     */
    public void setCurrentPrimeLogger(JTextComponent currentPrimeLogger) {
        this.currentPrimeLogger = currentPrimeLogger;
    }
}
