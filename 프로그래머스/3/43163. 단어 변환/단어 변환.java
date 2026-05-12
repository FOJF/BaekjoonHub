import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Map<String, Integer> visited = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        
        q.add(begin);
        visited.put(begin, 0);
        
        while(!q.isEmpty()) {
            String cur = q.poll();
            
            for(String word : words) {
                if(visited.containsKey(word) || !isPossible(cur, word)) continue;
                
                if(target.equals(word)) return visited.get(cur)+1;
                
                q.add(word);
                visited.put(word, visited.get(cur)+1);
            }
        }
        
        return 0;
    }
    
    private boolean isPossible(String cur, String next) {
        int diff = 0;
        
        for(int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) != next.charAt(i)) diff++;
            
            if (diff > 1) return false;
        }
        
        return true;
    }
}