package zx.primes.extras;

import java.math.BigInteger;

/**
 * Created by ryan on 10/02/15.
 */
public class PrimeStorage {

    private long globalCounter;
    private long localCounter;
    private long generations;
    private long length;
    private long startTime;
    private long currentTime;
    private long finalEndTime;
    private long currentPrimeSearch;

    private BigInteger currentNumber;
    private boolean isCurrentPrime;

    /**
     * Returns the current prime search value
     *
     * @return long - Returns the current prime search value
     */
    public long getCurrentPrimeSearch() {
        return currentPrimeSearch;
    }

    /**
     * Sets the value of the current prime search
     * @param currentPrimeSearch long - The new value for the current prime search
     */
    public void setCurrentPrimeSearch(long currentPrimeSearch) {
        this.currentPrimeSearch = currentPrimeSearch;
    }

    /**
     * Returns the current number being tested
     * @return BigInteger - Returns the current number being tested
     */
    public BigInteger getCurrentNumber() {
        return currentNumber;
    }

    /**
     * Sets the value of the current number begin tested
     * @param currentNumber BigInteger - The new value for the current prime begin tested
     */
    public void setCurrentNumber(BigInteger currentNumber) {
        this.currentNumber = currentNumber;
    }

    /**
     * Returns whether the current number is prime
     * @return boolean - Returns whether the current number is prime
     */
    public boolean isCurrentPrime() {
        return isCurrentPrime;
    }

    /**
     * Sets the value of whether the current number is prime
     * @param isCurrentPrime boolean - The new value for whether the current number is prime
     */
    public void setCurrentPrime(boolean isCurrentPrime) {
        this.isCurrentPrime = isCurrentPrime;
    }

    /**
     * Returns the local counter value
     * @return long - Returns the local counter value
     */
    public long getLocalCounter() {
        return localCounter;
    }

    /**
     * Sets the value of the local counter
     * @param localCounter long - The new value for the local counter
     */
    public void setLocalCounter(long localCounter) {
        this.localCounter = localCounter;
    }

    /**
     * Returns the global counter value
     * @return long - Returns the global counter value
     */
    public long getGlobalCounter() {
        return globalCounter;
    }

    /**
     * Sets the value of the global counter
     * @param globalCounter long - The new value for the global counter
     */
    public void setGlobalCounter(long globalCounter) {
        this.globalCounter = globalCounter;
    }

    /**
     * Returns the number of generations
     * @return long - Returns the number of generations
     */
    public long getGenerations() {
        return generations;
    }

    /**
     * Sets the value of the generations
     * @param generations long - The new value for the generations
     */
    public void setGenerations(long generations) {
        this.generations = generations;
    }

    /**
     * Returns the length of the prime
     * @return long - Returns the length of the prime
     */
    public long getLength() {
        return length;
    }

    /**
     * Sets the value of the length
     * @param length long - The new value for the length
     */
    public void setLength(long length) {
        this.length = length;
    }

    /**
     * Returns the start time of generation
     * @return long - Returns the start time of generation
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the start time
     * @param startTime long - The new value for the start time
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the current time value
     * @return long - Returns the current time value
     */
    public long getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets the value of the current time
     * @param currentTime long - The new value for the current time
     */
    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Returns the final end time for generation
     * @return long - Returns the final end time of generation
     */
    public long getFinalEndTime() {
        return finalEndTime;
    }

    /**
     * Sets the value of the final end time
     * @param finalEndTime long - The new value for the final end time
     */
    public void setFinalEndTime(long finalEndTime) {
        this.finalEndTime = finalEndTime;
    }

    /**
     * This will increment the local counter by one
     */
    public void incrementLocalCounter() {
        localCounter++;
    }

    /**
     * This will increment the global counter by one
     */
    public void incrementGlobalCounter() {
        globalCounter++;
    }

    /**
     * This will increment the prime search by one.
     */
    public void incrementPrimeSearch() {
        currentPrimeSearch++;
    }

}
