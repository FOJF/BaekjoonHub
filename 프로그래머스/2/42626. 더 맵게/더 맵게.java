import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        int answer = 0;
        
        Arrays.stream(scoville).forEach(i -> pq.add(i));
        
        while(!pq.isEmpty()) {
            if (pq.peek() >= K) {
                return answer++;
            }
            if (pq.size() == 1) break;
            
            pq.add(pq.poll() + pq.poll()*2);
            answer++;
        }
        
        return -1;
    }
}