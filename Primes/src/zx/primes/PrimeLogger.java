package zx.primes;

import zx.utils.DataWriter;
import zx.enums.LogType;
import zx.primes.extras.PrimeStorage;
import zx.utils.MessageGenerator;

/**
 * Created by ryan on 10/02/15.
 */
public class PrimeLogger {

    /**
     * This will attempt to log the the file but it the system is disabled it
     * will just print to console.
     *
     * @param logType - Where the message is coming from
     */
    public static void fileLog(LogType logType, PrimeConfiguration configuration, PrimeStorage storage) {
        if (configuration.isFileLoggingEnabled()) {
            switch (logType) {
                case FULL:
                    DataWriter.writeToFile(MessageGenerator.generateFinalMessage(storage.getGlobalCounter(), storage.getGenerations(), storage.getLength(), storage.getStartTime(), storage.getFinalEndTime()), configuration);
                    break;
                case SEMI:
                    DataWriter.writeToFile(MessageGenerator.generateSemiFinalMessage(storage.getCurrentNumber(), storage.getLocalCounter(), storage.getLength(), storage.getCurrentTime(), storage.getStartTime()), configuration);
                    break;
                case TYRS:
                    DataWriter.writeToFile(MessageGenerator.generateTryMessage(storage.getCurrentNumber(), storage.getLocalCounter(), storage.getLength(), storage.isCurrentPrime()), configuration);
                    break;
                case BEGIN:
                    if (configuration.isBeginMessageEnabled())
                        DataWriter.writeToFile(MessageGenerator.generateBeginMessage(storage.getGenerations(), storage.getLength()), configuration);
                default:
                    break;
            }
        } else {
            DataWriter.writeToStdOut("Would write to file but system is disabled.");
        }
    }

    /**
     * This will attempt to log a message to the standard output
     *
     * @param logType - Where the message is coming from
     */
    public static void stdOutLog(LogType logType, PrimeConfiguration configuration, PrimeStorage storage) {
        switch (logType) {
            case FULL:
                DataWriter.writeToStdOut(MessageGenerator.generateFinalMessage(storage.getGlobalCounter(), storage.getGenerations(), storage.getLength(), storage.getStartTime(), storage.getFinalEndTime()));
                break;
            case SEMI:
                DataWriter.writeToStdOut(MessageGenerator.generateSemiFinalMessage(storage.getCurrentNumber(), storage.getLocalCounter(), storage.getLength(), storage.getCurrentTime(), storage.getStartTime()));
                break;
            case TYRS:
                DataWriter.writeToStdOut(MessageGenerator.generateTryMessage(storage.getCurrentNumber(), storage.getLocalCounter(), storage.getLength(), storage.isCurrentPrime()));
                break;
            case BEGIN:
                if (configuration.isBeginMessageEnabled())
                    DataWriter.writeToStdOut(MessageGenerator.generateBeginMessage(storage.getGenerations(), storage.getLength()));
            default:
                break;
        }
    }

    /**
     * This will attempt to log to the text fields
     *
     * @param logType - Where the message is coming from.
     */
    public static void txtLog(LogType logType, PrimeConfiguration configuration, PrimeStorage storage) {
        switch (logType) {
            case FULL:
                if (configuration.getIsFieldLoggingEnabled()[0])
                    configuration.getMainLoggingArea().setText(configuration.getMainLoggingArea().getText() + MessageGenerator.generateFinalMessage(storage.getGlobalCounter(), storage.getGenerations(), storage.getLength(), storage.getStartTime(), storage.getFinalEndTime()) + "\n");
                //PRIME
                if (configuration.getIsFieldLoggingEnabled()[2])
                    configuration.getLocalPrimeCounter().setText("" + storage.getLocalCounter());
                if (configuration.getIsFieldLoggingEnabled()[3])
                    configuration.getGlobalPrimeCounter().setText("" + storage.getGlobalCounter());
                //CURRENT PRIME
                break;
            case SEMI:
                if (configuration.getIsFieldLoggingEnabled()[0])
                    configuration.getMainLoggingArea().setText(configuration.getMainLoggingArea().getText() + MessageGenerator.generateFinalMessage(storage.getGlobalCounter(), storage.getGenerations(), storage.getLength(), storage.getStartTime(), storage.getFinalEndTime()) + "\n");
                if (configuration.getIsFieldLoggingEnabled()[1])
                    configuration.getPrimeLoggingArea().setText(storage.getCurrentNumber().toString());
                if (configuration.getIsFieldLoggingEnabled()[2])
                    configuration.getLocalPrimeCounter().setText("" + storage.getLocalCounter());
                if (configuration.getIsFieldLoggingEnabled()[3])
                    configuration.getGlobalPrimeCounter().setText("" + storage.getGlobalCounter());
                if (configuration.getIsFieldLoggingEnabled()[4])
                    configuration.getCurrentPrimeLogger().setText("" + storage.getCurrentPrimeSearch());
                break;
            case TYRS:
                if (configuration.getIsFieldLoggingEnabled()[0])
                    configuration.getMainLoggingArea().setText(configuration.getMainLoggingArea().getText() + MessageGenerator.generateTryMessage(storage.getCurrentNumber(), storage.getLocalCounter(), storage.getLength(), storage.isCurrentPrime()) + "\n");
                //PRIME
                if (configuration.getIsFieldLoggingEnabled()[2])
                    configuration.getLocalPrimeCounter().setText("" + storage.getLocalCounter());
                if (configuration.getIsFieldLoggingEnabled()[3])
                    configuration.getGlobalPrimeCounter().setText("" + storage.getGlobalCounter());
                //CURRENT PRIME
                break;
            case BEGIN:
                if (configuration.getIsFieldLoggingEnabled()[0])
                    configuration.getMainLoggingArea().setText(configuration.getMainLoggingArea().getText() + MessageGenerator.generateBeginMessage(storage.getGenerations(), storage.getLength()) + "\n");
                if (configuration.getIsFieldLoggingEnabled()[4])
                    configuration.getCurrentPrimeLogger().setText("" + storage.getCurrentPrimeSearch());
                break;
            default:
                break;
        }
        if (configuration.getIsFieldLoggingEnabled()[0])
            configuration.getMainLoggingArea().setCaretPosition(configuration.getMainLoggingArea().getText().length());
    }

}
