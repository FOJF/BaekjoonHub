import java.util.*;

class Solution {
    public int solution(int N, int target) {
        if (N == target) {
            return 1;
        }
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        int num = 0;
        for (int i = 1; i <= 8; i++) {
            num = num * 10 + N;
            dp.get(i).add(num);
        }
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for(int k : dp.get(j)) {
                    for(int l : dp.get(i-j)) {
                        dp.get(i).add(k + l);
                        dp.get(i).add(k - l);
                        dp.get(i).add(k * l);
                        
                        
                        if (l != 0) dp.get(i).add(k / l);
                    }
                }
            }
            
            if (dp.get(i).contains(target)) return i;
        }
        
        return -1;
    }
}