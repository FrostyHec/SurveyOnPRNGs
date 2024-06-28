package prngtest.algos;

import com.google.common.primitives.UnsignedLong;
import prngtest.interfaces.LongGenerator;

public class PCG extends LongGenerator {
    private UnsignedLong state = UnsignedLong.fromLongBits(0x4d595df4d0f33173L);
    private static final UnsignedLong multiplier = UnsignedLong.fromLongBits(6364136223846793005L);
    private static final UnsignedLong increment = UnsignedLong.fromLongBits(1442695040888963407L);
    private UnsignedLong seed;

    public PCG(long seed) {
        super(-1);//Unused
        this.seed = UnsignedLong.fromLongBits(seed);
        init();
    }

    private int rotate(int x, int r) {
        return x >>> r | x << (-r & 31);
    }

    public void init() {
        state = seed.plus(increment);
        nextLong();
    }

    @Override
    public long nextLong() {
        UnsignedLong x = state;
        int count = (int) (x.longValue() >>> 59);
        state = x.times(multiplier).plus(increment);
        long x2 = x.longValue();
        x2 ^= x2 >>> 18;
        x = UnsignedLong.fromLongBits(x2);
        int res = rotate((int) (x.longValue() >>> 27), count);
        return Integer.toUnsignedLong(res);
    }
}
