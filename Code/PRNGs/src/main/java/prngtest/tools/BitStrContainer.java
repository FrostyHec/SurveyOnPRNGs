package prngtest.tools;

public class BitStrContainer {
    public StringBuilder binaryString = new StringBuilder();

    public boolean isEmpty() {
        return binaryString.isEmpty();
    }

    public void refresh(long num) {
        binaryString.append(Long.toBinaryString(num));
    }
}
