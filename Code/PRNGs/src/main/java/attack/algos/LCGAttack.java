package attack.algos;

public class LCGAttack {
    private LCGAttack() {
    }
    public static long attack(long a, long c, long m, long s0) {
        return (a * s0 + c) % m;
    }

}
