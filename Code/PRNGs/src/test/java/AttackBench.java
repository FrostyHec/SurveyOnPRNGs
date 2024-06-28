import attack.algos.JavaRandomAttacker;
import attack.algos.LCGAttack;
import org.junit.Test;
import prngtest.algos.ShortLCG;

import java.util.Random;

public class AttackBench {
    @Test
    public void fullRandTest() {
        int TEST_TIMES = 100000;
        int PREDICT_LEN = 100;
        for (int i = 0; i < TEST_TIMES; i++) {
            Random random = new Random();
            int s0 = random.nextInt(), s1 = random.nextInt();
            JavaRandomAttacker attacker = JavaRandomAttacker.rangeInt(s0, s1);
            for (int j = 0; j < PREDICT_LEN; j++) {
                int a = attacker.nextInt();
                int b = random.nextInt();
                assert a==b;
            }
        }
        System.out.println("testPass!");
    }

    @Test
    public void javaRand() {
        Random random = new Random(10);
        int s0 = random.nextInt();
        int s1 = random.nextInt();
        JavaRandomAttacker attacker = JavaRandomAttacker.rangeInt(s0, s1);
        for (int i = 0; i < 10; i++) {
            int assume_s2 = attacker.nextInt();
            int real_s2 = random.nextInt();
            System.out.println("assume: " + assume_s2 + "\t real:" + real_s2);
        }
    }

    @Test
    public void learn() {
        ShortLCG lcg = new ShortLCG(1, 4, 2, 10, 1);
        System.out.println(lcg.nextLong());
        System.out.println(lcg.nextLong());
        System.out.println(lcg.nextLong());
    }
}
