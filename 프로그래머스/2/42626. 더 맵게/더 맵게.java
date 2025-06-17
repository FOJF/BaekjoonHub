import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        int tryCnt = 0;
        
        if(pq.peek() >= K) return 0;
        
        while(pq.size() >= 2) {
            tryCnt++;
            
            pq.offer(pq.poll() + 2 * pq.poll());
            
            if (pq.peek() >= K) break;
        }
        
        return pq.peek() >= K ? tryCnt : -1;
    }
}