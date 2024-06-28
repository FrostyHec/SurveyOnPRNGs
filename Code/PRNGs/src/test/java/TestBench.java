import org.junit.Test;
import prngtest.algos.*;
import prngtest.exceptions.InvalidSeedException;
import prngtest.exceptions.UnsupportedException;
import prngtest.interfaces.Generator;
import prngtest.interfaces.LongGenerator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class TestBench {
    private long TEST_BIT_LEN = 1000000 * 10;
    // MS
//    private long seed = 1234869890732L;
//    private Generator generator = new MiddleSquare(seed, 13);
    //MSWS
//    private long seed = 0;
//    private Generator generator = new WeylSeqMiddleSquare(seed, 0, 0xb5ad4eceda1ce2a9L);
    //LCG
//    private long seed =25214903917L;
//    private Generator generator = new LCG(seed, 1L << 48, 0x5DEECE66DL, 0xBL);

    //PMLCG
//    private long seed = 10;
//    private Generator generator = new PMLCG(seed, (1L << 31) - 1, 16807);
//PCG
//    private long seed=10;
//    private Generator generator=new PCG(seed);
    //LFG
//    private long seed=10;
//    private Generator generator = new LFG(seed, 1, 3, 1L<<32, Long::sum);
    //MLFG
//    private long seed = 10;
//    private Generator generator = new LFG(seed, 1, 3, 1L << 32, (a, b) -> a * b, x -> x % 2 == 1);
//LFSR
//    private long seed = 10;
//    private Generator generator = new LFSR32(10);
    //MT
//    private long seed = 10;
//    private Generator generator = new MT19937_32(seed);
//BBS
//    private Generator generator=new BBS();
    //SecureRandom
    private Generator generator=new System_SecureRandom();

    public TestBench() throws InvalidSeedException {
    }

    @Test
    public void RND() {
        Random rnd = new Random(0);
//        for (int i = 0; i < 100; i++) {
//            System.out.println(rnd.nextInt());
//        }
        int times = 100;
        while (times-- > 0) {
            System.out.print((rnd.nextBoolean() ? 1 : 0) + " ");
            if (times % 10 == 0) System.out.println();
        }
    }

    @Test
    public void longTestBench() throws UnsupportedException {
        int times = 100;
        while (times > 0) {
            System.out.println("times:" + times-- + "\t val:" + generator.nextLong());
        }
    }

    @Test
    public void bitTestBench() {
        int times = 100;
        while (times-- > 0) {
            System.out.print((generator.nextBit() ? 1 : 0) + " ");
            if (times % 10 == 0) System.out.println();
        }
    }

    @Test
    public void output() throws IOException {
        long t1, t2;
        try (FileWriter writer = new FileWriter("test.txt")) {
            t1 = System.currentTimeMillis();
            for (long i = 0; i < TEST_BIT_LEN; i++) {
                writer.write(generator.nextBit() ? '1' : '0');
            }
            t2 = System.currentTimeMillis();
        }
        System.out.println("total millis usage:" + (t2 - t1) + "ms");
    }

    @Test
    public void outputTxtAndImage() throws IOException {
        long t1, t2;
        int width = (int) Math.ceil(Math.sqrt(TEST_BIT_LEN));
        BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
        try (FileWriter writer = new FileWriter("test.txt")) {
            t1 = System.currentTimeMillis();
            for (long i = 0; i < TEST_BIT_LEN; i++) {
                boolean bit = generator.nextBit();
                writer.write(bit ? '1' : '0');
                image.setRGB(
                        (int) (i % width),
                        (int) (i / width),
                        (bit ? Color.BLACK : Color.WHITE).getRGB()
                );
            }
            t2 = System.currentTimeMillis();
        }
        ImageIO.write(image, "png", new File("output.png"));
        System.out.println("total millis usage:" + (t2 - t1) + "ms");
    }
}