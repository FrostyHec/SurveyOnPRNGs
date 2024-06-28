package prngtest.algos;

import com.google.common.primitives.UnsignedLong;
import prngtest.interfaces.LongGenerator;


public class WeylSeqMiddleSquare extends LongGenerator {
    private UnsignedLong seed;
    private final UnsignedLong weylConst;
    private UnsignedLong w;

    public WeylSeqMiddleSquare(long seed) {
        this(seed, 0, 33827);
    }

    public WeylSeqMiddleSquare(long seed, long w, long weylConst) {
        super(-1);//unused
        this.seed = UnsignedLong.fromLongBits(seed);
        this.w = UnsignedLong.fromLongBits(w);
        this.weylConst = UnsignedLong.fromLongBits(weylConst);
    }

    @Override
    public long nextLong() {
        seed = seed.times(seed);
        w = w.plus(weylConst);
        seed = seed.plus(w);
        long xBits = seed.longValue();
        long high = (xBits >>> 32);
        long low = (xBits << 32);
        seed=UnsignedLong.fromLongBits(high | low);
        return high;
    }
}
