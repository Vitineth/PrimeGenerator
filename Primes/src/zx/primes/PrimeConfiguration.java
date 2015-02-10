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

    //Configuration value.

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

    public long getPrimeDigits() {
        return primeDigits;
    }

    public void setPrimeDigits(long primeDigits) {
        this.primeDigits = primeDigits;
    }

    public long getPrimeAmount() {
        return primeAmount;
    }

    public void setPrimeAmount(long primeAmount) {
        this.primeAmount = primeAmount;
    }

    public boolean isSequential() {
        return isSequential;
    }

    public void setSequential(boolean isSequential) {
        this.isSequential = isSequential;
    }

    public boolean isFileLoggingEnabled() {
        return isFileLoggingEnabled;
    }

    public void setFileLoggingEnabled(boolean isFileLoggingEnabled) {
        this.isFileLoggingEnabled = isFileLoggingEnabled;
    }

    public boolean isBeginMessageEnabled() {
        return isBeginMessageEnabled;
    }

    public void setBeginMessageEnabled(boolean isBeginMessageEnabled) {
        this.isBeginMessageEnabled = isBeginMessageEnabled;
    }

    public boolean[] getIsFieldLoggingEnabled() {
        return isFieldLoggingEnabled;
    }

    public void setIsFieldLoggingEnabled(boolean[] isFieldLoggingEnabled) {
        this.isFieldLoggingEnabled = isFieldLoggingEnabled;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public JTextComponent getMainLoggingArea() {
        return mainLoggingArea;
    }

    public void setMainLoggingArea(JTextComponent mainLoggingArea) {
        this.mainLoggingArea = mainLoggingArea;
    }

    public JTextComponent getPrimeLoggingArea() {
        return primeLoggingArea;
    }

    public void setPrimeLoggingArea(JTextComponent primeLoggingArea) {
        this.primeLoggingArea = primeLoggingArea;
    }

    public JTextComponent getLocalPrimeCounter() {
        return localPrimeCounter;
    }

    public void setLocalPrimeCounter(JTextComponent localPrimeCounter) {
        this.localPrimeCounter = localPrimeCounter;
    }

    public JTextComponent getGlobalPrimeCounter() {
        return globalPrimeCounter;
    }

    public void setGlobalPrimeCounter(JTextComponent globalPrimeCounter) {
        this.globalPrimeCounter = globalPrimeCounter;
    }

    public JTextComponent getCurrentPrimeLogger() {
        return currentPrimeLogger;
    }

    public void setCurrentPrimeLogger(JTextComponent currentPrimeLogger) {
        this.currentPrimeLogger = currentPrimeLogger;
    }
}
