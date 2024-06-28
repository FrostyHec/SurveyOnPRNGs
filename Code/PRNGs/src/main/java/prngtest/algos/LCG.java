package prngtest.algos;

import prngtest.interfaces.LongGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LCG extends LongGenerator {
    private long mod, a, c;

    public LCG(long seed) {
        this(seed, 1L << 48, 0x5DEECE66DL, 0xBL);
    }

    public LCG(long seed, long mod, long a, long c) {
        super(seed);
        this.mod = mod;
        this.a = a;
        this.c = c;
    }

    private long next(int bits) {
        seed = (seed * a + c) & (mod - 1);
        return seed >>> (48 - bits);
    }

    @Override
    public long nextLong() {
        return (int)next(32);
    }

    @Override
    public boolean nextBit() {
        return next(1) != 0;
    }
}
