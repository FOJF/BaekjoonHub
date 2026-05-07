class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] s = new int[n+2];
        
        for(int i = 1; i <= n; i++) {
            s[i] = 1;
        }
        
        for(int r : reserve) {
            s[r]++;
        }
        
        for(int l : lost) {
            s[l]--;
        }
        
        for(int i = 1; i < s.length-1; i++) {
            if (s[i] > 0) continue;
            
            if (s[i-1] > 1) {
                s[i-1]--;
                s[i]++;
            } else if (s[i+1] > 1) {
                s[i+1]--;
                s[i]++;
            }
        }
        
        int answer = 0;
        for (int a : s) {
            if (a > 0) answer++;
        }
        
        return answer;
    }
}