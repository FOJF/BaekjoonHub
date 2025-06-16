import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();
        
        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1],1)+1);
        }
        
        for (int value : hm.values()) {
            answer *= value;
        }
        
        return answer-1;
    }
}