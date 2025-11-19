import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> older = new HashSet<>();
        Map<Integer, Integer> younger = new HashMap<>();
        
        int answer = 0;
        for (int t : topping) {
            younger.put(t, younger.getOrDefault(t, 0)+1);
        }
        
        for (int t : topping) {
            older.add(t);
            younger.put(t, younger.get(t) - 1);
            
            if (younger.get(t) == 0) younger.remove(t);
            
            if (younger.size() == older.size()) answer++;
        }
        
        return answer;
    }
}