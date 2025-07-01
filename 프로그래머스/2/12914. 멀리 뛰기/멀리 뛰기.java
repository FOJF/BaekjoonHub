class Solution {
    public long solution(int n) {
        long[] dp = new long[n+2];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i-2]%1234567+dp[i-1]%1234567)%1234567;
        }
        
        return dp[n-1];
    }
}
// 11111
// 2111
// 1211
// 1121
// 1112
// 221
// 212
// 122
