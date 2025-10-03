import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        // dp[i][j]: 길이가 i이고 마지막 자리가 j인 계단 수의 개수
        long[][] dp = new long[N + 1][10];

        // 길이가 1인 계단 수 초기화
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        // 길이가 2부터 N까지 계산
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % MOD;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;
        // 길이가 N인 모든 계단 수의 개수를 합산
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        System.out.println(result);
    }
}
