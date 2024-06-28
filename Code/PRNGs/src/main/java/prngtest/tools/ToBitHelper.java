package prngtest.tools;

public class ToBitHelper {
    public static boolean byParity(long num) {
        return num % 2 == 1;
    }

    public static boolean byBitSeq(BitStrContainer num) {
        if(num.isEmpty()) throw new RuntimeException("container is empty!");
        var str = num.binaryString;
        int len = str.length();
        boolean res = str.charAt(len - 1) == '1';
        str.delete(len - 1, len);
        return res;
    }
}
