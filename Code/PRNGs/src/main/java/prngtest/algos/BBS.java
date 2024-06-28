package prngtest.algos;

import com.google.common.primitives.UnsignedLong;
import prngtest.interfaces.Generator;

import java.math.BigInteger;
import java.util.Random;

public class BBS extends Generator {
    private BigInteger p, q, n, seed;
    private static final int bitLength = 64;
    private static final int certainty = 100;
    private static final BigInteger FOUR = BigInteger.valueOf(4), THREE = BigInteger.valueOf(3);

    public BBS() {
        super(-1);//unused
        p = bigPrime();
        q = bigPrime();
        n = p.multiply(q);
        seed = bigPrime();
    }

    public BigInteger genCoprime(BigInteger val) {
        Random rnd = new Random();
        BigInteger res;
        do {
            res = BigInteger.valueOf(rnd.nextLong());
        } while (res.gcd(val).equals(BigInteger.ONE));
        return res;
    }

    public BigInteger bigPrime() {
        Random rnd = new Random();
        BigInteger res;
        do {
            res = BigInteger.probablePrime(bitLength, rnd);
        } while (res.mod(FOUR).equals(THREE) && res.isProbablePrime(certainty));
        return res;
    }

    @Override
    public boolean nextBit() {
        seed = seed.pow(2).mod(n);
        return seed.testBit(0);
    }
}
