import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
         //   System.out.println(getPrintCnt(n, true) + " "+ getPrintCnt(n, false));
            int[] answer = getPrintCnt(n);
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }

        br.close();
        System.out.println(sb);
    }

    static int[] getPrintCnt(int n) {
        
        if (n == 0) return new int[]{1,0};
        int[] beforeNumbers = {0,1};
        for (int i = 2; i <= n; i++) {
            int newNumber = beforeNumbers[0] + beforeNumbers[1];
            beforeNumbers[0] = beforeNumbers[1];
            beforeNumbers[1] = newNumber;
        }
        return beforeNumbers;
    }
}