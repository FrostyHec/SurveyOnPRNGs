package prngtest.algos;

import prngtest.exceptions.InvalidSeedException;
import prngtest.interfaces.LongGenerator;
import prngtest.tools.ToBitHelper;

public class MiddleSquare extends LongGenerator {
    private int LENGTH;
    private long FACTOR;
    private long TAIL;

    private void initialize(int length) {
        LENGTH = length;
        FACTOR = (long) Math.pow(10, LENGTH);
        TAIL = (long) Math.pow(10, LENGTH / 2);
    }

    public MiddleSquare(long seed) throws InvalidSeedException {
        this(seed, 4);
    }

    public MiddleSquare(long seed, int length) throws InvalidSeedException {
        super(seed);
        initialize(length);
        if (seed / FACTOR != 0)
            throw new InvalidSeedException(seed, "Not matching the length");
    }

    @Override
    public long nextLong() {
        long next = seed * seed / TAIL;
        long res = 0;
        long term = 1;
        for (int i = 0; i < LENGTH; i++) {
            int v = (int) (next % 10);
            res += term * v;
            term *= 10;
            next /= 10;
        }
        seed = res;
        return res;
    }
}
