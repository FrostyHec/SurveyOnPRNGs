package prngtest.algos;

import prngtest.interfaces.LongGenerator;

public class MT19937_32 extends LongGenerator {
    // 常数
    private static final int N = 624;
    private static final int M = 397;
    private static final int R = 31;
    private static final long A = 0x9908B0DFL;
    private static final int F = 1812433253;
    private static final int U = 11;
    private static final long D = 0xFFFFFFFFL;
    private static final int S = 7;
    private static final long B = 0x9D2C5680L;
    private static final int T = 15;
    private static final long C = 0xEFC60000L;
    private static final int L = 18;
    private static final long MASK_LOWER = (1L << R) - 1;
    private static final long MASK_UPPER = (1L << R);

    private final long[] mt = new long[N];
    private int index;
    public MT19937_32(long seed) {
        super(-1);//unused
        mt[0] = seed;
        initialize();
        index = N;
    }
    private void initialize(){
        for (int i = 1; i < N; i++) {
            mt[i] = (F * (mt[i - 1] ^ (mt[i - 1] >> 30)) + i) & D;
        }
    }
    private void twist() {
        for (int i = 0; i < N; i++) {
            long x = (mt[i] & MASK_UPPER) + (mt[(i + 1) % N] & MASK_LOWER);
            long xA = (x >> 1) & D;
            if ((x & 1) != 0) {
                xA ^= A;
            }
            mt[i] = mt[(i + M) % N] ^ xA;
        }
        index = 0;
    }
    @Override
    public long nextLong() {
        if (index >= N) {
            twist();
        }
        long y = mt[index];
        y ^= (y >> U);
        y ^= (y << S) & B;
        y ^= (y << T) & C;
        y ^= (y >> L);
        index++;
        return y & D;
    }
}
