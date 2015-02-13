package zx.primes.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import zx.primes.PrimeConfiguration;

/**
 * Created by ryan on 10/02/15.
 */
public class PrimeConfigurationBuilder {

    private PrimeConfiguration configuration;

    /**
     * This will create a PrimeConfigurationBuilder with a pre exiting configuration
     *
     * @param configuration PrimeConfiguration - The base configuration
     */
    public PrimeConfigurationBuilder(PrimeConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * This will create a PrimeConfigurationBuilder with a blank value
     */
    public PrimeConfigurationBuilder() {
        configuration = new PrimeConfiguration();
    }

    /**
     * This will set the prime digit amount and then return the builder
     * @param amount long - The new prime digit amount
     * @return PrimeConfigurationBuilder - The current builder
     */
    public PrimeConfigurationBuilder setPrimeDigitAmount(long amount) {
        configuration.setPrimeDigits(amount);
        return this;
    }

    /**
     * This will set the prime generation amount and then return the builder
     * @param amount long - The new prime generation amount
     * @return PrimeConfigurationBuilder - The current builder
     */
    public PrimeConfigurationBuilder setPrimeGenerationAmount(long amount) {
        configuration.setPrimeAmount(amount);
        return this;
    }

    /**
     * This will set whether the generator should be sequential or not and then return the builder
     * @param isSequential boolean - whether generation is sequential
     * @return PrimeConfigurationBuilder - The current builder
     */
    public PrimeConfigurationBuilder setIsSequential(boolean isSequential) {
        configuration.setSequential(isSequential);
        return this;
    }

    /**
     * This will set whether file logging is enabled and the log file location and then return the builder. It will create the
     * file if it does not exist and set the new print writer
     * @param isFileLoggingEnabled boolean - whether file logging is enabled
     * @param logLocation File - the output file location
     * @return PrimeConfigurationBuilder - The current builder
     * @throws FileNotFoundException
     */
    public PrimeConfigurationBuilder setFileLogging(boolean isFileLoggingEnabled, File logLocation) throws FileNotFoundException {
        configuration.setFileLoggingEnabled(isFileLoggingEnabled);
        configuration.setOutputFile(logLocation);

        try {
            File parent = logLocation.getParentFile();
            if (parent != null) {
                if (!parent.exists()) parent.mkdirs();
            }
            if (!logLocation.exists()) logLocation.createNewFile();
        } catch (IOException e) {
            configuration.setFileLoggingEnabled(false);
        }

        configuration.setWriter(new PrintWriter(logLocation));
        return this;
    }

    /**
     * This will set whether the begin message is enabled or not and then return the builder
     * @param isBeginMessageEnabled boolean - If the begin message is enabled
     * @return PrimeConfigurationBuilder - The current builder
     */
    public PrimeConfigurationBuilder setIsBeginMessageEnabled(boolean isBeginMessageEnabled) {
        configuration.setBeginMessageEnabled(isBeginMessageEnabled);
        return this;
    }

    /**
     * This will set whether each file logging section is enabled and set the field and then return the builder
     * @param logArea boolean - Whether the main log area is enabled
     * @param logPrime boolean - Whether the prime log area is enabled
     * @param logLocalCounter boolean - Whether the local counter log area is enabled
     * @param logGlobalCounter boolean - Whether the global counter log area is enabled
     * @param logCurrentPrime boolean - Whether the current prime log area is enabled
     * @param logAreaField JTextField - The main logging area field
     * @param logPrimeField JTextField - The prime logging area field
     * @param logLocalCounterField JTextField - The local counter field
     * @param logGlobalCounterField JTextField - The global counter field
     * @param logCurrentPrimeField JTextField - The current prime log field
     * @return PrimeConfigurationBuilder - The current builder
     */
    public PrimeConfigurationBuilder setFieldLoggingEnabled(boolean logArea, boolean logPrime, boolean logLocalCounter, boolean logGlobalCounter, boolean logCurrentPrime, JTextComponent logAreaField, JTextComponent logPrimeField, JTextComponent logLocalCounterField, JTextComponent logGlobalCounterField, JTextComponent logCurrentPrimeField) {
        boolean[] fields = new boolean[]{logArea, logPrime, logLocalCounter, logGlobalCounter, logCurrentPrime};
        configuration.setIsFieldLoggingEnabled(fields);
        configuration.setMainLoggingArea(logAreaField);
        configuration.setPrimeLoggingArea(logPrimeField);
        configuration.setLocalPrimeCounter(logLocalCounterField);
        configuration.setGlobalPrimeCounter(logGlobalCounterField);
        configuration.setCurrentPrimeLogger(logCurrentPrimeField);

        return this;
    }

    /**
     * This will return the configuration in its complete form
     * @return PrimeConfiguration - The final configuration
     */
    public PrimeConfiguration build() {
        return configuration;
    }

}
