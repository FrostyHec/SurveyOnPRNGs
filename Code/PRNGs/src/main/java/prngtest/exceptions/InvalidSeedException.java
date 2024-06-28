package prngtest.exceptions;

public class InvalidSeedException extends Exception {
    public InvalidSeedException(long seed, String cause) {
        super("Invalid Seed! seed:" + seed + " reason:" + cause);
    }

    public InvalidSeedException(long seed) {
        super("Invalid Seed! seed:" + seed);
    }
    public InvalidSeedException(String cause){
        super(cause);
    }
}
