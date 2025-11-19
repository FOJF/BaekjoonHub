import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> older = new HashMap<>();
        Map<Integer, Integer> younger = new HashMap<>();
        
        int answer = 0;
        for (int t : topping) {
            younger.put(t, younger.getOrDefault(t, 0)+1);
        }
        
        for (int t : topping) {
            older.put(t, older.getOrDefault(t, 0)+1);
            younger.put(t, younger.get(t) - 1);
            
            if (younger.get(t) == 0) younger.remove(t);
            
            if (younger.size() == older.size()) answer++;
        }
        
        return answer;
    }
}