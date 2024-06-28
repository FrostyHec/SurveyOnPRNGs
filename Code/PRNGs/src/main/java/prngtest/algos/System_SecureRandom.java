package prngtest.algos;

import prngtest.interfaces.LongGenerator;

import java.security.SecureRandom;

public class System_SecureRandom extends LongGenerator {
    SecureRandom secureRandom=new SecureRandom();
    public System_SecureRandom() {
        super(-1);//unused
    }
    @Override
    public long nextLong() {
        return secureRandom.nextLong();
    }

    @Override
    public boolean nextBit() {
        return secureRandom.nextBoolean();
    }
}
