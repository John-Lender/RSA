import java.math.BigInteger;

public class RSA {
    private static final int N_BIT = 1024;
    private static final BigInteger ONE = new BigInteger(String.valueOf("1"));
    private static final BigInteger ZERO = new BigInteger(String.valueOf("0"));
    private BigInteger p;
    private BigInteger q;
    public BigInteger n;
    private BigInteger eilerFun;
    public BigInteger e;
    public BigInteger d;
    private long time;



    public RSA() {
        time = System.currentTimeMillis();
        this.p = GeneratorEaseNumber.generateNbitEV(N_BIT);
        getTime(time);
        this.q = GeneratorEaseNumber.generateNbitEV(N_BIT);
        getTime(time);
        n = p.multiply(q);
        getTime(time);
        eilerFun = (p.subtract(ONE)).multiply(q.subtract(BigInteger.ONE));
        getTime(time);
        e = GeneratorEaseNumber.generateNbitEV(N_BIT/2);
        getTime(time);
        d = ExtendEvclid.extEvclid(e,eilerFun)[1].mod(eilerFun);
        getTime(time);
    }
    public RSA(BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.e = e;
        n = p.multiply(q);
        eilerFun = (p.subtract(ONE)).multiply(q.subtract(BigInteger.ONE));
        d = new BigInteger(String.valueOf("6111579"));
    }

    public static BigInteger[] encrypt(String text, BigInteger e, BigInteger n){
        BigInteger[] encript_text = new BigInteger[text.length()];
        int i = 0;
        for (char c: text.toCharArray()) {
            encript_text[i] = (new BigInteger(String.valueOf((int)c)).modPow(e,n));
            i+=1;
        }
        return encript_text;
    }
    public static String decrypt(BigInteger[] text, BigInteger d, BigInteger n){
        String decryptText = new String("");
        for (int i = 0; i < text.length; i++) {
            decryptText += ((char)text[i].modPow(d,n).intValue());
        }
        return decryptText;
    }
    @Override
    public String toString() {
        return
                "p=" + p + "\n"+
                "q=" + q +"\n"+
                "n=" + n +"\n"+
                "eilerFun=" + eilerFun +"\n"+
                "e=" + e +"\n"+
                "d=" + d +
                '}';
    }
    private static void getTime(long time){
        System.out.println((System.currentTimeMillis() - time)/1000);
    }
}
