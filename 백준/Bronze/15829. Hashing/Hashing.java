import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final BigInteger R = new BigInteger("31");
        final BigInteger M = new BigInteger("1234567891");

        Scanner sc = new Scanner(System.in);

        int length = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        sc.close();

        BigInteger hash = new BigInteger("0");

        for (int i = 0; i < length; i++) {
            BigInteger a = R.pow(i).multiply(BigInteger.valueOf(str.charAt(i) - 'a' + 1));
            hash = hash.add(a);
        }

        hash = hash.remainder(M);

        System.out.println(hash);

    }
}