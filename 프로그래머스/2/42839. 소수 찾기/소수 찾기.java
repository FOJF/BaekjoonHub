import java.util.*;

class Solution {
    private static int answer = 0;

    private static Set<Integer> isChecked = new HashSet<>();
    private static boolean[] hasIdx;
    private int n = 0;
    
    public int solution(String numbers) {
        hasIdx = new boolean[numbers.length()];
        
        dfs(numbers);
        
        return answer;
    }
    
    private void dfs(String numbers) {
        
        if (!isChecked.contains(n)) {
            isChecked.add(n);
            answer += isPrime(n);
            
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if (hasIdx[i]) continue;
            
            hasIdx[i] = true;
            n *= 10;
            n += numbers.charAt(i)-'0';
            
            dfs(numbers);
            
            hasIdx[i] = false;
            n /= 10;
        }
    }
    
    private int isPrime(int num) {
        if (num < 2) return 0;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i == 0) return 0;
        }
        
        return 1;
    }
}