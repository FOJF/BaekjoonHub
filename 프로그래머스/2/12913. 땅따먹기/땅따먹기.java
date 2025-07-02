import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int[] dp = Arrays.copyOf(land[0], land[0].length);
        
        int[] nDP = new int[dp.length];
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                int max = 0;
                for (int k = 0; k < dp.length; k++) {
                    if (j == k) continue;
                    max = Math.max(max, dp[k]);
                }
                nDP[j] = land[i][j] + max;
            }
            int[] tmp = dp;
            dp = nDP;
            nDP = tmp;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}