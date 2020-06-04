import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        RSA test = new RSA();
        System.out.println(test);
        BigInteger[] text = RSA.encrypt("Hello world", test.e, test.n);
        for (BigInteger item: text) {
            System.out.print(item + "\n");
        }
        System.out.println();
        String text1 = RSA.decrypt(text, test.d, test.n);
        System.out.println("decrypt msg: " + text1);
    }
}
