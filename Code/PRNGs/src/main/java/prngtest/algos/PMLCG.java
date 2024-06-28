package prngtest.algos;

import prngtest.interfaces.LongGenerator;
import prngtest.tools.ToBitHelper;

public class PMLCG extends LongGenerator {
    private long mod, a;

    public PMLCG(long seed, long mod, long a) {
        super(seed);
        this.mod = mod;
        this.a = a;
    }

    @Override
    public long nextLong() {
        return seed = (int) ((seed * a) % mod);
    }

//    @Override
//    public boolean nextBit() {
//        if (bitStr.isEmpty()) bitStr.refresh(nextLong());
//        return ToBitHelper.byBitSeq(bitStr);
//    }
}
