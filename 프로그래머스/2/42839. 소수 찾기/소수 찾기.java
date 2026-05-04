import java.util.*;

class Solution {
    private static int answer = 0;

    private static Set<Integer> isChecked = new HashSet<>();
    private static List<Integer> idxs = new ArrayList<>();
    private static boolean[] hasIdx;
    
    public int solution(String numbers) {
        hasIdx = new boolean[numbers.length()];
        
        dfs(numbers);
        
        return answer;
    }
    
    private void dfs(String numbers) {
        int n = 0;
        for(int i = 0; i < idxs.size(); i++) {
            n *= 10;
            n += numbers.charAt(idxs.get(i))-'0';
        }
        
        if (!isChecked.contains(n)) {
            isChecked.add(n);
            answer += isPrime(n);
            
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if (hasIdx[i]) continue;
            
            idxs.add(i);
            hasIdx[i] = true;
            dfs(numbers);
            idxs.remove(idxs.size()-1);
            hasIdx[i] = false;
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