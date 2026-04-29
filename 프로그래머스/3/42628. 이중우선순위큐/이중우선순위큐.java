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
                
                int k = 0;
                if (s[1].charAt(0) == '1') {
                    k = m.lastKey();
                    m.put(k, m.get(k)-1);
                    
                    if (m.lastEntry().getValue() == 0) m.pollLastEntry();
                } else {
                    k = m.firstKey();
                    m.put(k, m.get(k)-1);
                    
                    if (m.firstEntry().getValue() == 0) m.pollFirstEntry();
                }
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