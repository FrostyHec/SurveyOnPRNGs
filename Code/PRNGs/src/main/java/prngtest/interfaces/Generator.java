package prngtest.interfaces;

import prngtest.exceptions.UnsupportedException;

public abstract class Generator {
    protected long seed;
    protected Generator(long seed){
        this.seed=seed;
    }
    public long nextLong() throws UnsupportedException{
        throw new UnsupportedException();
    }
    public abstract boolean nextBit();
}
