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

    public PrimeConfigurationBuilder(PrimeConfiguration configuration) {
        this.configuration = configuration;
    }

    public PrimeConfigurationBuilder() {
        configuration = new PrimeConfiguration();
    }

    public PrimeConfigurationBuilder setPrimeDigitAmount(long amount) {
        configuration.setPrimeDigits(amount);
        return this;
    }

    public PrimeConfigurationBuilder setPrimeGenerationAmount(long amount) {
        configuration.setPrimeAmount(amount);
        return this;
    }

    public PrimeConfigurationBuilder setIsSequential(boolean isSequential) {
        configuration.setSequential(isSequential);
        return this;
    }

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

    public PrimeConfigurationBuilder setIsBeginMessageEnabled(boolean isBeginMessageEnabled) {
        configuration.setBeginMessageEnabled(isBeginMessageEnabled);
        return this;
    }

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

    public PrimeConfiguration build() {
        return configuration;
    }

}
