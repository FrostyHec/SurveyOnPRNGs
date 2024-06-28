package prngtest.interfaces;

import prngtest.tools.BitStrContainer;
import prngtest.tools.ToBitHelper;

public abstract class LongGenerator extends Generator {
    protected BitStrContainer bitStr = new BitStrContainer();

    protected LongGenerator(long seed) {
        super(seed);
    }

    @Override
    public abstract long nextLong();

    @Override
    public boolean nextBit() {
        return ToBitHelper.byParity(nextLong());

    }

    //@Override
    //public boolean nextBit() {
    //        if(bitStr.isEmpty()) bitStr.refresh(nextLong());
    //        return ToBitHelper.byBitSeq(bitStr);
    //        }
}
