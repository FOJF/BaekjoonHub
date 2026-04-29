import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        
        for(String op : operations) {
            String[] s = op.split(" ");
            
            if (s[0].charAt(0) == 'I') {
                int k = Integer.parseInt(s[1]);
                m.put(k, m.getOrDefault(k, 0)+1);
            } else {
                if (m.isEmpty()) continue;
                
                Map.Entry<Integer, Integer> e = s[1].charAt(0) == '1' ? m.pollLastEntry() : m.pollFirstEntry();
                
                if (e.getValue() > 1) m.put(e.getKey(), e.getValue()-1);
            }
        }
        
        int[] answer = { 0,0 };
        
        if (!m.isEmpty()) {
            answer[0] = m.lastKey();
            answer[1] = m.firstKey();
        }
        
        return answer;
    }
}