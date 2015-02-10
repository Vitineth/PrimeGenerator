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

    public long getCurrentPrimeSearch() {
        return currentPrimeSearch;
    }

    public void setCurrentPrimeSearch(long currentPrimeSearch) {
        this.currentPrimeSearch = currentPrimeSearch;
    }

    public BigInteger getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(BigInteger currentNumber) {
        this.currentNumber = currentNumber;
    }

    public boolean isCurrentPrime() {
        return isCurrentPrime;
    }

    public void setCurrentPrime(boolean isCurrentPrime) {
        this.isCurrentPrime = isCurrentPrime;
    }

    public long getLocalCounter() {
        return localCounter;
    }

    public void setLocalCounter(long localCounter) {
        this.localCounter = localCounter;
    }

    public long getGlobalCounter() {
        return globalCounter;
    }

    public void setGlobalCounter(long globalCounter) {
        this.globalCounter = globalCounter;
    }

    public long getGenerations() {
        return generations;
    }

    public void setGenerations(long generations) {
        this.generations = generations;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public long getFinalEndTime() {
        return finalEndTime;
    }

    public void setFinalEndTime(long finalEndTime) {
        this.finalEndTime = finalEndTime;
    }

    public void incrementLocalCounter() {
        localCounter++;
    }

    public void incrementGlobalCounter() {
        globalCounter++;
    }

    public void incrementPrimeSearch() {
        currentPrimeSearch++;
    }

}
