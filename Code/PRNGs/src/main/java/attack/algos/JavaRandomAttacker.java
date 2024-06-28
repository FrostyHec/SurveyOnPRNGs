package attack.algos;

import prngtest.interfaces.InitSeedConstrain;

import java.math.BigInteger;

public class JavaRandomAttacker {
    private static final long a = 0x5DEECE66DL;
    private static final long c = 0xBL;
    private static final int LEN = 48;
    private static final long m = 1L << LEN;
    private long D;
    private long seed;

    private JavaRandomAttacker(long s0, long s1, int bitWidth) {
        D = 1L << LEN - bitWidth;
        long r = (a * s0 - s1) % m;
        BigInteger bi = BigInteger.valueOf(r < 0 ? m + r : r);
        bi = bi.multiply(BigInteger.valueOf(D % m)).add(BigInteger.valueOf(c)).mod(BigInteger.valueOf(m));
        long dif = bi.longValue();
        long u1 = guessPair(dif, D);
        seed = s1 * D + u1;
    }

    private static long guessPair(long dif, long max) {
        long r = -1;
        for (int i = 0; i < max; i++) {
            long res = (dif + a * i) % m;
            if (res < max) {
                if (res != -1) {
                    int o = 2;
                }
                return res;
            }
        }
        return r;
        //throw new RuntimeException("err!");
    }

    public static JavaRandomAttacker rangeInt(int s0, int s1) {
        return new JavaRandomAttacker(Integer.toUnsignedLong(s0),
                Integer.toUnsignedLong(s1), 32);
    }

    private long next(int bits) {
        seed = (seed * a + c) & (m - 1);
        return seed >>> (48 - bits);
    }

    public int nextInt() {
        return (int) next(32);
    }

    public boolean nextBoolean() {
        return next(1) != 0;
    }
}
