package game;

import java.util.Random;

/**
 * A random number generator
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class RandomNumberGenerator {
    /**
     * A random int generator
     * @param bound The upper bound
     * @return An int which is from 0 to bound(exclusive)
     */
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    /**
     * A random int generator within a lower and upper bound
     * @param lowerBound An int which is the lower bound
     * @param upperBound An int which is the upper bound
     * @return An int which is from lower bound to upper bound(exclusive)
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
