package zx.primes;

import java.math.BigInteger;

import zx.enums.LogType;
import zx.primes.extras.PrimeStorage;
import zx.utils.NumberGenerator;

/**
 * This is the object used to generate the prime number. It comes will a lot (<a
 * href=
 * "http://thewritepractice.com/wp-content/uploads/2012/05/Alot-vs-a-lot1-600x450.png"
 * >Alot</a> more features so it looks quite bloated.
 * 
 * @author ryan
 * 
 */
public class PrimeGenerator {

	/**
	 * This stores whether the system has been canceled
	 */
	private boolean isCanceled;

    private int threadKey;

    private PrimeConfiguration configuration;
    private PrimeStorage storage;

    /**
     * This will create a prime generator with the given config.
     *
     * @param configuration The configuration for the prime generator
     * @param threadKey int - The threads key used for sequential generation.
     */
    public PrimeGenerator(PrimeConfiguration configuration, int threadKey) {
        this.configuration = configuration;
        this.storage = new PrimeStorage();
        this.threadKey = threadKey;
    }

	/**
	 * This will cancel the search for a prime.
	 */
	public void cancelSearch() {
		isCanceled = true;
	}

	/**
	 * This will start the loop to find the prime numbers
	 */
	public void startPrimeLoop() {
        storage.setStartTime(System.currentTimeMillis());
        this.isCanceled = false;
		log(LogType.BEGIN);
        for (int i = 0; i != configuration.getPrimeAmount(); i++) {
            storage.setLocalCounter(0);
            storage.setCurrentPrime(false);
            storage.setCurrentNumber(null);
            while (!storage.isCurrentPrime() && !isCanceled) {
                storage.incrementLocalCounter();
                storage.incrementGlobalCounter();

                BigInteger nextNumber = configuration.isSequential() ? NumberGenerator.getNextValue(threadKey, configuration.getPrimeDigits()) : new BigInteger(NumberGenerator.generateRandomNumber(configuration.getPrimeDigits()));
                storage.setCurrentNumber(nextNumber);

				testPrime();
				log(LogType.TYRS);
            }
            storage.incrementPrimeSearch();
            log(LogType.SEMI);
			if (isCanceled) break;
        }
        storage.setFinalEndTime(System.currentTimeMillis());
        log(LogType.FULL);
	}

	/**
	 * This will output a log message
	 * 
	 * @param logType
	 *            - Where the message is coming from
	 */
	private void log(LogType logType) {
        PrimeLogger.fileLog(logType, configuration, storage);
        PrimeLogger.txtLog(logType, configuration, storage);
    }


	/**
	 * This method will test if the current number is a prime.
	 */
	private void testPrime() {
        storage.setCurrentPrime(storage.getCurrentNumber().isProbablePrime(Integer.MAX_VALUE));
        storage.setCurrentTime(System.currentTimeMillis());
    }

    /**
     * This will reset the prime configuration to the given value
     *
     * @param configuration PrimeConfiguration - The new configuration for the generator
     */
    public void setConfiguration(PrimeConfiguration configuration) {
        this.configuration = configuration;
    }
}