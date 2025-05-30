import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        BigInteger bi = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }

        String nFac = bi.toString();
        int answer = 0;
        for (int i = nFac.length()-1; i >= 0; i--) { // 뒤에서부터 0인지 체크
            if (nFac.charAt(i) != '0') break;

            answer++;
        }

        System.out.println(answer);
    }
}