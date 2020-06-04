import java.math.BigInteger;

public class ExtendEvclid {
    //private static final BigInteger ZERO  = new BigInteger(String.valueOf("0"));
    public static BigInteger x = BigInteger.ZERO;
    public static BigInteger y = BigInteger.ZERO;
    public static BigInteger x1 = BigInteger.ZERO;
    public static BigInteger y1 = BigInteger.ZERO;

    public static BigInteger[] extEvclid(BigInteger a, BigInteger b){
        if (b.equals(BigInteger.ZERO)){
            return new BigInteger[] {a, BigInteger.ONE, BigInteger.ZERO};
        }
        BigInteger[] array = extEvclid(b, a.mod(b));
        //System.out.println(array[0] + " " + array[1] + " " + array[2]);
        return new BigInteger[] {array[0], array[2], array[1].subtract((array[2]).multiply(a.divide(b)))};
    }
}
