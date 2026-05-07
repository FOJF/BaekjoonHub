import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> clothMap = new HashMap<>();
        
        for(String[] cloth : clothes) {
            clothMap.computeIfAbsent(cloth[1], k -> new HashSet<>()).add(cloth[0]);
        }
        
        int answer = 1;
        
        for(String k : clothMap.keySet()) {
            answer *= clothMap.get(k).size()+1;
        }
        
        return answer-1;
    }
}