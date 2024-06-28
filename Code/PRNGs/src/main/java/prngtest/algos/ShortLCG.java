package prngtest.algos;

import prngtest.interfaces.LongGenerator;

public class ShortLCG extends LongGenerator {
    private long mod, a, c;
    private int offset,back;

    public ShortLCG(long seed, int offset,int back, long a, long c) {
        super(seed);
        this.mod = 1L << offset;
        this.a = a;
        this.c = c;
        this.offset = offset;
        this.back=back;
    }

    private long next(int bits) {
        seed = (seed * a + c) & (mod - 1);
        return seed >>> (offset - bits);
    }

    @Override
    public long nextLong() {
        return (int) next(back);
    }

    @Override
    public boolean nextBit() {
        return next(1) != 0;
    }
}
