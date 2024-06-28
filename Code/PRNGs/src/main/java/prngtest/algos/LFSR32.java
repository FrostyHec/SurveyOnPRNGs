package prngtest.algos;

import prngtest.interfaces.LongGenerator;

public class LFSR32 extends LongGenerator {
    public LFSR32(long seed) {
        super(seed);
    }

    @Override
    public long nextLong() {
        long bit = ((seed >>> 0) ^ (seed >>> 1) ^ (seed >>> 2) ^ (seed >>> 22) ^ (seed >>> 32)) & 1L;
        seed = (seed >>> 1) | (bit << 31);
        return seed;
    }
}
