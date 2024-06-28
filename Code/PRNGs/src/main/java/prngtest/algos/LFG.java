package prngtest.algos;

import prngtest.exceptions.InvalidSeedException;
import prngtest.interfaces.BinaryOperator;
import prngtest.interfaces.InitSeedConstrain;
import prngtest.interfaces.LongGenerator;
import prngtest.tools.ToBitHelper;

public class LFG extends LongGenerator {

    private final long[] seeds;
    private final int j, k;
    private final int LEN, LAG_1, LAG_2;
    private int pointer;
    private final BinaryOperator operator;
    private final long mod;

    public LFG(long seed, int j, int k, long mod, BinaryOperator operator) {
        this(seed, j, k, mod, operator, a -> true);
    }

    public LFG(long seed, int j, int k, long mod, BinaryOperator operator, InitSeedConstrain initSeedConstrain) {
        super(-1);//unused
        this.j = j;
        this.k = k;
        this.mod = mod;
        this.operator = operator;

        LEN = k;
        LAG_1 = LEN - j;
        LAG_2 = 0;
        pointer = LEN - 1;

        this.seeds = getSeedByLCG(seed, initSeedConstrain);
    }

    private long[] getSeedByLCG(long seed, InitSeedConstrain constrain) {
        long[] arr = new long[LEN];
        LCG lcg = new LCG(seed);
        for (int i = 0; i < LEN; i++) {
            long cur;
            do {
                cur = lcg.nextLong();
            } while (!constrain.isValid(cur));
            arr[i] = cur;
        }
        return arr;
    }

    public LFG(long[] seeds, int j, int k, long mod, BinaryOperator operator) throws InvalidSeedException {
        super(-1);//unused
        if (seeds.length != k) throw new InvalidSeedException("seed arr len invalid!");
        this.seeds = seeds;
        this.j = j;
        this.k = k;
        this.mod = mod;
        this.operator = operator;
        this.
                LEN = k;
        LAG_1 = LEN - j;
        LAG_2 = 0;
        pointer = LEN - 1;
    }

    @Override
    public long nextLong() {
        pointer = (pointer + 1) % LEN;
        int l = (LAG_1 + pointer) % LEN;
        int r = (LAG_2 + pointer) % LEN;
        return seeds[pointer] =
                operator.operate(seeds[l], seeds[r]) % mod;
    }

//    @Override
//    public boolean nextBit() {
//        if (bitStr.isEmpty()) bitStr.refresh(nextLong());
//        return ToBitHelper.byBitSeq(bitStr);
//    }
}
